package ms.factroy;

public class CarFarctory {
    public Car createCar(){
        System.out.println("a car created");
        return  new Car();
    }
}
