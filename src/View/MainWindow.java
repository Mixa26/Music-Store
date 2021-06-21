package View;

import Controller.MainWindowAddController;
import Controller.MainWindowPrintRacunController;
import Controller.MainWindowSortController;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MainWindow extends VBox {
    private static MainWindow instance = null;

    static
    {
        instance = new MainWindow();
    }

    public static MainWindow getInstance()
    {
        return instance;
    }

    MuzickaRadnja muzickaRadnja = MuzickaRadnja.getInstance();

    HBox gornji;

    TableView<Statistika> gornjaLeva;

    VBox sredina;

    HBox goreRadio;
    RadioButton nove;
    RadioButton polovne;
    RadioButton sve;
    ToggleGroup toggle;
    Button prikazi;

    VBox desno;
    ListView<MuzickaDatoteka> desni;
    List<MuzickaDatoteka> desniB;
    List<MuzickaDatoteka> backup;

    HBox gornjiMali;
    Label kolicina;
    ComboBox<Integer> padajuciMeni;
    Button dodajUKorpu;

    //donji deo ekrana
    Label sadrzajKorpe;

    TableView<MuzickaDatoteka> donji;

    HBox donjiMali;

    Label ukupno;
    Label cenaUkupno;
    Button stampajRacun;

    private MainWindow()
    {
        init();
        addElements();
        initListeners();
    }

    public void init()
    {
        gornji = new HBox();

        gornjaLeva = new TableView<>();

           TableColumn<Statistika, Zanr> tcZanr = new TableColumn<>("Zanr");
           tcZanr.setCellValueFactory(new PropertyValueFactory<>("zanr"));
           TableColumn<Statistika, Integer> tcNove = new TableColumn<>("Nove");
           tcNove.setCellValueFactory(new PropertyValueFactory<>("nove"));
           TableColumn<Statistika, Integer> tcPolovne = new TableColumn<>("Polovne");
           tcPolovne.setCellValueFactory(new PropertyValueFactory<>("polovne"));

           gornjaLeva.getColumns().addAll(tcZanr, tcNove, tcPolovne);

           for (Zanr zanr : Zanr.values())
           {
               gornjaLeva.getItems().add(new Statistika(zanr, Statistika.calc(zanr, Tip.nova), Statistika.calc(zanr, Tip.polovna)));
           }

        sredina = new VBox();

        goreRadio = new HBox();
        nove = new RadioButton("nove");
        polovne = new RadioButton("polovne");
        sve = new RadioButton("sve");
        toggle = new ToggleGroup();
        toggle.getToggles().addAll(nove, polovne, sve);
        toggle.getToggles().get(2).setSelected(true);
        prikazi = new Button("Prikaži");

        desno = new VBox();
        desni = new ListView<>();
        desniB = new ArrayList<MuzickaDatoteka>();
        backup = new ArrayList<>();

        desniB.addAll(muzickaRadnja.getMuzickeDatoteke());
        backup.addAll(muzickaRadnja.getMuzickeDatoteke());
        desni.getItems().addAll(desniB);

        gornjiMali = new HBox();
        kolicina = new Label("Količina");
        padajuciMeni = new ComboBox<>();

        for (int i = 1; i <= 10; i++)
        {
            padajuciMeni.getItems().addAll(i);
        }

        padajuciMeni.getSelectionModel().selectFirst();

        dodajUKorpu = new Button("Dodaj u korpu");

        //donji deo ekrana
        sadrzajKorpe = new Label("Sadržaj korpe");

        donji = new TableView<>();

        TableColumn<MuzickaDatoteka, String> tcArtikal = new TableColumn<>("Artikal");
        tcArtikal.setCellValueFactory(new PropertyValueFactory<>("artikal"));
        TableColumn<MuzickaDatoteka, Integer> tcBrojKomada = new TableColumn<>("Broj komada");
        tcBrojKomada.setCellValueFactory(new PropertyValueFactory<>("brkomada"));
        TableColumn<MuzickaDatoteka, Double> tcCena = new TableColumn<>("Cena");
        tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        tcArtikal.setPrefWidth(500);
        tcBrojKomada.setPrefWidth(200);

        donji.getColumns().addAll(tcArtikal, tcBrojKomada, tcCena);

        donjiMali = new HBox();

        ukupno = new Label("Ukupno");
        cenaUkupno = new Label("0.000");
        stampajRacun = new Button("Stampaj račun");
    }

    public void addElements()
    {
        donjiMali.getChildren().addAll(ukupno, cenaUkupno, stampajRacun);

        gornjiMali.getChildren().addAll(kolicina, padajuciMeni, dodajUKorpu);

        desni.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        desno.getChildren().addAll(desni, gornjiMali);

        goreRadio.getChildren().addAll(nove, polovne, sve);

        sredina.getChildren().addAll(goreRadio, prikazi);

        gornji.getChildren().addAll(gornjaLeva, sredina, desno);

        this.getChildren().addAll(gornji, sadrzajKorpe, donji, donjiMali);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        goreRadio.setSpacing(10);

        sredina.setAlignment(Pos.CENTER);
        sredina.setPadding(new Insets(50));
        sredina.setSpacing(10);

        desni.setPrefWidth(450);

        gornjiMali.setSpacing(5);

        donjiMali.setAlignment(Pos.CENTER);
        donjiMali.setSpacing(10);
    }

    public void initListeners()
    {
        prikazi.setOnAction(new MainWindowSortController(this));
        dodajUKorpu.setOnAction(new MainWindowAddController(this));
        stampajRacun.setOnAction(new MainWindowPrintRacunController(this));
    }

    public Scene makeScene()
    {
        return new Scene(this, 1000, 600);
    }

    public TableView<Statistika> getGornjaLeva() {
        return gornjaLeva;
    }

    public ToggleGroup getToggle() {
        return toggle;
    }

    public List<MuzickaDatoteka> getBackup() {
        return backup;
    }

    public List<MuzickaDatoteka> getDesniB() {
        return desniB;
    }

    public RadioButton getNove() {
        return nove;
    }

    public RadioButton getPolovne() {
        return polovne;
    }

    public RadioButton getSve() {
        return sve;
    }

    public ListView<MuzickaDatoteka> getDesni() {
        return desni;
    }

    public ComboBox<Integer> getPadajuciMeni() {
        return padajuciMeni;
    }

    public TableView<MuzickaDatoteka> getDonji() {
        return donji;
    }

    public Label getCenaUkupno() {
        return cenaUkupno;
    }


}
