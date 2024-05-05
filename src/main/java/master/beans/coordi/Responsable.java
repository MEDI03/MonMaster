package master.beans.coordi;

public class Responsable {
	private int id_respo ;
	private String email ;
	private String password ;
	private int id_facultes ;

   public int getId_respo() {
        return id_respo;
    }
    public void setId_respo(int id_respo) {
        this.id_respo = id_respo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_facultes() {
        return id_facultes;
    }
    public void setId_facultes(int id_facultes) {
        this.id_facultes = id_facultes;
    }
}
