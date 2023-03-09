/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.BusinessLogic;

import QuanLiNhanVien.ProcessData.pdQuanLiNhanVien;
import QuanLiNhanVien.GUI.*;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 *
 * @author HP
 */
public class blQuanLiNhanVien{
    private Hashtable<String, NhanVien> dsNhanVien;
    private pdQuanLiNhanVien pdQuanLiNhanVien;

    public blQuanLiNhanVien() {
        dsNhanVien = new Hashtable<String, NhanVien>();
        pdQuanLiNhanVien = new pdQuanLiNhanVien();
    }
    
    public Hashtable<String, NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }

    public void setDsNhanVien(Hashtable<String, NhanVien> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
    }
    
    public Hashtable<String, NhanVien> showDsNv() throws SQLException{
        dsNhanVien = pdQuanLiNhanVien.getDanhSachNhanVien();
        return dsNhanVien;
    }
    
    public void addStaff(NhanVien nv) throws SQLException{
        pdQuanLiNhanVien.addStaff(nv);
    }
    
    public void editStaff(NhanVien nv) throws SQLException{
        pdQuanLiNhanVien.editStaff(nv);
    }
    
    public void removeStaff(String maNv) throws SQLException{
        pdQuanLiNhanVien.removeStaff(maNv);
    }
    
    public Hashtable<String, NhanVien> findStaff(String tenNv) throws SQLException{
        dsNhanVien = pdQuanLiNhanVien.findStaff(tenNv);
        return dsNhanVien;
    }
}
