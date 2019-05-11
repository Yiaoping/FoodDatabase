
import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.driver.*;
public class Main {

	
	
	public static void main(String args[]) throws Exception {

		select();
	}
	
	public static Connection getConnection() throws Exception {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/supplements";
		String username = "root";
		String password = "sparkyshu";
		Class.forName(driver).newInstance();
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		return connection;
	}
	
	public static void createTable() throws Exception{
		Connection connection = getConnection();
		PreparedStatement create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS protein2(id int NOT NULL AUTO_INCREMENT, NAME varchar(25), PRICE int, GRAMS int, PRIMARY KEY(id))");
		create.executeUpdate();
		System.out.println("Completed");
	}
	
	public static void insert() throws Exception{
		final String name1 = "Whey";
		final String name2 = "Casein";
		final String name3 = "Isolate";
		
		final int price = 50;
		final int price2 = 60;
		final int price3 = 75;
		
		final int grams = 20;
		final int grams2 = 25;
		final int grams3 = 30;
		
		Connection connection = getConnection();															   							
		PreparedStatement insert = connection.prepareStatement("INSERT INTO protein2 (NAME, PRICE, GRAMS) VALUES ('"+name1+"', "+price+", "+grams + ")");
		ResultSet insertOutput = insert.executeQuery();
		System.out.println("Completed");
	}
	
	
	public static void remove() throws Exception{
		Connection connection = getConnection();
		PreparedStatement remove = connection.prepareStatement("DELETE FROM protein2 WHERE id=2 || id=3");
		remove.executeUpdate();
	}
	
	public static void select()throws Exception{
		Connection connection = getConnection();
		PreparedStatement select = connection.prepareStatement("SELECT * FROM PROTEIN");
		ResultSet selectOutput = select.executeQuery();

		
		ArrayList<String> array = new ArrayList<String>();
		while(selectOutput.next()) {
			System.out.print(selectOutput.getString("ID"));
			System.out.print(" ");
			System.out.print(selectOutput.getString("NAME"));
			System.out.print(" ");
			System.out.print(selectOutput.getString("PRICE"));
			System.out.print(" ");
			System.out.print(selectOutput.getString("GRAMS"));
			System.out.println();
		}
	}

}
