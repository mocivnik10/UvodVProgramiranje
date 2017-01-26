import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by iztokmocivnik on 25/01/2017.
 */
public class Physical_worker extends Employee {
    private boolean physically_capable;
    private int techincal_skill;

    public Physical_worker() {
        this.physically_capable = false;
        this.techincal_skill = 1;
    }

    public Physical_worker(String name, String surname, int age, String id, String dateOfEmployment, boolean physically_capable, int techincal_skill) {
        super(id, name, surname, age, dateOfEmployment);
        this.physically_capable = physically_capable;
        this.techincal_skill = techincal_skill;
    }


    // get metodi:
    public boolean getPhysically_capable() {
        return this.physically_capable;
    }

    public int getTechincal_skill() {
        return this.techincal_skill;
    }

    // set metodi
    public void setPhysically_capable(boolean physically_capable) {
        this.physically_capable = physically_capable;
    }

    public void setTechincal_skill(int techincal_skill) {
        this.techincal_skill = techincal_skill;
    }


    public void printData() {
        super.printData();
        System.out.println("Is phisically capable: " + this.getPhysically_capable());
        System.out.println("Technical skill(1-5): " + this.getTechincal_skill());
    }

    public String toString() {
        String description = "";
        description += super.toString();
        description += "Is phisically capable: " + this.getPhysically_capable() + "\n";
        description += "Technical skill(1-5): " + this.getTechincal_skill() + "\n";

        return description;
    }

    public static Physical_worker inputEmployee() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input new Physical worker: ");

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

        System.out.print("Is employee phisically capable for work(yes/no): ");
        boolean pc;
        String capability;
        // Ponavljaj dokler vnesen string ni enak yes ali no
        while (true) {
            capability = input.readLine().toLowerCase();
            if (capability.equals("yes")) {
                pc = true;
                break;
            } else if (capability.equals("no")) {
                pc = false;
                break;
            } else {
                System.out.print("Error! Please input only yes/no: ");
            }
        }

        System.out.print("Rate employee's technical skills(1-5): ");
        int ts = Integer.parseInt(input.readLine());
        // Ponavljaj dokler vneseno stevilo ni med 1 in 5
        while (ts > 5 || ts < 1) {
            System.out.println("Enter the number between 1 and 5!");
            System.out.print("Rate again please: ");
            ts = Integer.parseInt(input.readLine());
        }


        Physical_worker newEmployee = new Physical_worker(name, surname, age, id, date, pc, ts);
        return newEmployee;
    }

    public String saveAsString() {
        String entry = "*P\r\n"; // symbol for start read
        entry += this.getId()  + "\r\n";
        entry += this.getName() + "\r\n";
        entry += this.getSurname() + "\r\n";
        entry += this.getAge() + "\r\n";
        entry += this.getDateOfEmployment() + "\r\n";
        entry += this.physically_capable + "\r\n";
        entry += this.techincal_skill + "\r\n";

        entry += "##\r\n"; // symbol for end read
        return entry;
    }

    public static Physical_worker readString(ArrayList<String> entry) {
        Physical_worker employee= new Physical_worker();

        try {
            employee.setId(entry.get(0));
            employee.setName(entry.get(1));
            employee.setSurname(entry.get(2));
            employee.setAge(Integer.parseInt(entry.get(3)));
            employee.setDateOfEmployment(entry.get(4));
            employee.setPhysically_capable(Boolean.parseBoolean(entry.get(5)));
            employee.setTechincal_skill(Integer.parseInt(entry.get(6)));

            return employee;
        } catch (Exception ex) {
            System.out.println("Error - Reading the string");
            throw ex;
        }
    }

}
