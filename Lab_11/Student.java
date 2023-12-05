package edu.cscc;

/**
 * Student class (immutable)
 */
public final class Student {
    private final String firstName;
    private final String lastName;
    private final String major;
    private final int zipcode;
    private final String studentID;
    private final double gpa;

    public Student(String firstName, String lastName, String major, int zipcode, String studentID, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.zipcode = zipcode;
        this.studentID = studentID;
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getStudentID() {
        return studentID;
    }

    public double getGpa() {
        return gpa;
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
