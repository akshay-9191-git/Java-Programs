package org.example.employeesalary;

import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    public Employee calculateSalary(Employee employee) {
        double basic = employee.getBasic_salary();
        double allowance = basic * (0.20);
        double deduction = basic * (0.10);
        double net_sal = basic + allowance - deduction;

        employee.setAllowance(allowance);
        employee.setDeduction(deduction);
        employee.setNet_salary(net_sal);

        return employee;
    }
}
