package Inscription;

public class Matieres {
    
    private String code;
    private String nom;
    private int coeff;
    

    public Matieres(String code, String nom, int coeff) {
        this.code = code;
        this.nom = nom;
        this.coeff = coeff;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getCoeff() {
        return coeff;
    }

    
    
}
