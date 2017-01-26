import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by iztokmocivnik on 25/01/2017.
 */
public class UserInterface {

    public static void main(String[] args) throws Exception {
        System.out.println("***Welcome to our program****");

        Company company = new Company();

        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press (a) for input the employee");
            System.out.println("Press (p) for print out the employees");
            System.out.println("Press (s) for save the employees to folder");
            System.out.println("Press (r) for add the employees from folder");
            System.out.println("Press (g) for search");
            System.out.println("Press (x) for exit");
            String inputedString;


            try {
                inputedString= input.readLine();
                char choice = inputedString.toLowerCase().charAt(0);

                switch (choice) {
                    case 'a':
                        System.out.println("For which department would you like to input employee data: (P - Phisycall workers, O - Office workers, R - Research workers)");
                        choice = input.readLine().toLowerCase().charAt(0);
                        Employee newEmployee = null;
                        String notification;
                        switch (choice) {
                            case 'p':
                                newEmployee = Physical_worker.inputEmployee();
                                break;
                            case 'o':
                                newEmployee = Office_worker.inputEmployee();
                                break;
                            case 'r':
                                newEmployee = Research_worker.inputEmployee();
                                break;
                            default:
                                newEmployee = Employee.inputEmployee();
                                break;
                        }
                        notification = company.addEmployee(newEmployee);
                        if(notification.length() > 0)
                            System.out.println(notification);
                        else
                            System.out.println(newEmployee.toString());
                        break;
                    case 'p':
                        System.out.println(company.toString());
                        break;
                    case 's':
                        System.out.print("Enter the folder name: ");
                        String saveFolder = input.readLine();
                        company.saveToFolder(saveFolder);
                        System.out.println("Successfully saved to folder: " + saveFolder);
                        break;
                    case 'r':
                        System.out.print("Enter the folder name: ");
                        String readFolder = input.readLine();
                        company.addFromFolder(readFolder);
                        System.out.println("Employees were successfully added from folder: " + readFolder);
                        break;
                    case 'g':
                        System.out.println("For which department do you wish data: (P - Physical workers, O - Office workers, R - Research workers)");
                        String inputChoice = input.readLine();
                        char searchChoice = inputChoice.toLowerCase().charAt(0);
                        System.out.println(company.searchForSpecificDepartment(searchChoice));
                        break;
                    case 'x':
                        System.out.println("Exiting the program...");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error - Please try again!");
            }
        }

    }
}
