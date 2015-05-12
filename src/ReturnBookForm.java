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


public class ReturnBookForm extends JInternalFrame {
	private JTextField ISBNTextField;
	private JTextField IDTextField;
	private JTextField returnDayTextField;
	private JTextField fineTextField;
	private JLabel fineLabel;
	private JTextField reviewTextField;


	/**
	 * Create the frame.
	 */
	public ReturnBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(ReturnBookForm.class.getResource("/images/inbox_download_16x16.png")));
		setTitle("Return Book");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 385, 402);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
		
		JButton buttonReturnBook = new JButton("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		
		JLabel IDLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
		
		IDTextField = new JTextField();
		IDTextField.setColumns(10);
		
		returnDayTextField = new JTextField();
		returnDayTextField.setColumns(10);
		
		fineTextField = new JTextField();
		fineTextField.setColumns(10);
		
		JLabel returnDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2:");
		
		fineLabel = new JLabel("\u03A0\u03C1\u03CC\u03C3\u03C4\u03B9\u03BC\u03BF/\u0397\u03BC\u03AD\u03C1\u03B1:");
		
		JButton buttonExit = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		
		JLabel reviewLabel = new JLabel("A\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		
		reviewTextField = new JTextField();
		reviewTextField.setColumns(10);
		GroupLayout gl_panelData = new GroupLayout(panelData);
		gl_panelData.setHorizontalGroup(
			gl_panelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelData.createSequentialGroup()
					.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelData.createSequentialGroup()
							.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING)
								.addComponent(fineLabel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addComponent(returnDayLabel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addComponent(IDLabel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addComponent(ISBNLabel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(returnDayTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(IDTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(fineTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(ISBNTextField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
						.addGroup(gl_panelData.createSequentialGroup()
							.addGroup(gl_panelData.createParallelGroup(Alignment.TRAILING)
								.addComponent(buttonReturnBook)
								.addComponent(reviewLabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelData.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelData.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(reviewTextField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panelData.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(buttonExit, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(43)))))
					.addContainerGap())
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
						.addComponent(IDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(returnDayTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(returnDayLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(fineTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(fineLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(reviewLabel)
						.addComponent(reviewTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(100)
					.addGroup(gl_panelData.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonReturnBook)
						.addComponent(buttonExit))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelData.setLayout(gl_panelData);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ISBNLabel, ISBNTextField, IDLabel, IDTextField, returnDayLabel, returnDayTextField, fineLabel, fineTextField, buttonReturnBook, buttonExit}));
		
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
