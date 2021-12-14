package com.capstone.AninPringleOfori.dao;

import com.capstone.AninPringleOfori.model.order.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoImpl implements ProcessingFeeDao {
    public static final String FIND_FEE_SQL = "select * from processing_fee where product_type = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee getFee(String product_type) {
        return jdbcTemplate.queryForObject(FIND_FEE_SQL, this::mapRowToProcessingFee, product_type);
    }

    public ProcessingFee mapRowToProcessingFee(ResultSet resultSet, int rowNum) throws SQLException {
        return new ProcessingFee(
                resultSet.getString("product_type"),
                resultSet.getDouble("fee"));
    }
}
