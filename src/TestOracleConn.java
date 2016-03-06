
//Import required packages either from all sql or all mysql.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This Class will create a JDBS=C connection in 4Steps 1. Register a Driver 2.
 * Create a connection 3. Pass the Statement/Execute/Fetch in Result Set 4.
 * Close the Connection
 * 
 * @author ank
 *
 */
public class TestOracleConn {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ankita";

	// Database credentials
	static final String USER_NAME = "test";
	static final String PASSWORD = "welcome";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		// STEP 1: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		// STEP 2: Create a connection
		conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		if (conn != null) {
			System.out.println("Connected to 'ankita' database...");
		}

		// STEP 3 : Pass the Statement/Execute Query/ Fetch in Result set
		stmt = conn.createStatement();
		System.out.println("Creating Employee & Department table in given database...");

		String create_emp_sql = "CREATE TABLE EMPLOYEE (" + "EMP_ID INT NOT NULL AUTO_INCREMENT,"
				+ "NAME VARCHAR(20) NOT NULL," + "SALARY INT(10) NOT NULL," + "AGE INT(3)," + "ADDRESS VARCHAR(255),"
				+ "DEPT_ID INT(3)," + "PRIMARY KEY (EMP_ID)" + ")";

		String create_dept_sql = "CREATE TABLE DEPARTMENT (" + "DEPT_ID INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "NAME VARCHAR(20) NOT NULL," + "HEAD_ID INT(3)) ";

		stmt.executeUpdate(create_emp_sql);
		stmt.executeUpdate(create_dept_sql);
		System.out.println("Created tables in given database...");

		System.out.println("Inserting data in Employee table...");
		String insert_emp_sql = "INSERT INTO EMPLOYEE (EMP_ID, NAME, SALARY, AGE, ADDRESS, DEPT_ID)" + " VALUES "
				+ "(1, 'Sam', 100000, 29, 'San Antonio', 101)";
		stmt.executeUpdate(insert_emp_sql);

		insert_emp_sql = "INSERT INTO EMPLOYEE (EMP_ID, NAME, SALARY, AGE, ADDRESS, DEPT_ID)" + " VALUES "
				+ "(2, 'Rick', 500000, 24, 'San Antonio', 201)";
		stmt.executeUpdate(insert_emp_sql);

		insert_emp_sql = "INSERT INTO EMPLOYEE (EMP_ID, NAME, SALARY, AGE, ADDRESS, DEPT_ID)" + " VALUES "
				+ "(3, 'Mike', 300000, 25, 'San Antonio', 201)";
		stmt.executeUpdate(insert_emp_sql);

		insert_emp_sql = "INSERT INTO EMPLOYEE (EMP_ID, NAME, SALARY, AGE, ADDRESS, DEPT_ID)" + " VALUES "
				+ "(4, 'Joe', 50000, 23, 'San Antonio', 401)";
		stmt.executeUpdate(insert_emp_sql);

		insert_emp_sql = "INSERT INTO EMPLOYEE (EMP_ID, NAME, SALARY, AGE, ADDRESS, DEPT_ID)" + " VALUES "
				+ "(5, 'Adam', 40000, 22, 'San Antonio', 501)";
		stmt.executeUpdate(insert_emp_sql);

		System.out.println("Inserting data in Department table...");
		String insert_dep_sql = "INSERT INTO DEPARTMENT VALUES " + "(101, 'IT', 101)";
		stmt.executeUpdate(insert_dep_sql);

		insert_dep_sql = "INSERT INTO DEPARTMENT VALUES " + "(201, 'Medical', 201)";
		stmt.executeUpdate(insert_dep_sql);

		insert_dep_sql = "INSERT INTO DEPARTMENT VALUES " + "(301, 'Mechanical', 303)";
		stmt.executeUpdate(insert_dep_sql);

		insert_dep_sql = "INSERT INTO DEPARTMENT VALUES " + "(401, 'Accounts', 404)";
		stmt.executeUpdate(insert_dep_sql);

		System.out.println("Data insertion in Tables finished...");

		rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");

		// STEP 4: Extract data from result set
		while (rs.next()) {
			int id = rs.getInt("EMP_ID");
			String name = rs.getString("NAME");
			int salary = rs.getInt("SALARY");
			int age = rs.getInt("AGE");
			String address = rs.getString("ADDRESS");
			int dept_id = rs.getInt("DEPT_ID");
			System.out.println(
					"Data from Employee table \n    Emp Id : '" + id + "' Department id : '" + dept_id + "' Name : '"
							+ name + "' Age : '" + age + "' Salary : '" + salary + "' Address : '" + address + "'");
		}

		rs1 = stmt.executeQuery("SELECT * FROM DEPARTMENT");
		while (rs1.next()) {
			String name1 = rs1.getString("NAME");
			int dept_id1 = rs1.getInt("DEPT_ID");
			int head_id = rs1.getInt("HEAD_ID");
			System.out.println("Data from Department table \n    Department Name : '" + name1 + "'" + " Dept Id : '"
					+ dept_id1 + "' Head id : '" + head_id + "'");
		}
	      rs.close();
	      rs1.close();

	}

}
