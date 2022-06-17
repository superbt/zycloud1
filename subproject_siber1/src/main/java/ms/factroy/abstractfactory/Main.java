package ms.factroy.abstractfactory;

public class Main {
    public static void main(String[] args) {
/*        Car car = new Car();
        car.go();
        new AK47().shoot();
        new Bread().printName();*/

        //永远要保持学习啊
        AbstractFactory f = new MagicFactory();
        f.createVechicle().go();
        f.createWeapon().shoot();
        f.createFood().printName();


    }
}
