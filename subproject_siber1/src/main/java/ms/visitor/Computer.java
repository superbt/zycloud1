package ms.visitor;

public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v){
        this.board.accept(v);
        this.cpu.accept(v);
        this.memory.accept(v);
    }

    public static void main(String[] args) {
        PersonelVisitor p = new PersonelVisitor();
        new Computer().accept(p);
        System.out.println(p.totalprice);
    }


}



abstract class  ComputerPart{
 abstract void accept(Visitor v) ;
 abstract double getPrice();
}


class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 80;
    }
}


class  CPU extends ComputerPart{

    @Override
    void accept(Visitor v) {
         v.visitCPU(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
         v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 1000;
    }
}
class PersonelVisitor implements  Visitor{

    double totalprice = 0.0 ;

    @Override
    public void visitCPU(CPU cpu) {
     this.totalprice = this.totalprice+cpu.getPrice()*0.9 ;
    }

    @Override
    public void visitMemory(Memory memory) {
        this.totalprice = this.totalprice +memory.getPrice()*0.85 ;

    }

    @Override
    public void visitBoard(Board board) {
       this.totalprice = this.totalprice+board.getPrice()*0.95 ;
    }
}

class  CorpVisitor implements  Visitor{

    double totalprice = 0.0 ;

    @Override
    public void visitCPU(CPU cpu) {
        this.totalprice = this.totalprice+cpu.getPrice()*0.6 ;
    }

    @Override
    public void visitMemory(Memory memory) {
        this.totalprice = this.totalprice +memory.getPrice()*0.75 ;

    }

    @Override
    public void visitBoard(Board board) {
        this.totalprice = this.totalprice+board.getPrice()*0.75 ;
    }
}

interface  Visitor{
    void visitCPU(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);

}
