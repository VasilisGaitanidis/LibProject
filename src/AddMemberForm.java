import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
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


	/**
	 * Create the frame.
	 */
	public AddMemberForm() {
		setTitle("Add Member");
		setFrameIcon(new ImageIcon(AddMemberForm.class.getResource("/images/user_add_16x16.png")));
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setBounds(0, 0, 385, 402);
		
		JPanel panelData = new JPanel();
		panelData.setForeground(Color.BLACK);
		panelData.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

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

		JLabel studentNameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");

		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);

		JButton buttonAddMember = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");

		JLabel studentSurnameLabel = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF:");

		studentSurnameTextField = new JTextField();
		studentSurnameTextField.setColumns(10);

		IDTextField = new JTextField();
		IDTextField.setColumns(10);

		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);

		JLabel IDLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");

		departmentLabel = new JLabel("\u03A4\u03BC\u03AE\u03BC\u03B1:");

		emailLabel = new JLabel("E-Mail:");

		JButton button = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		GroupLayout gl_panelData = new GroupLayout(panelData);
		gl_panelData.setHorizontalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelData.createSequentialGroup()
							.addContainerGap()
							.addComponent(buttonAddMember))
						.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
							.addComponent(emailLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addComponent(departmentLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addComponent(IDLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addComponent(studentSurnameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addComponent(studentNameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelData.createSequentialGroup()
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(IDTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(studentSurnameTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(departmentTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(studentNameTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(54))))
		);
		gl_panelData.setVerticalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentNameLabel)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentSurnameLabel)
						.addComponent(studentSurnameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(IDTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(IDLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(departmentTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(departmentLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(buttonAddMember))
					.addContainerGap())
		);
		panelData.setLayout(gl_panelData);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{studentNameLabel, studentNameTextField, studentSurnameLabel, studentSurnameTextField, IDLabel, IDTextField, departmentLabel, departmentTextField, emailLabel, emailTextField, buttonAddMember, button}));

		JTextPane studentNotesTextPane = new JTextPane();
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
				gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
						.addContainerGap()
						.addComponent(studentNotesTextPane, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panelButtons.setVerticalGroup(
				gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
						.addComponent(studentNotesTextPane, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addContainerGap())
				);
		panelButtons.setLayout(gl_panelButtons);
		getContentPane().setLayout(groupLayout);

	}

}
