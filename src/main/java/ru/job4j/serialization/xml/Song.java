package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Song")
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {

    @XmlAttribute
    private String name;

    public Song(String name) {
        this.name = name;
    }

    public Song() {
    }

    @Override
    public String toString() {
        return "Song{"
                + "name='" + name + '\''
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Song song = new Song("Smells like a teen spirit");
        PrinterHelper.print(song);
    }
}
