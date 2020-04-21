import DBConnection.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class APP03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");
            st.setDouble(1, 200);
            st.setInt(2, 2);

            int rowsaffected = st.executeUpdate();
            System.out.println("DONE! Rows affected: " + rowsaffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
