package Feld;
import java.util.Scanner;

public class Main {
	public static Spieler[] Spieler = new Spieler[2];
	public static char[] spielFeld = new char[9]; // Spielfeld

	public static void main(String[] args) {  
		int Draw=0;																															
		spielerAuswahl(2);																													
		System.out.println("Dann wünsche ich euch viel spaß beim spielen "+Spieler[0].Name+" und "+Spieler[1].Name+". Los gehts!");
		printFeld();												// zeige das spielFeld
		
		do {
			for(int durchgang=1;durchgang<=9;durchgang++) {						// Schleife bis gewinn//durchgang==9
				aktiverSpieler().Zug(durchgang);										//eingabe + überprüfen
				printFeld();															// Zeige Feld
				if (Spielmechanik.gewinn()) 											// Gewinn ? + break
					break;
				spielerwechsel();														//nester Spieler
			}
			if (Spielmechanik.gewinn()) {
				System.out.println(aktiverSpieler().Name+" hat gewonnen!");		//Zeige Gewinner
				aktiverSpieler().Sieg();																									
				printZeichen(aktiverSpieler());					//Zeige Fett Zeichen des Spielers											
				spielerwechsel();								// bei erneutem spielen beginnt der Verlierer
			}
			else{
				System.out.println("Unentschieden"+"\n"+"Leider hat keiner gewonnen"+"\n");					//Draw
				Draw++;}
			System.out.println("Spielstand:	x	o	Unentschieden"+"\n"+"		"+Spieler[0].Siege+"	"+Spieler[1].Siege+"	"+Draw+"\n");
			if (Spieler[0].Siege!=Spieler[1].Siege) {
				System.out.println(führenderSpieler().Name+" liegt in Führung");
				printZeichen(führenderSpieler());
			}
		} while (abfrage());
	}
	public static Spieler führenderSpieler() {						//Giebt Spieler mit den mehr Siegen zurrück
		return (Spieler[0].Siege>Spieler[1].Siege)?Spieler[0]:Spieler[1];
	}
	
	public static boolean abfrage() {												//Weiterspielen?				//!!
		int antwort;
		do {
			System.out.println("Möchst du noch eine Runde spielen?"+"\n"+"1 : nochmal spielen"+"\n"+"2 : beenden");									//bissher drücke belibige taste um erneut zu spielen
			antwort=Spielmechanik.eingabe(1, 2);
		}while((antwort!=1)&&(antwort!=2));			//solange wie nicht 1/2		fehler (immer true)
		if(antwort==1) {
			deletespielFeld();
			printFeld();
			return true;}
		else{
			System.out.println("Das Spiel ist zu Ende"+"\n"+"\n"+"Der Sieger ist: "+führenderSpieler().Name);
			printZeichen(führenderSpieler());
			return false;}
	}

	public static void deletespielFeld() {								// vorrübergehend
		{
		for(int i=0;i<spielFeld.length;i++){
			spielFeld[i]=' ';
			}
		} 
	}
	
	public static void printArray(char a[][])				// print 2-Dimensionales Array mit passenden Zeilensprung
		{
		for(int i=0;i<a.length;i++){
			for(int j=0;j< a[i].length;j++) {
				System.out.print(a[i][j]);
				if(j==(a[i].length)-1)
					System.out.println();}
			}
		} 
	public static void printFeld(){							// print spielFeld in Feld
		char[][]Feld = {
				{' ',spielFeld[6],' ','|',' ',spielFeld[7],' ','|',' ',spielFeld[8],' '},
				{'-',    '-',     '-','+','-',    '-',     '-','+','-',    '-',     '-'},
				{' ',spielFeld[3],' ','|',' ',spielFeld[4],' ','|',' ',spielFeld[5],' '},
				{'-',    '-',     '-','+','-',    '-',     '-','+','-',    '-',     '-'},
				{' ',spielFeld[0],' ','|',' ',spielFeld[1],' ','|',' ',spielFeld[2],' '}	};
		printArray(Feld);
	}
	public static void printZeichen(Spieler Spieler) {						// print Spieler.Zeichen groß			
			if (Spieler.Zeichen=='x') {																				
				char [][] gewinnZeichenX= {
						{'x',' ',' ',' ',' ',' ',' ',' ','x'},
						{' ',' ','x',' ',' ',' ','x',' ',' '},
						{' ',' ',' ',' ','x',' ',' ',' ',' '},
						{' ',' ','x',' ',' ',' ','x',' ',' '},
						{'x',' ',' ',' ',' ',' ',' ',' ','x'}	};
				printArray(gewinnZeichenX);
				}
			else {
				char [][] gewinnZeichenO= {
						{' ',' ',' ','o','o','o','o',' ',' ',' '},
						{' ','o','o',' ',' ',' ',' ','o','o',' '},
						{'o','o',' ',' ',' ',' ',' ',' ','o','o'},
						{' ','o','o',' ',' ',' ',' ','o','o',' '},
						{' ',' ',' ','o','o','o','o',' ',' ',' '}	};
				printArray(gewinnZeichenO);}
		}
	
