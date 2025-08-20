public class Personeel extends Persoon{
    public enum PersoneelType { GIDS, VERZORGER, POETSPLOEG, ANDERS }
    private PersoneelType personeelType;

    public Personeel(String naam, String geboortedatum, String adres, PersoneelType personeelType) {
        super(naam, geboortedatum, adres);
        this.personeelType = personeelType;
    }

    public PersoneelType getPersoneelType() {
        return personeelType;
    }

    public void setPersoneelType(PersoneelType personeelType) {
        this.personeelType = personeelType;
    }
}


