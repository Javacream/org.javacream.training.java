# COBOL und Java – Die hauptsächlichen Unterschiede

**Handout zum Einstieg von COBOL in Java / Spring Boot / Microservices**

## Lernziel und Einordnung

Dieses Handout richtet sich an Entwicklerinnen und Entwickler mit COBOL-Erfahrung. Es zeigt, welche vertrauten Konzepte in Java wiederkehren und wo ein Umdenken erforderlich ist. Im Mittelpunkt stehen Sprache, Datenmodell und Laufzeit – Frameworks und Microservices folgen darauf aufbauend.

Die Gegenüberstellung bezieht sich auf klassische, prozedurale COBOL-Anwendungen. COBOL unterstützt je nach Standard und Implementierung auch objektorientierte Konzepte. Ebenso ist Java weder auf Webanwendungen beschränkt noch automatisch eine Microservice-Technologie.

## 1. Überblick

| Aspekt | Klassisches COBOL | Java |
| --- | --- | --- |
| Grundstruktur | Programme, Divisions, Sections und Paragraphs | Klassen, Interfaces, Methoden und Packages |
| Programmiermodell | Überwiegend prozedural; Datenbereiche und Verarbeitung getrennt | Überwiegend objektorientiert; Zustand und Verhalten können zusammengekapselt werden |
| Syntax | Sprachähnliche Anweisungen, etwa `MOVE` und `ADD` | Ausdrücke, Operatoren, geschweifte Klammern und Semikolons |
| Datendefinition | `PICTURE`, Stufennummern und `USAGE` beschreiben Felder und Darstellung | Primitive Typen und Referenztypen beschreiben Werte und Objekte |
| Dezimalrechnung | Dezimalstellen und Feldbreite häufig direkt in der Definition | Für genaue Dezimalrechnung typischerweise `BigDecimal` |
| Datenstrukturen | Gruppenfelder, Tabellen mit `OCCURS`, Copybooks | Klassen, Records, Arrays und Collections |
| Unterprogramme | `CALL`, häufig mit Parametern aus der `LINKAGE SECTION` | Methodenaufrufe mit typisierten Parametern und Rückgabewerten |
| Fehlerbehandlung | Beispielsweise Statusfelder, `FILE STATUS` und anweisungsbezogene Fehlerbehandlung | Exceptions sowie bei Bedarf fachliche Ergebnis- und Statusobjekte |
| Ausführung | Häufig plattformbezogene Übersetzung und COBOL-Laufzeit | Typischerweise Bytecode, ausgeführt durch eine JVM |
| Typische Integration | Beispielsweise Dateien, SQL, Transaktionsmonitore und Jobsteuerung | Beispielsweise Dateien, JDBC, HTTP, Messaging und Frameworks |

## 2. Programmstruktur und Verantwortlichkeiten

Ein COBOL-Programm gliedert sich typischerweise in `IDENTIFICATION DIVISION`, `ENVIRONMENT DIVISION`, `DATA DIVISION` und `PROCEDURE DIVISION`. Daten stehen oft in einem gemeinsamen Bereich; mehrere Paragraphs greifen darauf zu.

In Java werden zusammengehörige Aufgaben auf Klassen und Methoden verteilt. Eine Klasse kann Daten und die zugehörigen Operationen enthalten. Zugriffe lassen sich durch Sichtbarkeiten wie `private` und `public` begrenzen.

```cobol
       IDENTIFICATION DIVISION.
       PROGRAM-ID. BEGRUESSUNG.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 WS-NAME PIC X(20) VALUE "Anna".
       PROCEDURE DIVISION.
           DISPLAY "Hallo " FUNCTION TRIM(WS-NAME)
           STOP RUN.
```

```java
public class Begruessung {
    public static void main(String[] args) {
        String name = "Anna";
        System.out.println("Hallo " + name);
    }
}
```

**Bedeutung für den Umstieg:** Ein COBOL-Programm muss nicht genau einer Java-Klasse entsprechen. Die Aufteilung sollte fachlichen Verantwortlichkeiten folgen. Ein Paragraph ist ebenfalls nicht automatisch ein eigenständiges Objekt.

## 3. Datentypen und Datendarstellung

### Feldbeschreibung gegenüber Werttyp

In COBOL beschreibt eine Datendefinition häufig zugleich den fachlichen Wert und dessen technische Darstellung:

```cobol
       01 WS-ANZAHL PIC 9(4) COMP.
       01 WS-PREIS  PIC 9(5)V99 COMP-3.
       01 WS-NAME   PIC X(30).
```

In Java sind Werttyp und externe Darstellung stärker getrennt:

```java
int anzahl = 25;
BigDecimal preis = new BigDecimal("123.45");
String name = "Anna";
```

Für `BigDecimal` ist der Import `java.math.BigDecimal` erforderlich. Die folgenden Java-Beispiele sind Ausschnitte, sofern keine vollständige Klasse gezeigt wird.

