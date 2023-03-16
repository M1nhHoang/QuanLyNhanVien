/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appRun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class NhanVienBienChe extends NhanVien{
    private double heSoLuong;
    DateFormat d;

    public NhanVienBienChe(String maNV, String hoTen, Date NgayVaoCoQuan, String gioiTinh, String soCM, Date ngaySinh, double heSoLuong) {
        super(maNV, hoTen, NgayVaoCoQuan, gioiTinh, soCM, ngaySinh);
        this.heSoLuong = heSoLuong;
        d = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public double PhuCap() {
        if (super.ThamNien() > 10)
            return super.getLuongCB()*10/100+500000;
        else
            return super.getLuongCB()*10/100+200000;
    }

    @Override
    public double ThucLinh() {
        return this.heSoLuong*super.getLuongCB()+PhuCap();
    }

    @Override
    public String toString() {
        return "2"+','+super.getMaNV()+','+super.getHoTen()
                +','+d.format(super.getNgayVaoCoQuan())+','+super.getGioiTinh()+','+super.getSoCM()
                +','+d.format(super.getNgaySinh())+','+heSoLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
}
