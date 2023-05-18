package ADM;

import java.util.ArrayList;
import  java.util.Scanner;
public class Main {
    static ArrayList<Student> students = new ArrayList<>();/*建立一个arraylist，泛型数据是我们建立的Student类，把的学生的基本信息存在arraylist类里*/
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        show0();/*录入初始的学生信息*/
        while (true) {
            show1();/*显示学生管理系统界面以及我们需要进行的操作*/
            int count = sc.nextInt();
            if (count == 7)/*退出系统*/
                break;
            switch (count) {
                case 1:
                    show();/*显示学生信息*/
                    break;
                case 2:
                    add();/*增加学生信息*/
                    break;
                case 3:
                    delect();/*删除学生信息*/
                    break;
                case 4:
                    search();/*查找学生信息*/
                    break;
                case 5:
                    modify();/*修改学生信息*/
                    break;
                case 6:
                    count();/*统计学生人数*/
                    break;
                default:
                    System.out.println("请输入正确的序号。");
            }
        }
    }

    static void show0() {
        Student student0 = new Student("2021212130", "秦帅哥", "男", "21", "2001-01-01", "理学院 ", 88);
        Student student1 = new Student("2021212131", "张三儿", "男", "20", "2002-01-14", "软件学院 ", 86);
        Student student2 = new Student("2021212132", "李美女", "女", "19", "2003-02-15", "经管学院 ", 80);
        Student student3 = new Student("2021212133", "贺大凉", "女", "21", "2001-06-25", "传媒学院 ", 90);
        Student student4 = new Student("2021212134", "秀秀 ", "女", "20", "2002-11-18", "计算机学院", 98);
        Student student5 = new Student("2021212135", "陈保安", "男", "21", "2001-05-05", "通信学院 ", 60);
        Student student6 = new Student("2021212136", "郑钱 ", "女", "18", "2004-10-01", "通信学院 ", 100);
        students.add(student0);/*Student是arraylist的元素，存入元素student0*/
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
    }

    public static void show1() {
        System.out.println("***********************************");
        System.out.println("***********  学生管理系统  ***********");
        System.out.println("**********  1.显示学生信息  **********");
        System.out.println("**********  2.增加学生信息  **********");
        System.out.println("**********  3.删除学生信息  **********");
        System.out.println("**********  4.查找学生信息  **********");
        System.out.println("**********  5.修改学生信息  **********");
        System.out.println("**********  6.统计学生信息  **********");
        System.out.println("**********  7.退出学生系统  **********");
        System.out.println("***********************************");
        System.out.println("请选择其功能：");
    }

    public static void show() {
        System.out.println("*************学生信息表*****************");
        System.out.println("序号\t学号\t\t\t\t姓名\t\t\t性别\t\t年龄\t\t出生日期\t\t\t学院\t\t\t成绩");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);/*计算arraylist中元素的数量*/
            System.out.println(i + 1 + "\t" + student.getId() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t"
                    + student.getAge() + "\t\t" + student.getBrithday() + "\t\t" + student.getCollege() + "\t\t" + student.getGrade());
        }
        System.out.println("**************************************");
    }

    public static void add() {
        System.out.print("请输入您要添加学生的个数:");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("请输入您要添加的学号:");
            String str = sc.next();
            int count = 0;
            for (Student student : students) {/*遍历students数组*/
                if (student.getId().equals(str)) {/*student.getId().equals(str)是将存在的学号和我们输入的学号str进行比较*/
                    System.out.println("已有此人！");
                    break;
                }
                count++;
            }
            if (count == students.size()) {/*计算arraylist中元素的数量*/
                System.out.print("添加的学生的姓名:");
                String str1 = sc.next();
                System.out.print("添加的学生的性别:");
                String str2 = sc.next();
                System.out.print("添加的学生的年龄:");
                String str3 = sc.next();
                System.out.print("添加的学生的出生日期(yyyy-mm-dd):");
                String str4 = sc.next();
                System.out.print("添加的学生的学院:");
                String str5 = sc.next();
                System.out.print("添加的学生的成绩:");
                int str6 = sc.nextInt();
                Student student = new Student(str, str1, str2, str3, str4, str5, str6);
                students.add(student);
                System.out.println("添加成功！");
            }
        }
    }
    public static void delect(){
        System.out.println("请输入需要删除的学生的学号：" );
        String str= sc.next();
        int count =0;
        int n=students.size();
        for(int i=0;i<n;i++){
            Student student=students.get(i);/*访问arraylist中的元素*/
            if(student.getId().equals(str)){
                students.remove(i);/*删除arraylist中的元素*/
                System.out.println("删除成功。");
                break;
            }
            count++;
        if(count==n){
            System.out.println("没有此人");
        }
        }
    }
    public static void search(){
        System.out.println("请输入你需要查找的学号");
        String str= sc.next();
        int count=0;
        for (Student student:students){
            if(student.getId().equals(str)){
                System.out.println(student.getId() + "\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" +
                        student.getAge() + "\t\t" + student.getBrithday() + "\t\t" + student.getCollege() + "\t\t" + student.getGrade());
                break;
            }
            count++;
        }
        if(count==students.size()){
            System.out.println("没有此人");
        }
    }
    public static void modify(){
        System.out.println("请输入你要修改的学号");
        String str= sc.next();
        int count=0;
        for(Student student:students){
            if(student.getId().equals(str)){
                while (true){
                    System.out.println("*******************************");
                    System.out.println("**********  1.学生姓名 **********");
                    System.out.println("**********  2.学生性别 **********");
                    System.out.println("**********  3.学生出生日期  ******");
                    System.out.println("**********  4.学生年龄  **********");
                    System.out.println("**********  5.学生学院  **********");
                    System.out.println("**********  6.学生成绩  **********");
                    System.out.println("*********************************");
                    System.out.println("请输入你要修改的选项：");
                    int number=sc.nextInt();
                    if(number==1||number==2||number==3||number==4||number==5||number==6){
                        System.out.println("修改为：");
                        String sr= sc.next();
                        switch (number){
                            case 1:
                                student.setName(sr);
                                break;
                            case 2:
                                student.setSex(sr);
                                break;
                            case 3:
                                student.setBrithday(sr);
                                break;
                            case 4:
                                student.setAge(sr);
                                break;
                            case 5:
                                student.setCollege(sr);
                                break;
                            case 6:
                                student.setGrade(Integer.parseInt(sr));
                                break;
                        }
                        System.out.println("修改成功");
                        break;
                    }
                    else {
                        System.out.println("请输入正确的序号。");
                    }
                }
                break;
            }
            count++;
        }
        if(count==students.size()){
            System.out.println("没有此人");
        }
    }
    public static void count(){
        System.out.println("学生总人数为："+students.size());
    }
}


    class Student {
        private String id;
        private String name;
        private String sex;
        private String age;
        private String brithday;
        private String college;
        private int grade;

        public Student() {
        }

        public Student(String id, String name, String sex, String age, String brithday, String college, int grade) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.brithday = brithday;
            this.college = college;
            this.grade = grade;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getBrithday() {
            return brithday;
        }

        public void setBrithday(String brithday) {
            this.brithday = brithday;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }
    }
