package com.dkfedko;
import java.io.File;
import java.util.HashMap;

public class HashMapSample {
public static void main(String[] args) {

    HashMap<Object, Object> healthCare = new HashMap<>();

    healthCare.put("Oleg", "This is information about Oleg's health insurance..." );
    healthCare.put("Stas", "Here is File ");
    healthCare.put("Dima", "Insurance file");
    healthCare.replace("Dima", "NewInfo");
    healthCare.replace("Stas", "Here is File ", "updatedInfo");

    System.out.println(healthCare.get("Stas"));
    System.out.println(healthCare.get("Oleg"));
    System.out.println(healthCare.containsKey("Oleg"));
    System.out.println(healthCare.containsKey("Danylo"));
    System.out.println(healthCare.get("Dima"));
    System.out.println(healthCare.isEmpty());
    System.out.println(healthCare.keySet());
    System.out.println(healthCare.entrySet());
    System.out.println(healthCare.clone());
    System.out.println(healthCare.remove("Oleg"));

}
}
