import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JSeparator;


public class ToolBar extends JToolBar{
	private JToolBar toolBar;
	private JButton btnAddBook;
	private JButton btnAddMember;
	private JButton btnBorrowBook;
	private JButton btnReturnBook;
	private JButton btnSearch;


	public ToolBar() {
		setSize(new Dimension(148, 20));
		setFloatable(false);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 434, 16);

		
		btnAddBook = new JButton("");
		btnAddBook.setToolTipText("Add Book");
		btnAddBook.setIcon(new ImageIcon(ToolBar.class.getResource("/images/add_book_small.png")));
		add(btnAddBook);
		addSeparator();
		
		btnAddMember = new JButton("");
		btnAddMember.setToolTipText("Add Member");
		btnAddMember.setIcon(new ImageIcon(ToolBar.class.getResource("/images/add_member_small.png")));
		add(btnAddMember);
		addSeparator();
		
		btnBorrowBook = new JButton("");
		btnBorrowBook.setToolTipText("Borrow Book");
		btnBorrowBook.setIcon(new ImageIcon(ToolBar.class.getResource("/images/borrow_book_small.png")));
		add(btnBorrowBook);
		
		btnReturnBook = new JButton("");
		btnReturnBook.setToolTipText("Return Book");
		btnReturnBook.setIcon(new ImageIcon(ToolBar.class.getResource("/images/return_book_small.png")));
		add(btnReturnBook);
		addSeparator();
		
		btnSearch = new JButton("");
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon(ToolBar.class.getResource("/images/search_small.png")));
		add(btnSearch);
			}

}
