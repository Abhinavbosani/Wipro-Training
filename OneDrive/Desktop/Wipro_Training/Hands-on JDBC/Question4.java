package wipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question4 {
public static void main(String args[]) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		   
		Statement stmt;
		ResultSet rs;
	 	Connection conn;

		try {
	  		Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex) {
	   		System.out.println("Error: unable to load driver class!");
	   		System.exit(1);
		}
	    
	        try{

	            conn = DriverManager.getConnection(url,"abhinav","root");
	            System.out.println("Connection Established successfully.");

	            String sql = "SELECT * FROM emp WHERE sal > 1000 AND sal < 2000";
	    		stmt = conn.createStatement();
	    		rs = stmt.executeQuery(sql);
	    		
	    		System.out.printf("%-10S%-10S%10S%10S\n", "ename", "job", "sal", "comm");
	    		for (int i = 0; i < 50; i++) System.out.print("=");
	    		System.out.println();
	    		
	    		while (rs.next()) {
	    			System.out.printf("%-10s%-10s%10s%10s\n", 
	    				rs.getString("ename"), rs.getString("job"), rs.getDouble("sal"), rs.getDouble("comm"));
	    		}
	    	}
	    	catch(Exception e){
	      		System.out.println("Exception: " + e);
	    	}
	}

}
