package data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student implements Serializable {

	private static final int INITIAL_CAPACITY = 64;

	private static final long serialVersionUID = 1L;

	private static Student singleton;

	private String name;

	private Map<String, Course> courses;

	private Student() {
		courses = new HashMap<>(INITIAL_CAPACITY);
	}

	public static synchronized Student getInstance() {
		if (singleton == null)
			singleton = new Student();
		return singleton;
	}

	public static synchronized void setInstance(Student student) {
		singleton = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Course> courses() {
		return courses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(name, student.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
