import java.util.Scanner;

/**
 * This is a seller object, which described as an Employee of the store
 * 
 * Seller has some private properties
 * 
 * @param numberOfSoldProduct -> Indicate the number that the employee sold
 * @param kpi                 -> Indicate the kpi of Seller
 */
public class Seller extends Employee {
    private int numberOfSoldProduct;
    private int kpi;

    // The final salary is the combination of temporary salary and the bonus depends
    // on kpi and sold product
    @Override
    public double getSalary() {
        return tempSalary() + bonusOnKpi();
    }

    private double tempSalary() {
        return isOfficial ? (1.0 * baseSalary) : (0.7 * baseSalary + 100);
    }

    private double bonusOnKpi() {
        final double tempSalary = tempSalary();
        final double soldProductOnKpi = numberOfSoldProduct / kpi;
        double result = 0.0;

        if (soldProductOnKpi == 0) {
            result = tempSalary;
        } else if (soldProductOnKpi > 0 && soldProductOnKpi <= 0.5) {
            result = tempSalary + 150;
        } else if (soldProductOnKpi > 0.5 && soldProductOnKpi <= 0.8) {
            result = tempSalary + 300;
        } else if (0.8 < numberOfSoldProduct && numberOfSoldProduct <= 0.9) {
            result = tempSalary + 450;
        } else {
            result = tempSalary + 550;
        }

        return result;
    }

    @Override
    public Employee inputEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap id cua nguoi ban: ");
        this.id = scanner.nextLine();
        System.out.print("Nhap ten cua nguoi ban: ");
        this.name = scanner.nextLine();
        System.out.print("Nhap loai hop dong cua nguoi ban(chinh thuc: 1, thu viec: 0): ");
        this.isOfficial = scanner.nextInt() == 1;
        System.out.print("Nhap so luong san pham ban duoc: ");
        this.numberOfSoldProduct = scanner.nextInt();
        System.out.print("Nhap kpi: ");
        this.kpi = scanner.nextInt();

        this.baseSalary = 1000;

        return this;
    }

    @Override
    public String toString() {
        return "Nguoi ban hang => "
                + ", id = " + this.id
                + ", ten = " + this.name
                + ", loai hop dong = " + (this.isOfficial ? "Chinh Thuc" : "Thu Viec")
                + ", thu nhap = " + this.getSalary()
                + ", kpi = " + this.kpi
                + ", so luong san pham ban duoc = " + this.numberOfSoldProduct;
    }

}
