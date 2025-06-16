package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Disciplina {

    private int id;
    private String nm_disciplina;
    private int cd_prof;

    // Construtor padrão
    public Disciplina() {
    }

    // Construtor para inserção (sem ID, pois é auto incremento)
    public Disciplina(String nm_disciplina, int cd_prof) {
        this.nm_disciplina = nm_disciplina;
        this.cd_prof = cd_prof;
    }

    // Construtor completo (para SELECT)
    public Disciplina(int id, String nm_disciplina, int cd_prof) {
        this.id = id;
        this.nm_disciplina = nm_disciplina;
        this.cd_prof = cd_prof;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNm_disciplina() {
        return nm_disciplina;
    }

    public int getCd_prof() {
        return cd_prof;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNm_disciplina(String nm_disciplina) {
        this.nm_disciplina = nm_disciplina;
    }

    public void setCd_prof(int cd_prof) {
        this.cd_prof = cd_prof;
    }

    // Conversor de um único registro (Map) para objeto Disciplina
    public static Disciplina converterUmaDisciplina(Map<String, Object> registro) {
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nm_disciplina");
        int prof = (Integer) registro.get("cd_prof");
        return new Disciplina(id, nome, prof);
    }

    // Conversor de uma lista de Map para lista de objetos Disciplina
    public static List<Disciplina> converterNDisciplinas(List<Map<String, Object>> registros) {
        List<Disciplina> lista = new ArrayList<Disciplina>();
        for (Map<String, Object> reg : registros) {
            lista.add(converterUmaDisciplina(reg));
        }
        return lista;
    }
}

