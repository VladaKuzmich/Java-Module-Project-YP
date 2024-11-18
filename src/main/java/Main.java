import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int carsCount = 3;

        int minSpeedRange = 1;
        int maxSpeedRange = 250;

        Scanner scanner = new Scanner(System.in);
        CarRace carRace = new CarRace();

        System.out.println("Гонка началась!");

        for (int i = 1; i <= carsCount; i++) {

            System.out.println("Введите название " + i + "-ой машины:");
            String carName = scanner.nextLine();

            int carSpeed;
            while (true) {
                System.out.println("Введите скорость " + i + "-ой машины:");

                String carSpeedString = scanner.nextLine().trim();

                try {
                    carSpeed = Integer.parseInt(carSpeedString);

                    if (carSpeed >= minSpeedRange && carSpeed <= maxSpeedRange) {
                        carRace.addCar(new Car(carName, carSpeed));
                        break;
                    } else {
                        System.out.printf("Неверное значение для скорости. Скорость должна быть в интервале [%d,%d].%n", minSpeedRange, maxSpeedRange);
                    }
                } catch (Exception ex) {
                    System.out.printf("Неверный формат для скорости. Скорость - целое число в интервале [%d,%d].%n", minSpeedRange, maxSpeedRange);
                }
            }
        }

        if (carRace.leaderCars.size() == 1) {
            System.out.println("Победитель: " + carRace.leaderCars.get(0).name);
        }
        else {
            System.out.println("Победители:");
            for (Car car : carRace.leaderCars) {
                System.out.println(car.name);
            }
        }
    }
}