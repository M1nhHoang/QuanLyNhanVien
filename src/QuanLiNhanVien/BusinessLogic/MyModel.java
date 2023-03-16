/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.BusinessLogic;

import appRun.NhanVienHopDong;
import appRun.NhanVienBienChe;
import appRun.NhanVien;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class MyModel extends AbstractTableModel{
    private ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
    private String colName[];
    
    public MyModel(Hashtable<String, NhanVien> dsnv, String colName[]){
        this.dsNhanVien.addAll(dsnv.values());
        this.colName = colName;
    }
    
    public void updateData(Hashtable<String, NhanVien> dsNhanVien){
        this.dsNhanVien.addAll(dsNhanVien.values());
    }
    
    @Override
    public int getRowCount() {
        return dsNhanVien.size();
    }

    @Override
    public int getColumnCount() {
        return colName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        NhanVien nv = dsNhanVien.get(rowIndex);
        switch(columnIndex) {
            case 0: return nv.getMaNV();
            case 1: return nv.getHoTen();
            case 2: return nv.getGioiTinh();
            case 3: return d.format(nv.getNgaySinh());
            case 4: return nv.getSoCM();
            case 5: return d.format(nv.getNgayVaoCoQuan());
            case 6: return (nv instanceof NhanVienBienChe)?"Nhân viên biên chế":"Nhân viên hợp đồng";
            case 7: return (nv instanceof NhanVienBienChe)?((NhanVienBienChe)nv).getHeSoLuong():((NhanVienHopDong)nv).getMucLuong();
            case 8: return nv.ThucLinh();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colName[columnIndex];
    } 
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
