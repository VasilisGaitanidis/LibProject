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
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class BorrowBookForm extends JInternalFrame {
	private JTextField ISBNTextField;
	private JTextField IDtextField;
	private JTextField borrowDayTextField;
	private JTextField returnDayTextField;
	private JLabel returnDayLabel;
	private JLabel borrowDayLabel;
	private JButton borrowBookButton;


	/**
	 * Create the frame.
	 */
	public BorrowBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(BorrowBookForm.class.getResource("/images/inbox_upload_16x16.png")));
		setTitle("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 484, 380);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new TitledBorder(null, "\u03A3\u03B7\u03BC\u03B5\u03B9\u03CE\u03C3\u03B5\u03B9\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
						.addComponent(panelData, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JLabel ISBNLabel = new JLabel("ISBN \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		ISBNTextField = new JTextField();
		ISBNTextField.setColumns(10);
		
		JButton cancelButton = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		panelData.add(ISBNLabel);
		panelData.add(ISBNTextField);
		
		JLabel IDLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
		panelData.add(IDLabel);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ISBNLabel, ISBNTextField, IDLabel, IDtextField, borrowDayLabel, borrowDayTextField, returnDayLabel, returnDayTextField, borrowBookButton, cancelButton}));
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		panelData.add(IDtextField);
		
		borrowDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03BF\u03CD:");
		panelData.add(borrowDayLabel);
		
		borrowDayTextField = new JTextField();
		borrowDayTextField.setColumns(10);
		panelData.add(borrowDayTextField);
		
		returnDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2:");
		panelData.add(returnDayLabel);
		
		returnDayTextField = new JTextField();
		returnDayTextField.setColumns(10);
		panelData.add(returnDayTextField);
		
		borrowBookButton = new JButton("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2");
		panelData.add(borrowBookButton);
		panelData.add(cancelButton);
		
		JTextPane borrowNotesTextPane = new JTextPane();
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addContainerGap()
					.addComponent(borrowNotesTextPane, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addComponent(borrowNotesTextPane, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelButtons.setLayout(gl_panelButtons);
		getContentPane().setLayout(groupLayout);

	}
}
