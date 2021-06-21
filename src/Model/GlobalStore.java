package Model;

public class GlobalStore {
    private User currentlyLogedIn;

    private static GlobalStore instance = null;

    static
    {
        instance = new GlobalStore();
    }

    private GlobalStore()
    {

    }

    public static GlobalStore getInstance() {
        return instance;
    }

    public void setCurrentlyLogedIn(User currentlyLogedIn) {
        this.currentlyLogedIn = currentlyLogedIn;
    }
}
