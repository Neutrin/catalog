package Product;

public class Product {
    private int Id;
    private String Name;
    private  String Desc;
    private int HeapIndex;
    private  int Count;

    public Product(String name, String Desc, int id){
        this.Name = name;
        this.Desc = Desc;
        this.Count = 0;
        HeapIndex = -1;
        this.Id = id;
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
    }

}

