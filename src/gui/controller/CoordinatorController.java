package gui.controller;

import be.Events;
import dal.EventsDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class CoordinatorController {

    @FXML
    private Button addevents_btn;
    @FXML
    private AnchorPane addevents_form;
    @FXML
    private Button coordinators_btn;
    @FXML
    private AnchorPane coordinators_form;
    @FXML
    private TableView<Events> eventsTableView;
    @FXML
    private TableColumn<?, ?> event_name;
    @FXML
    private TableColumn<?, ?> event_startDate;
    @FXML
    private TableColumn<?, ?> event_endDate;
    @FXML
    private TableColumn<?, ?> event_location;
    @FXML
    private TableColumn<?, ?> event_locationGuidance;
    @FXML
    private TableColumn<?, ?> event_Notes;
    @FXML
    private AnchorPane events_form;
    @FXML
    private Button tickets_btn;
    @FXML
    private AnchorPane tickets_form;
    private Events selectedEvent;
    @FXML
    public TextField nameTxtField;
    @FXML
    public TextField locationTxtField;
    @FXML
    public TextField locationGuidanceTxtField;
    @FXML
    public TextField notesTxtField;
    @FXML
    public DatePicker dateStart;
    @FXML
    public DatePicker dateEnd;
    private CoordinatorController coordinatorController;
    private EventsDAO eventsDAO;



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

    public void initialize(){
        setEventsTable();
        loadAllEvents();

    }

    public void setEventsTable(){
        EventsDAO eventsDAO = new EventsDAO();
        List<Events> data = eventsDAO.getAllEvents();
        ObservableList<Events> observableData = FXCollections.observableArrayList(data);
        eventsTableView.setItems(observableData);

        // set up the columns in the TableView
        TableColumn<Events, String> event_name = (TableColumn<Events, String>) eventsTableView.getColumns().get(0);
        TableColumn<Events, String> event_startDate = (TableColumn<Events, String>) eventsTableView.getColumns().get(1);
        TableColumn<Events, String> event_endDate = (TableColumn<Events, String>) eventsTableView.getColumns().get(2);
        TableColumn<Events, String> event_location = (TableColumn<Events, String>) eventsTableView.getColumns().get(3);
        TableColumn<Events, String> event_locationGuidance= (TableColumn<Events, String>) eventsTableView.getColumns().get(4);
        TableColumn<Events, String> event_Notes = (TableColumn<Events, String>) eventsTableView.getColumns().get(5);

        // define cell value factories for each column
        event_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventName()));
        event_startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate()));
        event_endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate()));
        event_location.setCellValueFactory(cellData -> new SimpleStringProperty (cellData.getValue().getEventLocation()));
        event_locationGuidance.setCellValueFactory(cellData -> new SimpleStringProperty (cellData.getValue().getLocationGuidance()));
        event_Notes.setCellValueFactory(cellData -> new SimpleStringProperty (cellData.getValue().getNotes()));
    }

   public void addEvent(ActionEvent event) {
        String name = nameTxtField.getText();
        LocalDate startDate = dateStart.getValue();
        LocalDate endDate = dateEnd.getValue();
        String location = locationTxtField.getText();
        String locationGuidance = locationGuidanceTxtField.getText();
        String notes = notesTxtField.getText();

        if (name.isEmpty() || startDate == null || endDate == null || location.isEmpty() || notes.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();
            return;
        }


        Events newEvent = new Events(0, name, startDate.toString(), endDate.toString(), location, locationGuidance, notes);

        EventsDAO eventsDAO = new EventsDAO();
        eventsDAO.createEvent(newEvent);

        setEventsTable();
        clearInputFields();
   }

    // clear input fields after adding an event
   private void clearInputFields() {
       nameTxtField.clear();
       dateStart.setValue(null);
       dateEnd.setValue(null);
       locationTxtField.clear();
       locationGuidanceTxtField.clear();
       notesTxtField.clear();
   }

    public void loadAllEvents() {
        EventsDAO eventsDAO = new EventsDAO();
        List<Events> allEvents = eventsDAO.getAllEvents();
        ObservableList<Events> observableList = FXCollections.observableArrayList(allEvents);
        eventsTableView.getItems().setAll(allEvents);
    }


    public void clearFields(ActionEvent event) {
        nameTxtField.clear();
        dateStart.setValue(null);
        dateEnd.setValue(null);
        locationTxtField.clear();
        locationGuidanceTxtField.clear();
        notesTxtField.clear();
    }
}





