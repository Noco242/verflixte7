
import java.util.Random;

/**
 * Klasse Wuerfel
 * 
 * Diese Klasse repräsentiert einen Würfel mit einer bestimmten Augenzahl.
 */
public class Wuerfel {
    private int _punkte; // Beibehaltung der Variablenbezeichnung _punkte

    /**
     * Konstruktor für den Würfel. Initialisiert die Augenzahl mit 0.
     */
    public Wuerfel() {
        this._punkte = 0;
    }

    /**
     * Gibt die aktuelle Augenzahl des Würfels zurück.
     * 
     * @return Die Augenzahl des Würfels.
     */
    public int punktzahlAngeben() {
        return this._punkte;
    }

    /**
     * Setzt die Augenzahl des Würfels auf den angegebenen Wert.
     * 
     * @param punkte Die Augenzahl, die gesetzt werden soll.
     */
    public void setPunkte(int punkte) {
        this._punkte = punkte;
    }

    /**
     * Lässt den Würfel rollen und setzt die Augenzahl auf einen zufälligen Wert zwischen 1 und maximum (einschließlich).
     * 
     * @param maximum Die maximale Augenzahl, die gewürfelt werden kann.
     */
    private int zufallsZahlAusgeben(int maximum) {
        Random rand = new Random();
        return rand.nextInt(maximum) + 1;
    }

    /**
     * Lässt den Würfel rollen und setzt die Augenzahl entsprechend.
     * 
     * @param maximum Die maximale Augenzahl, die gewürfelt werden kann.
     */
    public void rollen(int maximum) {
        this.setPunkte(zufallsZahlAusgeben(maximum));
    }

    /**
     * Setzt die Augenzahl auf 0 zurück.
     */
    public void reset() {
        this.setPunkte(0);
    }


   public int getPunkte(){
      return this._punkte;
   }


}

