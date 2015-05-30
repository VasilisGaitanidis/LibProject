import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.classes.dto.Book;

public class BookTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Book> books;

	public BookTableModel(ArrayList<Book> books) {
		this.books = new ArrayList<>(books);
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int column) {
		String[] columnNames=new String[]{"ISBN", "Τίτλος Βιβλίου", "Συγγραφέας", "Εκδοτικός Οίκος", "Θέμα", "Γλώσσα", "Αξιολόγηση", "Συνολικοί Δανεισμοί"};
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book b = books.get(rowIndex);
		Object[] values=new Object[]{
				b.getiSBN(), b.getBookName(), b.getBookAuthor(), b.getBookPublisher(), b.getBookSubject(), b.getBookLanguage(), b.getBookEvaluation(), b.getnOBorrows()
		};
		return values[columnIndex];
	}        
}       