package xw.daily.threeday;

public class Bills {
    private String name ;
    private String account ;
    private String type ;
    private double total ;
    private String time ;
    private String desc ;

    public Bills(String name, double total,String account, String type, String time, String desc) {
        this.name = name;
        this.account = account;
        this.type = type;
        this.total = total;
        this.time = time;
        this.desc = desc;
    }

    public Bills() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
