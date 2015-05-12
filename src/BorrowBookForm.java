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
import javax.swing.UIManager;
import java.awt.Color;


public class BorrowBookForm extends JInternalFrame {
	private JTextField ISBNTextField;
	private JTextField IDtextField;
	private JTextField borrowDayTextField;
	private JTextField returnDayTextField;
	private JLabel returnDayLabel;


	/**
	 * Create the frame.
	 */
	public BorrowBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(BorrowBookForm.class.getResource("/images/inbox_upload_16x16.png")));
		setTitle("Borrow Book");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 385, 402);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
		
		JLabel ISBNLabel = new JLabel("ISBN \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		ISBNTextField = new JTextField();
		ISBNTextField.setColumns(10);
		
		JButton buttonBorrowBook = new JButton("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2");
		
		JLabel IDLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		
		borrowDayTextField = new JTextField();
		borrowDayTextField.setColumns(10);
		
		returnDayTextField = new JTextField();
		returnDayTextField.setColumns(10);
		
		JLabel borrowDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03BF\u03CD:");
		
		returnDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2:");
		
		JButton buttonExit = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		GroupLayout gl_panelData = new GroupLayout(panelData);
		gl_panelData.setHorizontalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelData.createSequentialGroup()
							.addContainerGap(53, Short.MAX_VALUE)
							.addComponent(buttonBorrowBook))
						.addComponent(returnDayLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(borrowDayLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(IDLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(ISBNLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelData.createSequentialGroup()
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(borrowDayTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(IDtextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(returnDayTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(ISBNTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addComponent(buttonExit, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(50))))
		);
		gl_panelData.setVerticalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(ISBNLabel)
						.addComponent(ISBNTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(IDLabel)
						.addComponent(IDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(borrowDayTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(borrowDayLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(returnDayTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(returnDayLabel))
					.addGap(125)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonBorrowBook)
						.addComponent(buttonExit))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelData.setLayout(gl_panelData);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ISBNLabel, ISBNTextField, IDLabel, IDtextField, borrowDayLabel, borrowDayTextField, returnDayLabel, returnDayTextField, buttonBorrowBook, buttonExit}));
		
		JTextPane borrowNotesTextPane = new JTextPane();
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addContainerGap()
					.addComponent(borrowNotesTextPane, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addComponent(borrowNotesTextPane, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelButtons.setLayout(gl_panelButtons);
		getContentPane().setLayout(groupLayout);

	}
}
