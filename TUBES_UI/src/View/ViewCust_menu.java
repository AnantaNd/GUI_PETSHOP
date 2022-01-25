package View;

import Database.ConnectionDB;
import PetShopClass.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewCust_menu extends javax.swing.JFrame {

    ConnectionDB conn;
    Customer user;
    DefaultListModel<String> listAcc = new DefaultListModel<>();
    DefaultListModel<String> listAnj = new DefaultListModel<>();
    DefaultListModel<String> listKcn = new DefaultListModel<>();
    
    public ViewCust_menu(Customer cust) {
        initComponents();
        conn = new ConnectionDB();
        this.user = cust;
        
        tampilAcc();
        tampilAnj();
        tampilKcn();
        tampilCart();
    }
    
    // --- ACC ---
    private void tampilCart(){
        cartTable.setModel(new DefaultTableModel(null, new String []{"produk", "harga"}));
        try{
            String sql = "SELECT * FROM cart WHERE no_hp = '"+user.getNohp()+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String produk = rs.getString(3);
                String harga = rs.getString(4);
                
                String cols[] = {produk, harga};
                DefaultTableModel table = (DefaultTableModel)cartTable.getModel();
                table.addRow(cols);
            }
        }catch(SQLException e){
            System.err.print(e);
        }
    }

    private void tampilAcc(){
        listAcc.clear();
        try{
            String sql = "SELECT * FROM aksesoris";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String nama = rs.getString(2);
                listAcc.addElement(nama);
            }
            jListAcc1.setModel(listAcc);
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    private void detailAcc(String key){
        try{
            String sql = "SELECT * FROM aksesoris WHERE aksesoris = '"+key+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String acc = rs.getString(2);
                String ket = rs.getString(3);
                String qnt = rs.getString(4);
                String fee = rs.getString(5);
                
                jLabel31.setText(acc);
                jLabel32.setText(ket);
                jLabel33.setText(qnt);
                jLabel34.setText(fee);
            }
        }catch(SQLException e){
            System.err.print(e);
        }
    }
    
    //--- ANJING ---
     private void tampilAnj(){
        listAnj.clear();
        try{
            String sql = "SELECT * FROM anjing";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String nama = rs.getString(3);
                listAnj.addElement(nama);
            }
            jListAnj1.setModel(listAnj);
        } catch (SQLException ex) {
            System.err.print(ex);
        }
     }
     private void detailAnj(String key){
        try{
            String sql = "SELECT * FROM anjing WHERE nama_anjing ='"+key+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String jenis = rs.getString(2);
                String anjing = rs.getString(3);
                String umur = rs.getString(4);
                String gndr = rs.getString(5);
                String fee = rs.getString(6);
                
                jLabel10.setText(anjing);
                jLabel11.setText(jenis);
                jLabel12.setText(umur);
                jLabel13.setText(gndr);
                jLabel14.setText(fee);
            }
        }catch(SQLException e){
            System.err.print(e);
        }
     }
     
    //--- KUCING ---
    private void tampilKcn(){
        listKcn.clear();
        try{
            String sql = "SELECT * FROM kucing";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String nama = rs.getString(3);
                listKcn.addElement(nama);
            }
            jListKcn1.setModel(listKcn);
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    private void detailKcn(String key){
        try{
            String sql = "SELECT * FROM kucing WHERE nama_kucing ='"+key+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String jenis = rs.getString(2);
                String kucing = rs.getString(3);
                String umur = rs.getString(4);
                String gndr = rs.getString(5);
                String fee = rs.getString(6);
                
                jLabel25.setText(kucing);
                jLabel24.setText(jenis);
                jLabel23.setText(umur);
                jLabel22.setText(gndr);
                jLabel21.setText(fee);
            }
        }catch(SQLException ex){
            System.err.print(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogOPK = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        anjPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListAnj1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kcnPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListKcn1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        accPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListAcc1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        bckButton = new javax.swing.JButton();
        orderBtn = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bayarButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();

        dialogOPK.setTitle("Order Produk");
        dialogOPK.setSize(new java.awt.Dimension(583, 446));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel3.setText("PRODUK");

        jListAnj1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAnj1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAnj1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListAnj1);

        jButton1.setText("Keranjang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama");

        jLabel5.setText("Jenis");

        jLabel6.setText("Umur");

        jLabel7.setText("Gender");

        jLabel8.setText("Harga");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Detail Produk");

        javax.swing.GroupLayout anjPanelLayout = new javax.swing.GroupLayout(anjPanel);
        anjPanel.setLayout(anjPanelLayout);
        anjPanelLayout.setHorizontalGroup(
            anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anjPanelLayout.createSequentialGroup()
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(anjPanelLayout.createSequentialGroup()
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel9))
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );
        anjPanelLayout.setVerticalGroup(
            anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(anjPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(24, 24, 24)
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(anjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        TabbedPane.addTab("Anjing", anjPanel);

        jListKcn1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListKcn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListKcn1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListKcn1);

        jButton2.setText("Keranjang");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Detail Produk");

        jLabel16.setText("Nama");

        jLabel17.setText("Jenis");

        jLabel18.setText("Umur");

        jLabel19.setText("Gender");

        jLabel20.setText("Harga");

        javax.swing.GroupLayout kcnPanelLayout = new javax.swing.GroupLayout(kcnPanel);
        kcnPanel.setLayout(kcnPanelLayout);
        kcnPanelLayout.setHorizontalGroup(
            kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kcnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kcnPanelLayout.createSequentialGroup()
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)))
                    .addGroup(kcnPanelLayout.createSequentialGroup()
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jButton2))
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kcnPanelLayout.setVerticalGroup(
            kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kcnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(kcnPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(24, 24, 24)
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(kcnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabbedPane.addTab("Kucing", kcnPanel);

        jListAcc1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAcc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAcc1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListAcc1);

        jButton3.setText("Keranjang");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel26.setText("nama");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Detail Produk");

        jLabel28.setText("Keterangan");

        jLabel29.setText("Jumlah");

        jLabel30.setText("Harga");

        javax.swing.GroupLayout accPanelLayout = new javax.swing.GroupLayout(accPanel);
        accPanel.setLayout(accPanelLayout);
        accPanelLayout.setHorizontalGroup(
            accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accPanelLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31))
                    .addGroup(accPanelLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32))
                    .addGroup(accPanelLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33))
                    .addGroup(accPanelLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34))
                    .addGroup(accPanelLayout.createSequentialGroup()
                        .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jButton3))
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );
        accPanelLayout.setVerticalGroup(
            accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(accPanelLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(accPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 123, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        TabbedPane.addTab("Aksesoris", accPanel);

        bckButton.setText("Kembali");
        bckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogOPKLayout = new javax.swing.GroupLayout(dialogOPK.getContentPane());
        dialogOPK.getContentPane().setLayout(dialogOPKLayout);
        dialogOPKLayout.setHorizontalGroup(
            dialogOPKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogOPKLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogOPKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(dialogOPKLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bckButton)))
                .addContainerGap())
        );
        dialogOPKLayout.setVerticalGroup(
            dialogOPKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogOPKLayout.createSequentialGroup()
                .addGroup(dialogOPKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogOPKLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogOPKLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bckButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPane)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Menu");
        setSize(new java.awt.Dimension(462, 334));

        orderBtn.setText("Order Produk");
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lithos Pro Regular", 0, 48)); // NOI18N
        jLabel1.setText("MENU");

        bayarButton.setText("Bayar");
        bayarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Batal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Keranjang");

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Produk", "Harga (Rp)"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(orderBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logoutButton)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bayarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutButton)
                            .addComponent(jLabel1))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bayarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderBtn)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        dialogOPK.show();
        dialogOPK.setLocationRelativeTo(null);
    }//GEN-LAST:event_orderBtnActionPerformed

    private void bayarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarButtonActionPerformed
        DefaultTableModel tbl = (DefaultTableModel) cartTable.getModel();
        int jumlah = 0;
        try{
            String sql = "SELECT * FROM cart WHERE no_hp = '"+user.getNohp()+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                jumlah = 0;
                for(int i=0;i<tbl.getRowCount();i++){
                    String d = cartTable.getValueAt(i, 1).toString();
                    jumlah += Integer.parseInt(d);
                }
            }
            JOptionPane.showMessageDialog(null, "Total : Rp" + jumlah + ".\n"
                        + "Beritahu Kasir No Handphone anda yang terdaftar pada aplikasi PetShop ini!");
        }catch(SQLException e){
            System.err.print(e);
        }
    }//GEN-LAST:event_bayarButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
       Login login = new Login();
       login.setVisible(true);
       dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void jListAnj1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAnj1MouseClicked
        if(evt.getClickCount()==1){
            detailAnj(jListAnj1.getSelectedValue());
        }
    }//GEN-LAST:event_jListAnj1MouseClicked

