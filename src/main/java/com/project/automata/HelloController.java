package com.project.automata;

import com.project.automata.services.PlateServiceImpl;
import com.project.automata.services.dtos.Plate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HelloController {

    private final static PlateServiceImpl plateService = new PlateServiceImpl();

    @FXML
    public Circle q0;


    @FXML
    public Circle q1;


    @FXML
    public Circle q2;


    @FXML
    public Circle q3;


    @FXML
    public Circle q4;


    @FXML
    public Circle q5;


    @FXML
    public Circle q6;


    @FXML
    public Circle q7;


    @FXML
    public Circle q8;


    @FXML
    public Circle q9;


    @FXML
    public Circle q10;


    @FXML
    public Circle q11;


    @FXML
    public Circle q12;


    @FXML
    public Circle q13;


    @FXML
    public Circle q14;


    @FXML
    public Circle q15;


    @FXML
    public Circle q14b;

    @FXML
    public Pane resultPanel;

    @FXML
    public Label resultLabelRute;

    @FXML
    public Pane resultPanelRute;


    @FXML
    private TextField plateTextField;


    @FXML
    private Label resultLabel;


    @FXML
    void validatePlate(ActionEvent event) throws Exception {
        String plate = plateTextField.getText();

        try {
            Plate plateDto = plateService.validatePlateFinal(plate);
            List<String> states = plateDto.getStates();
            for (String p: states) {
                Thread.sleep(300);
                q0.setFill(Paint.valueOf(Colors.WHITE.cod));
                q1.setFill(Paint.valueOf(Colors.WHITE.cod));
                q2.setFill(Paint.valueOf(Colors.WHITE.cod));
                q3.setFill(Paint.valueOf(Colors.WHITE.cod));
                q4.setFill(Paint.valueOf(Colors.WHITE.cod));
                q5.setFill(Paint.valueOf(Colors.WHITE.cod));
                q6.setFill(Paint.valueOf(Colors.WHITE.cod));
                q7.setFill(Paint.valueOf(Colors.WHITE.cod));
                q8.setFill(Paint.valueOf(Colors.WHITE.cod));
                q9.setFill(Paint.valueOf(Colors.WHITE.cod));
                q10.setFill(Paint.valueOf(Colors.WHITE.cod));
                q11.setFill(Paint.valueOf(Colors.WHITE.cod));
                q12.setFill(Paint.valueOf(Colors.WHITE.cod));
                q13.setFill(Paint.valueOf(Colors.WHITE.cod));
                q14.setFill(Paint.valueOf(Colors.WHITE.cod));
                q15.setFill(Paint.valueOf(Colors.WHITE.cod));
                Thread.sleep(300);
                switch (p){
                    case "q0" -> {
                        q0.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q1" -> {
                        q1.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q2" -> {
                        q2.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q3" -> {
                        q3.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q4" -> {
                        q4.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q5" -> {
                        q5.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q6" -> {
                        q6.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q7" -> {
                        q7.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q8" -> {
                        q8.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q9" -> {
                        q9.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q10" -> {
                        q10.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q11" -> {
                        q11.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q12" -> {
                        q12.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q13" -> {
                        q13.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q14" -> {
                        q14.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    case "q15" -> {
                        q15.setFill(Paint.valueOf(Colors.GREEN.cod));
                    }
                    default -> {
//                        q14.setFill(Paint.valueOf("#01DF01"));
                    }
                }
                Thread.sleep(300);
            }

            if (!plateDto.getStatus() || Objects.equals(states.get(states.size() - 1), "Error")){
                Thread.sleep(300);
                switch (states.get(states.size() - 1)){
                    case "q0" -> {
                        q0.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q1" -> {
                        q1.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q2" -> {
                        q2.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q3" -> {
                        q3.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q4" -> {
                        q4.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q5" -> {
                        q5.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q6" -> {
                        q6.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q7" -> {
                        q7.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q8" -> {
                        q8.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q9" -> {
                        q9.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q10" -> {
                        q10.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q11" -> {
                        q11.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q12" -> {
                        q12.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q13" -> {
                        q13.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q14" -> {
                        q14.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    case "q15" -> {
                        q15.setFill(Paint.valueOf(Colors.RED.cod));
                    }
                    default -> {
                        switch (states.get(states.size() - 2)) {
                            case "q0" -> {
                                q0.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q1" -> {
                                q1.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q2" -> {
                                q2.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q3" -> {
                                q3.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q4" -> {
                                q4.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q5" -> {
                                q5.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q6" -> {
                                q6.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q7" -> {
                                q7.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q8" -> {
                                q8.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q9" -> {
                                q9.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q10" -> {
                                q10.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q11" -> {
                                q11.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q12" -> {
                                q12.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q13" -> {
                                q13.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q14" -> {
                                q14.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                            case "q15" -> {
                                q15.setFill(Paint.valueOf(Colors.RED.cod));
                            }
                        }
                    }
                }

                BackgroundFill backgroundFill = new BackgroundFill(Color.RED, new CornerRadii(20), null);
                resultPanel.setBackground(new Background(backgroundFill));
                resultPanelRute.setBackground(new Background(backgroundFill));
//                resultPanel.setBorder(new Border(new BorderStroke(
//                        Color.BLUE,
//                        BorderStrokeStyle.SOLID,
//                        new CornerRadii(20),
//                        new BorderWidths(2)
//                )));
                resultLabel.setText("Matricula " + plateDto.getPlate() +" invalida" );
                List<String> rute = new ArrayList<>();
                for (String r: states) {
                    rute.add(r);
                    rute.add("->");
                }
                resultLabel.setText("Matricula " + plateDto.getPlate() +" invalida" );
                resultLabelRute.setText(rute.toString());
                states.clear();
            }else {

                BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, new CornerRadii(20), null);
                resultPanel.setBackground(new Background(backgroundFill));
                resultPanelRute.setBackground(new Background(backgroundFill));
                List<String> rute = new ArrayList<>();
                for (String r: states) {
                    rute.add(r);
                    rute.add("->");
                }
                resultLabel.setText("Matricula " + plateDto.getPlate() +" valida" );
                resultLabelRute.setText(rute.toString());
                states.clear();
            }



        } catch (NumberFormatException e) {
            throw new Exception("Matricula no valida");
        }
    }

    public enum Colors {
        WHITE("#ffffff"),
        RED("#FF0000"),
        GREEN("#01DF01");

        private final String cod;

        Colors(String cod) {
            this.cod = cod;
        }

        public String getCod() {
            return cod;
        }
    }

}