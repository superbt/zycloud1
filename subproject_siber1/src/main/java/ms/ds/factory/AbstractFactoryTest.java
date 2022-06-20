package ms.ds.factory;

import java.sql.SQLOutput;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        IDatabaseUtils iDatabaseUtils = new ORCLIDatabaseUtils() ;
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();
    }

}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

interface IConnection{
    void connect();

}

interface ICommand{
    void command();
}

class MySqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("my sql connetion");
    }
}

class MyCommand implements  ICommand{

    @Override
    public void command() {
        System.out.println("my sql command");
    }
}

class MySqlIDatabaseUtils implements  IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MySqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MyCommand();
    }
}



class ORCLConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("ORCL connetion");
    }
}

class ORCLCommand implements  ICommand{

    @Override
    public void command() {
        System.out.println("ORCL command");
    }
}

class ORCLIDatabaseUtils implements  IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new ORCLConnection();
    }

    @Override
    public ICommand getCommand() {
        return new ORCLCommand();
    }
}
