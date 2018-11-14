package esprit.tn.myapplication;

public class Center {

    private Integer center_id;
    private String center_name;
    private Activity_type activity_type;
    private Center_type center_type;
    private Center_internet_type center_internet;
    private Center_ville center_ville;
    private Center_pays center_pays;
    private String pays;
    private Center_pret center_pret;
    private String sigle;
    private String pic_url;
    private String facebook_url;
    private String catalogue_url;
    private String center_adresse;
    private long code_postale;
    private String center_webSite;
    private String center_mail;
    private String center_commentaire;
    private long date_update;
    private long date_add;
    private String center_schedule;
    String y;
    String x;

    public Center(Integer center_id, String center_name, Activity_type activity_type, Center_type center_type, Center_internet_type center_internet, Center_ville center_ville, Center_pays center_pays, String pays, Center_pret center_pret, String sigle, String pic_url, String facebook_url, String catalogue_url, String center_adresse, long code_postale, String center_webSite, String center_mail, String center_commentaire, long date_update, long date_add, String center_schedule, String y, String x) {
        this.center_id = center_id;
        this.center_name = center_name;
        this.activity_type = activity_type;
        this.center_type = center_type;
        this.center_internet = center_internet;
        this.center_ville = center_ville;
        this.center_pays = center_pays;
        this.pays = pays;
        this.center_pret = center_pret;
        this.sigle = sigle;
        this.pic_url = pic_url;
        this.facebook_url = facebook_url;
        this.catalogue_url = catalogue_url;
        this.center_adresse = center_adresse;
        this.code_postale = code_postale;
        this.center_webSite = center_webSite;
        this.center_mail = center_mail;
        this.center_commentaire = center_commentaire;
        this.date_update = date_update;
        this.date_add = date_add;
        this.center_schedule = center_schedule;
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Center{" +
                "center_id=" + center_id +
                ", center_name='" + center_name + '\'' +
                ", activity_type=" + activity_type +
                ", center_type=" + center_type +
                ", center_internet=" + center_internet +
                ", center_ville=" + center_ville +
                ", center_pays=" + center_pays +
                ", pays='" + pays + '\'' +
                ", center_pret=" + center_pret +
                ", sigle='" + sigle + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", facebook_url='" + facebook_url + '\'' +
                ", catalogue_url='" + catalogue_url + '\'' +
                ", center_adresse='" + center_adresse + '\'' +
                ", code_postale=" + code_postale +
                ", center_webSite='" + center_webSite + '\'' +
                ", center_mail='" + center_mail + '\'' +
                ", center_commentaire='" + center_commentaire + '\'' +
                ", date_update=" + date_update +
                ", date_add=" + date_add +
                ", center_schedule='" + center_schedule + '\'' +
                ", y='" + y + '\'' +
                ", x='" + x + '\'' +
                '}';
    }

    public Activity_type getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(Activity_type activity_type) {
        this.activity_type = activity_type;
    }

    public Center_type getCenter_type() {
        return center_type;
    }

    public void setCenter_type(Center_type center_type) {
        this.center_type = center_type;
    }

    public Center_internet_type getCenter_internet() {
        return center_internet;
    }

    public void setCenter_internet(Center_internet_type center_internet) {
        this.center_internet = center_internet;
    }

    public Center_ville getCenter_ville() {
        return center_ville;
    }

    public void setCenter_ville(Center_ville center_ville) {
        this.center_ville = center_ville;
    }

    public Center_pays getCenter_pays() {
        return center_pays;
    }

    public void setCenter_pays(Center_pays center_pays) {
        this.center_pays = center_pays;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Center(String center_name){
        this.center_name = center_name;
    }


    public Center(Integer center_id, String center_name, String sigle, String pic_url, String facebook_url, String catalogue_url, String center_adresse, long code_postale, String center_webSite, String center_mail, String center_commentaire, long date_update, long date_add, String center_schedule) {
        this.center_id = center_id;
        this.center_name = center_name;
        this.sigle = sigle;
        this.pic_url = pic_url;
        this.facebook_url = facebook_url;
        this.catalogue_url = catalogue_url;
        this.center_adresse = center_adresse;
        this.code_postale = code_postale;
        this.center_webSite = center_webSite;
        this.center_mail = center_mail;
        this.center_commentaire = center_commentaire;
        this.date_update = date_update;
        this.date_add = date_add;
        this.center_schedule = center_schedule;
    }


    public Center() {
    }


    public Integer getCenter_id() {
        return center_id;
    }

    public void setCenter_id(Integer center_id) {
        this.center_id = center_id;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public String getCatalogue_url() {
        return catalogue_url;
    }

    public void setCatalogue_url(String catalogue_url) {
        this.catalogue_url = catalogue_url;
    }

    public String getCenter_adresse() {
        return center_adresse;
    }

    public void setCenter_adresse(String center_adresse) {
        this.center_adresse = center_adresse;
    }

    public long getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(long code_postale) {
        this.code_postale = code_postale;
    }

    public String getCenter_webSite() {
        return center_webSite;
    }

    public void setCenter_webSite(String center_webSite) {
        this.center_webSite = center_webSite;
    }

    public String getCenter_mail() {
        return center_mail;
    }

    public void setCenter_mail(String center_mail) {
        this.center_mail = center_mail;
    }

    public String getCenter_commentaire() {
        return center_commentaire;
    }

    public void setCenter_commentaire(String center_commentaire) {
        this.center_commentaire = center_commentaire;
    }

    public long getDate_update() {
        return date_update;
    }

    public void setDate_update(long date_update) {
        this.date_update = date_update;
    }

    public long getDate_add() {
        return date_add;
    }

    public void setDate_add(long date_add) {
        this.date_add = date_add;
    }

    public String getCenter_schedule() {
        return center_schedule;
    }

    public esprit.tn.myapplication.Center_pret getCenter_pret() {
        return center_pret;
    }

    public void setCenter_schedule(String center_schedule) {
        this.center_schedule = center_schedule;

    }
    public void setCenter_pret(esprit.tn.myapplication.Center_pret center_pret) {
        center_pret = center_pret;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        pays = pays;
    }
}
