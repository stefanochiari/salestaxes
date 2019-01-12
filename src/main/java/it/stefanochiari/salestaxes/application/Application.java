package it.stefanochiari.salestaxes.application;

import it.stefanochiari.salestaxes.model.Receipt;
import it.stefanochiari.salestaxes.model.SimpleTaxModel;
import it.stefanochiari.salestaxes.model.TaxModel;

public class Application {

	public static void main(String[] args) {
		
		// TODO should be injected by a container (spring?) where needed (just TaxedItem?)
		TaxModel taxModel = new SimpleTaxModel();
		
		TestingShoppingCartFactory scFactory = new TestingShoppingCartFactory(taxModel);

		Receipt receipt = scFactory.getTestingShoppingCart1().checkout();
		receipt.display();
		
//		receipt = scFactory.getTestingShoppingCart2().checkout();
//		receipt.display();
		
//		receipt = scFactory.getTestingShoppingCart3().checkout();
//		receipt.display();
		
	
	}

}
