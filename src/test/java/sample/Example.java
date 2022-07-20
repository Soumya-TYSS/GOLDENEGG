package sample;

import java.util.Date;

public class Example {


	public static void main(String[] args) {

		
		Date date =new Date();
		String currentdate = date.toString();
		System.out.println(currentdate);
		
		String yyyy = currentdate.split(" ")[5];
		       String mm = currentdate.split(" ")[1];
		       String dd = currentdate.split(" ")[2];
		       String time = currentdate.split(" ")[3];
		       System.out.println(dd + ":" + mm + ":" + yyyy);
               System.out.println(time);
	}

}
