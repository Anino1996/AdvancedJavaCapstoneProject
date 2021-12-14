package com.company.PringleProject3.controller;

import com.company.PringleProject3.dao.ConsoleDao;
import com.company.PringleProject3.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleDao consoleDao;

    // get all

    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsloles() {
        System.out.println("Getting all the consoles...");
        return consoleDao.getAllConsoles();
    }

    //get by manufacture

    //get by id

    //add console
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        System.out.println("creating new console");
        return consoleDao.addConsole(console);
    }

    //update console
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        System.out.println("Updating the console id = " + console.getId());
        consoleDao.updateConsole(console);
    }

    //delete console
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        System.out.println("console has been deleted");
        consoleDao.deleteConsole(id);
    }
}
