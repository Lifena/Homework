package com.sxt;

import java.util.Scanner;
public class Hello {
	 public static void main(String wanshu[]){
		 Scanner in = new Scanner(System.in);
	        double x, y;
	        System.out.println("Please input the horizontal (X) : ");
	        x = in.nextDouble();
	        System.out.println("Please input the ordinate (Y) : ");
	        y = in.nextDouble();
	        MyPoint point=new MyPoint(x,y);
	        point.show();

	    }
	}

	class MyPoint {

	    double x,y;

	    public MyPoint(double x,double y) {
	      this.x=x;
	      this.y=y;
	    }

	    void show() {
	        System.out.println("Your location of horizontal (X) is :" +x);
	        System.out.println("Your location of ordinate (Y) is :" + y);



	    }
}