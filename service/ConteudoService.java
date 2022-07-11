package br.edu.ifce.Classroom.service;

import java.util.List;

import br.edu.ifce.Classroom.model.Conteudo;

public interface ConteudoService {

    List<Conteudo> getAllConteudo();

    Conteudo salvar(Conteudo conteudo);

    Conteudo findById(Long id);

    Conteudo atualizar(Conteudo conteudo);

    void deletar(Long id);
    
}
