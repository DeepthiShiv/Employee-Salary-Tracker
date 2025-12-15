import java.util.Scanner;
import java.util.ArrayList;
class Employee{
    int id;
    String name;
    double salary;
    
    Employee(int id, String name, double salary){
        this.id= id;
        this.name= name;
        this.salary= salary;
    }
    double calculateBonus(){
         if (salary >= 80000)
            return 0.10 * salary;
        else if (salary >= 50000)
            return 0.07 * salary;
        else
            return 0.05 * salary;
    }
    double getTotalSalary(){
        return salary+calculateBonus();
    }
}

class EmployeeSalaryTracker{
    static Scanner sc= new Scanner(System.in);
    static ArrayList<Employee> employees= new ArrayList<>();
   
    public static void main(String args[]){
        while(true){
            System.out.println("\n--Employee Salary Tracker--");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Display All Employees");
            System.out.println("4. Identify Underpaid Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: updateEmployeeSalary(); break;
                case 3: displayEmployees(); break;
                case 4: underpaidEmployees(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
    static void addEmployee(){
        System.out.print("Enter Employee ID: ");
        int id= sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Employee Name: ");
        String name= sc.nextLine();
        
        System.out.print("Enter Employee Salary: ");
        double salary= sc.nextDouble();
        
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }
    static void updateEmployeeSalary(){
        System.out.print("Enter Employee ID: ");
        int id= sc.nextInt();
        for(Employee e: employees){
            if(e.id==id){
                System.out.print("enter salary: ");
                e.salary= sc.nextDouble();
                System.out.println("salary updated successfully");
                return;
            }
        }
        System.out.print("Employee not found!");
    }
    static void displayEmployees(){
        System.out.print("\nID Name Salary Bonus Total_Salary\n");
        for(Employee e: employees){
            System.out.println(
                e.id+" "+e.name+" "+
                e.salary+" "+
                e.calculateBonus()+" "+
                e.getTotalSalary());
        }
    }
    static void underpaidEmployees(){
        System.out.println("\n--Underpaid Employees (<30000)--");
        for(Employee e: employees){
            if(e.salary<30000){
                System.out.println(e.id+" "+e.name+" "+e.salary);
            }
        }
    }
}
