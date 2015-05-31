package model.classes.dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Entity of Books.
@Entity
//Table name at Database
@Table (name = "Μέλη")
public class Member {
	//Column's name at Database
	@Column (name = "Όνομα",nullable=false)
    private String studentName;
	@Column (name = "Επώνυμο",nullable=false)
	private String studentSurname;
	//Student's ID is the primary key
	@Id
	@Column (name = "ΑΜ")
	private String iD;
	@Column (name = "Τμήμα",nullable=false)
	private String department;
	@Column (name = "Εmail",nullable=false)
	private String email;
	@Column (name = "Πρόστιμο")
	private double latePoints;
	//One member can have many books
	@OneToMany(mappedBy="member")
	//Books that the member has borrowed
	private Collection<Book> books = new ArrayList<Book>();
	//This creates a joined column at the Borrow-Return Table
	@OneToMany(mappedBy="member")
	private Collection<MemberBook> mb = new ArrayList<MemberBook>();
	
	
	public Collection<Book> getBooks() {
		return books;
	}
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	public Collection<MemberBook> getMb() {
		return mb;
	}
	public void setMb(Collection<MemberBook> mb) {
		this.mb = mb;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSurname() {
		return studentSurname;
	}
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLatePoints() {
		return latePoints;
	}
	public void setLatePoints(double latePoints) {
		this.latePoints = latePoints;
	}
	}