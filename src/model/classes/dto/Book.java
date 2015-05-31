package model.classes.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//Entity of Members
@Entity
//Database's Table name
@Table (name = "Βιβλία")
public class Book {
	//Column's name at Database
	@Column (name = "Όνομα",nullable=false)
	private String bookName;
	@Column (name = "Συγγραφέας",nullable=false)
	private String bookAuthor;
	@Column (name = "Θέμα",nullable=false)
	private String bookSubject;
	@Column (name = "Σελίδες",nullable=false)
	private int bookPages;
	@Column (name = "Εκδότης",nullable=false)
	private String bookPublisher;
	@Column (name = "Έκδοση",nullable=false)
	private int bookEdition;
	@Column (name = "Γλώσσα",nullable=false)
	private String bookLanguage;
	//Declaration of book ISBN as primary key
	@Id
	@Column (name = "ISBN",nullable=false)
	private int iSBN;
	//A book can be borrowed by one member
	@ManyToOne
	/*This creates a joined column at the book table that
	contains the member's ID that currently has the book*/
	//If this is null then the book is free for borrow
	@JoinColumn(name="ΑΜ_Κατόχου")
	private Member member;
	@OneToMany(mappedBy="book")
	private Collection<MemberBook> mb = new ArrayList<MemberBook>();	
	@Column (name = "Αξιολόγηση")
    private double bookEvaluation;
	@Column (name = "Συνολικοί_Δανεισμοί")
	private int nOBorrows;
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookSubject() {
		return bookSubject;
	}
	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}
	public int getBookPages() {
		return bookPages;
	}
	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public int getBookEdition() {
		return bookEdition;
	}
	public void setBookEdition(int bookEdition) {
		this.bookEdition = bookEdition;
	}
	public String getBookLanguage() {
		return bookLanguage;
	}
	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}
	public int getiSBN() {
		return iSBN;
	}
	public void setiSBN(int iSBN) {
		this.iSBN = iSBN;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Collection<MemberBook> getMb() {
		return mb;
	}
	public void setMb(Collection<MemberBook> mb) {
		this.mb = mb;
	}
	public double getBookEvaluation() {
		return bookEvaluation;
	}
	public void setBookEvaluation(double bookEvaluation) {
		this.bookEvaluation = bookEvaluation;
	}
	public int getnOBorrows() {
		return nOBorrows;
	}
	public void setnOBorrows(int nOBorrows) {
		this.nOBorrows = nOBorrows;
	}
		
}