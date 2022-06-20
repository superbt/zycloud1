package ms.state.v1;

public class RunningState  extends ThreadState_ {
    private Thread_ t ;

    public RunningState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action state) {
        super.move(state);
    }

    @Override
    public void run() {
        super.run();
    }
}
