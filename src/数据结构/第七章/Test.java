package 数据结构.第七章;

public class Test {
    public static void main(String[] args) {
        //创建一个数组来存储不同型号的电脑对象
        Computer[] computers = new Computer[5];
        computers[0] = new Computer("ThinkPad 1", 8999, 120);
        computers[1] = new Computer("ThinkPad 2", 12999, 80);
        computers[2] = new Computer("ThinkPad 3", 19999, 50);
        computers[3] = new Computer("ThinkPad 4", 5999, 150);
        computers[4] = new Computer("ThinkPad 5", 6999, 100);

        //使用冒泡排序算法来对数组中的电脑对象按照销量从高到低进行排序
        for (int i = 0; i < computers.length - 1; i++) {
            for (int j = 0; j < computers.length - 1 - i; j++) {
                //如果前一个电脑的销量小于后一个电脑的销量，就交换它们的位置
                if (computers[j].getSales() < computers[j + 1].getSales()) {
                    Computer temp = computers[j];
                    computers[j] = computers[j + 1];
                    computers[j + 1] = temp;
                }
            }
        }

        //使用循环语句来遍历数组中的电脑对象，并将它们的属性输出到控制台，形成汇总表
        System.out.println("华清电脑销售公司ThinkPad系列电脑销售情况汇总表：");
        System.out.println("序号\t型号\t\t价格\t\t销量");
        for (int i = 0; i < computers.length; i++) {
            System.out.println((i + 1) + "\t" + computers[i].getModel() + "\t" + computers[i].getPrice() + "\t" + computers[i].getSales());
        }
    }
}