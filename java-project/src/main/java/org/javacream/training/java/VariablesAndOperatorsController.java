package org.javacream.training.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VariablesAndOperatorsController {

	@GetMapping("/operations")
	public String operations() {
		// var (fast) frei wählbarer Name = Literal: Zeichenkette "Hugo", Ganzzahl 42,
		// -4711, Kommazahl 4.2, -47.11;
		var name = "Hugo";
		var height = 183;
		var weight = 76.6;
		name = "Eduard";
		//var name = "Fritz";//falsch, name war bereits deklariert
		//name = 42; Fehler, Java ist statisch typisiert
		//Exkurs: Altes Java, statt var wird ein Datentyp hingeschrieben: String, Integer, Double
		String oldName = "Rainer";
		//völlig unüblich: Typisierung im Namen kennzeichen, der Typ wird im Editor immer angezeigt
		String sName = "Fritz";
		System.out.println(name);
		return "OK";
	}
}
