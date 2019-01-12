package it.stefanochiari.salestaxes.model;

import java.util.logging.Logger;

public class SimpleTaxModel implements TaxModel {
	
	private final static Logger log = Logger.getLogger(SimpleTaxModel.class.getName());
	
	protected float additionalOnImportedRate = (float)0.05;
	protected float[] rateMap = {0,(float)0.1};
	
	protected float taxed;
	protected float tax;
	
	
	/* (non-Javadoc)
	 * @see ch.lastminute.taxes.model.TaxModel#applyTax(ch.lastminute.taxes.model.ItemInterface)
	 */
	@Override
	public void applyTax(Item item) {
		log.info("Applying tax model to: " + item.getName() + " - price: " + item.getPrice());
		float additionalOnImported			= 0;
		float roundedAdditionalOnImported 	= 0;
		
		int rateIndex = item.getTaxType() == TaxModel.TaxType.EXEMPT ? 0 : 1;

		float tax 			= item.getPrice()*this.rateMap[rateIndex];
		float roundedTax 	= Math.round(tax * 20) / 20f; // rounded to the nearest 0.05
		float taxed 		= item.getPrice() + roundedTax;
		
		log.info("Local tax is: " + roundedTax);
		
		if (item.isImported()) {
			additionalOnImported 		= item.getPrice() * this.additionalOnImportedRate;
			roundedAdditionalOnImported = Math.round(additionalOnImported * 20) / 20f; // rounded to the nearest 0.05
			taxed += roundedAdditionalOnImported;
			log.info("Tax on imported item is: " + roundedAdditionalOnImported);
		}else {
			log.info("Item is local, no additiona on imported is applied");
		}
		
		this.taxed 	= taxed;
		this.tax 	= roundedTax + roundedAdditionalOnImported;
		log.info("total price is: " + this.taxed + " - total taxes applied: " + this.tax);
	}


	@Override
	public float getTaxedPrice() {
		return this.taxed;
	}


	@Override
	public float getTaxesApplied() {
		return this.tax;
	}

}
