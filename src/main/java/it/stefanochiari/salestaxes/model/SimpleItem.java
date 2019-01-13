package it.stefanochiari.salestaxes.model;

import java.util.logging.Logger;

/**
 * The product item
 * 
 * @author Stefano Chiari
 *
 */
public class SimpleItem implements Item {
	
	private final static Logger log = Logger.getLogger(SimpleItem.class.getName());
	
	protected String name;
	protected float price;
	protected TaxModel.TaxType taxType;
	protected boolean imported;
	
	
	/**
	 * @param name			Name and/or description of the item
	 * @param price			Net price
	 * @param taxType		A tax type as defined in TaxModel as an enumeration
	 * @param imported		Boolean. True if it is imported 
	 */
	public SimpleItem(String name, float price, TaxModel.TaxType taxType, boolean imported) {
		super();
		this.name = name;
		this.price = price;
		this.taxType = taxType;
		this.imported = imported;
		log.finest("Item created: " + name);
	}
	
	/** 
	 * 
	 * @return name     the item name
	 * @see it.stefanochiari.salestaxes.model.Item#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name		The item name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return price 	The price
	 * @see it.stefanochiari.salestaxes.model.Item#getPrice()
	 */
	@Override
	public float getPrice() {
		return this.price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public SimpleTaxModel.TaxType getTaxType() {
		return taxType;
	}
	
	public void setTaxType(TaxModel.TaxType taxType) {
		this.taxType = taxType;
	}

	@Override
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}

	@Override
	public String getBarcode() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
