package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class PrinterHelper {
    public static <T> void print(T printObj) throws JAXBException {
        String result = doString(printObj);
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }

    public static <T> String doString(T printObj) throws JAXBException {
        String result = "";
        JAXBContext context = JAXBContext.newInstance(printObj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(printObj, writer);
            result = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}