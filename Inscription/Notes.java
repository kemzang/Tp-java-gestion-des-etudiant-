package Inscription;

import Examen.Etudiant;

public class Notes {
    
    private Etudiant etudiant;
    private Matieres matiere;
    private double note;

    public Notes(Etudiant etudiant, Matieres matiere, double note) {
        this.etudiant = etudiant;
        this.matiere = matiere;
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Matieres getMatiere() {
        return matiere;
    }

    public double getNote() {
        return note;
    }
}
