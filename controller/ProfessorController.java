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

import br.edu.ifce.Classroom.model.Conteudo;
import br.edu.ifce.Classroom.model.Professor;
import br.edu.ifce.Classroom.service.ConteudoService;
import br.edu.ifce.Classroom.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
    @Autowired  
    private ProfessorService ProfessorService;
    
    @Autowired  
    private ConteudoService ConteudoService;

    
    @GetMapping("")
    public String professors(Model model) {
        List<Professor> professors = ProfessorService.getAllProfessor();
        List<Conteudo> conteudos = ConteudoService.getAllConteudo();     
        model.addAttribute("professors", professors);
        model.addAttribute("professor", new Professor());
        model.addAttribute("conteudos", conteudos);
        model.addAttribute("conteudo", new Conteudo());
        model.addAttribute("titulo", "Professores");
        model.addAttribute("adicionaProfessor", true);
        model.addAttribute("adicionaConteudo", true);
        return "view/professores";
    }
    
    @PostMapping(value="/salvar")
    public String salvar(@ModelAttribute Professor professor, RedirectAttributes redirectAttributes, Model model) {
        Professor dbProfessor = ProfessorService.salvar(professor);
        if(dbProfessor != null) {
            redirectAttributes.addFlashAttribute("msg_sucesso", "Salvo com sucesso");
            return "redirect:/professor";
        }
        else {
            model.addAttribute("msg_erro", "Houve um erro");
            model.addAttribute("professor", professor);
            return "view/professores";
        }
    }
    
    @GetMapping(value="/getProfessor/{id}")
    public String getProfessor(@PathVariable Long id, Model model) {
        Professor professor = ProfessorService.findById(id);
        List<Professor> professors = ProfessorService.getAllProfessor();
        model.addAttribute("professors", professors);
        model.addAttribute("professor", professor);
        model.addAttribute("titulo", "Editar Professor");
        model.addAttribute("adicionaProfessor", false);
        return "view/professores";
    }
    
    @PostMapping(value="/atualizar")
    public String atualizar(@ModelAttribute Professor professor, RedirectAttributes redirectAttributes, Model model) {
        Professor dbProfessor = ProfessorService.atualizar(professor);
        if(dbProfessor != null) {
            redirectAttributes.addFlashAttribute("msg_sucesso", "Atualizado com sucesso");
            return "redirect:/professor";
        }else {
            model.addAttribute("msg_erro", "Houve um erro");
            model.addAttribute("professor", professor);
            return "view/professores";
        }
    }
    
    @GetMapping(value="/deletarProfessor/{id}")
    public String deletarProfessor(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        ProfessorService.deletar(id);
        redirectAttributes.addFlashAttribute("msg_sucesso", "Deletado com sucesso");
        return "redirect:/professor";
    }
    

    @PostMapping(value="/salvarConteudo")
    public String salvarConteudo(@ModelAttribute Conteudo conteudo, RedirectAttributes redirectAttributes, Model model) {
        Conteudo dbConteudo = ConteudoService.salvar(conteudo);
        if(dbConteudo != null) {
            redirectAttributes.addFlashAttribute("msg_sucesso", "Salvo com sucesso");
            return "redirect:/professor";
        }
        else {
            model.addAttribute("msg_erro", "Houve um erro");
            model.addAttribute("conteudo", conteudo);
            return "view/prefessores";
        }
    }
    
    @GetMapping(value="/getConteudo/{id}")
    public String getConteudo(@PathVariable Long id, Model model) {
        Conteudo conteudo = ConteudoService.findById(id);
        List<Conteudo> conteudos = ConteudoService.getAllConteudo();
        model.addAttribute("conteudos", conteudos);
        model.addAttribute("conteudo", conteudo);
        model.addAttribute("titulo", "Editar Conteudo");
        model.addAttribute("adicionaConteudo", false);
        return "view/professores";
    }
    
    @PostMapping(value="/atualizarConteudo")
    public String atualizarConteudo(@ModelAttribute Conteudo conteudo, RedirectAttributes redirectAttributes, Model model) {
        Conteudo dbConteudo = ConteudoService.atualizar(conteudo);
        if(dbConteudo != null) {
            redirectAttributes.addFlashAttribute("msg_sucesso", "Atualizado com sucesso");
            return "redirect:/prefessor";
        }else {
            model.addAttribute("msg_erro", "Houve um erro");
            model.addAttribute("conteudo", conteudo);
            return "view/prefessores";
        }
    }
    
    @GetMapping(value="/deletarConteudo/{id}")
    public String deletarConteudo(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        ConteudoService.deletar(id);
        redirectAttributes.addFlashAttribute("msg_sucesso", "Deletado com sucesso");
        return "redirect:/professor";
    }

}
