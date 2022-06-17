package ms.observer.v8;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Mybutton mb = new Mybutton();
        mb.addActionListener(new MyActionListener());
        mb.addActionListener(new MyActionListener2());
        mb.buttonPressed();

    }
}

class Mybutton{
    private List<ActionListener> actionListeners = new ArrayList<ActionListener>();
    public void buttonPressed(){
        MyActionEvent e = new MyActionEvent(System.currentTimeMillis(),this);
        for (ActionListener l: actionListeners
             ) {
            l.actionPerformed(e);
        }
    }
    public void addActionListener(ActionListener l){
        actionListeners.add(l);
    }
}


interface ActionListener{
    public void actionPerformed(MyActionEvent e) ;
}
class MyActionListener implements ActionListener{


    @Override
    public void actionPerformed(MyActionEvent e) {
        System.out.println("button press !");
    }
}

class MyActionListener2 implements ActionListener{


    @Override
    public void actionPerformed(MyActionEvent e) {
        System.out.println("button press 2!");
    }
}

class MyActionEvent{
   long when ;
   Object source;

    public MyActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
