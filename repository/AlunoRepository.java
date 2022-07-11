package br.edu.ifce.Classroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.Classroom.model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
