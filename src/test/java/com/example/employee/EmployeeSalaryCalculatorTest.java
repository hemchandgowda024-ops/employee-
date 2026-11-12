
package com.example.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmployeeSalaryCalculatorTest {

    // Test 1: HRA calculation
    @Test
    void testHRA() {
        assertEquals(6000,
            EmployeeSalaryCalculator.calculateHRA(30000), 0.01);
    }

    // Test 2: DA calculation
    @Test
    void testDA() {
        assertEquals(3000,
            EmployeeSalaryCalculator.calculateDA(30000), 0.01);
    }

    // Test 3: Gross salary calculation
    @Test
    void testGrossSalary() {
        assertEquals(39000,
            EmployeeSalaryCalculator.calculateGrossSalary(30000), 0.01);
    }

    // Test 4: PF deduction calculation
    @Test
    void testDeduction() {
        assertEquals(3800,
            EmployeeSalaryCalculator.calculateDeduction(30000), 0.01);
    }

    // Test 5: Net salary calculation
    @Test
    void testNetSalary() {
        assertEquals(35200,
            EmployeeSalaryCalculator.calculateNetSalary(30000), 0.01);
    }

    // Test 6: Zero salary boundary
    @Test
    void testZeroSalary() {
        assertEquals(0,
            EmployeeSalaryCalculator.calculateNetSalary(0), 0.01);
    }

    // Test 7: Negative salary
    @Test
    void testNegativeSalary() {
        assertThrows(IllegalArgumentException.class, () ->
            EmployeeSalaryCalculator.calculateNetSalary(-5000));
    }

    // Test 8: Invalid NaN salary
    @Test
    void testNaNSalary() {
        assertThrows(IllegalArgumentException.class, () ->
            EmployeeSalaryCalculator.calculateHRA(Double.NaN));
    }

    // Test 9: Infinite salary
    @Test
    void testInfiniteSalary() {
        assertThrows(IllegalArgumentException.class, () ->
            EmployeeSalaryCalculator.calculateDA(Double.POSITIVE_INFINITY));
    }

    // Test 10: Small positive salary
    @Test
    void testSmallSalary() {
        assertEquals(-198.82,
            EmployeeSalaryCalculator.calculateNetSalary(1), 0.01);
    }
}
