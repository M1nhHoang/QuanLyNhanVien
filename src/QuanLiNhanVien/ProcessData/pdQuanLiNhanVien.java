/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.ProcessData;
import appRun.NhanVienHopDong;
import appRun.NhanVienBienChe;
import appRun.NhanVien;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

/**
 *
 * @author HP
 */
public class pdQuanLiNhanVien {
    private SQLSEVERDataAccess d;
    private ResultSet rs;
    private String sqlSelect = "select * from nhanVien";
    private String sqlInsert = "insert into nhanVien values (?, ?, ?, ?, ?, ?, ?)";
    private String sqlUpdate = "update nhanVien set idNv=?, tenNV=?, ngaySinh=?, gioiTinh=?, ngayVaoCoQuan=?, soCMND=?, heSoLuong=? where maNv=?";
    private String sqlRemove = "delete from nhanVien where maNv = ?";
    private String sqlFind = "select * from nhanVien where tenNV like ?";
    private DateFormat df;
    private Hashtable<String, NhanVien> list;
    
    public pdQuanLiNhanVien() throws SQLException{
        d = new SQLSEVERDataAccess();
        df = new SimpleDateFormat("dd/MM/yyyy");
        list = new Hashtable<String, NhanVien>();
    }
    
    public Hashtable<String, NhanVien> getDanhSachNhanVien() throws SQLException{
        rs = d.getResultSet_StoredProcedures("psGetNhanVien", null);
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
        return list;
    }
    public Hashtable<Integer, String> getDanhSachLoaiNhanVien() throws SQLException{
        Hashtable<Integer, String> list=new Hashtable<Integer, String>();
        
        rs = d.getResultSet("select * from loaiNhanVien");
        list.clear();

        while (rs.next()) {
            int id = rs.getInt(1);
            String tenloai = rs.getString(2);
            list.put(id, tenloai);
        }
        return list;
    }
    
    public void addStaff(NhanVien nv) throws SQLException{
        d.Execute_StoredProcedures("psThemNhanVien", new Object[]{(nv instanceof NhanVienHopDong)?1:2, nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getNgayVaoCoQuan(), 
nv.getSoCM(), (nv instanceof NhanVienHopDong)?((NhanVienHopDong)nv).getMucLuong():((NhanVienBienChe)nv).getHeSoLuong()});
    }
    
    public void editStaff(NhanVien nv) throws SQLException{
        d.Execute_StoredProcedures("psSuaNhanVien", new Object[]{(nv instanceof NhanVienHopDong)?1:2, nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getNgayVaoCoQuan(), 
nv.getSoCM(), (nv instanceof NhanVienHopDong)?((NhanVienHopDong)nv).getMucLuong():((NhanVienBienChe)nv).getHeSoLuong()});
    }
    
    public void removeStaff(String maNV) throws SQLException{
        d.Execute_StoredProcedures("psXoaNhanVien", new Object[]{Integer.parseInt(maNV)});
    }
    
    public Hashtable<String, NhanVien> findStaff(String tenNV) throws SQLException{
        rs = d.getResultSet_StoredProcedures("psTimKiemNhanVien", new Object[]{tenNV});
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
        return list;
    }
}
