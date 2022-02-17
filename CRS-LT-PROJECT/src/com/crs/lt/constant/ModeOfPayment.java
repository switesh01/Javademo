package com.crs.lt.constant;

public enum ModeOfPayment {

	CREDIT_CARD,DEBIT_CARD,OFFLINE;
	public static ModeOfPayment getModeOfpayment(int value){
		
		switch(value) {
		case 1: 
			return ModeOfPayment.CREDIT_CARD;
			
		case 2: 
			return ModeOfPayment.DEBIT_CARD;
			
		case 3: 
			return ModeOfPayment.OFFLINE;
			
		}
		return null;
	
		
	}
}
