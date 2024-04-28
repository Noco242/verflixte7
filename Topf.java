/**
 * Klasse Topf
 *
 * @author Asmen
 * @version 01
 */

public class Topf {

  private int einsatz;

  public Topf() {
    // der Einsatz wird auf 0 gesetzt
    this.einsatz = 0;
  }

  /**
   *
   * Gibt die Summe, die im Topf liegt, zurueck und leert den Topf.
   */
  public int einsatzAbgeben() {
    int einsatz2 = this.einsatz;
    this.einsatz = 0;
    return einsatz2;
  }

  /**
   * Nimmt den Einsatz auf, der in den Topf eingezahlt werden soll.
   */
  public void einsatzAufnehmen(int einsatz) {

    this.einsatz = this.einsatz + einsatz;

  }
}
