package Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

//Class for each node of the heap
class HeapNode implements Comparable<HeapNode> {
    int id;
    int count;
    HeapNode(int id, int count){
        this.id = id;
        this.count = count;
    }
    //customer comparable to make it max heap
    public int compareTo(HeapNode heapNode){
        return Integer.compare(heapNode.count, this.count);
    }
}

public class TopProduct{
    private int capacity;  //Max capacity of heap
    private int nodeCount; //Total number of nodes in the heap
    HeapNode[]heapDet; //Nodes of the heap

    public TopProduct(int capacity){
        this.capacity = capacity;
        this.nodeCount = 0;
        heapDet = new HeapNode[this.capacity];
    }

    public int getCapacity(){
        return this.capacity;
    }

    private void swap(int index1, int index2){
        HeapNode tempNode = heapDet[index1];
        heapDet[index1] = heapDet[index2];
        heapDet[index2] = tempNode;
    }
    private void minHeapify(HashMap<Integer, Product> prodDetail, int index){
        int leftNode =  2 * index + 1;
        int rightNode = 2 * index + 2;
        int smallest = index;
        if((leftNode < nodeCount) && (heapDet[leftNode].count  < heapDet[smallest].count)){
            smallest = leftNode;
        }
        if((rightNode < nodeCount) && (heapDet[rightNode].count < heapDet[smallest].count)){
            smallest  = rightNode;
        }
        if(smallest != index){
            Product smallestProduct =  prodDetail.get(heapDet[smallest].id);
            Product curProduct = prodDetail.get(heapDet[index].id);
            //Swap indexes of the products in hasmap
            smallestProduct.setHeapIndex(index);
            curProduct.setHeapIndex(index);
            prodDetail.put(heapDet[smallest].id, smallestProduct);
            prodDetail.put(heapDet[index].id, curProduct);
            //Swap values in heap
            swap(index, smallest);
            minHeapify(prodDetail, smallest);
        }
    }

    private void makeHeap(HashMap<Integer, Product> prodDetail){
        int midNodeIndex = (nodeCount - 1)/2;
        for(int curIndex = midNodeIndex; curIndex >= 0 ; curIndex--){
            minHeapify(prodDetail, curIndex);
        }
    }
    /*This function check and accordingly adds nodes to the heap
      Also it manipulates the index of the node in hash map
     */
    public void addNodeToHeap(HashMap<Integer, Product> prodDetail, int productID){
        Product curProduct = prodDetail.get(productID);
        //Product is present in heap
        if(curProduct.getHeapIndex() != -1){
            //Increase it's count
            heapDet[curProduct.getHeapIndex()].count++;
            //do minimum heapify
            minHeapify(prodDetail, curProduct.getHeapIndex());
        }else{
            //If the product is not present in heap
            //If the limit has not been reached
            if(nodeCount < 10){

                //  HeapNode newHeapNode = new HeapNode(curProduct.id, curProduct.count);
                HeapNode newHeapNode = new HeapNode(curProduct.getId(), curProduct.getCount());
                heapDet[nodeCount] = newHeapNode;
                //  curProduct.heapIndex = nodeCount;
                curProduct.setHeapIndex(nodeCount);
                nodeCount++;
                // prodDetail.put(curProduct.id, curProduct);
                prodDetail.put(curProduct.getId(), curProduct);
                makeHeap(prodDetail);
            }else if (heapDet[0].count < curProduct.getCount()){
                //Check if the count of the product is greater than the root node of the heap
                //Replace the the topmost node
                //make pointer of replaced node -1 and new node 0
                //call min heapify operation
                Product heapTopProduct = prodDetail.get(heapDet[0].id);
                //  heapTopProduct.heapIndex = -1;
                heapTopProduct.setHeapIndex(-1);
                //  prodDetail.put(heapTopProduct.id, heapTopProduct);
                prodDetail.put(heapTopProduct.getId(), heapTopProduct);
                heapDet[0].count = curProduct.getCount();
                //   heapDet[0].id = curProduct.id;
                heapDet[0].id = curProduct.getId();
                //  curProduct.heapIndex = 0;
                curProduct.setHeapIndex(0);
                //   prodDetail.put(curProduct.id, curProduct);
                prodDetail.put(curProduct.getId(), curProduct);
                minHeapify(prodDetail, 0);
            }
        }
    }

    //This function return the most searched products i.e equals to the capacity of heap
    public ArrayList<Integer> getAllMostSearchedProducts(){
        ArrayList<Integer> productList = new ArrayList<>();
        for(int index = 0; index < nodeCount; index++){
            productList.add(heapDet[index].id);
        }
        return productList;
    }

    //This function returns the k most searched products which is passed as parameter
    public ArrayList<Integer> getKMostSearchedProducts(int k){
        //Make a max heap
        PriorityQueue<HeapNode> maxHeap =
                new PriorityQueue<HeapNode>();

        //add all the nodes from min heap to max heap
        for(int index = 0; index < nodeCount; index++){

            HeapNode curHeap = new HeapNode(heapDet[index].id, heapDet[index].count);
            maxHeap.add(curHeap);
        }
        //maxHeap.addAll(products);
        ArrayList<Integer> kMostSearchedProducts = new ArrayList<>();
        int curId;
        //Return the top k most searched products
        for(int i = 0 ; i < k; i++){
            if(!maxHeap.isEmpty()){
                curId = (maxHeap.poll()).id;
                kMostSearchedProducts.add(curId);

            }
        }
        return kMostSearchedProducts;
    }
}

