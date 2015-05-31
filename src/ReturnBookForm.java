import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.classes.dto.Book;
import model.classes.dto.Member;
import model.classes.dto.MemberBook;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ReturnBookForm extends JInternalFrame {
	private JTextField returnDayTextField;
	private JTextField fineTextField;
	private JLabel evaluationLabel;
	private JButton returnBookButton;
	private JTextField borrowIDTextField;
	private JLabel fineLabel;
	private JButton clearButton;
	private JSpinner evaluationSpinner;
	
	private String deliveryDay;

	/**
	 * Creates the Return Book frame.Listeners at the end!
	 */
	public ReturnBookForm() {
		setResizable(true);
		setFrameIcon(new ImageIcon(
				ReturnBookForm.class.getResource("/images/inbox_download_16x16.png")));
		setTitle("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 330, 202);

		JPanel panelData = new JPanel();
		panelData
				.setBorder(new TitledBorder(
						UIManager.getBorder("TitledBorder.border"),
						"\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelData, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addContainerGap())
		);

		
		panelData.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel borrowIDLabel = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03BF\u03CD:");
		panelData.add(borrowIDLabel);

		borrowIDTextField = new JTextField();
		borrowIDTextField.setColumns(10);
		panelData.add(borrowIDTextField);

		JLabel returnDayLabel = new JLabel("\u0397\u03BC\u03AD\u03C1\u03B1 \u03A0\u03B1\u03C1\u03AC\u03B4\u03BF\u03C3\u03B7\u03C2:");
		panelData.add(returnDayLabel);
		//Takes the system's date automatically
		deliveryDay = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());		
		returnDayTextField = new JTextField(deliveryDay);
		returnDayTextField.setHorizontalAlignment(SwingConstants.CENTER);
		returnDayTextField.setBackground(Color.LIGHT_GRAY);
		returnDayTextField.setColumns(10);
		panelData.add(returnDayTextField);

		fineLabel = new JLabel("\u03A0\u03C1\u03CC\u03C3\u03C4\u03B9\u03BC\u03BF /  \u0397\u03BC\u03AD\u03C1\u03B1:");
		panelData.add(fineLabel);
		
		
		fineTextField = new JTextField();
		fineTextField.setColumns(10);
		panelData.add(fineTextField);

		evaluationLabel = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5:");
		panelData.add(evaluationLabel);
		
		//Book Evaluation Spinner(min=1,max=5 ,starting value=1,pace=1)
		evaluationSpinner = new JSpinner();
		evaluationSpinner.setModel(new SpinnerNumberModel(1.0, 1.0, 5.0, 1.0));
		evaluationSpinner.setEditor(new JSpinner.DefaultEditor(evaluationSpinner));
		panelData.add(evaluationSpinner);
		
		returnBookButton = new JButton("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		returnBookButton.addActionListener(new ReturnBookActionListener());
		
		
		panelData.add(returnBookButton);

		clearButton = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clearButton.addActionListener(new ClearButtonActionListener());
		panelData.add(clearButton);
		panelData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{returnDayLabel}));
		getContentPane().setLayout(groupLayout);

	}
	//Return Book Button Action Listener
	class ReturnBookActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Connection with Database via Hibernate
			Configuration configuration = new Configuration();
		    configuration.configure();
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			//New Session
		    Session session = sessionFactory.openSession();
			//Gets the text from TextFields
			int borrowID = Integer.parseInt(borrowIDTextField.getText());
			//Fine per day of delay
			double fine = Double.parseDouble(fineTextField.getText());
			//Gets the member from table "Δανεισμοί" with the specific ID given
			MemberBook mb = (MemberBook) session.get(MemberBook.class, borrowID);
			//Sets the delivery Date (System Date)
			mb.setDeliveryDay(deliveryDay);
			//Gets the member and the book according to the values(ISBN and ID) from table "Δανεισμοί"
			Member member = mb.getMember();
			Book book = mb.getBook();
			//Initialize days
			Date d1 = null;
			Date d2 = null;
			//Gets return day from table
			String returnDay = mb.getReturnDay();
			//Sets the two days to simple format
			try {
				d1 = new SimpleDateFormat("dd-MM-yy").parse(deliveryDay);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			/*System.out.println(deliveryDay);
			System.out.println(returnDay);*/
			
			try {
				d2 = new SimpleDateFormat("dd-MM-yy").parse(returnDay);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
			//Difference from 2 days
			long diff = d1.getTime() - d2.getTime();
			long diffDays = (diff + 12 * 60 * 60 * 1000) / (24 * 60 * 60 * 1000);
			//System.out.println(diffDays);
			//If user is late announces the fine
			if(diffDays>0) {
				//Total Fine = overdue days * fine per day
				double latePoints = diffDays * fine;
				String latePointsString = Double.toString(latePoints);
				JOptionPane.showMessageDialog(null,
						"Ημέρες Αργοπορίας " + diffDays + " και πρόστιμο " + latePointsString + "€", "Πρόστιμο!",
						JOptionPane.WARNING_MESSAGE);
				//System.out.println(latePoints);
				//Member's late points + fine
				double totalLatePoints = member.getLatePoints() + latePoints;
				//Sets the fine to the member
				member.setLatePoints(totalLatePoints);
			}
			
			//Times the book has been borrowed
			int totalBorrows = book.getnOBorrows() + 1;
			book.setnOBorrows(totalBorrows);
			//System.out.println("Synolikoi Daneismoi=" + totalBorrows);
			
			//Book Evaluation
			//Spinner's value
			double evaluation = (double)(evaluationSpinner.getValue());
			//Gets book's previous evaluation
			double previousEval = book.getBookEvaluation();
			//Sets new evaluation
	        double evAverage = (previousEval + evaluation) / totalBorrows;
			book.setBookEvaluation(evAverage);
	        //System.out.println("Synolikoi Daneismoi=" + totalBorrows + ", Aksiologisi=" + evAverage);
	            
	        
			// nobody has the book
			book.setMember(null);
			//Saves the Book,Member and the borrow tables
			session.beginTransaction();
			session.saveOrUpdate(book);
			session.saveOrUpdate(member);
			session.saveOrUpdate(mb);
			session.getTransaction().commit();
			//Closing session
			session.close();
			
		}
	}
	//Button katharismou pediwn
	class ClearButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			borrowIDTextField.setText(null);
			fineTextField.setText(null);
			
		}
		
	}
}