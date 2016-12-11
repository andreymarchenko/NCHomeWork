package third;

/**
 * Created by Andrey on 11.12.2016.
 */
public class CarFactory {
    Car buildCar(CarType model) {
        switch (model) {
            case SEDAN: {
                return new SedanCar();
            }
            case WAGON: {
                return new WagonCar();
            }
            case HATCHBACK: {
                return new HatchBack();
            }
        }
        return null;
    }
}

