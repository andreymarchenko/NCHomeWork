package third;

/**
 * Created by Andrey on 11.12.2016.
 */
public class CarFactoryDemo {
    public static void main(String[] args) {
        Car firstCar = new CarFactory().buildCar(CarType.SEDAN);
        System.out.println(firstCar instanceof SedanCar);
        Car secondCar = new CarFactory().buildCar(CarType.WAGON);
        System.out.println(secondCar instanceof WagonCar);
        Car thirdCar = new CarFactory().buildCar(CarType.HATCHBACK);
        System.out.println(thirdCar instanceof HatchBack);
    }
}
