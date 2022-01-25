package PetShopClass;

import java.util.*;

public class Customer extends Akun {
    private String nama, alamat, no_hp;
    private ArrayList<Order> L_Order = new ArrayList<Order>();
    private Order orderan = new Order(this);
    
    // Constructor
    public Customer(String nama, String alamat, String no_hp, String user, String pass){
        super(user,pass);
        this.nama = nama; 
        this.no_hp = no_hp;
        this.alamat = alamat;
    }
    
    public Customer(){};
    
    // Setter & Getter
    public void setNama(String nama) {this.nama = nama;}
    public void setAlamat(String alamat) { this.alamat = alamat;}
    public void setNohp(String nohp){this.no_hp = nohp;}
    public void addListOrder(Order order){this.L_Order.add(order);}
    public String getNama() {return this.nama;}
    public String getAlamat() {return this.alamat;}
    public String getNohp() {return this.no_hp;}
    public ArrayList<Order> getListOrder(){return this.L_Order;}
    
    @Override
    public void info(){
        System.out.println("Nama\t : " + getNama());
        System.out.println("Alamat\t : " + getAlamat());
        System.out.println("No HP\t : " + getNohp());
    }
}
