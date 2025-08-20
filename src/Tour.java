
import java.util.*;
public class Tour {
    private String Naam;
    private Set<Bezoeker.leeftijdCategorie> toegelatenLeeftijden;
    private List<Personeel> personeelLijst = new ArrayList<>();
    private List<Bezoeker> bezoekerLijst = new ArrayList<>();
    private int maxCapaciteit;

    public Tour(String Naam, Set<Bezoeker.leeftijdCategorie> toegelatenLeeftijden, int maxCapaciteit) {
        this.Naam = Naam;
        this.toegelatenLeeftijden = toegelatenLeeftijden;
        this.maxCapaciteit = maxCapaciteit;
    }

    public boolean voegPersoneelToe(Personeel personeel) {
        if (!personeelLijst.contains(personeel)) {
            personeelLijst.add(personeel);
            return true;
        }
        return false;
    }

    public boolean voegBezoekerToe(Bezoeker bezoeker) {
        if (bezoekerLijst.size() < maxCapaciteit &&
                toegelatenLeeftijden.contains(bezoeker.getLeeftijdCategorie())) {
            bezoekerLijst.add(bezoeker);
            return true;
        }
        return false;
    }

    public List<Bezoeker> getBezoekerLijst() {
        return bezoekerLijst;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public Set<Bezoeker.leeftijdCategorie> getToegelatenLeeftijden() {
        return toegelatenLeeftijden;
    }

    public void setToegelatenLeeftijden(Set<Bezoeker.leeftijdCategorie> toegelatenLeeftijden) {
        this.toegelatenLeeftijden = toegelatenLeeftijden;
    }

    public List<Personeel> getPersoneelLijst() {
        return personeelLijst;
    }

    public int getMaxCapaciteit() {
        return maxCapaciteit;
    }

    public void setMaxCapaciteit(int maxCapaciteit) {
        this.maxCapaciteit = maxCapaciteit;
    }
}
