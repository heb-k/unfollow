package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class NotaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    // Inserir nova nota
    public void inserirNota1(int cd_cliente, int cd_disciplina) {
        String sql = "INSERT INTO nota VALUES (?, ?)";
        Object[] parametros = new Object[2];
        parametros[0] = cd_cliente;
        parametros[1] = cd_disciplina;
        jdbc.update(sql, parametros);
    }


    // Atualizar nota existente
    public void atualizarNota1(Double a1, int cd_cliente, int cd_disciplina) {
        String sql = "UPDATE nota SET a1 = ? WHERE cd_cliente = ? AND cd_disciplina = ?";
        Object[] parametros = new Object[3];
        parametros[0] = a1;
        parametros[1] = cd_cliente;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ;
        parametros[2] = cd_disciplina;
        jdbc.update(sql, parametros);
    }

    // Atualizar nota existente
    public void atualizarNota2(Double a2, int cd_cliente, int cd_disciplina) {
        String sql = "UPDATE nota SET a2 = ? WHERE cd_cliente = ? AND cd_disciplina = ?";
        Object[] parametros = new Object[3];
        parametros[0] = a2;
        parametros[1] = cd_cliente;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ;
        parametros[2] = cd_disciplina;
        jdbc.update(sql, parametros);
    }

    // Deletar nota
    public void deletarNota(int cd_cliente, int cd_disciplina) {
        String sql = "DELETE FROM nota WHERE cd_cliente = ? AND cd_disciplina = ?";
        jdbc.update(sql, cd_cliente, cd_disciplina);
    }

    // Buscar uma nota específica
    public Map<String, Object> puxarNota(int cd_cliente, int cd_disciplina) {
        String sql = "SELECT * FROM nota WHERE cd_cliente = ? AND cd_disciplina = ?";
        return jdbc.queryForMap(sql, cd_cliente, cd_disciplina);
    }

    // Buscar todas as notas
    public List<Map<String, Object>> puxarTodasNotas() {
        String sql = "SELECT qt_nota, a1, a2 FROM nota";
        //model.addAttribute("dados", lr);
        return jdbc.queryForList(sql);
    }
}
