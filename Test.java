import java.util.Arrays;

import javax.swing.*;

public class Test {
	
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
		 int kistenNummer,breite,länge,höhe;

	     kistenNummer = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kistennummer ein die geloscht werden soll."));
	        
	     if (kistenNummer <= argLoeschen.length) {
				
	    	 	
				argLoeschen[kistenNummer -1][0] = 0;
				
				
				argLoeschen[kistenNummer -1][1] = 0;
				
				
				argLoeschen[kistenNummer -1][2] = 0;
				
				
				argLoeschen[kistenNummer -1][3] = 0;
			}
	     if (kistenNummer != argLoeschen.length) {
	    	 System.out.print("Die Kistenummer ist nicht vorhanden./n");
	     }
	     }
	static void Aendern(int [][] argAendern) {
		int kistenNummer, breite,länge,höhe;
		
		kistenNummer = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kistennumer ein die Geändert werden soll:"));
		
		if (kistenNummer > 0 && kistenNummer <= argAendern.length) {
			if (argAendern[kistenNummer -1][0] != 0) {
				breite = Integer.parseInt(JOptionPane.showInputDialog("Breite"));
				argAendern[kistenNummer -1][1] = breite;
				
				länge = Integer.parseInt(JOptionPane.showInputDialog("Länge"));
				argAendern[kistenNummer -1][2] = länge;
				
				höhe = Integer.parseInt(JOptionPane.showInputDialog("Höhe"));
				argAendern[kistenNummer -1][3] = höhe;
				}else {
					System.out.print("Die Kistennummer ist nicht vorhanden./n");
				}
			}
			
		
	}
	

	public static void main(String[] args) {
		//Array anlegen
		int[][] kisten = new int [75][4];
		int[][] keine = new int [0][0];
		//Variabeln anlegen
		String funktioneinlesen;
		String input;
		char funktionen;
		
		
		
		//Auswahlmenu 
		do {
			funktioneinlesen = JOptionPane.showInputDialog("W�hlen Sie eine Funktion aus:\n A) Neue Kiste eingeben.\n B) L�schen der Daten einer vorhandenen Kiste.\n C) �ndern der Daten einer vorhandenen Kiste.\n D) Anzeigen der Daten einer vorhandenen Kiste.\n E) Aller vorhande Kisten anzeigen.");
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
			case 'c':
			case 'C':
				Aendern(kisten);
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
