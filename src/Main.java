import menu.Menu;
import model.Pessoa;
import repository.PessoaRepository;
import service.PessoaService;
import utils.FormataData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.menu1();
        Scanner sc = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService(sc);
        PessoaRepository pessoaRepository = new PessoaRepository();
        boolean continua = true;

        Pessoa pessoa = pessoaService.tratarOpcaoCadastro();
        System.out.println("Cadastrado Id " + pessoa.getId() + ", nome " + pessoa.getName()
                + ", nascimento " + pessoa.getNascimento() + ", telefone " + pessoa.getTelefone()
                + ", cadastro em " + FormataData.formata(pessoa.getDataCadastro())
                + ", atualizado em " + FormataData.formata(pessoa.getDataAtualização()));

        Pessoa consulta = pessoaService.tratarOpcaoConsulta();
        System.out.println("Id " + consulta.getId() + ", nome " + consulta.getName()
                + ", nascimento " + consulta.getNascimento() + ", telefone " + consulta.getTelefone()
                + ", cadastro em " + FormataData.formata(consulta.getDataCadastro())
                + ", atualizado em " + FormataData.formata(consulta.getDataAtualização()));

        /*do {
            Menu.menu2();
            Integer opcao1 = sc.nextInt();
            if(opcao1 == 1){
                Menu.menu3();
                int opcao2 = sc.nextInt();
                if(opcao2 == 1){
                    Pessoa pessoa = pessoaService.tratarOpcaoCadastro();
                    pessoaRepository.salvar(pessoa);
                    System.out.println("Cadastrado Id " + pessoa.getId() + ", nome " + pessoa.getName()
                            + ", nascimento " + pessoa.getNascimento() + ", telefone " + pessoa.getTelefone()
                            + ", cadastro em " + FormataData.formata(pessoa.getDataCadastro())
                            + ", atualizado em " + FormataData.formata(pessoa.getDataAtualização()));
                }
            } else if(opcao1 == 2) {
                Pessoa pessoa = pessoaService.tratarOpcaoConsulta();
                System.out.println("Cadastrado Id " + pessoa.getId() + ", nome " + pessoa.getName()
                        + ", nascimento " + pessoa.getNascimento() + ", telefone " + pessoa.getTelefone()
                        + ", cadastro em " + FormataData.formata(pessoa.getDataCadastro())
                        + ", atualizado em " + FormataData.formata(pessoa.getDataAtualização()));
            }else if(opcao1 == 3){continua = false;}
        } while(continua);*/

    }
}