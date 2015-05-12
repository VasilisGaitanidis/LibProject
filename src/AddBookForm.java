import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddBookForm extends JInternalFrame {
	private JTextField bookNameTextField;
	private JTextField bookAuthorTextField;
	private JTextField bookSubjectTextField;
	private JTextField bookPagesTextField;
	private JTextField bookPublisherTextField;
	private JTextField bookEditionTextField;
	private JTextField bookLanguageTextField;
	private JLabel bookPublisherLabel;
	private JLabel ISBNLabel;
	private JLabel bookPagesLabel;
	private JLabel bookEditionLabel;
	private JButton buttonAddBook;
	private JTextField ISBNtextField;


	/**
	 * Create the frame.
	 */
	public AddBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(AddBookForm.class.getResource("/images/add_book_16x16.png")));
		setTitle("Add Book");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 385, 402);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(null, "\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new TitledBorder(null, "\u03A3\u03B7\u03BC\u03B5\u03B9\u03CE\u03C3\u03B5\u03B9\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelButtons, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
						.addComponent(panelData, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addContainerGap())
		);
		
				
		
		
		JLabel bookNameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		bookNameLabel.setBounds(6, 19, 144, 14);
		
		bookNameTextField = new JTextField();
		bookNameTextField.setBounds(154, 16, 179, 20);
		bookNameTextField.setColumns(10);
		
		buttonAddBook = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		buttonAddBook.setBounds(69, 239, 81, 23);
		buttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DatabaseHandling db = new DatabaseHandling();
				db.establishConnection();
				String bookName = bookNameTextField.getText();
				int ISBN = Integer.parseInt(bookPublisherTextField.getText());
				db.insertingIntoDB("book", ISBN, bookName);
				
				
				db.closeConnection();
			}
		});
		
		JLabel bookAuthorLabel = new JLabel("\u03A3\u03C5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AD\u03B1\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		bookAuthorLabel.setBounds(6, 45, 144, 14);
		
		bookAuthorTextField = new JTextField();
		bookAuthorTextField.setBounds(154, 42, 179, 20);
		bookAuthorTextField.setColumns(10);
		
		bookSubjectTextField = new JTextField();
		bookSubjectTextField.setBounds(154, 68, 179, 20);
		bookSubjectTextField.setColumns(10);
		
		bookPagesTextField = new JTextField();
		bookPagesTextField.setBounds(154, 94, 179, 20);
		bookPagesTextField.setColumns(10);
		
		bookPublisherTextField = new JTextField();
		bookPublisherTextField.setBounds(154, 120, 179, 20);
		bookPublisherTextField.setColumns(10);
		
		bookEditionTextField = new JTextField();
		bookEditionTextField.setBounds(154, 146, 179, 20);
		bookEditionTextField.setColumns(10);
		
		bookLanguageTextField = new JTextField();
		bookLanguageTextField.setBounds(154, 172, 179, 20);
		bookLanguageTextField.setColumns(10);
		
		JLabel bookSubjectLabel = new JLabel("\u0398\u03AD\u03BC\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		bookSubjectLabel.setBounds(6, 71, 144, 14);
		
		bookPublisherLabel = new JLabel("\u0395\u03BA\u03B4\u03BF\u03C4\u03B9\u03BA\u03CC\u03C2 \u039F\u03AF\u03BA\u03BF\u03C2:");
		bookPublisherLabel.setBounds(6, 123, 144, 14);
		
		ISBNLabel = new JLabel("ISBN:");
		ISBNLabel.setBounds(6, 204, 142, 14);
		
		bookPagesLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03A3\u03B5\u03BB\u03B9\u03B4\u03CE\u03BD:");
		bookPagesLabel.setBounds(6, 97, 144, 14);
		
		bookEditionLabel = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		bookEditionLabel.setBounds(6, 149, 144, 14);
		
		JButton button = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		button.setBounds(209, 239, 81, 23);
		
		JLabel bookLanguageLabel = new JLabel("\u0393\u03BB\u03CE\u03C3\u03C3\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		bookLanguageLabel.setBounds(6, 175, 144, 14);
		
		ISBNtextField = new JTextField();
		ISBNtextField.setBounds(154, 201, 179, 20);
		ISBNtextField.setColumns(10);
		panelData.setLayout(null);
		panelData.add(bookNameLabel);
		panelData.add(bookAuthorLabel);
		panelData.add(bookPagesLabel);
		panelData.add(bookPublisherLabel);
		panelData.add(bookEditionLabel);
		panelData.add(bookSubjectLabel);
		panelData.add(bookLanguageLabel);
		panelData.add(bookLanguageTextField);
		panelData.add(bookEditionTextField);
		panelData.add(bookPublisherTextField);
		panelData.add(bookSubjectTextField);
		panelData.add(bookAuthorTextField);
		panelData.add(bookPagesTextField);
		panelData.add(bookNameTextField);
		panelData.add(ISBNLabel);
		panelData.add(buttonAddBook);
		panelData.add(ISBNtextField);
		panelData.add(button);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{bookNameLabel, bookNameTextField, bookAuthorLabel, bookAuthorTextField, bookSubjectLabel, bookSubjectTextField, bookPublisherLabel, bookPagesTextField, ISBNLabel, bookPublisherTextField, bookPagesLabel, bookEditionTextField, bookEditionLabel, bookLanguageTextField, buttonAddBook, button}));
		
		JTextPane bookNotesTextPane = new JTextPane();
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addContainerGap()
					.addComponent(bookNotesTextPane, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addComponent(bookNotesTextPane, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelButtons.setLayout(gl_panelButtons);
		getContentPane().setLayout(groupLayout);

	}
}
