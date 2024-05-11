package Model;

public class Utilizatori {
    private int idClienti;
    private String username;
    private String password;
    private String role;
    public Utilizatori() {
        // Default constructor
    }
    public Utilizatori(String username, String password, String role) {
        this(-1, username, password, role);
    }
    
    public Utilizatori(int idClienti, String username,String password, String role) {
        this.idClienti = idClienti;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getIdClienti() {
        return idClienti;
    }

    public void setIdClienti(int idClienti) {
        this.idClienti = idClienti;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nume) {
        this.username = nume;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "Clienti{" +
                "id=" + idClienti +
                ", username=" + username  +
                ", password=" + password +
                 ", role=" + role +
                '}';
    }

}