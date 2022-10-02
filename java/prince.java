package PrinceTest;

public class Department {
    
    int deptNo;
    String deptName;
    String deptHead;
    
    public Department(int deptNo, String deptName, String deptHead) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptHead = deptHead;
    }
    
    public void printDeptDetails() {
        System.out.println(deptNo);
        System.out.println(deptName);
        System.out.println(deptHead);
    }
    
}
package PrinceTest;

public class Hostel {
    String hostelName;
    String hostelLocation;
    int numOfRooms;
    
    public Hostel(String hostelName, String hostelLocation, int numOfRooms) {
        this.hostelName = hostelName;
        this.hostelLocation = hostelLocation;
        this.numOfRooms = numOfRooms;
    }
    
    public void printHostelDetails() {
        System.out.println(hostelName);
        System.out.println(hostelLocation);
        System.out.println(numOfRooms);
    }
    
}
package PrinceTest;

import java.util.*;

public class Student extends Hostel{
    
    int rollNo;
    String studentName;
    String Branch;
    int num_CoreCourses;
    int num_ElectiveCourses;
    
    public Student(String hostelName, String hostelLocation, int numOfRooms) {
        super(hostelName, hostelLocation, numOfRooms);
    }
    
    public void setBranch(String Branch) {
        this.Branch = Branch;
    }
    
    public void setNum_CoreCourses(int num_CoreCourses) {
        this.num_CoreCourses = num_CoreCourses;
    }
    
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    
    public void setNum_ElectiveCourses(int num_ElectiveCourses) {
        this.num_ElectiveCourses = num_ElectiveCourses;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public void check() {
        while(num_CoreCourses+num_ElectiveCourses>8) {
            System.out.println("Enter Core Courses and Elective courses again..");
            Scanner s = new Scanner(System.in);
            this.num_CoreCourses = s.nextInt();
            this.num_ElectiveCourses = s.nextInt();
        }
    }
    
    public void print() {
        check();
        super.printHostelDetails();
        System.out.println(rollNo);
        System.out.println(studentName);
        System.out.println(Branch);
        System.out.println(num_CoreCourses);
        System.out.println(num_ElectiveCourses);
    }
    
}
package PrinceTest;

import java.util.*;
public class PrinceSinghYadav{

    public static void main(String[] args) {
        Student s1 = new Student("hostelName", "hostelLocation", 200);

        s1.Branch = "CSE";
        s1.hostelLocation = "Location";
        s1.hostelName = "Name";
        s1.num_CoreCourses = 5;
        s1.num_ElectiveCourses = 5;
        s1.rollNo = 123;
        s1.print();
    }
    
}