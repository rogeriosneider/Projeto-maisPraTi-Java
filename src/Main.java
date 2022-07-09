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
            System.out.println();
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
                //criar opção de consultar lista, e dentro disso criar do while mostrando lista e atualizando cadastro
                Pessoa consulta = pessoaService.tratarOpcaoConsulta();
                System.out.println(consulta);
                System.out.println();
                sc.nextLine();
                System.out.println("deseja atualizar dados? s para sim");
                String opcao3 = sc.nextLine();
                if(opcao3.equals("s")){
                    pessoaService.tratarOpcaoAtualiza(consulta);
                }
            } else if(opcao.equals("3")) continua=false;
        } while(continua);

    }
}