import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager bookManager = null;
    private static ProductManager cdManager = null;
    private static EmployeeManager employeeManager = null;

    public static void main(String[] args) {
        displayMenu();

        scanner.close();
    }

    /**
     * The function that display menu
     * 
     */
    private static void displayMenu() {

        int option = 0;
        do {
            System.out.println("");
            System.out.println(
                    "|======================   DANH SACH CAC TINH NANG CUA CHUONG TRINH  =======================|");
            System.out.println(
                    "|(1) nhap xuat tung loai sach                                                              |");
            System.out.println(
                    "|(2) nhap xuat tung loai cd                                                                |");
            System.out.println(
                    "|(3) tinh thanh tien cho tung loai sach                                                    |");
            System.out.println(
                    "|(4) tinh thanh tien cho tung loai cd                                                      |");
            System.out.println(
                    "|(5) tinh tong so luong khong phan biet CD hay Sach                                        |");
            System.out.println(
                    "|(6) nhap xuat thong tin nhan vien                                                         |");
            System.out.println(
                    "|(7) tinh thu thap hang thang cho tung nhan vien                                           |");
            System.out.println(
                    "|(8) thoat chuong trinh                                                                    |");
            System.out.println(
                    "===========================================================================================|");

            System.out.print("Lua chon: ");
            option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            processOption(option);

        } while (option != 8);

    }

    /** Process the option input and perform valid calculation */
    private static void processOption(int option) {

        switch (option) {
            case 1:
                System.out.println(
                        "======================================   CAU A   ==========================================");
                bookManager = new ProductManager(ProductType.Book);
                break;
            case 2:
                System.out.println(
                        "======================================   CAU B   ==========================================");
                cdManager = new ProductManager(ProductType.CD);
                break;
            case 3:
                System.out.println(
                        "======================================   CAU C   ==========================================");
                if (bookManager == null) {
                    System.out.println("Chua nhap danh sach loai sach");
                } else {
                    bookManager.calculatePriceForEachType();
                }
                break;
            case 4:
                System.out.println(
                        "======================================   CAU D   ==========================================");
                if (cdManager == null) {
                    System.out.println("Chua nhap danh sach CD");
                } else {
                    cdManager.calculatePriceForEachType();
                }
                break;
            case 5:
                System.out.println(
                        "======================================   CAU E   ==========================================");
                if (cdManager != null && bookManager != null) {
                    System.out.println(
                            "Tong thanh tien cho tat ca cac loai san pham da ban ra: " + (bookManager.calculateTotal()
                                    + cdManager.calculateTotal()));
                } else {
                    System.out.println("Chua nhap danh sach sach hoac danh sach cd");
                }
                break;
            case 6:
                System.out.println(
                        "======================================   CAU F   ==========================================");
                employeeManager = new EmployeeManager();
                break;
            case 7:
                System.out.println(
                        "======================================   CAU G   ==========================================");
                if (employeeManager == null) {
                    System.out.println("Chua nhap danh sach nhan vien");
                } else {
                    employeeManager.displaySalaryOfEmployee();
                }

                break;
            default:
        }
    }
}
