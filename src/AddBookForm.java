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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel publisherLabel;
	private JLabel ISBNLabel;
	private JLabel numberOfPagesLabel;
	private JLabel editionNumberLabel;
	private JButton buttonAddBook;


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
		
				
		
		
		JLabel bookNamelLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		buttonAddBook = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		buttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DatabaseHandling db = new DatabaseHandling();
				db.establishConnection();
				String bookName = textField.getText();
				int ISBN = Integer.parseInt(textField_4.getText());
				db.insertingIntoDB("book", ISBN, bookName);
				
				
				db.closeConnection();
			}
		});
		
		JLabel authorLabel = new JLabel("\u03A3\u03C5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AD\u03B1\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel bookSubjectLabel = new JLabel("\u0398\u03AD\u03BC\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		publisherLabel = new JLabel("\u0395\u03BA\u03B4\u03BF\u03C4\u03B9\u03BA\u03CC\u03C2 \u039F\u03AF\u03BA\u03BF\u03C2:");
		
		ISBNLabel = new JLabel("ISBN:");
		
		numberOfPagesLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03A3\u03B5\u03BB\u03B9\u03B4\u03CE\u03BD:");
		
		editionNumberLabel = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		JButton button = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		GroupLayout gl_panelData = new GroupLayout(panelData);
		gl_panelData.setHorizontalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelData.createSequentialGroup()
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(editionNumberLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(ISBNLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panelData.createParallelGroup(Alignment.LEADING)
									.addComponent(publisherLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(bookSubjectLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(authorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(bookNamelLabel, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
								.addComponent(numberOfPagesLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addContainerGap(246, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addContainerGap(246, Short.MAX_VALUE)
							.addComponent(buttonAddBook)))
					.addContainerGap())
		);
		gl_panelData.setVerticalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookNamelLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(authorLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookSubjectLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(publisherLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBNLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(numberOfPagesLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editionNumberLabel))
					.addGap(18)
					.addComponent(buttonAddBook)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelData.setLayout(gl_panelData);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{bookNamelLabel, textField, authorLabel, textField_1, bookSubjectLabel, textField_2, publisherLabel, textField_3, ISBNLabel, textField_4, numberOfPagesLabel, textField_5, editionNumberLabel, textField_6, buttonAddBook, button}));
		
		JTextPane textPane = new JTextPane();
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelButtons.setLayout(gl_panelButtons);
		getContentPane().setLayout(groupLayout);

	}
}
