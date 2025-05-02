package Model;

import java.util.Date;

public class Bill {

    private int billId;
    private int size;
    private int userId;
    private int productId;
    private int quantity;
    private float totalAmount, price;
    private Date billDate;

    private static boolean isInitiallized = false;
    private static Bill instance;

    public static void init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new Bill();
            isInitiallized = true;
        }
    }

    public Bill() {
    }

    public Bill(int BillId, int UserId, int ProductId, int size, int Quantity, float total, float Price, Date BillDate) {
        this.billId = BillId;
        this.userId = UserId;
        this.productId = ProductId;
        this.size = size;
        this.quantity = Quantity;
        this.totalAmount = total;
        this.price = Price;
        this.billDate = BillDate;
    }

    public Bill(int UserId, int ProductId, int size, int Quantity, float Price, Date BillDate) {
        this.userId = UserId;
        this.productId = ProductId;
        this.size = size;
        this.quantity = Quantity;
        this.price = Price;
        this.billDate = BillDate;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
    }

    public float getTotalAmount() {
        return totalAmount = price * quantity;
    }

    public void setTotalAmount(float TotalAmount) {
        this.totalAmount = TotalAmount;
    }

    public float getPrice() {
        return price;

    }

    public void setPrice(float Price) {
        this.price = Price;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date BillDate) {
        this.billDate = BillDate;
    }

}
