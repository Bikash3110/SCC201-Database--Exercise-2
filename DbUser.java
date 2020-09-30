// STUBBED FILE
import java.sql.*;

// this is the class through which all Database calls go
public class DbUser extends DbBasic {

	private ResultSet rs = null;
	static private final int STR_SIZE = 25;

	// this method takes a String, converts it into an array of bytes;
	// copies those bytes into a bigger byte array (STR_SIZE worth), and
	// pads any remaining bytes with spaces. Finally, it converts the bigger
	// byte array back into a String, which it then returns.
	// e.g. if the String was "s_name", the new string returned is
	// "s_name                    " (the six characters followed by 18 spaces).
	private String pad( String in ) {
		byte [] org_bytes = in.getBytes( );
		byte [] new_bytes = new byte[STR_SIZE];
		int upb = in.length( );

		if ( upb > STR_SIZE )
			upb = STR_SIZE;

		for ( int i = 0; i < upb; i++ )
			new_bytes[i] = org_bytes[i];

		for ( int i = upb; i < STR_SIZE; i++ )
			new_bytes[i] = ' ';

		return new String( new_bytes );
	}

	/*
	 * Creates a connection to the named database
	 */
	DbUser ( String dbName ) {
		super( dbName );
	}

	/*
	 * You need to complete the following methods
	 */
	public void doQuery_1_a( ) {
		// 1 a) what is the title of the course with code 361?';
		// Write the Java code that executes the "select" statement that answers query 1a).
		// See the example output to see what should be produced.
		System.out.println("1 a) what is the title of the course with code 361?");
	
        System.out.println("SELECT c_title FROM courses WHERE code = 361;");
		try{
			Statement q1a =  con.createStatement( );
			ResultSet rSet = q1a.executeQuery("SELECT c_title FROM courses WHERE code = 361;");
			while(rSet.next()){
				String c_title = rSet.getString( "c_title" );
                System.out.format( "%-20s \n",c_title);
			}
			rSet.close();
			q1a.close();
		}
		catch(Exception e){
			System.out.println("Error in 1a");
		}
	}

	public void doQuery_1_b( ) {
		//1 b) what position and qualifications does Davies have?';
		// Write the Java code that executes the "select" statement that answers query 1b).
		// See the example output to see what should be produced.
		System.out.println("1 b) what position and qualifications does Davies have?");
	
	    System.out.println("SELECT pos, qual FROM staff WHERE s_name = 'Davies';");
		try{
			Statement q1b =  con.createStatement( );
			ResultSet rSet = q1b.executeQuery("SELECT pos, qual FROM staff WHERE s_name = 'Davies';");
			while(rSet.next()){
				String pos = rSet.getString( "pos" );
				String qual = rSet.getString( "qual" );
                System.out.format( "%-20s|%-20s \n",pos,qual);
			}
			rSet.close();
			q1b.close();
		}
		catch(Exception e){
			System.out.println("Error in 1b");
		}
	}

	public void doQuery_2_a( ) {
		System.out.println("2 a) what is the name of the department that Bear works for?");
	   
	    System.out.println("SELECT d_title FROM department, staff WHERE department.d_id = staff.d_id AND staff.s_name = 'Bear';");
		try{
			Statement q2a =  con.createStatement( );
			ResultSet rSet = q2a.executeQuery("SELECT d_title FROM department, staff WHERE department.d_id = staff.d_id AND staff.s_name='Bear';");
			while(rSet.next()){
				String d_title = rSet.getString( "d_title" );
                System.out.format( "%-20s \n",d_title);
			}
			rSet.close();
			q2a.close();
		}
		catch(Exception e){
			System.out.println("Error in 2a");
		}
	}

	public void doQuery_2_b( ) {
		System.out.println("2 b) what are the course codes of courses offered by the Computing department? ");
	    System.out.println("SELECT code FROM courses, department WHERE department.d_id =courses.d_id AND department.d_title = 'Computing';");
		try{
			Statement q2b =  con.createStatement( );
			ResultSet rSet = q2b.executeQuery("SELECT code FROM courses, department WHERE department.d_id =courses.d_id AND department.d_title = 'Computing';");
			while(rSet.next()){
				String code = rSet.getString( "code" );
                System.out.format( "%-20s \n",code);
			}
			rSet.close();
			q2b.close();
		}
		catch(Exception e){
			System.out.println("Error in 2b");
		}
	}
	
