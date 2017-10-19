import java.sql.*;
import java.util.ArrayList;

public class Database {
    int id;
    ArrayList<String[]> data = new ArrayList<String[]>();
    public Database() {
        id =0;
        this.initialize();
    }
    public ArrayList<String[]> getData()
    {
        return this.data;
    }

    public void initialize()
    {
        try {
// setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
// display database information
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
                // execute SQL statements
//                System.out.println("----- Data in Calendar table -----");
                String query = "select * from Calendar";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
//                int id =0;
                while (resultSet.next()) {
                    String[] d = new String[4];
                    d[0] = resultSet.getInt(1)+"";
                    d[1] = resultSet.getString(2);
                    d[2] = resultSet.getString(3);
                    d[3] = resultSet.getString(4);
                    data.add(d);
//                    System.out.println(data.get(0)[1]);
                    id = resultSet.getInt(1);


//                    System.out.println("id:"+id+" name:"+name+" price: "+price);
                }

// close connection
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public void edit(int id,String detail,String title,String date)
    {
        try {
// setup
            Class.forName("org.sqlite.JDBC"); 
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
// display database information
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
                // execute SQL statements
//                System.out.println("----- Data in Calendar table -----");
//                System.out.println(id+"                       bnm");
                String query = "update Calendar set date='"+date+"',title='"+title+"',detail='"+detail +"' where id='"+id+"'";

                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
                statement.execute(query);
//                while (resultSet.next()) {
//                    String date = resultSet.getString(1);
//                    String title = resultSet.getString(2);
//                    String detail = resultSet.getString(3);


//                    System.out.println("id:"+id+" name:"+name+" event: "+event);
//                }
// close connection
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delete(int id){
        try {
// setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
// display database information
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
                // execute SQL statements
//                System.out.println("----- Data in Calendar table -----");
                System.out.println(id+"                       bnm");
                String query = "delete from Calendar where id='"+id+"'";

                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
                statement.execute(query);
//                while (resultSet.next()) {
//                    String date = resultSet.getString(1);
//                    String title = resultSet.getString(2);
//                    String detail = resultSet.getString(3);


//                    System.out.println("id:"+id+" name:"+name+" price: "+price);
//                }
// close connection
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insert(int id,String date,String title) {
        try {
// setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
// display database information
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
                // execute SQL statements
//                System.out.println("----- Data in Calendar table -----");
                System.out.println(id + "                       bnm");
                String query = "insert into values('" + id + "','" + date + "','" + title + "','" + "')";

                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
                statement.execute(query);
//                while (resultSet.next()) {
//                    String date = resultSet.getString(1);
//                    String title = resultSet.getString(2);
//                    String detail = resultSet.getString(3);


//                    System.out.println("id:"+id+" name:"+name+" price: "+price);
//                }
// close connection
                statement.executeUpdate(query);
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getCreateID(){
        int minID = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "Select max(id) from event";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                minID = resultSet.getInt(1);
                connection.close();
                return  minID+1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minID;
    }
}
