package br.edu.ifce.Classroom.service;

import java.util.List;

import br.edu.ifce.Classroom.model.Aluno;

public interface AlunoService {

    List<Aluno> getAllAluno();

    Aluno salvar(Aluno aluno);

    Aluno findById(Long id);

    Aluno atualizar(Aluno aluno);

    void deletar(Long id);
    
}
