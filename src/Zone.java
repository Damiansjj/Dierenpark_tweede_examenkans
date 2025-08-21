import java.util.HashSet;
import java.util.Set;
public class Zone {
    private int maxCapaciteit;
    private Set<Activiteit> activiteiten = new HashSet<>();

    public Zone(int maxCapaciteit) {
        this.maxCapaciteit = maxCapaciteit;
    }
    public boolean voegActiviteitToe(Activiteit activiteit) {
        if (activiteiten.size() < maxCapaciteit) {
            return activiteiten.add(activiteit);
        }
        return false; // Zone is vol
    }
    public int getMaxCapaciteit() {
        return maxCapaciteit;
    }
    public void setMaxCapaciteit(int maxCapaciteit) {
        this.maxCapaciteit = maxCapaciteit;
    }
    public Set<Activiteit> getActiviteiten() {
        return activiteiten;
    }
}