	public void doQuery_3_a( ) {
		System.out.println("3 a) What are the titles of course given by Mariani?");
	    System.out.println("SELECT c_title FROM courses ,department,staff WHERE (department.d_id = courses.d_id AND department.d_id = staff.d_id)AND staff.s_name= 'Mariani' ORDER BY c_title ASC;");
		try{
			Statement q3a =  con.createStatement( );
			ResultSet rSet = q3a.executeQuery("SELECT c_title FROM courses ,department,staff WHERE (department.d_id = courses.d_id AND department.d_id = staff.d_id)AND staff.s_name= 'Mariani' ORDER BY c_title ASC;");
			while(rSet.next()){
				String c_title = rSet.getString( "c_title" );
                System.out.format( "%-20s \n",c_title);
			}
			rSet.close();
			q3a.close();
		}
		catch(Exception e){
			System.out.println("Error in 3a");
		}
	}
	
	public void doQuery_3_b( ) {
		System.out.println("3 b) What are the names and initials of the staff who work on the COMIC project?");
	    System.out.println("SELECT s_name, initials FROM projects ,work_on,staff WHERE (staff.s_id == work_on.s_id AND work_on.p_id = projects.p_id)AND projects.p_title='COMIC' ORDER BY s_name ASC;");
		try{
			Statement q3b =  con.createStatement( );
			ResultSet rSet = q3b.executeQuery("SELECT s_name, initials FROM projects ,work_on,staff WHERE (staff.s_id == work_on.s_id AND work_on.p_id = projects.p_id)AND projects.p_title='COMIC' ORDER BY s_name ASC;");
			while(rSet.next()){
				String s_name = rSet.getString( "s_name" );
				String initials = rSet.getString( "initials" );
                System.out.format( "%-20s|%-5s \n",s_name,initials);
			}
			rSet.close();
			q3b.close();
		}
		catch(Exception e){
			System.out.println("Error in 3b");
		}
	}

	public void doQuery_4_a( ) {
		System.out.println("4 a) add a row to the Department relation regarding the Sociology department, with a location at Cartmel college and a code of SOCIO");
	    System.out.println("INSERT INTO department VALUES ('SOCIO','Sociology','Cartmel college');");
		try{
			Statement q4a =  con.createStatement( );
		    q4a.executeQuery("INSERT INTO department"+"VALUES('SOCIO','Sociology','Cartmel college')");
			System.out.println("Row Added into Department");
			//q4a.close();
		}
		catch(Exception e){
			System.out.println("Error in 4a");
		}
	}
	
	public void doQuery_4_b( ) {
		System.out.println("4 b) add a row to Staff regarding J. Hughes, who is a Professor and has a PhD, an S_ID of JH, and works for Sociology");
	    System.out.println("INSERT INTO staff VALUES ('JH','J','Hughes','Professor','Phd','SOCIO');");
		try{
			Statement q4b =  con.createStatement( );
			String sql = "INSERT INTO staff VALUES ('JH','J','Hughes','Professor','Phd','SOCIO')";
		    q4b.executeQuery(sql);
			System.out.println("Row Added into staff");
			q4b.close();
		}
		catch(Exception e){
			System.out.println("Error in 4b");
		} 
	}
	
	public void doQuery_4_c( ) {
		System.out.println("4 c) add a row to Work_on for J.Hughes working on COMIC from 1991 to 1994.");
	     System.out.println("INSERT INTO work_on VALUES ('JH','COMIC','1991','1990'); ");
		try{
			Statement q4c =  con.createStatement( );
			String sql = "INSERT INTO work_on VALUES ('JH','COMIC','1991','1990');";
		    q4c.executeQuery(sql);
			System.out.println("Row Added into work_on");
			q4c.close();
		}
		catch(Exception e){
			System.out.println("Error in 4c");
		} 
	}
	
	public void doQuery_5_a( ) {
		System.out.println("5 a) what are the names of people who started work on COMIC between 1990 and 1992?");
	    System.out.println("SELECT staff.s_name FROM staff,work_on,projects WHERE ((staff.s_id= work_on.s_id )AND (1990 < work_on.start_date AND work_on.start_date < 1992)) AND(work_on.p_id = projects.p_id AND projects.p_title = 'COMIC');");
		try{
			Statement q5a =  con.createStatement( );
			ResultSet rSet = q5a.executeQuery("SELECT staff.s_name FROM staff, work_on, projects WHERE ((staff.s_id = work_on.s_id ) AND (1990<work_on.start_date AND work_on.start_date<1992) AND (work_on.p_id = projects.p_id AND projects.p_title = 'COMIC'));");
			while(rSet.next()){
				String s_name = rSet.getString("staff.s_name");
                System.out.format( "%-20s \n",s_name);
			}
			rSet.close();
			q5a.close();
		}
		catch(Exception e){
			System.out.println("Error in 5a");
		}
	}
	
