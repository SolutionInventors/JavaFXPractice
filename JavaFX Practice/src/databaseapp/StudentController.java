package databaseapp;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ComboBox;

import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;

public class StudentController implements Initializable{
	@FXML private TextField txtSearchBar;
	@FXML private Button btnGo;
	@FXML private ComboBox cmbDateRegistered;
	@FXML private ComboBox cmbCategory;
	@FXML private Label lblStudentName;
	@FXML private ImageView imgStudentImage;
	@FXML private TableView moduleTable;
	@FXML private TableView<Student>studentTable;
	@FXML private TableColumn<Student, Integer>id;
	@FXML private TableColumn<Student, String>firstName;
	@FXML private TableColumn<Student, String>lastName;
	//private ObservableList<Student> list;
	
	public ObservableList<Student> list = FXCollections.observableArrayList(
			new Student(001,"john","willard"),
			new Student(011,"W.T","BAS"),
			new Student(021,"judge","Noose"),
			new Student(401,"williams","bukly"),
			new Student(301,"Row","Ark")			
			);
		
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		firstName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		studentTable.setItems(list);
	}
	
	public void getuser() {
		Student std = (Student)studentTable.getSelectionModel().getSelectedItem();
		System.out.println(std.getId());
		System.out.println(std.getFirstName());
		System.out.println(std.getLastName());
		
	}

		
		
	
	/*
	 * @FXML private TableView<CompetitorStatus>table;
	@FXML private TableColumn<CompetitorStatus, Integer>sn;
	@FXML private TableColumn<CompetitorStatus, String>competitorName;
	@FXML private TableColumn<CompetitorStatus, String>eliminated;
	
	@FXML private Label tourStage;
	private CommonMethods cm = new CommonMethods();
	private Font font[] = new Font[3];
	
	private Tournament tournament;
	private ObservableList<CompetitorStatus> list;
	
	public void initialize() {
		font = cm.loadfonts();

		tourStage.setFont(font[1]);// tournament Specs
		//tourStage.size
	}
	
	public void setTournament(Tournament tour) {
		tournament = tour;
		
		
		sn.setCellValueFactory(new PropertyValueFactory<CompetitorStatus, Integer>("sn"));
		competitorName.setCellValueFactory(new PropertyValueFactory<CompetitorStatus, String>("competitorName"));
		eliminated.setCellValueFactory(new PropertyValueFactory<CompetitorStatus, String>("eliminated"));
		
		table.setItems(setuptablevariable());
	}
	

	
	public ObservableList<CompetitorStatus> setuptablevariable() {
	list = FXCollections.observableArrayList();
	Competitor comp[];
	comp = tournament.getCompetitors();
	for (int i = 0; i < comp.length; i++) {
		list.add(new  CompetitorStatus(i+1,comp[i].getName(), (comp[i].isEliminated() ? "Yes" : "No")));
	}
	return list;
	
	}//end utility method
	
	 * 
	 * 
	 * */
}
