    package DataBase;

    import java.sql.*;

    public class dataBase {

        static ResultSet r;

        static void connect() throws SQLException {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/stepping stone", "Admin", "9513572680");
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            r = s.executeQuery("SELECT `Id`, `password` FROM `accounts`");

        }

        public static boolean login(String id, String password) throws SQLException {
            r.beforeFirst();
            while (r.next()) {
                String dbId = r.getString("Id");
                String dbPassword = r.getString("password");

                if (dbId.equals(id) && dbPassword.equals(password)) {
                    return true;
                }
            }
            return false;
        }

        public  static  boolean check(String id ) throws SQLException   {
            r.isBeforeFirst();
            while (r.next())    {
                if (r.getString("id").equals(id))   {
                    return true;
                }

            }
            return false;
        }
        public static void signUp(String id, String password) throws SQLException {
            r.moveToInsertRow();
            r.updateString("Id", id);
            r.updateString("password", password);
            r.insertRow();
            System.out.println("Signed up");
        }

        public static void Print() throws SQLException {
            r.beforeFirst();
            while (r.next()) {
                System.err.println(r.getString(1) + " " + r.getString(2));
            }

        }

        public static void update(int row, int columnIndex, String id, String password) throws SQLException {
            if (check(id)) {
                r.absolute(row);
                r.updateString(columnIndex, password);
                r.updateRow();
                System.out.println("Data updated");
            }
        }

        public static void update(int row, String columnIndex, String id, String password) throws SQLException {
            if (check(id))  {
                r.absolute(row);
                r.updateString(columnIndex, password);
                r.updateRow();
                System.out.println("Data updated");
            }

        }


    }