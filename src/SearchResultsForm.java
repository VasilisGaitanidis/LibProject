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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DropMode;

public class SearchResultsForm extends JInternalFrame {
	private JTextField searchResultsTextField;

	/**
	 * Create the frame.
	 */
	public SearchResultsForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(
				SearchForm.class.getResource("/images/search_16x16.png")));
		setTitle("\u0391\u03C0\u03BF\u03C4\u03B5\u03BB\u03AD\u03C3\u03BC\u03B1\u03C4\u03B1");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 691, 529);

		JPanel searchResultsPanel = new JPanel();
		searchResultsPanel
				.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0391\u03C0\u03BF\u03C4\u03B5\u03BB\u03AD\u03C3\u03BC\u03B1\u03C4\u03B1 \u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(searchResultsPanel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchResultsPanel, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		searchResultsTextField = new JTextField();
		searchResultsTextField.setBackground(Color.WHITE);
		searchResultsTextField.setEditable(false);
		searchResultsTextField.setColumns(10);
		GroupLayout gl_searchResultsPanel = new GroupLayout(searchResultsPanel);
		gl_searchResultsPanel.setHorizontalGroup(
			gl_searchResultsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_searchResultsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchResultsTextField, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_searchResultsPanel.setVerticalGroup(
			gl_searchResultsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_searchResultsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchResultsTextField, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
					.addContainerGap())
		);
		searchResultsPanel.setLayout(gl_searchResultsPanel);
		getContentPane().setLayout(groupLayout);

	}
}