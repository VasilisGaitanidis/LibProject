package model.classes.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Δανεισμοί")
public class MemberBook implements java.io.Serializable{	
	
	
	@Id                              // Primary Key to ID tou katoxou
	@ManyToOne                       //Dhlwsh Sysxetishs Polla pros Ena
	@JoinColumn(name="ΑΜ_Κατόχου")   // Onomasia extra sthlhs ston pinaka Daneismou
	private Member member;
	@Id
	@ManyToOne                       //Dhlwsh Sysxetishs Polla pros Ena 
	@JoinColumn(name="ISBN_Βιβλίου") // Onomasia extra sthlhs ston pinaka Daneismou
	private Book book;
	@Column (name = "Ημέρα_Δανεισμού")
	private String borrowDay;
	@Column (name = "Ημέρα_Επιστροφής")
	private String returnDay;
	@Column (name = "Ημέρα_Παράδοσης")
	private String deliveryDay;
	
	public String getBorrowDay() {
		return borrowDay;
	}
	public void setBorrowDay(String borrowDay) {
		this.borrowDay = borrowDay;
	}
	public String getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	public String getDeliveryDay() {
		return deliveryDay;
	}
	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}