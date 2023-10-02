package Modelo;

public class Cliente {
    int id;
    String dni;
    String dir;
    String nom;
    String est;

    public Cliente() {
    }

    public Cliente(int id, String dni, String dir, String nom, String est) {
        this.id = id;
        this.dni = dni;
        this.dir = dir;
        this.nom = nom;
        this.est = est;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

  

    
    
}
