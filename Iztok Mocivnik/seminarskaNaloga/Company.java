import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by iztokmocivnik on 25/01/2017.
 */
public class Company {
    private ArrayList<Employee> employees;

    public Company() {
        employees = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public String addEmployee(Employee employee) {
        boolean IdExist = false;

        for (Employee e : this.employees) {
            if (e.getId().equals(employee.getId())) {
                IdExist = true;
                break;
            }
        }

        if (!IdExist) {
            this.employees.add(employee);
        } else {
            return "The employee with the same id is already exists";
        }
        return "";
    }

    public String toString() {
        String description = "";

        if (this.employees.size() > 0) {
            description += "Employees working for the company: \n\n";
            for (int i = 0; i < employees.size(); i++) {
                description += this.employees.get(i).toString() + "\n";
            }
        } else {
            description += "The company doesn't have any employees at the moment. \n";
        }
        return description;
    }

    public void saveToFolder(String folderName) throws Exception {
        FileWriter fw = new FileWriter(folderName, true);
        PrintWriter folder = new PrintWriter(fw);

        for (Employee employee : this.employees) {
            folder.print(employee.saveAsString());
        }
        folder.close();
    }

    public void addFromFolder(String folderName) throws Exception {
        FileReader fr = new FileReader(folderName);
        BufferedReader folder = new BufferedReader(fr);

        ArrayList<String> employeeData;
        while (folder.ready()) {
            String line = folder.readLine().trim().toUpperCase();
            if (line.equals("*E")) {
                employeeData = new ArrayList<String>();
                while (folder.ready() && !line.equals("##")) {
                    line = folder.readLine().trim();
                    employeeData.add(line);
                }

                Employee newEmployee = Employee.readString(employeeData);
                if (!is_existingId(newEmployee)) {
                    this.employees.add(newEmployee);
                }
            } else if (line.equals("*P")) {
                employeeData = new ArrayList<String>();
                while (folder.ready() && !line.equals("##")) {
                    line = folder.readLine().trim();
                    employeeData.add(line);
                }

                Physical_worker newEmployee = Physical_worker.readString(employeeData);
                if (!is_existingId(newEmployee)) {
                    this.employees.add(newEmployee);
                }
            } else if (line.equals("*O")) {
                employeeData = new ArrayList<String>();
                while (folder.ready() && !line.equals("##")) {
                    line = folder.readLine().trim();
                    employeeData.add(line);
                }

                Office_worker newEmployee = Office_worker.readString(employeeData);
                if (!is_existingId(newEmployee)) {
                    this.employees.add(newEmployee);
                }
            } else if (line.equals("*R")) {
                employeeData = new ArrayList<String>();
                while (folder.ready() && !line.equals("##")) {
                    line = folder.readLine().trim();
                    employeeData.add(line);
                }

                Research_worker newEmployee = Research_worker.readString(employeeData);
                if (!is_existingId(newEmployee)) {
                    this.employees.add(newEmployee);
                }
            }
        }
        folder.close();
    }

    private boolean is_existingId(Employee employee) {
        boolean exists = false;
        for (Employee e : this.employees) {
            if (e.getId().equals(employee.getId())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public String searchForSpecificDepartment(char choice) {
        String output = "";
        ArrayList<Employee> employees = this.getEmployees();
        boolean isAny = false;
        switch (choice) {
            case 'p':
                output += "Physical workers in company: \n\n";
                for (Employee e : employees) {
                    if (e instanceof Physical_worker) {
                        output += e.toString();
                        isAny = true;
                    }
                }
                break;
            case 'o':
                output += "Office workers in company: \n\n";
                for (Employee e : employees) {
                    if (e instanceof Office_worker) {
                        output += e.toString();
                        isAny = true;
                    }
                }
                break;
            case 'r':
                output += "Research workers in company \n\n";
                for (Employee e : employees) {
                    if (e instanceof Research_worker) {
                        output += e.toString();
                        isAny = true;
                    }
                }
                break;
        }


        if (!isAny) {
            return "Currently none of the employees work as " + output;
        } else {
            return output;
        }
    }
}
