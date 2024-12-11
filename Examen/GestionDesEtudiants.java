package Examen;
import Inscription.Matieres;
import Inscription.Notes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestionDesEtudiants {
    static List<Etudiant> etudiants = new ArrayList<>();
    static List<Matieres> matieres = new ArrayList<>();
    static List<Etudiant> ListeEtudiantsParMoyenne = new ArrayList<>();
    static List<Etudiant> ListeEtudiantsParMoyenneTrie = new ArrayList<>();
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer l'effectif de la classe :");
        int effectif = sc.nextInt();
        System.out.println("\n\n");

        System.out.println("Entrer les étudiants :");
        for (int i = 0; i < effectif; i++) {
            System.out.println("Étudiant " + (i + 1) + " :");

            System.out.print("Matricule : ");
            String matricule = sc.next();

            System.out.print("Nom : ");
            String nom = sc.next();

            System.out.print("Prénom : ");
            String prenom = sc.next();

            System.out.print("Âge : ");
            int age = sc.nextInt();

            // Créer un nouvel objet Etudiant
            Etudiant etudiant = new Etudiant(matricule, nom, prenom, age);
            etudiants.add(etudiant);
            System.out.println("\n\n");

        }

        System.out.println("\n\n");

        System.out.println("Entrer le nombre de matiere :");
            int nbMatieres = sc.nextInt();
            System.out.println("\n");

            System.out.println("Entrer la liste de matiere :");

            for (int j = 0; j < nbMatieres; j++) {
                System.out.print("code de la matiere : ");
                String code = sc.next();

                System.out.print("Nom de la matiere : ");
                String nom = sc.next();

                System.out.print("Coefficient de la matiere : ");
                int coeff = sc.nextInt();

                // Créer un nouvel objet Matieres
                Matieres mat = new Matieres(code, nom, coeff);
                matieres.add(mat);
                System.out.println("\n");
            }

            System.out.println("\n");

            System.out.println("Attribution une note a chaque etudiant pour chaque matiere");

            for (Etudiant etudiant : etudiants) {
                for (Matieres mat : matieres) {
                    System.out.print("Note de " + etudiant.getNom() + " pour " + mat.getNom() + " : ");
                    double note = sc.nextDouble();
                    System.out.println("\n"); // Consommer la nouvelle ligne

                    // Créer un nouvel objet Notes
                    Notes noteEtudiant = new Notes(etudiant, mat, note);
                    etudiant.getNotes().add(noteEtudiant);
                }
                System.out.println("\n");
            }

            System.out.println("\n");

                      

            while (true) {
                
                System.out.println("\t\t\t\t Menu \n");
                System.out.println("1 - afficher les resultat par ordre de merite");
                System.out.println("2 - afficher le premier et le dernier de la classe ");
                System.out.println("3 - afficher la liste des admis (moyenne >= 10 )");
                System.out.println("4 - calculer et afficher la moyenne de la classe ");
                System.out.println("5 - afficher les etudiants ayant une moyenne superieur ou egal a la moyenne de la classe "); 
                System.out.println("6 - Quitter \n");

                
                int choix = sc.nextInt();

                switch (choix) {
                    case 1:

                        for (Etudiant etudiant : etudiants) {
                            double moyenne = etudiant.CalculMoyenne();
                            etudiant.setMoyenne(moyenne);
                            ListeEtudiantsParMoyenne.add(etudiant);
                        }  
                        Collections.sort(ListeEtudiantsParMoyenne, Comparator.comparingDouble(Etudiant::getMoyenne).reversed());
                        for (Etudiant etudiant : ListeEtudiantsParMoyenne) {
                            System.out.println(etudiant.getNom() + " - Moyenne : " + etudiant.getMoyenne());
                        }
                        break;
                    case 2:
                    Etudiant maxNote = null;
                    Etudiant minNote = null;
                    
                    for (Etudiant etudiant : ListeEtudiantsParMoyenne) {
                        if (maxNote == null || etudiant.getMoyenne() > maxNote.getMoyenne()) {
                            maxNote = etudiant;
                        }
                        if (minNote == null || etudiant.getMoyenne() < minNote.getMoyenne()) {
                            minNote = etudiant;
                        }
                    }  
                        System.out.println("Étudiant avec la plus grande note : " + maxNote.getNom() + " - Moyenne : " + maxNote.getMoyenne());
                        System.out.println("Étudiant avec la plus petite note : " + minNote.getNom() + " - Moyenne : " + minNote.getMoyenne());
                            break;
                    case 3:
                    for (Etudiant etudiant : ListeEtudiantsParMoyenne) {
                        if (etudiant.getMoyenne() > 10) {
                            System.out.println(etudiant.getNom() + " - Moyenne : " + etudiant.getMoyenne());
                        }
                    }
                        
                        break;
                    case 4:
                    double sommeDesNotes = 0;

                    for(Etudiant etudiant : ListeEtudiantsParMoyenne) {
                        sommeDesNotes += etudiant.getMoyenne();
                    }
            
                    double moyenneClasse = sommeDesNotes / ListeEtudiantsParMoyenne.size();
                    
                    System.out.println("Moyenne de la classe : " + moyenneClasse);
                        
                        break;
                    case 5:

                    if (!ListeEtudiantsParMoyenne.isEmpty()) {
                        double sommeDesNotess = 0;
                        for (Etudiant etudiant : ListeEtudiantsParMoyenne) {
                            sommeDesNotess += etudiant.getMoyenne();
                        }
                        double moyenneClasses = sommeDesNotess / ListeEtudiantsParMoyenne.size();
                    
                        for (Etudiant etudiant : ListeEtudiantsParMoyenne) {
                            if (etudiant.getMoyenne() >= moyenneClasses) {
                                System.out.println(etudiant.getNom() + " - Moyenne : " + etudiant.getMoyenne());
                            }
                        }
                    } else {
                        System.out.println("La liste est vide");
                    }
                        
                        break;
                    case 6:
                        System.exit(0);
                        break;
                
                    default:
                        System.out.println("choix invalide");
                        break;
                }
            }
        
    }
}
