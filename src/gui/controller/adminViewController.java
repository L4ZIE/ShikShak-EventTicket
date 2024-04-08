package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class adminViewController {


                @FXML
                private Button customers_btn;

                @FXML
                private TableColumn<?, ?> customers_date;

                @FXML
                private TableColumn<?, ?> customers_email;

                @FXML
                private AnchorPane customers_form;

                @FXML
                private TableColumn<?, ?> customers_id;

                @FXML
                private TableColumn<?, ?> customers_name;

                @FXML
                private TableColumn<?, ?> customers_price;

                @FXML
                private TableColumn<?, ?> customers_status;

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
                private Button events_btn;

                @FXML
                private AnchorPane events_form;

                @FXML
                private TableView<?> table;



                public void switchForm(ActionEvent event) {
                        if (event.getSource() == customers_btn) {
                                customers_form.setVisible(true);
                                events_form.setVisible(false);
                        } else if (event.getSource() == events_btn) {
                                customers_form.setVisible(false);
                                events_form.setVisible(true);
                        }
                }
        }

