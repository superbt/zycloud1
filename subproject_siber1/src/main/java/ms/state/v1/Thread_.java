package ms.state.v1;

public class Thread_ {
    ThreadState_ state ;

    public void move(Action input){
        state.move(input);
    }
    public void run(){
        state.run();
    }
}
