package xw.daily.threeday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMenu {

    static List<Bills> billsList = new ArrayList<>();

    static {
        billsList.add(new Bills("吃饭支出",247.0,"交行","支出","2021-03-02","家庭聚餐"));
        billsList.add(new Bills("吃饭支出",247.0,"交行","支出","2021-03-02","家庭聚餐"));
        billsList.add(new Bills("工资收入",12345.0,"现金","收入","2021-03-15","发工资了"));
        billsList.add(new Bills("服装支出",1998.0,"现金","支出","2021-04-02","买衣服"));
        billsList.add(new Bills("吃饭支出",325.0,"现金","支出","2021-06-18","朋友聚餐"));
        billsList.add(new Bills("股票收入",8000.0,"工行","收入","2021-07-28","股票大涨"));
        billsList.add(new Bills("股票收入",5000.0,"工行","收入","2021-08-28","股票又大涨了"));
        billsList.add(new Bills("工资收入",5000.0,"交行","收入","2021-09-28","又发工资了"));
        billsList.add(new Bills("礼金支出",5000.0,"现金","支出","2021-11-28","朋友结婚"));
        billsList.add(new Bills("其他支出",1560.0,"现金","支出","2021-12-29","丢钱了"));
        billsList.add(new Bills("交通支出",2300.0,"交行","支出","2020-10-29","油价还在涨呀"));
        billsList.add(new Bills("吃饭支出",1000.0,"工行","支出","2020-09-29","又吃饭了"));
        billsList.add(new Bills("工资收入",1000.0,"现金","收入","2020-11-30","开工资了"));
        billsList.add(new Bills("交通支出",2000.0,"现金","支出","2020-07-30","机票好贵呀"));
        billsList.add(new Bills("工资收入",5000.0,"现金","收入","2020-05-30","又发工资了"));
    }

    public static void main(String[] args) {
        run();

    }

    public static void run(){
        showMenu();
        boolean flag = true ;
        while (flag){
            Scanner scanner = new Scanner(System.in);
            int opt = scanner.nextInt() ;
            switch (opt){
                case 1 :
                    System.out.println("添加账务");
                    break;
                case 2 :
                    System.out.println("删除账务");
                    break;
                case 3 :
                    //System.out.println("查询账务");
                    select();
                    break;
                case 4 :
                    System.out.println("退出系统");
                    flag =  false ;
                    break;
                default:
                    System.out.println("请重新输入");
            }
        }
        System.out.println("---see you---");
    }

    private static void select(){
        System.out.println("记录》》账务查询");
        System.out.println("1.查询所有 2，按着时间区间查询 3.收入和支出的类型查询");
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();
        switch (opt){
            case 1 :
                selectByAll() ;
                break;
            case 2 :
                selectByTime() ;
                break;
            case 3 :
                selectByType();
                break;
        }
        showMenu();
    }

    private static void selectByAll(){
        System.out.println("查询所有");
        print(billsList);

    }

    public static void print(List<Bills> list){
        System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
        int i = 1;
        for(Bills bills :list){
            System.out.println(i+"\t\t"+bills.getName()+"\t\t\t"+bills.getAccount()+"\t\t"+bills.getType()+"\t\t"+
                    bills.getTotal()+"\t\t\t"+bills.getTime()+"\t\t\t"+bills.getDesc());
            i++;
        }
    }
    private static void selectByTime(){
        System.out.println("记录》》账务查询>>按时间区间查询");
        System.out.println("输入开始时间");
        Scanner scanner = new Scanner(System.in);
        String startData = scanner.next();
        System.out.println("输入结束时间");
        String endData = scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        List<Bills> list =  billsList.stream().filter(bills -> {
            String date = bills.getTime();
            try {
                Date sDate = simpleDateFormat.parse(startData);
                Date eDate = simpleDateFormat.parse(endData);
                Date billDate = simpleDateFormat.parse(date);
                return billDate.after(sDate)&&billDate.before(eDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        print(list);
    }

    private static  void selectByType(){
        System.out.println("记录》》账务查询>>收入和支出类型查询");
        System.out.println("输入 收入或者支出");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.next();
         List<Bills> list =  billsList.stream().filter(bills -> {
             String opt1 = bills.getType();
            return  opt1.equals(opt);
        }).collect(Collectors.toList());
          print(list);
    }

    public static void showMenu(){
        System.out.println("----------------随手记-------");
        System.out.println("1.添加账务 2.删除账务 3.查询账务 4.退出系统");
        System.out.println("请输入功能序号【1-4】");
    }

    public static void addMenu(){

    }
    public static void deleMenu(){
        System.out.println("输入 收入或者支出");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.next();
        List<Bills> list =  billsList.stream().filter(bills -> {
            String opt1 = bills.getType();
            return  opt1.equals(opt);
        }).collect(Collectors.toList());
    }
}
