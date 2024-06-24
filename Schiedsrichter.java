public class Schiedsrichter {

  private Spieler _spieler1;
  private Spieler _spieler2;
  private Spieler _beginner;
  private Computer _comp;
  private Spieler _nichtBeginner;
  private Topf _topf1;
  private Wuerfel _wuerfel1;
  private Wuerfel _wuerfel2;
  private boolean _compaktiv = false;
  private Spieler _ultbeginner;
  private StartPanelGUI _GUI;

  public Schiedsrichter() { // Initialisierung der Spieler
    this._topf1 = new Topf();
    this._wuerfel1 = new Wuerfel();
    this._wuerfel2 = new Wuerfel();

    Spieler spieler_1 = new Spieler(
      "spieler1",
      _wuerfel1,
      _wuerfel2,
      _topf1,
      this
    );
    Spieler spieler_2 = new Spieler(
      "spieler2",
      _wuerfel1,
      _wuerfel2,
      _topf1,
      this
    );

    this._spieler1 = spieler_1;
    this._spieler2 = spieler_2;
  }

  public Schiedsrichter(StartPanelGUI GUI) { // Initialisierung der Spieler
    this._topf1 = new Topf();
    this._wuerfel1 = new Wuerfel();
    this._wuerfel2 = new Wuerfel();
    this._GUI = GUI;

    Spieler spieler_1 = new Spieler(
      "spieler1",
      _wuerfel1,
      _wuerfel2,
      _topf1,
      this
    );
    Spieler spieler_2 = new Spieler(
      "spieler2",
      _wuerfel1,
      _wuerfel2,
      _topf1,
      this
    );

    this._spieler1 = spieler_1;
    this._spieler2 = spieler_2;
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
      this._spieler1 = spieler_1;
      this._spieler2 = comp_1;
      this._comp = comp_1;
      this._compaktiv = true;
    } else this._spieler1 = spieler_1;
    this._spieler2 = spieler_2;
  }

  //Methode zum starten des Spiels
  public void spielStarten() {
    // Überprüfen, ob keiner der Spieler würfeln darf
    if (
      getSpieler1().getDarfWuerfeln() == false &&
      getSpieler2().getDarfWuerfeln() == false &&
      getNichtBeginner() == null
    ) {
      // Zufällig einen Wert zwischen 1 und 2 auswählen
      int wert = 0;
      wert = (int) Math.round(Math.random() * (2 - 1)) + 1;
      if (wert == 1) {
        setNichtBeginner(getSpieler1());
        setBeginner(getSpieler2());
        setUltbeginner(getSpieler2());
      } else {
        setNichtBeginner(getSpieler2());
        setBeginner(getSpieler1());
        setUltbeginner(getSpieler1());
      }
      // Den Spieler, der nicht beginnt, festlegen
      if (getNichtBeginner() == getSpieler1()) {
        getSpieler1().setDarfWuerfeln(false);
        getSpieler2().setDarfWuerfeln(true);
      } else {
        getSpieler1().setDarfWuerfeln(true);
        getSpieler2().setDarfWuerfeln(false);
      }
    } else {
      // Wenn ein Spieler nicht der Anfänger ist, die Würfelreihenfolge wechseln
      if (getNichtBeginner() == getSpieler1()) {
        getSpieler1().setDarfWuerfeln(true);
        getSpieler2().setDarfWuerfeln(false);
        setNichtBeginner(getSpieler2());
        setBeginner(getSpieler1());
      } else if (getNichtBeginner() == getSpieler2()) {
        getSpieler2().setDarfWuerfeln(true);
        getSpieler1().setDarfWuerfeln(false);
        setNichtBeginner(getSpieler1());
        setBeginner(getSpieler2());
      }
    }

    this.startcomp();
  }

  public void startcomp() {
    if (_compaktiv && getBeginner() == getSpieler2()) {
      getComp().compdurchgangstart();
    }
  }

  // Methode zum Auswerten des Spiels
  public void Auswerten() {
    boolean spieler1gewonnen = false;
    boolean spieler2gewonnen = false;
    // Überprüfen, ob Spieler 1 keine Sieben geworfen hat
    if (getSpieler1().getsiebengewuerfelt() == false) {
      // Überprüfen, ob Spieler 1 eine höhere Punktzahl hat und weniger Würfe als Spieler 2
      if (
        getSpieler1().punktestandAngeben() >
        getSpieler2().punktestandAngeben() &&
        getSpieler1().wurfAnzahlAngeben() <= getSpieler2().wurfAnzahlAngeben()
      ) {
        spieler1gewonnen = true;
      }
    }

    // Überprüfen, ob Spieler 2 keine Sieben geworfen hat
    if (getSpieler2().getsiebengewuerfelt() == false) {
      // Überprüfen, ob Spieler 2 eine höhere Punktzahl hat und weniger Würfe als Spieler 1
      if (
        getSpieler2().punktestandAngeben() >
        getSpieler1().punktestandAngeben() &&
        getSpieler2().wurfAnzahlAngeben() <= getSpieler1().wurfAnzahlAngeben()
      ) {
        spieler2gewonnen = true;
      }
    }
    if (getSpieler2().getsiebengewuerfelt() == true) {
      // Überprüfen, ob Spieler 2 eine höhere Punktzahl hat und weniger Würfe als Spieler 1
      spieler1gewonnen = true;
    }
    if (getSpieler1().getsiebengewuerfelt() == true) {
      // Überprüfen, ob Spieler 2 eine höhere Punktzahl hat und weniger Würfe als Spieler 1
      spieler2gewonnen = true;
    }

    //den Topf für den Gewinner leeren
    if (spieler1gewonnen == true) {
      getSpieler1().topfLeeren();
    } else if (spieler2gewonnen == true) {
      getSpieler2().topfLeeren();
    }

    getSpieler1().setsiebengewuerfelt(false);
    this._spieler2.setsiebengewuerfelt(false);

    getSpieler1().getWuerfel1().reset();
    getSpieler1().getWuerfel2().reset();

    


    getSpieler1().setPunkte(0);
    getSpieler1().setWurfAnzahl(0);


    getSpieler2().setPunkte(0);
    getSpieler2().setWurfAnzahl(0);
    setBeginner(null);
    setNichtBeginner(null);
  }

  public String getnichtbeginner() {
    return this._nichtBeginner.getName();
  }

  public void gameReset() {
    getSpieler1().playerreset();
    getSpieler2().playerreset();
    getSpieler1().getWuerfel1().reset();
    getSpieler1().getWuerfel2().reset();
    getSpieler1().getTopf().topfReset();



    setBeginner(null);
    setNichtBeginner(null);
  }





  // Getter / Setter Methoden

  public Spieler getSpieler1() {
    return _spieler1;
  }

  public void setSpieler1(Spieler spieler1) {
    this._spieler1 = spieler1;
  }

  // Getter and setter for _spieler2
  public Spieler getSpieler2() {
    return _spieler2;
  }

  public void setSpieler2(Spieler spieler2) {
    this._spieler2 = spieler2;
  }

  // Getter and setter for _beginner
  public Spieler getBeginner() {
    return _beginner;
  }

  public void setBeginner(Spieler beginner) {
    this._beginner = beginner;
  }

  // Getter and setter for _comp
  public Computer getComp() {
    return _comp;
  }

  public void setComp(Computer comp) {
    this._comp = comp;
  }

  // Getter and setter for _nichtBeginner
  public Spieler getNichtBeginner() {
    return _nichtBeginner;
  }

  public void setNichtBeginner(Spieler nichtBeginner) {
    this._nichtBeginner = nichtBeginner;
  }

  // Getter and setter for _topf1
  public Topf getTopf1() {
    return _topf1;
  }

  public void setTopf1(Topf topf1) {
    this._topf1 = topf1;
  }

  // Getter and setter for _wuerfel1
  public Wuerfel getWuerfel1() {
    return _wuerfel1;
  }

  public void setWuerfel1(Wuerfel wuerfel1) {
    this._wuerfel1 = wuerfel1;
  }

  // Getter and setter for _wuerfel2
  public Wuerfel getWuerfel2() {
    return _wuerfel2;
  }

  public void setWuerfel2(Wuerfel wuerfel2) {
    this._wuerfel2 = wuerfel2;
  }

  // Getter and setter for _compaktiv
  public boolean isCompaktiv() {
    return _compaktiv;
  }

  public void setCompaktiv(boolean compaktiv) {
    this._compaktiv = compaktiv;
  }

  // Getter and setter for _ultbeginner
  public Spieler getUltbeginner() {
    return _ultbeginner;
  }

  public void setUltbeginner(Spieler ultbeginner) {
    this._ultbeginner = ultbeginner;
  }

  // Getter and setter for _GUI
  public StartPanelGUI getGUI() {
    return _GUI;
  }

  public void setGUI(StartPanelGUI GUI) {
    this._GUI = GUI;
  }





}
