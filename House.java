import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Child> children;

    public House(List<Child> children) {
        this.children = children;
    }

    public List<Child> getChildren() {
        return children;
    }

    public boolean hasHealingStones() {
        for (Child child : children) {
            if (!child.hasHealingStone()) {
                return false;
            }
        }
        return true;
    }
}