package repository;

import model.Pessoa;


public class PessoaRepository {
    Pessoa[] pessoasRepository = new Pessoa[30];

    public void salvar(Integer id, Pessoa pessoa){
        pessoasRepository[id] = pessoa;
    }

    public Pessoa[] listarPessoas() {
        return pessoasRepository;
    }

    public Pessoa buscarPorId(Integer id){
        return pessoasRepository[id];
    }
}


