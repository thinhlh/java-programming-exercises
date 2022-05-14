package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * This is a class where we manage all the vehicles
 */
public class VehicleManager {
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void inputVehiclesWithFile() {
        try {
            FileReader reader = new FileReader("vehicles.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            // Read every line from buffer reader and create a new vehicle
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Vehicle vehicle = VehicleFactory.createVehicleWithInputString(line);
                vehicles.add(vehicle);
            }

            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Khong the doc duoc file.");
            e.printStackTrace();
        }
    }

    /**
     * Nhap danh sach cac xe
     */
    public void inputVehiclesWithScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so luong cac xe: ");
        int numOfVehicles = scanner.nextInt();

        for (int i = 0; i < numOfVehicles; i++) {
            System.out.println("### Nhap xe thu " + (i + 1) + " ###");
            int option;
            do {
                displayVehicleChosenMenu();
                option = scanner.nextInt();
            } while (option <= 0 || option > 4);
            vehicles.add(processVehicleChosenOption(option));
            System.out.println("");
        }
    }

    public void displayAllVehicles() {
        displayVehicle(vehicles);
    }

    public void displayNewlyManufactoredVehicles() {

        final List<Vehicle> _newlyManufactoredVehicles = vehicles.stream()
                .filter((vehicle) -> vehicle.newlyManufactored()).toList();

        displayVehicle(_newlyManufactoredVehicles);
    }

    public void displayVehicleTotalPrice() {
        Double totalPrice = vehicles.stream().flatMapToDouble(vehicle -> DoubleStream.of(vehicle.price)).sum();
        System.out.println("Tong gia tri cac xe: " + totalPrice);
    }

    public void displayAverageMileOfEachTypeOfVehicle() {
        averageMileageOfBikes();
        averageMileageOfCars();
        averageMileageOfTrucks();
    }

    private void averageMileageOfCars() {
        OptionalDouble average = vehicles.stream()
                .filter(Car.class::isInstance)
                .map(vehicle -> (Car) vehicle)
                .flatMapToDouble(car -> DoubleStream.of(car.getMileage()))
                .average();

        if (average.isPresent()) {
            System.out.println("Tong so miles trung binh da di cua xe hoi: " + average.getAsDouble());
        } else {
            System.out.println("Chua co chiec xe hoi nao duoc nhap.");
        }
    }

    private void averageMileageOfBikes() {
        OptionalDouble average = vehicles.stream()
                .filter(Bike.class::isInstance)
                .map(vehicle -> (Bike) vehicle)
                .flatMapToDouble(bike -> DoubleStream.of(bike.getMileage()))
                .average();

        if (average.isPresent()) {
            System.out.println("Tong so miles trung binh da di cua xe may: " + average.getAsDouble());
        } else {
            System.out.println("Chua co chiec xe may nao duoc nhap.");
        }
    }

    private void averageMileageOfTrucks() {
        OptionalDouble average = vehicles.stream()
                .filter(Truck.class::isInstance)
                .map(vehicle -> (Truck) vehicle)
                .flatMapToDouble(truck -> DoubleStream.of(truck.getMileage()))
                .average();

        if (average.isPresent()) {
            System.out.println("Tong so miles trung binh da di cua xe tai: " + average.getAsDouble());
        } else {
            System.out.println("Chua co chiec xe tai nao duoc nhap.");
        }
    }

    /**
     * Hien thi danh sach cac loai xe de lua chon
     */
    private void displayVehicleChosenMenu() {
        System.out.println("========== CHON LOAI XE ==========");
        System.out.println("(1) Xe Dap - Bicycle");
        System.out.println("(2) Xe May - Bike");
        System.out.println("(3) Xe Hoi - Car");
        System.out.println("(4) Xe Tai - Truck");
        System.out.println("==================================");
        System.out.print("Lua chon: ");
    }

    /**
     * Xu ly tao cac xe dua tren lua chon nguoi dung
     * 
     * @param option
     * @return Vehicle
     */
    private Vehicle processVehicleChosenOption(int option) {
        switch (option) {
            case 1:
                System.out.println("### Xe Dap - Bicycle ###");
                return VehicleFactory.createVehicleFromWithScanner(VehicleType.Bicycle);
            case 2:
                System.out.println("### Xe May - Bike ###");
                return VehicleFactory.createVehicleFromWithScanner(VehicleType.Bike);
            case 3:
                System.out.println("### Xe Hoi - Car ###");
                return VehicleFactory.createVehicleFromWithScanner(VehicleType.Car);
            case 4:
                System.out.println("### Xe Tai - Truck ###");
                return VehicleFactory.createVehicleFromWithScanner(VehicleType.Truck);
            default:
                return null;
        }
    }

    /**
     * Display list of vehicles
     * 
     * @param vehicles
     */
    private void displayVehicle(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("CHUA CO XE NAO TRONG DANH SACH");
            return;
        }
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("### Xe thu " + (i + 1) + " ###");
            System.out.println(vehicles.get(i));
        }
    }

}
