package br.edu.ifce.Classroom.service;

import java.util.List;

import br.edu.ifce.Classroom.model.Professor;

public interface ProfessorService {

    List<Professor> getAllProfessor();

    Professor salvar(Professor professor);

    Professor findById(Long id);

    Professor atualizar(Professor professor);

    void deletar(Long id);

}
