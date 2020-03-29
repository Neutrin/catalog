package Catalog;

import Product.Product;
import Product.TopProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Catalog{
    static  private  HashMap<Integer, Product> prodDetail;  //HashMap of product id as key and its details as value
    static  private  TopProduct topProduct; //heap to store top k products
    private static int id;  //To assign unique id to each product

    public Catalog() {
        prodDetail = new HashMap<Integer, Product>();
        topProduct = new TopProduct(10);//maximum capacity of heap i.e 1 <= k <= 10
        id = 1;
    }

    //This function adds new product to catalog
    public void addProduct(String name, String desc){
        Product newProduct = new Product(name, desc, id++);
        prodDetail.put(newProduct.getId(), newProduct); //Add product details to hashmap
        //this is for the testing part
        System.out.println("Created a product with name " + newProduct.getName() + " with id " + newProduct.getId() + " and desc" +
                newProduct.getDesc());
    }

    //this function searches for a product on the basis of product id
    public void searchProduct(int productID){
        //checks if product is present in catalog
        if(prodDetail.containsKey(productID)) {
            Product searchedProduct = prodDetail.get(productID);
            //Increase count of searched product
            searchedProduct.increaseCount();
            /*Add product to heap if it is the case i.e if heap is not filled or it comes under top k searched
            /products*/
            topProduct.addNodeToHeap(prodDetail, productID);
            //This is for testing purpose
            System.out.println(searchedProduct.getName()+searchedProduct.getId()+searchedProduct.getDesc()+"");
        }
    }

    //This function prints all the products by ids (for testing purpose)
    public void printProductsByID(ArrayList<Integer> id){
        Iterator<Integer> productID = id.iterator();
        int curProductID;
        while(productID.hasNext()){
            curProductID = productID.next();
            if(prodDetail.containsKey(curProductID)){
                (prodDetail.get(curProductID)).printProduct();
            }
        }


    }

    //Returns and prints most searched products i.e maximum limit of heap
    public ArrayList<Integer> printMostSearchedProducts(int limit){
        ArrayList<Integer> searchedProducts = new ArrayList<Integer>();
        //when all the most searched products are to be printed ie till the capacity of heap
        if(limit <= topProduct.getCapacity()){
            if(limit == topProduct.getCapacity()){
              //  printProductsByID(heapDet.getAllMostSearchedProducts());
                searchedProducts = topProduct.getAllMostSearchedProducts();

            }else{
                //When top k most seached products are to be printed
                //printProductsByID(heapDet.getKMostSearchedProducts(limit));
                searchedProducts = topProduct.getKMostSearchedProducts(limit);
            }
        }
        return searchedProducts;
    }

    public void doCleanup() {
        prodDetail = null;
        topProduct = null;
    }
}

