package Model;

public class Statistika {
    private Zanr zanr;
    private int nove;
    private int polovne;

    public Statistika(Zanr zanr, int nove, int polovne) {
        this.zanr = zanr;
        this.nove = nove;
        this.polovne = polovne;
    }

    static MuzickaRadnja muzickaRadnja = MuzickaRadnja.getInstance();

    public static int calc(Zanr zanr, Tip tip)
    {
        int count = 0;
        for (MuzickaDatoteka muzickaDatoteka : muzickaRadnja.getMuzickeDatoteke())
        {
            if (muzickaDatoteka.getZanr() == zanr && muzickaDatoteka.getTip() == tip)
            {
                count++;
            }
        }

        return count;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public int getNove() {
        return nove;
    }

    public int getPolovne() {
        return polovne;
    }
}
