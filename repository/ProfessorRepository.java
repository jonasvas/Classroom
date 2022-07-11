package br.edu.ifce.Classroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.Classroom.model.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}
