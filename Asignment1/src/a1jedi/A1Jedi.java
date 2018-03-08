package a1jedi;


import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		int total = 0;
		int numass = s.nextInt();

		for (int i = 0; i < numass; i++) {
			total += s.nextInt();
		}

		int count = s.nextInt();
		double[] gradePointA = new double[count];
		double[] midtermArray = new double[count];
		double[] midterm2Array = new double[count];
		double[] finalExamArray = new double[count];

		for (int g = 0; g < count; g++) {

			double recitationGrade = 0;

			String firstName = s.next();

			String lastName = s.next();

			double recitationPercent = (s.nextDouble() / 15);

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

			recitationGrade = recitationGrade * .1;

			double points = 0;

			for (int n = 0; n < numass; n++) {
				points = points + s.nextDouble();
			}

			double assignmentTotal = (points / total);

			double assignmentGrade = 0;

			if (assignmentTotal >= .95) {
				assignmentGrade = 4.0;
			} else if (assignmentTotal < .95 && assignmentTotal >= .9) {
				assignmentGrade = (3.5 + ((assignmentTotal - .9) * (4 - 3.5)) / (.95 - .9));
			} else if (assignmentTotal < .9 && assignmentTotal >= .8) {
				assignmentGrade = (2.5 + ((assignmentTotal - .8) * (3.5 - 2.5)) / (.9 - .8));
			} else if (assignmentTotal < .8 && assignmentTotal >= .7) {
				assignmentGrade = (1.5 + ((assignmentTotal - .7) * (2.5 - 1.5)) / (.8 - .7));
			} else if (assignmentTotal < .7 && assignmentTotal > .4) {
				assignmentGrade = (0 + ((assignmentTotal - .4) * (1.5 - 0)) / (.7 - .4));
			} else if (assignmentTotal <= .4) {
				assignmentGrade = 0;
			}
			assignmentGrade = assignmentGrade * .4;

			midtermArray[g] = s.nextDouble();
			midterm2Array[g] = s.nextDouble();
			finalExamArray[g] = s.nextDouble();
			gradePointA[g] = recitationGrade + assignmentGrade;
		}

		double totalPointsMT = 0;

		double totalPointsMT2 = 0;

		double totalPointsFE = 0;

		for (int t = 0; t < count; t++) {
			totalPointsMT = totalPointsMT + midtermArray[t];
			totalPointsMT2 = totalPointsMT2 + midterm2Array[t];
			totalPointsFE = totalPointsFE + finalExamArray[t];
		}

		double meanm1 = totalPointsMT / count;

		double meanm2 = totalPointsMT2 / count;

		double meanf = totalPointsFE / count;

		double[] mean2m1 = new double[count];

		double[] mean2m2 = new double[count];

		double[] mean2f = new double[count];

		for (int p = 0; p < count; p++) {
			mean2m1[p] = (midtermArray[p] - meanm1) * (midtermArray[p] - meanm1);
			mean2m2[p] = (midterm2Array[p] - meanm2) * (midterm2Array[p] - meanm2);
			mean2f[p] = (finalExamArray[p] - meanf) * (finalExamArray[p] - meanf);
		}

		double totalm1 = 0;

		double totalm2 = 0;

		double totalf = 0;

		for (int r = 0; r < count; r++) {
			totalm1 += mean2m1[r];
			totalm2 += mean2m2[r];
			totalf += mean2f[r];
		}

		double stdm1 = Math.sqrt(totalm1 / count);

		double stdm2 = Math.sqrt(totalm2 / count);

		double stdf = Math.sqrt(totalf / count);

		double left[] = new double[count];

		for (int q = 0; q < count; q++) {
			double normm1 = (midtermArray[q] - meanm1) / stdm1;
			double midterm1Grade = norm(normm1);

			double normm2 = (midterm2Array[q] - meanm2) / stdm2;
			double midterm2Grade = norm(normm2);
			double normf = (finalExamArray[q] - meanf) / stdf;
			double finalGrade = norm(normf);

			left[q] = ((midterm1Grade * .15) + (midterm2Grade * .15) + (finalGrade * .2));
		}
		int[] book = new int[11];
		double[] gradePointAverageFin = new double[count];
		for (int q = 0; q < count; q++) {
			gradePointAverageFin[q] = left[q] + gradePointA[q];

			if (gradePointAverageFin[q] >= 3.85) {
				book[0] = book[0] + 1;
			} else if (3.5 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 3.85) {
				book[1] = book[1] + 1;
			} else if (3.15 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 3.5) {
				book[2] = book[2] + 1;
			} else if (2.85 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 3.15) {
				book[3] = book[3] + 1;
			} else if (2.5 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 2.85) {
				book[4] = book[4] + 1;
			} else if (2.15 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 2.5) {
				book[5] = book[5] + 1;
			} else if (1.85 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 2.15) {
				book[6] = book[6] + 1;
			} else if (1.5 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 1.85) {
				book[7] = book[7] + 1;
			} else if (1.15 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 1.5) {
				book[8] = book[8] + 1;
			} else if (.85 <= gradePointAverageFin[q] && gradePointAverageFin[q] < 1.15) {
				book[9] = book[9] + 1;
			} else if (gradePointAverageFin[q] < .85) {
				book[10] = book[10] + 1;
			}

		}

		System.out.println("A: " + book[0]);
		System.out.println("A-: " + book[1]);
		System.out.println("B+: " + book[2]);
		System.out.println("B: " + book[3]);
		System.out.println("B-: " + book[4]);
		System.out.println("C+: " + book[5]);
		System.out.println("C: " + book[6]);
		System.out.println("C-: " + book[7]);
		System.out.println("D+: " + book[8]);
		System.out.println("D: " + book[9]);
		System.out.println("F: " + book[10]);

	}

	public static double norm(double x) {
		double y = 0;
		if (x >= 1) {
			y = 4.0;
		} else if (x >= 0 && x < 1) {
			y = (4.0 + ((x - 1) * (4 - 3)) / (1 - 0));
		} else if (x >= -1 && x < 0) {
			y = (3.0 + ((x - 0) * (3 - 2)) / (0 + 1));
		} else if (x >= -1.5 && x < -1) {
			y = (2.0 + ((x + 1) * (2 - 1)) / (-1 + 1.5));
		} else if (x > -2 && x < -1.5) {
			y = (1.0 + ((x + 1.5) * (1 - 0)) / (-1.5 + 2));
		} else if (x <= 2) {
			y = 0;
		}

		return y;

	}

}
//A statistician walks into a bar:
//Guy: You're the most average girl out here.
//Girl: Hey, you're mean!
//Guy: No, you are.