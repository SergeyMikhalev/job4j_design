package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note {


    @XmlAttribute
    private String value;
    @XmlAttribute
    private String quality;

    public Note() {
    }

    public Note(String value, String quality) {
        this.value = value;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Note{"
                + "value='" + value + '\''
                + ", quality='" + quality + '\''
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Note note = new Note("C5", "good");
        PrinterHelper.print(note);
    }
}
