/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.BusinessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author HP
 */
public abstract class NhanVien implements INhanVien{
    private String maNV;
    private String hoTen;
    private Date NgayVaoCoQuan;
    private String gioiTinh;
    private String soCM;
    private Date ngaySinh;
    DateFormat sdf;

    public NhanVien(String maNV, String hoTen, Date NgayVaoCoQuan, String gioiTinh, String soCM, Date ngaySinh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.NgayVaoCoQuan = NgayVaoCoQuan;
        this.gioiTinh = gioiTinh;
        this.soCM = soCM;
        this.ngaySinh = ngaySinh;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    @Override
    public abstract double PhuCap();
    
    @Override
    public abstract double ThucLinh();

    @Override
    public abstract String toString();
    
    public int ThamNien(){
        Date NgayHienTai = new Date();

        long diffInMillies = Math.abs(NgayHienTai.getTime() - this.NgayVaoCoQuan.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        
        return (int)diff;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgayVaoCoQuan() {
        return NgayVaoCoQuan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoCM() {
        return soCM;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public static int getLuongCB() {
        return LuongCB;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgayVaoCoQuan(Date NgayVaoCoQuan) {
        this.NgayVaoCoQuan = NgayVaoCoQuan;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSoCM(String soCM) {
        this.soCM = soCM;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    
}
