package 数据结构.第七章;

class Computer {
    //定义成员变量
    private String model; //型号
    private double price; //价格
    private int sales; //销量

    //定义构造方法
    public Computer(String model, double price, int sales) {
        this.model = model;
        this.price = price;
        this.sales = sales;
    }

    //定义get和set方法
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

}