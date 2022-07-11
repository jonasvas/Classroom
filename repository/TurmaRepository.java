package br.edu.ifce.Classroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.Classroom.model.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long>{

}
