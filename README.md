
<div style="margin-bottom:100px">
<a href="https://broadwayinfosys.com/">
<img src="https://3.imimg.com/data3/XM/QN/MY-9237150/employee-management-system-500x500.jpg" alt="Employee Management System" align="center" height="200" >
</a>

## **Table of Contents**
  - [**Employee Management System**](#employee-management-system)
  - [**Requirements Analysis**](#requirements-analysis)
  - [**Design Pattern**](#design-pattern)

## **Employee Management System**
Here, this website helps to manage the employee and department record. It is usually used in organization purpose. It is made on Spring Tool Suite(STS) IDE, MVC design pattern, thymeleaf is used for better view, bootstrap for design and sqlyog for data storage.


## **Requirements Analysis**

Summarizing all the user requirements we can conclude the following measures as the actual user requirements. According
to client requirements we must create an inventory application with following requirements:

1. __User__
    1. Register, login
1. __Department__
    1. add, update, delete, list and view Department
    2. department list
1. __Employee__
    1. add, update, delete, list and view Employee
    1. Employee detail

Briefing out the requirements, I will be creating an website which can store details of employee, department.

## **Design Pattern**
In order to implement a model I have used MVC template. 
1. Create a pojo file. give annotation like @Entity, @Data, @Table
2. Map the pojo file to database (JPA repository)
3. Make a repository
4. Make an interface
5. Make an implementation class for implementing interface abstract method
6. Make a controller where getMapping and postMapping are done
7. Finally, make view(html template)


