public abstract class Persoon {
    String naam;
    String geboortedatum;
    String adres;

    public Persoon(String naam, String geboortedatum, String adres) {
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}

