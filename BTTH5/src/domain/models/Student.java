package src.domain.models;

import java.sql.Date;
import java.util.Scanner;

/**
 * Model student
 */
public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String department;
    private Date entranceDate;
    private Date graduationDate;
    private int credits;
    private Double score;

    public Student(
            String studentId,
            String firstName,
            String lastName,
            Date dob,
            String department,
            Date entranceDate,
            Date graduationDate,
            int credits,
            double score) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.department = department;
        this.entranceDate = entranceDate;
        this.graduationDate = graduationDate;
        this.credits = credits;
        this.score = score;
    }

    public Student(Scanner scanner) {

        String currentLine = scanner.nextLine();

        do {
            System.out.print("Nhap ma sinh vien: ");
            String studentId = scanner.nextLine();

            int studentIdLength = studentId.length();
            if (studentIdLength > 6 || studentIdLength <= 0) {
                System.out.println("Ma sinh vien phai tu 1 den 6 ky tu");
            } else {
                this.studentId = studentId;
                break;
            }
        } while (true);

        System.out.print("Nhap ho sinh vien (co the de trong): ");
        currentLine = scanner.nextLine();
        this.firstName = currentLine.isEmpty() ? null : currentLine;

        System.out.print("Nhap ten sinh vien (co the de trong): ");
        currentLine = scanner.nextLine();
        this.lastName = currentLine.isEmpty() ? null : currentLine;

        do {
            System.out.print("Nhap ngay sinh (co the de trong) | format => YYYY-MM-DD: ");
            try {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;

                this.dob = Date.valueOf(line);
                break;
            } catch (Exception e) {
                System.out.println("Ngay sinh khong hop le");
            }

        } while (true);

        System.out.print("Nhap khoa (co the de trong): ");
        currentLine = scanner.nextLine();
        this.department = currentLine.isEmpty() ? null : currentLine;

        do {
            System.out.print("Nhap ngay vao truong (co the de trong) | format => YYYY-MM-DD: ");

            try {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;

                this.entranceDate = Date.valueOf(line);
                break;
            } catch (Exception e) {
                System.out.println("Ngay vao truong khong hop le");
            }
        } while (true);

        do {
            System.out.print("Nhap ngay tot nghiep (co the de trong) | format => YYYY-MM-DD: ");

            try {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;

                this.graduationDate = Date.valueOf(line);
                break;
            } catch (Exception e) {
                System.out.println("Ngay tot nghiep khong hop le");
            }
        } while (true);

        do {
            System.out.print("Nhap so tin chi: ");
            try {
                this.credits = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("So tinh chi khong hop le");
            }
        } while (true);

        do {
            System.out.print("Nhap diem trung binh (co the de trong): ");
            try {
                String line = scanner.nextLine();
                if (line == null)
                    this.score = null;
                break;
            } catch (Exception e) {
                System.out.println("Diem trung binh khong hop le");
            }
        } while (true);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {

        return "Student ["
                + "studentId=" + studentId
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", dob=" + dob
                + ", department=" + department
                + ", entranceDate=" + entranceDate
                + ", graduationDate=" + graduationDate
                + ", credits=" + credits
                + ", score=" + score
                + "]";
    }

}
