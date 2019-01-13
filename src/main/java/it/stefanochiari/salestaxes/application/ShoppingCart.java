package it.stefanochiari.salestaxes.application;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import it.stefanochiari.salestaxes.model.Item;
import it.stefanochiari.salestaxes.model.Receipt;
import it.stefanochiari.salestaxes.model.SimpleReceipt;
import it.stefanochiari.salestaxes.model.SimpleTaxedItem;
import it.stefanochiari.salestaxes.model.TaxModel;
import it.stefanochiari.salestaxes.model.TaxedItem;

public class ShoppingCart {
	
	private final static Logger log = Logger.getLogger(ShoppingCart.class.getName());
	
	private List<Item> items = new ArrayList<Item>();
	private TaxModel taxModel;

	public ShoppingCart(TaxModel taxModel) {
		this.taxModel = taxModel;
		log.finest("Shopping cart created");
	}
	
	public ShoppingCart( List<Item> items, TaxModel taxModel) {
		this.items = items;
		this.taxModel = taxModel;
		log.finest("Shopping cart created and filled");
	}	
	
	public void display() {
		for (Item item : items) {
			this.taxModel.applyTax(item);
			System.out.println( item.getName() + ": " + this.taxModel.getTaxedPrice());
		}
	}
	
	public Receipt checkout(){
		log.info("Checkout! Creating a receipt");
		List<TaxedItem> taxedItems = new ArrayList<TaxedItem>();
		for (Item item : items) {
			TaxedItem t = new SimpleTaxedItem(item, this.taxModel);
			taxedItems.add(t);
		}		
		
		Receipt receipt = new SimpleReceipt(taxedItems);
				
		this.items.clear();
		this.items = null;
		
		return receipt;
	}

	public void addItem(Item item) {
		log.finest("Adding to cart: " + item.getName());
		this.items.add(item);
	}
	
	
	public void removeItem(Item item) {
		// TODO remove Item based on barcode
		log.finest("Removing from cart: " + item.getName());
	}
	
}
