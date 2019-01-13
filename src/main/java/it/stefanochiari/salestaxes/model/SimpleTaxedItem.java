package it.stefanochiari.salestaxes.model;

import java.util.logging.Logger;

/**
 * A very simple implementation. It will use the 
 * TaxModel to calculate taxes to be applied
 * 
 * @author Stefano Chiari
 *
 */
public class SimpleTaxedItem implements TaxedItem {
	
	private final static Logger log = Logger.getLogger(SimpleTaxedItem.class.getName());
	
	protected Item item;
	protected float taxedPrice;
	protected float tax;
	
	
	/**
	 * @param item		the item to be taxed
	 * @param t			the tax model
	 */
	public SimpleTaxedItem(Item item, TaxModel t) {
		this.item = item;
		t.applyTax(this.item);
		this.taxedPrice = t.getTaxedPrice();
		this.tax		= t.getTaxesApplied();
		log.finest("Taxed item created for: " + item.getName() + " price: " + item.getPrice() + " - tax:" + this.tax + " to pay: " + this.taxedPrice);
	}
	
	/**
	 * 
	 * @return taxedPrice 	the gross price
	 * @see it.stefanochiari.salestaxes.model.TaxedItem#getTaxedPrice()
	 */
	@Override
	public float getTaxedPrice() {
		return taxedPrice;
	}
	
	/**
	 * 
	 * @return the item name
	 * @see it.stefanochiari.salestaxes.model.TaxedItem#getName()
	 */
	@Override
	public String getName() {
		return this.item.getName();
	}
	
	/**
	 * @return the net price
	 */
	public float getOriginalPrice() {
		return this.item.getPrice();
	}
	
	/**
	 * @return the taxes applied
	 * @see it.stefanochiari.salestaxes.model.TaxedItem#getTotalTaxesApplied()
	 */
	@Override
	public float getTotalTaxesApplied() {
		return this.tax;
	}
		

}
