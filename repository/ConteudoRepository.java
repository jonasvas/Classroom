package br.edu.ifce.Classroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.Classroom.model.Conteudo;

@Repository
public interface ConteudoRepository extends CrudRepository<Conteudo, Long>{

}
