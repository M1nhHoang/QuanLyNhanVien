/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.ProcessData;
import QuanLiNhanVien.BusinessLogic.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

/**
 *
 * @author HP
 */
public class pdQuanLiNhanVien {
    private DataConnection d;
    private ResultSet rs;
    private String sqlSelect = "select * from nhanVien";
    private String sqlInsert = "insert into nhanVien values (?, ?, ?, ?, ?, ?, ?)";
    private String sqlUpdate = "update nhanVien set idNv=?, tenNV=?, ngaySinh=?, gioiTinh=?, ngayVaoCoQuan=?, soCMND=?, heSoLuong=? where maNv=?";
    private String sqlRemove = "delete from nhanVien where maNv = ?";
    private String sqlFind = "select * from nhanVien where tenNV like ?";
    private DateFormat df;
    private Hashtable<String, NhanVien> list;
    
    public pdQuanLiNhanVien(){
        d = new DataConnection();
        df = new SimpleDateFormat("dd/MM/yyyy");
        list = new Hashtable<String, NhanVien>();
    }
    
    public Hashtable<String, NhanVien> getDanhSachNhanVien() throws SQLException{
        d.openConnection();
        rs = d.executeQuery(sqlSelect);
        list.clear();
        
        while (rs.next()) {
            int id = rs.getInt("idNv");
            String maNv = rs.getString("maNv");
            String tenNv = rs.getString("tenNV");
            Date ngaySinh = rs.getDate("ngaySinh");
            String gioiTinh = rs.getString("gioiTinh");
            Date ngayVaoCoQuan = rs.getDate("ngayVaoCoQuan");
            String soCMND = rs.getString("soCMND");
            Double heSoLuong = rs.getDouble("heSoLuong");

            NhanVien nv = null;
            if (id == 1){
                nv = new NhanVienHopDong(maNv, tenNv, ngayVaoCoQuan, gioiTinh, soCMND, ngaySinh, heSoLuong);
            }
            else if (id == 2){
                nv = new NhanVienBienChe(maNv, tenNv, ngayVaoCoQuan, gioiTinh, soCMND, ngaySinh, heSoLuong);
            }
            list.put(maNv, nv);
        }
        d.closeConnection();
        
        return list;
    }
    
    public void addStaff(NhanVien nv) throws SQLException{
        d.openConnection();
        Connection conn = d.getConn();
        PreparedStatement stmt = conn.prepareStatement(sqlInsert);
        stmt.setInt(1, (nv instanceof NhanVienHopDong)?1:2);
        stmt.setString(2, nv.getHoTen());
        stmt.setDate(3, new Date(nv.getNgaySinh().getTime()));
        stmt.setString(4, nv.getGioiTinh());
        stmt.setDate(5, new Date(nv.getNgayVaoCoQuan().getTime()));
        stmt.setString(6, nv.getSoCM());
        stmt.setDouble(7, (nv instanceof NhanVienHopDong)?((NhanVienHopDong)nv).getMucLuong():((NhanVienBienChe)nv).getHeSoLuong());
        stmt.execute();
        d.closeConnection();
    }
    
    public void editStaff(NhanVien nv) throws SQLException{
        d.openConnection();
        Connection conn = d.getConn();
        PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
        stmt.setInt(1, (nv instanceof NhanVienHopDong)?1:2);
        stmt.setString(2, nv.getHoTen());
        stmt.setDate(3, new Date(nv.getNgaySinh().getTime()));
        stmt.setString(4, nv.getGioiTinh());
        stmt.setDate(5, new Date(nv.getNgayVaoCoQuan().getTime()));
        stmt.setString(6, nv.getSoCM());
        stmt.setDouble(7, (nv instanceof NhanVienHopDong)?((NhanVienHopDong)nv).getMucLuong():((NhanVienBienChe)nv).getHeSoLuong());
        stmt.setInt(8, Integer.parseInt(nv.getMaNV()));
        stmt.execute();
        d.closeConnection();
    }
    
    public void removeStaff(String maNV) throws SQLException{
        d.openConnection();
        Connection conn = d.getConn();
        PreparedStatement stmt = conn.prepareStatement(sqlRemove);
        stmt.setInt(1, Integer.parseInt(maNV));
        stmt.execute();
        d.closeConnection();
    }
    
    public Hashtable<String, NhanVien> findStaff(String tenNV) throws SQLException{
        d.openConnection();
        Connection conn = d.getConn();
        PreparedStatement stmt = conn.prepareStatement(sqlFind);
        stmt.setString(1, tenNV+"%");
        rs = stmt.executeQuery();
        list.clear();
        
        while (rs.next()) {
            int id = rs.getInt("idNv");
            String maNv = rs.getString("maNv");
            String tenNv = rs.getString("tenNV");
            Date ngaySinh = rs.getDate("ngaySinh");
            String gioiTinh = rs.getString("gioiTinh");
            Date ngayVaoCoQuan = rs.getDate("ngayVaoCoQuan");
            String soCMND = rs.getString("soCMND");
            Double heSoLuong = rs.getDouble("heSoLuong");

            NhanVien nv = null;
            if (id == 1){
                nv = new NhanVienHopDong(maNv, tenNv, ngayVaoCoQuan, gioiTinh, soCMND, ngaySinh, heSoLuong);
            }
            else if (id == 2){
                nv = new NhanVienBienChe(maNv, tenNv, ngayVaoCoQuan, gioiTinh, soCMND, ngaySinh, heSoLuong);
            }
            list.put(maNv, nv);
        }
        d.closeConnection();
        System.out.println(list);
        return list;
    }
}
