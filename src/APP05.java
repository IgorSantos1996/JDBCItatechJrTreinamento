import Excecoes.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class APP05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //int x = 1;
            // if (x < 2) {
            //    throw new SQLException("ERROR");
            //}

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 2");


            conn.commit();
            System.out.println("rows 1 = " + rows1);
            System.out.println("rows 2 = " + rows2);


        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException d) {
                throw new DbException("Error trying to rollback!! Caused by: " + d.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
