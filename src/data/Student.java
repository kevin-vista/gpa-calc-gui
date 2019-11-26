package data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public strictfp class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Student singleton;

	private String id;

	private String name;

	private Map<String, Course> courses;

	private Student() {
		courses = new HashMap<>();
	}

	public static synchronized Student getInstance() {
		if (singleton == null)
			singleton = new Student();
		return singleton;
	}

	public static synchronized void setInstance(Student student) {
		singleton = student;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return Objects.equals(id, student.id) &&
				Objects.equals(name, student.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

}
