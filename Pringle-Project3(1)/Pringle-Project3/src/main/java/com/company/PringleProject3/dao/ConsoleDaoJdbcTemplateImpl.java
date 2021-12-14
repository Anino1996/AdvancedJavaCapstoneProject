package com.company.PringleProject3.dao;

import com.company.PringleProject3.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;

    //Statements Strings

    private static final String INSERT_CONSOLE_SQL =
            "Insert in the console (model, manufacturer, memory_amount, processor, price, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CONSOLE_SQL =
            "select * from console where console_id = ?";

    private static final String SELECT_ALL_CONSOLE_SQL =
            "select * from console";

    private static final String SELECT_CONSOLES_BY_MANUFACTURER_SQL =
            "select * from console where manufacturer = ?";

    private static final String DELETE_CONSOLE_SQL =
            "delete from console where console_id = ?";

    private static final String UPDATE_CONSOLE_SQL =
            "update console set model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? where console_id = ?";

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    @Transactional
    public Console addConsole(Console console) {

        jdbcTemplate.update(
                INSERT_CONSOLE_SQL,
                console.getClass(),
                console.getClass(),
                console.getClass(),
                console.getClass(),
                console.getClass(),
                console.getClass(),;
        )

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        console.setId(id);
        return console;
    }

    @Override
    public Console getConsole(int id) {
        try
        {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        } catch (EmptyResultDataAccessException e)
        {
            // return null if nothing is returned
            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLE_SQL, this::mapRowToConsole);
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        try {
            return jdbcTemplate.query(SELECT_CONSOLES_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer);
        } catch (EmptyResultDataAccessException e) {
            //  return null if albulm titles do not match up
            return null;
        }
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(
                UPDATE_CONSOLE_SQL,
                console.getClass(),
                console.getClass(),
                console.getClass(),
                console.getClass(),
                console.getClass(),
                console.getClass(),;
        )
    }

    @Override
    public void deleteConsole(int id) {jdbcTemplate.update(DELETE_CONSOLE_SQL, id);}

    // row mapper
    private Console mapRowToConsole(ResultSet resultSet, int rowNum) throws SQLException{
        Console console = new Console();
        console.setId(resultSet.getInt("console_id"));
        console.setModel(resultSet.getString("model"));
        console.setManufacturer(resultSet.getString("manufacturer"));
        console.setMemoryAmount(resultSet.getString("memory_amount"));
        console.setProcessor(resultSet.getString("processor"));
        console.setPrice(resultSet.getBigDecimal("price"));
        console.setQuantity(resultSet.getInt("quantity"));
        return console;
    }
}

/* console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),;
 */

