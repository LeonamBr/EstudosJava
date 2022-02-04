module JavaFxJDBCProject {
	
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.graphics, javafx.fxml;
	opens model.entities to javafx.graphics, javafx.fxml, javafx.base;
	opens model.services to javafx.graphics, javafx.fxml;
}
