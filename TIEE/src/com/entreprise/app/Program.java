package com.entreprise.app;

import com.entreprise.rh.*;
import com.entreprise.compta.*;
import com.entreprise.exceptions.*;

public class Program {
    public static void main(String[] args) throws EquipeCompletException {
        Service service = new Service(4);
        try {
            service.ajouter(new Commercial("Karim", 3000, 40000, "Rabat"));
            service.ajouter(new ChefProjet("Salma", 6000, "Casablanca"));
        } catch (MontantInvalideException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        String[] noms = {"Nadia", "Omar", "Yassine", "Leila", "Hamza"};
        String[] salaires = {"4500", "abc", "-800", "3800", "5200"};

        int tentatives = 0;
        for (int i = 0; i < noms.length; i++) {
            try {
                double sal = Double.parseDouble(salaires[i]);
                Permanent p = new Permanent(noms[i], sal);
                service.ajouter(p);
                System.out.println("Embauche de " + noms[i] + " : " + sal);
            } catch (NumberFormatException e) {
                System.out.println("\"" + salaires[i] + "\" n'est pas un montant\nSaisie ignorée");
            } catch (MontantInvalideException e) {
                System.out.println("Erreur " + e.getMessage());
            } catch (EquipeCompletException e) {
                System.out.println("Erreur " + e.getMessage());
            } finally {
                tentatives++;
            }
        }
        System.out.println("Tentatives: " + tentatives + ", employés dans le service: " + service.getNb());
        service.trier();
        service.afficher();
        System.out.println("Masse salariale " + service.getMasseSalariale());
        try {
            Employe moinsPaye = service.getEmploye(0);
            Augmentable aug = (Augmentable) moinsPaye; 
            aug.augmenterStandard();
            System.out.println("Après augmentation " + moinsPaye);
            aug.augmenter(0.5);
            System.out.println("Cette ligne ne s'affiche jamais");
        } catch (MontantInvalideException e) {
            System.out.println("Erreur: taux invalide " + e.getValeur() + " [valeur reçue: " + e.getValeur() + "]");
        }
        try {
            service.getEmploye(7);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        Payable[] paiements = new Payable[] {
            new Facture("F-102", "Bureau Plus", 450),
            service.getEmploye(1)
        };
        double total = 0;
        for (Payable p : paiements) {
            System.out.println("À payer: " + p);
            total += p.getMontantAPayer();
        }
        System.out.println("Total à payer: " + total);
        System.out.println("Nombre d'employés créés: " + Employe.getNbEmployes());
    }
}

