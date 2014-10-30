package controller;

import connection.DBConnection;
import connection.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nands
 */
public class ScoreController {

    public static void updateScore(String player, int marks) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getConnectionToDB();
        int currentMarks = getCurrentScore(player);
        if (currentMarks != (-1)) {
            int newMarks = currentMarks + marks;
            String query = "Update scores set score = '" + newMarks + "' where userName='" + player + "'";
            DBHandler.setData(connection, query);
        } else {
            String query = "Insert into scores(userName,score) values ('" + player + "','" + marks + "')";
            DBHandler.setData(connection, query);
        }
    }

    public static int getCurrentScore(String player) throws ClassNotFoundException, SQLException {
        String query = "Select * from scores";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);

        while (rst.next()) {
            String name = rst.getString("userName");
            int marks = Integer.parseInt(rst.getString("score"));
            if (name.equals(player)) {
                return marks;
            }
        }
        return -1;
    }

    public static int getMaximumScore() throws ClassNotFoundException, SQLException {
        String query = "Select * from scores";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        int max = 0;
        while (rst.next()) {
            int marks = Integer.parseInt(rst.getString("score"));
            if (marks > max) {
                max = marks;
            }
        }
        return max;
    }

    public static String getWinner() throws ClassNotFoundException, SQLException {
        String winner = null;
        String query = "Select * from scores";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        int max = 0;
        while (rst.next()) {            
            String name = rst.getString("userName");
            int marks = Integer.parseInt(rst.getString("score"));
            if (marks > max) {
                max = marks;
                winner = name;
            }
        }
        return winner;
    }

    public static ResultSet getScoreInfo() throws ClassNotFoundException, SQLException{
        String query = "Select * from scores";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        return rst;
    }

}
