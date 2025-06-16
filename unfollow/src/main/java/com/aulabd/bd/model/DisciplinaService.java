package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaDAO ddao;

    public List<Map<String, Object>> puxarTodasDisciplinas(int cdProf) {
        return ddao.puxarTodasDisciplinas(cdProf);
    }

    public List<Integer> puxarTodosCdProfessores() {
        return ddao.puxarTodosCdProfessores();
    }
}
