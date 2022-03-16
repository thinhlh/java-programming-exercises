
/**
 * The base class for all Product in the store
 */
public abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected String publisher;
    protected long publishedYear;
    protected int quantity;

    /**
     * This is the function to calculate the final price of a product
     */
    protected abstract double grandTotal();

    public abstract Product inputProduct();

    public abstract String toString();

    /**
     * We will use factory method here
     * We will create a product depends on the type we input
     * For further enhancement, if we have more product, it will just need to
     * implement this and call input Product
     */
    public static Product createProduct(ProductType productType) {
        Product result;
        if (productType == ProductType.Book) {
            result = new Book();
        } else {
            result = new CD();
        }

        return result.inputProduct();
    }
}
