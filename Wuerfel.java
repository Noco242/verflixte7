
/**
 * Klasse Wuerfel
 * 
 * @author ...
 * @version 01
 */

public class Wuerfel
{
   private int _punkte;

    public Wuerfel()
    {
        // initialisiert die Augenzahl mit 0 
        _punkte = 0;
    }
   
   /**
    * Diese Methode gibt die gewuerfelte Augenzahl zurueck.
    */
   public int punktzahlAngeben ()
   {
      return this._punkte;
   }
   
   /**
    * Diese Methode liefert einen Zufallswert zwischen 1 und einschliesslich maximum 
   *   
   *   //schlechte Implementierung, weil 1 und 6 nur halbs so oft gewuerfelt werden wegen round
   * 
   *   //Aufgabe: mit Java-Klasse Random besser machen!
    */
   
   private int zufallsZahlAusgeben(int maximum)
   { 
      int wert=0;
      wert =(int)Math.round(Math.random()*(maximum-1))+1;
      return wert;
   }

   /**
    * laesst den Wuerfel rollen
    */
   public void rollen ()
   {
      setPunkte(zufallsZahlAusgeben(6));
   }

   public void reset(){

      setPunkte(0);
   }

   public int getPunkte(){
      return this._punkte;
   }

   public void setPunkte(int Punkte){
      this._punkte = Punkte;
   }

}

