package Examen;

import java.util.ArrayList;
import java.util.List;

import Inscription.Notes;

public class Etudiant {

    private String Matricule;
    private String Nom;
    private String Prenom;
    private int age;
    private double Moyenne;
    private List<Notes> notes;
    
    public Etudiant(String Matricule, String Nom, String Prenom, int age) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.age = age;
        this.Moyenne = 0;
        notes = new ArrayList<>();
    }

    public String getMatricule() {
        return Matricule;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public int getAge() {
        return age; 
    }

    public double getMoyenne() {
        return Moyenne;
    }

    public void setMoyenne(double Moyenne) {
        this.Moyenne = Moyenne;
    }
    
    public List<Notes> getNotes() {
        return notes;
    }

    public double CalculMoyenne() {
        double somme = 0;
        double sommeCoefficients = 0;
        for (Notes note : notes) {
            somme += note.getNote() * note.getMatiere().getCoeff();
            sommeCoefficients += note.getMatiere().getCoeff();
        }
        Moyenne = somme / sommeCoefficients;
        return Moyenne;
    }
}