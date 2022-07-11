package br.edu.ifce.Classroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifce.Classroom.model.Aluno;
import br.edu.ifce.Classroom.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
    @Autowired  
    private AlunoService AlunoService;
    
    @GetMapping("")
    public String alunos(Model model) {
        List<Aluno> alunos = AlunoService.getAllAluno();
        model.addAttribute("alunos", alunos);
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("titulo", "Alunos");
        model.addAttribute("adicionaAluno", true);
        
        return "view/alunos";
    }
    
    @PostMapping(value="/salvar")
    public String salvar(@ModelAttribute Aluno aluno, RedirectAttributes redirectAttributes, Model model) {
        Aluno dbAluno = AlunoService.salvar(aluno);
        if(dbAluno != null) {
            redirectAttributes.addFlashAttribute("msg_sucesso", "Salvo com sucesso");
            return "redirect:/aluno";
        }
        else {
            model.addAttribute("msg_erro", "Houve um erro");
            model.addAttribute("aluno", aluno);
            return "view/alunos";
        }
    }
    
    @GetMapping(value="/getAluno/{id}")
    public String getAluno(@PathVariable Long id, Model model) {
        Aluno aluno = AlunoService.findById(id);
        List<Aluno> alunos = AlunoService.getAllAluno();
        model.addAttribute("alunos", alunos);
        model.addAttribute("aluno", aluno);
        model.addAttribute("titulo", "Editar Aluno");
        model.addAttribute("adicionaAluno", false);
        return "view/alunos";
    }
    
    @PostMapping(value="/atualizar")
    public String atualizar(@ModelAttribute Aluno aluno, RedirectAttributes redirectAttributes, Model model) {
        Aluno dbAluno = AlunoService.atualizar(aluno);
        if(dbAluno != null) {
            redirectAttributes.addFlashAttribute("msg_sucesso", "Atualizado com sucesso");
            return "redirect:/aluno";
        }else {
            model.addAttribute("msg_erro", "Houve um erro");
            model.addAttribute("aluno", aluno);
            return "view/alunos";
        }
    }
    
    @GetMapping(value="/deletarAluno/{id}")
    public String deletarAluno(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        AlunoService.deletar(id);
        redirectAttributes.addFlashAttribute("msg_sucesso", "Deletado com sucesso");
        return "redirect:/aluno";
    }
}
