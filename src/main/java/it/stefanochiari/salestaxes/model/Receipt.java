package it.stefanochiari.salestaxes.model;


/**
 * A receipt object will provide informations about items purchased
 * and taxes applied 
 * 
 * @author Stefano Chiari
 *
 */
public interface Receipt {

	void display();

	float getTotalTaxesApplied();

	float getTotalToBePaid();
	
	String[] getItemsToBeDisplayed();

}