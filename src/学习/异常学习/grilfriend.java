package 学习.异常学习;

public class grilfriend {
    String name;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "grilfriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        if (age < 18 || age > 30) {
            throw new myException(age + "范围超出预期");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
