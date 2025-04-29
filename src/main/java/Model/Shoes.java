package Model;

public class Shoes {

    private int productId;
    private String productName;
    private int productSize;
    private int productQuantity;
    private float productPrice;
    private String productColor;
    private byte[] productImage;
    private static Shoes instance;
    private static boolean isInitiallized = false;

    public static void Init() {

        if (isInitiallized == true) {
            return;
        } else {
            instance = new Shoes();
            isInitiallized = true;
        }
    }

    public Shoes() {
    }

    public Shoes(int productId, String productName, int productSize, int productQuantity, float productPrice, String productColor, byte[] productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productSize = productSize;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productImage = productImage;
    }

    public Shoes(String productName, int productSize, int productQuantity, float productPrice, String productColor, byte[] productImage) {
        this.productName = productName;
        this.productSize = productSize;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productImage = productImage;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public byte[] getProductAvatar() {
        return productImage;
    }

    public void setProductAvatar(byte[] productAvatar) {
        this.productImage = productAvatar;
    }

    public float getTotalProduct() {
        return getProductPrice() * getProductQuantity();
    }

    @Override
    public String toString() {
        return "Shoes{" + "productName=" + productName + ", ProductColor=" + productColor + ", productId=" + productId + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", productImage=" + productImage + '}';
    }

}
