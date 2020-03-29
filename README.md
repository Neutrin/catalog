# catalog

Directory structure of the project 
Catalog - Package which contains all the function to add, search and get details of product 
CatalogTest - contains test of catalog 
Product - package which contains model and utility function for heap and product 

Time complexities 

Add a product - constant time complexity
Get most searched products 
    Get k most searched products where k is the max size of heap - O(k)
    Get m most searched products where 1<=m<=k -> O(k)(to make new max heap) + mlog(k) 

*Note*
Designed my own heap as one provided by java takes O(n) time to search for an element
