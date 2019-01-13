package it.stefanochiari.salestaxes.model;

import java.util.logging.Logger;

/**
 * Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. <br>
 * Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.<br>
 * The rounding rules for sales tax are that for a tax rate of n%, 
 * a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.<br>
 * @author Stefano Chiari
 *
 */
public class SimpleTaxModel implements TaxModel {
	
	private final static Logger log = Logger.getLogger(SimpleTaxModel.class.getName());
	
	protected float additionalOnImportedRate = (float)0.05;
	protected float[] rateMap = {0,(float)0.1};
	
	protected float taxed;
	protected float tax;
	
	
	/** 
	 * 
	 * @see it.stefanochiari.salestaxes.model.TaxModel#applyTax(it.stefanochiari.salestaxes.model.Item)
	 */
	@Override
	public void applyTax(Item item) {
		log.fine("Applying tax model to: " + item.getName() + " - price: " + item.getPrice());
		float additionalOnImported			= 0;
		float roundedAdditionalOnImported 	= 0;
		
		int rateIndex = item.getTaxType() == TaxModel.TaxType.EXEMPT ? 0 : 1;

		float tax 			= item.getPrice()*this.rateMap[rateIndex];
		float roundedTax 	= Math.round(tax * 20) / 20f; // rounded to the nearest 0.05
		float taxed 		= item.getPrice() + roundedTax;
		
		log.fine("Local tax is: " + roundedTax);
		
		if (item.isImported()) {
			additionalOnImported 		= item.getPrice() * this.additionalOnImportedRate;
			roundedAdditionalOnImported = Math.round(additionalOnImported * 20) / 20f; // rounded to the nearest 0.05
			taxed += roundedAdditionalOnImported;
			log.fine("Tax on imported item is: " + roundedAdditionalOnImported);
		}else {
			log.fine("Item is local, no additiona on imported is applied");
		}
		
		this.taxed 	= taxed;
		this.tax 	= roundedTax + roundedAdditionalOnImported;
		log.fine("total price is: " + this.taxed + " - total taxes applied: " + this.tax);
	}


	/**
	 * @return the gross price
	 * @see it.stefanochiari.salestaxes.model.TaxModel#getTaxedPrice()
	 */
	@Override
	public float getTaxedPrice() {
		return this.taxed;
	}


	/**
	 * @return the taxes applied
	 * @see it.stefanochiari.salestaxes.model.TaxModel#getTaxesApplied()
	 */
	@Override
	public float getTaxesApplied() {
		return this.tax;
	}

}
