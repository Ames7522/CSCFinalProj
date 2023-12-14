public class player {
    
    private String name;
    private boolean isDiscovered;

    public player(String name) {
        this.name = name;
        this.isDiscovered = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void discover() {
        isDiscovered = true;
        System.out.println("You have been discovered! The children notice your presence.");
    }
}