package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class PrinterHelper {
    public static <T> void print(Class<? extends T> printClass, T printObj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(printClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(printObj, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
    }
}
