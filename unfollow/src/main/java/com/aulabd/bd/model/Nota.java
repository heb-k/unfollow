package com.aulabd.bd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Nota {

    private int cd_cliente;
    private int cd_disciplina;
    private BigDecimal qt_nota;
    private BigDecimal a1;
    private BigDecimal a2;    

    // Construtor padrão (vazio)
    public Nota() {
    }

    // Construtor completo
    public Nota(int cd_cliente, int cd_disciplina, BigDecimal qt_nota, BigDecimal a1, BigDecimal a2) {
        this.cd_cliente = cd_cliente;
        this.cd_disciplina = cd_disciplina;
        this.qt_nota = qt_nota;
        this.a1 = a1;
        this.a2 = a2;
    }

    // Getters
    public int getcd_cliente() {
        return cd_cliente;
    }

    public int getCd_disciplina() {
        return cd_disciplina;
    }

    public BigDecimal getQt_nota() {
        return qt_nota;
    }

    // Setters
    public void setcd_cliente(int cd_cliente) {
        this.cd_cliente = cd_cliente;
    }

    public void setCd_disciplina(int cd_disciplina) {
        this.cd_disciplina = cd_disciplina;
    }

    public void setQt_nota(BigDecimal qt_nota) {
        this.qt_nota = qt_nota;
    }
    

    public void setA2(BigDecimal a2) {
        this.a2 = a2;
    }
    public void setA1(BigDecimal a1) {
        this.a1 = a1;
    }
    public BigDecimal getA1() {
        return a1;
    }

   

    public BigDecimal getA2() {
        return a2;
    }

    // Conversão de um único registro (Map) para objeto Nota
    public static Nota converterUmaNota(Map<String, Object> registro) {
        int aluno = (Integer) registro.get("cd_cliente");
        int disciplina = (Integer) registro.get("cd_disciplina");
        BigDecimal nota = (BigDecimal) registro.get("qt_nota");
        BigDecimal a1 = (BigDecimal) registro.get("a1");
        BigDecimal a2 = (BigDecimal) registro.get("a2");
        return new Nota(aluno, disciplina, nota, a1, a2);
    }

    // Conversão de uma lista de Map para lista de objetos Nota
    public static List<Nota> converterNNotas(List<Map<String, Object>> registros) {
        List<Nota> lista = new ArrayList<Nota>();
        for (Map<String, Object> reg : registros) {
            lista.add(converterUmaNota(reg));
        }
        return lista;
    }
}
