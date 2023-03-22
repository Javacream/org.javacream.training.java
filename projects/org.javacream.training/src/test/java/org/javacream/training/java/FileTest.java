package org.javacream.training.java;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FileTest {

    @Test public void readFile(){
        try {
            Files.readAllLines(Path.of("./pom.xml")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test public void readPropertyFile() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./application.properties"));
        Assertions.assertEquals("value1", properties.getProperty("key1"));
    }

    @Test public void javaSerialization() throws IOException {
        Address a = new Address("Irgend", "Wo");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./a.ser"))){
            oos.writeObject(a);
        }
        SerializationUtils.serialize(a, new FileOutputStream("./a_util.ser"));

    }

    @Test public void javaXmlEndcoding() throws FileNotFoundException {
        Address a = new Address("Irgend", "Wo");
        XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("./a.xml"));
        xmlEncoder.writeObject(a);
        xmlEncoder.close();

    }

}
