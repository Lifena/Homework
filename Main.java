package csa;
import java.util.*;
public class Main{
    public static void main(String [] args) {
        System.out.println("<-------第一题------->");
        Monkey one=new Monkey("Tom");
        System.out.println("我是猴子"+one.getName());
        one.speak();
        People two=new People("Saa");
        System.out.println("我是人类"+two.getName());
        two.speak();
        two.think();

        System.out.println("<-------第二题------->");
        Car car=new Car(4,1110,5);
        System.out.println(car);
        System.out.println("-------------------");
        Truck truck=new Truck(6,15000,2,3500);
        System.out.println(truck);

        System.out.println("<-------第三题------->");
        System.out.println(getSum("13829579081298345918257","438823897418920918472193"));

        System.out.println("<-------第四题------->");
        int m=7;
        int n=6;
        System.out.println(uniquePaths(m,n)+"种");

        System.out.println("<-------第五题------->");
        String[] str= {"f1ower","f1ow","f1ight"};
        Solution solution=new Solution();
        String s = solution.longstCommonPrefix(str);
        System.out.println("\""+s+"\"");

    }
    public static String getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c="";
        for(int i=a.length()-1;i>=0;--i){
            la.add(a.charAt(i)-'0');
        }
        for(int i=b.length()-1;i>=0;--i){
            lb.add(b.charAt(i)-'0');
        }
        List<Integer> lc = new ArrayList<Integer>();
        int tmp=0;
        int maxsize = Math.max(la.size(),lb.size());
        for (int i = 0; i < maxsize; i++) {
            if(i<la.size()){
                tmp += la.get(i);
            }
            if(i<lb.size()){
                tmp += lb.get(i);
            }
            lc.add(tmp%10);
            tmp /= 10;
        }
        if(tmp>0)
            lc.add(tmp%10);
        for(int i = lc.size()-1;i>=0;i--){
            c += lc.get(i);
        }
        return c;
    }
    public static int uniquePaths(int m, int n){
        int a[][]=new int[m][n];
        for(int i=0;i<n;i++){
            a[0][i]=1;
        }
        for(int j=0;j<m;j++){
            a[j][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                a[i][j]=a[i][j-1]+a[i-1][j];
            }
        }
        return a[m-1][n-1];
    }

}

class Monkey{
    String name;

    public Monkey() {
    }

    public Monkey(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void speak() {
        System.out.println("咿咿呀呀 ......");
    }
}
class People extends Monkey{
    public People(String s) {
        super(s);
    }
    public void speak() {
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    void think() {
        System.out.println("别说话！认真思考！  ");
    }
}
class Vehicle{
    int wheels;
    double weight;

    public Vehicle() {
    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }
}
class Car extends Vehicle{
    int loader;

    public Car() {
    }
    public Car(int wheels, double weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    @Override
    public String toString() {
        return "车轮的个数是："+wheels+" 车重："+weight+"\n" +
                "这是一辆小车，能载6人，实载"+loader+"人"+(loader>=6?"，你超员了！！！":"");
    }
}
class Truck extends Vehicle{
    int loader;
    double payload;

    public Truck() {
    }

    public Truck(int wheels, double weight, int loader,double payload) {
        super(wheels, weight);
        this.loader = loader;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "车轮的个数是："+wheels+" 车重："+weight+"\n"+
                "这是一辆卡车，能载3人，实载"+loader+"人"+(loader>=3?"，你超员了！！！":"")+"\n"+
                "这是一辆卡车，核载5000kg，你已装载"+payload+"kg"+(payload>5000.0?"，你超载了！！！":"");
    }
}
class Solution{
    public static String longstCommonPrefix(String[] str) {
        String ans="";
        if(str==null||str.length==0) {
            return ans;
        }
        String pre=str[0];
        int count=str.length;
        for(int i=1;i<count;i++) {
            pre=proStr(pre,str[i]);
            if(pre.length()==0) {
                break;
            }
        }
        return pre;
    }
    public static String proStr(String str1,String str2) {
        int min=Math.min(str1.length(), str2.length());
        int index=0;
        while(index<min&&str1.charAt(index)==str2.charAt(index)) {
            index++;
        }
        return str1.substring(0,index);
    }
}