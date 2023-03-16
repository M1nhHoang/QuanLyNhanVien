/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.GUI;

import QuanLiNhanVien.BusinessLogic.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author HP ActionListener, ListSelectionListener, ItemListener
 */
public class FrameNhanVien extends JFrame implements ListSelectionListener, ActionListener{
    public Label lbMaNv;
    public Label lbHoten;
    public Label lbGioiTinh;
    public Label lbNgaySinh;
    public Label lbSoCM;
    public Label lbNgayVaoCoQuan;
    public Label lbHeSoLuong;
    public Label lbMucLuong;
    public Label lbAnhNhanVien;
    public Label lbLoaiNhanVien;
    public TextField txtMaNv;
    public TextField txtHoTen;
    public TextField txtNgaySinh;
    public TextField txtSoCm;
    public TextField txtNgayVaoCoQuan;
    public TextField txtHeSoLuong;
    public TextField txtMucLuong;
    public Checkbox ckNhanVienBienChe;
    public Checkbox ckNhanVienHopDong;
    public Checkbox ckNam;
    public Checkbox ckNu;
    public CheckboxGroup gGioiTinh;
    public CheckboxGroup gLoaiNv;
    public Button btAddStaff;
    public Button btRemoveStaff;
    public Button btEditStaff;
    public Button btFindStaff;
    public JScrollPane scrPane;
    public JTable table;
    public String[] columnNames = {"MaNV",
                            "Họ tên",
                            "Giới Tính",
                            "Ngày Sinh",
                            "Số CM",
                            "Ngày ra vào cơ quan",
                            "Loại Nv",
                            "Lương",
                            "Thực Lĩnh"};
    public Choice cobLoaiNhanVien;
    public blQuanLiNhanVien bl;
    
