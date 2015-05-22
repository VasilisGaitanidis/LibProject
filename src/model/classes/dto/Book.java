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

@Entity                           //Kathorismos Ontothtas Vivliwn.
@Table (name = "Βιβλία")            //Onomasia pinaka Vivliwn
public class Book {
	
	@Column (name = "Όνομα",nullable=false)     //@Column (name=)--> Allagh onomatos Sthlhs 
	private String bookName;     //                   se Bash Dedomenwn
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
	@Id                         //Dhlwsh tou ISBN san prwteuon kleidi
	@Column (name = "ISBN",nullable=false)
	private int iSBN;
	@ManyToOne                 //Dhlwsh Sysxetishs Polla pros Ena apo Vivlio se Melos
	@JoinColumn(name="ΑΜ_Κατόχου") // Onomasia extra sthlhs ston pinaka twn Vivliwn 
	private Member member;         // p dhlwnei to ID tou katoxou
	@OneToMany(mappedBy="book")
	private Collection<MemberBook> mb = new ArrayList<MemberBook>();
    //private String bookNotes;*/
	
	
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
}