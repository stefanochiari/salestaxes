package it.stefanochiari.salestaxes.model;

import java.util.logging.Logger;

import it.stefanochiari.salestaxes.application.ShoppingCart;

public class SimpleItem implements Item {
	
	private final static Logger log = Logger.getLogger(SimpleItem.class.getName());
	
	protected String name;
	protected float price;
	protected TaxModel.TaxType taxType;
	protected boolean imported;
	
	
	public SimpleItem(String name, float price, TaxModel.TaxType taxType, boolean imported) {
		super();
		this.name = name;
		this.price = price;
		this.taxType = taxType;
		this.imported = imported;
		log.finest("Item created: " + name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.ItemInterface#getPrice()
	 */
	@Override
	public float getPrice() {
		return this.price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.ItemInterface#getTaxType()
	 */
	@Override
	public SimpleTaxModel.TaxType getTaxType() {
		return taxType;
	}
	public void setTaxType(TaxModel.TaxType taxType) {
		this.taxType = taxType;
	}
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.ItemInterface#isImported()
	 */
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
