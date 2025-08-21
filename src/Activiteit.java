import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Activiteit {
    private String catergorie;
    private String naam;
    private String omschrijving;
    private List<Personeel> personeelLijst = new ArrayList<>();

    public Activiteit(String catergorie, String naam, String omschrijving) {
        this.catergorie = catergorie;
        this.naam = naam;
        this.omschrijving = omschrijving;
    }
    public String getCatergorie() {
        return catergorie;
    }
    public void setCatergorie(String catergorie) {
        this.catergorie = catergorie;
    }
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getOmschrijving() {
        return omschrijving;
    }
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    public boolean voegPersoneelToe(Personeel personeel) {
        if (!personeelLijst.contains(personeel)) {
            personeelLijst.add(personeel);
            return true;
        }
        return false;
    }

    public List<Personeel> getPersoneelLijst() {
        return personeelLijst;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activiteit)) return false;
        Activiteit other = (Activiteit) o;
        return catergorie.equals(other.catergorie) && naam.equals(other.naam);
    }
    @Override
    public int hashCode() {
        return catergorie.hashCode() + naam.hashCode();
    }
}
