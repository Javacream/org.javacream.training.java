package org.javacream.training.java;

public class ObjectMethods {

	public static void main(String[] args) {
		new ObjectMethods();
	}
	
	public ObjectMethods() {
		Address munich = new Address("München", "Marienplatz");
		Address berlin = new Address("Berlin", "Alexanderplatz");
		Address munich2 = new Address("München", "Marienplatz");
		
		
		AddressProvider sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		AddressProvider sawitzki2 = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		AddressProvider mustermann = new Person("Mustermann", "Hans", 80.5, 183, berlin);
		
		//== Vergleich der Referenzen
//		Boolean sawitzkiIsMustermann = sawitzki == mustermann;
//		System.out.println(sawitzkiIsMustermann);
//
//		Boolean munichIsBerlin = munich== berlin;
//		System.out.println( munichIsBerlin);
//
//		Boolean sawitzkiIsSawitzki2= sawitzki == sawitzki2;
//		System.out.println(sawitzkiIsSawitzki2);
//
//		Boolean munichIsMunich2= munich== munich2;
//		System.out.println( munichIsMunich2);
	
		//equals Vergleich über Obhjekt-Identität
		Boolean sawitzkiIsMustermann = sawitzki.equals(mustermann);
		System.out.println(sawitzkiIsMustermann);

		Boolean munichIsBerlin = munich.equals(berlin);
		System.out.println( munichIsBerlin);

		Boolean sawitzkiIsSawitzki2= sawitzki.equals(sawitzki2);
		System.out.println(sawitzkiIsSawitzki2);

		Boolean munichIsMunich2= munich.equals(munich2);
		System.out.println( munichIsMunich2);

	
	
	}

}
