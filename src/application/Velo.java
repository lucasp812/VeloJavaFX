package application;

public class Velo {
  
  private String type; 
  private int PrixVelo;
  
  
  public int getPrixVelo() {
    return PrixVelo;
  }
  public void setPrixVelo(int prixVelo) {
    PrixVelo = prixVelo;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  
  public Velo(String type, int prixVelo) {
    super();
    this.type = type;
    PrixVelo = prixVelo;
  }
  
  
  
  
  

}