    public FrameNhanVien() throws SQLException{
        this.setTitle("javaAdvance Chap 2");
        this.setLayout(null);
        super.setSize(600, 600);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Label
        lbMaNv = new Label("Mã Nhân Viên");
        lbHoten = new Label("Họ Tên");
        lbGioiTinh = new Label("Giới Tính");
        lbNgaySinh = new Label("Ngày Sinh");
        lbSoCM = new Label("Số Chứng Minh");
        lbNgayVaoCoQuan = new Label("Ngày Vào Cơ Quan");
        lbHeSoLuong = new Label("Hệ Số Lương");
        lbMucLuong = new Label("Mức Lương");
        lbAnhNhanVien = new Label("Ảnh Nhân Viên");
        lbLoaiNhanVien = new Label("Loại Nhân Viên");
        
        lbMaNv.setBounds(150, 30, 150, 30);
        lbHoten.setBounds(150, 60, 150, 30);
        lbGioiTinh.setBounds(150, 90, 150, 30);
        lbNgaySinh.setBounds(150, 120, 150, 30);
        lbSoCM.setBounds(150, 150, 150, 30);
        lbNgayVaoCoQuan.setBounds(150, 180, 150, 30);
        lbHeSoLuong.setBounds(50, 240, 100, 30);
        lbMucLuong.setBounds(350, 240,70, 30);
        lbAnhNhanVien.setBounds(30, 80, 150, 30);
        lbLoaiNhanVien.setBounds(150, 210, 150, 30);
        
        add(lbMaNv);
        add(lbHoten);
        add(lbGioiTinh);
        add(lbNgaySinh);
        add(lbSoCM);
        add(lbNgayVaoCoQuan);
        add(lbHeSoLuong);
        add(lbMucLuong);
        add(lbAnhNhanVien);
        add(lbLoaiNhanVien);
        
        //text Feild
        txtMaNv = new TextField();
        txtHoTen = new TextField();
        txtNgaySinh = new TextField();
        txtSoCm = new TextField();
        txtNgayVaoCoQuan = new TextField();
        txtHeSoLuong = new TextField();
        txtMucLuong = new TextField();
        
        txtMaNv.setBounds(330, 30, 250, 20);
        txtHoTen.setBounds(330, 60, 250, 20);
        txtNgaySinh.setBounds(330, 120, 250, 20);
        txtSoCm.setBounds(330, 150, 250, 20);
        txtNgayVaoCoQuan.setBounds(330, 180, 250, 20);
        txtHeSoLuong.setBounds(150, 240, 150, 20);
        txtMucLuong.setBounds(425, 240, 150, 20);
        
        txtMaNv.setEnabled(false);

        add(txtMaNv);
        add(txtHoTen);
        add(txtNgaySinh);
        add(txtSoCm);
        add(txtNgayVaoCoQuan);
        add(txtHeSoLuong);
        add(txtMucLuong);
        //CheckBox
        //Combobox loai nhan vien
        cobLoaiNhanVien = new Choice();
        cobLoaiNhanVien.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                if (cobLoaiNhanVien.getSelectedItem().equals("Nhân viên biên chế")){
                    txtMucLuong.setEnabled(false);
                    txtHeSoLuong.setEnabled(true);
                }
                else {
                    txtMucLuong.setEnabled(true);
                    txtHeSoLuong.setEnabled(false);
                }
            }
        });
        
        cobLoaiNhanVien.setBounds(330, 210, 150, 30);
        
        this.add(cobLoaiNhanVien);
        
        //Group Gioi Tính
        gGioiTinh = new CheckboxGroup();
        ckNam = new Checkbox("Nam", gGioiTinh, true);
        ckNu = new Checkbox("Nữ", gGioiTinh, false);
        
        ckNam.setBounds(330, 90, 50, 30);
        ckNu.setBounds(380, 90, 50, 30);
        
        add(ckNam);
        add(ckNu);
        
        // button
        btAddStaff = new Button("Thêm mới");
        btEditStaff = new Button("Sửa");
        btFindStaff = new Button("Tìm");
        btRemoveStaff = new Button("Xóa");
        
        btAddStaff.setBounds(40, 280, 90, 30);
        btEditStaff.setBounds(170, 280, 90, 30);
        btFindStaff.setBounds(470, 280, 90, 30);
        btRemoveStaff.setBounds(340, 280, 90, 30);
        
        btAddStaff.addActionListener(this);
        btEditStaff.addActionListener(this);
        btFindStaff.addActionListener(this);
        btRemoveStaff.addActionListener(this);
        
        add(btAddStaff);
        add(btEditStaff);
        add(btFindStaff);
        add(btRemoveStaff);
        
        // table
        table = new JTable();
        table.getSelectionModel().addListSelectionListener(this);

        
        // scr panel
        scrPane = new JScrollPane(table);
        scrPane.setViewportView(table);
        
        scrPane.setBounds(25, 350, 550, 200);
        
        add(scrPane);
        
        // bl layer
        bl = new blQuanLiNhanVien(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btAddStaff){
            try {
                bl.addStaff();
            } catch (SQLException | ParseException ex) {
                System.out.println(ex);
            }
        }
        else if(e.getSource() == btEditStaff){
            try {
                bl.editStaff();
            } catch (SQLException | ParseException ex) {
                System.out.println(ex);
            }
        }
        else if(e.getSource() == btFindStaff){
            try {
                bl.findStaff();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        else if(e.getSource() == btRemoveStaff){
            try {
                bl.removeStaff();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
//
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (table.getSelectedRow() != -1) {
            txtMaNv.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            txtHoTen.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            if (table.getValueAt(table.getSelectedRow(), 2).toString().equals("Nam"))
                ckNam.setState(true);
            else
                ckNu.setState(true);
            txtNgaySinh.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            txtSoCm.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
            txtNgayVaoCoQuan.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
            cobLoaiNhanVien.select(table.getValueAt(table.getSelectedRow(), 6).toString());
            if (table.getValueAt(table.getSelectedRow(), 6).toString().equals("Nhân viên biên chế")){
                txtHeSoLuong.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
                txtMucLuong.setText("");
                txtMucLuong.setEnabled(false);
                txtHeSoLuong.setEnabled(true);
            }
            else{
                txtMucLuong.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
                txtHeSoLuong.setText("");
                txtMucLuong.setEnabled(true);
                txtHeSoLuong.setEnabled(false);
            }
        }
    }
}