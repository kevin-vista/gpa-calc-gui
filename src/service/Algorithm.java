package service;

import data.Course;
import data.Student;

public strictfp class Algorithm {

	private static double simple(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double score = c.getScore();
			double credit = c.getCredit();

			if (score >= 90)
				numerator += credit * 4;
			else if (score >= 80)
				numerator += credit * 3;
			else if (score >= 70)
				numerator += credit * 2;
			else if (score >= 60)
				numerator += credit;

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double standard(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			numerator += c.getScore() * c.getCredit();
			denominator += c.getCredit();
		}
		numerator /= 25;

		return numerator / denominator;
	}

	private static double standardAdvanced1(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double credit = c.getCredit();
			double score = c.getScore();

			if (score >= 85)
				numerator += credit * 4.0;
			else if (score >= 70)
				numerator += credit * 3.0;
			else if (score >= 60)
				numerator += credit * 2.0;

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double standardAdvanced2(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double credit = c.getCredit();
			double score = c.getScore();

			if (score >= 85)
				numerator += credit * 4.0;
			else if (score >= 75)
				numerator += credit * 3.0;
			else if (score >= 60)
				numerator += credit * 2.0;

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double pekingUniversity(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double score = c.getScore();
			double credit = c.getCredit();

			if (score >= 90)
				numerator += credit * 4.0;
			else if (score >= 85)
				numerator += credit * 3.7;
			else if (score >= 82)
				numerator += credit * 3.3;
			else if (score >= 78)
				numerator += credit * 3.0;
			else if (score >= 75)
				numerator += credit * 2.7;
			else if (score >= 72)
				numerator += credit * 2.3;
			else if (score >= 69)
				numerator += credit * 2.0;
			else if (score >= 66)
				numerator += credit * 1.7;
			else if (score >= 63)
				numerator += credit * 1.3;
			else if (score >= 60)
				numerator += credit * 1.0;

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double zhejiangUniversity(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double credit = c.getCredit();
			double score = c.getScore();

			if (score >= 85)
				numerator += credit * 4.0;
			else
				numerator += credit * (score / 10 - 4.5);

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double worldEducationService(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double credit = c.getCredit();
			double score = c.getScore();

			if (score >= 85)
				numerator += credit * 4.0;
			else if (score >= 75)
				numerator += credit * 3.0;
			else if (score >= 60)
				numerator += credit * 2.0;
			else
				numerator += credit;

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double canadaFourPointThree(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double credit = c.getCredit();
			double score = c.getScore();

			if (score >= 90)
				numerator += credit * 4.3;
			else if (score >= 85)
				numerator += credit * 4.0;
			else if (score >= 80)
				numerator += credit * 3.7;
			else if (score >= 75)
				numerator += credit * 3.3;
			else if (score >= 70)
				numerator += credit * 3.0;
			else if (score >= 65)
				numerator += credit * 2.7;
			else if (score >= 60)
				numerator += credit * 2.3;

			denominator += credit;
		}

		return numerator / denominator;
	}

	private static double northeasternUniversityFive(Student student) {
		double numerator = 0;
		double denominator = 0;

		for (String s : student.courses().keySet()) {
			Course c = student.courses().get(s);
			double credit = c.getCredit();
			double score = c.getScore();

			numerator += credit * (score / 10 - 5);
			denominator += credit;
		}

		return numerator / denominator;
	}

	public static String resultOf(Student student) {
		String FORMAT = "%.4f";

		return "简单算法:\t\t\t" + String.format(FORMAT, simple(student)) +
				"\n标准算法:\t\t\t" + String.format(FORMAT, standard(student)) +
				"\n标准改进(1):\t\t" + String.format(FORMAT, standardAdvanced1(student)) +
				"\n标准改进(2):\t\t" + String.format(FORMAT, standardAdvanced2(student)) +
				"\n北大算法:\t\t\t" + String.format(FORMAT, pekingUniversity(student)) +
				"\n浙大算法:\t\t\t" + String.format(FORMAT, zhejiangUniversity(student)) +
				"\nWES算法:\t\t\t" + String.format(FORMAT, worldEducationService(student)) +
				"\n加拿大(4.3分制):\t" + String.format(FORMAT, canadaFourPointThree(student)) +
				"\n东北大学(5分制):\t" + String.format(FORMAT, northeasternUniversityFive(student));
	}

}
