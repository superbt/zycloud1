package ms.strategy;

public class Dog implements Comarable<Dog> {
    int food ;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        if(this.food>o.food) return -1 ;
        else if(this.food<o.food) return 1 ;
        else return  0;

    }
}
