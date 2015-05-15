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
import java.awt.GridLayout;
import javax.swing.UIManager;
import java.awt.Color;

public class AddMemberForm extends JInternalFrame {
	private JTextField studentNameTextField;
	private JTextField studentSurnameTextField;
	private JTextField IDTextField;
	private JTextField departmentTextField;
	private JTextField emailTextField;
	private JLabel departmentLabel;
	private JLabel emailLabel;
	private JButton addMemberButton;
	private JLabel IDLabel;
	private JButton cancelButton;
	private JLabel studentNameLabel;

	/**
	 * Create the frame.
	 */
	public AddMemberForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(
				AddMemberForm.class.getResource("/images/user_add_16x16.png")));
		setTitle("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 380, 236);

		JPanel panelData = new JPanel();
		panelData
				.setBorder(new TitledBorder(
						UIManager.getBorder("TitledBorder.border"),
						"\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 364,
								Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panelData, GroupLayout.PREFERRED_SIZE,
								185, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(174, Short.MAX_VALUE)));

		studentNameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");

		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		panelData.add(studentNameLabel);
		panelData.add(studentNameTextField);

		JLabel studentSurnameLabel = new JLabel(
				"\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF:");
		panelData.add(studentSurnameLabel);

		studentSurnameTextField = new JTextField();
		studentSurnameTextField.setColumns(10);
		panelData.add(studentSurnameTextField);

		IDLabel = new JLabel(
				"\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
		panelData.add(IDLabel);

		IDTextField = new JTextField();
		IDTextField.setColumns(10);
		panelData.add(IDTextField);

		departmentLabel = new JLabel("\u03A4\u03BC\u03AE\u03BC\u03B1:");
		panelData.add(departmentLabel);

		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		panelData.add(departmentTextField);

		emailLabel = new JLabel("E-Mail:");
		panelData.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		panelData.add(emailTextField);

		cancelButton = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		addMemberButton = new JButton(
				"\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DatabaseHandling db = new DatabaseHandling();
				db.establishConnection();
				String bookName = studentNameTextField.getText();
				int ISBN = Integer.parseInt(emailTextField.getText());
				db.insertingIntoDB("book", ISBN, bookName);

				db.closeConnection();
			}
		});
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { studentNameLabel, studentNameTextField,
						studentSurnameLabel, studentSurnameTextField, IDLabel,
						IDTextField, departmentLabel, departmentTextField,
						emailLabel, emailTextField, addMemberButton,
						cancelButton }));
		panelData.add(addMemberButton);
		panelData.add(cancelButton);
		getContentPane().setLayout(groupLayout);

	}
}