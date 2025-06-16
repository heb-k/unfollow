package com.aulabd.bd.model;

//POJO

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cliente {

    private int id;
    private String nome, cpf;

    //INICIALIZAR FORM
    public Cliente(){

    }

    //id eh auto incremento, INSERIR
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    //SELECT
    public Cliente(int id, String cpf, String nome) {
        this.cpf = cpf;
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static Cliente converterUmCliente (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String cpf = (String) registro.get("cpf");
        Cliente cli = new Cliente(id,cpf,nome);
        return cli;
    }

    public static List<Cliente> converterNClientes(List<Map<String,Object>> registros){
        List<Cliente> aux = new ArrayList<Cliente>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmCliente(reg));
        }
        return aux;
    }
}
