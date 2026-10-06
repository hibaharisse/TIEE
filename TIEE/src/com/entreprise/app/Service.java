package com.entreprise.app;

import com.entreprise.rh.Employe;
import com.entreprise.exceptions.EquipeCompletException;
import java.util.Arrays;

public class Service {
    private Employe[] employes;
    private int nb;

    public Service(int capacite) {
        employes = new Employe[capacite];
        nb = 0;
    }
    public void ajouter(Employe e) throws EquipeCompletException {
     
        if (nb >= employes.length) {
            throw new EquipeCompletException(employes.length);
        }
        employes[nb] = e;
        nb++;
    }

    public Employe getEmploye(int i) {
        if (i < 0 || i >= nb) {
            throw new IllegalArgumentException("indice invalide : " + i);
        }
        return employes[i];
    }
    public int getNb() {
        return nb;
    }
    public double getMasseSalariale() {
        double somme = 0;
        for (int i = 0; i < nb; i++) {
            somme += employes[i].getSalaire();
        }
        return somme;
    }
    public void trier() {
        Arrays.sort(employes, 0, this.nb);
    }
    public void afficher() {
        for (int i = 0; i < nb; i++) {
            System.out.println(i + " : " + employes[i]);
        }
    }
}
    
    