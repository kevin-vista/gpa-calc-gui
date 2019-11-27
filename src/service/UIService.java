package service;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Window;

public class UIService {

	public static void showAlert(Window currentWindow, String heading, String content) {
		JFXAlert<String> alert = new JFXAlert<>(currentWindow);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.setOverlayClose(false);

		JFXDialogLayout layout = new JFXDialogLayout();

		Label headingLabel = new Label(heading);
		headingLabel.setFont(Font.font("Microsoft Yahei Bold", 24));
		layout.setHeading(headingLabel);

		Label resultLabel = new Label(content);
		resultLabel.setFont(Font.font("Microsoft Yahei", 17));
		layout.setBody(resultLabel);

		alert.setContent(layout);
		alert.showAndWait();
	}
}
