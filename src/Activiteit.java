import java.util.Objects;

public class Activiteit {
    private String catergorie;
    private String Naam;
    private String omschrijving;

    public Activiteit(String catergorie, String Naam, String omschrijving) {
        this.catergorie = catergorie;
        this.Naam = Naam;
        this.omschrijving = omschrijving;
    }
    public String getCatergorie() {
        return catergorie;
    }
    public void setCatergorie(String catergorie) {
        this.catergorie = catergorie;
    }
    public String getNaam() {
        return Naam;
    }
    public void setNaam(String Naam) {
        this.Naam = Naam;
    }
    public String getOmschrijving() {
        return omschrijving;
    }
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activiteit)) return false;
        Activiteit other = (Activiteit) o;
        return catergorie.equals(other.catergorie) && Naam.equals(other.Naam);
    }
    @Override
    public int hashCode() {
        return catergorie.hashCode() + Naam.hashCode();
    }
}
