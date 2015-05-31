import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.classes.dto.Member;
//Projects the Member Results to separate Frame
public class MemberTableModel extends AbstractTableModel {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<Member> members;
	
	public MemberTableModel(ArrayList<Member> members) {
		this.members = new ArrayList<>(members);
	}

	@Override
	//Sets the number of Rows of the table
	public int getRowCount() {
		return members.size();
	}

	@Override
	//Sets the number of Columns
	public int getColumnCount() {
		return 6;				//Check for number of columns
	}

	@Override
	//Column Title Names
	public String getColumnName(int column) {
		String[] columnNames=new String[]{"ΑΜ", "Όνομα", "Επώνυμο", "e-mail", "Τμήμα", "Πρόστιμο"};
		return columnNames[column];
	}

	@Override
	//Column fields in order
	public Object getValueAt(int rowIndex, int columnIndex) {
		Member m = members.get(rowIndex);
		Object[] values=new Object[]{
				m.getiD(), m.getStudentName(), m.getStudentSurname(), m.getEmail(), m.getDepartment(), m.getLatePoints()
		};
		return values[columnIndex];
	}        
}       