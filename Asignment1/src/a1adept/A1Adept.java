package a1adept;

import java.util.Scanner;

public class A1Adept {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		// Put your code here.

		int totalGrades = s.nextInt();
		int totalAssignments = 0;
		for (int assignments = 0; assignments < totalGrades; assignments++){
			totalAssignments += s.nextInt();
		}

		int numberStudents = s.nextInt();

		for (int students = 0; students <= numberStudents; students++){
			String firstName = s.next();
			String abbreviate = firstName.charAt(0) + ".";
			String lastName = s.next();
			double recitationPercent = s.nextDouble()/15;
			double recitationGrade = 0;
			if (recitationPercent >= .95) {
				recitationGrade = 4.0;
			} else if (recitationPercent < .95 && recitationPercent >= .9) {
				recitationGrade = (3.5 + ((recitationPercent - .9) * (4 - 3.5)) / (.95 - .9));
			} else if (recitationPercent < .9 && recitationPercent >= .8) {
				recitationGrade = (2.5 + ((recitationPercent - .8) * (3.5 - 2.5)) / (.9 - .8));
			} else if (recitationPercent < .8 && recitationPercent >= .7) {
				recitationGrade = (1.5 + ((recitationPercent - .7) * (2.5 - 1.5)) / (.8 - .7));
			} else if (recitationPercent < .7 && recitationPercent > .4) {
				recitationGrade = (0 + ((recitationPercent - .4) * (1.5 - 0)) / (.7 - .4));
			} else if (recitationPercent <= .4) {
				recitationGrade = 0;
			}

			double assignmentPercent = 0;
			double assignmentGrade = 0;
			for (int i = 0; i < totalGrades; i++){
				assignmentPercent += s.nextDouble();
			} assignmentPercent = (assignmentPercent / totalAssignments);
			for (int i = 0; i < totalGrades; i++){
				if (assignmentPercent >= .95) {
					assignmentGrade = 4.0;
				} else if (assignmentPercent < .95 && assignmentPercent >= .9) {
					assignmentGrade = (3.5 + ((assignmentPercent - .9) * (4 - 3.5)) / (.95 - .9));
				} else if (assignmentPercent < .9 && assignmentPercent >= .8) {
					assignmentGrade = (2.5 + ((assignmentPercent - .8) * (3.5 - 2.5)) / (.9 - .8));
				} else if (assignmentPercent < .8 && assignmentPercent >= .7) {
					assignmentGrade = (1.5 + ((assignmentPercent - .7) * (2.5 - 1.5)) / (.8 - .7));
				} else if (assignmentPercent < .7 && assignmentPercent > .4) {
					assignmentGrade = (0 + ((assignmentPercent - .4) * (1.5 - 0)) / (.7 - .4));
				} else if (assignmentPercent <= .4) {
					assignmentGrade = 0;
				}
			}


			double midtermGrade = (s.nextDouble())*(0.15);
			double midtermGrade2 = (s.nextDouble())*(0.15);
			double finalExam = (s.nextDouble())*(0.2);
			double average = (assignmentGrade*0.4 + recitationGrade*0.1 + midtermGrade + midtermGrade2 + finalExam);

			String letterGrade = "N/A";
			if ( average >= 3.85){
				letterGrade = "A";
			} else if( average >= 3.5 && average < 3.85){
				letterGrade = "A-";
			} else if( average >= 3.15 && average < 3.5){
				letterGrade = "B+";
			} else if( average >= 2.85 && average < 3.15){
				letterGrade = "B";
			} else if( average >= 2.5 && average < 2.85){
				letterGrade = "B-";
			} else if( average >= 2.15 && average < 2.5){
				letterGrade = "C+";
			} else if( average >= 1.85 && average < 2.15){
				letterGrade = "C";
			} else if( average >= 1.5 && average < 1.85){
				letterGrade = "C-";
			} else if( average >= 1.15 && average < 1.5){
				letterGrade = "D+";
			} else if( average >= 0.85 && average < 1.15){
				letterGrade = "D";
			} else if( average < 0.85){
				letterGrade = "F";
			}
			System.out.println(abbreviate + " " + lastName + " " + letterGrade);
		}
	}
}