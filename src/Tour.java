import java.util.*;
public class Tour {
    private String naam;
    private Set<Bezoeker.leeftijdCategorie> toegelatenLeeftijden;
    private List<Bezoeker> bezoekerLijst = new ArrayList<>();
    private int maxCapaciteit;

    public Tour(String naam, Set<Bezoeker.leeftijdCategorie> toegelatenLeeftijden, int maxCapaciteit) {
        this.naam = naam;
        this.toegelatenLeeftijden = toegelatenLeeftijden;
        this.maxCapaciteit = maxCapaciteit;
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
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Set<Bezoeker.leeftijdCategorie> getToegelatenLeeftijden() {
        return toegelatenLeeftijden;
    }

    public void setToegelatenLeeftijden(Set<Bezoeker.leeftijdCategorie> toegelatenLeeftijden) {
        this.toegelatenLeeftijden = toegelatenLeeftijden;
    }

    public int getMaxCapaciteit() {
        return maxCapaciteit;
    }

    public void setMaxCapaciteit(int maxCapaciteit) {
        this.maxCapaciteit = maxCapaciteit;
    }
}