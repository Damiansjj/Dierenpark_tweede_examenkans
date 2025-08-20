public class Bezoeker extends Persoon{
    public enum leeftijdCategorie { min12, kind, volwassene, plus65 }
    private leeftijdCategorie leeftijdCategorie;

    public Bezoeker(String naam, String geboortedatum, String adres, leeftijdCategorie leeftijdCategorie) {
        super(naam, geboortedatum, adres);
        this.leeftijdCategorie = leeftijdCategorie;
    }
    public leeftijdCategorie getLeeftijdCategorie() {
        return leeftijdCategorie;
    }
    public void setLeeftijdCategorie(leeftijdCategorie leeftijdCategorie) {
        this.leeftijdCategorie = leeftijdCategorie;
    }

}
