package com.aulabd.bd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aulabd.bd.model.Cliente;
import com.aulabd.bd.model.ClienteService;
import com.aulabd.bd.model.Disciplina;
import com.aulabd.bd.model.DisciplinaService;
import com.aulabd.bd.model.Nota;
import com.aulabd.bd.model.NotaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
	private ApplicationContext context;

    @GetMapping("/")
    public String formLoginProfessor(Model model, HttpSession session) {
    Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf != null){
            return "redirect:/listarD";
        }
    DisciplinaService ds = context.getBean(DisciplinaService.class);
    List<Integer> professores = ds.puxarTodosCdProfessores();
    model.addAttribute("professores", professores);
    return "loginProfessor";
    }

    @RequestMapping("/errorP")
    public String error(Model model) {
    return "error";
    }

    @PostMapping("/editar")
    public String editar(HttpSession session, @RequestParam(required = false) Double a1, @RequestParam int ad, @RequestParam int d, @RequestParam int a, @RequestParam(required = false) Double a2){
        Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
        NotaService ns = context.getBean(NotaService.class);
        if(a == 1){
            if(a1 == null){
                ns.atualizarNota1(null, ad, d);
            }
            ns.atualizarNota1(a1, ad, d);
        }else{
            ns.atualizarNota2(a2, ad, d);
        }
        
        return "redirect:/aluno?d=" + d + "&ad=" + ad;
    }

    @GetMapping("/deletar/{d}/{ad}")
    public String deletar(@PathVariable int d, @PathVariable int ad, HttpSession session){
        Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
        NotaService ns = context.getBean(NotaService.class);
        ns.deletarNota(ad, d);
        return "redirect:/listar/"+ d;
    }

    @GetMapping("/matricula")
    public String matricula(Model model, HttpSession session, @RequestParam("id") Integer id) {
    ClienteService cs = context.getBean(ClienteService.class);
    Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
    List<Map<String, Object>> clientes = cs.puxarTodosClientesSM(id);
    model.addAttribute("clientes", clientes);
    model.addAttribute("disc", id);
    return "matricularAluno";
    }

    @PostMapping("/matricula")
    public String receberMatricula(HttpSession session, @RequestParam("disc") Integer disc, @RequestParam("cd_cliente") Integer cliente) {
    NotaService ns = context.getBean(NotaService.class);
    Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
    ns.inserirNota1(cliente, disc);
    return "redirect:/listar/" + disc; // redireciona pra alguma página depois do "login"
    }

    @PostMapping("/login-prof")
    public String receberLoginProfessor(@RequestParam("cd_prof") Integer cdProf, HttpSession session) {
    session.setAttribute("cd_prof", cdProf);
    return "redirect:/listarD"; // redireciona pra alguma página depois do "login"
    }

    @GetMapping("/listarD")
    public String listarD(Model model , HttpSession session){
        Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
        DisciplinaService ds = context.getBean(DisciplinaService.class);
        List<Map<String,Object>> lr = ds.puxarTodasDisciplinas(cdProf);
        List<Disciplina> ld = Disciplina.converterNDisciplinas(lr);
        model.addAttribute("disciplinas",ld);
        return "listaD";
    }

    @GetMapping("/listar/{id}")
    public String listarAD(Model model , HttpSession session, @PathVariable int id){
        Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> lr = cs.puxarTodosClientes(cdProf);
        List<Cliente> lc = Cliente.converterNClientes(lr);
        model.addAttribute("clientes",lc);
        return  "lista";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("cd_prof");
        return "redirect:/";
    }

    @GetMapping("/aluno")
    public String aluno(@RequestParam int d, @RequestParam int ad, Model model , HttpSession session){
        Integer cdProf = (Integer) session.getAttribute("cd_prof");
        if(cdProf == null){
            return "redirect:/";
        }
        ClienteService cs = context.getBean(ClienteService.class);
        Map<String,Object> lr = cs.puxarCliente(ad);
        Cliente lc = Cliente.converterUmCliente(lr);
        model.addAttribute("cliente",lc);

        NotaService ns = context.getBean(NotaService.class);
        Map<String,Object> n = ns.puxarNota(ad, d);
        Nota nt = Nota.converterUmaNota(n);
        model.addAttribute("nota",nt);
        return "aluno";
    }
}
