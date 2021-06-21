package Controller;


import Model.MuzickaDatoteka;
import View.MainWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWindowPrintRacunController implements EventHandler<ActionEvent> {
    private MainWindow mainWindow;

    public MainWindowPrintRacunController(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    @Override
    public void handle(ActionEvent event) {
        try
        {
            File file = new File("racun1.txt");
            FileWriter fw = new FileWriter(file);
            for (MuzickaDatoteka muzickaDatoteka : mainWindow.getDonji().getItems())
            {
                fw.append(muzickaDatoteka.toRacun());
                fw.append("\n");
            }
            fw.append("Ukupno: " + mainWindow.getCenaUkupno().getText() + ".0");
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
