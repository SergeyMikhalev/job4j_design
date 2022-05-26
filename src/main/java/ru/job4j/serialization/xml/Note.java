package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Note")
public class Note {

    @XmlAttribute
    private String type;
    @XmlAttribute
    private String value;
    @XmlAttribute
    private String quality;

    public Note() {
    }

    public Note(String type, String value, String quality) {
        this.type = type;
        this.value = value;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Note{"
                + "type='" + type + '\''
                + ", value='" + value + '\''
                + ", quality='" + quality + '\''
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Note note = new Note("highest", "C5", "good");
        PrinterHelper.print(note.getClass(), note);
    }
}
