package com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SimpleTextEditor extends Application{
	
	private TextArea textArea;
	
	private Stage stage;
	private String url;
	private String loadedContent = new String();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		// User Interface
		// Texteditor
		textArea = new TextArea();
		AnchorPane root = new AnchorPane(textArea);
		textArea.setPrefWidth(600);
		textArea.setPrefHeight(400);
		textArea.setLayoutY(27);
		
		// Menüleiste
		MenuBar menuBar = new MenuBar();
		menuBar.setPrefWidth(600);
		root.getChildren().add(menuBar);
		
		// Menüs
		Menu menuFile = new Menu("Datei");
		menuBar.getMenus().add(menuFile);
		Menu menuEdit = new Menu("Bearbeiten");
		menuBar.getMenus().add(menuEdit);
		Menu menuHelp = new Menu("Hilfe");
		menuBar.getMenus().add(menuHelp);
		
		// Menüpunkte
		// Datei			
		
		MenuItem miNew = new MenuItem("Neu");
		miNew.setOnAction(e->{this.fileNew();});	
		
		MenuItem miOpen = new MenuItem("Öffnen");
		miOpen.setOnAction(e->{this.fileOpen();});
		
		MenuItem miSave = new MenuItem("Speichern");
		miSave.setOnAction(e->{this.fileSave();});
		
		MenuItem miSaveAs = new MenuItem("Speichern unter");
		miSaveAs.setOnAction(e->{this.fileSaveAs();});
		
		MenuItem miQuit = new MenuItem("Beenden");
		miQuit.setOnAction(e->{this.fileQuit();});
		
		menuFile.getItems().addAll(miNew, miOpen, miSave, miSaveAs, miQuit);
		
		// Bearbeiten
		
		MenuItem miUndo = new MenuItem("Rückgängig");
		miUndo.setOnAction(e->{this.editUndo();});	
		
		MenuItem miCut = new MenuItem("Ausschneiden");
		miCut.setOnAction(e->{this.editCut();});
		
		MenuItem miCopy = new MenuItem("Kopieren");
		miCopy.setOnAction(e->{this.editCopy();});
		
		MenuItem miPaste = new MenuItem("Einfügen");
		miPaste.setOnAction(e->{this.editPaste();});
		
		MenuItem miDelete = new MenuItem("Löschen");
		miDelete.setOnAction(e->{this.editDelete();});
		
		menuEdit.getItems().addAll(miUndo, miCut, miCopy, miPaste, miDelete);
			
		 
		// Hilfe
		MenuItem miInfo = new MenuItem("Info");
		miInfo.setOnAction(e->{this.helpInfo();});	
		menuHelp.getItems().add(miInfo);
		
		// 
		primaryStage.setTitle("Einfacher Texteditor");
	    primaryStage.setScene(new Scene(root, 600, 400));
	    primaryStage.show();		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// Events des Datei-Menüs:
	
	public void fileNew() {
		System.out.println("fileNew");
		checkChanges(textArea);
		textArea.setText("");
		loadedContent = "";
	}
	
	public void fileOpen() {
		System.out.println("fileOpen");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Datei öffnen");
		File file = fileChooser.showOpenDialog(stage);
			
		if(file == null)
			return;
		// Pfad und Dateiname speichern
		url = file.toString();
		byte[] buffer = new byte[ (int) file.length() ];
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in.read( buffer );
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content = new String(buffer);
		textArea.setText(content);
		loadedContent = content;
	}
	
	public void fileSave() {		
		System.out.println("fileSave");
		if(url == null) {
			saveFileAs();
			return;
		}
		File file = new File(url);
		saveFile(file);		
	}
	
	public void fileSaveAs() {
		System.out.println("fileSaveAs");
		saveFileAs();
		
		
	}
	
	public void fileQuit() {
		System.out.println("fileQuit");
		checkChanges(textArea);					
		Platform.exit();
	}
	
	// Events des Bearbeiten-Menüs

	// Gute Anregungen dazu kamen von:
	// http://bekwam.blogspot.de/2014/10/cut-copy-and-paste-from-javafx-menubar.html
	
	
	public void editUndo() {
		System.out.println("editUndo");
		textArea.undo();		
	}
	
	public void editCut() {
		System.out.println("editCut");
		copyToClipboard();
		textArea.replaceSelection("");
		
		
	}
	
	public void editCopy() {
		System.out.println("editCopy");
		copyToClipboard();
	}
	
	public void editPaste() {
		System.out.println("editPaste");
		
		// Prüfen, ob etwas in der Zwischenablage ist
		if( !Clipboard.getSystemClipboard().hasContent(DataFormat.PLAIN_TEXT) ) 			   
			return; // falls sie leer ist			  
		String clipboardText = Clipboard.getSystemClipboard().getString();		
		textArea.replaceSelection(clipboardText);		
	}
	
	public void editDelete() {
		System.out.println("editDelete");
		textArea.replaceSelection(""); 
	}
	
	// Events des Hilfe-Menüs
	public void helpInfo() {
		System.out.println("helpInfo");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Was ist das?");
		alert.setContentText("Dies ist ein einfacher Texteditor.");

		alert.showAndWait();

	}
		
	
	private void saveFile(File file) {
		byte[] buffer = textArea.getText().getBytes();
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			out.write( buffer );
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		// geladenen Inhalt synchronisieren:
		loadedContent = textArea.getText();
	}
	
	private void saveFileAs() {
		FileChooser fileChooser = new FileChooser();		  
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("JAVA files (*.java)", "*.java");
        fileChooser.getExtensionFilters().add(extFilter2);
        
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("all files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter3);
        
        //Show save file dialog
        File file = fileChooser.showSaveDialog(stage);
        
        if(file == null)
        	return;
        saveFile(file);
	}
	
	private void copyToClipboard() {
		String text = textArea.getSelectedText();
		//System.out.println(text);
		ClipboardContent content = new ClipboardContent();
		content.putString(text);
		Clipboard.getSystemClipboard().setContent(content);
	}
	
	private void checkChanges(TextArea textArea) {	
		//System.out.println("loaded: "+loadedContent +  " real: " + textArea.getText());
		if(!loadedContent.equals(textArea.getText())) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Einfacher Texteditor");
			alert.setHeaderText("Möchtens die Änderungen speichern?");
			alert.setContentText("");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    fileSaveAs();
			} 
			//else {
			    // ... user chose CANCEL or closed the dialog
			//}
		}
	}

}
