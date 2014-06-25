/*
 * The CutomerRecordManagement program implements an application that
 * stores and maintains Customer Records and displays the records
 * @author: Swapnil Lahire
 * @since: 23-06-2014  
 */
package Form;

import java.sql.*;

public class Connect {
    /*
     *This Constructor is used for the purpose of connection
     */

    public Connection conn;
    public PreparedStatement st;

    public Connect() throws ClassNotFoundException, SQLException {
        //Type 4 driver used here  of H2 Database
        Class.forName("org.h2.Driver");  //Loading the driver class
        conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    /**
     * this method implements data entry mechanism by firing insert query on
     * customer table
     */
    public void insertrow(String cName, String cEmail, String cPhone, String cAddress, String cCity, String cState, String cPincode, String cCountry) throws SQLException {
        int cPin = Integer.parseInt(cPincode);
        String sql = "insert into customertable values(?,?,?,?,?,?,?,?)";//query for adding new rows in data base.
        st = conn.prepareStatement(sql);
        st.setString(1, cName);
        st.setString(2, cEmail);
        st.setString(3, cPhone);
        st.setString(4, cAddress);
        st.setString(5, cCity);
        st.setString(6, cState);
        st.setInt(7, cPin);
        st.setString(8, cCountry);
        st.executeUpdate();
    }

    //Closing the connection    
    public void closeconn() throws SQLException {
        conn.close();
    }
}
