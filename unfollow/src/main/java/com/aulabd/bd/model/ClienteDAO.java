
package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public List<Map<String,Object>> puxarTodosClientes(int cdProf){
        String sql = "SELECT * FROM cliente c JOIN nota n ON c.id = n.cd_cliente JOIN disciplina d ON n.cd_disciplina = d.id WHERE d.cd_prof = ?;";
        return jdbc.queryForList(sql, cdProf);
    } 

    public Map<String,Object> puxarCliente(int id){
        String sql = "SELECT * FROM cliente WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public List<Map<String,Object>> puxarTodosClientesSM(int id){
        String sql = "SELECT * FROM cliente c WHERE NOT EXISTS (SELECT 1 FROM nota n WHERE n.cd_cliente = c.id AND n.cd_disciplina = ?);";
        return jdbc.queryForList(sql, id);
    } 
}
