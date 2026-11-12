
package com.example.employee;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeeSalaryCalculatorDemoTest {

    // Test 1: Expected to PASS
    @Test
    void testGrossSalaryPass() {
        assertEquals(39000,
            EmployeeSalaryCalculator.calculateGrossSalary(30000),
            0.01);
    }

    // Test 2: Expected to FAIL intentionally
    @Test
    void testNetSalaryFail() {
        assertEquals(40000,
            EmployeeSalaryCalculator.calculateNetSalary(30000),
            0.01);
    }
}
