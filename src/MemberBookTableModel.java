import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.classes.dto.MemberBook;
//Projects the Borrow Results to separate Frame
public class MemberBookTableModel extends AbstractTableModel {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<MemberBook> memberBooks;

	public MemberBookTableModel(ArrayList<MemberBook> memberBooks) {
		this.memberBooks = new ArrayList<>(memberBooks);
	}

	@Override
	//Sets the number of Rows of the table
	public int getRowCount() {
		return memberBooks.size();
	}

	@Override
	//Sets the number of Columns
	public int getColumnCount() {
		return 7;				//Check for number of columns
	}

	@Override
	//Column Title Names
	public String getColumnName(int column) {
		String[] columnNames=new String[]{"Κωδικός Δανεισμού", "Ημέρα Δανεισμού", "Ημέρα Παράδοσης", "Ημέρα Επιστροφής", "ISBN","Τίτλος Βιβλίου", "Αριθμός Μητρώου"};
		return columnNames[column];
	}

	@Override
	//Column fields in order
	public Object getValueAt(int rowIndex, int columnIndex) {
		MemberBook mb = memberBooks.get(rowIndex);
		Object[] values=new Object[]{
				mb.getBorrowID(), mb.getBorrowDay(), mb.getReturnDay(), mb.getDeliveryDay(), mb.getBook().getiSBN(), mb.getBook().getBookName(), mb.getMember().getiD()
		};
		return values[columnIndex];
	}        
}       