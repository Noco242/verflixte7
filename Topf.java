/**
 * Klasse Topf
 *
 * @author Asmen
 * @version 01
 */

public class Topf {

  private int _einsatz;

  public Topf() {
    // der Einsatz wird auf 0 gesetzt
    this._einsatz = 0;
  }

  /**
   *
   * Gibt die Summe, die im Topf liegt, zurueck und leert den Topf.
   */
  public int einsatzAbgeben() {
    int einsatz2 = getEinsatz();
    setEinsatz(0);
    return einsatz2;
  }

  /**
   * Nimmt den Einsatz auf, der in den Topf eingezahlt werden soll.
   */
  public void einsatzAufnehmen(int einsatz) {

    setEinsatz(getEinsatz() + einsatz);

  }

  public void topfReset(){

    setEinsatz(0);

  }

  public int getEinsatz(){

    return this._einsatz;
  }

  public void setEinsatz(int einsatz){

    this._einsatz = einsatz;
  }
}
