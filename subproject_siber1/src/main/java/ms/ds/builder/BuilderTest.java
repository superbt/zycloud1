package ms.ds.builder;

public class BuilderTest {
    public static void main(String[] args) {
        DefaulConcreateProBUilder defaulConcreateProBUilder = new DefaulConcreateProBUilder();
       // Director director = new Director(defaulConcreateProBUilder);
       // director.makeProduct();

    }
}

class Director{
    private ProductBuilder builder ;

    public Product makeProduct(String productName, String companyName, String part1,
                               String part2, String part3, String part4){
        builder.builderPart1("1");
        builder.builderPart2("2");
        return  builder.builder();
    }

}


class DefaulConcreateProBUilder implements  ProductBuilder{

    String productName;
    String companyName;
    String part1 ;
    String part2 ;
    String part3 ;
    String part4 ;
    Product product = new Product();

    @Override
    public Product builderprcName(String prcName) {
     this.productName = prcName ;
     return  product ;
    }

    @Override
    public Product buildercomName(String comName) {
        this.companyName = comName ;
        return  product ;
    }

    @Override
    public Product builderPart1(String part1) {

        this.part1 = part1 ;
        return  product ;
    }

    @Override
    public Product builderPart2(String part2) {

        this.part2 = part2 ;
        return  product ;
    }

    @Override
    public Product builderPart3(String part3) {

        this.part3 = part3 ;
        return  product ;
    }

    @Override
    public Product builderPart4(String part4) {

        this.part4 = part4 ;
        return  product ;
    }

    @Override
    public Product builder() {
        return product;
    }
}


interface  ProductBuilder{
    Product builderprcName(String prcName);
    Product buildercomName(String comName);
    Product builderPart1(String part1);
    Product builderPart2(String part2);
    Product builderPart3(String part3);
    Product builderPart4(String part4);
    Product builder() ;

}


class Product {
    String productName;
    String companyName;
    String part1 ;
    String part2 ;
    String part3 ;
    String part4 ;

    public Product() {
    }

    public Product(String productName, String companyName, String part1,
                   String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }
}

