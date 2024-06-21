/**
 * Klasse Spieler zur Bearbeitung!
 *
 * @author Noah
 * @version 01
 *
 */

public class Spieler {

  // Attribute der Klasse Spieler
  public String name;
  public int punkte;
  public int vermoegen;
  public int wurfAnzahl;
  public Computer compgegner;
  public Topf topf;
  public Wuerfel wuerfel1;
  public Wuerfel wuerfel2;
  private boolean darfWuerfeln = false;
  public boolean siebengewuerfelt = false;
  private Schiedsrichter schiedsrichter = null;

  // hier im spaeteren Verlauf noch das Attribut darfWuerfeln dazunehmen

  // Konstruktor der Klasse Spieler
  public Spieler(String name,Wuerfel wuerfel1,Wuerfel wuerfel2,Topf topf,Schiedsrichter schiedsrichter) {
    this.name = name;
    this.wuerfel1 = wuerfel1; // Setzt den ersten Würfel
    this.wuerfel2 = wuerfel2; // Setzt den zweiten Würfel
    this.topf = topf; // Setzt den Topf
    this.wurfAnzahl = 0;
    this.punkte = 0;
    this.vermoegen = 1000; // Setzt das Vermögen auf 1000
    this.schiedsrichter = schiedsrichter;
  }

  // Methode, die den aktuellen Punktestand zurückgibt
  public int punktestandAngeben() {
    return this.punkte;
  }

  //Methode zum beenden eines Durchgangs

  public void durchgangBeenden() {
    if (siebengewuerfelt == false) {
      this.darfWuerfeln = false;
      schiedsrichter.spielStarten();
    } else {
      this.darfWuerfeln = false;
      this.punkte = this.punkte - 7;
      schiedsrichter.Auswerten();
    }
 
  }

  // Methode, die den Topf leert und das Vermögen des Spielers aktualisiert
  public void topfLeeren() {
    this.vermoegen = this.vermoegen + this.topf.einsatzAbgeben();
    this.punkte = 0;
    this.wurfAnzahl = 0;
  }

  // Methode, die die Anzahl der Würfe zurückgibt
  public int wurfAnzahlAngeben() {
    return this.wurfAnzahl;
  }

  // Methode, die es dem Spieler ermöglicht, einen Einsatz zu setzen
  public void einsatzSetzen(int einsatz) {
    if (this.vermoegen < einsatz) {
      einsatz = this.vermoegen;
    }
    this.topf.einsatzAufnehmen(einsatz);
    this.vermoegen = this.vermoegen - einsatz;
  }

  // Methode, die es dem Spieler ermöglicht, zu würfeln
  public void wuerfeln() {
    int wuerfegeggner = 0;

    //Überprüfe, ob der Spieler darfWuerfeln hat
    
    if (darfWuerfelnAuswertung() == true) {
       wuerfel1.rollen();
      wuerfel2.rollen();

      if (wuerfel1.punktzahlAngeben() + wuerfel2.punktzahlAngeben() == 7) { // Falls 7 gewürfelt durchgang vorbei
        this.siebengewuerfelt = true;

        this.durchgangBeenden();
      } else {
        int augensumme =
          this.punktestandAngeben() +
          wuerfel1.punktzahlAngeben() +
          wuerfel2.punktzahlAngeben();
        this.punkte = augensumme;

        this.wurfAnzahl = this.wurfAnzahl + 1;
      }
    } else {
      schiedsrichter.Auswerten();
    }
  }

  // Methode, die es ermöglicht, den Namen des Spielers zu ändern
  public void setName(String neuerName) {
    this.name = neuerName;
  }

  public boolean getsiebengewuerfelt() {
    return this.siebengewuerfelt;
  }

  public void setDarfWuerfeln(boolean jaodernein) {
    this.darfWuerfeln = jaodernein;
  }

  public boolean getDarfWuerfeln() {
    return this.darfWuerfeln;
  }

  public void setsiebengewuerfelt(boolean siebengewuerfelt) {
    this.siebengewuerfelt = siebengewuerfelt;
  }

  public void playerreset() {
    this.punkte = 0;
    this.vermoegen = 1000;
    this.wurfAnzahl = 0;

    this.darfWuerfeln = false;
    this.siebengewuerfelt = false;
  }


  

  public boolean darfWuerfelnAuswertung() {
    if (darfWuerfeln == true) {
        if (schiedsrichter.ultbeginner == this) {
            return true; // If the player is the beginner, they can roll as many times as they want
        } else {
            int opponentRollCount = getOpponentRollCount();
            
            return this.wurfAnzahl < opponentRollCount; // If the player has rolled less than or equal to the opponent's roll count, they can roll again
        }
    }
    return false; // If darfWuerfeln is false, the player cannot roll
}

public int getOpponentRollCount() {
    if (schiedsrichter.spieler1 == this) {
        return schiedsrichter.spieler2.wurfAnzahl;
    } else {
        return schiedsrichter.spieler1.wurfAnzahl;
    }
}
}
