package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "Artist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Artist {

    @XmlAttribute
    private String type;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean sex;

    @XmlElement(name = "Voice")
    private Voice voice;

    @XmlElementWrapper(name = "Songs")
    @XmlElement(name = "Song")
    private Song[] songs;

    public Artist(String type, int age, boolean sex, Voice voice, Song[] songs) {
        this.type = type;
        this.age = age;
        this.sex = sex;
        this.voice = voice;
        this.songs = songs;
    }

    public Artist() {
    }

    @Override
    public String toString() {
        return "Artist{"
                + "type='" + type + '\''
                + ", age=" + age
                + ", sex=" + sex
                + ", voice=" + voice
                + ", songs=" + Arrays.toString(songs)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Note noteH = new Note("C5", "brilliant");
        final Note noteL = new Note("C3", "brilliant");
        final Voice voice = new Voice("bass", noteL, noteH);
        final Song[] songs = {new Song("Malo polovin")};
        PrinterHelper.print(new Artist("singer", 20, true, voice, songs));
    }
}
