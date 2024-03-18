package application;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class SampleController {

	@FXML
    public void initialize() throws IOException {
		LocalDate currentDate = LocalDate.now();
		// Define a custom date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convert LocalDate to String
        String dateAsString = currentDate.format(formatter);
		currentdate.setText(dateAsString);
		//----------------------------------------------------------------

        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        lastModifiedCol.setCellValueFactory(new PropertyValueFactory<>("lastModified"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("Satut"));

        // Add columns to the table view
//        contrattableview.getColumns().addAll(fileNameCol2, lastModifiedCol2);

        // Create a list of FileInfo objects by listing files in a directory
//        File folder = new File("C:\\Users\\taouf\\Documents\\ContratsMariage");
//        File[] files = folder.listFiles();
//        List<FileInfo> fileInfoList = new ArrayList<>();
//
//        if (files != null) {
//            for (File file : files) {
//                if (file.isFile() && file.getName().contains(".pdf")) {
//                    FileInfo fileInfo = new FileInfo(file);
//                    fileInfoList.add(fileInfo);
//                }
//            }
//        }
//
//        // Add the file information to the table view
//        contrattableview.getItems().addAll(fileInfoList);

        tabpane.getSelectionModel().select(2);
		voletInfos.setText("Nouveau Contrats");
	}

	@FXML
    void contratTab(ActionEvent event) {
		tabpane.getSelectionModel().select(2);
		voletInfos.setText("Nouveau Contrats");
		refreshcontratList();

    }

	@FXML
    private TextField ACCOMPTTTC;

    @FXML
    private TextField DATEMARIAGE;

    @FXML
    private TextField PRIXTTC;

    @FXML
    private TextField adresseMr;

    @FXML
    private TextField adresseMr1;

    @FXML
    private TextField adressemail;

    @FXML
    private TableView<FileInfo> contrattableview;

    @FXML
    private Label currentdate;

    @FXML
    private TextField datenaissanceMr;

    @FXML
    private TextField datenaissanceMr1;

    @FXML
    private TableColumn<FileInfo, String> fileNameCol;

    @FXML
    private TableColumn<FileInfo, Date> lastModifiedCol;

    @FXML
    private TableColumn<FileInfo, String> statusCol;

    @FXML
    private TextField lieunaissanceMr;

    @FXML
    private TextField lieunaissanceMr1;

    @FXML
    private HBox loading;

    @FXML
    private Label loadingText;

    @FXML
    private TextField nomMr;

    @FXML
    private TextField nomMr2;

    @FXML
    private TextField prenomMr;

    @FXML
    private TextField prenomMr1;

    @FXML
    private TextField recherche;

    @FXML
    private TabPane tabpane;

    @FXML
    private Label voletInfos;


    @FXML
    void EnregistrerContrat(ActionEvent event) {

//    	loading.setOpacity(0);;
    	System.out.println("setvisible");


    	String[] search = {"nameMr","PrenomMr","datenaissanceMr","lieunaissanceMr","adresseMr","DATEMARIAGE","ACCOMPTTTC","PRIXTTC"};
    	String[] replace = {nomMr.getText(),prenomMr.getText(),datenaissanceMr.getText(),lieunaissanceMr.getText(),adresseMr.getText(),DATEMARIAGE.getText(),ACCOMPTTTC.getText(),PRIXTTC.getText()};
    	String[] searchMm = {"nameMm","PrenomMm","datenaissanceMm","lieunaissanceMm","adresseMm"};
    	String[] replaceMm = {nomMr2.getText(),prenomMr1.getText(),datenaissanceMr1.getText(),lieunaissanceMr1.getText(),adresseMr1.getText()};
//    	loading.setVisible(true);
//    	WordEditor.editWordDocument("C:\\Users\\taouf\\Documents\\Contrat_photo_Template.docx", "C:\\Users\\taouf\\Documents\\contrat_prestation_photographie_"+nomMr.getText(), "nomMr", nomMr.getText(), "prenomMr", prenomMr.getText());
    	WordEditor.editWordDocument("C:\\Users\\taouf\\Documents\\ContratsMariage\\Contrat_photo_Template.docx", "C:\\Users\\taouf\\Documents\\ContratsMariage\\contrat_prestation_photographie_"+nomMr.getText()+"_"+nomMr2.getText(),search,replace,searchMm,replaceMm );
//    	loading.setVisible(false);
    }

    @FXML
    void refresh(ActionEvent event) {
    	refreshcontratList();
    }

    void refreshcontratList(){
    	contrattableview.getItems().clear();
    	File folder = new File("C:\\Users\\taouf\\Documents\\ContratsMariage");
        File[] files = folder.listFiles();
        List<FileInfo> fileInfoList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains(".pdf")) {
                    FileInfo fileInfo = new FileInfo(file);
                    fileInfoList.add(fileInfo);
                }
            }
        }

        // Add the file information to the table view
        contrattableview.getItems().addAll(fileInfoList);
    }

    @FXML
    void NouvelleEntree(ActionEvent event) {
    	tabpane.getSelectionModel().select(0);
		voletInfos.setText("Nouveau Contrats");
    }


}
