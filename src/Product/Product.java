package Product;

//import /Users/nitinthakur/IdeaProjects/lidoLearning;


public class Product {
    private int Id;
    private String Name;
    private  String Desc;
   // HeapNode heapNode;
   private int HeapIndex;
   private  int Count;
   //Heap heapDet;
   //HashMap<Integer, Product> prodDetail;
    public Product(String name, String Desc, int id){
        this.Name = name;
        this.Desc = Desc;
        this.Count = 0;
        HeapIndex = -1;
        this.Id = id;
   //     intialiseHeap();
    }
    public String getName() {
        return this.Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getDesc(){
        return this.Desc;
    }
    public void setDesc(String Desc){
        this.Desc = Desc;
    }

    public int getId(){
        return this.Id;
    }

    public void increaseCount(){
        Count++;
    }

    public int getHeapIndex() {
        return this.HeapIndex;
    }

    public void setHeapIndex(int index){
        this.HeapIndex = index;
    }

    public int getCount(){
        return  this.Count;
    }

    public void setCount(int count){
        this.Count = count;
    }
    public void printProduct() {
        System.out.println("Desc :- " + Desc + " name :- " + Name+ "id :-  " + Id
                + "count :- " + Count);

//    public void intialiseProductDet(){
//        prodDetail = new HashMap<Integer, Product>();
//    }
//    public void intialiseHeap(){
//        heapDet = new Heap(10);
//    }
//    public void createProduct(String name, String description){
//        Product newProduct = new Product(name, description);
//        newProduct.id++;
//        //If hash map is unitialised
//        if(prodDetail == null){
//          //  intialiseProduct();
//        }
//        prodDetail.put(newProduct.id, newProduct);
//    }
//    public void printProduct(Product product) {
//        System.out.println("here the products details are" + product.Desc + "and the name is" + product.name);
//
//    }
//    public boolean searchProduct(int productID){
//        boolean isPresent = false;
//        if(prodDetail != null){
//            if(prodDetail.containsKey(productID)){
//                isPresent = true;
//                printProduct(prodDetail.get(productID));
//                heapDet.addNodeToHeap(prodDetail, productID);
//            }
//        }else{
//            //apply try catch over here
//        }
//        return isPresent;
//    }
//    public void printProductsByID(ArrayList<Integer> id){
//        Iterator<Integer> productID = id.iterator();
//        int curProductID;
//        while(productID.hasNext()){
//            curProductID = productID.next();
//            if(prodDetail.containsKey(curProductID)){
//                printProduct(prodDetail.get(curProductID));
//            }
//        }
//
//
//    }
//
//    public boolean printMostSearchedProducts(int limit){
//        if(limit <= heapDet.capacity){
//            if(limit == heapDet.capacity){
//                heapDet.getAllMostSearchedProducts();
//            }else{
//                heapDet.getKMostSearchedProducts(limit);
//            }
//        }
//        return false;
//    }



    }

}

