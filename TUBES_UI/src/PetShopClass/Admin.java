package PetShopClass;

public class Admin extends Akun{
    private String nama_admin;
    
    // Constructor
    public Admin(String nama_admin, String user, String pass){
        super(user,pass);
        this.nama_admin = nama_admin;
    }
    
    // Setter & Getter
    public void setNama_admin(String nama){this.nama_admin = nama;}
    public String getNama_admin(){return this.nama_admin;}
    
    // Validasi Admin
    public boolean isAdmin(String id, String pass){
        return getUser().equals(id) && getPassword().equals(pass);
    }
    
    @Override
    public void info(){
        System.out.println("Admin\t : " + getNama_admin());
    }
}
