import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DatabaseHandling {
	// C:\\Users\\Βασίλης\\workspace\\LibraryTest_v0.1\\
	static final String DATABASE_URL = "jdbc:sqlite:LibUom.sqlite"; // το ονομα
	// της βασης
	// static final String USER = ""; //username & password
	// static final String PASS = "";
	Connection connection = null;
	Statement statement = null;

	public DatabaseHandling() {

	}

	public void establishConnection() { // κάνει connect στη βάση

		try {
			// Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(DATABASE_URL);
			statement = connection.createStatement(); // για να εκτελέσει το
			// connection(?)
			// JOptionPane.showMessageDialog(null,"connection successful");
		} catch (SQLException e) {
			e.printStackTrace(); // για την κονσόλα
			JOptionPane.showMessageDialog(null,
					"Connection couldn't be established.");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Connection couldn't be established");
		}
	}

	public void createBook() {

		String sql = "CREATE TABLE book (ISBN INTEGER PRIMARY KEY  NOT NULL , NAME VARCHAR)";
		try {
			statement.executeUpdate(sql); // εκτέλεση του query
		} catch (SQLException e) {
		}

	}

	public void createStudent() {
		String sql = "CREATE TABLE student (ID INTEGER PRIMARY KEY  NOT NULL , NAME VARCHAR)";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
		}
	}

	public void insertingIntoDB(String table, int isbn, String name) {

		try {
			// statement = connection.createStatement();
			String sql = "INSERT INTO " + table + " VALUES (" + isbn + " ,'"
					+ name + "' )";
			statement.executeUpdate(sql); // update tn vasi
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void insertingIntoDBMember(String table, int iD, String memberName) {

		try {
			// statement = connection.createStatement();
			String sql = "INSERT INTO " + table + " VALUES (" + iD + " ,'"
					+ memberName + "' )";
			statement.executeUpdate(sql); // update tn vasi
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getResults(String table) {
		int counter = 0;
		ResultSet resultSet = null;

		try {
			String sql = "SELECT * FROM " + table + "";
			resultSet = statement.executeQuery(sql); // logo tou resultSet
			while (resultSet.next())
				counter++;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return counter;
	}

	public void closeConnection() { // κάνει dissconnect στη βάση
		try {
			connection.close();
			// JOptionPane.showMessageDialog(null,"Connection closed successfully");
			// statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection couldn't close");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection couldn't close");
		}

	}

	public void printData() { // εμφανιση στην κονσολα

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL); // ισως να
			// μην
			// χρειάζεται..
			// check
			// it!!!
			statement = connection.createStatement();
			String sql = "SELECT * FROM book"; // μονο για book
			resultSet = statement.executeQuery(sql);

			ResultSetMetaData metaData = resultSet.getMetaData(); // einai ta
			// columns
			// tou table
			int numberOfColumns = metaData.getColumnCount();

			System.out.println("First Table's DB concent results:\n");

			for (int i = 1; i <= numberOfColumns; i++)
				// i=1 (!)

				System.out.printf("%-8s\t", metaData.getColumnName(i));

			System.out.println();

			while (resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));

				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
				// statement.close();
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
