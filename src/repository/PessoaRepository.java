package repository;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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


