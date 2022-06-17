package ms.factroy;

import ms.factroy.inf.MoveAble;

public class Main {
    public static void main(String[] args) {
        MoveAble moveAble = new CarFarctory().createCar();
        moveAble.go();
    }
}

