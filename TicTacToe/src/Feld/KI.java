package Feld;

import java.util.Random;

public class KI extends Spieler {
	int Schwierigkeit;
	int trst;
	
	public KI(String Name,int Schwierigkeit,char Zeichen) {
		this.Zeichen = Zeichen;
		this.Schwierigkeit = Schwierigkeit;
		this.Name=Name;
	}

	public void Zug(int durchgang) {
		int eingabe = eingabe(durchgang);
		Spielmechanik.eingabe(eingabe);
		System.out.println("Zug: " + durchgang + "\n" + Main.aktiverSpieler().Name + " wählt:" + eingabe);
	}
	
	private int eingabe(int durchgang) {
		switch (Schwierigkeit) {
		case 1:
			return leicht();
		case 2:
			return mittel();
		default:
			return schwer(durchgang);
		}
	}
	private int leicht() { 															// Einfache KI
		for (int eingabe1 = 1; eingabe1 < 10; eingabe1++) {								// if feld eingabe1 eingabeMöglich dann return eingabe1;
			if (Spielmechanik.eingabeMöglich(eingabe1))
				return eingabe1;
		}
		return 0;
	}
	private int mittel() { // Fabians Zufällige KI
		Random rand = new Random();
		int eingabe2;
		if (möglich(gewinnen(Zeichen))) { // gewinn in diesem Zug möglich?
			return gewinnen(Zeichen);
		} else if (möglich(gewinnen(gegnerZeichen()))) { // verlieren möglich? (kann der andere Spieler Gewinnen?)
			return gewinnen(gegnerZeichen());
		} else
			do {
				eingabe2 = rand.nextInt(9) + 1;
			} while (!Spielmechanik.eingabeMöglich(eingabe2));
		return eingabe2;
	}
	private int schwer(int durchgang) { // Schwierige KI
		if (möglich(gewinnen(Zeichen))) { // gewinn in diesem Zug möglich?
			return gewinnen(Zeichen);
		} else if (möglich(gewinnen(gegnerZeichen()))) { // verlieren möglich? (kann der andere Spieler Gewinnen?)
			return gewinnen(gegnerZeichen());
		} else if (möglich(Strategie(durchgang))) { // Strategie möglich? (gewinnen immer in spätere/n Zug/Züge)
			return Strategie(durchgang);
		} else
			return leicht(); // mögliches int; (Sarahs ki)
	}

	private boolean möglich(int eingabe) { // schwierigkeit 3 (unmöglich)
		if (eingabe != 0) // ausgabe bei den Methoden(eingabe) immer 0 wenn es nicht möglich ist
			return true;
		else
			return false;
	}
	private char gegnerZeichen() { // suche noch nach einer anderen lösung
		if (Zeichen == 'x')
			return 'o';
		else
			return 'x';
	}
	
