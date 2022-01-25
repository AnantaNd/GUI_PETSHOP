package View;

import Database.ConnectionDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class ViewAdmin_menu extends javax.swing.JFrame {
    ConnectionDB conn;
    String status;
    
    DefaultListModel<String> listAcc = new DefaultListModel<>();
    DefaultListModel<String> listAnj = new DefaultListModel<>();
    DefaultListModel<String> listKcn = new DefaultListModel<>();
    
    public ViewAdmin_menu() {
        initComponents();
        conn = new ConnectionDB();
        nonAktif();
        tampilAnj();
        tampilKcn();
        tampilAcc();
        tampilCust();
        tampilOrder();
    }
    
    // --- ACC ---
    public String getNamaAcc(){
        return namaField2.getText();
    }
    public String getDescAcc(){
        return ketTxtArea.getText();
    }
    public String getJlhAcc(){
        return jlhField.getText();
    }
    public String getHargaAcc(){
        return feeField2.getText();
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
            jList4.setModel(listAcc);
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
                
                nacLabel.setText(acc);
                ketLabel.setText(ket);
                jlhLabel.setText(qnt);
                hacLabel.setText(fee);
            }
        }catch(SQLException e){
            System.err.print(e);
        }
    }
    private void clearAcc(){
        nacLabel.setText(null);
        ketLabel.setText(null);
        jlhLabel.setText(null);
        hacLabel.setText(null);
    }
    //nonaktif button edit & delete
    public void nonAktifBtnAcc(){
        EditButton3.setEnabled(false);
        delButton2.setEnabled(false);
    }
    //aktif button edit & delete
    public void aktifBtnAcc(){
        EditButton3.setEnabled(true);
        delButton2.setEnabled(true);
    }
    
    // --- ANJING ---
    public String getNamaAnjing(){
        return namaField.getText();
    }
    public String getUmurAnjing(){
        return umurField.getText();
    }
    public String getRasAnjing(){
        return rasField.getText();
    }
    public String getFeeAnjing(){
        return feeField.getText();
    }
    public String getRadiobtnA(){
        if(jantanRB.isSelected()){
            return "Jantan";
        }else{
            return "Betina";
        }
    }
    private void tampilAnj(){
        listAnj.clear();
        try{
            String sql = "SELECT * FROM anjing";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String nama = rs.getString(3);
                listAnj.addElement(nama);
            }
            jList3.setModel(listAnj);
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    private void clearAnj(){
        namaField.setText(null);
        umurField.setText(null);
        rasField.setText(null);
        feeField.setText(null);
        bg1.clearSelection();
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
                
                naLabel.setText(anjing);
                jaLabel.setText(jenis);
                uaLabel.setText(umur);
                gaLabel.setText(gndr);
                haLabel.setText(fee);
            }
        }catch(SQLException e){
            System.err.print(e);
        }
    }
    //nonaktif button edit & delete
    public void nonAktifBtnAnj(){
        EditButton1.setEnabled(false);
        delButton1.setEnabled(false);
    }
    //aktif button edit & delete
    public void aktifBtnAnj(){
        EditButton1.setEnabled(true);
        delButton1.setEnabled(true);
    }
    
    // --- KUCING ---
    public String getNamaKucing(){
        return namaField1.getText();
    }
    public String getUmurKucing(){
        return umurField1.getText();
    }
    public String getRasKucing(){
        return rasField1.getText();
    }
    public String getFeeKucing(){
        return feeField1.getText();
    }
    public String getRadiobtnK(){
        if(jantanRB1.isSelected()){
            return "Jantan";
        }else{
            return "Betina";
        }
    }
    private void tampilKcn(){
        listKcn.clear();
        try{
            String sql = "SELECT * FROM kucing";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String nama = rs.getString(3);
                listKcn.addElement(nama);
            }
            jList2.setModel(listKcn);
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
                
                nkLabel.setText(kucing);
                jkLabel.setText(jenis);
                ukLabel.setText(umur);
                gkLabel.setText(gndr);
                hkLabel.setText(fee);
            }
        }catch(SQLException e){}
    }
    private void clearKcn(){
        namaField1.setText(null);
        umurField1.setText(null);
        rasField1.setText(null);
        feeField1.setText(null);
        bg1.clearSelection();
    }
    //nonaktif button edit & delete
    public void nonAktifBtnKcn(){
        EditButton2.setEnabled(false);
        delButton.setEnabled(false);
    }
    //aktif button edit & delete
    public void aktifBtnKcn(){
        EditButton2.setEnabled(true);
        delButton.setEnabled(true);
    }
    
    // --- CUSTOMER ---
    private void tampilCust(){
        try{
            String sql = "SELECT * FROM user";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String nama = rs.getString("nama_customer");
                String alamat = rs.getString("alamat");
                String nohp = rs.getString("no_hp");
                String tbData[] = {nama, alamat, nohp};
                DefaultTableModel tbl = (DefaultTableModel) jTable2.getModel();
                tbl.addRow(tbData);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
    // --- ORDER ---
    private void tampilOrder(){
        DefaultTableModel tbl = (DefaultTableModel) tableOrder.getModel();
        int jumRow = tbl.getRowCount();
        for(int i=0; i<jumRow; i++){
            tbl.removeRow(0);
        }
        String keyword = searchField.getText();
        try{
            String sql = "SELECT * FROM cart WHERE no_hp LIKE " + "'%" + keyword + "'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                int jumlah = 0;
                String nama = rs.getString("nama_cust");
                String nohp = rs.getString("no_hp");
                String produk = rs.getString("nama_produk");
                String harga = rs.getString("harga");
                String tbData[] = {nama, nohp, produk, harga};
                tbl.addRow(tbData);
                
                for(int i=0;i<tbl.getRowCount();i++){
                    String d = tableOrder.getValueAt(i, 3).toString();
                    jumlah += Integer.parseInt(d);
                }
                totalHarga.setText("Total Harga : Rp" + jumlah);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
    public void nonAktif(){
        naLabel.setText(null);
        jaLabel.setText(null);
        uaLabel.setText(null);
        gaLabel.setText(null);
        haLabel.setText(null);
        nkLabel.setText(null);
        jkLabel.setText(null);
        ukLabel.setText(null);
        gkLabel.setText(null);
        hkLabel.setText(null);
        nacLabel.setText(null);
        ketLabel.setText(null);
        jlhLabel.setText(null);
        hacLabel.setText(null);
    }
    public void nonAktifFK(){
        namaField1.setEnabled(false);
        jantanRB1.setEnabled(false);
        betinaRB1.setEnabled(false);
        umurField1.setEnabled(false);
        rasField1.setEnabled(false);
        feeField1.setEnabled(false);
    }
    public void nonAktifFA(){
        namaField.setEnabled(false);
        jantanRB.setEnabled(false);
        betinaRB.setEnabled(false);
        umurField.setEnabled(false);
        rasField.setEnabled(false);
        feeField.setEnabled(false);
    }
    public void nonAktifFACC(){
        namaField2.setEnabled(false);
        ketTxtArea.setEnabled(false);
        jlhField.setEnabled(false);
        feeField2.setEnabled(false);
    }
    public void AktifFK(){
        namaField1.setEnabled(true);
        jantanRB1.setEnabled(true);
        betinaRB1.setEnabled(true);
        umurField1.setEnabled(true);
        rasField1.setEnabled(true);
        feeField1.setEnabled(true);
    }
    public void AktifFA(){
        namaField.setEnabled(true);
        jantanRB.setEnabled(true);
        betinaRB.setEnabled(true);
        umurField.setEnabled(true);
        rasField.setEnabled(true);
        feeField.setEnabled(true);
    }
    public void AktifFACC(){
        namaField2.setEnabled(true);
        ketTxtArea.setEnabled(true);
        jlhField.setEnabled(true);
        feeField2.setEnabled(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogForm = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        anjingPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jantanRB = new javax.swing.JRadioButton();
        betinaRB = new javax.swing.JRadioButton();
        namaField = new javax.swing.JTextField();
        umurField = new javax.swing.JTextField();
        rasField = new javax.swing.JTextField();
        feeField = new javax.swing.JTextField();
        saveAnjingButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        kucingPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jantanRB1 = new javax.swing.JRadioButton();
        betinaRB1 = new javax.swing.JRadioButton();
        namaField1 = new javax.swing.JTextField();
        umurField1 = new javax.swing.JTextField();
        rasField1 = new javax.swing.JTextField();
        feeField1 = new javax.swing.JTextField();
        saveKucingButton = new javax.swing.JButton();
        idField1 = new javax.swing.JTextField();
        aksesorisPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        namaField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ketTxtArea = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jlhField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        feeField2 = new javax.swing.JTextField();
        saveAccButton = new javax.swing.JButton();
        idField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        backForm = new javax.swing.JButton();
        dialogProduk = new javax.swing.JDialog();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        anjingDel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        delButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        naLabel = new javax.swing.JLabel();
        jaLabel = new javax.swing.JLabel();
        uaLabel = new javax.swing.JLabel();
        gaLabel = new javax.swing.JLabel();
        haLabel = new javax.swing.JLabel();
        EditButton1 = new javax.swing.JButton();
        addBtn1 = new javax.swing.JButton();
        kucingDel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        delButton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nkLabel = new javax.swing.JLabel();
        jkLabel = new javax.swing.JLabel();
        ukLabel = new javax.swing.JLabel();
        gkLabel = new javax.swing.JLabel();
        hkLabel = new javax.swing.JLabel();
        EditButton2 = new javax.swing.JButton();
        addBtn2 = new javax.swing.JButton();
        accDel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        delButton2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        nacLabel = new javax.swing.JLabel();
        ketLabel = new javax.swing.JLabel();
        jlhLabel = new javax.swing.JLabel();
        hacLabel = new javax.swing.JLabel();
        EditButton3 = new javax.swing.JButton();
        addBtn3 = new javax.swing.JButton();
        backProd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dialogDelCon = new javax.swing.JDialog();
        btnOK = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        labelDelete = new javax.swing.JLabel();
        dialogSOR = new javax.swing.JDialog();
        doneSOR = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        cancelSOR = new javax.swing.JButton();
        backSOR = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchSOR = new javax.swing.JButton();
        totalHarga = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        dialogVMB = new javax.swing.JDialog();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        backVMB = new javax.swing.JButton();
        bg1 = new javax.swing.ButtonGroup();
        viewButton = new javax.swing.JButton();
        vmButton = new javax.swing.JButton();
        outButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();

        dialogForm.setTitle("Form Produk");
        dialogForm.setMinimumSize(new java.awt.Dimension(419, 526));
        dialogForm.setSize(new java.awt.Dimension(399, 467));

        jLabel13.setText("DATA ANJING");

        jLabel3.setText("Nama");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Umur");

        jLabel6.setText("Ras");

        jLabel8.setText("Fee");

        bg1.add(jantanRB);
        jantanRB.setText("Jantan");

        bg1.add(betinaRB);
        betinaRB.setText("Betina");

        saveAnjingButton.setText("Simpan");
        saveAnjingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAnjingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout anjingPanelLayout = new javax.swing.GroupLayout(anjingPanel);
        anjingPanel.setLayout(anjingPanelLayout);
        anjingPanelLayout.setHorizontalGroup(
            anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anjingPanelLayout.createSequentialGroup()
                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anjingPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveAnjingButton))
                    .addGroup(anjingPanelLayout.createSequentialGroup()
                        .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(anjingPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(38, 38, 38)
                                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(anjingPanelLayout.createSequentialGroup()
                                        .addComponent(jantanRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(betinaRB))
                                    .addComponent(namaField)
                                    .addComponent(umurField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rasField)
                                    .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(anjingPanelLayout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel13)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(anjingPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        anjingPanelLayout.setVerticalGroup(
            anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anjingPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jantanRB)
                    .addComponent(betinaRB))
                .addGap(18, 18, 18)
                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(umurField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(anjingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(saveAnjingButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Anjing", anjingPanel);

        jLabel14.setText("DATA KUCING");

        jLabel7.setText("Nama");

        jLabel9.setText("Jenis Kelamin");

        jLabel10.setText("Umur");

        jLabel11.setText("Ras");

        jLabel12.setText("Fee");

        bg1.add(jantanRB1);
        jantanRB1.setText("Jantan");

        bg1.add(betinaRB1);
        betinaRB1.setText("Betina");

        saveKucingButton.setText("Simpan");
        saveKucingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveKucingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kucingPanelLayout = new javax.swing.GroupLayout(kucingPanel);
        kucingPanel.setLayout(kucingPanelLayout);
        kucingPanelLayout.setHorizontalGroup(
            kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kucingPanelLayout.createSequentialGroup()
                .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kucingPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveKucingButton))
                    .addGroup(kucingPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(38, 38, 38)
                        .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(kucingPanelLayout.createSequentialGroup()
                                    .addComponent(jantanRB1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(betinaRB1))
                                .addComponent(namaField1)
                                .addComponent(umurField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rasField1)
                                .addComponent(feeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(kucingPanelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kucingPanelLayout.setVerticalGroup(
            kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kucingPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(namaField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jantanRB1)
                    .addComponent(betinaRB1))
                .addGap(18, 18, 18)
                .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(umurField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rasField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kucingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(feeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(idField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(saveKucingButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Kucing", kucingPanel);

        jLabel15.setText("Nama Barang");

        jLabel16.setText("Deskripsi");

        ketTxtArea.setColumns(20);
        ketTxtArea.setRows(5);
        jScrollPane1.setViewportView(ketTxtArea);

        jLabel17.setText("Jumlah ");

        jLabel18.setText("Harga");

        saveAccButton.setText("Simpan");
        saveAccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAccButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aksesorisPanelLayout = new javax.swing.GroupLayout(aksesorisPanel);
        aksesorisPanel.setLayout(aksesorisPanelLayout);
        aksesorisPanelLayout.setHorizontalGroup(
            aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aksesorisPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aksesorisPanelLayout.createSequentialGroup()
                        .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18)
                    .addGroup(aksesorisPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(45, 45, 45)
                        .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(feeField2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlhField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveAccButton)
                            .addComponent(idField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        aksesorisPanelLayout.setVerticalGroup(
            aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aksesorisPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(namaField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlhField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(aksesorisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(feeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(saveAccButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Aksesoris", aksesorisPanel);

        jLabel19.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
        jLabel19.setText("FORM PRODUK");

        backForm.setText("Kembali");
        backForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogFormLayout = new javax.swing.GroupLayout(dialogForm.getContentPane());
        dialogForm.getContentPane().setLayout(dialogFormLayout);
        dialogFormLayout.setHorizontalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backForm)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel19)))
                .addGap(23, 23, 23))
        );
        dialogFormLayout.setVerticalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(backForm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogProduk.setTitle("View Produk");
        dialogProduk.setSize(new java.awt.Dimension(598, 520));

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList3);

        delButton1.setText("Delete");
        delButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButton1ActionPerformed(evt);
            }
        });

        jLabel25.setText("Jenis");

        jLabel26.setText("Nama");

        jLabel27.setText("Umur (th)");

        jLabel28.setText("Gender");

        jLabel29.setText("Harga (Rp)");

        naLabel.setText("jLabel25");

        jaLabel.setText("jLabel26");

        uaLabel.setText("jLabel27");

        gaLabel.setText("jLabel28");

        haLabel.setText("jLabel29");

        EditButton1.setText("Edit");
        EditButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton1ActionPerformed(evt);
            }
        });

        addBtn1.setText("Add");
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout anjingDelLayout = new javax.swing.GroupLayout(anjingDel);
        anjingDel.setLayout(anjingDelLayout);
        anjingDelLayout.setHorizontalGroup(
            anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anjingDelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anjingDelLayout.createSequentialGroup()
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(anjingDelLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(haLabel))
                            .addGroup(anjingDelLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gaLabel))
                            .addGroup(anjingDelLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uaLabel))
                            .addGroup(anjingDelLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jaLabel))
                            .addGroup(anjingDelLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(naLabel)))
                        .addGap(73, 73, 73))
                    .addGroup(anjingDelLayout.createSequentialGroup()
                        .addComponent(addBtn1)
                        .addGap(18, 18, 18)
                        .addComponent(EditButton1)
                        .addGap(18, 18, 18)
                        .addComponent(delButton1)
                        .addContainerGap(65, Short.MAX_VALUE))))
        );
        anjingDelLayout.setVerticalGroup(
            anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anjingDelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(anjingDelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(naLabel))
                        .addGap(18, 18, 18)
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(uaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(gaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(haLabel))
                        .addGap(35, 35, 35)
                        .addGroup(anjingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn1)
                            .addComponent(EditButton1)
                            .addComponent(delButton1))
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Anjing", anjingDel);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        delButton.setText("Delete");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        jLabel20.setText("Jenis");

        jLabel21.setText("Nama");

        jLabel22.setText("Umur (th)");

        jLabel23.setText("Gender");

        jLabel24.setText("Harga (Rp)");

        nkLabel.setText("jLabel25");

        jkLabel.setText("jLabel26");

        ukLabel.setText("jLabel27");

        gkLabel.setText("jLabel28");

        hkLabel.setText("jLabel29");

        EditButton2.setText("Edit");
        EditButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton2ActionPerformed(evt);
            }
        });

        addBtn2.setText("Add");
        addBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kucingDelLayout = new javax.swing.GroupLayout(kucingDel);
        kucingDel.setLayout(kucingDelLayout);
        kucingDelLayout.setHorizontalGroup(
            kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kucingDelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kucingDelLayout.createSequentialGroup()
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kucingDelLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hkLabel))
                            .addGroup(kucingDelLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addComponent(gkLabel))
                            .addGroup(kucingDelLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ukLabel))
                            .addGroup(kucingDelLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jkLabel))
                            .addGroup(kucingDelLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nkLabel)))
                        .addGap(73, 73, 73))
                    .addGroup(kucingDelLayout.createSequentialGroup()
                        .addComponent(addBtn2)
                        .addGap(18, 18, 18)
                        .addComponent(EditButton2)
                        .addGap(18, 18, 18)
                        .addComponent(delButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kucingDelLayout.setVerticalGroup(
            kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kucingDelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kucingDelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(kucingDelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(nkLabel))
                        .addGap(18, 18, 18)
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jkLabel))
                        .addGap(18, 18, 18)
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(ukLabel))
                        .addGap(18, 18, 18)
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(gkLabel))
                        .addGap(18, 18, 18)
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(hkLabel))
                        .addGap(35, 35, 35)
                        .addGroup(kucingDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditButton2)
                            .addComponent(addBtn2)
                            .addComponent(delButton))
                        .addContainerGap(88, Short.MAX_VALUE))))
        );

        jTabbedPane2.addTab("Kucing", kucingDel);

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jList4);

        delButton2.setText("Delete");
        delButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButton2ActionPerformed(evt);
            }
        });

        jLabel30.setText("Ket");

        jLabel31.setText("Nama");

        jLabel32.setText("Jumlah");

        jLabel34.setText("Harga (Rp)");

        nacLabel.setText("jLabel25");

        ketLabel.setText("jLabel26");

        jlhLabel.setText("jLabel27");

        hacLabel.setText("jLabel29");

        EditButton3.setText("Edit");
        EditButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton3ActionPerformed(evt);
            }
        });

        addBtn3.setText("Add");
        addBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accDelLayout = new javax.swing.GroupLayout(accDel);
        accDel.setLayout(accDelLayout);
        accDelLayout.setHorizontalGroup(
            accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accDelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accDelLayout.createSequentialGroup()
                        .addComponent(addBtn3)
                        .addGap(18, 18, 18)
                        .addComponent(EditButton3)
                        .addGap(18, 18, 18)
                        .addComponent(delButton2)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(accDelLayout.createSequentialGroup()
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hacLabel)
                            .addComponent(jlhLabel)
                            .addComponent(ketLabel)
                            .addComponent(nacLabel))
                        .addGap(34, 34, 34))))
        );
        accDelLayout.setVerticalGroup(
            accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accDelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(accDelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(nacLabel))
                        .addGap(18, 18, 18)
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(ketLabel))
                        .addGap(18, 18, 18)
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jlhLabel))
                        .addGap(18, 18, 18)
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(hacLabel))
                        .addGap(35, 35, 35)
                        .addGroup(accDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditButton3)
                            .addComponent(addBtn3)
                            .addComponent(delButton2))
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Aksesoris", accDel);

        backProd.setText("Kembali");
        backProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backProdActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
        jLabel1.setText("PRODUK");

        javax.swing.GroupLayout dialogProdukLayout = new javax.swing.GroupLayout(dialogProduk.getContentPane());
        dialogProduk.getContentPane().setLayout(dialogProdukLayout);
        dialogProdukLayout.setHorizontalGroup(
            dialogProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogProdukLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(backProd)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dialogProdukLayout.createSequentialGroup()
                        .addGroup(dialogProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane2)
                            .addGroup(dialogProdukLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        dialogProdukLayout.setVerticalGroup(
            dialogProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogProdukLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backProd)
                .addGap(16, 16, 16))
        );

        dialogDelCon.setTitle("Delete Konfrimasi");
        dialogDelCon.setSize(new java.awt.Dimension(409, 180));

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        labelDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDelete.setText("jLabel7");

        javax.swing.GroupLayout dialogDelConLayout = new javax.swing.GroupLayout(dialogDelCon.getContentPane());
        dialogDelCon.getContentPane().setLayout(dialogDelConLayout);
        dialogDelConLayout.setHorizontalGroup(
            dialogDelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDelConLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogDelConLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnBatal)
                .addGap(80, 80, 80))
        );
        dialogDelConLayout.setVerticalGroup(
            dialogDelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogDelConLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelDelete)
                .addGap(37, 37, 37)
                .addGroup(dialogDelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnBatal))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        dialogSOR.setTitle("Search Order");
        dialogSOR.setSize(new java.awt.Dimension(677, 468));

        doneSOR.setText("Selesai");
        doneSOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneSORActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
        jLabel35.setText("SEARCH ORDER");

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama ", "No Handphone", "Item", "Harga"
            }
        ));
        jScrollPane6.setViewportView(tableOrder);

        cancelSOR.setText("Cancel");
        cancelSOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSORActionPerformed(evt);
            }
        });

        backSOR.setText("Kembali");
        backSOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSORActionPerformed(evt);
            }
        });

        searchSOR.setText("Cari");
        searchSOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSORActionPerformed(evt);
            }
        });

        totalHarga.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalHarga.setText("TOTAL HARGA");

        refreshBtn.setText("View All");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogSORLayout = new javax.swing.GroupLayout(dialogSOR.getContentPane());
        dialogSOR.getContentPane().setLayout(dialogSORLayout);
        dialogSORLayout.setHorizontalGroup(
            dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogSORLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSORLayout.createSequentialGroup()
                        .addComponent(cancelSOR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doneSOR))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSORLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchSOR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogSORLayout.createSequentialGroup()
                        .addGroup(dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogSORLayout.createSequentialGroup()
                                .addComponent(backSOR)
                                .addGap(149, 149, 149)
                                .addComponent(jLabel35))
                            .addComponent(totalHarga))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogSORLayout.setVerticalGroup(
            dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSORLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(backSOR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchSOR)
                    .addComponent(refreshBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalHarga)
                .addGap(18, 18, 18)
                .addGroup(dialogSORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneSOR)
                    .addComponent(cancelSOR))
                .addGap(69, 69, 69))
        );

        dialogVMB.setTitle("View Member");
        dialogVMB.setSize(new java.awt.Dimension(639, 350));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Alamat", "No Handphone"
            }
        ));
        jScrollPane9.setViewportView(jTable2);

        jLabel41.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
        jLabel41.setText("VIEW MEMBER");

        backVMB.setText("Kembali");
        backVMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backVMBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogVMBLayout = new javax.swing.GroupLayout(dialogVMB.getContentPane());
        dialogVMB.getContentPane().setLayout(dialogVMBLayout);
        dialogVMBLayout.setHorizontalGroup(
            dialogVMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogVMBLayout.createSequentialGroup()
                .addGroup(dialogVMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogVMBLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                    .addGroup(dialogVMBLayout.createSequentialGroup()
                        .addGroup(dialogVMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogVMBLayout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel41))
                            .addGroup(dialogVMBLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backVMB)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogVMBLayout.setVerticalGroup(
            dialogVMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogVMBLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backVMB)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Menu");

        viewButton.setText("View Produk");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        vmButton.setText("View Member");
        vmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmButtonActionPerformed(evt);
            }
        });

        outButton.setText("Log Out");
        outButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lithos Pro Regular", 0, 36)); // NOI18N
        jLabel2.setText("admin menu");

        searchButton.setText("Search Order");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)))
                .addGap(0, 80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(viewButton)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addComponent(vmButton)
                .addGap(18, 18, 18)
                .addComponent(outButton)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(361, 387));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        dialogProduk.show();
        dialogProduk.setLocationRelativeTo(null);
        nonAktifBtnAnj();
        nonAktifBtnKcn();
        nonAktifBtnAcc();
    }//GEN-LAST:event_viewButtonActionPerformed

   /*------------------------------------------------------------------- SIMPAN ACC -------------------------------------------------------------------*/
    private void saveAccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAccButtonActionPerformed
        // ----- UPDATE ACC ----- 
        if("Update Produk".equals(status)){
            if(namaField2.getText().isEmpty() || ketTxtArea.getText().isEmpty() || jlhField.getText().isEmpty() || feeField2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
            }else{
                try{
                    String sql = "UPDATE aksesoris SET "
                        + "aksesoris = '"+namaField2.getText()+"',"
                        + "ket = '"+ketTxtArea.getText()+"',"
                        + "qnty = '"+jlhField.getText()+"',"
                        + "harga = '"+feeField2.getText()+"'WHERE "
                        + "aksesoris_id = '"+idField2.getText()+"'";
                    conn.query(sql);
                    JOptionPane.showMessageDialog(null, getNamaAcc() + " berhasil diubah");
                    tampilAcc();
                    dialogForm.hide();
                }catch(Exception e){
                    System.err.print(e);
                }
            }
        }else{
            // ----- ADD ACC ----- 
            if(namaField2.getText().isEmpty() || ketTxtArea.getText().isEmpty() || jlhField.getText().isEmpty() || feeField2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
            }else{
                try{
                    String sql="INSERT INTO aksesoris (aksesoris, ket, qnty, harga)"
                        + "VALUES ("
                        + "'" + getNamaAcc() + "',"
                        + "'" + getDescAcc() + "',"
                        + "'" + getJlhAcc() + "',"
                        + "'" + getHargaAcc() + "'"
                        + ");";
                    conn.query(sql);
                    JOptionPane.showMessageDialog(null, getNamaAcc() + " berhasil disimpan");
                    tampilAcc();
                    dialogForm.hide();
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                AktifFA();
                AktifFK();
            }   
        }
    }//GEN-LAST:event_saveAccButtonActionPerformed
    
    /*------------------------------------------------------------------- SIMPAN KUCING -------------------------------------------------------------------*/
    private void saveKucingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveKucingButtonActionPerformed
        // ----- UPDATE KUCING ----- 
        if("Update Produk".equals(status)){
          if(namaField1.getText().isEmpty() || umurField1.getText().isEmpty() || rasField1.getText().isEmpty() || feeField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
          }else{
              try{
                  String sql = "UPDATE kucing SET "
                        + "jenis_kucing = '"+rasField1.getText()+"',"
                        + "nama_kucing = '"+namaField1.getText()+"',"
                        + "umur_kucing = '"+umurField1.getText()+"',"
                        + "gender = '"+getRadiobtnK()+"',"
                        + "harga_kucing = '"+feeField1.getText()+"'WHERE "
                        + "id_kucing = '"+idField1.getText()+"'";
                    conn.query(sql);
                    JOptionPane.showMessageDialog(null, getNamaKucing() + " berhasil diubah");
                    tampilKcn();
                    dialogForm.hide();
              }catch(Exception e){
                    System.err.println(e.getMessage());
                }
          }
        }else{
            // ----- ADD KUCING ----- 
            if(namaField1.getText().isEmpty() || umurField1.getText().isEmpty() || rasField1.getText().isEmpty() || feeField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
            }else{
                try{
                    String sql="INSERT INTO kucing (nama_kucing, gender, umur_kucing, jenis_kucing, harga_kucing)"
                        + "VALUES ("
                        + "'" + getNamaKucing() + "',"
                        + "'" + getRadiobtnK() + "',"
                        + "'" + getUmurKucing() + "',"
                        + "'" + getRasKucing() + "',"
                        + "'" + getFeeKucing() + "'"
                        + ");";
                    conn.query(sql);
                    JOptionPane.showMessageDialog(null, getNamaKucing() + " berhasil disimpan");
                    tampilKcn();
                    clearKcn();
                    dialogForm.hide();
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                AktifFA();
                AktifFACC();
            }   
        }
    }//GEN-LAST:event_saveKucingButtonActionPerformed
    
    /*------------------------------------------------------------------- OK DEL BTN -------------------------------------------------------------------*/
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if("Delete Kucing".equals(status)){
            try{
                String sql = "DELETE FROM kucing WHERE"+" nama_kucing = '"+jList2.getSelectedValue()+"'";
                conn.query(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                dialogDelCon.hide();
                tampilKcn();
            }catch(Exception e){
                System.err.print(e.getMessage());
            }
        } else if ("Delete Anjing".equals(status)){
            try{
                String sql = "DELETE FROM anjing WHERE"+" nama_anjing = '"+jList3.getSelectedValue()+"'";
                conn.query(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                dialogDelCon.hide();
                tampilAnj();
            }catch(Exception e){
                System.err.print(e.getMessage());
            }
        } else {
            try{
                String sql = "DELETE FROM aksesoris WHERE"+" aksesoris = '"+jList4.getSelectedValue()+"'";
                conn.query(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                dialogDelCon.hide();
                tampilAcc();
            }catch(Exception e){
                System.err.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dialogDelCon.hide();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        dialogSOR.show();
        dialogSOR.setLocationRelativeTo(null);
        totalHarga.setText(null);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void vmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vmButtonActionPerformed
        dialogVMB.show();
        dialogVMB.setLocationRelativeTo(null);
    }//GEN-LAST:event_vmButtonActionPerformed

    /*------------------------------------------------------------------- SIMPAN ANJING -------------------------------------------------------------------*/
    private void saveAnjingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAnjingButtonActionPerformed
        // ----- UPDATE ANJING ----- 
        if("Update Produk".equals(status)){
          if(namaField.getText().isEmpty() || umurField.getText().isEmpty() || rasField.getText().isEmpty() || feeField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
          }else{
              try{
                  String sql = "UPDATE anjing SET "
                        + "jenis_anjing = '"+rasField.getText()+"',"
                        + "nama_anjing = '"+namaField.getText()+"',"
                        + "umur_anjing = '"+umurField.getText()+"',"
                        + "gender = '"+getRadiobtnA()+"',"
                        + "harga_anjing = '"+feeField.getText()+"'WHERE "
                        + "id_anjing = '"+idField.getText()+"'";
                    conn.query(sql);
                    JOptionPane.showMessageDialog(null, getNamaAnjing() + " berhasil diubah");
                    tampilAnj();
                    dialogForm.hide();
              }catch(Exception e){
                    System.err.println(e.getMessage());
              }
            AktifFK();
            AktifFACC();
          }
        }else{
            // ----- ADD ANJING ----- 
            if(namaField.getText().isEmpty() || umurField.getText().isEmpty() || rasField.getText().isEmpty() || feeField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
            }else{
                try{
                    String sql="INSERT INTO anjing (nama_anjing, gender, umur_anjing, jenis_anjing, harga_anjing)"
                        + "VALUES ("
                        + "'" + getNamaAnjing() + "',"
                        + "'" + getRadiobtnA() + "',"
                        + "'" + getUmurAnjing() + "',"
                        + "'" + getRasAnjing() + "',"
                        + "'" + getFeeAnjing() + "'"
                        + ");";
                    conn.query(sql);
                    JOptionPane.showMessageDialog(null, getNamaAnjing() + " berhasil disimpan");
                    tampilAnj();
                    clearAnj();
                    dialogForm.hide();
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_saveAnjingButtonActionPerformed
    
    /*------------------------------------------------------------------- LIST ANJING -------------------------------------------------------------------*/
    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            detailAnj(jList3.getSelectedValue());
            aktifBtnAnj();
        }else{
            nonAktifBtnAnj();
        }
    }//GEN-LAST:event_jList3MouseClicked

    /*------------------------------------------------------------------- LIST ACC -------------------------------------------------------------------*/
    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            detailAcc(jList4.getSelectedValue());
            aktifBtnAcc();
        }else{
            nonAktifBtnAcc();
        }
    }//GEN-LAST:event_jList4MouseClicked

    /*------------------------------------------------------------------- LIST KUCING -------------------------------------------------------------------*/
    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            detailKcn(jList2.getSelectedValue());
            aktifBtnKcn();
        }else{
            nonAktifBtnKcn();
        }
    }//GEN-LAST:event_jList2MouseClicked

    /*------------------------------------------------------------------- BTN DEL KUCING -------------------------------------------------------------------*/
    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        nonAktifBtnKcn();
        nkLabel.setText(null);
        jkLabel.setText(null);
        ukLabel.setText(null);
        gkLabel.setText(null);
        hkLabel.setText(null);
        dialogDelCon.show();
        dialogDelCon.setLocationRelativeTo(null);
        labelDelete.setText("Hapus " + jList2.getSelectedValue() + "?");
        status = "Delete Kucing";
    }//GEN-LAST:event_delButtonActionPerformed

    /*------------------------------------------------------------------- BTN DEL ANJING -------------------------------------------------------------------*/
    private void delButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButton1ActionPerformed
        nonAktifBtnAnj();
        naLabel.setText(null);
        jaLabel.setText(null);
        uaLabel.setText(null);
        gaLabel.setText(null);
        haLabel.setText(null);
        dialogDelCon.show();
        dialogDelCon.setLocationRelativeTo(null);
        labelDelete.setText("Hapus " + jList3.getSelectedValue() + "?");
        status = "Delete Anjing";
    }//GEN-LAST:event_delButton1ActionPerformed
    
    /*------------------------------------------------------------------- BTN DEL ACC -------------------------------------------------------------------*/
    private void delButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButton2ActionPerformed
        nonAktifBtnAcc();
        nacLabel.setText(null);
        ketLabel.setText(null);
        jlhLabel.setText(null);
        hacLabel.setText(null);
        dialogDelCon.show();
        dialogDelCon.setLocationRelativeTo(null);
        labelDelete.setText("Hapus " + jList4.getSelectedValue() + "?");
    }//GEN-LAST:event_delButton2ActionPerformed

    /*------------------------------------------------------------------- EDIT ANJING -------------------------------------------------------------------*/
    private void EditButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton1ActionPerformed
        dialogForm.show();
        dialogForm.setLocationRelativeTo(null);
        nonAktifFK();
        nonAktifFACC();
        nonAktifBtnAnj();
        try{
            String sql = "SELECT * FROM anjing WHERE nama_anjing = '"+
                (jList3.getSelectedValue()+"'");
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String jenis = rs.getString(2);
                String nama = rs.getString(3);
                String umur = rs.getString(4);
                String gndr = rs.getString(5);
                String fee = rs.getString(6);
                
                idField.setText(id);
                namaField.setText(nama);
                //radio button
                if("Jantan".equals(gndr))jantanRB.setSelected(true);
                if("Betina".equals(gndr))betinaRB.setSelected(true);
                umurField.setText(umur);
                rasField.setText(jenis);
                feeField.setText(fee);
            }
            status = "Update Produk";
        }catch(SQLException e){
            System.err.print(e);
        }
    }//GEN-LAST:event_EditButton1ActionPerformed
    
    /*------------------------------------------------------------------- EDIT KUCING -------------------------------------------------------------------*/
    private void EditButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton2ActionPerformed
        dialogForm.show();
        dialogForm.setLocationRelativeTo(null);
        nonAktifFA();
        nonAktifFACC();
        nonAktifBtnKcn();
        try{
            String sql = "SELECT * FROM kucing WHERE nama_kucing = '"+
                    (jList2.getSelectedValue())+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String jenis = rs.getString(2);
                String nama = rs.getString(3);
                String umur = rs.getString(4);
                String gndr = rs.getString(5);
                String fee = rs.getString(6);
                
                idField1.setText(id);
                namaField1.setText(nama);
                //radio button
                if("Jantan".equals(gndr))jantanRB1.setSelected(true);
                if("Betina".equals(gndr))betinaRB1.setSelected(true);
                umurField1.setText(umur);
                rasField1.setText(jenis);
                feeField1.setText(fee);
            }
            status = "Update Produk";
        }catch(SQLException e){
            System.err.print(e);
        }
    }//GEN-LAST:event_EditButton2ActionPerformed

    private void backFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFormActionPerformed
        dialogForm.hide();
        AktifFA();
        AktifFK();
        AktifFACC();
    }//GEN-LAST:event_backFormActionPerformed

    /*------------------------------------------------------------------- EDIT ACC -------------------------------------------------------------------*/
    private void EditButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton3ActionPerformed
        dialogForm.show();
        dialogForm.setLocationRelativeTo(null);
        nonAktifFK();
        nonAktifFA();
        nonAktifBtnAcc();
        try{
            String sql = "SELECT * FROM aksesoris WHERE aksesoris = '"
                    +(jList4.getSelectedValue())+"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String nama = rs.getString(2);
                String ket = rs.getString(3);
                String qnt = rs.getString(4);
                String fee = rs.getString(5);
                
                idField2.setText(id);
                namaField2.setText(nama);
                ketTxtArea.setText(ket);
                jlhField.setText(qnt);
                feeField2.setText(fee);
            }
            status = "Update Produk";
        }catch(SQLException e){
            System.err.print(e);
        }
    }//GEN-LAST:event_EditButton3ActionPerformed

    /*------------------------------------------------------------------- ADD BTN -------------------------------------------------------------------*/
    // --- ANJING ----
    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed
        dialogForm.show();
        dialogForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_addBtn1ActionPerformed
    // --- KUCING ---
    private void addBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn2ActionPerformed
        dialogForm.show();
        dialogForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_addBtn2ActionPerformed
    //--- ACC ---
    private void addBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn3ActionPerformed
        dialogForm.show();
        dialogForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_addBtn3ActionPerformed

    private void backProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backProdActionPerformed
        dialogProduk.hide();
    }//GEN-LAST:event_backProdActionPerformed

    private void backSORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSORActionPerformed
        dialogSOR.hide();
    }//GEN-LAST:event_backSORActionPerformed

    private void backVMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backVMBActionPerformed
        dialogVMB.hide();
    }//GEN-LAST:event_backVMBActionPerformed

    private void outButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outButtonActionPerformed
        this.dispose();
        new Login().show();
    }//GEN-LAST:event_outButtonActionPerformed

    private void searchSORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSORActionPerformed
        if(searchField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "isi dengan no hp yang dicari");
        }else{
            tampilOrder();
        }
    }//GEN-LAST:event_searchSORActionPerformed

    private void doneSORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneSORActionPerformed
       String key = searchField.getText();

       if(key.isEmpty()){
           JOptionPane.showMessageDialog(null, "Isi No Handphone untuk menyelesaikan Order", "KESALAHAN", JOptionPane.WARNING_MESSAGE);
       } else {
           try{
               String sql = "DELETE FROM cart WHERE no_hp = '"+key+"'";
               conn.query(sql);
               JOptionPane.showMessageDialog(null, "pesanan berhasil diselesaikan");
               tampilOrder();
               searchField.setText("");
               totalHarga.setText("");
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
       }
    }//GEN-LAST:event_doneSORActionPerformed

    private void cancelSORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSORActionPerformed
       String key = searchField.getText();
       if(key.isEmpty()){
           JOptionPane.showMessageDialog(this, "Isi No Handphone untuk membatalkan Order", "KESALAHAN", JOptionPane.WARNING_MESSAGE);
       } else {
           try{
               String sql = "DELETE FROM cart WHERE no_hp = '"+key+"'";
               conn.query(sql);
               JOptionPane.showMessageDialog(this, "pesanan berhasil dibatalkan");
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
           tampilOrder();
       }
    }//GEN-LAST:event_cancelSORActionPerformed

    //refresh data customer
    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        tampilOrder();
        totalHarga.setText("");
    }//GEN-LAST:event_refreshBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewAdmin_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton1;
    private javax.swing.JButton EditButton2;
    private javax.swing.JButton EditButton3;
    private javax.swing.JPanel accDel;
    private javax.swing.JButton addBtn1;
    private javax.swing.JButton addBtn2;
    private javax.swing.JButton addBtn3;
    private javax.swing.JPanel aksesorisPanel;
    private javax.swing.JPanel anjingDel;
    private javax.swing.JPanel anjingPanel;
    private javax.swing.JButton backForm;
    private javax.swing.JButton backProd;
    private javax.swing.JButton backSOR;
    private javax.swing.JButton backVMB;
    private javax.swing.JRadioButton betinaRB;
    private javax.swing.JRadioButton betinaRB1;
    private javax.swing.ButtonGroup bg1;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton cancelSOR;
    private javax.swing.JButton delButton;
    private javax.swing.JButton delButton1;
    private javax.swing.JButton delButton2;
    private javax.swing.JDialog dialogDelCon;
    private javax.swing.JDialog dialogForm;
    private javax.swing.JDialog dialogProduk;
    private javax.swing.JDialog dialogSOR;
    private javax.swing.JDialog dialogVMB;
    private javax.swing.JButton doneSOR;
    private javax.swing.JTextField feeField;
    private javax.swing.JTextField feeField1;
    private javax.swing.JTextField feeField2;
    private javax.swing.JLabel gaLabel;
    private javax.swing.JLabel gkLabel;
    private javax.swing.JLabel haLabel;
    private javax.swing.JLabel hacLabel;
    private javax.swing.JLabel hkLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField idField1;
    private javax.swing.JTextField idField2;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jaLabel;
    private javax.swing.JRadioButton jantanRB;
    private javax.swing.JRadioButton jantanRB1;
    private javax.swing.JLabel jkLabel;
    private javax.swing.JTextField jlhField;
    private javax.swing.JLabel jlhLabel;
    private javax.swing.JLabel ketLabel;
    private javax.swing.JTextArea ketTxtArea;
    private javax.swing.JPanel kucingDel;
    private javax.swing.JPanel kucingPanel;
    private javax.swing.JLabel labelDelete;
    private javax.swing.JLabel naLabel;
    private javax.swing.JLabel nacLabel;
    private javax.swing.JTextField namaField;
    private javax.swing.JTextField namaField1;
    private javax.swing.JTextField namaField2;
    private javax.swing.JLabel nkLabel;
    private javax.swing.JButton outButton;
    private javax.swing.JTextField rasField;
    private javax.swing.JTextField rasField1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveAccButton;
    private javax.swing.JButton saveAnjingButton;
    private javax.swing.JButton saveKucingButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchSOR;
    private javax.swing.JTable tableOrder;
    private javax.swing.JLabel totalHarga;
    private javax.swing.JLabel uaLabel;
    private javax.swing.JLabel ukLabel;
    private javax.swing.JTextField umurField;
    private javax.swing.JTextField umurField1;
    private javax.swing.JButton viewButton;
    private javax.swing.JButton vmButton;
    // End of variables declaration//GEN-END:variables
}
