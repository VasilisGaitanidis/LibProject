package model.classes.dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity                       //Kathorismos Ontothtas Vivliwn.
@Table (name = "Μέλη")       //Onomasia pinaka Melwn
public class Member {
	
	@Column (name = "Όνομα",nullable=false)
    private String studentName;
	@Column (name = "Επώνυμο",nullable=false)
	private String studentSurname;
	@Id                       // Dhlwsh tou ID(Arithmo Mitrwou 
	@Column (name = "ΑΜ",nullable=false)    //  san prwteuon kleidi
	private String iD;
	@Column (name = "Τμήμα",nullable=false)
	private String department;
	@Column (name = "Εmail",nullable=false)
	private String email;
	@Column (name = "Πρόστιμο")
	private int latePoints;
	@OneToMany(mappedBy="member")//Dhlwsh syxetishs Ena pros Polla apo Melos se Vivlio
	private Collection<Book> books = new ArrayList<Book>(); //Lista Vivliwn pou exei daneistei to melos
	
	public void addBook(Book book) {
		books.add(book);
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
	public int getLatePoints() {
		return latePoints;
	}
	public void setLatePoints(int latePoints) {
		this.latePoints = latePoints;
	}
	public Collection<Book> getBooks() {
		return books;
	}
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
}