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

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel publisherLabel;
	private JLabel ISBNLabel;


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

		JLabel bookNamelLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton buttonAddMember = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");

		JLabel authorLabel = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF:");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel label = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");

		publisherLabel = new JLabel("\u03A3\u03C7\u03BF\u03BB\u03AE:");

		ISBNLabel = new JLabel("\u03A4\u03BC\u03AE\u03BC\u03B1:");

		JButton button = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		GroupLayout gl_panelData = new GroupLayout(panelData);
		gl_panelData.setHorizontalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING)
								.addComponent(ISBNLabel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(publisherLabel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(authorLabel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(bookNamelLabel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addContainerGap(246, Short.MAX_VALUE)
							.addComponent(buttonAddMember))
						.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
							.addContainerGap(246, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(publisherLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBNLabel))
					.addGap(70)
					.addComponent(buttonAddMember)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(button))
		);
		panelData.setLayout(gl_panelData);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{bookNamelLabel, textField, authorLabel, textField_1, label, textField_2, publisherLabel, textField_3, ISBNLabel, textField_4, buttonAddMember, button}));

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
