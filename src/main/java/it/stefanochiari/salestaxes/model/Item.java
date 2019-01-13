package it.stefanochiari.salestaxes.model;

/**
 * The absolutely minimum a product item must implement 
 * 
 * @author Stefano Chiari
 *
 */
public interface Item {

	float getPrice();
	String getBarcode();
	String getName();
	TaxModel.TaxType getTaxType();
	boolean isImported();

}