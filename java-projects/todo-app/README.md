# ToDo-Anwendung

Java 21, Spring Boot 4.1.1, Spring Data JPA, H2 und Swagger UI.

## Start

`mvn spring-boot:run`

- Swagger UI: http://localhost:9090/swagger-ui.html
- H2-Console: http://localhost:9090/h2-console
- JDBC URL: `jdbc:h2:mem:tododb;DB_CLOSE_DELAY=-1`, User: `sa`, Passwort leer

## REST-API

- `POST /todos` – anlegen (Request-Parameter `description`, `priority`, `finished`)
- `PUT /todos/{id}` – aktualisieren (gleiche Request-Parameter)
- `GET /todos` – alle anzeigen
- `GET /todos/{id}` – eines anzeigen

Beispiel:

```bash
curl -X POST "http://localhost:9090/todos?description=Dokumentation%20schreiben&priority=5&finished=false"
```

`priority` muss zwischen 0 und 10 liegen. Fehlerbehandlung ist absichtlich minimal gehalten.

## Docker-Image über Buildpacks

Docker Daemon muss erreichbar sein. Anschließend:

```bash
mvn spring-boot:build-image

docker run --rm -p 9090:9090 javacream-todo:1.0
```

Die H2-Datenbank ist in-memory; Daten gehen beim Neustart verloren.
