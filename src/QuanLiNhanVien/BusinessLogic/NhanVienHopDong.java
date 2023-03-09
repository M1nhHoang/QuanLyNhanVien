/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.BusinessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class NhanVienHopDong extends NhanVien{
    private double MucLuong;
    DateFormat d;

    public NhanVienHopDong(String maNV, String hoTen, Date NgayVaoCoQuan, String gioiTinh, String soCM, Date ngaySinh, double MucLuong) {
        super(maNV, hoTen, NgayVaoCoQuan, gioiTinh, soCM, ngaySinh);
        this.MucLuong = MucLuong;
        d = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    @Override
    public double PhuCap(){
        if (super.ThamNien() > 2)
            return this.MucLuong*10/100+200000;
        else
            return this.MucLuong*10/100+100000;
    }
    
    @Override
    public double ThucLinh(){
        return super.LuongCB+this.MucLuong+PhuCap();
    }
    
    @Override
    public String toString() {
        return "1"+','+super.getMaNV()+','+super.getHoTen()
                +','+d.format(super.getNgayVaoCoQuan())+','+super.getGioiTinh()+','+super.getSoCM()
                +','+d.format(super.getNgaySinh())+','+MucLuong;
    }

    public double getMucLuong() {
        return MucLuong;
    }

    public void setMucLuong(double MucLuong) {
        this.MucLuong = MucLuong;
    }
}
