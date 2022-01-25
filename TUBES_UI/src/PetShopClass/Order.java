package PetShopClass;
import java.util.*;

public class Order {
    private ArrayList<Anjing> L_Anjing = new ArrayList<Anjing>();
    private ArrayList<Kucing> L_Kucing = new ArrayList<Kucing>();
    private ArrayList<Aksesoris> L_Acc = new ArrayList<Aksesoris>();
    private Customer customer;
    private String tgl;
    
    public Order(Customer customer){this.customer = customer;}
    public void addAnjing(Anjing anjing){this.L_Anjing.add(anjing);}
    public void addKucing(Kucing kucing){this.L_Kucing.add(kucing);}
    public void addAcc(Aksesoris acc){this.L_Acc.add(acc);}
    public ArrayList<Anjing> getAnjing(){return this.L_Anjing;}
    public ArrayList<Kucing> getKucing(){return this.L_Kucing;}
    public ArrayList<Aksesoris> getAcc(){return this.L_Acc;}
    
    public double getTotalHarga(){
        int fee_anjing = 0;
        int fee_kucing = 0;
        int price_acc = 0;
        for(Anjing x : L_Anjing){
            fee_anjing += x.getAdpt_fee();
        }
        for(Kucing x : L_Kucing){
            fee_kucing += x.getAdpt_fee();
        }
        for(Aksesoris x : L_Acc){
            price_acc += x.getHarga();
        }
        double total = fee_anjing + fee_kucing + price_acc;
        return total;
    }
}

