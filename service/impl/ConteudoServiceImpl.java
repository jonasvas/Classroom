package br.edu.ifce.Classroom.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.Classroom.model.Conteudo;
import br.edu.ifce.Classroom.repository.ConteudoRepository;
import br.edu.ifce.Classroom.service.ConteudoService;

@Service
@Transactional
public class ConteudoServiceImpl implements ConteudoService {
    @Autowired
    private ConteudoRepository conteudoRepository;
    
    @Override
    public List<Conteudo> getAllConteudo() {
        return (List<Conteudo>) conteudoRepository.findAll();
    }

    @Override
    public Conteudo salvar(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    @Override
    public Conteudo findById(Long id) {
        Optional<Conteudo> conteudo = conteudoRepository.findById(id);
        if(conteudo.isPresent()) {
            return conteudo.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Conteudo atualizar(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    @Override
    public void deletar(Long id) {
        conteudoRepository.deleteById(id);
    }

}
