package it.stefanochiari.salestaxes.application;

import it.stefanochiari.salestaxes.model.Receipt;
import it.stefanochiari.salestaxes.model.SimpleTaxModel;
import it.stefanochiari.salestaxes.model.TaxModel;

/**
 * As this is only a very simple prototype, it just retrieves (somehow) 
 * the required shopping carts, executes the checkout and displays the related receipts<br>
 * A real world application will create a new ShoppingCart object as a response to user 
 * action. <br>A straightforward example is "browsing a website and clicking an 'Add to cart' button".
 * A ShoppingCart requires a TaxModel, which can depend on country. <br>In a real, worldwide application,
 * every country should implement its own model.<br>
 * A shopping cart is able to display items (here, to system console, in a real world... somehow, probably
 * returning a List to a controller in an MVC application, web or not), and of course, to checkout.<br>
 * A checkout action, will create the receipt, applying taxes of its TaxModel implementation<br>
 *
 * @author Stefano Chiari
 */
public class Application {

	public static void main(String[] args) {
		
		// TODO should be injected by a container (spring?) where needed (just TaxedItem?)
		TaxModel taxModel = new SimpleTaxModel();
		
		TestingShoppingCartFactory scFactory = new TestingShoppingCartFactory(taxModel);

		Receipt receipt = scFactory.getTestingShoppingCart1().checkout();
		receipt.display();
		
		receipt = scFactory.getTestingShoppingCart2().checkout();
		receipt.display();
		
		receipt = scFactory.getTestingShoppingCart3().checkout();
		receipt.display();
		
	
	}

}
