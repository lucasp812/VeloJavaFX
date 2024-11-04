package application;

public class Personnalisation extends Option {

    private String personnalisationClient;

    public Personnalisation(String nomOption, int prixOption, String personnalisationClient) {
        super(nomOption, prixOption);
        this.personnalisationClient = personnalisationClient;
    }

    // Getter et Setter pour personnalisationClient
    public String getPersonnalisationClient() {
        return personnalisationClient;
    }

    public void setPersonnalisationClient(String personnalisationClient) {
        this.personnalisationClient = personnalisationClient;
    }
}
