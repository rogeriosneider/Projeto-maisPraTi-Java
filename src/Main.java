import model.Pessoa;
import repository.PessoaRepository;
import utils.FormataData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("entre com o nome");
        String nome = sc.nextLine();
        System.out.println("Entre com telefone");
        String telefone = sc.nextLine();
        System.out.println("entre com o nascimento [dd/mm/aaa]");
        String nascimento = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome, telefone, nascimento);
        System.out.println("Cadastrado: " + pessoa.getId() + ", " + pessoa.getName() + ", " +
                pessoa.getNascimento() + ", " + pessoa.getTelefone() + ", " +
                FormataData.formata(pessoa.getDataCadastro()));

    }
}