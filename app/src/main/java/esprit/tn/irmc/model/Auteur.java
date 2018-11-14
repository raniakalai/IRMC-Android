package esprit.tn.irmc.model;

public class Auteur {
    private Integer id;
    private String nom;
    private String universite;
    private String departement;
    private String bio;

    public Auteur(Integer id, String nom, String universite, String departement, String bio) {
        this.id = id;
        this.nom = nom;
        this.universite = universite;
        this.departement = departement;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