| COBOL-Konzept | Java-Entsprechung bzw. Unterschied |
| --- | --- |
| `PIC X(n)` | Häufig `String`; dessen Länge ist nicht automatisch auf `n` beschränkt |
| `PIC 9(n)` | Je nach Wertebereich etwa `int`, `long` oder `BigInteger`; die Stellenzahl wird nicht durch den Typ festgelegt |
| `PIC … V99` | Häufig `BigDecimal`; zwei Nachkommastellen müssen ausdrücklich vereinbart werden |
| Gruppenfeld | Häufig Klasse oder Record; keine automatische Entsprechung des Speicherlayouts |
| Bedingungsname auf Stufe 88 | Je nach Zweck `boolean`, `enum` oder eine prüfende Methode |
| `REDEFINES` | Kein direktes Gegenstück zur Überlagerung desselben Speicherbereichs |
| `OCCURS` | Array oder Collection, je nach benötigtem Verhalten |

Ein numerisch aussehender Wert ist nicht zwingend eine Zahl: Kundennummern und Postleitzahlen können in Java als `String` sinnvoller sein, insbesondere wenn führende Nullen erhalten bleiben müssen.

### Genaue Dezimalrechnung

`float` und `double` verwenden binäre Gleitkommadarstellung. Viele Dezimalbrüche lassen sich damit nicht exakt darstellen. Für Geldbeträge ist deshalb häufig `BigDecimal` geeignet.

```java
BigDecimal preis = new BigDecimal("19.90");
BigDecimal menge = BigDecimal.valueOf(3);
BigDecimal gesamt = preis.multiply(menge); // 59.70
```

Die Erzeugung aus einem String vermeidet die Übernahme einer bereits ungenauen `double`-Darstellung. Rundung und Nachkommastellen müssen bewusst festgelegt werden; bei Divisionen kann eine Rundungsvorgabe erforderlich sein. Auch Überlauf- und Abschneideverhalten sind nicht automatisch mit den COBOL-Feldregeln identisch.

**Merksatz:** Ein Java-Typ ersetzt keine fachliche Felddefinition. Länge, Wertebereich, Pflichtangaben und Dezimalstellen brauchen eigene Regeln.

## 4. Variablen, Objekte und Speicher

Java unterscheidet primitive Werte und Objektreferenzen:

- Primitive Typen wie `int`, `long` und `boolean` enthalten unmittelbar einen Wert.
- Variablen von Referenztypen wie `String` oder einer eigenen Klasse enthalten eine Referenz auf ein Objekt.
- `null` bedeutet, dass keine Objektreferenz vorhanden ist. Es ist weder ein leerer String noch die Zahl null.

```java
Kunde erster = new Kunde();
Kunde zweiter = erster;
```

Beide Variablen verweisen auf dasselbe Objekt. Änderungen an diesem Objekt sind über beide Referenzen sichtbar. Eine Zuweisung erzeugt keine unabhängige Kopie wie die Übertragung eines Datensatzinhalts.

Java übergibt Parameter immer **by value**. Bei Objekten wird der Wert der Referenz kopiert: Die Methode kann das referenzierte Objekt verändern, aber durch eine neue Zuweisung an ihren Parameter nicht die Variable des Aufrufers ersetzen.

Die JVM gibt Speicher nicht mehr erreichbarer Objekte durch Garbage Collection frei. Dateien, Netzwerkverbindungen und ähnliche Ressourcen müssen dennoch gezielt geschlossen werden, beispielsweise mit `try-with-resources`.

Java-Instanzfelder erhalten Standardwerte wie `0`, `false` oder `null`. Lokale Variablen müssen vor ihrer Verwendung zugewiesen werden. Ein nicht initialisierter String ist deshalb nicht automatisch mit Leerzeichen gefüllt.

## 5. Kontrollfluss und Methoden

Verzweigungen und Schleifen erfüllen in beiden Sprachen ähnliche Aufgaben. Die Schreibweise unterscheidet sich:

```cobol
           IF WS-ANZAHL > 0
               DISPLAY "Positionen vorhanden"
           ELSE
               DISPLAY "Keine Positionen"
           END-IF

           PERFORM VARYING WS-I FROM 1 BY 1 UNTIL WS-I > 3
               DISPLAY WS-I
           END-PERFORM
```

```java
if (anzahl > 0) {
    System.out.println("Positionen vorhanden");
} else {
    System.out.println("Keine Positionen");
}

for (int i = 1; i <= 3; i++) {
    System.out.println(i);
}
```

Java unterscheidet Groß- und Kleinschreibung: `kunde` und `Kunde` sind unterschiedliche Bezeichner. Ein Punkt beendet keinen Satz wie in COBOL; er wird unter anderem für den Zugriff auf Methoden oder Felder verwendet.

