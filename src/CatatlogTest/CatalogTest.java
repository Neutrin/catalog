package CatatlogTest;

import Catalog.Catalog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class CatalogTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
    @Test
    public void addProduct() {
        Catalog instance = new Catalog();
        instance.addProduct("Shoe", "For protection of foot");

        assertTrue("createdaproductwithnameshoewithid1anddescforprotectionoffoot".
                equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
        instance.doCleanup();
    }

    @Test
    public void searchProduct() {
        Catalog instance = new Catalog();
        instance.addProduct("Shoe", "For protection of foot");
        outContent.reset();
        instance.searchProduct(1);
        assertTrue("shoe1forprotectionoffoot".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
        instance.doCleanup();
    }

    /*
    This test case is for the case when we want to get all k most searched product
    here k is the maximum limit of heap
    */
    @Test
    public void printTenMostSearchedProducts() {
        Catalog instance = new Catalog();
        //add 30 products to catalog
        for(int i = 1; i <= 30; i++){
            instance.addProduct("Product" + i + "", "Product" + i + "");

        }
        //Search product with id (1) 5 times
        for(int i = 0; i < 5; i++) {
            instance.searchProduct(1);
        }
        //Search product with id (2) 3 times
        for(int i = 0; i < 3; i++) {
            instance.searchProduct(2);
        }
        //Search product between 3 - 10 ids 2 times
        for(int i = 3; i <= 10; i++){
            instance.searchProduct(i);
            instance.searchProduct(i);
        }
        //Search all other products one time
        for(int i = 11; i < 30 ; i++){
            instance.searchProduct(i);
        }
        outContent.reset();
        //Return top 10 most searched products
        ArrayList<Integer> searchedProducts =  instance.printMostSearchedProducts(10);
        Collections.sort(searchedProducts);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        for(int i = 1; i <= 10; i++){
            expected.add(i);
        }
        assertTrue(expected.equals(searchedProducts));
    }
    /*
   This test case is for the case when we want to get top 3 most searched product
   */
    @Test
    public void printLessThantenMostSearchedProducts() {
        Catalog instance = new Catalog();
        //add 30 products to catalog
        for(int i = 1; i <= 30; i++){
            instance.addProduct("Product" + i + "", "Product" + i + "");

        }
        //Search product with id (1) 5 times
        for(int i = 0; i < 5; i++) {
            instance.searchProduct(1);
        }
        //Search product with id (2) 4 times
        for(int i = 0; i < 4; i++) {
            instance.searchProduct(2);
        }

        //Search product with id (3) 3 times
        for(int i = 0; i < 3; i++) {
            instance.searchProduct(3);
        }
        //Search product between 4 - 10 ids 2 times
        for(int i = 4; i <= 10; i++){
            instance.searchProduct(i);
            instance.searchProduct(i);
        }
        //Search all other products one time
        for(int i = 11; i < 30 ; i++){
            instance.searchProduct(i);
        }
        outContent.reset();
        //Returns top 3 most searched products
        ArrayList<Integer> searchedProducts =  instance.printMostSearchedProducts(3);
        Collections.sort(searchedProducts);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        for(int i = 1; i <= 3; i++){
            expected.add(i);
        }
        assertTrue(expected.equals(searchedProducts));

    }
}