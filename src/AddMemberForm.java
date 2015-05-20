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

import model.classes.dto.Member;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddMemberForm extends JInternalFrame {
	private JTextField studentNameTextField;
	private JTextField studentSurnameTextField;
	private JTextField IDTextField;
	private JTextField emailTextField;
	private JLabel departmentLabel;
	private JLabel emailLabel;
	private JButton addMemberButton;
	private JLabel IDLabel;
	private JButton cancelButton;
	private JLabel studentNameLabel;
	private JComboBox departmentComboBox;

	/**
	 * Dhmiourgia tou Frame.
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
		
		departmentComboBox = new JComboBox();
		departmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u039F\u0394\u0395", "\u039B\u03A7", "\u0395\u03A0", "\u0394\u0395\u03A3", "\u0395\u039A\u03A0", "\u039C\u0395\u03A4", "\u039F\u0395", "\u0392\u03A3\u0391\u03A3"}));
		panelData.add(departmentComboBox);

		emailLabel = new JLabel("E-Mail:");
		panelData.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		panelData.add(emailTextField);

		cancelButton = new JButton("\u0386\u03BA\u03C5\u03C1\u03BF");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		addMemberButton = new JButton(
				"\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addMemberButton.addActionListener(new ActionListener() { //--->Button Prosthikhs Melous
			public void actionPerformed(ActionEvent arg0) {
				Member member = new Member();
				String studentName = studentNameTextField.getText();
				String studentSurname = studentSurnameTextField.getText();
				String iD = IDTextField.getText();
				String department = departmentComboBox.getSelectedItem().toString();
				String email = emailTextField.getText();
				
				member.setStudentName(studentName);
				member.setStudentSurname(studentSurname);
				member.setiD(iD);
				member.setDepartment(department);
				member.setEmail(email);
				
				Configuration configuration = new Configuration();//Connection me Database kai eggrafh stoixeiwn apo TExtFields
			    configuration.configure();
			    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
			            configuration.getProperties()).build();
			    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.saveOrUpdate(member);
				session.getTransaction().commit();
				session.close();				
			}
		});
		panelData.add(addMemberButton);
		panelData.add(cancelButton);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{studentNameLabel, studentNameTextField, studentSurnameLabel, studentSurnameTextField, IDLabel, IDTextField, departmentLabel, emailLabel, emailTextField, addMemberButton, cancelButton}));
		getContentPane().setLayout(groupLayout);

	}
}