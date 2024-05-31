import java.util.ArrayList;
import java.util.List;

class Car {
    private double price;
    private String brand;
    private double speed;

    public Car(double price, String brand, double speed) {
        this.price = price;
        this.brand = brand;
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}

public class CarList {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2500000, "Toyota", 180));
        cars.add(new Car(1800000, "Honda", 170));
        cars.add(new Car(3000000, "BMW", 220));
        cars.add(new Car(1500000, "Ford", 160));
        cars.add(new Car(2800000, "Mercedes", 200));

        System.out.println("Cars with price over 2000000 takas:");
        for (Car car : cars) {
            if (car.getPrice() > 2000000) {
                System.out.println(car.getBrand() + " - Price: " + car.getPrice());
            }
        }
    }
}
