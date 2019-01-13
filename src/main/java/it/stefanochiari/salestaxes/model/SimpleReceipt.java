package it.stefanochiari.salestaxes.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * It is a list of taxed items. 
 * It provides informations about total taxes applied and the total to be paid
 * 
 * @author Stefano Chiari
 *
 */
public class SimpleReceipt implements Receipt {
	
	private final static Logger log = Logger.getLogger(SimpleReceipt.class.getName());
	
	protected List<TaxedItem> taxedItems = new ArrayList<TaxedItem>();
	protected float totalTaxesApplied = 0;
	protected float toBePaid = 0;
	
	/**
	 * @param taxedItems a list of items whose taxes are already computed
	 */
	public SimpleReceipt(List<TaxedItem> taxedItems) {	
		this.taxedItems = taxedItems;
		for (TaxedItem taxedItem : this.taxedItems) {
			this.totalTaxesApplied += taxedItem.getTotalTaxesApplied();
			this.toBePaid += taxedItem.getTaxedPrice();
		}	
		log.info("Receipt created for a total of " + this.toBePaid);
	}

	
	/** 
	 * Displays the receipt on system console
	 * 
	 * @see it.stefanochiari.salestaxes.model.Receipt#display()
	 */
	@Override
	public void display() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		System.out.println("\n********\n receipt - " + dateFormat.format(new Date()));
		for (TaxedItem taxedItem : this.taxedItems) {
			System.out.println("1 " + taxedItem.getName() + " at " + taxedItem.getTaxedPrice());
		}
		System.out.println("Sales Taxes: " + this.getTotalTaxesApplied());
		System.out.println("Total: " + this.getTotalToBePaid() + "\n********\n");
	}
	
	/**
	 * 
	 * @see it.stefanochiari.salestaxes.model.Receipt#getTotalTaxesApplied()
	 */
	@Override
	public float getTotalTaxesApplied() { 
		return this.totalTaxesApplied;
	}
	
	/**
	 * 
	 * @see it.stefanochiari.salestaxes.model.Receipt#getTotalToBePaid()
	 */
	@Override
	public float getTotalToBePaid() {
		return this.toBePaid;
	}

	/**
	 * @see it.stefanochiari.salestaxes.model.Receipt#getItemsToBeDisplayed()
	 */
	@Override
	public String[] getItemsToBeDisplayed() {
		int i = 0;
		String[] names = new String[this.taxedItems.size()];
		for (TaxedItem taxedItem : this.taxedItems) {
			names[i++] = taxedItem.getName();
		}
		return names;
	}

}
