import java.util.Scanner;

/**
 * This is Book object, which is a product of the store
 * Book have private properties such as
 * 
 * @param pages indicate the number of pages
 * @param isNew indicate the status of the
 */
public class Book extends Product {
    private int pages;
    private boolean isNew;

    /**
     * For book, the @param isNew will decide the grand total of the book.
     * If the book is old it will be discount 30%.
     *
     */
    @Override
    protected double grandTotal() {
        return (isNew ? 1.0 : 1 - 30 / 100) * this.price;
    }

    @Override
    public Product inputProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap id cua loai sach: ");
        this.id = scanner.nextLine();

        System.out.print("Nhap ten cua loai sach: ");
        this.name = scanner.nextLine();
        System.out.print("Nhap gia cua loai sach: ");
        this.price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap nha xuat ban cua loai sach: ");
        this.publisher = scanner.nextLine();
        System.out.print("Nhap nam xuat ban cua loai sach: ");
        this.publishedYear = scanner.nextLong();
        System.out.print("Nhap so trang cua loai sach: ");
        this.pages = scanner.nextInt();
        System.out.print("Nhap tinh trang cua sach (moi: 1, cu: 0): ");
        this.isNew = scanner.nextInt() == 1;
        System.out.print("Nhap so luong cua loai sach: ");
        this.quantity = scanner.nextInt();

        return this;
    }

    @Override
    public String toString() {
        return "Book => "
                + "id = " + this.id
                + ", ten = " + this.name
                + ", gia = " + this.price
                + ", nha xuat ban = " + this.publisher
                + ", nam xuat ban = " + this.publishedYear
                + ", so trang = " + this.pages
                + ", tinh trang = " + (this.isNew ? "Moi" : "Cu")
                + ", so luong = " + this.quantity;
    }
}
