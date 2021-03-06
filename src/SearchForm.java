import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.classes.dto.Book;
import model.classes.dto.Member;
import model.classes.dto.MemberBook;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SearchForm extends JInternalFrame {
	private JTextField bookKeyWordTextField;
	private JTextField memberKeyWordTextField;
	private JComboBox memberSearchComboBox, bookSearchComboBox,borrowSearchByComboBox;
	private JButton clearButton;
	private JButton searchBookButton;
	private JButton searchMemberButton;
	private JPanel searchBorrowPanel;
	private JLabel borrowKeyWordLabel;
	private JTextField borrowKeyWordTextField;
	private JButton borrowSearchButton;
	private JPanel searchBookPanel;
	private JPanel searchMemberPanel;

	/**
	 * Creates the search form frame. Action Listeners at the end!
	 */
	public SearchForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(SearchForm.class.getResource("/images/search_16x16.png")));
		setTitle("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 681, 434);

		// Search book panel
		searchBookPanel = new JPanel();
		searchBookPanel
		.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		// Search member panel
		searchMemberPanel = new JPanel();
		searchMemberPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		clearButton = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clearButton.addActionListener(new ClearActionListener());

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
						gl_panel.createSequentialGroup()
						.addGap(529)
						.addComponent(clearButton, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(26)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
						gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(clearButton)
								.addContainerGap()));
		panel.setLayout(gl_panel);

		// Search borrow panel
		searchBorrowPanel = new JPanel();
		searchBorrowPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CE\u03BD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		borrowKeyWordLabel = new JLabel("\u039B\u03AD\u03BE\u03B7 \u039A\u03BB\u03B5\u03B9\u03B4\u03AF:");
		borrowKeyWordLabel.setToolTipText("");
		borrowKeyWordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		borrowKeyWordTextField = new JTextField();
		borrowKeyWordTextField.setColumns(10);

		borrowSearchButton = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		borrowSearchButton.addActionListener(new BorrowSearchActionListener());

		JLabel borrowSearchByLabel = new JLabel("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03BC\u03B5:");
		borrowSearchByLabel.setToolTipText("");
		borrowSearchByLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		borrowSearchByComboBox = new JComboBox();
		borrowSearchByComboBox.setModel(new DefaultComboBoxModel(new String[] {"ISBN", "\u0391\u03C1\u03B9\u03B8\u03BC\u03CC \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5"}));

		GroupLayout gl_searchBorrowPanel = new GroupLayout(searchBorrowPanel);
		gl_searchBorrowPanel.setHorizontalGroup(
				gl_searchBorrowPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_searchBorrowPanel.createSequentialGroup()
						.addGap(106)
						.addComponent(borrowSearchButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
						.addGap(102))
						.addGroup(Alignment.LEADING, gl_searchBorrowPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(borrowKeyWordLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(borrowKeyWordTextField, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addContainerGap())
								.addGroup(Alignment.LEADING, gl_searchBorrowPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(borrowSearchByLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(borrowSearchByComboBox, 0, 137, Short.MAX_VALUE)
										.addContainerGap())
				);
		gl_searchBorrowPanel.setVerticalGroup(
				gl_searchBorrowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_searchBorrowPanel.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_searchBorrowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(borrowSearchByLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(borrowSearchByComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_searchBorrowPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(borrowKeyWordLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(borrowKeyWordTextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(borrowSearchButton)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		searchBorrowPanel.setLayout(gl_searchBorrowPanel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(searchBookPanel, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(searchMemberPanel, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
						.addGap(12))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
								.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(172)
										.addComponent(searchBorrowPanel, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(175, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchBookPanel, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(searchMemberPanel, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchBorrowPanel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				);

		JLabel memberSearchByLabel = new JLabel(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03BC\u03B5:");
		memberSearchByLabel.setToolTipText("");
		memberSearchByLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel memberKeyWordLabel = new JLabel(
				"\u039B\u03AD\u03BE\u03B7 \u039A\u03BB\u03B5\u03B9\u03B4\u03AF:");
		memberKeyWordLabel.setToolTipText("");
		memberKeyWordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		memberSearchComboBox = new JComboBox();
		memberSearchComboBox
		.setModel(new DefaultComboBoxModel(
				new String[] {"\u0391\u03C1\u03B9\u03B8\u03BC\u03CC \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5","\u03A4\u03BC\u03AE\u03BC\u03B1" }));

		memberKeyWordTextField = new JTextField();
		memberKeyWordTextField.setColumns(10);

		searchMemberButton = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		searchMemberButton.addActionListener(new SearchMemberActionListener());


		GroupLayout gl_searchMemberPanel = new GroupLayout(searchMemberPanel);
		gl_searchMemberPanel.setHorizontalGroup(
				gl_searchMemberPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchMemberPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_searchMemberPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_searchMemberPanel.createSequentialGroup()
										.addComponent(memberSearchByLabel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(memberSearchComboBox, 0, 137, Short.MAX_VALUE))
										.addGroup(gl_searchMemberPanel.createSequentialGroup()
												.addComponent(memberKeyWordLabel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(memberKeyWordTextField, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
												.addGroup(Alignment.TRAILING, gl_searchMemberPanel.createSequentialGroup()
														.addGap(189)
														.addComponent(searchMemberButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
														.addContainerGap())
				);
		gl_searchMemberPanel.setVerticalGroup(
				gl_searchMemberPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchMemberPanel.createSequentialGroup()
						.addGap(13)
						.addGroup(gl_searchMemberPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(memberSearchByLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(memberSearchComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_searchMemberPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(memberKeyWordLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(memberKeyWordTextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(searchMemberButton)
										.addContainerGap(23, Short.MAX_VALUE))
				);
		searchMemberPanel.setLayout(gl_searchMemberPanel);

		JLabel bookSearchByLabel = new JLabel(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03BC\u03B5:");
		bookSearchByLabel.setToolTipText("");
		bookSearchByLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		bookSearchComboBox = new JComboBox();
		bookSearchComboBox.setModel(new DefaultComboBoxModel(
				new String[] {"\u038C\u03BD\u03BF\u03BC\u03B1","\u03A3\u03C5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AD\u03B1","\u0398\u03AD\u03BC\u03B1",
						"\u0395\u03BA\u03B4\u03BF\u03C4\u03B9\u03BA\u03CC \u039F\u03AF\u03BA\u03BF","ISBN" }));

		JLabel bookKeyWordLabel = new JLabel("\u039B\u03AD\u03BE\u03B7 \u039A\u03BB\u03B5\u03B9\u03B4\u03AF:");
		bookKeyWordLabel.setToolTipText("");
		bookKeyWordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		bookKeyWordTextField = new JTextField();
		bookKeyWordTextField.setColumns(10);

		searchBookButton = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		searchBookButton.addActionListener(new SearchBookActionListener());

		GroupLayout gl_searchBookPanel = new GroupLayout(searchBookPanel);
		gl_searchBookPanel.setHorizontalGroup(
				gl_searchBookPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchBookPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_searchBookPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_searchBookPanel.createSequentialGroup()
										.addComponent(bookSearchByLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
										.addGap(10)
										.addComponent(bookSearchComboBox, 0, 137, Short.MAX_VALUE))
										.addGroup(gl_searchBookPanel.createSequentialGroup()
												.addComponent(bookKeyWordLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
												.addGap(10)
												.addComponent(bookKeyWordTextField, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
												.addGroup(gl_searchBookPanel.createSequentialGroup()
														.addGap(188)
														.addComponent(searchBookButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
														.addContainerGap())
				);
		gl_searchBookPanel.setVerticalGroup(
				gl_searchBookPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchBookPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_searchBookPanel.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(bookSearchByLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookSearchComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_searchBookPanel.createParallelGroup(Alignment.BASELINE, false)
										.addComponent(bookKeyWordLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookKeyWordTextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(searchBookButton)
										.addGap(25))
				);
		searchBookPanel.setLayout(gl_searchBookPanel);
		getContentPane().setLayout(groupLayout);

	}

	// Search book with the key word given
	class SearchBookActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Gets the text from TextField
			String bookSearchSelection = bookKeyWordTextField.getText();
			// Gets the selection of ComboBox and sets to String
			String bookSeachKey = bookSearchComboBox.getSelectedItem().toString();

			// Connection with Database via Hibernate
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			// Creates new session and transaction with database
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// Initialize as ""
			String columnName = "";
			// Gets the ComboBox selection and sets the query value accordingly
			if (bookSeachKey.equals("�����"))
				columnName = "bookName";
			else if (bookSeachKey.equals("���������"))
				columnName = "bookAuthor";
			else if (bookSeachKey.equals("����"))
				columnName = "bookSubject";
			else if (bookSeachKey.equals("�������� ����"))
				columnName = "bookPublisher";
			// ISBN is integer so we have to parse it differently
			else if (bookSeachKey.equals("ISBN"))
				columnName = "iSBN";				

			// Uses Hibernate Query Language (Book=class name, iSBN =variable name)

			Query query = session.createQuery("from Book where "+columnName+" =?");

			if(columnName.equals("iSBN")) {
				// tries to parse string to integer
				try {
					int iSBNValue = Integer.parseInt(bookSearchSelection);
					// This is what goes into "?"
					query.setInteger(0,iSBNValue);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"To ISBN ������ �� ����� �������!!", "������ ISBN",
							JOptionPane.ERROR_MESSAGE);
					bookKeyWordTextField.setText(null);
				}				
			}
			else {
				// This is what goes into "?"
				query.setString(0, bookSearchSelection);
			}

			// Result list
			ArrayList<Book> books = new ArrayList<Book>(query.list());

			// Closing transaction and session
			session.getTransaction().commit();
			session.close();

			if (books.isEmpty()){
				JOptionPane.showMessageDialog(null,
						"�� ������ ��� ����������� ��� �������.", "����� ���� ������",
						JOptionPane.INFORMATION_MESSAGE);
				bookKeyWordTextField.setText(null);
			}
			else {
				// Projects the results via the BookTableModel method in separate frame
				BookTableModel model = new BookTableModel(books);
				JTable table = new JTable(model);

				JFrame frame = new JFrame("���������� ����������");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new JScrollPane(table));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}			
		}
	}

	// Search member with the key word given
	class SearchMemberActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Gets the ComboBox selection
			String memberSeachKey = memberSearchComboBox.getSelectedItem().toString();
			// Gets the text from TextField
			String memberSearchSelection = memberKeyWordTextField.getText();

			// Connection with Database via Hibernate
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// Initialize as ""
			String columnName = "";

			// Gets the ComboBox selection and sets the query value accordingly
			if (memberSeachKey.equals("������ �������"))
				columnName = "iD";
			else if (memberSeachKey.equals("�����"))
				columnName = "department";

			// Uses Hibernate Query Language (Member=class name, columnName =variable name according to search type from IF above)
			Query query = session.createQuery("from Member where "+columnName+" =?");
			//This is what goes into "?"
			query.setString(0,memberSearchSelection);

			// Result List
			ArrayList<Member> members = new ArrayList<Member>(query.list());

			// Closing transaction and session
			session.getTransaction().commit();
			session.close();

			if (members.isEmpty()){
				JOptionPane.showMessageDialog(null,
						"�� ����� ��� ����������� ��� �������.", "����� ���� ������",
						JOptionPane.INFORMATION_MESSAGE);
				memberKeyWordTextField.setText(null);
			}
			else {
				// Projects the results via the MemberTableModel method in separate frame
				MemberTableModel model = new MemberTableModel(members);
				JTable table = new JTable(model);

				JFrame frame = new JFrame("���������� ����������");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new JScrollPane(table));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		}
	}

	// Clears all text fields
	class ClearActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			bookKeyWordTextField.setText(null);
			memberKeyWordTextField.setText(null);
			borrowKeyWordTextField.setText(null);
		}
	}

	// Search table "���������" with the key word given
	class BorrowSearchActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Gets the ComboBox selection
			String borrowBySeachKey = borrowSearchByComboBox.getSelectedItem().toString();
			String borrowSearchSelection = borrowKeyWordTextField.getText();

			// Connection with Database via Hibernate
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// Initialize as ""
			String columnName = "";
			if (borrowBySeachKey.equals("������ �������"))
				columnName = "mb.member.iD";
			else if(borrowBySeachKey.equals("ISBN"))
				columnName = "mb.book.iSBN";

			// Searching at the table "���������"
			Query query = session.createQuery("from MemberBook as mb where "+columnName+" = ?");

			if(columnName.equals("mb.book.iSBN")) {
				// tries to parse string to integer
				try {
					int iSBNValue = Integer.parseInt(borrowSearchSelection);
					// This is what goes into "?"
					query.setInteger(0,iSBNValue);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"To ISBN ������ �� ����� �������!!", "������ ISBN",
							JOptionPane.ERROR_MESSAGE);
					borrowKeyWordTextField.setText(null);
				}				
			}
			else {
				// This is what goes into "?"
				query.setString(0, borrowSearchSelection);
			}

			//Result list
			ArrayList<MemberBook> mbooks = new ArrayList<MemberBook>(query.list());

			//Closing transaction and session
			session.getTransaction().commit();
			session.close();

			//Checking if member has ever borrowed any books
			if (mbooks.isEmpty()){
				JOptionPane.showMessageDialog(null,
						"��� ������� ��������� �� �� ������������ ����.", "������� ���������",
						JOptionPane.INFORMATION_MESSAGE);
				borrowKeyWordTextField.setText(null);
			}
			//Member has a borrow history cause the list ain't empty
			else{

				//Uses the MemberBookTableModel method to project the results in separate frame
				MemberBookTableModel model = new MemberBookTableModel(mbooks);
				JTable table = new JTable(model);
				//Projecting the result list using table
				JFrame frame = new JFrame("���������� ����������");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new JScrollPane(table));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		}
	}
}