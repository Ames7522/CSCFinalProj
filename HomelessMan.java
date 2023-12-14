public class HomelessMan {
    private boolean isAwake;
    private boolean isWalking;

    public HomelessMan() {
        this.isAwake = false;
        this.isWalking = false;
    }

    public void wakeUp() {
        isAwake = true;
        System.out.println("The homeless man wakes up.");
    }

    public void startWalking() {
        isWalking = true;
        System.out.println("The homeless man starts walking through the streets of Quito.");
    }

    public boolean isWalking() {
        return isWalking;
    }
}