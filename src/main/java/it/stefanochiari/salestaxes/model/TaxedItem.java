package it.stefanochiari.salestaxes.model;

/**
 * 
 * An item decorated with tax informations
 * 
 * @author Stefano Chiari
 *
 */
public interface TaxedItem {

	float getTaxedPrice();

	String getName();

	float getTotalTaxesApplied();

}