import java.util.Scanner;

public class EmployeeManager {
    final int numberOfEmployee;
    Employee[] employees;

    public EmployeeManager() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong nhan vien: ");
        this.numberOfEmployee = scanner.nextInt();
        employees = new Employee[numberOfEmployee];

        for (int i = 0; i < employees.length; i++) {
            System.out.println("##### Nhap thong tin nhan vien thu " + (i + 1) + " #####");
            System.out.print("Nhap chuc vu cua nhan vien (nguoi ban hang: 1, quan ly: 0): ");
            final EmployeeType employeeType = scanner.nextInt() == 1 ? EmployeeType.Seller : EmployeeType.Manager;
            employees[i] = Employee.createEmployee(employeeType);
        }

        displayEmployee();
    }

    private void displayEmployee() {
        System.out.println("\n+++++ THONG TIN TUNG NHAN VIEN +++++");
        for (int i = 0; i < employees.length; i++) {
            System.out.println("##### Thong tin san pham thu " + (i + 1) + " #####");
            System.out.println(employees[i]);
        }
    }

    public void displaySalaryOfEmployee() {
        System.out.println("\n+++++ LUONG MOI THANG CUA NHAN VIEN +++++");
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Luong moi thang cua nhan vien " + (i + 1) + "= " + employees[i].getSalary());
        }
    }

}
