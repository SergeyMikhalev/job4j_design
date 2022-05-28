package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Voice")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"type", "lowest", "highest"})
public class Voice {

    @XmlAttribute
    private String type;
    @XmlElement(name = "LowestNote")
    private Note lowest;
    @XmlElement(name = "HighestNote")
    private Note highest;

    public Voice(String type, Note lowest, Note highest) {
        this.type = type;
        this.lowest = lowest;
        this.highest = highest;
    }

    public Voice() {
    }

    @Override
    public String toString() {
        return "Voice{"
                + "type='" + type + '\''
                + ", lowest=" + lowest
                + ", highest=" + highest
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Note noteH = new Note("C5", "good");
        final Note noteL = new Note("C3", "good");
        PrinterHelper.print(new Voice("bass", noteL, noteH));
    }
}
