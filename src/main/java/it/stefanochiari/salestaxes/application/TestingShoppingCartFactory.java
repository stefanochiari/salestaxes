package it.stefanochiari.salestaxes.application;

import it.stefanochiari.salestaxes.model.SimpleItem;
import it.stefanochiari.salestaxes.model.TaxModel;


/**
 * This factory will create ShoppingCarts required for the test.<br>
 * A better implementation could retrieve them from a repository, a database 
 * (in a real world application, a shopping cart is usually persistent), or 
 * at least a serialized object saved on file system
 * 
 * @author Stefano Chiari
 *
 */
public class TestingShoppingCartFactory {
	
	private TaxModel taxModel;

	public TestingShoppingCartFactory(TaxModel taxModel) {
		this.taxModel = taxModel;
	}

	public ShoppingCart getTestingShoppingCart1() {
		ShoppingCart s = new ShoppingCart(this.taxModel);
		s.addItem(new SimpleItem("Book", 			(float)12.49, 	TaxModel.TaxType.EXEMPT, 		false));
		s.addItem(new SimpleItem("Music CD", 		(float)14.99, 	TaxModel.TaxType.TENPERCENT, 	false));
		s.addItem(new SimpleItem("Chocolate bar",   (float)0.85, 	TaxModel.TaxType.EXEMPT, 		false));
		
		return s;
	}

	public ShoppingCart getTestingShoppingCart2() {
		ShoppingCart s = new ShoppingCart(this.taxModel);
		s.addItem(new SimpleItem("imported box of chocolates", 10, 		TaxModel.TaxType.EXEMPT, 	true));		
		s.addItem(new SimpleItem("imported bottle of perfume", (float)47.50, 	TaxModel.TaxType.TENPERCENT, true));
		return s;		
	}

	public ShoppingCart getTestingShoppingCart3() {
		ShoppingCart s = new ShoppingCart(this.taxModel);
		s.addItem(new SimpleItem("impored bottle of perfume", 	(float)27.99, 		TaxModel.TaxType.TENPERCENT, true));
		s.addItem(new SimpleItem("bottle of perfume", 			(float)18.99, 		TaxModel.TaxType.TENPERCENT, false));
		s.addItem(new SimpleItem("packet of headache pills", 	(float)9.75, 	TaxModel.TaxType.EXEMPT, 	false));
		s.addItem(new SimpleItem("box of imported chocolates", 	(float)11.25, 		TaxModel.TaxType.EXEMPT, 	true));		
		return s;		
	}
	
}
	