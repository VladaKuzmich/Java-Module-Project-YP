import java.util.ArrayList;

public class CarRace {
    private int raceDurationHours = 24;
    private int leaderCarDistance;
    private ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Car> leaderCars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
        setLeader(car);
    }

    private void setLeader(Car car) {
        int carDistance = raceDurationHours * car.speed;
        if (carDistance > leaderCarDistance) {
            leaderCars.clear();
            leaderCars.add(car);
            leaderCarDistance = carDistance;
        } else if (carDistance == leaderCarDistance) {
            leaderCars.add(car);
        }
    }
}
