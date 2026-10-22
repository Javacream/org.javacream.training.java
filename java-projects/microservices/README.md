# Books- und Store-Microservices

Zwei voneinander unabhängige Maven-Projekte (Java 21, Spring Boot 3.4.4) mit je einer H2-In-Memory-Datenbank. Die Kommunikation läuft asynchron über Kafka.

## Start

1. `docker compose up -d` (Kafka auf localhost:9092)
2. `cd books-service && mvn spring-boot:run` (separates Terminal, Port 8081)
3. `cd store-service && mvn spring-boot:run` (separates Terminal, Port 8082)

## Demonstration

Buch anlegen:

```bash
curl -X POST http://localhost:8081/books -H 'Content-Type: application/json' -d '{"isbn":"979-9-1234-5678-5","title":"Kafka mit Spring","pages":180,"price":19.99,"available":false}'
```

Lagerbestand auf 5 setzen:

```bash
curl -X PUT http://localhost:8082/store/books/979-9-1234-5678-5/stock/5
```

Nach Kafka-Verarbeitung ist `available=true`:

```bash
curl http://localhost:8081/books/979-9-1234-5678-5
```

Lagerbestand auf 0 setzen und erneut lesen:

```bash
curl -X PUT http://localhost:8082/store/books/979-9-1234-5678-5/stock/0
```

Weitere APIs: GET `/books`, DELETE `/books/{isbn}`, PUT `/books/{isbn}/availability/{available}`; GET `/store`, GET `/store/{category}/{itemId}`.

## Technische Hinweise

- Die beiden Services haben getrennte H2-In-Memory-Datenbanken; beim Stoppen gehen die Daten verloren.
- Die Kafka-Nachricht enthält `category`, `itemId`, `stock` als JSON. Der Store publiziert nach `repository.save()`; Books ignoriert andere Kategorien und unbekannte ISBNs.
- Dies ist ein bewusst einfaches Lehrbeispiel. Für produktiven Einsatz fehlen insbesondere Outbox/Transaktionskopplung, Event-Versionierung, Fehlerbehandlung, Idempotenz und die Behandlung verspäteter bzw. vertauschter Nachrichten.
- Kafka-Nachrichten werden asynchron verarbeitet; die Aktualisierung ist nicht unmittelbar beim HTTP-Response garantiert.
