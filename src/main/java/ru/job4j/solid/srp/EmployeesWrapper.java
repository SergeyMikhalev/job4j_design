package ru.job4j.solid.srp;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "Report")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesWrapper {

    @XmlElementWrapper(name = "Employees")
    @XmlElement(name = "employee")
    private List<Employee> elements;

    public EmployeesWrapper() {
    }

    public EmployeesWrapper(List<Employee> elements) {
        this.elements = elements;
    }

    public List<Employee> getElements() {
        return elements;
    }

    public void setElements(List<Employee> elements) {
        this.elements = elements;
    }
}
