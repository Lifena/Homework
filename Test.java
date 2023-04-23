package CSA;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		System.out.println("1、B 2、B 3、A 4、B 5、D");
		Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        String s=in.next();
        int m=in.nextInt();
        showTriangle(n);
        reverseString(s);
        isPalindrome(m);
        ShuiXianHua();
        arraysDemo();
	}

public static void showTriangle(int n){
	for(int i=1;i<=n;i++) {
		for(int k=n-1;k>=i;k--) {
			System.out.print(" ");
		}
		for(int j=1;j<=2*i-1;j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
}
public static void reverseString(String s) {
	char a=0;
	char[] chars = s .toCharArray(); 
	int num=chars.length-1;
	for(int i=0;i<=num/2+1;i++) {
		a=chars[i];
		chars[i]=chars[num];
		chars[num]=a;
		num--;
	}
	String s1 = String.valueOf(chars);
	System.out.println(s1) ;
	}	
public static void isPalindrome(int num) {
boolean flag = false;
int nums=0;
int a=num;
while(num!=0) {
	int ge=num%10;
	num=num/10;
	nums=nums*10+ge;
}
if(nums==a)
	flag=true;
else
	flag=false;
if (flag) {
System.out.println("是的") ; 
} 
else {
System.out.println("不是") ; 
}
}
public static void ShuiXianHua() {
	int a;
	int b;
	int c;
	for(int i=100;i<1000;i++) {
		a=i%10;
		b=i/10%10;
		c=i/100%10;
		if (a*a*a + b*b*b + c*c*c == i) {
			System.out.print(i+" ");
		}
	}
}
public static void arraysDemo() {
	int[] arr = new int[10];
	Scanner in =new Scanner(System.in);
	int num=0;
	for(int i =0;i<=9;i++) {
	    arr[i]=in.nextInt();
	}
	int max=arr[0];
	int min=arr[0];
	for(int j=1;j<=9;j++) {
		if(max<arr[j]) {
			max=arr[j];
		}
	}
	for(int j=1;j<=9;j++) {
		if(min>arr[j]) {
			min=arr[j];
		}
	}
	num=max+min;
	System.out.println("打印两个 最值:"+max+" "+min);
	System.out.println(max+min);
}
}