public class Child {
    private String name;
    private String dreamNightmare;
    private boolean hasHealingStone;

    public Child(String name, String dreamNightmare) {
        this.name = name;
        this.dreamNightmare = dreamNightmare;
        this.hasHealingStone = false;
    }

    public String getName() {
        return name;
    }

    public String getDreamNightmare() {
        return dreamNightmare;
    }

    public boolean hasHealingStone() {
        return hasHealingStone;
    }

    public void hideHealingStone() {
        hasHealingStone = true;
        System.out.println(name + " hides their healing stone.");
    }
}