package problem3;

import java.util.ArrayList;
import java.util.List;
import problem2.door.Door;
import problem2.factory.CarPartsFactory;
import problem2.wheel.Wheel;

/**
 * ==============BEGIN==============
 * Complete the below code that requires your implementation
 * If necessary, you can make your own methods or classes so that the corresponding tests are passed
 */
public class CarBuilder implements Builder{
    private Car car;
    private CarPartsFactory factory;

    public CarBuilder(CarPartsFactory factory) {
        this.factory = factory;
        reset();
    }

    @Override
    public Builder addDoors(int numDoors) {
        List<Door> doors = new ArrayList<>();
        for (int i = 0; i < numDoors; i++) {
            doors.add(factory.createDoor());
        }
        this.car.setDoors(doors);
        return this;
    }

    @Override
    public Builder addWheels(int numWheels) {
        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < numWheels; i++) {
            wheels.add(factory.createWheel());
        }
        this.car.setWheels(wheels);
        return this;
    }

    @Override
    public Builder setRoof() {
        this.car.setRoof(factory.createRoof());
        return this;
    }

    @Override
    public Builder setColor(Color color) {
        this.car.setColor(color);
        return this;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public void reset() {
        this.car = new Car();
        setCompanyName();
    }

    private void setCompanyName() {
        this.car.setCompanyName(factory.getCompanyName());
    }
}
/**
 * ===============END===============
 */
