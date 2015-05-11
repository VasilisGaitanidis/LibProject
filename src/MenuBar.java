import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class MenuBar extends JMenuBar {
	
	public JMenuBar menuBar;
	
	public JMenu fileJMenu;
	public JMenuItem exitJMenuItem;
	
	public JMenu booksJMenu;
	public JMenuItem addBookJMenuItem;
	public JMenuItem listBookJMenuItem;
	
	public JMenu membersJMenu;
	public JMenuItem addMemberJMenuItem;
	public JMenuItem listMemberJMenuItem;
	
	public JMenu loanJMenu;
	public JMenuItem borrowBookJMenuItem;
	public JMenuItem returnBookJMenuItem;
	
	public JMenu searchJMenu;
	public JMenuItem searchJMenuItem;
	
	public JMenu helpJMenu;
	public JMenu mnAboutJMenu;
	public JMenuItem mntmCopyrightJMenuItem;	

	public MenuBar() {
		
		menuBar = new JMenuBar();
		
		fileJMenu = new JMenu("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF");
		menuBar.add(fileJMenu);
		
		exitJMenuItem = new JMenuItem("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		exitJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		exitJMenuItem.setIcon(new ImageIcon(Library.class.getResource("/images/exit_small.png")));
		fileJMenu.add(exitJMenuItem);
		
		booksJMenu = new JMenu("\u0392\u03B9\u03B2\u03BB\u03AF\u03B1");
		menuBar.add(booksJMenu);
		
		addBookJMenuItem = new JMenuItem("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		addBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		addBookJMenuItem.setIcon(new ImageIcon(Library.class.getResource("/images/add_book_small.png")));
		booksJMenu.add(addBookJMenuItem);
		
		listBookJMenuItem = new JMenuItem("\u039B\u03AF\u03C3\u03C4\u03B1 \u0392\u03B9\u03B2\u03BB\u03AF\u03C9\u03BD");
		booksJMenu.add(listBookJMenuItem);
		
		membersJMenu = new JMenu("\u039C\u03AD\u03BB\u03B7");
		menuBar.add(membersJMenu);
		
		addMemberJMenuItem = new JMenuItem("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039C\u03AD\u03BB\u03BF\u03C5\u03C2");
		addMemberJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		addMemberJMenuItem.setIcon(new ImageIcon(Library.class.getResource("/images/add_member_small.png")));
		membersJMenu.add(addMemberJMenuItem);
		
		listMemberJMenuItem = new JMenuItem("\u039B\u03AF\u03C3\u03C4\u03B1 \u039C\u03B5\u03BB\u03CE\u03BD");
		membersJMenu.add(listMemberJMenuItem);
		
		loanJMenu = new JMenu("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2");
		menuBar.add(loanJMenu);
		
		borrowBookJMenuItem = new JMenuItem("\u0394\u03B1\u03BD\u03B5\u03B9\u03C3\u03BC\u03CC\u03C2 \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		borrowBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		borrowBookJMenuItem.setIcon(new ImageIcon(Library.class.getResource("/images/borrow_book_small.png")));
		loanJMenu.add(borrowBookJMenuItem);
		
		returnBookJMenuItem = new JMenuItem("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE \u0392\u03B9\u03B2\u03BB\u03AF\u03BF\u03C5");
		returnBookJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		returnBookJMenuItem.setIcon(new ImageIcon(Library.class.getResource("/images/return_book_small.png")));
		loanJMenu.add(returnBookJMenuItem);
		
		searchJMenu = new JMenu("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		menuBar.add(searchJMenu);
		
		searchJMenuItem = new JMenuItem("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		searchJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		searchJMenuItem.setIcon(new ImageIcon(Library.class.getResource("/images/search_small.png")));
		searchJMenu.add(searchJMenuItem);
		
		helpJMenu = new JMenu("\u0392\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1");
		menuBar.add(helpJMenu);
		
		mnAboutJMenu = new JMenu("About");
		mnAboutJMenu.setIcon(new ImageIcon(Library.class.getResource("/images/about_small.png")));
		helpJMenu.add(mnAboutJMenu);
		
		mntmCopyrightJMenuItem = new JMenuItem("copyright \u00A9 2015 VG123");
		mnAboutJMenu.add(mntmCopyrightJMenuItem);
	}
}
