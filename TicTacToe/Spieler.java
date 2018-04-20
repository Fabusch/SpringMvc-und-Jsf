package Feld;

public class Spieler 
{
	String Name;
	char Zeichen;
	boolean aktiv;		//aktiv = am Zug
	int Siege;
	
	public Spieler(String name,char zeichen) {
		this.Name=name;
		this.Zeichen = zeichen;
	}
	public Spieler() {}									// notwedig um KI (Spieler) zu erstellen
	
 	public void setAktiv(boolean Wert) {
		this.aktiv=Wert;
	}
	public boolean getAktiv() {
		return aktiv;
	}

	public void Zug(int durchgang) {					// eingabeAufforderrung + eingabe wiederholung (solange wie nicht möglich) + eintragen
		int eingabe;
		int gg=0;
		do {															// Zug eingabe wiederholen bis der Zug möglich ist
			if (gg >0)
				System.out.println("Dieses Feld ist nicht verfügbar, wähle bitte ein anderes aus!");
			System.out.println("Zug: "+durchgang+"\n"+Main.aktiverSpieler().Name+" wähle ein freies Feld"+"\n"+"Felder siehe Nummernblock");
			eingabe = Spielmechanik.eingabe(1,9);
			gg++;
			}while (!(Spielmechanik.eingabeMöglich(eingabe)));
		Spielmechanik.eingabe(eingabe);									// eintragen im spielFeld
	}
	public void Sieg() {								
		this.Siege=(this.Siege+1);}
}