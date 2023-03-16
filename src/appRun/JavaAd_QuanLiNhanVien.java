package appRun;

import QuanLiNhanVien.BusinessLogic.blQuanLiNhanVien;
import QuanLiNhanVien.GUI.FrameNhanVien;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



/**
 *
 * @author HP
 */
public class JavaAd_QuanLiNhanVien {

    public static void main(String[] args) throws SQLException {
        FrameNhanVien f = new FrameNhanVien();
        f.show();
        System.out.println("Hello World!");
    }
}
