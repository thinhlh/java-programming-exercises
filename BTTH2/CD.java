import java.util.Scanner;

/**
 * CD is a product of the store
 * This class has a private property named author
 * 
 * @param author - single
 */
public class CD extends Product {
    private String author;

    /**
     * For cd, the grand total depends on the publishedYear, whether it is before or
     * after 1990
     * 
     * @param publishedYear
     */
    @Override
    protected double grandTotal() {
        return (this.publishedYear < 1990 ? 1.0 : 1 - 10 / 100) * this.price;
    }

    @Override
    public Product inputProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap id cua loai CD: ");
        this.id = scanner.nextLine();
        System.out.print("Nhap ten cua loai CD: ");
        this.name = scanner.nextLine();
        System.out.print("Nhap gia cua loai CD: ");
        this.price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap nha phat hanh cua loai CD: ");
        this.publisher = scanner.nextLine();
        System.out.print("Nhap nam phat hanh cua loai CD: ");
        this.publishedYear = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Nhap ten ca si cua loai CD: ");
        this.author = scanner.nextLine();
        System.out.print("Nhap so luong cua loai CD: ");
        this.quantity = scanner.nextInt();

        return this;
    }

    @Override
    public String toString() {
        return "CD => "
                + "id = " + this.id
                + ", ten = " + this.name
                + ", gia = " + this.price
                + ", nha phat hanh = " + this.publisher
                + ", nam phat hanh = " + this.publishedYear
                + ", ca si = " + this.author
                + ", so luong = " + this.quantity;
    }
}
