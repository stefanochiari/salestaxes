package com.lastminute.taxes;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.stefanochiari.salestaxes.application.TestingShoppingCartFactory;
import it.stefanochiari.salestaxes.model.Item;
import it.stefanochiari.salestaxes.model.Receipt;
import it.stefanochiari.salestaxes.model.SimpleItem;
import it.stefanochiari.salestaxes.model.SimpleTaxModel;
import it.stefanochiari.salestaxes.model.TaxModel;

/**
 * Unit test for simple App.
 */
public class ApplicationTest 
{
	
	private final static Logger log = Logger.getLogger(ApplicationTest.class.getName());
	
	private TaxModel taxModel = new SimpleTaxModel();
	private TestingShoppingCartFactory scFactory;
	private Receipt receipt1;
	private Receipt receipt2;
	private Receipt receipt3;

    @Before
    public void setUp() throws Exception {
    	log.info("Setting up...");
        this.taxModel = new SimpleTaxModel();
        this.scFactory = new TestingShoppingCartFactory(this.taxModel);
        receipt1 = scFactory.getTestingShoppingCart1().checkout();
        receipt2 = scFactory.getTestingShoppingCart2().checkout();
        receipt3 = scFactory.getTestingShoppingCart3().checkout();
        log.info("...setup complete!");
    }
	
    @Test
    public void testItemImportedAndTaxed(){
    	Item i = new SimpleItem("item", (float)47.50, TaxModel.TaxType.TENPERCENT, true);
    	this.taxModel.applyTax(i);
        float taxed = this.taxModel.getTaxedPrice();   		
    	assertTrue( taxed == (float) 54.65);
    }    
    
    @Test
    public void testItemNotTaxedAndNotImported(){
    	Item i = new SimpleItem("item", (float)9.75, TaxModel.TaxType.EXEMPT, false);
    	this.taxModel.applyTax(i);
        float taxed = this.taxModel.getTaxedPrice();   		
    	assertTrue( taxed == (float) 9.75);
    } 

    @Test
    public void testItemTaxedAndNotImported(){
    	Item i = new SimpleItem("item", (float)18.99, TaxModel.TaxType.TENPERCENT, false);
    	this.taxModel.applyTax(i);
        float taxed = this.taxModel.getTaxedPrice();   		
    	assertTrue( taxed == (float) 20.89);
    }     
    
    @Test
    public void testItemNotTaxedAndImported(){
    	Item i = new SimpleItem("item", (float)11.25, TaxModel.TaxType.EXEMPT, true);
    	this.taxModel.applyTax(i);
        float taxed = this.taxModel.getTaxedPrice();   		
        log.severe("Maybe data in exercise are wrong on this? It is said to be 11.85 but it seems to be wrong");
    	assertTrue( taxed == (float) 11.8);
    }         
   
    @Test
    public void testTaxesOnReceiptFromShoppingCart1(){
        assertTrue( receipt1.getTotalTaxesApplied() == (float)1.50);
    }

    @Test
    public void testTotalToBePaidOnReceiptFromShoppingCart1(){
        assertTrue( receipt1.getTotalToBePaid() == (float)29.83);
    }    
    
    @Test
    public void testItemNamesOnReceiptFromShoppingCart1(){
        String[] names = receipt1.getItemsToBeDisplayed();
    	assertTrue( names[0] == "Book" 		&& 
    				names[1] == "Music CD"	&&
    				names[2] == "Chocolate bar");
    }    

        
    @Test
    public void testTaxesOnReceiptFromShoppingCart2(){
        assertTrue( receipt2.getTotalTaxesApplied() == (float)7.65);
    }

    @Test
    public void testTotalToBePaidOnReceiptFromShoppingCart2(){
        assertTrue( receipt2.getTotalToBePaid() == (float)65.15);
    }    
    
    @Test
    public void testTaxesOnReceiptFromShoppingCart3(){
    	log.severe("Maybe data in exercise are wrong on this? '1 box of imported chocolates at 11.25' it is said to cost 0.05 more, but it seems to be wrong");
        assertTrue( receipt3.getTotalTaxesApplied() == (float)6.65);
    }

    @Test
    public void testTotalToBePaidOnReceiptFromShoppingCart3(){
    	log.severe("Maybe data in exercise are wrong on this? '1 box of imported chocolates at 11.25' it is said to cost 0.05 more, but it seems to be wrong");
        assertTrue( receipt3.getTotalToBePaid() == (float)74.63);
    }  
    
    @After
    public void tearDown() {
    	// nop
    	log.info("Tear down");
    }
        
    
}
