package br.edu.ifce.Classroom.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.Classroom.model.Aluno;
import br.edu.ifce.Classroom.repository.AlunoRepository;
import br.edu.ifce.Classroom.service.AlunoService;

@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Override
    public List<Aluno> getAllAluno() {
        return (List<Aluno>) alunoRepository.findAll();
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isPresent()) {
            return aluno.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Aluno atualizar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

}
