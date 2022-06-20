package ms.ds.builder.v2;

public class ProductTest2{
    public static void main(String[] args) {

        Product product = new Product();

    }

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


    static class Builder{
        String productName;
        String companyName;
        String part1 ;
        String part2 ;
        String part3 ;
        String part4 ;

        public Builder productName(String productName){
            this.productName = productName ;
            return  this ;
        }

        public  Product builder(){
            return  new Product();
        }

    }
}

