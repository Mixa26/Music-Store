package Controller;

import Model.MuzickaDatoteka;
import Model.Tip;
import View.MainWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.awt.*;

public class MainWindowAddController implements EventHandler<ActionEvent> {
    private MainWindow mainWindow;

    public MainWindowAddController(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    @Override
    public void handle(ActionEvent event) {
        ObservableList<MuzickaDatoteka> observableList = mainWindow.getDesni().getSelectionModel().getSelectedItems();
        int kolicina = Integer.parseInt(mainWindow.getPadajuciMeni().getSelectionModel().getSelectedItem().toString());
        observableList.forEach(muzickaDatoteka -> { if(muzickaDatoteka.getTip() != Tip.polovna && muzickaDatoteka.getKomada() != 1)
                                                    {
                                                        muzickaDatoteka.setBrkomada(muzickaDatoteka.getBrkomada() + kolicina);
                                                    }
                                                    else
                                                    {
                                                        muzickaDatoteka.setBrkomada(1);
                                                    }});

        int cijena = 0;

        for (MuzickaDatoteka datoteka : observableList)
        {
            if (!mainWindow.getDonji().getItems().contains(datoteka))
            {
                mainWindow.getDonji().getItems().add(datoteka);
            }

        }

        for (MuzickaDatoteka muzickaDatoteka : mainWindow.getDonji().getItems())
        {
            cijena += muzickaDatoteka.getCena() * muzickaDatoteka.getBrkomada();
        }

        mainWindow.getCenaUkupno().setText(String.valueOf(cijena));

        mainWindow.getDonji().refresh();
    }
}
