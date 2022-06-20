package ms.state.v1;

public class NewState extends ThreadState_ {

    private Thread_ t ;

    public NewState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action state) {

        if(state.msg=="start"){
            t.state = new RunningState(t);
        }
    }

    @Override
    public void run() {
        super.run();
    }
}
