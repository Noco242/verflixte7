public class Schiedsrichter {

  public Spieler spieler1;
  public Spieler spieler2;
  public Spieler beginner;
  public Computer comp;
  public Spieler nichtBeginner;
  public Topf topf1;
  public Wuerfel wuerfel1;
  public Wuerfel wuerfel2;
  public boolean compaktiv = false;
  public Spieler ultbeginner;
  public StartPanelGUI GUI;

  public Schiedsrichter() { // Initialisierung der Spieler
    this.topf1 = new Topf();
    this.wuerfel1 = new Wuerfel();
    this.wuerfel2 = new Wuerfel();

    Spieler spieler_1 = new Spieler(
      "spieler1",
      wuerfel1,
      wuerfel2,
      topf1,
      this
    );
    Spieler spieler_2 = new Spieler(
      "spieler2",
      wuerfel1,
      wuerfel2,
      topf1,
      this
    );

    this.spieler1 = spieler_1;
    this.spieler2 = spieler_2;
  }

  public Schiedsrichter(StartPanelGUI GUI) { // Initialisierung der Spieler
    this.topf1 = new Topf();
    this.wuerfel1 = new Wuerfel();
    this.wuerfel2 = new Wuerfel();
    this.GUI = GUI;

    Spieler spieler_1 = new Spieler(
      "spieler1",
      wuerfel1,
      wuerfel2,
      topf1,
      this
    );
    Spieler spieler_2 = new Spieler(
      "spieler2",
      wuerfel1,
      wuerfel2,
      topf1,
      this
    );

    this.spieler1 = spieler_1;
    this.spieler2 = spieler_2;
  }

  public Schiedsrichter(boolean Computeraktiv) { // Initialisierung der Spieler
    Topf topf1 = new Topf();
    Wuerfel wuerfel1 = new Wuerfel();
    Wuerfel wuerfel2 = new Wuerfel();

    Spieler spieler_1 = new Spieler(
      "spieler1",
      wuerfel1,
      wuerfel2,
      topf1,
      this
    );
    Spieler spieler_2 = new Spieler(
      "spieler2",
      wuerfel1,
      wuerfel2,
      topf1,
      this
    );
    Computer comp_1 = new Computer(
      "Computer",
      wuerfel1,
      wuerfel2,
      topf1,
      this,
      spieler_1
    );

    if (Computeraktiv = true) {
      this.spieler1 = spieler_1;
      this.spieler1.compgegner = comp_1;
      this.spieler2 = comp_1;
      this.comp = comp_1;
      this.compaktiv = true;
    } else this.spieler1 = spieler_1;
    this.spieler2 = spieler_2;
  }

  //Methode zum starten des Spiels
  public void spielStarten() {
    // Überprüfen, ob keiner der Spieler würfeln darf
    if (
      this.spieler1.getDarfWuerfeln() == false &&
      this.spieler2.getDarfWuerfeln() == false &&
      this.nichtBeginner == null
    ) {
      // Zufällig einen Wert zwischen 1 und 2 auswählen
      int wert = 0;
      wert = (int) Math.round(Math.random() * (2 - 1)) + 1;
      if (wert == 1) {
        this.nichtBeginner = this.spieler1;
        this.beginner = this.spieler2;
        this.ultbeginner = this.spieler2;
      } else {
        this.nichtBeginner = this.spieler2;
        this.beginner = this.spieler1;
        this.ultbeginner = this.spieler1;
      }
      // Den Spieler, der nicht beginnt, festlegen
      if (this.nichtBeginner == this.spieler1) {
        this.spieler1.setDarfWuerfeln(false);
        this.spieler2.setDarfWuerfeln(true);
      } else {
        this.spieler1.setDarfWuerfeln(true);
        this.spieler2.setDarfWuerfeln(false);
      }
    } else {
      // Wenn ein Spieler nicht der Anfänger ist, die Würfelreihenfolge wechseln
      if (this.nichtBeginner == this.spieler1) {
        this.spieler1.setDarfWuerfeln(true);
        this.spieler2.setDarfWuerfeln(false);
        this.nichtBeginner = this.spieler2;
        this.beginner = this.spieler1;
      } else if (this.nichtBeginner == this.spieler2) {
        this.spieler2.setDarfWuerfeln(true);
        this.spieler1.setDarfWuerfeln(false);
        this.nichtBeginner = this.spieler1;
        this.beginner = this.spieler2;
      }
    }

    this.startcomp();
  }

  public void startcomp() {
    if (compaktiv && this.beginner == spieler2) {
      this.comp.compdurchgangstart();
    }
  }

  // Methode zum Auswerten des Spiels
  public void Auswerten() {
    boolean spieler1gewonnen = false;
    boolean spieler2gewonnen = false;
    // Überprüfen, ob Spieler 1 keine Sieben geworfen hat
    if (this.spieler1.getsiebengewuerfelt() == false) {
      // Überprüfen, ob Spieler 1 eine höhere Punktzahl hat und weniger Würfe als Spieler 2
      if (
        this.spieler1.punktestandAngeben() >
        this.spieler2.punktestandAngeben() &&
        this.spieler1.wurfAnzahlAngeben() <= this.spieler2.wurfAnzahlAngeben()
      ) {
        spieler1gewonnen = true;
      }
    }

    // Überprüfen, ob Spieler 2 keine Sieben geworfen hat
    if (this.spieler2.getsiebengewuerfelt() == false) {
      // Überprüfen, ob Spieler 2 eine höhere Punktzahl hat und weniger Würfe als Spieler 1
      if (
        this.spieler2.punktestandAngeben() >
        this.spieler1.punktestandAngeben() &&
        this.spieler2.wurfAnzahlAngeben() <= this.spieler1.wurfAnzahlAngeben()
      ) {
        spieler2gewonnen = true;
      }
    }
    if (this.spieler2.getsiebengewuerfelt() == true) {
      // Überprüfen, ob Spieler 2 eine höhere Punktzahl hat und weniger Würfe als Spieler 1
      spieler1gewonnen = true;
    }
    if (this.spieler1.getsiebengewuerfelt() == true) {
      // Überprüfen, ob Spieler 2 eine höhere Punktzahl hat und weniger Würfe als Spieler 1
      spieler2gewonnen = true;
    }

    //den Topf für den Gewinner leeren
    if (spieler1gewonnen == true) {
      this.spieler1.topfLeeren();
    } else if (spieler2gewonnen == true) {
      this.spieler2.topfLeeren();
    }

    this.spieler1.setsiebengewuerfelt(false);
    this.spieler2.setsiebengewuerfelt(false);

    this.spieler1.wuerfel1.reset();
    this.spieler1.wuerfel2.reset();

    this.spieler1.punkte = 0;
    this.spieler1.wurfAnzahl = 0;

    this.spieler2.punkte = 0;
    this.spieler2.wurfAnzahl = 0;

    this.beginner = null;
    this.nichtBeginner = null;
  }

  public String getnichtbeginner() {
    return this.nichtBeginner.name;
  }

  public void gameReset() {
    this.spieler1.playerreset();
    this.spieler2.playerreset();
    this.spieler1.wuerfel1.reset();
    this.spieler1.wuerfel2.reset();
    this.spieler1.topf.topfReset();
    this.beginner = null;
    this.nichtBeginner = null;
  }
}
