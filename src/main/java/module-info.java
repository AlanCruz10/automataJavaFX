module com.project.automata {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
            
    opens com.project.automata to javafx.fxml;
    exports com.project.automata;
}