	public void doQuery_5_b( ) {
		System.out.println("5 b) what is the total amount of funding, and the average amount of funding, of all projects?");
	    System.out.println("SELECT SUM(funding), AVG(funding) FROM projects;");
		try{
			Statement q5b =  con.createStatement( );
			ResultSet rSet = q5b.executeQuery("SELECT SUM(funding), AVG(funding) FROM projects;");
			while(rSet.next()){
				int sum = rSet.getInt( "SUM(funding)" );
				int avg = rSet.getInt( "AVG(funding)" );
                System.out.format( "%-2d| %-2d \n",sum,avg);
			}
			rSet.close();
			q5b.close();
		}
		catch(Exception e){
			System.out.println("Error in 5b");
		}
	}
	
	void doQuery_6( ) {
		System.out.println("6. List staff names and the number of projects they have worked on.");
        System.out.println("SELECT staff.s_name, COUNT(work_on.p_id) FROM staff,work_on WHERE staff.s_id = work_on.s_id GROUP BY staff.s_name;");
		try{
			Statement q6 =  con.createStatement( );
			ResultSet rSet = q6.executeQuery("SELECT s_name, COUNT(p_id) FROM staff,work_on WHERE staff.s_id = work_on.s_id GROUP BY staff.s_name;");
			while(rSet.next()){
				String s_name = rSet.getString( "s_name" );
				int count = rSet.getInt("COUNT(p_id)");
                System.out.format( "%-20s|%-2d \n",s_name,count);
			}
			rSet.close();
			q6.close();
		}
		catch(Exception e){
			System.out.println("Error in 6");
		}
    }
	
	void execute_7c( ) {
		
		System.out.println("DELETE FROM work_on WHERE p_id = 'COMIC' AND s_id = 'JH';");
		try{
			Statement q4a =  con.createStatement( );
		    q4a.executeQuery("DELETE FROM work_on WHERE p_id = 'COMIC' AND s_id = 'JH';");
			System.out.println("Row del into Department");
			//q4a.close();
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("7c) Delete tuples in work_on for s_id equal tp 'JH'");
	}
	
	void execute_7a( ) {
		
		System.out.println("DELETE FROM Department WHERE d_id = 'SOCIO' AND d_title = 'Sociology';");
		try{
			Statement q4a =  con.createStatement( );
		    q4a.executeQuery("DELETE FROM Department WHERE d_id = 'SOCIO' AND d_title = 'Sociology';");
			System.out.println("Row Added into Department");
			//q4a.close();
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("7a) Delete tuples in department for d_id equal to 'SOCIO'");
	}
	
	void execute_7b( ) {
		
		System.out.println("DELETE FROM staff WHERE s_id = 'JH';");
		try{
			Statement q4a =  con.createStatement( );
		    q4a.executeQuery("DELETE FROM staff WHERE s_id = 'JH';");
			System.out.println("Row Added into Department");
			//q4a.close();
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("7b) Delete tuples in staff where s_id equal to 'JH'");
	}

	public void parameterise_3_a(String lecturerName) {
		// in this method, we want you to "parameterise" query 3a) so that, in the
		// argument to this method, your provide the name of the staff member, and can
		// subsequently find out what course code and name they give
		System.out.println("Parameterising Q3a) using " + lecturerName);
		System.out.println("3 a) What are the titles of course given by "+lecturerName+" ?");
		System.out.println("SELECT c_title FROM courses ,department,staff WHERE (department.d_id = courses.d_id AND department.d_id = staff.d_id)AND staff.s_name= "+lecturerName+" ORDER BY c_title ASC;");
		try{
			Statement q3a =  con.createStatement( );
			ResultSet rSet = q3a.executeQuery("SELECT c_title FROM courses ,department,staff WHERE (department.d_id = courses.d_id AND department.d_id = staff.d_id)AND staff.s_name= "+ lecturerName +" ORDER BY c_title ASC;");
			while(rSet.next()){
				String c_title = rSet.getString( "c_title" );
                System.out.format( "%-20s \n",c_title);
			}
			rSet.close();
			q3a.close();
		}
		catch(Exception e){
			System.out.println("Error in 3a");
		}	
	}
}
