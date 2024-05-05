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
    exports org.example.gestorempleadosmatiasrojas.Controlador;
    opens org.example.gestorempleadosmatiasrojas.Controlador to javafx.fxml;
    exports org.example.gestorempleadosmatiasrojas.Modelo;
    opens org.example.gestorempleadosmatiasrojas.Modelo to javafx.fxml;
    exports org.example.gestorempleadosmatiasrojas.Modulo;
    opens org.example.gestorempleadosmatiasrojas.Modulo to javafx.fxml;
}