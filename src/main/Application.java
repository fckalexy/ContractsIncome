package main;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the department: ");
        Department department = new Department(input.nextLine());

        System.out.println();

        System.out.println(" -> ENTER WORKER DATA");

        System.out.print("Name: ");
        String workerName = input.nextLine();
        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(input.next());
        System.out.print("Base Salary: ");
        Double workerBaseSalary = input.nextDouble();

        Worker worker = new Worker(workerName, workerLevel, workerBaseSalary, department);

        System.out.println();

        System.out.print("Number of contracts: ");
        int numberOfContracts = input.nextInt();

        System.out.println();

        for (int i=1; i<= numberOfContracts; i++) {

            System.out.println(" -> Contract Data #" + i);

            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate contractDate = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();

            System.out.print("Duration (hours): ");
            int duration = input.nextInt();

            worker.addContract(new HourContract(contractDate, valuePerHour, duration));

            System.out.println();

        }

        DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder().appendPattern("MM/yyyy").parseDefaulting(ChronoField.DAY_OF_MONTH, 1);

        System.out.print("Enter the month and year to calculate the total income (MM/yyyy): ");
        LocalDate contractIncome = LocalDate.parse(input.next(), formatterBuilder.toFormatter());

        System.out.println();

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + department.getName());
        System.out.println("Total income: " + worker.income(contractIncome));

        input.close();

    }

}
