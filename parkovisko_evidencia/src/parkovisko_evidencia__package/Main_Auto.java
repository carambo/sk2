package parkovisko_evidencia__package;

public class Main_Auto {

	public static void main( String[] args ) {
		
		Sedan sedan1 = new Sedan( false, "macky", 30, "BMW 5", "biela", 1.7, false ); // tych 1.7 metra som si vymyslel :)
		System.out.println(sedan1);
		
		Kupe kupe1 = new Kupe(true, "macky", 60, "Audi TT", "cierna", 180.2, true);
		System.out.println(kupe1);
		
		
		TypAuta auto1 = new TypAuta( false, "macky", 40, "Jaguar XJ", "seda");
		System.out.println(auto1);
		
		TypAuta auto2 = new TypAuta( false, "macky", 50, "Marcedes CLA", "cervena" );
		System.out.println(auto2);
		
	}
}


/*
Co este dorobit

1. aby mi to pekne vypisovalo ci auto zraca macky alebo nie, myslel som ze to spravim pomocu String macky ktora sa da sa " nezraza macky" alebo " zraza macky" podla toho ci je boolean zrazaMacky true alebo false
2. aby mi aj pri vypisovani udajov o kupe pisalo typ auta a jeho farbu a ostatne veci z Class TypAuta
3. nechat uzivatela aby si zadal hodnoty, teda farbu auta, jeho typ a podobne. Mohol by som ksusit taku srandu, ze nech uzivatel napise ci to auto co prislo je kupe alebo sedan. ked vie tak napise a potom ho to 
   este poziada aby napisal specifikaciu toho auta, teda pri kupe vykon a este cosi a pri sedane napr. dlzku. ked vsak nebude vediet to auto zaradit, nech napise jeho typ, napr. Audi A5 a program ho uz zaradi, 
   v tomto pripade medzi sedany. samozrejme nie vsetky, zadefinovanych budem mat napr len 6 aut a vzdu teda musi akoby prist jedno z nich. 







*/