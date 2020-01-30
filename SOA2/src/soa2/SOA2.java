/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa2;

/**
 *
 * @author STD-PC
 */
import java.sql.*;

public class SOA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=1234");
        // TODO code application logic here
        Statement statement = connection.createStatement( );

//        2. Write a Java program to insert the data into the Country and City tables
        
//statement.executeUpdate("INSERT INTO Country VALUES('THA', 'Thailand', 'Asia', 600, 'Thai')");
//statement.executeUpdate("INSERT INTO Country VALUES('USA', 'United State of America', 'North America', 1000, 'English')");
//statement.executeUpdate("INSERT INTO Country VALUES('MAS', 'Malaysia', 'Asia',350, 'English')");
//statement.executeUpdate("INSERT INTO Country VALUES('GER', 'German', 'Europe', 10, 'Deutsch')");

//statement.executeUpdate("INSERT INTO City VALUES(1,'THA', 'Phuket', 2)");
//statement.executeUpdate("INSERT INTO City VALUES(2, 'THA', 'Bangkok', 10)");
//statement.executeUpdate("INSERT INTO City VALUES(3, 'THA', 'Chaingmai', 4)");
//statement.executeUpdate("INSERT INTO City VALUES(4, 'USA', 'California', 35)");
//statement.executeUpdate("INSERT INTO City VALUES(5, 'USA', 'New York', 45)");
//statement.executeUpdate("INSERT INTO City VALUES(6, 'MAS', 'Kuala Lumpur', 11");

//        4. Change the given code to PreparedStatement
        
ResultSet rs = statement.executeQuery("SELECT * FROM CITY WHERE COUNTRYCODE ='THA'");
printRS(rs);

//     5.1 All Asia countries   
ResultSet rs2 = statement.executeQuery("SELECT * FROM Country WHERE Continent ='Asia'");
System.out.println("5.1 All Asia countries  ");
printRS(rs2);
System.out.println("--------------------------------");

ResultSet rs3 = statement.executeQuery("SELECT * FROM City WHERE Countrycode ='USA'");
System.out.println("5.2 All cities in USA");
printRS(rs3);
System.out.println("--------------------------------");

ResultSet rs4 = statement.executeQuery("SELECT * FROM City WHERE Population>5");
System.out.println("Cities where population is greater than 5");
printRS(rs4);
System.out.println("--------------------------------");


statement.executeUpdate(
"INSERT INTO city VALUES( 0,'MAS', 'Johor Bahru',20)",
Statement.RETURN_GENERATED_KEYS);
ResultSet rs5 = statement.getGeneratedKeys( );
if ( rs5.first() ) {
int id = rs5.getInt(1);
System.out.println("ID:"+id);
}

statement.close();
    }catch(Exception e){ System.out.println("DAM:"+e);} 
   }
    


public static void printRS(ResultSet rs) throws
SQLException
{
ResultSetMetaData md = rs.getMetaData();
// get number of columns
int nCols = md.getColumnCount();
// print column names
for(int i=1; i < nCols; ++i)
System.out.print( md.getColumnName( i)+",");
/// / output resultset
while ( rs.next() )
{ for(int i=1; i < nCols; ++i)
System.out.print( rs.getString( i)+",");
System.out.println( rs.getString(nCols) );
}
}

}
