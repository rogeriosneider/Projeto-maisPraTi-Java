package repository;

import model.Pessoa;

import java.util.ArrayList;

public class PessoaRepository {
    private ArrayList<Pessoa> pessoasRepository = new ArrayList<>();

    public void salvar(Pessoa pessoa){
        this.pessoasRepository.add(pessoa.getId(), pessoa);
    }
}
