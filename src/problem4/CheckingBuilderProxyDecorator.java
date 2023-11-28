package problem4;

import problem2.factory.CarPartsFactory;
import problem3.Builder;
import problem3.Car;

/**
 * ==============BEGIN==============
 * Complete the below code that requires your implementation
 * If necessary, you can make your own methods or classes so that the corresponding tests are passed
 */
public class CheckingBuilderProxyDecorator extends BaseBuilderProxyDecorator {
    public CheckingBuilderProxyDecorator(Builder builder) {
        super(builder);
    }

    public CheckingBuilderProxyDecorator(CarPartsFactory factory) {
        super(factory);
    }

    @Override
    public Car getCar() {
        Car car = super.getCar();
        if (isDoorOutOfRange(car) || isWheelOutOfRange(car) || isOddWheel(car) || isNotSingleRoof(car)) {
            return null;
        }
        return car;
    }

    private boolean isDoorOutOfRange(Car car) {
        return car.numDoors() < 4 || 6 < car.numDoors();
    }

    private boolean isWheelOutOfRange(Car car) {
        return car.numWheels() < 2 || 10 < car.numWheels();
    }

    private boolean isOddWheel(Car car) {
        return car.numWheels() % 2 != 0;
    }

    private boolean isNotSingleRoof(Car car) {
        return car.numRoofs() != 1;
    }
}
/**
 * ===============END===============
 */
