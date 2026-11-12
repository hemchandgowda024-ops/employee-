
package com.example.employee;

import java.util.Scanner;

public class EmployeeSalaryCalculator {

    public static double calculateHRA(double basic) {
        validateSalary(basic);
        return basic * 0.20;
    }

    public static double calculateDA(double basic) {
        validateSalary(basic);
        return basic * 0.10;
    }

    public static double calculatePF(double basic) {
        validateSalary(basic);
        return basic * 0.12;
    }

    public static double calculateGrossSalary(double basic) {
        validateSalary(basic);

        return basic + calculateHRA(basic)
                     + calculateDA(basic);
    }

    public static double calculateDeduction(double basic) {
        validateSalary(basic);

        double pf = calculatePF(basic);
        double professionalTax = basic > 0 ? 200 : 0;

        return pf + professionalTax;
    }

    public static double calculateNetSalary(double basic) {
        validateSalary(basic);

        return calculateGrossSalary(basic)
                - calculateDeduction(basic);
    }

    public static void validateSalary(double basic) {
        if (!Double.isFinite(basic) || basic < 0) {
            throw new IllegalArgumentException(
                "Salary cannot be negative or invalid"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        try {
            validateSalary(basic);

            double hra = calculateHRA(basic);
            double da = calculateDA(basic);
            double gross = calculateGrossSalary(basic);
            double deduction = calculateDeduction(basic);
            double net = calculateNetSalary(basic);

            System.out.println("\n----- EMPLOYEE SALARY DETAILS -----");

            System.out.println("Basic Salary: " + basic);
            System.out.println("HRA: " + hra);
            System.out.println("DA: " + da);
            System.out.println("Gross Salary: " + gross);
            System.out.println("Total Deduction: " + deduction);
            System.out.println("Net Salary: " + net);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
