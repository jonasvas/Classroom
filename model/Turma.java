package br.edu.ifce.Classroom.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name="tbl_turma")
public class Turma {
    @Id
    @GeneratedValue
    private Long id;
    private String nome_turma;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conteudo_id", referencedColumnName = "id")
    private Conteudo conteudo;
    
    @ManyToMany
    private Collection<Aluno> aluno = new ArrayList<Aluno>();
    
    @ManyToMany
    private Collection<Professor> professor = new ArrayList<Professor>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_turma() {
        return nome_turma;
    }

    public void setNome_turma(String nome_turma) {
        this.nome_turma = nome_turma;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public Collection<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(Collection<Professor> professor) {
        this.professor = professor;
    }
}
