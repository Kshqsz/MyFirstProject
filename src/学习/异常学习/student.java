package 学习.异常学习;

public class student {
    int age;
    String name;
    public student () {

    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        if (age > 40) {
            throw new RuntimeException();
        } else {
            this.age = age;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
