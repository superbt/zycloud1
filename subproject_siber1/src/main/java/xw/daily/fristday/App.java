package xw.daily.fristday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Dish> disList = new ArrayList<Dish>();
    static List<Dish> personDis = new ArrayList<Dish>();


    public static void main(String[] args) {
        initDish();
        Scanner scanner = new Scanner(System.in);
        while (true){
            showMenu();
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    while(true){
                        showDishMenu();
                        int id = scanner.nextInt();
                        if(id == 0){
                            break;
                        }
                        Dish dish = disList.get(id - 1);
                        personDis.add(dish);
                        System.out.println("亲 您点了："+dish.getName());

                    }
                case 2:
                    showPersionDis();
                    break;
                case 3:
                    buy();
                    return;
            }

            if (num==0000){
                System.out.println("退出");
                break;
            }
        }
    }

    public static void showMenu(){
        System.out.println("----主菜单---");
        System.out.println("----菜单---1");
        System.out.println("----已点菜单---2");
        System.out.println("----买单---3");
        System.out.println("----根据编号请选择服务---");
    }

    public static void  showDishMenu(){
        System.out.println("---请您点菜");
        for (Dish dish : disList) {
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("---输入序号点菜");
    }

    public static void showPersionDis(){
        System.out.println("---您已点的菜品");
        for(Dish dish:personDis){
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
    }

    public static void buy(){
        System.out.println("---请稍等正在结账");
        Double total = 0D;
        for(Dish dish:personDis){
            total = total +dish.price ;
            //System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("---总金额--"+total);
    }

    public static void initDish(){
        Dish dish = new Dish( 1, "香辣肉丝",29.0);
        disList.add(dish);
        Dish dish2 = new Dish( 1, "炖王八",59.0);
        disList.add(dish2);
        disList.add(new Dish(3,"家常凉菜",21.0));
        disList.add(new Dish(4,"地三鲜",24.0));
        disList.add(new Dish(3,"油焖大虾",55.0));

    }
}
