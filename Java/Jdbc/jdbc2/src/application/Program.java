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

        Statement st2 = null;

        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement("INSERT INTO seller"
                                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                                            + "VALUES"
                                            + "(?, ?, ?, ?, ?)",
                                            Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.printf("No rows affected!");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
