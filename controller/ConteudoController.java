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
import br.edu.ifce.Classroom.service.ConteudoService;

@Controller
@RequestMapping("conteudo")
public class ConteudoController {
    @Autowired  
    private ConteudoService ConteudoService;
    
    @GetMapping("/conteudo")
    public String conteudos(Model model) {
        List<Conteudo> conteudos = ConteudoService.getAllConteudo();
        model.addAttribute("conteudos", conteudos);
        model.addAttribute("conteudo", new Conteudo());
        model.addAttribute("titulo", "Conteudos");
        model.addAttribute("adicionaConteudo", true);
        
        return "view/professores";
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
