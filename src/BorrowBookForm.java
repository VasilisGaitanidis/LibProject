import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.classes.dto.Book;
import model.classes.dto.Member;
import model.classes.dto.MemberBook;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class BorrowBookForm extends JInternalFrame {
	private JTextField ISBNTextField;
	private JTextField IDTextField;
	private JTextField borrowDayTextField;
	private JTextField returnDayTextField;
	private JLabel returnDayLabel;
	private JLabel borrowDayLabel;
	private JButton borrowBookButton;
	private JButton clearButton;
	
	private String borrowDay;
	private String returnDay;

	/**
	 * Create the Borrow Book frame.Listeners at the end.
	 * @throws ParseException 
	 */
	public BorrowBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(
				BorrowBookForm.class.getResource("/images/inbox_upload_16x16.png")));
		setTitle("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 350, 240);

		JPanel panelData = new JPanel();
		panelData
				.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel ISBNLabel = new JLabel("ISBN \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");

		ISBNTextField = new JTextField();
		ISBNTextField.setColumns(10);

		clearButton = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clearButton.addActionListener(new ClearButtonActionListener());
		
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		panelData.add(ISBNLabel);
		panelData.add(ISBNTextField);

		JLabel IDLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
		panelData.add(IDLabel);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { ISBNLabel, ISBNTextField, IDLabel,
						IDTextField, borrowDayLabel, borrowDayTextField,
						returnDayLabel, returnDayTextField, borrowBookButton,
						clearButton }));

		IDTextField = new JTextField();
		IDTextField.setColumns(10);
		panelData.add(IDTextField);

		borrowDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03BF\u03CD:");
		panelData.add(borrowDayLabel);

		borrowDay = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());
		borrowDayTextField = new JTextField(borrowDay);
		borrowDayTextField.setHorizontalAlignment(SwingConstants.CENTER);
		borrowDayTextField.setBackground(Color.LIGHT_GRAY);
		borrowDayTextField.setColumns(10);
		panelData.add(borrowDayTextField);

		returnDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2:");
		panelData.add(returnDayLabel);
		//System's date
		Calendar c = Calendar.getInstance();
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		c.setTime(dt);
		//number of max borrow days (7)
		c.add(Calendar.DATE, 7);
		dt = c.getTime();
		returnDay = df.format(dt);
		
		returnDayTextField = new JTextField(returnDay);
		returnDayTextField.setHorizontalAlignment(SwingConstants.CENTER);
		returnDayTextField.setBackground(Color.LIGHT_GRAY);
		returnDayTextField.setColumns(10);
		panelData.add(returnDayTextField);

		borrowBookButton = new JButton("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2");
		borrowBookButton.addActionListener(new BorrowBookActionListener());
		
		panelData.add(borrowBookButton);
		panelData.add(clearButton);
		getContentPane().setLayout(groupLayout);

	}
	//Borrow Book Button Action Listener
	class BorrowBookActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Connection with Database via Hibernate
			Configuration configuration = new Configuration();
		    configuration.configure();
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    //New session
			Session session = sessionFactory.openSession();
			//Gets the text from TextFields
			String iD = IDTextField.getText();
			int iSBN = Integer.parseInt(ISBNTextField.getText());
			//Gets the Member with the specified ID
			Member selectedMember = (Member) session.get(Member.class,iD);
			//Gets the Book with the specified ISBN
			Book selectedBook = (Book) session.get(Book.class,iSBN);
			//Gets the value of the book's borrower
			Member memberOwner = selectedBook.getMember();
			
			//if the upper value is null then the book can be borrowed
			if(memberOwner == null) {
				//Creates new borrow
				MemberBook mb = new MemberBook();
				//Gets the system date and sets the return day to one week later
				mb.setBorrowDay(borrowDay);
				mb.setReturnDay(returnDay);
			    //Inserts the member's ID to the Book's row								
				selectedBook.setMember(selectedMember);
				//Inserts the ID to the new Borrow row
				mb.setMember(selectedMember);
				//Inserts the book ISBN to the new Borrow row
				mb.setBook(selectedBook);
				//Saves the Book,and the borrow tables
				session.beginTransaction();
				session.saveOrUpdate(selectedBook);
				session.saveOrUpdate(mb);
				session.getTransaction().commit();
				//Announces the new Borrow ID
				String borrowID = Integer.toString(mb.getBorrowID());
				JOptionPane.showMessageDialog(null,
						"Ο κωδικός δανεισμού είναι " + borrowID , "Κωδικός Δανεισμού",
						JOptionPane.INFORMATION_MESSAGE);
				ISBNTextField.setText(null);
			}
			//if the value is not null then someone else has the book.Informs who has it.
			else {
				String aMOwner = memberOwner.getiD();
				JOptionPane.showMessageDialog(null,
						"Το βιβλίο με ISBN " + iSBN + " είναι ήδη δανεισμένο στον " + aMOwner, "Σφάλμα Δανεισμού!",
						JOptionPane.ERROR_MESSAGE);
				ISBNTextField.setText(null);
			}
			//Closing session
			session.close();
			
		}		
	}
	//Button katharismou pediwn
	class ClearButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ISBNTextField.setText(null);
		    IDTextField.setText(null);
		    
		}
		
	}
	
}
