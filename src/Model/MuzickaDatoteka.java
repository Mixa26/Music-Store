package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MuzickaDatoteka {
    private String izvodjac;
    private String naslov;
    private int godinaProizvodnje;
    private NosacZvuka nosacZvuka;
    private Zanr zanr;
    private int cena;
    private Tip tip;
    private int komada;
    private int brkomada;
    private String artikal;

    public MuzickaDatoteka(String izvodjac, String naslov, int godinaProizvodnje, NosacZvuka nosacZvuka, Zanr zanr, int cena, Tip tip, int komada) {
        this.izvodjac = izvodjac;
        this.naslov = naslov;
        this.godinaProizvodnje = godinaProizvodnje;
        this.nosacZvuka = nosacZvuka;
        this.zanr = zanr;
        this.cena = cena;
        this.tip = tip;
        this.komada = komada;
        this.brkomada = 0;
        this.artikal = this.toString();
    }

    @Override
    public String toString()
    {
        if (komada == 1)
        {
            return izvodjac + " \"" + naslov + "\" " + godinaProizvodnje + " (" + tip.toString() + ") " + (double)cena + " din. " + nosacZvuka;
        }
        else
        {
            return izvodjac + " \"" + naslov + "\" " + godinaProizvodnje + " (" + tip.toString() + ") " + (double)cena + " din. " + komada + " " + nosacZvuka;
        }
    }

    public String toRacun()
    {
        int komadaCurrent = 1;
        if (komada > 1)
        {
            komadaCurrent = 2;
        }
        StringBuilder sb = new StringBuilder();
        String str1 = izvodjac + ", " + naslov + " (" + godinaProizvodnje + ") " + nosacZvuka + "-" + komadaCurrent + " " + tip;
        sb.append(str1);
        for (int i = 0; i < 76 - str1.length() - String.valueOf(cena).length() - 2; i++)
        {
            sb.append("_");
        }
        sb.append(String.valueOf(cena) + ".0");

        return sb.toString();
    }

    public Zanr getZanr() {
        return zanr;
    }

    public Tip getTip() {
        return tip;
    }

    public int getCena() {
        return cena;
    }

    public void setBrkomada(int brkomada) {
        this.brkomada = brkomada;
    }

    public int getBrkomada() {
        return brkomada;
    }

    public String getArtikal() {
        return artikal;
    }

    public int getKomada() {
        return komada;
    }
}
