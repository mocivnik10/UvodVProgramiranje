import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by iztokmocivnik on 25/01/2017.
 */
public class Employee {
    private String id;
    private String name;
    private String surname;
    private int age;
    private String dateOfEmployment;

    public Employee() {
        this.id = "unknown";
        this.name = "unknown";
        this.surname = "unknown";
        this.age = 0;
        this.dateOfEmployment = "";
    }

    public Employee(String id, String name, String surname, int age, String dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateOfEmployment = dateOfEmployment;
    }


    // get metode:
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public int getAge() {
        return this.age;
    }
    public String getDateOfEmployment() {
        return this.dateOfEmployment;
    }

    // set metode:
    public void setId(String newId) {
        this.id = newId;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public void setDateOfEmployment(String date) {
        this.dateOfEmployment = date;
    }

    public void printData() {
        System.out.println("*** Employee data ***");
        System.out.println("Full name: " + this.getName() + ", " + this.getSurname());
        System.out.println("ID number: " + this.getId());
        System.out.println("Age: " + this.getAge());
        System.out.println("Date of employment: " + this.getDateOfEmployment());
    }

    public String toString() {
        String description = "";
        description += "Full name: " + this.getName() + ", " + this.getSurname() + "\n";
        description += "ID number: " + this.getId() + "\n";
        description += "Age: " + this.getAge() + "\n";
        description += "Date of employment: " + this.getDateOfEmployment() + "\n";

        return description;
    }

    public boolean equals(Object employee2) {
        if (this.id == ((Employee)employee2).id) {
            return true;
        } else {
            return false;
        }
    }

    public static Employee inputEmployee() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input new Employee: ");

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
        while (!isValidDate(date)) {
            System.out.println("Inputed date format is incorrect");
            System.out.print("Please enter the correct format((DD/MM/YYYY)): ");
            date = input.readLine();
        }

        Employee newEmployee = new Employee(id, name, surname, age, date);
        return newEmployee;
    }

    public String saveAsString() {
        String entry = "*E\r\n"; // symbol for start read
        entry += this.id  + "\r\n";
        entry += this.name + "\r\n";
        entry += this.surname + "\r\n";
        entry += this.age + "\r\n";
        entry += this.dateOfEmployment + "\r\n";

        entry += "##\r\n"; // symbol for end read
        return entry;
    }

    public static Employee readString(ArrayList<String> entry) {
        Employee employee = new Employee();

        try {
            employee.setId(entry.get(0));
            employee.setName(entry.get(1));
            employee.setSurname(entry.get(2));
            employee.setAge(Integer.parseInt(entry.get(3)));
            employee.setDateOfEmployment(entry.get(4));

            return employee;
        } catch (Exception ex) {
            System.out.println("Error - Reading the string");
            throw ex;
        }
    }


    //Metoda za preverjanje vnesenega datuma
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }


}
