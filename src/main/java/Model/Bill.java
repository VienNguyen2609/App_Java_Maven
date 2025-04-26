
package Model;

import java.util.Date;


public class Bill {
    
    private int billId , userId ,productId , quantity ; 
    private float totalAmount  , price; 
    private Date billDate ; 
    
    private static  boolean isInitiallized = false ; 
    private static Bill instance ; 
    
    public static void init(){
        if(isInitiallized == true){
            return ;
        }
        else{
            instance = new Bill(); 
            isInitiallized = true ; 
        }
    }

    public Bill() { }
    
    
    public Bill(int BillId, int UserId, int ProductId, int Quantity, float TotalAmount, float Price, Date BillDate) {
        this.billId = BillId;
        this.userId = UserId;
        this.productId = ProductId;
        this.quantity = Quantity;
        this.totalAmount = TotalAmount;
        this.price = Price;
        this.billDate = BillDate;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int BillId) {
        this.billId = BillId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int UserId) {
        this.userId = UserId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int ProductId) {
        this.productId = ProductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
        calculateTotalAmount() ; 
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float TotalAmount) {
        this.totalAmount = TotalAmount;
    }

    public float getPrice() {
        return price;
        
    }

    public void setPrice(float Price) {
        this.price = Price;
        calculateTotalAmount() ;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date BillDate) {
        this.billDate = BillDate;
    }

    public static boolean isIsInitiallized() {
        return isInitiallized;
    }

    public static void setIsInitiallized(boolean isInitiallized) {
        Bill.isInitiallized = isInitiallized;
    }

    public static Bill getInstance() {
        return instance;
    }

    public static void setInstance(Bill instance) {
        Bill.instance = instance;
    }
    
     private void calculateTotalAmount() {
        this.totalAmount = this.quantity * this.price;
    }
    
}
