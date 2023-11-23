package problem2.factory;

import problem2.CompanyName;
import problem2.door.Door;
import problem2.door.TeslaDoor;
import problem2.roof.Roof;
import problem2.roof.TeslaRoof;
import problem2.wheel.TeslaWheel;
import problem2.wheel.Wheel;

public class TeslaPartsFactory implements CarPartsFactory {
    CompanyName companyName;

    public TeslaPartsFactory() {
        this.companyName = CompanyName.TESLA;
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    @Override
    public Door createDoor() {
        return new TeslaDoor();
    }

    @Override
    public Wheel createWheel() {
        return new TeslaWheel();
    }

    @Override
    public Roof createRoof() {
        return new TeslaRoof();
    }
}
