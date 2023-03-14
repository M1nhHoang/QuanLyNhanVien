/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien.GUI;

import QuanLiNhanVien.BusinessLogic.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author HP
 */
public class FrameNhanVien extends JFrame implements ActionListener, ListSelectionListener, ItemListener {
    private Label lbMaNv;
    private Label lbHoten;
    private Label lbGioiTinh;
    private Label lbNgaySinh;
    private Label lbSoCM;
    private Label lbNgayVaoCoQuan;
    private Label lbHeSoLuong;
    private Label lbMucLuong;
    private Label lbAnhNhanVien;
    private TextField txtMaNv;
    private TextField txtHoTen;
    private TextField txtNgaySinh;
    private TextField txtSoCm;
    private TextField txtNgayVaoCoQuan;
    private TextField txtHeSoLuong;
    private TextField txtMucLuong;
    private Checkbox ckNhanVienBienChe;
    private Checkbox ckNhanVienHopDong;
    private Checkbox ckNam;
    private Checkbox ckNu;
    private CheckboxGroup gGioiTinh;
    private CheckboxGroup gLoaiNv;
    private Button btAddStaff;
    private Button btRemoveStaff;
    private Button btEditStaff;
    private Button btFindStaff;
    private JScrollPane scrPane;
    private JTable table;
    private blQuanLiNhanVien BLQuanLiNhanVien;
    private MyModel model;
    private String[] columnNames = {"MaNV",
                            "Họ tên",
                            "Giới Tính",
                            "Ngày Sinh",
                            "Số CM",
                            "Ngày ra vào cơ quan",
                            "Loại Nv",
                            "Lương",
                            "Thực Lĩnh"};
    
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
        
        lbMaNv.setBounds(150, 30, 150, 30);
        lbHoten.setBounds(150, 60, 150, 30);
        lbGioiTinh.setBounds(150, 90, 150, 30);
        lbNgaySinh.setBounds(150, 120, 150, 30);
        lbSoCM.setBounds(150, 150, 150, 30);
        lbNgayVaoCoQuan.setBounds(150, 180, 150, 30);
        lbHeSoLuong.setBounds(50, 240, 100, 30);
        lbMucLuong.setBounds(350, 240,70, 30);
        lbAnhNhanVien.setBounds(30, 80, 150, 30);
        
        add(lbMaNv);
        add(lbHoten);
        add(lbGioiTinh);
        add(lbNgaySinh);
        add(lbSoCM);
        add(lbNgayVaoCoQuan);
        add(lbHeSoLuong);
        add(lbMucLuong);
        add(lbAnhNhanVien);
        
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
        //Group Nhan Vien
        gLoaiNv = new CheckboxGroup();
        ckNhanVienBienChe = new Checkbox("Nhân Viên Biên Chế", gLoaiNv, true);
        ckNhanVienHopDong = new Checkbox("Nhân Viên Hợp Đồng", gLoaiNv, false);
        
        ckNhanVienBienChe.setBounds(150, 210, 150, 30);
        ckNhanVienHopDong.setBounds(300, 210, 150, 30);
        
        ckNhanVienBienChe.addItemListener(this);
        ckNhanVienHopDong.addItemListener(this);
        
        add(ckNhanVienBienChe);
        add(ckNhanVienHopDong);
        
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
        btEditStaff = new Button("Xóa");
        btFindStaff = new Button("Sửa");
        btRemoveStaff = new Button("Tìm");
        
        btAddStaff.setBounds(40, 280, 90, 30);
        btEditStaff.setBounds(170, 280, 90, 30);
        btFindStaff.setBounds(340, 280, 90, 30);
        btRemoveStaff.setBounds(470, 280, 90, 30);
        
        btAddStaff.addActionListener(this);
        btEditStaff.addActionListener(this);
        btFindStaff.addActionListener(this);
        btRemoveStaff.addActionListener(this);
        
        add(btAddStaff);
        add(btEditStaff);
        add(btFindStaff);
        add(btRemoveStaff);
        
