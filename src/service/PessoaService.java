package service;

import menu.Menu;
import model.Pessoa;
import repository.PessoaRepository;
import utils.FormataData;

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

    public Pessoa tratarOpcaoCadastro(String sc){
        if(sc.equals("1")) return this.cadastrarPessoa();
        if(sc.equals("2")) return this.cadastrarPessoa();
        else return null;
    }

    public Pessoa tratarOpcaoConsulta() {
        Pessoa[] pessoas = pessoaRepository.listarPessoas();
        for(Pessoa elemento: pessoas){
            if(elemento != null)System.out.println("Id: " + elemento.getId() + ", Nome: " + elemento.getName());
        }
        System.out.println("entre com o id que deseja consultar");
        Integer id = sc.nextInt();
        Pessoa pessoa = pessoaRepository.buscarPorId(id);
        return pessoa;
    }

    public Pessoa tratarOpcaoAtualiza(){
        Menu.menu5();
        return this.alteraDados();
    }


    private Pessoa cadastrarPessoa(){
        System.out.println("entre com o nome");
        String nome = sc.nextLine();
        System.out.println("Entre com telefone");
        String telefone = sc.nextLine();
        System.out.println("entre com o nascimento [dd/mm/aaa]");
        String nascimento = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome, telefone, nascimento);
        pessoaRepository.salvar(pessoa.getId(), pessoa);
        return pessoa;
    }

    private Pessoa alteraDados(){
        sc.nextLine();
        Pessoa[] pessoas = pessoaRepository.listarPessoas();
        for(Pessoa elemento: pessoas){
            if(elemento != null)System.out.println("Id: " + elemento.getId() + ", Nome: " + elemento.getName());
        }
        System.out.println("entre com o id que deseja atualizar");
        Integer id = sc.nextInt();
        Pessoa pessoa = pessoaRepository.buscarPorId(id);

        String nome = pessoa.getName();
        String telefone = pessoa.getTelefone();
        String nascimento = pessoa.getNascimento();

        System.out.println("Deseja alterar o nome: " + nome + "? s/n");
        String alteraNome = sc.nextLine();
        if(alteraNome.equals("s")){
            System.out.println("Entre com o nome");
            pessoa.setName(sc.nextLine());
        }

        System.out.println("Deseja alterar o telefone: " + telefone + "? s/n");
        String alteraFone = sc.nextLine();
        if(alteraFone.equals("s")){
            System.out.println("Entre com o telefone");
            pessoa.setTelefone(sc.nextLine());
        }

        //procurar forma de salvar isso no repository - substituir colocando a pessoa nova no lugar da antiga
        //criar uma função alterar() no repository, semelhante ao salvar() mas informando o id onde vai ser inserido
        //a princípio é como ta abaixo, testar depois pra ver se funciona
        pessoaRepository.salvar(id, pessoa);
        return pessoa;
    }
}
