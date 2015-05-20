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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * @throws ParseException 
	 */
	public BorrowBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(
				BorrowBookForm.class
						.getResource("/images/inbox_upload_16x16.png")));
		setTitle("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 350, 240);

		JPanel panelData = new JPanel();
		panelData
				.setBorder(new TitledBorder(
						UIManager.getBorder("TitledBorder.border"),
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

		JLabel ISBNLabel = new JLabel(
				"ISBN \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");

		ISBNTextField = new JTextField();
		ISBNTextField.setColumns(10);

		JButton cancelButton = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		panelData.add(ISBNLabel);
		panelData.add(ISBNTextField);

		JLabel IDLabel = new JLabel(
				"\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
		panelData.add(IDLabel);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { ISBNLabel, ISBNTextField, IDLabel,
						IDtextField, borrowDayLabel, borrowDayTextField,
						returnDayLabel, returnDayTextField, borrowBookButton,
						cancelButton }));

		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		panelData.add(IDtextField);

		borrowDayLabel = new JLabel(
				"\u0397\u03BC\u03AD\u03C1\u03B1 \u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03BF\u03CD:");
		panelData.add(borrowDayLabel);

		String borrowDay = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());
		borrowDayTextField = new JTextField(borrowDay);
		borrowDayTextField.setHorizontalAlignment(SwingConstants.CENTER);
		borrowDayTextField.setBackground(Color.LIGHT_GRAY);
		borrowDayTextField.setColumns(10);
		panelData.add(borrowDayTextField);

		returnDayLabel = new JLabel(
				"\u0397\u03BC\u03AD\u03C1\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2:");
		panelData.add(returnDayLabel);
		
		//String returnDay = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());
		
		Calendar c = Calendar.getInstance();
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		c.setTime(dt); 
		c.add(Calendar.DATE, 7);
		dt = c.getTime();
		String returnDay = df.format(dt);
		
		returnDayTextField = new JTextField(returnDay);
		returnDayTextField.setHorizontalAlignment(SwingConstants.CENTER);
		returnDayTextField.setBackground(Color.LIGHT_GRAY);
		returnDayTextField.setColumns(10);
		panelData.add(returnDayTextField);

		borrowBookButton = new JButton(
				"\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2");
		borrowBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panelData.add(borrowBookButton);
		panelData.add(cancelButton);
		getContentPane().setLayout(groupLayout);

	}
}
