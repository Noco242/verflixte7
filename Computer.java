public class Computer extends Spieler{

    private Spieler gegner = null;
    
    
    
    
    
    public Computer(String name, Wuerfel wuerfel1, Wuerfel wuerfel2, Topf topf, Schiedsrichter schiedsrichter, Spieler gegner) {
        super(name, wuerfel1, wuerfel2, topf, schiedsrichter);
        this.gegner = gegner;
        
    }






}