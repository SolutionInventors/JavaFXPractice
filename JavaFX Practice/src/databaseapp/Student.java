package databaseapp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty firstName;
	private final SimpleStringProperty lastName;
	
	public Student(Integer id, String firstname, String lastname) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.firstName =new SimpleStringProperty(firstname);
		this.lastName = new SimpleStringProperty(lastname);
	}
	public Integer getId() {
		return id.get();
	}
	public String getFirstName() {
		return firstName.get();
	}
	public String getLastName() {
		return lastName.get();
	}
	
}//end class
