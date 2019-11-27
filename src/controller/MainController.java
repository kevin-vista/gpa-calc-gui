package controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import data.Course;
import data.Student;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.converter.DefaultStringConverter;
import service.Algorithm;
import service.IOService;
import service.UIService;

import java.io.IOException;

public class MainController {

	@FXML
	private GridPane rootGridPain;
	@FXML
	private FontAwesomeIconView saveIcon;
	@FXML
	private Label promptLabel;
	@FXML
	private JFXTreeTableView<Course> courseTable;
	@FXML
	private JFXTreeTableColumn<Course, String> nameColumn;
	@FXML
	private JFXTreeTableColumn<Course, String> creditColumn;
	@FXML
	private JFXTreeTableColumn<Course, String> scoreColumn;

	private Student student;

	@FXML
	private void initialize() {
		student = Student.getInstance();

		// Initialize courseTable
		TreeItem<Course> root = new TreeItem<>(new Course());
		root.setExpanded(true);
		courseTable.setRoot(root);

		nameColumn.setCellValueFactory(p ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getName()));
		nameColumn.setCellFactory(p -> new TextFieldTreeTableCell<>(new DefaultStringConverter()));

		creditColumn.setCellValueFactory(p ->
				new ReadOnlyStringWrapper(String.valueOf(p.getValue().getValue().getCredit())));
		creditColumn.setCellFactory(p -> new TextFieldTreeTableCell<>(new DefaultStringConverter()));

		scoreColumn.setCellValueFactory(p ->
				new ReadOnlyStringWrapper(String.valueOf(p.getValue().getValue().getScore())));
		scoreColumn.setCellFactory(p -> new TextFieldTreeTableCell<>(new DefaultStringConverter()));

		// Fill courseTable with the singleton Student's courses
		for (String s : student.courses().keySet()) {
			root.getChildren().add(new TreeItem<>(student.courses().get(s)));
			System.out.println("Added course: " + student.courses().get(s).getName());
		}
	}

	@FXML
	private void onCalculateClicked() {
		UIService.showAlert(rootGridPain.getScene().getWindow(),
				"GPA计算结果",
				Algorithm.resultOf(Student.getInstance()) + "\n\n\n(按ESC键关闭此窗口)");
	}

	@FXML
	private void onCourseCommit(TreeTableColumn.CellEditEvent<Course, String> editEvent) {
		editEvent.getRowValue().getValue().setName(editEvent.getNewValue());
		student.courses().remove(editEvent.getOldValue());
		student.courses().put(
				editEvent.getNewValue(),
				editEvent.getRowValue().getValue());

		courseTable.refresh();
	}

	@FXML
	private void onCreditCommit(TreeTableColumn.CellEditEvent<Course, String> editEvent) {
		try {
			editEvent.getRowValue().getValue().setCredit(Double.parseDouble(editEvent.getNewValue()));
			student.courses().put(
					editEvent.getRowValue().getValue().getName(),
					editEvent.getTreeTablePosition().getTreeItem().getValue());
		} catch (NumberFormatException e) {
			promptLabel.setTextFill(Color.RED);
			promptLabel.setText("学分格式错误");
		} finally {
			courseTable.refresh();
		}

	}

	@FXML
	private void onScoreCommit(TreeTableColumn.CellEditEvent<Course, String> editEvent) {
		try {
			editEvent.getRowValue().getValue().setScore(Double.parseDouble(editEvent.getNewValue()));
			student.courses().put(
					editEvent.getRowValue().getValue().getName(),
					editEvent.getTreeTablePosition().getTreeItem().getValue());
		} catch (NumberFormatException e) {
			promptLabel.setTextFill(Color.RED);
			promptLabel.setText("成绩格式错误 (请输入百分制成绩)");
		} finally {
			courseTable.refresh();
		}
	}

	@FXML
	private void onAddCourse() {
		courseTable.getRoot().getChildren().add(new TreeItem<>(new Course()));
		courseTable.refresh();
	}

	@FXML
	private void onRemoveCourse() {
		int focusedIndex = courseTable.getSelectionModel().getFocusedIndex();
		if (focusedIndex >= 0) {
			student.courses().remove(courseTable.getRoot().getChildren().get(focusedIndex).getValue().getName());
			courseTable.getRoot().getChildren().remove(focusedIndex);
			courseTable.refresh();
		}
	}

	@FXML
	private void onSaveClicked() {
		promptLabel.setTextFill(Color.DIMGREY);
		promptLabel.setText("保存数据...");
		try {
			IOService.writeStudent(IOService.DATA_FILE);
			promptLabel.setText("已保存");
			promptLabel.setText("");
		} catch (IOException e) {
			e.printStackTrace();
			promptLabel.setTextFill(Color.RED);
			promptLabel.setText("文件读写异常: " + e.getMessage());
		}
	}

	// Simulates an animation effect for the 'save' icon
	@FXML
	private void onSavePressed() {
		saveIcon.setFont(Font.font("FontAwesome Regular", 23));
	}
	@FXML
	private void onSaveReleased() {
		saveIcon.setFont(Font.font("FontAwesome Regular", 25));
	}

}
