package service;

import model.Aluno;
import model.Pessoa;
import repository.PessoaRepository;

import java.util.Scanner;

public class PessoaService {
    private Scanner sc;
    private PessoaRepository pessoaRepository;

    public PessoaService(Scanner sc){
        this.sc = sc;
        this.pessoaRepository = new PessoaRepository();
    }

    public void tratarOpcaoCadastro(String sc){
        if(sc.equals("1")) cadastrarPessoa();
        else if(sc.equals("2")) {
            cadastrarAluno();
        }
    }

    public Pessoa consultaListaCompleta() {
        System.out.println();
        Pessoa[] pessoas = pessoaRepository.listarPessoas();
        for(Pessoa elemento: pessoas){
            if(elemento != null)System.out.println("Id: " + elemento.getId() + ", Nome: " + elemento.getName());
        }

        boolean continuarLeitura = true;
        Integer id = null;
        while(continuarLeitura) {
            System.out.println("Entre com o id que deseja consultar");
            try {
                id = Integer.parseInt(sc.nextLine());
                if (pessoaRepository.buscarPorId(id) == null){
                    System.out.println("Id inválido.");
                    continue;
                }
                continuarLeitura = false;
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida");
            }
        }
        return pessoaRepository.buscarPorId(id);
    }

    public Pessoa consultaListaAlunos() {
        System.out.println();
        Pessoa[] pessoas = pessoaRepository.listarPessoas();
        for(Pessoa elemento: pessoas){
            if(elemento != null){
                if(elemento.getNotaFinal() != null)
                    System.out.println("Id: " + elemento.getId() + ", Nome: " + elemento.getName() +
                            ", Nota Final: " + elemento.getNotaFinal());
            }
        }

        boolean continuarLeitura = true;
        Integer id = null;
        while(continuarLeitura) {
            System.out.println("Entre com o id que deseja consultar");
            try {
                id = Integer.parseInt(sc.nextLine());
                if (pessoaRepository.buscarPorId(id) == null){
                    System.out.println("Id inválido.");
                    continue;
                }
                continuarLeitura = false;
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida");
            }
        }
        return pessoaRepository.buscarPorId(id);
    }

    public void tratarOpcaoAtualiza(Pessoa consulta){
        //sc.nextLine();
        if(consulta.getNotaFinal() != null){
            atualizaAluno((Aluno) consulta);
        } else {
            atualizaPessoa(consulta);
        }
    }

    private void cadastrarPessoa(){
        System.out.println();
        System.out.println("Entre com o nome");
        String nome = sc.nextLine();
        System.out.println("Entre com telefone");
        String telefone = sc.nextLine();
        System.out.println("Entre com o nascimento [dd/mm/aaa]");
        String nascimento = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome, telefone, nascimento);
        pessoaRepository.salvar(pessoa.getId(), pessoa);
    }

    private void cadastrarAluno(){
        boolean entraNota = true;
        double nota = 0;
        System.out.println();
        System.out.println("Entre com o nome");
        String nome = sc.nextLine();
        System.out.println("Entre com telefone");
        String telefone = sc.nextLine();
        System.out.println("Entre com o nascimento [dd/mm/aaa]");
        String nascimento = sc.nextLine();
        while(entraNota) {
            System.out.println("Entre com a nota final");
            try {
                nota = Double.parseDouble(sc.nextLine());
                entraNota = false;
            } catch (NumberFormatException e){
                System.out.println("Formato de nota inválido;");
            }
        }

        Aluno aluno = new Aluno(nome, telefone, nascimento, nota);
        pessoaRepository.salvar(aluno.getId(), aluno);
    }

    private void atualizaPessoa(Pessoa pessoa){
        Integer id = pessoa.getId();
        String nome = pessoa.getName();
        String telefone = pessoa.getTelefone();
        pessoa.setDataAtualização();

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

        pessoaRepository.salvar(id, pessoa);
    }

    private void atualizaAluno(Aluno aluno){
        Integer id = aluno.getId();
        String nome = aluno.getName();
        String telefone = aluno.getTelefone();
        Double nota = aluno.getNotaFinal();
        aluno.setDataAtualização();

        System.out.println("Deseja alterar o nome: " + nome + "? s/n");
        String alteraNome = sc.nextLine();
        if(alteraNome.equals("s")){
            System.out.println("Entre com o nome");
            aluno.setName(sc.nextLine());
        }

        System.out.println("Deseja alterar o telefone: " + telefone + "? s/n");
        String alteraFone = sc.nextLine();
        if(alteraFone.equals("s")){
            System.out.println("Entre com o telefone");
            aluno.setTelefone(sc.nextLine());
        }

        System.out.println("Deseja alterar a nota final: " + nota + "? s/n");
        String alteraNota = sc.nextLine();
        if(alteraNota.equals("s")){
            boolean entraNota = true;
            while(entraNota) {
                System.out.println("Entre com a nota");
                try{
                    nota = Double.parseDouble(sc.nextLine());
                    entraNota = false;
                }catch (NumberFormatException e){
                    System.out.println("Valor inválido;");
                }
            }
            aluno.setNotaFinal(nota);
        }
        pessoaRepository.salvar(id, aluno);
    }
}
