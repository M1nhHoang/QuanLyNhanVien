/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.BusinessLogic;

import appRun.*;
import QuanLiNhanVien.ProcessData.pdQuanLiNhanVien;
import QuanLiNhanVien.GUI.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

/**
 *
 * @author HP
 */
public class blQuanLiNhanVien{
    private Hashtable<String, NhanVien> dsNhanVien;
    private FrameNhanVien frame;
    private pdQuanLiNhanVien pdQuanLiNhanVien;
    private DateFormat d;

    public blQuanLiNhanVien(FrameNhanVien frm) throws SQLException {
        dsNhanVien = new Hashtable<String, NhanVien>();
        pdQuanLiNhanVien = new pdQuanLiNhanVien();
        d = new SimpleDateFormat("dd/MM/yyyy");
        frame = frm;
        showTableDsNv();
        LoadCobobox();
    }
    
    public void showTableDsNv() throws SQLException{
        // get dsnv
        dsNhanVien = pdQuanLiNhanVien.getDanhSachNhanVien();
        // set model
        MyModel model = new MyModel(dsNhanVien, frame.columnNames);
        frame.table.setModel(model);
    }
    
    public void addStaff() throws SQLException, ParseException{
        NhanVien nv = null;
        if (frame.cobLoaiNhanVien.getSelectedItem().equals("Nhân viên biên chế")){
            nv = new NhanVienHopDong(frame.txtMaNv.getText(), frame.txtHoTen.getText(),
                            d.parse(frame.txtNgayVaoCoQuan.getText()), (frame.ckNam.getState())?"Nam":"Nữ", 
                            frame.txtSoCm.getText(), d.parse(frame.txtNgaySinh.getText()), 
                            Double.parseDouble(frame.txtHeSoLuong.getText()));
        }
        else {
            nv = new NhanVienBienChe(frame.txtMaNv.getText(), frame.txtHoTen.getText(),
                                d.parse(frame.txtNgayVaoCoQuan.getText()), (frame.ckNam.getState())?"Nam":"Nữ", 
                                frame.txtSoCm.getText(), d.parse(frame.txtNgaySinh.getText()), 
                                Double.parseDouble(frame.txtMucLuong.getText()));
        }
        pdQuanLiNhanVien.addStaff(nv);
        showTableDsNv();
    }
    
    public void editStaff() throws SQLException, ParseException{
        NhanVien nv = null;
        if (frame.cobLoaiNhanVien.getSelectedItem().equals("Nhân viên biên chế")){
            nv = new NhanVienHopDong(frame.txtMaNv.getText(), frame.txtHoTen.getText(),
                            d.parse(frame.txtNgayVaoCoQuan.getText()), (frame.ckNam.getState())?"Nam":"Nữ", 
                            frame.txtSoCm.getText(), d.parse(frame.txtNgaySinh.getText()), 
                            Double.parseDouble(frame.txtHeSoLuong.getText()));
        }
        else {
            nv = new NhanVienBienChe(frame.txtMaNv.getText(), frame.txtHoTen.getText(),
                                d.parse(frame.txtNgayVaoCoQuan.getText()), (frame.ckNam.getState())?"Nam":"Nữ", 
                                frame.txtSoCm.getText(), d.parse(frame.txtNgaySinh.getText()), 
                                Double.parseDouble(frame.txtMucLuong.getText()));
        }
        pdQuanLiNhanVien.editStaff(nv);
        showTableDsNv();
    }
    
    public void removeStaff() throws SQLException{
        pdQuanLiNhanVien.removeStaff(frame.txtMaNv.getText());
        showTableDsNv();
    }
    
    public void findStaff() throws SQLException{
        // set model
        MyModel model = new MyModel(pdQuanLiNhanVien.findStaff(frame.txtHoTen.getText()), frame.columnNames);
        frame.table.setModel(model);
    }
    
    public void LoadCobobox() throws SQLException{
        for(String loaiNv: pdQuanLiNhanVien.getDanhSachLoaiNhanVien().values()){
            frame.cobLoaiNhanVien.addItem(loaiNv);
        }
    }
}