	public static void spielerAuswahl(int spielerAnzahl) {				//!!
		Scanner scanner = new Scanner(System.in);
		int antwort;
		System.out.println("Gebt um fortzufahren bitte beide eure Namen ein.");
		for(int spieler=1;spieler<=spielerAnzahl;spieler++) {
			char Zeichen;										//teile Zeichen zu
			if(spieler==1)
				{Zeichen='x';}
			else
				{Zeichen='o';}
			System.out.println("Wie heißt der "+spieler+".Spieler mit dem Zeichen "+Zeichen+" ?");		//teile Name zu
			String Name=scanner.next();			
			do {															//teile Coputer oder spieler zu
				System.out.println("Soll dieser Spieler ein Computer sein?"+"\n"+"gebe die entsprechende Zahl an"+"\n"+"1 : Computer"+"\n"+"2 : Nein");
				antwort=Spielmechanik.eingabe(1,2);		//!!
			}while((antwort!=1)&&(antwort!=2));			//!!
			if (antwort==1) {
				int Schwierigkeit;													//teile Schwirigkeit dem Computer zu 
				do {
					System.out.println("Wie schwer soll der Gegner sein?"+"\n"+"Gebe die entsprechende Zahl an"+"\n"+"1 : leicht"+"\n"+"2 : mitten"+"\n"+"3 : unbesiegt (bis jetzt)");	//!!
					Schwierigkeit=Spielmechanik.eingabe(1,3);							//!!					
				}while((Schwierigkeit!=1)&&(Schwierigkeit!=2)&&(Schwierigkeit!=3));		//!!
					Spieler[spieler-1]=new KI(Name,Schwierigkeit,Zeichen);				//erstelle Computergegner
			}
			else
				{Spieler[spieler-1]=new Spieler(Name,Zeichen);}						//erstelle Spieler
			Spieler[spieler-1].Siege=0;												//setze Siege auf 0
			System.out.println("Spieler "+spieler+" : "+Spieler[spieler-1].Name+"\n"+"Zeichen : "+Spieler[spieler-1].Zeichen+"\n");			
		}
		do {
			System.out.println("Welcher Spieler soll beginnen?"+"\n"+"Gebe die entsprechende Zahl an"+"\n"+"1 : "+Spieler[0].Name+"\n"+"2 : "+Spieler[1].Name);
			antwort=Spielmechanik.eingabe(1,2);										//!!
		}while((antwort!=1)&&(antwort!=2));											//!!
		if (antwort==1) {
			Spieler[0].setAktiv(true);									// Spieler1 beginnt
			Spieler[1].setAktiv(false);}
		else {
			Spieler[1].setAktiv(true);									// Spieler2 beginnt
			Spieler[0].setAktiv(false);}
	}
	
 	public static void spielerwechsel() {					// wechselt aktiv von den Spielern
		if (Spieler[0].getAktiv()) {
			Spieler[0].setAktiv(false);								// wenn Spieler1 aktiv war, änder zu Spieler2 ist aktiv
			Spieler[1].setAktiv(true);}
		else {
			Spieler[0].setAktiv(true);								// wenn Spieler1 nicht aktiv war, änder Spieler1 zu aktiv
			Spieler[1].setAktiv(false);
		}
	}
 	public static Spieler aktiverSpieler() {				// gibt den Spieler zurück, welcher aktiv=true
		if (Spieler[0].aktiv)
			return Spieler[0];
		else
			return Spieler[1];
	}
}