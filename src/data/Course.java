package data;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;
import java.util.Objects;

public strictfp class Course extends RecursiveTreeObject<Course> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private double credit;

	private double score;

	public Course() {
		this.name = "";
		this.credit = 0.0;
		this.score = 0.0;
	}

	public Course(String name, double credit, double score) {
		this.name = name;
		this.credit = credit;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Course course = (Course) o;
		return Double.compare(course.credit, credit) == 0 &&
				name.equals(course.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, credit);
	}

	@Override
	public String toString() {
		return "课程名称: " + name
				+ ", 百分制成绩: " + score
				+ ", 学分: " + credit;
	}
}
