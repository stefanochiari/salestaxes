package it.stefanochiari.salestaxes.model;

public interface Receipt {

	void display();

	float getTotalTaxesApplied();

	float getTotalToBePaid();
	
	String[] getItemsToBeDisplayed();

}