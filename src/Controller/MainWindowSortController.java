package Controller;

import Model.MuzickaDatoteka;
import Model.Tip;
import View.MainWindow;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TablePosition;

import java.util.List;
import java.util.stream.Collectors;

public class MainWindowSortController implements EventHandler<ActionEvent> {
    private MainWindow mainWindow;
    
    public MainWindowSortController(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    @Override
    public void handle(ActionEvent event) {
        if (mainWindow.getGornjaLeva().getSelectionModel().getSelectedItem() != null) {
            List<MuzickaDatoteka> list = mainWindow.getDesniB()
                    .stream()
                    .filter(artikal ->
                            {
                                if (mainWindow.getToggle().getSelectedToggle() == mainWindow.getSve())
                                {
                                    return true;
                                }
                                if (mainWindow.getToggle().getSelectedToggle() == mainWindow.getNove())
                                {
                                    return artikal.getTip() == Tip.nova;
                                }
                                else if (mainWindow.getToggle().getSelectedToggle() == mainWindow.getPolovne())
                                {
                                    return artikal.getTip() == Tip.polovna;
                                }
                                return false;
                            }
                    )
                    .filter(artikal ->
                            artikal.getZanr().equals(mainWindow.getGornjaLeva().getSelectionModel().getSelectedItem().getZanr())
                            )
                    .collect(Collectors.toList());

            mainWindow.getDesni().getItems().clear();
            mainWindow.getDesni().getItems().addAll(list);
        }
        else
        {
            List<MuzickaDatoteka> list = mainWindow.getDesniB()
                    .stream()
                    .filter(artikal ->
                            {
                                if (mainWindow.getToggle().getSelectedToggle() == mainWindow.getSve())
                                {
                                    return true;
                                }
                                if (mainWindow.getToggle().getSelectedToggle() == mainWindow.getNove())
                                {
                                    return artikal.getTip() == Tip.nova;
                                }
                                else if (mainWindow.getToggle().getSelectedToggle() == mainWindow.getPolovne())
                                {
                                    return artikal.getTip() == Tip.polovna;
                                }
                                return false;
                            }
                    )
                    .collect(Collectors.toList());
            mainWindow.getDesni().getItems().clear();
            mainWindow.getDesni().getItems().addAll(list);
        }
    }
}
