package com.itc.pmb.rowmapper;

import com.itc.pmb.domain.Stats;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatsRowMapper implements RowMapper<Stats> {
    @Override
    public Stats mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Stats.builder()
                .totalCustomers(resultSet.getInt("total_customers"))
//                .totalUsers(resultSet.getInt("total_users"))
                .totalProducts(resultSet.getInt("total_products"))
                .build();
    }
}
