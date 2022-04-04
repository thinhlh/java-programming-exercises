import java.util.InputMismatchException;
import java.util.Scanner;

import models.VehicleManager;

public class Main {

        private static Scanner scanner = new Scanner(System.in);
        private static VehicleManager vehicleManager = new VehicleManager();

        public static void main(String[] args) {
                displayMenu();

                scanner.close();
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
                                        "|(1) nhap danh sach cac xe                                                                 |");
                        System.out.println(
                                        "|(2) xuat danh sach cac xe                                                                 |");
                        System.out.println(
                                        "|(3) xuat ra cac xe moi san xuat                                                           |");
                        System.out.println(
                                        "|(4) tinh tong gia tri cac xe                                                              |");
                        System.out.println(
                                        "|(5) tinh gia tri trung binh so dam da di tren cac loai xe co thong so nay                 |");
                        System.out.println(
                                        "|(6) thoat chuong trinh                                                                    |");
                        System.out.println(
                                        "===========================================================================================|");

                        System.out.print("Lua chon: ");
                        option = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println();
                        processOption(option);
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");

                } while (option != 6);

        }

        /** Process the option input and perform valid calculation */
        private static void processOption(int option) {
                switch (option) {
                        case 1: {
                                System.out.println(
                                                "=================================   NHAP VAO CAC XE   =====================================");
                                Boolean isFromFile = null;
                                do {
                                        System.out.print(
                                                        "Chon cach them cac xe (0: Tu file vehicles.txt, 1: Nhap tay): ");
                                        try {
                                                var inputOption = scanner.nextInt();
                                                if (inputOption == 0 || inputOption == 1) {
                                                        isFromFile = inputOption == 0;
                                                        if (isFromFile)
                                                                vehicleManager.inputVehiclesWithFile();
                                                        else
                                                                vehicleManager.inputVehiclesWithScanner();
                                                        break;
                                                }
                                        } catch (Exception e) {
                                                scanner.nextLine();
                                        }
                                } while (isFromFile != null);
                                break;
                        }
                        case 2:
                                System.out.println(
                                                "=================================   DANH SACH CAC XE  =====================================");
                                vehicleManager.displayAllVehicles();
                                break;
                        case 3:
                                System.out.println(
                                                "============================   DANH SACH CAC XE MOI SAN XUAT   ============================");
                                vehicleManager.displayNewlyManufactoredVehicles();
                                break;
                        case 4:
                                System.out.println(
                                                "==============================  TINH TONG GIA TRI CAC XE   =================================");
                                vehicleManager.displayVehicleTotalPrice();
                                break;
                        case 5:
                                System.out.println(
                                                "==========================   GIA TRI TRUNG BINH SO DAM DA DI   =============================");
                                vehicleManager.displayAverageMileOfEachTypeOfVehicle();
                                break;
                        default:
                                break;
                }
        }
}
