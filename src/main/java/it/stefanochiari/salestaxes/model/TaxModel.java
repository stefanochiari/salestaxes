package it.stefanochiari.salestaxes.model;

public interface TaxModel {

	public enum TaxType {
		TENPERCENT,
		EXEMPT
	}
	void applyTax(Item item);
	float getTaxedPrice();
	float getTaxesApplied();

}