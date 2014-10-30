/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anuradha
 */
public class DBHandler {

    public static int setData(Connection connection, String query) throws SQLException {
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(query);
        return res;
    }

    public static ResultSet getData(Connection connection, String query) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(query);
        return rst;
    }
}
