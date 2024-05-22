module es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.logging.log4j;
    requires com.google.gson;

    opens es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal to javafx.fxml, com.google.gson;
    exports es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;
    opens estructuras_de_datos_implementadas.listaDoblementeEnlazada to com.google.gson;
    exports estructuras_de_datos_implementadas.listaDoblementeEnlazada;
    opens estructuras_de_datos_implementadas.listaSimple to com.google.gson;
    exports estructuras_de_datos_implementadas.listaSimple;
    opens clases_a_utilizar_de_datos to com.google.gson;
    exports clases_a_utilizar_de_datos;
}