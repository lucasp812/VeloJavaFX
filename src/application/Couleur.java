package application;

public class Couleur extends Option {
    
    private String couleurVelo;  
    
    public Couleur(String nomOption, int prixOption, String couleurVelo) {
        super(nomOption, prixOption);
        this.couleurVelo = couleurVelo;
    }

    // Getter et Setter pour couleurVelo
    public String getCouleurVelo() {
        return couleurVelo;
    }

    public void setCouleurVelo(String couleurVelo) {
        this.couleurVelo = couleurVelo;
    }
    
    
    public String toString() {
      return couleurVelo; 
  }
}

