package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void sphereVertexes() {
        Box box = new Box(0, 10);
        Integer vertexes = box.getNumberOfVertices();
        assertThat(vertexes).isZero();
    }

    @Test
    void cubeVertexes() {
        Box box = new Box(8, 12);
        Integer vertexes = box.getNumberOfVertices();
        assertThat(vertexes).isEqualTo(8);
    }

    @Test
    void isExist() {
        Box box = new Box(8, 12);
        Boolean exists = box.isExist();
        assertThat(exists).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(169, 12);
        Boolean exists = box.isExist();
        assertThat(exists).isFalse();
    }

    @Test
    void areaOfSphere() {
        Box box = new Box(0, 10);
        Double area = box.getArea();
        assertThat(area).isEqualTo(1256.6370614359173);
    }

    @Test
    void areaOfCube() {
        Box box = new Box(8, 10);
        Double area = box.getArea();
        assertThat(area).isEqualTo(600.0);
    }


}