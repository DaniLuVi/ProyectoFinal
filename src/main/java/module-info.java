module es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.logging.log4j;
    requires com.google.gson;

    opens es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal to javafx.fxml;
    exports es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;
}