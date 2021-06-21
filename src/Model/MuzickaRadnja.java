package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MuzickaRadnja {
    private static MuzickaRadnja instance = null;

    static
    {
        instance = new MuzickaRadnja();
    }

    private MuzickaRadnja()
    {
        loadContents();
    }

    public static MuzickaRadnja getInstance() {
        return instance;
    }

    private List<MuzickaDatoteka> muzickeDatoteke = new ArrayList<MuzickaDatoteka>();

    private void loadContents()
    {
        try
        {
            File file = new File("katalog.txt");
            Scanner scanner = new Scanner(file);

            String line;
            String[] args;
            String[] arg3;
            NosacZvuka nosacZvuka;
            int kolicina = 1;

            while (scanner.hasNextLine())
            {
                line = scanner.nextLine();
                args = line.split(",");

                if (args[3].contains("-"))
                {
                    arg3 = args[3].split("-");
                    nosacZvuka = NosacZvuka.valueOf(arg3[0]);
                    kolicina = Integer.parseInt(arg3[1]);
                }
                else
                {
                    nosacZvuka = NosacZvuka.valueOf(args[3]);
                }

                if (args[4].equalsIgnoreCase("Hip hop"))
                {
                    args[4] = "Hiphop";
                }

                muzickeDatoteke.add(new MuzickaDatoteka(args[0], args[1], Integer.parseInt(args[2]), nosacZvuka, Zanr.valueOf(args[4]), Integer.parseInt(args[5]), Tip.valueOf(args[6]), kolicina));
                kolicina = 1;
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public List<MuzickaDatoteka> getMuzickeDatoteke() {
        return muzickeDatoteke;
    }
}
