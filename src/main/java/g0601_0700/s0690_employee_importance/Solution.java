package g0601_0700.s0690_employee_importance;

// #Medium #Hash_Table #Depth_First_Search #Breadth_First_Search

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

import com_github_leetcode.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return calculateImportance(id, map);
    }

    private int calculateImportance(int id, Map<Integer, Employee> map) {
        Employee employee = map.get(id);
        int sum = employee.importance;
        for (int sub : employee.subordinates) {
            sum += calculateImportance(sub, map);
        }
        return sum;
    }
}
