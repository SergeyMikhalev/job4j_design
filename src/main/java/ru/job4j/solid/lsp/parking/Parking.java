package ru.job4j.solid.lsp.parking;

import java.util.Optional;

public interface Parking {
    boolean park(Car car);

    /**
     * @author ������� ������
     * @version 1.0
     * @param idNumber ���������� �������������� ������������� ����������
     * @return true ���� ���������� ��������� �� ��������, ����� false
     */
    Optional<Car> leave(String idNumber);

    boolean present(String idNumber);
}
