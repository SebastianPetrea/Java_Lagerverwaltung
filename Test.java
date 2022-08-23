import java.util.Arrays;

import javax.swing.*;

public class Test {
	
	//Eingabe einer neuen Kiste
	static void eingabe(int[][]argEingabe) {
		//Variabeln anlegen
		int kistenNummer,breite,läenge,höhe;
		// Do while schleife erstellen 
		do {
			//Eingabe der Kistennummer
			kistenNummer = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie bitte eine Kistennummer ein zwischen 1 -75 ein."));
			
			if (kistenNummer > 0 && kistenNummer<=argEingabe.length)
				if (argEingabe[kistenNummer-1][0]==0) {
					
					argEingabe[kistenNummer-1][0] =kistenNummer;
					
					breite = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die breite ein:"));
					argEingabe[kistenNummer-1][1] = breite;
					läenge = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die laenge ein:"));
					argEingabe[kistenNummer-1][2] = läenge;
					höhe = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die hoehe ein:"));
					argEingabe[kistenNummer-1][3] = höhe;
				}
				else {
					System.out.println("\nDie Kistennummer ist schon vorhanden.");
				}
		}
		while(kistenNummer <=0 || kistenNummer>argEingabe.length);
		
	}
	
	//Daten einer vorhandenen Kiste anzeigen
	static void  anzeigen(int [][] argAnzeigen) {
		int suche;
		suche =Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kistennummer ein."));
		for(int element=0; element<argAnzeigen.length; element++){
            if(suche > 0 && suche <= argAnzeigen.length && argAnzeigen[element][0] == suche){
            	System.out.println("Die Daten der Kiste sind "+Arrays.toString(argAnzeigen[element]));
            	return;
            	}
        }
		if (suche != argAnzeigen.length) {
    		System.out.println("Die Kistenummer ist nich vorhanden.");
        }
		
	}
	
	//Zeigt alle vorhandenen Daten aller Kisten aufgelistet
	static void liste(int [][] argListe) {
		int counter = 0;
		for (int index =0; index < argListe.length; index++) {
			for (int j = 0; j < argListe[index].length; j++)
				if (argListe[index][j] != 0) {
					System.out.print(argListe[index][j] + " ");
					counter++;
					if (counter >= 4) {
						System.out.print("\n");
						counter = 0;
					}
				}
		}
		}
	
	
	static void löschen(int [][] argLöschen) {
		 int kistenNummer;

	     kistenNummer = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kistennummer ein die geloscht werden soll."));
	        
	     if (kistenNummer > 0 && kistenNummer <= argLöschen.length) {
	    	 if (argLöschen[kistenNummer -1][0] != 0) {
	    		//Die Werte der Kiste auf 0 setzen
					argLöschen[kistenNummer -1][0] = 0;
					
					
					argLöschen[kistenNummer -1][1] = 0;
					
					
					argLöschen[kistenNummer -1][2] = 0;
					
					
					argLöschen[kistenNummer -1][3] = 0;
	    	 }else {
	    		 System.out.println("Die Kistenummer ist nicht vorhanden.");
	    	 }
	     }
	     }
	
	static void ändern(int [][] argAendern) {
		int kistenNummer,breite,länge,höhe;
		
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
					System.out.println("Die Kistennummer ist nicht vorhanden.");
				}
			}
	}
	
	public static void main(String[] args) {
		//Array anlegen
		int[][] kisten = new int [75][4];
		//Variabeln anlegen
		String funktionEinlesen,input;
		char funktionen;
		
		
		
		//Auswahlmenu 
		do {
			funktionEinlesen = JOptionPane.showInputDialog("W�hlen Sie eine Funktion aus:\n A) Neue Kiste eingeben.\n B) L�schen der Daten einer vorhandenen Kiste.\n C) �ndern der Daten einer vorhandenen Kiste.\n D) Anzeigen der Daten einer vorhandenen Kiste.\n E) Aller vorhande Kisten anzeigen.");
			funktionen = funktionEinlesen.charAt(0);
			
			switch(funktionen) {
			case 'a':
			case 'A':
				eingabe(kisten);
				break;
			case 'b':
			case 'B':
				löschen (kisten);
				break;
			case 'c':
			case 'C':
				ändern(kisten);
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
