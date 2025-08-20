
import java.util.HashSet;
import java.util.Set;
public class Zone {
    private int MaxCapaciteit;
    private Set<Activiteit> activiteiten = new HashSet<>();

    public Zone(int maxCapaciteit) {
        this.MaxCapaciteit = maxCapaciteit;
    }
    public boolean voegActiviteitToe(Activiteit activiteit) {
        if (activiteiten.size() < MaxCapaciteit) {
            return activiteiten.add(activiteit);
        }
        return false; // Zone is vol
    }
    public int getMaxCapaciteit() {
        return MaxCapaciteit;
    }
    public void setMaxCapaciteit(int maxCapaciteit) {
        this.MaxCapaciteit = maxCapaciteit;
    }
    public Set<Activiteit> getActiviteiten() {
        return activiteiten;
    }

}
