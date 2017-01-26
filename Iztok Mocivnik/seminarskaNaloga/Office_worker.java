import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by iztokmocivnik on 25/01/2017.
 */
public class Office_worker extends Employee {
    private boolean thrive_under_pressure;
    private int communication_skill;

    public Office_worker() {
        this.thrive_under_pressure = false;
        this.communication_skill = 1;
    }

    public Office_worker(String name, String surname, int age, String id, String dateOfEmployment, boolean thrive_under_pressure, int communication_skill) {
        super(id, name, surname, age, dateOfEmployment);
        this.thrive_under_pressure = thrive_under_pressure;
        this.communication_skill = communication_skill;
    }

    // get metodi:
    public boolean getThrive_under_pressure() {
        return this.thrive_under_pressure;
    }
    public int getCommunication_skill() {
        return this.communication_skill;
    }

    // set metodi
    public void setThrive_under_pressure(boolean thrive_under_pressure) {
        this.thrive_under_pressure = thrive_under_pressure;
    }
    public void setCommunication_skill(int communication_skill) {
        this.communication_skill = communication_skill;
    }


    public void printData() {
        super.printData();
        System.out.println("Thrive under pressuer(yes/no): " + this.getThrive_under_pressure());
        System.out.println("Communication skills(1-5): " + this.getCommunication_skill());
    }

    public String toString() {
        String description = "";
        description += super.toString();
        description += "Thrive under pressuer: " + this.getThrive_under_pressure() + "\n";
        description += "Communication skills(1-5): " + this.getCommunication_skill() + "\n";

        return description;
    }

    public static Office_worker inputEmployee() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input new Office worker: ");

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

        System.out.print("Is employee thrive under the pressure well(yes/no): ");
        boolean tup;
        String pressure;
        // Ponavljaj dokler vnesen string ni enak yes ali no
        while (true) {
            pressure = input.readLine().toLowerCase();
            if (pressure.equals("yes")) {
                tup = true;
                break;
            } else if (pressure.equals("no")) {
                tup = false;
                break;
            } else {
                System.out.print("Error! Please input only yes/no: ");
            }
        }

        System.out.print("Rate employee's communication skills(1-5): ");
        int cs = Integer.parseInt(input.readLine());
        // Ponavljaj dokler vneseno stevilo ni med 1 in 5
        while (cs > 5 || cs < 1) {
            System.out.println("Enter the number between 1 and 5!");
            System.out.print("Rate again please: ");
            cs = Integer.parseInt(input.readLine());
        }


        Office_worker newEmployee = new Office_worker(name, surname, age, id, date, tup, cs);
        return newEmployee;
    }

    public String saveAsString() {
        String entry = "*O\r\n"; // symbol for start read
        entry += this.getId()  + "\r\n";
        entry += this.getName() + "\r\n";
        entry += this.getSurname() + "\r\n";
        entry += this.getAge() + "\r\n";
        entry += this.getDateOfEmployment() + "\r\n";
        entry += this.thrive_under_pressure + "\r\n";
        entry += this.communication_skill + "\r\n";

        entry += "##\r\n"; // symbol for end read
        return entry;
    }

    public static Office_worker readString(ArrayList<String> entry) {
        Office_worker employee= new Office_worker();

        try {
            employee.setId(entry.get(0));
            employee.setName(entry.get(1));
            employee.setSurname(entry.get(2));
            employee.setAge(Integer.parseInt(entry.get(3)));
            employee.setDateOfEmployment(entry.get(4));
            employee.setThrive_under_pressure(Boolean.parseBoolean(entry.get(5)));
            employee.setCommunication_skill(Integer.parseInt(entry.get(6)));

            return employee;
        } catch (Exception ex) {
            System.out.println("Error - Reading the string");
            throw ex;
        }
    }


}
