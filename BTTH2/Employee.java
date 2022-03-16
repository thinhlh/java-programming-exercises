/**
 * This is the base class for employee in the store.
 * 
 * This class has some special property
 * 
 * @param isOfficial indicate the type of contract whether this employee or
 *                   official(true) or trial(false)
 * 
 * @param position   does not need to be stored via object's property because it
 *                   will be depicted via the polymorphism and inheritance
 *                   whether this employee is Seller or Manager
 * 
 * @param salary     indicate the salary of employee and it will be initialized
 *                   via the constructor of children
 * 
 *                   Seller -> salary = 1000
 *                   Manager -> salary = 1500
 * 
 */
public abstract class Employee {
    protected String id;
    protected String name;
    protected boolean isOfficial;
    protected int baseSalary;

    /**
     * Get the salary of employee depends on the position of each employee
     */
    public abstract double getSalary();

    public abstract Employee inputEmployee();

    public abstract String toString();

    /**
     * Similar to Product, we use factory method to inistantiate an employee
     * 
     * @param employeeType
     */
    public static Employee createEmployee(EmployeeType employeeType) {
        Employee employee;
        if (employeeType == EmployeeType.Seller) {
            employee = new Seller();
        } else {
            employee = new Manager();
        }

        return employee.inputEmployee();
    }
}
