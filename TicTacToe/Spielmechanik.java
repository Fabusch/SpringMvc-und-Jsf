package Feld;

public class Spielmechanik {
	public static void eingabe(int eingabe) {
		Main.spielFeld[eingabe - 1] = Main.aktiverSpieler().Zeichen;
	}

	public static boolean gewinn() {
		Spieler Spieler = Main.aktiverSpieler();
		if (((Main.spielFeld[6] == Spieler.Zeichen) && (Main.spielFeld[7] == Spieler.Zeichen)
				&& (Main.spielFeld[8] == Spieler.Zeichen))
				|| ((Main.spielFeld[3] == Spieler.Zeichen) && (Main.spielFeld[4] == Spieler.Zeichen)
						&& (Main.spielFeld[5] == Spieler.Zeichen))
				|| ((Main.spielFeld[0] == Spieler.Zeichen) && (Main.spielFeld[1] == Spieler.Zeichen)
						&& (Main.spielFeld[2] == Spieler.Zeichen))
				|| ((Main.spielFeld[0] == Spieler.Zeichen) && (Main.spielFeld[3] == Spieler.Zeichen)
						&& (Main.spielFeld[6] == Spieler.Zeichen))
				|| ((Main.spielFeld[1] == Spieler.Zeichen) && (Main.spielFeld[4] == Spieler.Zeichen)
						&& (Main.spielFeld[7] == Spieler.Zeichen))
				|| ((Main.spielFeld[2] == Spieler.Zeichen) && (Main.spielFeld[5] == Spieler.Zeichen)
						&& (Main.spielFeld[8] == Spieler.Zeichen))
				|| ((Main.spielFeld[2] == Spieler.Zeichen) && (Main.spielFeld[4] == Spieler.Zeichen)
						&& (Main.spielFeld[6] == Spieler.Zeichen))
				|| ((Main.spielFeld[0] == Spieler.Zeichen) && (Main.spielFeld[4] == Spieler.Zeichen)
						&& (Main.spielFeld[8] == Spieler.Zeichen))) {
			return true;
		} else
			return false;
	}

	public static boolean eingabeMöglich(int eingabe) {
		if ((eingabe<1)||(eingabe>9)||(Main.spielFeld[eingabe - 1] == 'x') || (Main.spielFeld[eingabe - 1] == 'o')) {		//!! auf reihenfolge achten
			return false;																				// nicht möglicher Zug
		} else
			return true;																				// Möglicher Zug
	}
	
	public static int eingabe(int min,int max) {
		int i;
		while (true) {
			try {
				i = new java.util.Scanner(System.in).nextInt();
				return i;
			} catch (Exception e) {
				System.out.println("Bitte gebe eine ganze Zahlen zwischen "+min+" und "+max+" ein.");
			}

		}
	}
}