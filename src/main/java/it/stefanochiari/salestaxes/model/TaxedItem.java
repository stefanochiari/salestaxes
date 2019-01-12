package it.stefanochiari.salestaxes.model;

public interface TaxedItem {

	float getTaxedPrice();

	String getName();

	float getTotalTaxesApplied();

	void setTaxedPrice(float taxedPrice);

}