        BLQuanLiNhanVien = new blQuanLiNhanVien();
        // table
        model = new MyModel(BLQuanLiNhanVien.showDsNv(),columnNames);
        
        table = new JTable(model);
        table.getSelectionModel().addListSelectionListener(this);

        
        // scr panel
        scrPane = new JScrollPane(table);
        scrPane.setViewportView(table);
        
        scrPane.setBounds(25, 350, 550, 200);
        
        add(scrPane);
        table.setModel(model);
    }
    
    public void checkInput(){
        if (ckNhanVienBienChe.getState() == true){
            txtMucLuong.setEnabled(false);
            txtHeSoLuong.setEnabled(true);
        }
        else{
            txtMucLuong.setEnabled(true);
            txtHeSoLuong.setEnabled(false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Button temp = (Button)e.getSource();
        NhanVien nv = null;
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        if(temp.getLabel().equals("Thêm mới")){
            if (ckNhanVienHopDong.getState()){
                try {
                    nv = new NhanVienHopDong(txtMaNv.getText(), txtHoTen.getText(),
                            d.parse(txtNgayVaoCoQuan.getText()), (ckNam.getState())?"Nam":"Nữ", 
                            txtSoCm.getText(), d.parse(txtNgaySinh.getText()), 
                            Double.parseDouble(txtMucLuong.getText()));
                }catch(Exception ex){}}
            else 
                try {
                    nv = new NhanVienBienChe(txtMaNv.getText(), txtHoTen.getText(),
                                d.parse(txtNgayVaoCoQuan.getText()), (ckNam.getState())?"Nam":"Nữ", 
                                txtSoCm.getText(), d.parse(txtNgaySinh.getText()), 
                                Double.parseDouble(txtHeSoLuong.getText()));
                }catch(Exception ex){}
            try {
                BLQuanLiNhanVien.addStaff(nv);
                model = new MyModel(BLQuanLiNhanVien.showDsNv(),columnNames);
            } catch (SQLException ex) {
                Logger.getLogger(FrameNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(temp.getLabel().equals("Sửa")){
            if (ckNhanVienHopDong.getState()){
                try {
                    nv = new NhanVienHopDong(txtMaNv.getText(), txtHoTen.getText(),
                            d.parse(txtNgayVaoCoQuan.getText()), (ckNam.getState())?"Nam":"Nữ", 
                            txtSoCm.getText(), d.parse(txtNgaySinh.getText()), 
                            Double.parseDouble(txtMucLuong.getText()));
                }catch(Exception ex){}}
            else 
                try {
                    nv = new NhanVienBienChe(txtMaNv.getText(), txtHoTen.getText(),
                                d.parse(txtNgayVaoCoQuan.getText()), (ckNam.getState())?"Nam":"Nữ", 
                                txtSoCm.getText(), d.parse(txtNgaySinh.getText()), 
                                Double.parseDouble(txtHeSoLuong.getText()));
                }catch(Exception ex){}
            try {
                BLQuanLiNhanVien.editStaff(nv);
                model = new MyModel(BLQuanLiNhanVien.showDsNv(),columnNames);
            } catch (SQLException ex) {
                Logger.getLogger(FrameNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(temp.getLabel().equals("Xóa")){
            try {
                BLQuanLiNhanVien.removeStaff(txtMaNv.getText());
                model = new MyModel(BLQuanLiNhanVien.showDsNv(),columnNames);
            } catch (SQLException ex) {
                Logger.getLogger(FrameNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(temp.getLabel().equals("Tìm")){
            try {
                model = new MyModel(BLQuanLiNhanVien.findStaff(txtHoTen.getText()),columnNames);
            } catch (SQLException ex) {
                Logger.getLogger(FrameNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        table.setModel(model);
    }

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
            if (table.getValueAt(table.getSelectedRow(), 6).toString().equals("Nhân Viên Biên Chế")){
                ckNhanVienBienChe.setState(true);
                txtHeSoLuong.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
                txtMucLuong.setText("");
            }
            else{
                ckNhanVienHopDong.setState(true);
                txtHeSoLuong.setText("");
                txtMucLuong.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
            }
            checkInput();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        checkInput();
    }
}