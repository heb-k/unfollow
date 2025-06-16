package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    NotaDAO ndao;

    public void atualizarNota1(Double a1,  int cd_cliente, int cd_disciplina) {
        ndao.atualizarNota1(a1, cd_cliente, cd_disciplina);
    }

    public void atualizarNota2(Double a2,  int cd_cliente, int cd_disciplina) {
        ndao.atualizarNota2(a2, cd_cliente, cd_disciplina);
    }

    public void deletarNota(int cd_aluno, int cd_disciplina) {
        ndao.deletarNota(cd_aluno, cd_disciplina);
    }

    public Map<String, Object> puxarNota(int cd_aluno, int cd_disciplina) {
        return ndao.puxarNota(cd_aluno, cd_disciplina);
    }

    public List<Map<String, Object>> puxarTodasNotas() {
        return ndao.puxarTodasNotas();
    }

    public void inserirNota1(int cd_cliente, int cd_disciplina) {
        ndao.inserirNota1(cd_cliente, cd_disciplina);
    }
}
