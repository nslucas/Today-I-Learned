package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args){

        Connection conn = null;

        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement("UPDATE seller "
                                          + "SET baseSalary = BaseSalary + ? "
                                          + "WHERE "
                                          + "(DepartmentId = ? )");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();


            System.out.println("Done! Id Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
