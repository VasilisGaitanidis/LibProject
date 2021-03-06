import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.classes.dto.Book;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AddBookForm extends JInternalFrame {
	private JTextField bookNameTextField;
	private JTextField bookAuthorTextField;
	private JTextField bookSubjectTextField;
	private JTextField bookPagesTextField;
	private JTextField bookPublisherTextField;
	private JTextField bookEditionTextField;
	private JLabel bookPagesLabel;
	private JLabel bookPublisherLabel;
	private JLabel bookEditionLabel;
	private JLabel bookLanguageLabel;
	private JButton addBookButton;
	private JTextField ISBNTextField;
	private JLabel bookSubjectLabel;
	private JButton clearButton;
	private JComboBox bookLanguageComboBox;

	/**
	 * Creates the add book form frame. Action Listeners at the end!
	 * 
	 */
	
	public AddBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(AddBookForm.class.getResource("/images/add_book_16x16.png")));
		setTitle("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 400, 300);

		JPanel panelData = new JPanel();
		panelData
				.setBorder(new TitledBorder(null,"\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel bookNamelLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");

		bookNameTextField = new JTextField();
		bookNameTextField.setColumns(10);

		addBookButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addBookButton.addActionListener(new AddBookActionListener());

		JLabel ISBNLabel = new JLabel("ISBN:");
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		panelData.add(bookNamelLabel);
		panelData.add(bookNameTextField);

		JLabel bookAuthorLabel = new JLabel("\u03A3\u03C5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AD\u03B1\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		panelData.add(bookAuthorLabel);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { bookNamelLabel, bookNameTextField,
						bookAuthorLabel, bookAuthorTextField, bookSubjectLabel,
						bookSubjectTextField, bookPagesLabel,
						bookPagesTextField, bookPublisherLabel,
						bookPublisherTextField, bookEditionLabel,
						bookEditionTextField, bookLanguageLabel,
						bookLanguageComboBox, addBookButton, clearButton }));

		bookAuthorTextField = new JTextField();
		bookAuthorTextField.setColumns(10);
		panelData.add(bookAuthorTextField);

		bookSubjectLabel = new JLabel("\u0398\u03AD\u03BC\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		panelData.add(bookSubjectLabel);

		bookSubjectTextField = new JTextField();
		bookSubjectTextField.setColumns(10);
		panelData.add(bookSubjectTextField);

		bookPagesLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03A3\u03B5\u03BB\u03B9\u03B4\u03CE\u03BD:");
		panelData.add(bookPagesLabel);

		bookPagesTextField = new JTextField();
		bookPagesTextField.setColumns(10);
		panelData.add(bookPagesTextField);

		bookPublisherLabel = new JLabel("\u0395\u03BA\u03B4\u03BF\u03C4\u03B9\u03BA\u03CC\u03C2 \u039F\u03AF\u03BA\u03BF\u03C2:");
		panelData.add(bookPublisherLabel);

		bookPublisherTextField = new JTextField();
		bookPublisherTextField.setColumns(10);
		panelData.add(bookPublisherTextField);

		bookEditionLabel = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		panelData.add(bookEditionLabel);

		bookEditionTextField = new JTextField();
		bookEditionTextField.setColumns(10);
		panelData.add(bookEditionTextField);

		bookLanguageLabel = new JLabel("\u0393\u03BB\u03CE\u03C3\u03C3\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		panelData.add(bookLanguageLabel);

		bookLanguageComboBox = new JComboBox();
		bookLanguageComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03BB\u03BB\u03B7\u03BD\u03B9\u03BA\u03AC","\u0391\u03B3\u03B3\u03BB\u03B9\u03BA\u03AC" }));
		panelData.add(bookLanguageComboBox);
		panelData.add(ISBNLabel);

		ISBNTextField = new JTextField();
		ISBNTextField.setColumns(10);
		panelData.add(ISBNTextField);
		panelData.add(addBookButton);

		clearButton = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clearButton.addActionListener(new ClearBookActionListener());
		
		panelData.add(clearButton);
		getContentPane().setLayout(groupLayout);

	}
	//Adds a book to the Database
	class AddBookActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Creates new Book Object
			Book book = new Book();
			
			//Getting the user's input from TextFields
			String bookName = bookNameTextField.getText();
			String bookAuthor = bookAuthorTextField.getText();
			String bookSubject = bookSubjectTextField.getText();
			// Checks if number of pages is number
			try {
				int bookPages = Integer.parseInt(bookPagesTextField.getText());
				// Sets number of pages into the new book entity
				book.setBookPages(bookPages);
				} 
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
						"� ������� ������� ������ �� ����� �������!!", "������",
						JOptionPane.ERROR_MESSAGE);
				bookPagesTextField.setText(null);}
			
			String bookPublisher = bookPublisherTextField.getText();
			String bookEditionText = bookEditionTextField.getText();
			// Checks if book edition is number
			try {
				int bookEdition = Integer.parseInt(bookEditionText);
				// Sets book edition into the new book entity
				book.setBookEdition(bookEdition);
				} 
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
						"� ������ ��� ������� ������ �� ����� �������!!", "������",
						JOptionPane.ERROR_MESSAGE);
				bookEditionTextField.setText(null);}
			
			String bookLanguage = bookLanguageComboBox.getSelectedItem().toString();
			
			String iSBNText = ISBNTextField.getText();
			// Checks if ISBN is number
			try {
				int iSBN = Integer.parseInt(iSBNText);
				// Sets ISBN into the new book entity
				book.setiSBN(iSBN);
				} 
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
						"To ISBN ������ �� ����� �������!!", "������ ISBN",
						JOptionPane.ERROR_MESSAGE);
				ISBNTextField.setText(null);}
				
			//Setting them into the new book entity
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookSubject(bookSubject);
			book.setBookPublisher(bookPublisher);
			book.setBookLanguage(bookLanguage);
			
			//Connection with Database
			Configuration configuration = new Configuration();
		    configuration.configure();
		    
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    
		    //New session
			Session session = sessionFactory.openSession();
			
			//Saves or updates the book to the database
			session.beginTransaction();
			session.saveOrUpdate(book);
			session.getTransaction().commit();
			//Closing Session
			session.close();
		}
		
	}
	//Clears all textfields
	class ClearBookActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			bookNameTextField.setText(null);
		    bookAuthorTextField.setText(null);
		    bookSubjectTextField.setText(null);
		    bookPagesTextField.setText(null);
		    bookPublisherTextField.setText(null);
		    bookEditionTextField.setText(null);
		    ISBNTextField.setText(null);
		}
	}
}