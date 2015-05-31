import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.classes.dto.Book;
//Projects the Book Results to separate Frame
public class BookTableModel extends AbstractTableModel {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<Book> books;

	public BookTableModel(ArrayList<Book> books) {
		this.books = new ArrayList<>(books);
	}

	@Override
	//Sets the number of Rows of the table
	public int getRowCount() {
		return books.size();
	}

	@Override
	//Sets the number of Columns
	public int getColumnCount() {
		return 8;
	}

	@Override
	//Column Title Names
	public String getColumnName(int column) {
		String[] columnNames=new String[]{"ISBN", "Τίτλος Βιβλίου", "Συγγραφέας", "Εκδοτικός Οίκος", "Θέμα", "Γλώσσα", "Αξιολόγηση", "Συνολικοί Δανεισμοί"};
		return columnNames[column];
	}

	@Override
	//Column fields in order
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book b = books.get(rowIndex);
		Object[] values=new Object[]{
				b.getiSBN(), b.getBookName(), b.getBookAuthor(), b.getBookPublisher(), b.getBookSubject(), b.getBookLanguage(), b.getBookEvaluation(), b.getnOBorrows()
		};
		return values[columnIndex];
	}        
}       