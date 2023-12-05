package edu.cscc;

import java.util.Arrays;
import java.util.Comparator;

/**Sort students based on specific fields
 * @author Margaret Riordan
 */

public class Main {

    public static void main(String[] args) {
        Student[] students = TestData.createStudents();
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                String lastname1 = s1.getLastName();
                String lastname2 = s2.getLastName();
                return lastname1.compareTo(lastname2);
            }
        });
        printStudentList("Students Sorted By LastName", students);

        // TODO - sort students by major
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                String s1major = s1.getMajor();
                String s2major = s2.getMajor();
                return s1major.compareTo(s2major);

            }
        });
        printStudentList("Students Sorted By Major", students);

        // TODO - sort students by zip code
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int s1zip = s1.getZipcode();
                int s2zip = s2.getZipcode();
                return s2zip - s1zip;
            }
        });
        printStudentList("Students Sorted By Zip Code", students);

        // TODO - sort students by GPA
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int s1GPA = (int) (s1.getGpa() * 100);
                int s2GPA = (int) (s2.getGpa() * 100);
                if (s2GPA == s1GPA){
                    String s1major = s1.getMajor();
                    String s2major = s2.getMajor();
                    return s1major.compareTo(s2major);
                }
                return s2GPA - s1GPA;
            }
        });
        printStudentList("Students Sorted By GPA", students);
    }

    public static void printStudentList(String title,Student[] list) {
        final String format = "%-12s %-12s %-18s %-12s %-12s\n";
        System.out.println(title);
        System.out.printf(format,"First Name","Last Name","Major","Zip Code","GPA");
        for (Student s : list) {
            System.out.printf(format,s.getFirstName(),s.getLastName(),s.getMajor(),s.getZipcode(),s.getGpa());
        }
        System.out.println("==============================================================\n");
    }
}

/*
 * Copyright Notice: Columbus State Community College and its employees hold the copyright for this course material. This material is
 * made available to students for their personal use only and may not be distributed for commercial purposes without the College’s
 * express written consent. Uploading this copyrighted material to "tutoring" or other non-Columbus State web sites is prohibited and
 * may result in referral to the Office of Student Conduct and disciplinary action up to and including dismissal.
 *
 * Course ID: 40A9B085A383430396E7BACF467DE6E0
 */
