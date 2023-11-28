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
        if (isDoorInRange() && isWheelInRange() && isEvenWheel() && isSingleRoof()) {
            return car;
        }
        return null;
    }

    private boolean isDoorInRange() {
        int numDoors = car.numDoors();
        return 4 <= numDoors && numDoors <= 6;
    }

    private boolean isWheelInRange() {
        int numWheels = car.numWheels();
        return 2 <= numWheels && numWheels <= 10;
    }

    private boolean isEvenWheel() {
        int numWheels = car.numWheels();
        return numWheels % 2 == 0;
    }

    private boolean isSingleRoof() {
        int numRoofs = car.numRoofs();
        return numRoofs == 1;
    }
}
/**
 * ===============END===============
 */
