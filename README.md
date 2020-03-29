# catalog

Directory structure of the project. </br>
Catalog - Package which contains all the function to add, search and get details of product. </br>
CatalogTest - contains test of catalog. </br>
Product - package which contains model and utility function for heap and product. </br>
  
  
Time complexities  </br>

Add a product - constant time complexity. <br>
Get most searched products   </br>
    Get k most searched products where k is the max size of heap - O(k). </br>
    Get m most searched products where 1<=m<=k -> O(k)(to make new max heap) + mlog(k). </br>

*Note*. </br>
Designed my own heap as one provided by java takes O(n) time to search for an element. </br>
