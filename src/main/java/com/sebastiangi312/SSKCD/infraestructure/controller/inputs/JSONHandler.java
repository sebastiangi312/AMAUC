package com.sebastiangi312.SSKCD.infraestructure.controller.inputs;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JSONHandler {
  
  public static JSONObject readJSON(String pensum) {
    File resource;
    try {
      final String PATH = "pensums/" + pensum + ".json";
      resource = new ClassPathResource(PATH).getFile();
      String text = new String(Files.readAllBytes(resource.toPath()));
      JSONParser parser = new JSONParser();
      return (JSONObject) parser.parse(text);
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static  Object getProperty(Object JSONObject, String property){
    return ((JSONObject)JSONObject).get(property);
  }
  
}
