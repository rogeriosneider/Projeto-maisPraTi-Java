package service;

import menu.Menu;
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
        if(sc.equals("2")) cadastrarAluno();
    }

    public Pessoa tratarOpcaoConsulta() {
        Pessoa[] pessoas = pessoaRepository.listarPessoas();
        for(Pessoa elemento: pessoas){
            if(elemento != null)System.out.println("Id: " + elemento.getId() + ", Nome: " + elemento.getName());
        }
        System.out.println("entre com o id que deseja consultar");
        Integer id = sc.nextInt();
        Pessoa pessoa = pessoaRepository.buscarPorId(id);
        System.out.println(pessoa.getClass());
        return pessoa;
        //pensando: fazer consulta void e, ao final, perguntar se quer atualizar dados daquele Id com if para s
        //fazer chamar a atualiza, trocando ela pra private e enviando a pessoa consultada
    }

    public void tratarOpcaoAtualiza(Pessoa consulta){
        sc.nextLine();
        if(consulta.getNotaFinal() != null){
            atualizaAluno((Aluno) consulta);
        } else {
            atualizaPessoa(consulta);
        }



        /*
        OBS: fazer um método igual ao tratarOpcaoCadastro pra separar se é aluno ou pessoa;
        começar o método ja exibindo a lista e escolhendo a pessoa/aluno pra ver, e disso seguir
        tentar usar ig(get.nota() != null) pra separar entre se vai pro atualizaPessoa ou atualizaAluno;
        */
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

    private Aluno cadastrarAluno(){
        System.out.println("entre com o nome");
        String nome = sc.nextLine();
        System.out.println("Entre com telefone");
        String telefone = sc.nextLine();
        System.out.println("entre com o nascimento [dd/mm/aaa]");
        String nascimento = sc.nextLine();
        System.out.println("entre com a nota final");
        double nota = sc.nextDouble();

        Aluno aluno = new Aluno(nome, telefone, nascimento, nota);
        pessoaRepository.salvar(aluno.getId(), aluno);
        return aluno;
    }

    private Pessoa atualizaPessoa(Pessoa pessoa){
        Integer id = pessoa.getId();
        String nome = pessoa.getName();
        String telefone = pessoa.getTelefone();
        //String nascimento = pessoa.getNascimento();

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
        return pessoa;
    }

    private Pessoa atualizaAluno(Aluno aluno){
        Integer id = aluno.getId();
        String nome = aluno.getName();
        String telefone = aluno.getTelefone();
        //String nascimento = aluno.getNascimento();
        Double nota = aluno.getNotaFinal();

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
            System.out.println("Entre com a nota");
            aluno.setNotaFinal(sc.nextDouble());
        }

        pessoaRepository.salvar(id, aluno);
        return aluno;
    }
}
