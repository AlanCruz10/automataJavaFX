package com.project.automata.services;

import com.project.automata.services.dtos.Plate;
import com.project.automata.services.interfaces.IPlateService;

import java.util.*;

public class PlateServiceImpl implements IPlateService {

    public PlateServiceImpl() {
    }

    private static final List<String> ALPHABET = Arrays.stream("abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT).strip().split("")).toList();

    private static final Integer[] NUMBERS = {0,1,2,3,4,5,6,7,8,9};

    private final List<String> startPlate = Arrays.stream("WXA-001-A".toUpperCase(Locale.ROOT).strip().split("")).toList();

    private final List<String> endPlate = Arrays.stream("XSZ-999-Z".toUpperCase(Locale.ROOT).strip().split("")).toList();

    private final List<String> statesList = new ArrayList<>();


    @Override
    public Plate validatePlateFinal(String plate) {
        Plate plateDto = createPlate(plate);
        List<String> plateArray = Arrays.stream(plateDto.getPlate().strip().toUpperCase(Locale.ROOT).split("")).toList();
        String state = "q0";
        List<String> states = plateDto.getStates();
        states.add(state);
        for (String p: plateArray) {
            state = validateStates(p, state);
            plateDto.getStates().add(state);
            if (state.equals("Error")){
                break;
            }
        }
        if (states.stream().anyMatch(s -> s.equals("Error")) || plateArray.size() < startPlate.size() && plateArray.size() < endPlate.size()){
            plateDto.setStates(states);
            plateDto.setStatus(Boolean.FALSE);
        }else{
            plateDto.setStates(states);
            plateDto.setStatus(Boolean.TRUE);
        }
        return plateDto;
    }

    private Plate createPlate(String plate){
        Plate plateDto = new Plate();
        plateDto.setPlate(plate);
        plateDto.setStatus(false);
        plateDto.setStates(statesList);
        return plateDto;
    }

    private String validateStates(String p, String state){
        String switchState = state;
        switch (switchState){
            case "q0" -> {
                if (!q0(p).equals("q0")) {
                    switch (q0(p)) {
                        case "W" -> {
                            switchState = "q1";
                        }
                        case "X" -> {
                            switchState = "q15";
                        }
                    }
                } else {
                    switchState =  "Error";
                }
            }
            case "q1" -> {
                if (!q1(p).equals("q1")) {
                    switchState = "q2";
                }else {
                    switchState = "Error";
                }
            }
            case "q2" -> {
                if (!q2(p).equals("q2")) {
                    switchState = "q3";
                }else {
                    switchState = "Error";
                }
            }
            case "q3" -> {
                if (!q3(p).equals("q3")) {
                    switchState = "q4";
                }else {
                    switchState = "Error";
                }
            }
            case "q4" -> {
                if (!q4(p).equals("q4")){
                    if (Integer.parseInt(q4(p)) == 0){
                        switchState = "q5";
                    }else{
                        switchState = "q10";
                    }
                }else {
                    switchState = "Error";
                }
            }
            case "q5" -> {
                if (!q5(p).equals("q5")){
                    if (Integer.parseInt(q5(p)) == 0){
                        switchState = "q6";
                    }else{
                        switchState = "q8";
                    }
                }else {
                    switchState = "Error";
                }
            }
            case "q6" -> {
                if (!q6(p).equals("q6")){
                    if (Integer.parseInt(q6(p)) >= 1 && Integer.parseInt(q6(p)) <= 9 ){
                        switchState = "q7";
                    }else{
                        switchState = "Error";
                    }
                }else {
                    switchState = "Error";
                }
            }
            case "q7" -> {
                if (!q7(p).equals("q7")) {
                    switchState = "q13";
                }else {
                    switchState = "Error";
                }
            }
            case "q8" -> {
                if (!q8(p).equals("q8")){
                    switchState = "q9";
                }else {
                    switchState = "Error";
                }
            }
            case "q9" -> {
                if (!q9(p).equals("q9")) {
                    switchState = "q13";
                }else {
                    switchState = "Error";
                }
            }
            case "q10" -> {
                if (!q10(p).equals("q10")){
                    switchState = "q11";
                }else {
                    switchState = "Error";
                }
            }
            case "q11" -> {
                if (!q11(p).equals("q11")){
                    switchState = "q12";
                }else {
                    switchState = "Error";
                }
            }
            case "q12" -> {
                if (!q12(p).equals("q12")) {
                    switchState = "q13";
                }else {
                    switchState = "Error";
                }
            }
            case "q13" -> {
                if (!q13(p).equals("q13")) {
                    switchState = "q14";
                }else {
                    switchState = "Error";
                }
            }
            case "q14" -> {
                switchState = q14();
            }
            case "q15" -> {
                if (!q15(p).equals("q15")) {
                    switchState = "q2";
                }else {
                    switchState = "Error";
                }
            }
            default -> {
                switchState = "Error";
            }
        }
        return switchState;
    }

    private Boolean rangeOfLetters(String startLetter, String endLetter, String letter){
        try{
            List<String> letters = ALPHABET.subList(ALPHABET.indexOf(startLetter), ALPHABET.indexOf(endLetter) + 1);
            return letters.stream().anyMatch(l -> l.compareTo(letter) == 0);
        }catch (Exception e){
            return false;
        }

    }

    private Boolean rangeOfNumbers(String startLetter, String endLetter, String letter){
        try {
            return Arrays.stream(NUMBERS).anyMatch(n -> n == Integer.parseInt(letter));
        }catch (Exception e){
            return false;
        }

    }

    public String q0(String p){
        Boolean q0Boolean = rangeOfLetters(startPlate.get(0), endPlate.get(0), p);
        if (q0Boolean){
            return p;
        }else {
            return "q0";
        }
    }

    public String q1(String p){
        Boolean q1Boolean = rangeOfLetters(startPlate.get(1), ALPHABET.get(ALPHABET.size() - 1), p);
        if (q1Boolean){
            return p;
        }else{
            return "q1";
        }
    }

    public String q2(String p){
        Boolean q2Boolean = rangeOfLetters(startPlate.get(2), endPlate.get(2), p);
        if (q2Boolean){
            return p;
        }else {
            return "q2";
        }
    }

    public String q3(String p){
        if(p.equals("-")){
            return p;
        }else {
            return "q3";
        }
    }

    public String q4(String p){
        Boolean q4Boolean = rangeOfNumbers(startPlate.get(4), endPlate.get(4), p);
        if (q4Boolean){
            return p;
        }else {
            return "q4";
        }
    }

    public String q5(String p){
        Boolean q5Boolean = rangeOfNumbers(startPlate.get(5), endPlate.get(5), p);
        if (q5Boolean){
            return p;
        }else {
            return "q5";
        }
    }

    public String q6(String p){
        Boolean q6Boolean = rangeOfNumbers(startPlate.get(6), endPlate.get(6), p);
        if (q6Boolean){
            return p;
        }else {
            return "q6";
        }
    }

    public String q7(String p){
        if(p.equals("-")){
            return p;
        }else {
            return "q7";
        }
    }

    public String q8(String p){
        Boolean q8Boolean = rangeOfNumbers(startPlate.get(6), endPlate.get(6), p);
        if (q8Boolean){
            return p;
        }else {
            return "q8";
        }
    }

    public String q9(String p){
        if(p.equals("-")){
            return p;
        }else {
            return "q9";
        }
    }

    public String q10(String p){
        Boolean q10Boolean = rangeOfNumbers(startPlate.get(5), endPlate.get(5), p);
        if (q10Boolean){
            return p;
        }else {
            return "q10";
        }
    }

    public String q11(String p){
        Boolean q10Boolean = rangeOfNumbers(startPlate.get(6), endPlate.get(6), p);
        if (q10Boolean){
            return p;
        }else {
            return "q11";
        }
    }

    public String q12(String p){
        if(p.equals("-")){
            return p;
        }else {
            return "q12";
        }
    }

    public String q13(String p){
        Boolean q2Boolean = rangeOfLetters(startPlate.get(8), endPlate.get(8), p);
        if (q2Boolean){
            return p;
        }else {
            return "q13";
        }
    }

    public String q14(){
        return "Error";
    }

    public String q15(String p){
        Boolean q1Boolean = rangeOfLetters(ALPHABET.get(ALPHABET.size() - (ALPHABET.size() - 1) - 1), endPlate.get(1), p);
        if (q1Boolean){
            return p;
        }else {
            return "q15";
        }
    }

}