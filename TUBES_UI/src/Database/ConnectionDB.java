package Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionDB {
    Connection conn;
    ResultSet rs;
    Statement stm;
    String url = "jdbc:mysql://localhost/petshop";
    String user = "root";
    String pass = "";

    public ConnectionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            stm = conn.createStatement();
        }catch(SQLException ex){
            System.err.print(ex);
        }catch(ClassNotFoundException ex){
            System.err.print(ex);
        } 
    }
    public ResultSet getData(String sql){
        try{
            rs = stm.executeQuery(sql);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "error :"+ex.getMessage(),"Communication Error pada method getdata",
                   JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
     public void query (String SQLString){
        try {
            stm.execute(SQLString);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog
                    (null, "error"+e.getMessage(),
                            "Communication Error pada method query",
                            JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
