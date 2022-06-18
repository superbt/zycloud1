package ms.prototype.v3;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.age+"---"+p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.address = new StringBuilder("SH") ;
        System.out.println(p2.loc);
        System.out.println(p1.loc == p2.loc);
        System.out.println(p1.loc);
    }

}

class Location implements Cloneable {
    StringBuilder address ;
    int postNum  ;

    public Location(StringBuilder address, int postNum) {
        this.address = address;
        this.postNum = postNum;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", postNum=" + postNum +
                '}';
    }
}

class Person implements  Cloneable{
    int age = 8 ;
    int score = 100 ;

    Location loc = new Location(new StringBuilder("BJ"),22);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }
}
