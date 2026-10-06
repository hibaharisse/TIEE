package com.entreprise.exceptions;

public class EquipeCompletException extends Exception {
    
    public EquipeCompletException(int capacite) {
        super("Equipe complete (capacite : " + capacite + ")");
    }
    
}
