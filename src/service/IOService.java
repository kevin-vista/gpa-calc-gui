package service;

import data.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOService {

	public static final String DATA_FILE = System.getProperty("user.home") + "\\data.gc";

	public static synchronized void readStudent(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
		Student s = (Student) inputStream.readObject();
		Student.setInstance(s);
		inputStream.close();
	}

	public static synchronized void writeStudent(String filename) throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename, false));
		outputStream.writeObject(Student.getInstance());
		outputStream.flush();
		outputStream.close();
	}

}
