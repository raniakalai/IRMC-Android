package esprit.tn.irmc.model;

import java.util.Date;

public class Article {
    private Integer id;
    private String titre;
    private String Source;
    private String date;
    private Integer numero;
    private String pays;
    private String abstrait;
    private String date_ajout;
    private String file;

    public Article() {
    }

    public Article(Integer id, String titre, String date) {
        this.id = id;
        this.titre = titre;
        this.date = date;
    }

    public Article(Integer id, String titre, String source, String date, Integer numero, String pays, String abstrait, String date_ajout, String file) {
        this.id = id;
        this.titre = titre;
        Source = source;
        this.date = date;
        this.numero = numero;
        this.pays = pays;
        this.abstrait = abstrait;
        this.date_ajout = date_ajout;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAbstrait() {
        return abstrait;
    }

    public void setAbstrait(String abstrait) {
        this.abstrait = abstrait;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
