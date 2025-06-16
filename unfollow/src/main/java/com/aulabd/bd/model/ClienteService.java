package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired //cria a bagaca pra mim!
    ClienteDAO cdao;

    public List<Map<String,Object>> puxarTodosClientes(int cdProf){
        return cdao.puxarTodosClientes(cdProf);
    }

    public List<Map<String,Object>> puxarTodosClientesSM(int id){
        return cdao.puxarTodosClientesSM(id);
    }

    public Map<String,Object> puxarCliente(int id){
        return cdao.puxarCliente(id);
    }
}
