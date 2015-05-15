import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		try {
			Library frame = new Library();
			frame.setVisible(true);

			DatabaseHandling db = new DatabaseHandling();
			db.establishConnection();
			db.createBook();
			db.createStudent();

			int count = db.getResults("book");
			int count1 = db.getResults("student");
			System.out.println("Εμφάνιση στοιχείων πίνακα book: " +count);
			System.out.println();
			System.out.println("Εμφάνιση στοιχείων πίνακα member/student: " +count1);
			System.out.println();
			db.printData();

			db.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
		// });
	}

}
