# Agenda “Java Grundausbildung”

Dr. Rainer Sawitzki, 8.06.2026

**Teilnehmer:** EntwicklerInnen mit Programmierkenntnissen aus der Host-Welt

**Vorkenntnisse:** IT-Grundkenntnisse, Grundlagen der Programmierung, Arbeiten mit Git / Gitlab

**Methode:** Vortrag, Präsentation, Diskussion, eigene Übungen

**Dauer:** 20 Unterrichtseinheiten mit jeweils 90 Minuten, verteilt auf 2 + 3 Tage

**Seminarzeiten:** 9:00 - 16:15 mit zwei Kaffeepausen (15 min) und einer Mittagspause von 12:15 - 13:00

**Ort:** Eschborn oder Düsseldorf in den Räumen der dwpbank  (Abhängig vom Wohnort der meisten Teilnehmenden)

**Sprache:** Deutsch

**Termin:** Erste Durchführung im September 2026, genauer Termin muss noch abgesprochen werden

**Unterlagen:** PDF-Handout, Git-Repository mit Beispielen und Musterlösungen inklusive Commit-Historie, digitales Flipchart

**Hinweise:** Die Trainingsumgebung wird von Cegos über eine Remote-Umgebung bereitgestellt. Der Zugriff hierauf muss im Vorfeld getestet werden

**Teilnehmerrechner:** Freier Internet-Zugriff:

GitHub.com/Javacream https://docs.google.com/document/d/1yjfrg30aAuIB_M9Z5E5uGPflWq3ovgQ41K4AB0hE6gY/edit?tab=t.0

Konfiguriertes Maven mit Zugriff entweder auf das öffentliche Maven-Repository oder einen internen Nexus/Artifactory

**Ziel:** Das Ziel des Seminars ist es, den Teilnehmenden einen fundierten Einblick in die Programmierung mit der Sprache Java zu geben. Hierzu werden im Rahmen einer 5tägigen Schulung zwei RESTful WebServices mit Datenhaltung in einer relationalen Datenbank als Spring Boot-Applikationen entwickelt.

**Hinweise:** Die REST-Services sind vollständig funktionsfähig und nach der vom Kunden verwendeten Ziel-Architektur als hexagonale Microservices realisiert. Ebenso werden die internen Code Guidelines vermittelt.

Das Seminar legt besonderen Wert darauf, die Vorgehensweise der objektorientierten Anwendungsentwicklung mit Java / Spring Boot zu vermitteln. Es ist mit dem Kunden abgesprochen, die Teilnehmenden darauf hinzuweisen, dass damit keinesfalls "alle" Details der Java-Programmierung Bestandteil dieses Seminars sein können. Es ist vorgesehen, eine Reihe von vertiefenden anschließenden Kursen (etwa 1 - 2 Tage pro Thema) anzubieten, die entweder als klassisches Seminar oder als Lernpfad zum Selbststudium oder als Kombination angeboten werden. Eine Auswahl potenzieller Themen hierfür wären z.B.  "Collections und funktionale Programmierung", "Datenzugriffe mit JPA und Spring Transaction Management", Verwendung von Kafka, Metriken mit Prometheus

## Inhalte

### Java Grundlagen

#### Einführung

- Cobol vs Java (fundamentale Unterschiede)
- Installation und Überblick der Versionen
- Compiler und Java Virtual Machine
- Einrichten einer Entwicklungsumgebung mit Editor, Code Assist und Debugger
- Nutzung KI-basierter Assistenten (kann man kurz anreißen und auf die Initiativen innerhalb der dwpbank verweisen, die aktuell startet)

#### Grundlagen

- Variablen
- Operatoren
- Kontrollstrukturen - Schleifen, Abfragen, Fehlerbehandlung

#### Objektorientierung in Java Teil 1: Objekte

- Zugriff auf Attribute und Methoden
- Datentypen
- Speichermodell der Java Virtual Machine und Garbage Collection

#### Objektorientierung in Java Teil 2: Klassen

- Das Grundgerüst einer Klassendefinition
- Instanziierung und new-Operator
- Methoden als Funktionen mit Parametern und Rückgabewert
- Referenzen
- Klassen und das Java-Typsystem

#### Datencontainer

- Collection-Typen List, Set und Map
- Einfache Datenverarbeitung mit Collections

### Objektorientierte Programmierung

#### Einführung

- Modellierung und Klassendiagramm
- Relationen und Vererbung
- Kapselung

#### Umsetzung in Java

- class vs interface vs record
- Umsetzung des Klassendiagramms, extends und implements
- Kapselung: public, private, protected

### Spring Boot

#### Softwareentwicklung

- Exception Handling und Logging
- Module und Dependency Management
- Source Code Management am Beispiel Git
- Build-Prozess am Beispiel Apache Maven

#### Spring Boot

- Aufsetzen des Projekts
- Projektstruktur
- Wer macht was: pom.xml SpringBootApplication, application.yml

#### Testing

- Lokales Starten und Testen der Anwendung
- Unit-Tests vs Integration Tests vs System-Test
- jUnit
- Testtreiber, Dummies und Mocks

#### Verteilte Anwendungen

- RESTful WebServices
- Datenbankzugriff mit dem EntityManager, O/R-Mapping und native Queries

### Vom Programm zur Anwendung

#### Was ist eine CI/CD-Pipeline und wie hilft sie mir?

- Kurze Einführung für was wir das nutzen und wie wir Abbrüche der Pipeline analysieren.

#### Einführung in die Welt der Container, Beispiel Docker

#### Container und Kubernetes / die Cloud
