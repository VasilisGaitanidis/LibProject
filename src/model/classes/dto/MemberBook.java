package model.classes.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//Tells Hibernate that this Class will be an Entity
@Entity
//Table name at Database
@Table (name = "���������")
//ID generated automatically
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)	
public class MemberBook implements java.io.Serializable{	
	
	//Join Column from Member class
	@ManyToOne
	//Column name at Database
	@JoinColumn(name="��_�������")
	private Member member;
	//Join Column from Book class
	@ManyToOne
	//Column name at Database
	@JoinColumn(name="ISBN_�������")
	private Book book;
	// Primary key for table '���������' with generated values
	@Id
	//ID Generator
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column (name = "�������_���������")
	private int borrowID;
	@Column (name = "�����_���������")
	private String borrowDay;
	@Column (name = "�����_����������")
	private String returnDay;
	@Column (name = "�����_���������")
	private String deliveryDay;
	
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
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
}