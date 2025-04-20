package Model;

public class Shoes {

    private String productName, ProductColor;
    private int productId, productQuantity;
    private float productPrice;
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

    public Shoes(String productName, int productQuantity, float productPrice, String ProductColor) {
        this(productName, productQuantity, productPrice, ProductColor, null);
    }

    public Shoes(String productName, int productQuantity, float productPrice, String ProductColor, byte[] ProductImage) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.ProductColor = ProductColor;
        this.productImage = ProductImage;
    }

    public Shoes(int productId ,String productName, int productQuantity, float productPrice, String ProductColor, byte[] ProductImage) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.ProductColor = ProductColor;
        this.productImage = ProductImage;
    }
   public Shoes(int productId ,String productName, int productQuantity, float productPrice, String ProductColor) {
        this(productId, productName, productQuantity, productPrice, ProductColor, null);
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return ProductColor;
    }

    public void setProductColor(String ProductColor) {
        this.ProductColor = ProductColor;
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
        return "Shoes{" + "productName=" + productName + ", ProductColor=" + ProductColor + ", productId=" + productId + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", productImage=" + productImage + '}';
    }

    

  

}
