package com.codemanship.testutils;

import java.util.ArrayList;

public class AttemptList extends ArrayList<Attempt>{

	Attempt generateBestTestCase(ValuePair valuePair) {
		for(int n = 0;n < 10;n++){
			add(new Attempt(valuePair));
		}
		return findBest();
		
	}
	
	private Attempt findBest() {
		Attempt bestAttempt = get(0);
		for (Attempt attempt : this) {
			bestAttempt = compare(bestAttempt, attempt);
		}
		return bestAttempt;
	}

	private Attempt compare(Attempt bestAttempt, Attempt attempt) {
		if(attempt.valuePairsCovered() > bestAttempt.valuePairsCovered()){
			bestAttempt = attempt;
		}
		return bestAttempt;
	}


}