/*------------------------------------------------------------------- ADD ANJ TO CART -------------------------------------------------------------------*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String produk = null, harga = null;
        //load data from table anjing
        try{
            String sql ="SELECT * FROM anjing WHERE nama_anjing = '"+
                    (jListAnj1.getSelectedValue()+"'");
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                produk = rs.getString(3);
                harga = rs.getString(6);
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
        //insert into table cart
        try{
            String in = "INSERT INTO cart (nama_cust, nama_produk, harga, no_hp)"
                        +"VALUES("
                        +"'"+user.getNama()+"',"
                        +"'"+produk+"',"
                        +"'"+harga+"',"
                        +"'"+user.getNohp()+"'"
                        + ");";
            conn.query(in);
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
         //delete anjing from table anjing
        try{
            String del = "DELETE FROM anjing WHERE nama_anjing = '"+jListAnj1.getSelectedValue()+"'";
            conn.query(del);
            JOptionPane.showMessageDialog(null, produk+ " berhasil ditambahkan ke keranjang");
            tampilAnj();
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jListKcn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListKcn1MouseClicked
        if(evt.getClickCount()==1){
            detailKcn(jListKcn1.getSelectedValue());
        }
    }//GEN-LAST:event_jListKcn1MouseClicked

    private void jListAcc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAcc1MouseClicked
        if(evt.getClickCount()==1){
            detailAcc(jListAcc1.getSelectedValue());
        }
    }//GEN-LAST:event_jListAcc1MouseClicked

    private void bckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckButtonActionPerformed
        dialogOPK.hide();
        tampilCart();
    }//GEN-LAST:event_bckButtonActionPerformed

/*------------------------------------------------------------------- ADD KCG TO CART -------------------------------------------------------------------*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String produk = null, harga = null;
        //load data from table kucing
        try{
            String sql ="SELECT * FROM kucing WHERE nama_kucing = '"+
                    (jListKcn1.getSelectedValue()+"'");
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                produk = rs.getString(3);
                harga = rs.getString(6);
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
        //insert into table cart
        try{
            String in = "INSERT INTO cart (nama_cust, nama_produk, harga, no_hp)"
                        +"VALUES("
                        +"'"+user.getNama()+"',"
                        +"'"+produk+"',"
                        +"'"+harga+"',"
                        +"'"+user.getNohp()+"'"
                        + ");";
            conn.query(in);
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
        //delete kucing from table kucing 
        try{
            String del = "DELETE FROM kucing WHERE nama_kucing = '"+jListKcn1.getSelectedValue()+"'";
            conn.query(del);
            JOptionPane.showMessageDialog(null, produk+ " berhasil ditambahkan ke keranjang");
            tampilKcn();
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

/*------------------------------------------------------------------- ADD ACC TO CART -------------------------------------------------------------------*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String produk = null, harga = null;
        //load data from table kucing
        try{
            String sql ="SELECT * FROM aksesoris WHERE aksesoris = '"+
                    (jListAcc1.getSelectedValue()+"'");
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                produk = rs.getString(2);
                harga = rs.getString(5);
            }
            
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
        //insert into table cart
        try{
            String in = "INSERT INTO cart (nama_cust, nama_produk, harga, no_hp)"
                        +"VALUES("
                        +"'"+user.getNama()+"',"
                        +"'"+produk+"',"
                        +"'"+harga+"',"
                        +"'"+user.getNohp()+"'"
                        + ");";
            conn.query(in);
            JOptionPane.showMessageDialog(null, produk+ " berhasil ditambahkan ke keranjang");
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
        //delete acc from table acc  
//        try{
//            String del = "DELETE FROM aksesoris WHERE aksesoris = '"+jListAcc1.getSelectedValue()+"'";
//            conn.query(del);
//            JOptionPane.showMessageDialog(null, produk + " berhasil ditambahkan ke keranjang");
//            tampilAcc();
//        }catch(Exception e){
//            System.err.print(e.getMessage());
//        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /*------------------------------------------------------------------- REMOVE FROM CART DB -------------------------------------------------------------------*/
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       if (cartTable.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(null, "Anda belum memilih produk yang akan dibatalkan", "KESALAHAN", JOptionPane.WARNING_MESSAGE);
       } else {
           int row = cartTable.getSelectedRow();
           String key = cartTable.getValueAt(row, 0).toString();
           try{
               String sql = "DELETE FROM cart WHERE nama_produk = '"+key+"'";
               conn.query(sql);
               JOptionPane.showMessageDialog(null, "Produk " + key +" berhasil dibatalkan");
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
           tampilCart();
       }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked

    }//GEN-LAST:event_cartTableMouseClicked

    public static void main(String args[]) {
        Customer user = new Customer();
        java.awt.EventQueue.invokeLater(() -> {
            new ViewCust_menu(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JPanel accPanel;
    private javax.swing.JPanel anjPanel;
    private javax.swing.JButton bayarButton;
    private javax.swing.JButton bckButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JDialog dialogOPK;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListAcc1;
    private javax.swing.JList<String> jListAnj1;
    private javax.swing.JList<String> jListKcn1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel kcnPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton orderBtn;
    // End of variables declaration//GEN-END:variables
}