Methoden deklarieren Parameter und einen Rückgabetyp. `void` bedeutet, dass kein Wert zurückgegeben wird.

```java
static BigDecimal berechneGesamt(BigDecimal preis, int menge) {
    return preis.multiply(BigDecimal.valueOf(menge));
}
```

**Bedeutung für den Umstieg:** Explizite Parameter und Rückgabewerte machen Datenabhängigkeiten sichtbar. Eine Methode sollte möglichst nicht zahlreiche gemeinsame Variablen als versteckte Eingaben und Ausgaben verwenden.

## 6. Tabellen, Strings und Vergleiche

COBOL-Tabellen werden typischerweise über `OCCURS` definiert. In Java stehen unter anderem Arrays mit fester Länge sowie Collections mit unterschiedlichen Eigenschaften zur Verfügung.

```java
String[] namen = {"Anna", "Ben", "Clara"};
System.out.println(namen[0]); // Anna
```

Java-Arrayindizes beginnen bei **0**, COBOL-Tabellensubscripts typischerweise bei **1**. Ein Zugriff außerhalb der Java-Arraygrenzen löst eine Exception aus.

Ein Java-`String` ist unveränderlich. Operationen wie `trim()` liefern einen String als Ergebnis; sie ändern die ursprüngliche Variable nicht automatisch.

```java
String name = "Anna   ";
name = name.trim();
```

Bei Vergleichen ist zwischen Identität und Inhalt zu unterscheiden:

```java
boolean gleicherInhalt = "AKTIV".equals(status);
```

`==` vergleicht bei Objektreferenzen die Identität, bei primitiven Typen den Wert. Für Stringinhalte wird normalerweise `equals()` verwendet. Bei `BigDecimal` berücksichtigt `equals()` auch die Skala: `2.0` und `2.00` sind damit nicht gleich. Für numerische Gleichheit eignet sich `compareTo(...) == 0`.

## 7. Fehlerbehandlung

In COBOL werden technische und fachliche Fehler häufig über Statusfelder oder anweisungsbezogene Konstrukte behandelt, etwa `FILE STATUS`, `AT END` oder `ON SIZE ERROR`.

Java verwendet für viele technische Fehler Exceptions:

```java
try {
    int anzahl = Integer.parseInt(eingabe);
    System.out.println(anzahl);
} catch (NumberFormatException ex) {
    System.out.println("Die Eingabe ist keine gültige Ganzzahl.");
}
```

Eine Exception unterbricht den normalen Ablauf und kann bis zu einem passenden `catch` weitergereicht werden. Geprüfte Exceptions müssen gefangen oder mit `throws` deklariert werden; ungeprüfte Exceptions unterliegen dieser Compilerpflicht nicht.

Fachliche Ergebnisse wie „Kunde nicht gefunden“ brauchen eine bewusste Modellierung. Je nach Schnittstelle können beispielsweise ein Ergebnisobjekt oder `Optional` passen. Nicht jedes erwartete Ergebnis sollte pauschal als technischer Fehler behandelt werden.

## 8. Dateien, Datenbanken und Schnittstellen

In COBOL gehören Datei- und Satzbeschreibungen unmittelbar zur Sprache. Java stellt hierfür APIs und Bibliotheken bereit. Ein Java-Objekt ist jedoch nicht automatisch ein lesbarer COBOL-Datensatz.

Bei der Übernahme bestehender Daten müssen insbesondere folgende Eigenschaften vereinbart werden:

- Feldlängen, Füllzeichen und Satzgrenzen;
- Zeichencodierung, beispielsweise EBCDIC oder UTF-8;
- Darstellung von Binärzahlen und gepackten Dezimalzahlen;
- Datum, Dezimaltrennzeichen und Rundungsregeln.

SQL bleibt fachlich vertraut. Der Zugriff erfolgt in Java beispielsweise über JDBC; Frameworks können darauf aufbauen. Transaktionen bleiben erforderlich: Ein Sprachwechsel beseitigt keine Anforderungen an Commit, Rollback oder Konsistenz.

## 9. Übersetzung und Laufzeit

COBOL wird häufig in plattformbezogenen ausführbaren Code übersetzt. Die genaue Ausführung hängt von Compiler, Laufzeit und Betriebsumgebung ab.

Java-Quellcode wird typischerweise zu Bytecode in `.class`-Dateien übersetzt und oft als JAR ausgeliefert. Eine Java Virtual Machine (JVM) führt diesen Code aus und kann ihn zur Laufzeit durch Just-in-Time-Kompilierung optimieren.

Die JVM unterstützt Portabilität. Passende Java-Versionen, native Bibliotheken, Dateipfade und Umgebungsabhängigkeiten müssen dennoch berücksichtigt werden. Werkzeuge wie Maven oder Gradle organisieren Build und Abhängigkeiten; sie sind keine Sprachbestandteile.
