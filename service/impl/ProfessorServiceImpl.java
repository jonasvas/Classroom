package br.edu.ifce.Classroom.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.Classroom.model.Professor;
import br.edu.ifce.Classroom.repository.ProfessorRepository;
import br.edu.ifce.Classroom.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Override
    public List<Professor> getAllProfessor() {
        return (List<Professor>) professorRepository.findAll();
    }

    @Override
    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor findById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()) {
            return professor.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Professor atualizar(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }

}
