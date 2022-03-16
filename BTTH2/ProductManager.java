
import java.util.Scanner;

public class ProductManager {
    // So loai san pham nguoi dung se nhap vao
    private int numberOfType;

    private Product[] products;

    public ProductManager(ProductType productType) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so loai san pham " + (productType == ProductType.Book ? "sach" : "cd") + ": ");
        this.numberOfType = scanner.nextInt();
        products = new Product[numberOfType];

        for (int i = 0; i < products.length; i++) {
            System.out.println("##### Nhap thong tin san pham thu " + (i + 1) + " #####");
            products[i] = Product.createProduct(productType);
        }
        displayProducts();
    }

    private void displayProducts() {
        System.out.println("\n+++++ THONG TIN TUNG LOAI SAN PHAM +++++");
        for (int i = 0; i < products.length; i++) {
            System.out.println("##### Thong tin san pham thu " + (i + 1) + " #####");
            System.out.println(products[i]);
        }
    }

    public void calculatePriceForEachType() {
        for (Product product : products) {
            System.out.println("San pham " + product.name + " co gia la: " + product.grandTotal());
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.grandTotal();
        }

        return total;
    }
}
