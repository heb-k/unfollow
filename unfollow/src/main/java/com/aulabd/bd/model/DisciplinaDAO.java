package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class DisciplinaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> puxarTodasDisciplinas(int cdProf) {
        String sql = "SELECT * FROM disciplina WHERE cd_prof = ?;";
        return jdbc.queryForList(sql, cdProf);
    }

    public List<Integer> puxarTodosCdProfessores() {
    String sql = "SELECT DISTINCT cd_prof FROM disciplina ORDER BY cd_prof;";
    return jdbc.queryForList(sql, Integer.class);
}

}
