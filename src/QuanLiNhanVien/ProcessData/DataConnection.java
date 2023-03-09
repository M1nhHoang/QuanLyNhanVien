/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.ProcessData;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;

/**
 *
 * @author HP
 */
public class DataConnection {
    private final String server = "LAPTOP-G9HMKMUF\\SQLEXPRESS";
    private final String user = "sa";
    private final String password = "123456";
    private final String db = "QuanLiNhanVien";
    private final int port = 1433;
    private SQLServerDataSource ds;
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    
    public DataConnection(){
        ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber (port);
        ds.setIntegratedSecurity(true);
        ds.setEncrypt(false);
    }
    
    public void openConnection() throws SQLException {
        conn = ds.getConnection();
        System.out.println(conn.getCatalog());
    }
    
    public void closeConnection() throws SQLException{
        if (conn != null){
            conn.close();
        }
        if (stm != null)
            stm.close();
        if (rs != null)
            rs.close();
    }
    
    public ResultSet executeQuery(String sql) throws SQLException {
        stm = conn.createStatement();
        rs = stm.executeQuery(sql);
            
        return rs;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
}
