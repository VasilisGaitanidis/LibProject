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
 * ������ �������� ���� ������ ��� ������� �� ����� MemberBook.class,
 * ����� � �������� ��� ��������� ��� ����������� ������� ���������� �������� ��� ��� ����� ����� JoinTable.
 * � ���������� �������� �� ���� �� primary_key(��,ISBN) ��� ����� ��������� ��� �����������.
 * 
 * @author Gaitanidis
 *
 */

@Entity
@Table (name = "����")
public class Member {
	
	@Column (name = "�����",nullable=false)
    private String studentName;
	@Column (name = "�������",nullable=false)
	private String studentSurname;
	@Id
	@Column (name = "��",nullable=false)
	private String iD;
	@Column (name = "�����",nullable=false)
	private String department;
	@Column (name = "�mail",nullable=false)
	private String email;
	@Column (name = "��������")
	private int latePoints;
	@OneToMany
	@JoinTable(name="���������", joinColumns=@JoinColumn(name="��"), inverseJoinColumns=@JoinColumn(name="ISBN"))
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