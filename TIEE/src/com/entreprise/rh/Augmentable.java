package com.entreprise.rh;

import com.entreprise.exceptions.MontantInvalideException;

public interface Augmentable {
//Taux maximum 
	double TAUX_MAX=0.20;
	void augmenter(double taux)  throws MontantInvalideException;
		default void augmenterStandard() throws MontantInvalideException 
		{
			augmenter(0.05);
		}
	}

