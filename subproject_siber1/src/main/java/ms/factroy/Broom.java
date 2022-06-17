package ms.factroy;

import ms.factroy.inf.MoveAble;

public class Broom implements MoveAble {
    @Override
    public void go() {
        System.out.println("Brom fly");
    }
}
