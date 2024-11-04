package application;

public class Taille extends Option {

    private String tailleVelo;  

    public Taille(String nomOption, int prixOption, String tailleVelo) {
        super(nomOption, prixOption);
        this.tailleVelo = tailleVelo;
    }

    // Getter et Setter pour tailleVelo
    public String getTailleVelo() {
        return tailleVelo;
    }

    public void setTailleVelo(String tailleVelo) {
        this.tailleVelo = tailleVelo;
    }
    
    public String toString() {
      return tailleVelo; 
  }
}

