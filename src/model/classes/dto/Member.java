package model.classes.dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Πιθανή εισαγωγή νέας κλάσης στο Μοντέλο με όνομα MemberBook.class,
 * διότι η προσθήκη των ιδιοτήτων των ημερομηνιών δηλώνει καινούργια οντότητα και δεν είναι πλέον JoinTable.
 * Η καινούργια οντότητα θα έχει το primary_key(ΑΜ,ISBN) και έξτρα ιδιότητες τις ημερομηνίες.
 * 
 * @author Gaitanidis
 *
 */

@Entity
@Table (name = "Μέλη")
public class Member {
	
	@Column (name = "Όνομα",nullable=false)
    private String studentName;
	@Column (name = "Επώνυμο",nullable=false)
	private String studentSurname;
	@Id
	@Column (name = "ΑΜ",nullable=false)
	private String iD;
	@Column (name = "Τμήμα",nullable=false)
	private String department;
	@Column (name = "Εmail",nullable=false)
	private String email;
	@Column (name = "Πρόστιμο")
	private int latePoints;
	@OneToMany
	@JoinTable(name="Δανεισμοί", joinColumns=@JoinColumn(name="ΑΜ"), inverseJoinColumns=@JoinColumn(name="ISBN"))
	private Collection<Book> books = new ArrayList<Book>();
	
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