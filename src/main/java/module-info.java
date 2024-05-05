module org.example.gestorempleadosmatiasrojas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.gestorempleadosmatiasrojas to javafx.fxml;
    exports org.example.gestorempleadosmatiasrojas;
    exports Controladores;
    opens Controladores to javafx.fxml;
    exports Modelo;
    opens Modelo to javafx.fxml;
    exports Modulo;
    opens Modulo to javafx.fxml;
}