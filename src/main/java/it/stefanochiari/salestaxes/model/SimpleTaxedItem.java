package it.stefanochiari.salestaxes.model;

import java.util.logging.Logger;

public class SimpleTaxedItem implements TaxedItem {
	
	private final static Logger log = Logger.getLogger(SimpleTaxedItem.class.getName());
	
	protected Item item;
	protected float taxedPrice;
	protected float tax;
	
	public SimpleTaxedItem(Item item, TaxModel t) {
		this.item = item;
		t.applyTax(this.item);
		this.taxedPrice = t.getTaxedPrice();
		this.tax		= t.getTaxesApplied();
		log.finest("Taxed item created for: " + item.getName() + " price: " + item.getPrice() + " - tax:" + this.tax + " to pay: " + this.taxedPrice);
	}
	
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.TaxedItem#getTaxedPrice()
	 */
	@Override
	public float getTaxedPrice() {
		return taxedPrice;
	}
	
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.TaxedItem#getName()
	 */
	@Override
	public String getName() {
		return this.item.getName();
	}
	
	public float getOriginalPrice() {
		return this.item.getPrice();
	}
	
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.TaxedItem#getTotalTaxesApplied()
	 */
	@Override
	public float getTotalTaxesApplied() {
		return this.tax;
	}
	
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.TaxedItem#setTaxedPrice(float)
	 */
	@Override
	public void setTaxedPrice(float  taxedPrice) {
		this.taxedPrice = taxedPrice;
	}
	

}
