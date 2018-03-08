package a1novice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
	}

	public static void process(Scanner s) {
		// Put your code here.
		String Grade = new String();
		int students_length = s.nextInt();
		//s.nextLine();
for(int students = 0; students <= students_length; students++){	
		
		//System.out.println(s.next());
		String firstName = s.next();
		
		//System.out.println(s.next());
		String lastName = s.next();
		
		//System.out.println(s.nextDouble()*0.4);
		double assignmentGrade = s.nextDouble()*0.4;
		
		//System.out.println(s.nextDouble()*0.1);
		double recitationGrade = s.nextDouble()*0.1;
		
		//System.out.println(s.nextDouble()*0.15);
		double midterm = s.nextDouble()*0.15;
		
		//System.out.println(s.nextDouble()*0.15);
		double midterm2 = s.nextDouble()*0.15;
		
	//	System.out.println(s.nextDouble()*0.2);
		double finalExam = s.nextDouble()*0.2;
		s.nextLine();
		
		double average = (assignmentGrade + recitationGrade + midterm + midterm2 + finalExam);
		//System.out.println(Average);
		
		if (average >= 3.85){
			Grade = "A";
		} else if (3.5 <= average && average < 3.85) {
			Grade = "A-";	
		} else if (3.15 <= average && average < 3.5) {
			Grade = "B+";
		} else if (2.85 <= average && average < 3.15) {
			Grade = "B";
		} else if (2.5 <= average && average < 2.85) {
			Grade = "B-";
		} else if (2.15 <= average && average < 2.5) {
			Grade = "C+";
		} else if (1.85 <= average && average < 2.15) {
			Grade = "C";
		} else if (1.5 <= average && average < 1.85) {
			Grade = "C-";
		} else if (1.15 <= average && average < 1.5) {
			Grade = "D+";
		} else if (0.85 <= average && average < 1.15) {
			Grade = "D";
		} else if (average < 0.85) {
			Grade = "F";
		}
		int sum = 0;
		
		for (int i=0; i<4; i++){
			for(int j=i; j<i*2; j++){
				if (j<4) {
					sum++;
				} else {
					sum--;
				}
			}
		}
		System.out.println(sum);
		
		System.out.println(firstName.charAt(0)+ "." + " " + lastName + " " + Grade);
			}
		}	
	}
	
//}
