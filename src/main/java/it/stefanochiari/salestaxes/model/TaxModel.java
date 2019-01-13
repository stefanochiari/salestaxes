package it.stefanochiari.salestaxes.model;

/**
 * 
 * The tax model 
 * Implementations can depend on country
 * 
 * @author Stefano Chiari
 *
 */
public interface TaxModel {

	public enum TaxType {
		TENPERCENT,
		EXEMPT
	}
	void applyTax(Item item);
	float getTaxedPrice();
	float getTaxesApplied();

}