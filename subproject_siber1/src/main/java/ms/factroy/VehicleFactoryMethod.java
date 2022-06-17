package ms.factroy;

public class VehicleFactoryMethod {
    public Car createCar(){
        return  new Car();
    }

    public Plane createPlan(){
        return  new Plane();
    }

    public Broom createBroom(){
        return  new Broom();
    }
}
