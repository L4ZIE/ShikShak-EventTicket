package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class coordinatorController {


    @FXML
    private Button addevents_btn;

    @FXML
    private AnchorPane addevents_form;

    @FXML
    private Button coordinators_btn;

    @FXML
    private AnchorPane coordinators_form;

    @FXML
    private TableColumn<?, ?> event_action;

    @FXML
    private TableColumn<?, ?> event_date;

    @FXML
    private TableColumn<?, ?> event_id;

    @FXML
    private TableColumn<?, ?> event_location;

    @FXML
    private TableColumn<?, ?> event_name;

    @FXML
    private TableColumn<?, ?> event_start;

    @FXML
    private TableColumn<?, ?> event_status;

    @FXML
    private AnchorPane events_form;

    @FXML
    private Button tickets_btn;

    @FXML
    private AnchorPane tickets_form;

    public void switchForm(ActionEvent event) {
        if (event.getSource() == addevents_btn) {
            addevents_form.setVisible(true);
            coordinators_form.setVisible(false);
            tickets_form.setVisible(false);
        } else if (event.getSource() == coordinators_btn) {
            addevents_form.setVisible(false);
            coordinators_form.setVisible(true);
            tickets_form.setVisible(false);
        } else if (event.getSource() == tickets_btn) {
            addevents_form.setVisible(false);
            coordinators_form.setVisible(false);
            tickets_form.setVisible(true);

        }
    }
}





