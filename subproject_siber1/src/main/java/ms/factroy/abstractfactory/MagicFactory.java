package ms.factroy.abstractfactory;

public class MagicFactory extends AbstractFactory {

    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vechicle createVechicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagincSick();
    }
}
