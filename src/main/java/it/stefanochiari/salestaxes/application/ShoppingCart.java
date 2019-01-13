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

/**
 * A very simple shopping cart which will create a receipt using the TaxModel provided 
 *
 * @author Stefano Chiari
 */
public class ShoppingCart {
	
	private final static Logger log = Logger.getLogger(ShoppingCart.class.getName());
	
	private List<Item> items = new ArrayList<Item>();
	private TaxModel taxModel;

	
	/**
	 * A TaxModel is required!
	 */
	@SuppressWarnings("unused")
	private ShoppingCart() {}
	
	
	/**
	 * Will create an empty ShoppingCart, ready to be filled by an application
	 * 
	 * @param taxModel		An implementation of a TaxModel
	 */
	public ShoppingCart(TaxModel taxModel) {
		this.taxModel = taxModel;
		log.finest("Shopping cart created");
	}
	
	/**
	 * Will create a not empty ShoppingCart, filled from a wishlist or somehow 
	 * 
	 * @param items			A list of items
	 * @param taxModel		An implementation of a TaxModel
	 */
	public ShoppingCart( List<Item> items, TaxModel taxModel) {
		this.items = items;
		this.taxModel = taxModel;
		log.finest("Shopping cart created and filled");
	}	
	
	/**
	 * 
	 * Getter
	 * 
	 * @return items 	The list of the items 
	 */
	public List<Item> getItems() {
		return items;
	}	
	
	
	/**
	 * Displays items to final user
	 */
	public void display() {
		for (Item item : items) {
			this.taxModel.applyTax(item);
			System.out.println( item.getName() + ": " + this.taxModel.getTaxedPrice());
		}
	}
	
	/**
	 * Returns a receipt and clears the cart
	 *  
	 * @return receipt		A receipt, applying taxes from a TaxModel
	 */
	public Receipt checkout(){
		log.fine("Checkout! Creating a receipt");
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

	
	/**
	 * @param item		The item  to be added to cart
	 */
	public void addItem(Item item) {
		log.finest("Adding to cart: " + item.getName());
		this.items.add(item);
	}
	
	
	/**
	 * @param item		The item  to be removed from cart
	 */
	public void removeItem(Item item) {
		// TODO remove Item based on barcode
		log.finest("Removing from cart: " + item.getName());
	}
	
}
