import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by iztokmocivnik on 25/01/2017.
 */
public class Research_worker extends Employee {
    private String education;
    private int analytic_skill;

    public Research_worker() {
        this.education = "";
        this.analytic_skill = 1;
    }

    public Research_worker(String name, String surname, int age, String id, String dateOfEmployment,String education, int analytic_skill) {
        super(id, name, surname, age, dateOfEmployment);
        this.education = education;
        this.analytic_skill = analytic_skill;
    }

    // get metodi
    public String getEducation() {
        return this.education;
    }
    public int getAnalytic_skill() {
        return this.analytic_skill;
    }

    // set metodi
    public void setEducation(String education) {
        this.education = education;
    }
    public void setAnalytic_skill(int analytic_skill) {
        this.analytic_skill = analytic_skill;
    }


    public void printData() {
        super.printData();
        System.out.println("Education: " + this.getEducation());
        System.out.println("Analytic skills(1-5): " + this.getAnalytic_skill());
    }

    public String toString() {
        String description = "";
        description += super.toString();
        description += "Education: " + this.getEducation() + "\n";
        description += "Analytic skills(1-5): " + this.getAnalytic_skill() + "\n";

        return description;
    }

    public static Research_worker inputEmployee() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input new Research worker: ");

        System.out.print("First name: ");
        String name = input.readLine();

        System.out.print("Last name: ");
        String surname = input.readLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(input.readLine());

        System.out.print("Company ID number: ");
        String id = input.readLine();

        System.out.print("Date of employment(DD/MM/YYYY): ");
        String date = input.readLine();
        // Ponavljaj dokler vnesen format ni enak DD/MM/YYYY - Preverja metoda isValidDate v classu Employee
        while (!isValidDate(date)) {
            System.out.println("Inputed date format is incorrect");
            System.out.print("Please enter the correct format((DD/MM/YYYY)): ");
            date = input.readLine();
        }

        System.out.print("Employee education: ");
        String education = input.readLine();

        System.out.print("Rate employee's analytical skills(1-5): ");
        int as = Integer.parseInt(input.readLine());
        // Ponavljaj dokler vneseno stevilo ni med 1 in 5
        while (as > 5 || as < 1) {
            System.out.println("Enter the number between 1 and 5!");
            System.out.print("Rate again please: ");
            as = Integer.parseInt(input.readLine());
        }


        Research_worker newEmployee = new Research_worker(name, surname, age, id, date, education, as);
        return newEmployee;
    }

    public String saveAsString() {
        String entry = "*R\r\n"; // symbol for start read
        entry += this.getId()  + "\r\n";
        entry += this.getName() + "\r\n";
        entry += this.getSurname() + "\r\n";
        entry += this.getAge() + "\r\n";
        entry += this.getDateOfEmployment() + "\r\n";
        entry += this.education + "\r\n";
        entry += this.analytic_skill + "\r\n";

        entry += "##\r\n"; // symbol for end read
        return entry;
    }

    public static Research_worker readString(ArrayList<String> entry) {
        Research_worker employee= new Research_worker();

        try {
            employee.setId(entry.get(0));
            employee.setName(entry.get(1));
            employee.setSurname(entry.get(2));
            employee.setAge(Integer.parseInt(entry.get(3)));
            employee.setDateOfEmployment(entry.get(4));
            employee.setEducation(entry.get(5));
            employee.setAnalytic_skill(Integer.parseInt(entry.get(6)));

            return employee;
        } catch (Exception ex) {
            System.out.println("Error - Reading the string");
            throw ex;
        }
    }
}
