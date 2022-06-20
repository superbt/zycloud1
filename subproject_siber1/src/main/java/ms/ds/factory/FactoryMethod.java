package ms.ds.factory;

public class FactoryMethod {
    public static void main(String[] args) {

        Application application = new Application();
        ProductA productA = application.getObject();
        productA.method1();

    }
}


interface  Product{
    void  method1 ();
}

class ProductA implements  Product{
    public void method1(){
        System.out.println("A method executed!");
    }
}

class Application{
    private ProductA createProduct(){
        return  new ProductA();
    }

    public ProductA getObject(){
        ProductA productA = createProduct();
        return  productA ;
    }
}

class SimpleFactory{
    public static Product createProduct(String type){
        if(type.equals("0")){
            return new ProductA() ;
        }else if(type.equals("1")){
            return null ;
        }
        return null ;
    }
}
