package it.stefanochiari.salestaxes.model;

public interface Item {

	float getPrice();
	String getBarcode();
	String getName();
	TaxModel.TaxType getTaxType();
	boolean isImported();

}