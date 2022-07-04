package service;

import menu.Menu;
import model.Pessoa;
import repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaService {
    private Scanner sc;
    private PessoaRepository pessoaRepository;

    public PessoaService(Scanner sc){
        this.sc = sc;
        this.pessoaRepository = new PessoaRepository();
    }

    public Pessoa tratarOpcaoCadastro(){
        //Menu.menu3();
        return this.cadastrarPessoa();
    }

    public Pessoa tratarOpcaoConsulta() {
        List<Pessoa> pessoas = pessoaRepository.listarPessoas();
        pessoas.forEach(p -> System.out.println(p.getId() + " - " + p.getName()));
        System.out.println("entre com o id que deseja consultar");
        Integer id = sc.nextInt();
        Pessoa pessoa = pessoaRepository.buscarPorId(id);
        return pessoa;
    }


    private Pessoa cadastrarPessoa(){
        sc.nextLine();
        System.out.println("entre com o nome");
        String nome = sc.nextLine();
        System.out.println("Entre com telefone");
        String telefone = sc.nextLine();
        System.out.println("entre com o nascimento [dd/mm/aaa]");
        String nascimento = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome, telefone, nascimento);
        //pessoaRepository.salvar(pessoa);
        return pessoa;
    }
}