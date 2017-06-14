package ua.com.library.dto;

public class CustomerDTO {
public int id;
public String name;
public String email;
public String telephone;

public CustomerDTO(String name, String email, String telephone) {
	super();
	this.name = name;
	this.email = email;
	this.telephone = telephone;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public CustomerDTO(String name, String email) {
	super();
	this.name = name;
	this.email = email;
}
public CustomerDTO() {
	super();
	// TODO Auto-generated constructor stub
}

}
