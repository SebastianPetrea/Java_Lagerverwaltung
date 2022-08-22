import java.util.Arrays;

import javax.swing.*;

public class EInsendeaufgabe_4 {
	
	//Eingabe einer neuen Kiste
	static void eingabe(int[][]argEingabe) {
		//Variabeln anlegen
		int nummer,breite,laenge,hoehe;
		do {
			nummer = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie bitte eine Kistennummer ein zwischen 1 -75 ein."));
			
			if (nummer > 0 && nummer<=argEingabe.length)
				if (argEingabe[nummer-1][0]==0) {
					
					argEingabe[nummer-1][0] =nummer;
					
					breite = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die breite ein:"));
					argEingabe[nummer-1][1] = breite;
					laenge = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die laenge ein:"));
					argEingabe[nummer-1][2] = laenge;
					hoehe = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die hoehe ein:"));
					argEingabe[nummer-1][3] = hoehe;
				}
				else {
					System.out.println("\nDie Kistennummer ist schon vergeben");
				}
		}
		while(nummer <=0 || nummer>argEingabe.length);
		
	}
	//Zeigt daten einer vorhandenen Kiste
	static void  anzeigen(int [][] argAnzeigen) {
		int suche;
		suche =Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kistennummer ein."));
		for(int element=0; element<argAnzeigen.length; element++){
            if(suche > 0 && suche <= argAnzeigen.length && argAnzeigen[element][0] == suche){
            	System.out.print("\nDie Daten der Kiste sind "+Arrays.toString(argAnzeigen[element]));
            	return;
            	}
        }
		if (suche != argAnzeigen.length) {
    		System.out.print("Die Kiste ist nich vorhanden.");
        }
		
	}
	//Liste zeigt alle vorhandenen Daten aller Kisten
	static void liste(int [][] argListe) {
		int counter = 0;
		for (int i =0; i < argListe.length; i++) {
			for (int j = 0; j < argListe[i].length; j++)
				if (argListe[i][j] != 0) {
					System.out.print(argListe[i][j] + " ");
					counter++;
					if (counter >= 4) {
						System.out.print("\n");
						counter = 0;
					}
				}	
		}
	}
	
	static void loeschen(int [][] argLoeschen) {
		int kisten_Nummer;
		int[][] keine = new int [0][0];
		kisten_Nummer = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kistennummer ein die geloscht werden soll."));
		
		for (int index = 0; index < argLoeschen.length; index++) {
			if (argLoeschen[index][kisten_Nummer] == kisten_Nummer) {
					argLoeschen[kisten_Nummer][index] = keine;
					
				}
		}
		//if (kisten_Nummer != argLoeschen.length)
			//System.out.print(kisten_Nummer +"ist nicht vorhanden");
	}

	public static void main(String[] args) {
		//Array anlegen
		int[][] kisten = new int [75][4];
		//Variabeln anlegen
		String funktioneinlesen;
		String input;
		char funktionen;
		
		
		
		//Auswahlmenu 
		do {
			funktioneinlesen = JOptionPane.showInputDialog("Wählen Sie eine Funktion aus:\n A) Neue Kiste eingeben.\n B) Löschen der Daten einer vorhandenen Kiste.\n C) Ändern der Daten einer vorhandenen Kiste.\n D) Anzeigen der Daten einer vorhandenen Kiste.\n E) Aller vorhande Kisten anzeigen.");
			funktionen = funktioneinlesen.charAt(0);
			
			switch(funktionen) {
			case 'a':
			case 'A':
				eingabe(kisten);
				break;
			case 'b':
			case 'B':
				loeschen (kisten);
				break;
			case 'd':
			case 'D':
				anzeigen(kisten);
				break;
			case 'e':
			case 'E':
				liste(kisten);
				break;
					
			}
			input = JOptionPane.showInputDialog("Weitere Angaben(Ja/Nein)?").toLowerCase();
		}while(input.contains("ja"));

		System.exit(0);

	}

}
