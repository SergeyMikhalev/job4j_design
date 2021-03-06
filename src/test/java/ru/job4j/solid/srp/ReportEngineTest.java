package ru.job4j.solid.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.solid.srp.AccountingReportEngine.ACCOUNTING_DATE_FORMAT;
import static ru.job4j.solid.srp.AccountingReportEngine.ACCOUNTING_SALARY_FORMAT;
import static ru.job4j.solid.srp.PrgReportEngine.PRG_DATE_FORMAT;
import static ru.job4j.solid.srp.ReportEngine.DATE_FORMAT;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 10000);
        store.add(worker1);
        Employee worker2 = new Employee("Sergey", now, now, 30000);
        store.add(worker2);
        Employee worker3 = new Employee("Petr", now, now, 20000);
        store.add(worker3);
        Report engine = new HRReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountingReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(ACCOUNTING_DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(ACCOUNTING_DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(ACCOUNTING_SALARY_FORMAT.format(worker.getSalary())).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenPrgGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new PrgReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator()).append("<tr>")
                .append("<td>").append(worker.getName()).append("</td>")
                .append("<td>").append(PRG_DATE_FORMAT.format(worker.getHired().getTime())).append("</td>")
                .append("<td>").append(PRG_DATE_FORMAT.format(worker.getFired().getTime())).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td>")
                .append("<tr>")
                .append(System.lineSeparator())
                .append("</table>")
                .append(System.lineSeparator());

        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        now.set(2022, 1, 1, 1, 1, 1);
        Employee worker = new Employee("Ivan", now, now, 10000);
        store.add(worker);
        Report engine = new JSONReportEngine(store);
        String expect = new StringBuilder().append("[{\"name\":\"Ivan\",")
                .append("\"hired\":{\"year\":2022,\"month\":1,\"dayOfMonth\":1,\"hourOfDay\":1,\"minute\":1,\"second\":1},")
                .append("\"fired\":{\"year\":2022,\"month\":1,\"dayOfMonth\":1,\"hourOfDay\":1,\"minute\":1,\"second\":1},")
                .append("\"salary\":10000.0}]").toString();

        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(10_000L);

        Employee worker = new Employee("Ivan", now, now, 10000);
        store.add(worker);
        Report engine = new XMLReportEngine(store);
        String expect = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <Report>
                    <Employees>
                        <employee name="Ivan" hired="1970-01-01T03:00:10+03:00" fired="1970-01-01T03:00:10+03:00" salary="10000.0"/>
                    </Employees>
                </Report>
                """;

        assertThat(engine.generate(em -> true), is(expect));
    }
}
