module com.senac.avadminconfig {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.senac.avadminconfig.model to org.hibernate.orm.core;
    opens com.senac.avadminconfig to javafx.fxml;
    exports com.senac.avadminconfig;
    exports com.senac.avadminconfig.controllers;
    opens com.senac.avadminconfig.controllers to javafx.fxml;
}