import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    // Lijsten om alles bij te houden
    private static List<Personeel> personeelLijst = new ArrayList<>();
    private static List<Activiteit> activiteitLijst = new ArrayList<>();
    private static List<Tour> tourLijst = new ArrayList<>();
    private static List<Bezoeker> bezoekerLijst = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean doorgaan = true;
        while (doorgaan) {
            // Toon het menu
            System.out.println("\n--- Dierenpark Menu ---");
            System.out.println("1. Nieuw personeelslid toevoegen");
            System.out.println("2. Nieuwe activiteit toevoegen");
            System.out.println("3. Nieuwe tour toevoegen");
            System.out.println("4. Bezoeker registreren");
            System.out.println("5. Personeel aan activiteit toewijzen");
            System.out.println("6. Bezoeker inschrijven voor tour");
            System.out.println("7. Print bezoekerslijst van tour");
            System.out.println("0. Afsluiten");
            System.out.print("Kies een optie: ");
            String keuze = scanner.nextLine();

            // Gebruik if-else voor eenvoud
            if (keuze.equals("1")) {
                nieuwPersoneelslid(scanner);
            } else if (keuze.equals("2")) {
                nieuweActiviteit(scanner);
            } else if (keuze.equals("3")) {
                nieuweTour(scanner);
            } else if (keuze.equals("4")) {
                registreerBezoeker(scanner);
            } else if (keuze.equals("5")) {
                wijsPersoneelAanActiviteitToe(scanner);
            } else if (keuze.equals("6")) {
                inschrijvingBezoeker(scanner);
            } else if (keuze.equals("7")) {
                printTourInfo(scanner);
            } else if (keuze.equals("0")) {
                doorgaan = false;
                System.out.println("Programma afgesloten.");
            } else {
                System.out.println("Ongeldige keuze.");
            }
        }
        scanner.close();
    }

    // Personeelslid toevoegen
    private static void nieuwPersoneelslid(Scanner scanner) {
        System.out.print("Naam: ");
        String naam = scanner.nextLine();
        if (vindPersoneel(naam) != null) {
            System.out.println("Personeelslid bestaat al.");
            return;
        }
        System.out.print("Geboortedatum: ");
        String geboortedatum = scanner.nextLine();
        System.out.print("Adres: ");
        String adres = scanner.nextLine();
        System.out.print("Type (gids, verzorger, poetsploeg, anders): ");
        String typeStr = scanner.nextLine().toLowerCase();

        Personeel.PersoneelType type;
        try {
            type = Personeel.PersoneelType.valueOf(typeStr);
        } catch (Exception e) {
            type = Personeel.PersoneelType.anders;
        }

        Personeel personeel = new Personeel(naam, geboortedatum, adres, type);
        personeelLijst.add(personeel);
        System.out.println("Personeelslid toegevoegd.");
    }

    // Activiteit toevoegen
    private static void nieuweActiviteit(Scanner scanner) {
        System.out.print("Categorie: ");
        String categorie = scanner.nextLine();
        System.out.print("Naam: ");
        String naam = scanner.nextLine();
        if (vindActiviteit(naam) != null) {
            System.out.println("Activiteit bestaat al.");
            return;
        }
        System.out.print("Omschrijving: ");
        String omschrijving = scanner.nextLine();

        Activiteit activiteit = new Activiteit(categorie, naam, omschrijving);
        activiteitLijst.add(activiteit);
        System.out.println("Activiteit toegevoegd.");
    }

    // Tour toevoegen
    private static void nieuweTour(Scanner scanner) {
        System.out.print("Naam van de tour: ");
        String naam = scanner.nextLine();
        if (vindTour(naam) != null) {
            System.out.println("Tour bestaat al.");
            return;
        }
        System.out.print("Maximale capaciteit: ");
        int maxCap = Integer.parseInt(scanner.nextLine());

        System.out.println("Toegelaten leeftijden (gescheiden door komma, bv: min12,kind,volwassene,plus65): ");
        String leeftijdenStr = scanner.nextLine();
        Set<Bezoeker.leeftijdCategorie> leeftijden = new HashSet<>();
        for (String s : leeftijdenStr.split(",")) {
            try {
                leeftijden.add(Bezoeker.leeftijdCategorie.valueOf(s.trim()));
            } catch (Exception e) {
                System.out.println("Ongeldige leeftijdscategorie: " + s);
            }
        }

        Tour tour = new Tour(naam, leeftijden, maxCap);
        tourLijst.add(tour);
        System.out.println("Tour toegevoegd.");
    }

    // Bezoeker registreren
    private static void registreerBezoeker(Scanner scanner) {
        System.out.print("Naam: ");
        String naam = scanner.nextLine();
        System.out.print("Geboortedatum: ");
        String geboortedatum = scanner.nextLine();
        System.out.print("Adres: ");
        String adres = scanner.nextLine();
        System.out.print("Leeftijdscategorie (min12, kind, volwassene, plus65): ");
        String catStr = scanner.nextLine();

        Bezoeker.leeftijdCategorie cat;
        try {
            cat = Bezoeker.leeftijdCategorie.valueOf(catStr);
        } catch (Exception e) {
            cat = Bezoeker.leeftijdCategorie.volwassene;
        }

        Bezoeker bezoeker = new Bezoeker(naam, geboortedatum, adres, cat);
        bezoekerLijst.add(bezoeker);
        System.out.println("Bezoeker geregistreerd.");
    }

    // Personeel aan activiteit toewijzen
    private static void wijsPersoneelAanActiviteitToe(Scanner scanner) {
        if (activiteitLijst.isEmpty() || personeelLijst.isEmpty()) {
            System.out.println("Geen activiteiten of personeel beschikbaar.");
            return;
        }
        System.out.print("Naam van de activiteit: ");
        String activiteitNaam = scanner.nextLine();
        Activiteit activiteit = vindActiviteit(activiteitNaam);
        if (activiteit == null) {
            System.out.println("Activiteit niet gevonden.");
            return;
        }
        System.out.print("Naam van het personeelslid: ");
        String personeelNaam = scanner.nextLine();
        Personeel personeel = vindPersoneel(personeelNaam);
        if (personeel == null) {
            System.out.println("Personeelslid niet gevonden.");
            return;
        }
        if (activiteit.voegPersoneelToe(personeel)) {
            System.out.println("Personeel toegevoegd aan activiteit.");
        } else {
            System.out.println("Personeel was al toegevoegd aan deze activiteit.");
        }
    }

    // Bezoeker inschrijven voor tour
    private static void inschrijvingBezoeker(Scanner scanner) {
        if (tourLijst.isEmpty() || bezoekerLijst.isEmpty()) {
            System.out.println("Geen tours of bezoekers beschikbaar.");
            return;
        }
        System.out.print("Naam van de tour: ");
        String tourNaam = scanner.nextLine();
        Tour tour = vindTour(tourNaam);
        if (tour == null) {
            System.out.println("Tour niet gevonden.");
            return;
        }
        System.out.print("Naam van de bezoeker: ");
        String bezoekerNaam = scanner.nextLine();
        Bezoeker bezoeker = vindBezoeker(bezoekerNaam);
        if (bezoeker == null) {
            System.out.println("Bezoeker niet gevonden.");
            return;
        }
        if (tour.voegBezoekerToe(bezoeker)) {
            System.out.println("Bezoeker ingeschreven voor tour.");
        } else {
            System.out.println("Bezoeker kan niet worden ingeschreven.");
        }
    }

    // Print bezoekerslijst van tour naar bestand
    private static void printTourInfo(Scanner scanner) {
        if (tourLijst.isEmpty()) {
            System.out.println("Geen tours beschikbaar.");
            return;
        }
        System.out.print("Naam van de tour: ");
        String tourNaam = scanner.nextLine();
        Tour tour = vindTour(tourNaam);
        if (tour == null) {
            System.out.println("Tour niet gevonden.");
            return;
        }
        String bestandsnaam = tour.getNaam() + "_bezoekers.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(bestandsnaam))) {
            writer.println("Bezoekerslijst voor tour: " + tour.getNaam());
            for (Bezoeker bezoeker : tour.getBezoekerLijst()) {
                writer.println(bezoeker.getNaam() + " (" + bezoeker.getLeeftijdCategorie() + ")");
            }
            System.out.println("Bezoekerslijst opgeslagen in " + bestandsnaam);
        } catch (IOException e) {
            System.out.println("Fout bij opslaan bestand: " + e.getMessage());
        }
    }

    // Vind-methodes
    private static Activiteit vindActiviteit(String naam) {
        for (Activiteit a : activiteitLijst) {
            if (a.getNaam().equalsIgnoreCase(naam)) {
                return a;
            }
        }
        return null;
    }

    private static Tour vindTour(String naam) {
        for (Tour t : tourLijst) {
            if (t.getNaam().equalsIgnoreCase(naam)) {
                return t;
            }
        }
        return null;
    }

    private static Personeel vindPersoneel(String naam) {
        for (Personeel p : personeelLijst) {
            if (p.getNaam().equalsIgnoreCase(naam)) {
                return p;
            }
        }
        return null;
    }

    private static Bezoeker vindBezoeker(String naam) {
        for (Bezoeker b : bezoekerLijst) {
            if (b.getNaam().equalsIgnoreCase(naam)) {
                return b;
            }
        }
        return null;
    }
}