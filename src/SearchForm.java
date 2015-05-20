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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Font;

public class SearchForm extends JInternalFrame {
	private JTextField bookKeyWordTextField;
	private JTextField memberKeyWordTextField;

	/**
	 * Create the frame.
	 */
	public SearchForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(
				SearchForm.class.getResource("/images/search_16x16.png")));
		setTitle("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 681, 240);

		JPanel searchBookPanel = new JPanel();
		searchBookPanel
				.setBorder(new TitledBorder(
						UIManager.getBorder("TitledBorder.border"),
						"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));

		JPanel searchMemberPanel = new JPanel();
		searchMemberPanel
				.setBorder(new TitledBorder(
						UIManager.getBorder("TitledBorder.border"),
						"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JButton cancelButton = new JButton(
				"\u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(529)
						.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(26)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(cancelButton)
						.addContainerGap()));
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panel,
																Alignment.LEADING,
																0, 0,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				searchBookPanel,
																				GroupLayout.DEFAULT_SIZE,
																				318,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				searchMemberPanel,
																				GroupLayout.DEFAULT_SIZE,
																				319,
																				Short.MAX_VALUE)))
										.addGap(12)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																searchBookPanel,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchMemberPanel,
																GroupLayout.PREFERRED_SIZE,
																132,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(20, Short.MAX_VALUE)));

		JLabel memberSearchByLabel = new JLabel(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03BC\u03B5:");
		memberSearchByLabel.setToolTipText("");
		memberSearchByLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel memberKeyWordLabel = new JLabel(
				"\u039B\u03AD\u03BE\u03B7 \u039A\u03BB\u03B5\u03B9\u03B4\u03AF:");
		memberKeyWordLabel.setToolTipText("");
		memberKeyWordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JComboBox memberSearchComboBox = new JComboBox();
		memberSearchComboBox
				.setModel(new DefaultComboBoxModel(
						new String[] {
								"\u0391\u03C1\u03B9\u03B8\u03BC\u03CC \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5",
								"\u03A4\u03BC\u03AE\u03BC\u03B1" }));

		memberKeyWordTextField = new JTextField();
		memberKeyWordTextField.setColumns(10);

		JButton button = new JButton(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_searchMemberPanel = new GroupLayout(searchMemberPanel);
		gl_searchMemberPanel
				.setHorizontalGroup(gl_searchMemberPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_searchMemberPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_searchMemberPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_searchMemberPanel
																		.createSequentialGroup()
																		.addComponent(
																				memberSearchByLabel,
																				GroupLayout.DEFAULT_SIZE,
																				138,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				memberSearchComboBox,
																				0,
																				135,
																				Short.MAX_VALUE))
														.addGroup(
																gl_searchMemberPanel
																		.createSequentialGroup()
																		.addComponent(
																				memberKeyWordLabel,
																				GroupLayout.DEFAULT_SIZE,
																				138,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				memberKeyWordTextField,
																				GroupLayout.DEFAULT_SIZE,
																				135,
																				Short.MAX_VALUE))
														.addComponent(
																button,
																Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																98,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		gl_searchMemberPanel
				.setVerticalGroup(gl_searchMemberPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_searchMemberPanel
										.createSequentialGroup()
										.addGap(13)
										.addGroup(
												gl_searchMemberPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																memberSearchByLabel,
																GroupLayout.PREFERRED_SIZE,
																26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																memberSearchComboBox,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_searchMemberPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																memberKeyWordLabel,
																GroupLayout.PREFERRED_SIZE,
																26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																memberKeyWordTextField,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(button)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		searchMemberPanel.setLayout(gl_searchMemberPanel);

		JLabel bookSearchByLabel = new JLabel(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03BC\u03B5:");
		bookSearchByLabel.setToolTipText("");
		bookSearchByLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JComboBox bookSearchComboBox = new JComboBox();
		bookSearchComboBox
				.setModel(new DefaultComboBoxModel(
						new String[] {
								"\u038C\u03BD\u03BF\u03BC\u03B1",
								"\u03A3\u03C5\u03B3\u03B3\u03C1\u03B1\u03C6\u03AD\u03B1",
								"\u0398\u03AD\u03BC\u03B1",
								"\u0395\u03BA\u03B4\u03BF\u03C4\u03B9\u03BA\u03CC \u039F\u03AF\u03BA\u03BF",
								"ISBN" }));

		JLabel bookKeyWordLabel = new JLabel(
				"\u039B\u03AD\u03BE\u03B7 \u039A\u03BB\u03B5\u03B9\u03B4\u03AF:");
		bookKeyWordLabel.setToolTipText("");
		bookKeyWordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		bookKeyWordTextField = new JTextField();
		bookKeyWordTextField.setColumns(10);

		JButton searchBookButton = new JButton(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		GroupLayout gl_searchBookPanel = new GroupLayout(searchBookPanel);
		gl_searchBookPanel
				.setHorizontalGroup(gl_searchBookPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_searchBookPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_searchBookPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_searchBookPanel
																		.createSequentialGroup()
																		.addComponent(
																				bookSearchByLabel,
																				GroupLayout.DEFAULT_SIZE,
																				138,
																				Short.MAX_VALUE)
																		.addGap(10)
																		.addComponent(
																				bookSearchComboBox,
																				0,
																				135,
																				Short.MAX_VALUE))
														.addGroup(
																gl_searchBookPanel
																		.createSequentialGroup()
																		.addComponent(
																				bookKeyWordLabel,
																				GroupLayout.DEFAULT_SIZE,
																				138,
																				Short.MAX_VALUE)
																		.addGap(10)
																		.addComponent(
																				bookKeyWordTextField,
																				GroupLayout.DEFAULT_SIZE,
																				135,
																				Short.MAX_VALUE))
														.addComponent(
																searchBookButton,
																GroupLayout.PREFERRED_SIZE,
																98,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		gl_searchBookPanel
				.setVerticalGroup(gl_searchBookPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_searchBookPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_searchBookPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																bookSearchByLabel,
																GroupLayout.PREFERRED_SIZE,
																26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																bookSearchComboBox,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_searchBookPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																bookKeyWordLabel,
																GroupLayout.PREFERRED_SIZE,
																26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																bookKeyWordTextField,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(searchBookButton)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		searchBookPanel.setLayout(gl_searchBookPanel);
		getContentPane().setLayout(groupLayout);

	}
}