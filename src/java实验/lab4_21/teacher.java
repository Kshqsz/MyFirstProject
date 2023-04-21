package java实验.lab4_21;

import java.util.Date;

class Teacher
{
    String name,WorkNumber,Title,MainCourses;
    Date date;

    public Teacher(String name, Date date, String workNumber, String title, String mainCourses) {
        this.name = name;
        this.date = date;
        this.WorkNumber = workNumber;
        this.Title = title;
        this.MainCourses = mainCourses;
    }

    public String getName() {
        return name;
    }

    public String getWorkNumber() {
        return WorkNumber;
    }

    public String getTitle() {
        return Title;
    }
    public void promote() {
        long years = (new Date().getTime() - date.getTime()) / (1000L * 60 * 60 * 24 * 365);

        if (years >= 5) {
                System.out.println("晋升职称");
            }
        else System.out.println("未晋升职称");
        }

    public void setMainCourses(String mainCourses) {
        MainCourses = mainCourses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", WorkNumber='" + WorkNumber + '\'' +
                ", Title='" + Title + '\'' +
                ", MainCourses='" + MainCourses + '\'' +
                '}';
    }
}