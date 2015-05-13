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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class ReturnBookForm extends JInternalFrame {
 private JTextField IDTextField;
 private JTextField returnDayTextField;
 private JTextField fineTextField;
 private JLabel evaluationLabel;
 private JButton returnBookButton;
 private JTextField ISBNTextField;
 private JLabel fineLabel;
 private JButton cancelButton;
 private JRadioButton evaluationRadioButton1;
 private JRadioButton evaluationRadioButton2;
 private JRadioButton evaluationRadioButton3;
 private JRadioButton evaluationRadioButton4;
 private JRadioButton evaluationRadioButton5;
 private final ButtonGroup buttonGroup = new ButtonGroup();
 private JPanel evaluationPanel;


 /**
  * Create the frame.
  */
 public ReturnBookForm() {
  setResizable(true);
  setFrameIcon(new ImageIcon(ReturnBookForm.class.getResource("/images/inbox_download_16x16.png")));
  setTitle("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
  setIconifiable(true);
  setClosable(true);
  setBounds(0, 0, 400, 281);
  
  JPanel panelData = new JPanel();
  panelData.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
  GroupLayout groupLayout = new GroupLayout(getContentPane());
  groupLayout.setHorizontalGroup(
  	groupLayout.createParallelGroup(Alignment.TRAILING)
  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
  			.addContainerGap()
  			.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
  			.addContainerGap())
  );
  groupLayout.setVerticalGroup(
  	groupLayout.createParallelGroup(Alignment.LEADING)
  		.addGroup(groupLayout.createSequentialGroup()
  			.addContainerGap()
  			.addComponent(panelData, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
  			.addContainerGap(53, Short.MAX_VALUE))
  );
  
    
  
  
  JLabel IDLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u039C\u03B7\u03C4\u03C1\u03CE\u03BF\u03C5:");
  
  IDTextField = new JTextField();
  IDTextField.setColumns(10);
  
  returnBookButton = new JButton("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
  returnBookButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    
    
   }
  });
  panelData.setLayout(new GridLayout(0, 2, 0, 0));
  
  JLabel ISBNLabel = new JLabel("ISBN \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
  panelData.add(ISBNLabel);
  
  ISBNTextField = new JTextField();
  ISBNTextField.setColumns(10);
  panelData.add(ISBNTextField);
  panelData.add(IDLabel);
  panelData.add(IDTextField);
  
  JLabel returnDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2:");
  panelData.add(returnDayLabel);
  panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{IDLabel, IDTextField, returnDayLabel, returnDayTextField, fineLabel, fineTextField,evaluationLabel, evaluationPanel, returnBookButton, cancelButton}));
  
  returnDayTextField = new JTextField();
  returnDayTextField.setColumns(10);
  panelData.add(returnDayTextField);
  
  fineLabel = new JLabel("\u03A0\u03C1\u03CC\u03C3\u03C4\u03B9\u03BC\u03BF /  \u0397\u03BC\u03AD\u03C1\u03B1:");
  panelData.add(fineLabel);
  
  fineTextField = new JTextField();
  fineTextField.setColumns(10);
  panelData.add(fineTextField);
  
  evaluationLabel = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
  panelData.add(evaluationLabel);
  
  evaluationPanel = new JPanel();
  panelData.add(evaluationPanel);
  evaluationPanel.setBorder(null);
  
  evaluationRadioButton2 = new JRadioButton("2");
  buttonGroup.add(evaluationRadioButton2);
  
  evaluationRadioButton3 = new JRadioButton("3");
  buttonGroup.add(evaluationRadioButton3);
  evaluationRadioButton3.setSelected(true);
  
  evaluationRadioButton4 = new JRadioButton("4");
  buttonGroup.add(evaluationRadioButton4);
  
  evaluationRadioButton5 = new JRadioButton("5");
  buttonGroup.add(evaluationRadioButton5);
  evaluationPanel.setLayout(new GridLayout(0, 5, 0, 0));
  
  evaluationRadioButton1 = new JRadioButton("1");
  buttonGroup.add(evaluationRadioButton1);
  evaluationPanel.add(evaluationRadioButton1);
  evaluationPanel.add(evaluationRadioButton2);
  evaluationPanel.add(evaluationRadioButton3);
  evaluationPanel.add(evaluationRadioButton4);
  evaluationPanel.add(evaluationRadioButton5);
  panelData.add(returnBookButton);
  
  cancelButton = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
  cancelButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
   }
  });
  panelData.add(cancelButton);
  getContentPane().setLayout(groupLayout);

 }
}