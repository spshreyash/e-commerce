package org.project.models;

public class LoginModel {

//	 uid      | int          | NO   | PRI | NULL    | auto_increment |
//	 | uname    | varchar(200) | NO   |     | NULL    |                |
//	 | uemail   | varchar(200) | NO   | UNI | NULL    |                |
//	 | password | varchar(200) | NO   |     | NULL    |                |
//	 | usertype 
	
	
	private int uid;
	private String uname;
	private String  uemail;
private String password;
private String usertype ;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}

	
}
