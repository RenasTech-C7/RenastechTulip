package code;

public class orderBookPOJO {
    public String bookId;
    public String customerName;

    public  orderBookPOJO(String bookId, String customerName){
        this.bookId=bookId;
        this.customerName=customerName;
    }
    public  orderBookPOJO(String customerName){
        this.bookId=bookId;
        this.customerName=customerName;
    }
}
