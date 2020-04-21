import DBConnection.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class APP04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "delete from department "
                            + "WHERE "
                            + "Id = ?");
            st.setDouble(1, 5);


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
