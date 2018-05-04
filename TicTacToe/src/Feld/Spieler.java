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

	public void Zug(int durchgang) {					// eingabeAufforderrung + eingabe wiederholung (solange wie nicht m�glich) + eintragen
		int eingabe;
		int gg=0;
		do {															// Zug eingabe wiederholen bis der Zug m�glich ist
			if (gg >0)
				System.out.println("Dieses Feld ist nicht verf�gbar, w�hle bitte ein anderes aus!");
			System.out.println("Zug: "+durchgang+"\n"+Main.aktiverSpieler().Name+" w�hle ein freies Feld"+"\n"+"Felder siehe Nummernblock");
			eingabe = Spielmechanik.eingabe(1,9);
			gg++;
			}while (!(Spielmechanik.eingabeM�glich(eingabe)));
		Spielmechanik.eingabe(eingabe);									// eintragen im spielFeld
	}
	public void Sieg() {								
		this.Siege=(this.Siege+1);}
}