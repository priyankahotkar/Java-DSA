import java.io.*;
import java.util.*;

class Employee {
    String id;
    String name;
    double hourlyWage;
    double hoursWorked;

    public Employee(String id, String name, double hourlyWage, double hoursWorked) {
        this.id = id;
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculateMonthlySalary() {
        return hourlyWage * hoursWorked * 30; // Assuming 30 days in a month
    }
}

public class SalaryCalculator {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "salaries.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write("ID Name HourlyWage HoursWorked MonthlySalary\n");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");
                if (data.length == 4) {
                    String id = data[0];
                    String name = data[1];
                    double hourlyWage = Double.parseDouble(data[2]);
                    double hoursWorked = Double.parseDouble(data[3]);
                    Employee e = new Employee(id, name, hourlyWage, hoursWorked);
                    writer.write(line+" "+Double.toString(e.calculateMonthlySalary()));
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
