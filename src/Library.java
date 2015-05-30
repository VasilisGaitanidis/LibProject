import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.classes.dto.Book;
import model.classes.dto.Member;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Library extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem exitJMenuItem, addBookJMenuItem, popularBookJMenuItem,
			addMemberJMenuItem, bannedMemberJÌenuItem, borrowBookJMenuItem,
			returnBookJMenuItem, searchJMenuItem;
	private JToolBar toolBar;
	private JButton btnAddBook, btnPopularBook, btnAddMember, btnBannedMember,
			btnBorrowBook, btnReturnBook, btnSearch;
	private JDesktopPane desktopPane;
	private AddBookForm addBookForm;
	private AddMemberForm addMemberForm;
	private BorrowBookForm borrowBookForm;
	private ReturnBookForm returnBookForm;
	private SearchForm searchForm;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Library() {

		initComponents();
	}

	private void initComponents() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Library.class.getResource("/images/Library_Folder_64x64.png")));
		setTitle("\u03A3\u03CD\u03C3\u03C4\u03B7\u03BC\u03B1 \u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7\u03C2 \u0392\u03B9\u03B2\u03BB\u03B9\u03BF\u03B8\u03AE\u03BA\u03B7\u03C2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);

		// Create the menu bar.
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileJMenu = new JMenu("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF");
		menuBar.add(fileJMenu);

		exitJMenuItem = new JMenuItem("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		exitJMenuItem.addActionListener(new ExitActionListener());
		exitJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				InputEvent.ALT_MASK));
		exitJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/exit_16x16.png")));
		fileJMenu.add(exitJMenuItem);

		JMenu booksJMenu = new JMenu("\u0392\u03B9\u03B2\u03BB\u03AF\u03B1");
		menuBar.add(booksJMenu);

		addBookJMenuItem = new JMenuItem(
				"\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		addBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
				InputEvent.CTRL_MASK));
		addBookJMenuItem.addActionListener(new AddBookActionListener());
		addBookJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/add_book_16x16.png")));
		booksJMenu.add(addBookJMenuItem);

		popularBookJMenuItem = new JMenuItem(
				"\u0394\u03B7\u03BC\u03BF\u03C6\u03B9\u03BB\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03B1");
		popularBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_P, InputEvent.CTRL_MASK));
		popularBookJMenuItem
				.addActionListener(new PopularBooksActionListener());
		popularBookJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/chart_arrow_16x16.png")));
		booksJMenu.add(popularBookJMenuItem);

		/*
		 * JMenuItem listBookJMenuItem = new JMenuItem(
		 * "\u039B\u03AF\u03C3\u03C4\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03C9\u03BD"
		 * ); booksJMenu.add(listBookJMenuItem);
		 */

		JMenu membersJMenu = new JMenu("\u039C\u03AD\u03BB\u03B7");
		menuBar.add(membersJMenu);

		addMemberJMenuItem = new JMenuItem(
				"\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2");
		addMemberJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK));
		addMemberJMenuItem.addActionListener(new AddMemberActionListener());
		addMemberJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/user_add_16x16.png")));
		membersJMenu.add(addMemberJMenuItem);

		bannedMemberJÌenuItem = new JMenuItem(
				"\u0391\u03C3\u03C5\u03BD\u03B5\u03C0\u03B5\u03AF\u03C2 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B5\u03C2");
		bannedMemberJÌenuItem
				.addActionListener(new BannedMembersActionListener());
		bannedMemberJÌenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/user_ban_16x16.png")));
		membersJMenu.add(bannedMemberJÌenuItem);

		/*
		 * JMenuItem listMemberJMenuItem = new
		 * JMenuItem("\u039B\u03AF\u03C3\u03C4\u03B1 \u039C\u03B5\u03BB\u03CE\u03BD"
		 * ); membersJMenu.add(listMemberJMenuItem);
		 */

		JMenu loanJMenu = new JMenu(
				"\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2");
		menuBar.add(loanJMenu);

		borrowBookJMenuItem = new JMenuItem(
				"\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		borrowBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_D, InputEvent.CTRL_MASK));
		borrowBookJMenuItem.addActionListener(new BorrowBookActionListener());
		borrowBookJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/inbox_upload_16x16.png")));
		loanJMenu.add(borrowBookJMenuItem);

		returnBookJMenuItem = new JMenuItem(
				"\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		returnBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_R, InputEvent.CTRL_MASK));
		returnBookJMenuItem.addActionListener(new ReturnBookActionListener());
		returnBookJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/inbox_download_16x16.png")));
		loanJMenu.add(returnBookJMenuItem);

		JMenu searchJMenu = new JMenu(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		menuBar.add(searchJMenu);

		searchJMenuItem = new JMenuItem(
				"\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		searchJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
				InputEvent.CTRL_MASK));
		searchJMenuItem.addActionListener(new SearchActionListener());
		searchJMenuItem.setIcon(new ImageIcon(Library.class
				.getResource("/images/search_16x16.png")));
		searchJMenu.add(searchJMenuItem);

		JMenu helpJMenu = new JMenu(
				"\u0392\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1");
		menuBar.add(helpJMenu);

		JMenu mnAboutJMenu = new JMenu("About");
		mnAboutJMenu.setIcon(new ImageIcon(Library.class
				.getResource("/images/about_16x16.png")));
		helpJMenu.add(mnAboutJMenu);

		JMenuItem mntmCopyrightJMenuItem = new JMenuItem(
				"copyright \u00A9 2015 Gaitanidis & Georgaras");
		mnAboutJMenu.add(mntmCopyrightJMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Create the toolbar.
		toolBar = new JToolBar();
		toolBar.setFloatable(false);

		btnAddBook = new JButton("");
		btnAddBook.addActionListener(new AddBookActionListener());
		btnAddBook
				.setToolTipText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		btnAddBook.setIcon(new ImageIcon(Library.class
				.getResource("/images/add_book_16x16.png")));
		toolBar.add(btnAddBook);

		btnPopularBook = new JButton("");
		btnPopularBook.addActionListener(new PopularBooksActionListener());
		btnPopularBook.setIcon(new ImageIcon(Library.class
				.getResource("/images/chart_arrow_16x16.png")));
		btnPopularBook
				.setToolTipText("\u0394\u03B7\u03BC\u03BF\u03C6\u03B9\u03BB\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03B1");
		toolBar.add(btnPopularBook);
		toolBar.addSeparator();

		btnAddMember = new JButton("");
		btnAddMember.addActionListener(new AddMemberActionListener());
		btnAddMember
				.setToolTipText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2");
		btnAddMember.setIcon(new ImageIcon(Library.class
				.getResource("/images/user_add_16x16.png")));
		toolBar.add(btnAddMember);

		btnBannedMember = new JButton("");
		btnBannedMember.addActionListener(new BannedMembersActionListener());
		btnBannedMember
				.setToolTipText("\u0391\u03C3\u03C5\u03BD\u03B5\u03C0\u03B5\u03AF\u03C2 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B5\u03C2");
		btnBannedMember.setIcon(new ImageIcon(Library.class
				.getResource("/images/user_ban_16x16.png")));
		toolBar.add(btnBannedMember);
		toolBar.addSeparator();

		btnBorrowBook = new JButton("");
		btnBorrowBook.addActionListener(new BorrowBookActionListener());
		btnBorrowBook
				.setToolTipText("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		btnBorrowBook.setIcon(new ImageIcon(Library.class
				.getResource("/images/inbox_upload_16x16.png")));
		toolBar.add(btnBorrowBook);

		btnReturnBook = new JButton("");
		btnReturnBook.addActionListener(new ReturnBookActionListener());
		btnReturnBook
				.setToolTipText("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		btnReturnBook.setIcon(new ImageIcon(Library.class
				.getResource("/images/inbox_download_16x16.png")));
		toolBar.add(btnReturnBook);
		toolBar.addSeparator();

		btnSearch = new JButton("");
		btnSearch.addActionListener(new SearchActionListener());
		btnSearch
				.setToolTipText("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		btnSearch.setIcon(new ImageIcon(Library.class
				.getResource("/images/search_16x16.png")));
		toolBar.add(btnSearch);

		// Create the desktopPane.
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 874,
						Short.MAX_VALUE)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 874,
						Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 25,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE,
								700, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	class ExitActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// dispose();
			System.exit(0); // causes the Java VM to terminate completely

		}

	}

	class AddBookActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (addBookForm == null || addBookForm.isClosed()) {	 // only one instance to addBookForm
				
				addBookForm = new AddBookForm();
				desktopPane.add(addBookForm);
				addBookForm.show();
			}
		}
	}

	class PopularBooksActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Configuration configuration = new Configuration();	//Connection me Database
		    configuration.configure();
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from Book order by nOBorrows desc");
			// number of values display
			query.setMaxResults(10);
			//Create ArrayList of selected query
			ArrayList<Book> books = new ArrayList<Book>(query.list());
			
			session.getTransaction().commit();
			session.close();
			
			BookTableModel model = new BookTableModel(books);
            JTable table = new JTable(model);

            JFrame frame = new JFrame("10 ÄçìïöéëÝóôåñá Âéâëßá");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
			/*for (Book b : books)
				System.out.printf(b.getnOBorrows()+"\t"+b.getiSBN()+"\t"+b.getBookName()+"\t"+b.getBookAuthor()+"\t"+b.getBookPublisher()+"\t"+b.getBookSubject()+"\t"+b.getBookLanguage()+"\t"+b.getBookEvaluation()+"\n");	   
			System.out.println();*/
		}
	}

	class AddMemberActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			if (addMemberForm == null || addMemberForm.isClosed()) {
				addMemberForm = new AddMemberForm();
				desktopPane.add(addMemberForm);
				addMemberForm.show();
			}
		}
	}

	class BannedMembersActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Configuration configuration = new Configuration();	//Connection me Database
		    configuration.configure();
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from Member order by latePoints desc");
			// number of values display
			query.setMaxResults(5);
			ArrayList<Member> members = new ArrayList<Member>(query.list());
			
			session.getTransaction().commit();
			session.close();
			
			MemberTableModel model = new MemberTableModel(members);
            JTable table = new JTable(model);

            JFrame frame = new JFrame("Ïé 5 ðéï áóõíåðåßò ÷ñÞóôåò");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
		}
	}

	class BorrowBookActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (borrowBookForm == null || borrowBookForm.isClosed()) {
				borrowBookForm = new BorrowBookForm();
				desktopPane.add(borrowBookForm);
				borrowBookForm.show();
			}
		}
	}

	class ReturnBookActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (returnBookForm == null || returnBookForm.isClosed()) {
				returnBookForm = new ReturnBookForm();
				desktopPane.add(returnBookForm);
				returnBookForm.show();
			}
		}
	}

	class SearchActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (searchForm == null || searchForm.isClosed()) {
				searchForm = new SearchForm();
				desktopPane.add(searchForm);
				searchForm.show();
			}
		}
	}
}