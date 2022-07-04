package repository;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PessoaRepository {
    //private ArrayList<Pessoa> pessoasRepository = new ArrayList<>(30);
    Map<Integer, Pessoa> pessoasRepository = new TreeMap<>();


    public void salvar(Pessoa pessoa){
        this.pessoasRepository.put(pessoa.getId(), pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoasRepository.values().stream().collect(Collectors.toList());
    }

    public Pessoa buscarPorId(Integer id){
        return pessoasRepository.get(id);
    }
}


