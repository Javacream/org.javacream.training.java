# Ein Java Projekt

## Projektstruktur

| Datei | Aufgabe |
|---|---|
| `pom.xml` | Beschreibt das Projekt und die benötigten Bibliotheken |
| `src/main/java/org/javacream/training/java/Application.java` | Startet die Anwendung |
| `src/main/resources/application.properties` | Konfiguration der Anwendung, hier wird der Server-Port auf 8080 gesetzt |
| `src/main/java/org/javacream/training/java/PingController.java` | Liefert eine Antwort auf einen HTTP-Netzwerkrequest |

## Die pom.xml

Die `pom.xml` enthält den Projektnamen, die Version und die benötigten **Dependencies**.

Dependencies sind Bibliotheken, deren Funktionen die Anwendung verwendet. Sie werden im Bereich `<dependencies>` der `pom.xml` eingetragen.

## Die application.properties

Die Datei `application.properties` enthält die Anwendungskonfiguration, hier den Server-Port:

```properties
server.port=8080
```

Damit ist die Anwendung über Port **8080** erreichbar.

## Die Anwendung

Die eigentliche Anwendung ist die Abbildung des Kommandos **`/ping`** auf die Programmlogik **`return "Pong";`**. Dazu ist leider viel sogenannter **Boilerplate-Code** nötig (`package`, `import`, `@Annotations`, …), den wir mit dem aktuellen Wissensstand erst einmal akzeptieren müssen.

```java
package org.javacream.training.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }
}
```

## Die Anwendung starten

`Application.java` startet die Anwendung. Dies kann in einer Entwicklungsumgebung mit wenigen Klicks durchgeführt werden, beispielsweise über **Run** im Kontextmenü der Klasse.

## Die Swagger UI bedienen

Die Swagger UI bietet eine Oberfläche, mit der die Anwendung direkt im Browser ausprobiert werden kann:

1. Anwendung starten.
2. **`http://localhost:8080/swagger-ui.html`** öffnen.
3. Den Eintrag **`GET /ping`** aufklappen.
4. **Try it out** anklicken.
5. **Execute** anklicken.

Unter **Response body** erscheint `Pong`, unter **Code** der HTTP-Status `200` für einen erfolgreichen Aufruf.
