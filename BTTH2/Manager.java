import java.util.Scanner;

/**
 * This is Manager class indicate the employee working as the manager of the
 * store
 * 
 */
public class Manager extends Employee {

    @Override
    public double getSalary() {
        return (this.isOfficial ? 1.5 : 1.2) * baseSalary;
    }

    @Override
    public Employee inputEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap id cua quan ly: ");
        this.id = scanner.nextLine();
        System.out.print("Nhap ten cua quan ly: ");
        this.name = scanner.nextLine();
        System.out.print("Nhap loai hop dong cua quan ly(chinh thuc: 1, thu viec: 0): ");
        this.isOfficial = scanner.nextInt() == 1;

        this.baseSalary = 1500;

        return this;
    }

    @Override
    public String toString() {
        return "Nguoi quan ly => "
                + ", id = " + this.id
                + ", ten = " + this.name
                + ", loai hop dong = " + (this.isOfficial ? "Chinh Thuc" : "Thu Viec")
                + ", thu nhap = " + this.getSalary();
    }
}
