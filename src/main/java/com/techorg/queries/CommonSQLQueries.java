package com.techorg.queries;

public interface CommonSQLQueries {

    String GET_EMPLOYEE_LIST = "select emp.EmployeeId, emp.Name, emp.Email, emp.Designation, dept.Name" +
           " from Employee emp inner join Department dept on emp.DepartmentID = dept.departmentID";

    //String GET_EMPLOYEE_LIST = "select emp.EmployeeId, emp.Name, emp.Email, emp.Designation, dept.Name" +
    //        " from Employee emp left join Department dept on emp.DepartmentID = dept.departmentID";

    //String GET_EMPLOYEE_LIST = "select emp.EmployeeId, emp.Name, emp.Email, emp.Designation, dept.Name" +
    //        " from Employee emp right join Department dept on emp.DepartmentID = dept.departmentID";

    String UPDATE_EMPLOYEE_BY_ID = "Update Employee set DepartmentID = ? where EmployeeID = ?";

    String GET_EMPLOYEE_BY_ID= "select emp.EmployeeId, emp.Name, emp.Email, emp.Designation, dept.Name" +
            " from Employee emp inner join Department dept on emp.DepartmentID = dept.departmentID" +
            " where emp.EmployeeId = ?";

}
