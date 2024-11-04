package application;

public class Option  {
  
  private String nomOption;
  private int prixOption;

  public String getNomOption() {
    return nomOption;
  }

  public void setNomOption(String nomOption) {
    this.nomOption = nomOption;
  }

  public Option(String type, int prixVelo, String nomOption) {
    this.nomOption = nomOption;
  }

  public int getPrixOption() {
    return prixOption;
  }

  public void setPrixOption(int prixOption) {
    this.prixOption = prixOption;
  }

  public Option(String nomOption, int prixOption) {
    this.nomOption = nomOption;
    this.prixOption = prixOption;
  }




 
  
  

}
