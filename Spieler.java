/**
 * Klasse Spieler zur Bearbeitung!
 *
 * @author Noah
 * @version 01
 *
 */

public class Spieler {

  // Attribute der Klasse Spieler
  private String _name;
  private int _punkte;
  private int _vermoegen;
  private int _wurfAnzahl;
  private Computer _compgegner;
  private Topf _topf;
  private Wuerfel _wuerfel1;
  private Wuerfel _wuerfel2;
  private boolean _darfWuerfeln = false;
  private boolean _siebengewuerfelt = false;
  private Schiedsrichter _schiedsrichter = null;

  // hier im spaeteren Verlauf noch das Attribut darfWuerfeln dazunehmen

  // Konstruktor der Klasse Spieler
  public Spieler(String name,Wuerfel wuerfel1,Wuerfel wuerfel2,Topf topf,Schiedsrichter schiedsrichter) {
    this._name = name;
    this._wuerfel1 = wuerfel1; // Setzt den ersten Würfel
    this._wuerfel2 = wuerfel2; // Setzt den zweiten Würfel
    this._topf = topf; // Setzt den Topf
    this._wurfAnzahl = 0;
    this._punkte = 0;
    this._vermoegen = 1000; // Setzt das Vermögen auf 1000
    this._schiedsrichter = schiedsrichter;
  }

  // Methode, die den aktuellen Punktestand zurückgibt
  public int punktestandAngeben() {
    return this._punkte;
  }

  //Methode zum beenden eines Durchgangs

  public void durchgangBeenden() {
    
    
    
    if (getsiebengewuerfelt() == false) {
      if (getSchiedsrichter().getUltbeginner() != this) {
        getSchiedsrichter().Auswerten();
      }
      setDarfWuerfeln(false);
      getSchiedsrichter().spielStarten();
    } else {
      setDarfWuerfeln(false);
      setPunkte(getPunkte() - 7);
      getSchiedsrichter().Auswerten();
    }
 
  }

  // Methode, die den Topf leert und das Vermögen des Spielers aktualisiert
  public void topfLeeren() {
    setVermoegen(getVermoegen() + getTopf().einsatzAbgeben());
    setPunkte(0);
    setWurfAnzahl(0);
  }

  // Methode, die die Anzahl der Würfe zurückgibt
  public int wurfAnzahlAngeben() {
    return this._wurfAnzahl;
  }

  // Methode, die es dem Spieler ermöglicht, einen Einsatz zu setzen
  public void einsatzSetzen(int einsatz) {
    if (getVermoegen() < einsatz) {
      einsatz = getVermoegen();
    }
    getTopf().einsatzAufnehmen(einsatz);
    setVermoegen(getVermoegen() - einsatz);
  }

  // Methode, die es dem Spieler ermöglicht, zu würfeln
  public void wuerfeln() {
    int wuerfegeggner = 0;

    //Überprüfe, ob der Spieler darfWuerfeln hat
    
    if (darfWuerfelnAuswertung() == true) {
      getWuerfel1().rollen();
      getWuerfel2().rollen();
      
      if (getWuerfel1().punktzahlAngeben() + getWuerfel2().punktzahlAngeben() == 7) { // Falls 7 gewürfelt durchgang vorbei
        setsiebengewuerfelt(true);

        this.durchgangBeenden();
      } else {
        int augensumme =
          this.punktestandAngeben() +
          getWuerfel1().punktzahlAngeben() +
          getWuerfel2().punktzahlAngeben();
          setPunkte(augensumme);

          setWurfAnzahl(getWurfAnzahl() + 1);
      }
    }
  }

  // Methode, die es ermöglicht, den Namen des Spielers zu ändern

  

  public void playerreset() {
    setPunkte(0);
    setWurfAnzahl(0);
    setsiebengewuerfelt(false);
    setDarfWuerfeln(false);
    setVermoegen(1000);
  }


  

  public boolean darfWuerfelnAuswertung() {
    if (getDarfWuerfeln() == true) {
        if (getSchiedsrichter().getUltbeginner() == this) {
            return true; // If the player is the beginner, they can roll as many times as they want
        } else {
            int opponentRollCount = getOpponentRollCount();
            
            return getWurfAnzahl() < opponentRollCount; // If the player has rolled less than or equal to the opponent's roll count, they can roll again
        }
    }
    return false; // If darfWuerfeln is false, the player cannot roll
}

public int getOpponentRollCount() {
    if (getSchiedsrichter().getSpieler1() == this) {
        return getSchiedsrichter().getSpieler2().getWurfAnzahl();
    } else {
        return getSchiedsrichter().getSpieler1().getWurfAnzahl();
    }
}



// Getter und setter Methoden

public String getName() {
  return _name;
}

public void setName(String name) {
  this._name = name;
}

// Getter and setter for _punkte
public int getPunkte() {
  return _punkte;
}

public void setPunkte(int punkte) {
  this._punkte = punkte;
}

// Getter and setter for _vermoegen
public int getVermoegen() {
  return _vermoegen;
}

public void setVermoegen(int vermoegen) {
  this._vermoegen = vermoegen;
}

// Getter and setter for _wurfAnzahl
public int getWurfAnzahl() {
  return _wurfAnzahl;
}

public void setWurfAnzahl(int wurfAnzahl) {
  this._wurfAnzahl = wurfAnzahl;
}

// Getter and setter for _compgegner
public Computer getCompgegner() {
  return _compgegner;
}

public void setCompgegner(Computer compgegner) {
  this._compgegner = compgegner;
}

// Getter and setter for _topf
public Topf getTopf() {
  return _topf;
}

public void setTopf(Topf topf) {
  this._topf = topf;
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

// Getter and setter for _darfWuerfeln
public boolean isDarfWuerfeln() {
  return _darfWuerfeln;
}

// Getter and setter for _siebengewuerfelt
public boolean isSiebengewuerfelt() {
  return _siebengewuerfelt;
}

public void setSiebengewuerfelt(boolean siebengewuerfelt) {
  this._siebengewuerfelt = siebengewuerfelt;
}

// Getter and setter for _schiedsrichter
public Schiedsrichter getSchiedsrichter() {
  return _schiedsrichter;
}

public void setSchiedsrichter(Schiedsrichter schiedsrichter) {
  this._schiedsrichter = schiedsrichter;
}

public boolean getsiebengewuerfelt() {
  return this._siebengewuerfelt;
}

public void setDarfWuerfeln(boolean jaodernein) {
  this._darfWuerfeln = jaodernein;
}

public boolean getDarfWuerfeln() {
  return this._darfWuerfeln;
}

public void setsiebengewuerfelt(boolean siebengewuerfelt) {
  this._siebengewuerfelt = siebengewuerfelt;
}

}
