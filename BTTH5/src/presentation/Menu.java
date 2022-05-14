package src.presentation;

import java.util.Scanner;

import src.domain.models.Student;
import src.presentation.managers.StudentManager;

/**
 * This will be used to display the menu, get the user input and process it.
 */
public class Menu {

        private static Scanner scanner = new Scanner(System.in);
        private static StudentManager studentManager = new StudentManager();

        public Menu() {
                displayMenu();
        }

        /**
         * The function that display menu
         * 
         */
        private static void displayMenu() {

                int option = 0;
                do {
                        System.out.println("");
                        System.out.println(
                                        "|======================   DANH SACH CAC TINH NANG CUA CHUONG TRINH  =======================|");
                        System.out.println(
                                        "|(1) Xuat ra danh sach cac sinh vien                                                       |");
                        System.out.println(
                                        "|(2) Xuat ra thong tin sinh vien the student_id                                            |");
                        System.out.println(
                                        "|(3) Them 1 SV                                                                             |");
                        System.out.println(
                                        "|(4) Cap nhat SV theo student_id                                                           |");
                        System.out.println(
                                        "|(5) Xoa SV                                                                                |");
                        System.out.println(
                                        "|(6) thoat chuong trinh                                                                    |");
                        System.out.println(
                                        "===========================================================================================|");

                        System.out.print("Lua chon: ");
                        option = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println();
                        processOption(option);
                        System.out.println("\n\n\n");

                } while (option != 6);

        }

        /** Process the option input and perform valid calculation */
        private static void processOption(int option) {
                switch (option) {
                        case 1: {
                                System.out.println(
                                                "=========================   DANH SACH CAC SINH VIEN   ==========================");

                                studentManager.findAll();
                                break;
                        }
                        case 2:
                                System.out.println(
                                                "==========================   TIM THONG TIN SINH VIEN  ===========================");
                                studentManager.findById(getStudentId());
                                break;
                        case 3:
                                System.out.println(
                                                "============================   THEM 1 SINH VIEN   ============================");

                                studentManager.create(new Student(scanner));
                                break;
                        case 4:
                                System.out.println(
                                                "========================   CAP NHAT SV THEO MA SO SV   ======================");

                                studentManager.update(new Student(scanner));
                                break;
                        case 5:
                                System.out.println(
                                                "=============================   XOA SINH VIEN   =============================");
                                studentManager.delete(getStudentId());
                                break;
                        default:
                                break;
                }
        }

        private static String getStudentId() {
                String studentId;
                do {
                        System.out.print("Nhap ma sinh vien: ");
                        studentId = scanner.nextLine();

                        int studentIdLength = studentId.length();
                        if (studentIdLength > 6 || studentIdLength <= 0) {
                                System.out.println("Ma sinh vien phai co 6 ky tu");
                        } else {
                                break;
                        }
                } while (true);

                return studentId;
        }

}
