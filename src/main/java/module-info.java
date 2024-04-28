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

    opens org.example.gestorempleadosmatiasrojas to javafx.fxml;
    exports org.example.gestorempleadosmatiasrojas;
    exports org.example.gestorempleadosmatiasrojas.Controlador;
    opens org.example.gestorempleadosmatiasrojas.Controlador to javafx.fxml;
    exports org.example.gestorempleadosmatiasrojas.Modelo;
    opens org.example.gestorempleadosmatiasrojas.Modelo to javafx.fxml;
}