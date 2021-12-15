package com.company.PringleProject3.dao;

import com.company.PringleProject3.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    List<Console> getConsolesByManufacturer(String manufacturer);

    void updateConsole(Console console);

    void deleteConsole(int id);
}