	private int gewinnen(char spielerZeichen) { // überpüfft ob gewinnen in diesem Zug möglich ist
		if ((Spielmechanik.eingabeMöglich(1) && (Main.spielFeld[4] == spielerZeichen) && (Main.spielFeld[8] == spielerZeichen)) ||	// Diagonal
			(Spielmechanik.eingabeMöglich(1) && (Main.spielFeld[1] == spielerZeichen) && (Main.spielFeld[2] == spielerZeichen)) ||	// 3.Reihe Waagerecht
			(Spielmechanik.eingabeMöglich(1) && (Main.spielFeld[3] == spielerZeichen) && (Main.spielFeld[6] == spielerZeichen)))	// 1.Spalte Senkrecht
			return 1;
		else if ((Spielmechanik.eingabeMöglich(2) && (Main.spielFeld[4] == spielerZeichen) && (Main.spielFeld[7] == spielerZeichen)) ||	// 2.Spalte Senkrecht
				 (Spielmechanik.eingabeMöglich(2) && (Main.spielFeld[0] == spielerZeichen) && (Main.spielFeld[2] == spielerZeichen)))	// 3.Reihe Waagerecht
			return 2;
		else if ((Spielmechanik.eingabeMöglich(3) && (Main.spielFeld[0] == spielerZeichen) && (Main.spielFeld[1] == spielerZeichen)) ||	// 3.Reihe Waagerecht
				 (Spielmechanik.eingabeMöglich(3) && (Main.spielFeld[5] == spielerZeichen) && (Main.spielFeld[8] == spielerZeichen)) ||	// 3.Spalte Senkrecht
				 (Spielmechanik.eingabeMöglich(3) && (Main.spielFeld[4] == spielerZeichen) && (Main.spielFeld[6] == spielerZeichen)))	// Diagonal \
			return 3;
		else if ((Spielmechanik.eingabeMöglich(4) && (Main.spielFeld[4] == spielerZeichen) && (Main.spielFeld[5] == spielerZeichen)) ||	// 2.Reihe Waagerecht
				 (Spielmechanik.eingabeMöglich(4) && (Main.spielFeld[0] == spielerZeichen) && (Main.spielFeld[6] == spielerZeichen)))	// 1.Spalte Senkrecht
			return 4;
		else if ((Spielmechanik.eingabeMöglich(5) && (Main.spielFeld[3] == spielerZeichen) && (Main.spielFeld[5] == spielerZeichen)) ||	// 2.Reihe Waagerecht
				 (Spielmechanik.eingabeMöglich(5) && (Main.spielFeld[1] == spielerZeichen) && (Main.spielFeld[7] == spielerZeichen)) ||	// 2.Spalte Senkrecht
				 (Spielmechanik.eingabeMöglich(5) && (Main.spielFeld[2] == spielerZeichen) && (Main.spielFeld[6] == spielerZeichen)) ||	// Diagonal \
				 (Spielmechanik.eingabeMöglich(5) && (Main.spielFeld[0] == spielerZeichen) && (Main.spielFeld[8] == spielerZeichen)))	// Diagonal /
			return 5;
		else if ((Spielmechanik.eingabeMöglich(6) && (Main.spielFeld[3] == spielerZeichen) && (Main.spielFeld[4] == spielerZeichen)) ||	// 2.Reihe Waagerecht
				 (Spielmechanik.eingabeMöglich(6) && (Main.spielFeld[2] == spielerZeichen) && (Main.spielFeld[8] == spielerZeichen)))	// 3.Spalte Senkrecht
			return 6;
		else if ((Spielmechanik.eingabeMöglich(7) && (Main.spielFeld[7] == spielerZeichen) && (Main.spielFeld[8] == spielerZeichen)) ||	// 1.Reihe Waagerecht
				 (Spielmechanik.eingabeMöglich(7) && (Main.spielFeld[2] == spielerZeichen) && (Main.spielFeld[4] == spielerZeichen)) ||	// Diagonal \
				 (Spielmechanik.eingabeMöglich(7) && (Main.spielFeld[0] == spielerZeichen) && (Main.spielFeld[3] == spielerZeichen)))	// 1.Spalte Senkrecht
			return 7;
		else if ((Spielmechanik.eingabeMöglich(8) && (Main.spielFeld[1] == spielerZeichen) && (Main.spielFeld[4] == spielerZeichen)) || // 2.Spalte Senkrecht)
				 (Spielmechanik.eingabeMöglich(8) && (Main.spielFeld[6] == spielerZeichen) && (Main.spielFeld[8] == spielerZeichen)))	// 1.Reihe Waagerecht
			return 8;
		else if ((Spielmechanik.eingabeMöglich(9) && (Main.spielFeld[0] == spielerZeichen) && (Main.spielFeld[4] == spielerZeichen)) ||	// Diagonal /)
				 (Spielmechanik.eingabeMöglich(9) && (Main.spielFeld[2] == spielerZeichen) && (Main.spielFeld[5] == spielerZeichen)) ||	// 3.Spalte Senkrecht
				 (Spielmechanik.eingabeMöglich(9) && (Main.spielFeld[6] == spielerZeichen) && (Main.spielFeld[7] == spielerZeichen)))	// 1.Reihe Waagerecht
			return 9;
		return 0;
		}
	private int Strategie(int durchgang) {																// Strategie zum gewinnen /nicht verlieren
			switch (durchgang) {															// abhängich vom Zug(durchgang)
			case 1:
				return 1; // immer Feld unten links (höhere Wahrscheinlichtkeit)
			case 2:
				if (gegnerZeichen() == (Main.spielFeld[0] | Main.spielFeld[2] | Main.spielFeld[6] | Main.spielFeld[8])) // Falls eine Ecke
					return 5;
				else if (gegnerZeichen() == (Main.spielFeld[1] | Main.spielFeld[3])) //
					return 1;
				else
					return 9;
			case 3:
				if (gegnerZeichen() == (Main.spielFeld[2] | Main.spielFeld[8] | Main.spielFeld[1] | Main.spielFeld[7]))
					return 7;
				else if (gegnerZeichen() == (Main.spielFeld[6] | Main.spielFeld[3] | Main.spielFeld[5]))
					return 3;
				return 9; // Falls 5 (höhere Wahrscheinlichtkeit)
			case 4:
				if (Spielmechanik.eingabeMöglich(5))
					return 5;
				else if (gegnerZeichen() == ((Main.spielFeld[0] & Main.spielFeld[7]) | (Main.spielFeld[2] & Main.spielFeld[7])
						| (Main.spielFeld[6] & Main.spielFeld[1]) | (Main.spielFeld[8] & Main.spielFeld[1])))
					return 6;
				else if (gegnerZeichen() == (Main.spielFeld[5] & (Main.spielFeld[8] | Main.spielFeld[0] | Main.spielFeld[2])))
					return 1;
				else if (Zeichen==Main.spielFeld[8]&&(gegnerZeichen()==Main.spielFeld[0]))
						return 7;
				return 8;
			case 5:
				if (gegnerZeichen() == Main.spielFeld[8])
					return 3;
				else if (gegnerZeichen() != Main.spielFeld[5])
					return 5;
				return 0;
			default:
				return 0;
		}
	}
}