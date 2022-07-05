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


        do {
            Menu.menu2();
            String opcao = sc.nextLine();
            if(opcao.equals("1")){
                boolean continuar = true;
                do{
                    Menu.menu3();
                    String opcao2 = sc.nextLine();
                    if (opcao2.equals("1")||opcao2.equals("2")) pessoaService.tratarOpcaoCadastro(opcao2);
                    else if(opcao2.equals("3")) continuar = false;
                } while(continuar);
            } else if(opcao.equals("2")){
                Pessoa consulta = pessoaService.tratarOpcaoConsulta();
                System.out.println("Id " + consulta.getId() + ", nome " + consulta.getName()
                        + ", nascimento " + consulta.getNascimento() + ", telefone " + consulta.getTelefone()
                        + ", cadastro em " + FormataData.formata(consulta.getDataCadastro())
                        + ", atualizado em " + FormataData.formata(consulta.getDataAtualização()));
            }
        } while(continua);





        /*Pessoa pessoa = pessoaService.tratarOpcaoCadastro();
        System.out.println("Cadastrado Id " + pessoa.getId() + ", nome " + pessoa.getName()
                + ", nascimento " + pessoa.getNascimento() + ", telefone " + pessoa.getTelefone()
                + ", cadastro em " + FormataData.formata(pessoa.getDataCadastro())
                + ", atualizado em " + FormataData.formata(pessoa.getDataAtualização()));

        Pessoa consulta = pessoaService.tratarOpcaoConsulta();
        System.out.println("Id " + consulta.getId() + ", nome " + consulta.getName()
                + ", nascimento " + consulta.getNascimento() + ", telefone " + consulta.getTelefone()
                + ", cadastro em " + FormataData.formata(consulta.getDataCadastro())
                + ", atualizado em " + FormataData.formata(consulta.getDataAtualização()));

        Pessoa altera = pessoaService.tratarOpcaoAtualiza();
        System.out.println("Id " + altera.getId() + ", nome " + altera.getName()
                + ", nascimento " + altera.getNascimento() + ", telefone " + altera.getTelefone()
                + ", cadastro em " + FormataData.formata(altera.getDataCadastro())
                + ", atualizado em " + FormataData.formata(altera.getDataAtualização()));*/

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