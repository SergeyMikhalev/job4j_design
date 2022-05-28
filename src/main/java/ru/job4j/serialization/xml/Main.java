package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        personManipulations();
        artistManipulations();

    }

    private static void personManipulations() throws Exception {
        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Person.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
        System.out.println();
        System.out.println();
    }

    private static void artistManipulations() throws Exception {

        JAXBContext contextForArtist = JAXBContext.newInstance(Artist.class);
        Marshaller artistMarshaller = contextForArtist.createMarshaller();
        artistMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Artist resultArtist = null;

        Unmarshaller artistUnmarshaller = contextForArtist.createUnmarshaller();
        try (FileReader reader = new FileReader("./Artist.xml")) {
            resultArtist = (Artist) artistUnmarshaller.unmarshal(reader);
            System.out.println(resultArtist);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        String artistXml = "";
        if (resultArtist != null) {
            try (StringWriter writer = new StringWriter()) {

                artistMarshaller.marshal(resultArtist, writer);
                artistXml = writer.getBuffer().toString();
                System.out.println(artistXml);
            }
            System.out.println();
            System.out.println();
        }

    }
}
