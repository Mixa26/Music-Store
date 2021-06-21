package Model;

public enum Zanr {
    Hiphop,
    Rock,
    Jazz,
    Classical,
    Blues;

    @Override
    public String toString() {
        if (this == Zanr.Hiphop)
        {
            return "Hip hop";
        }
        else
        {
            return super.toString();
        }
    }
}
