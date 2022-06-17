package ms.command;

public class Main {
    public static void main(String[] args) {
        Content c = new Content() ;
        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        System.out.println(c.msg);
        insertCommand.undo();
        System.out.println(c.msg);


    }
}
