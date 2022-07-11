import menu.Menu;
import model.Pessoa;
import repository.PessoaRepository;
import service.PessoaService;

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
                    System.out.println();
                    Menu.menu3();
                    String opcao2 = sc.nextLine();
                    if (opcao2.equals("1")||opcao2.equals("2")) pessoaService.tratarOpcaoCadastro(opcao2);
                    else if(opcao2.equals("3")) continuar = false;
                } while(continuar);
            } else if(opcao.equals("2")){
                boolean consultar = true;
                do{
                    Pessoa consulta = pessoaService.tratarOpcaoConsulta();
                    System.out.println(consulta);
                    System.out.println();
                    sc.nextLine();
                    Menu.menu5();
                    String opcao3 = sc.nextLine();
                    if(opcao3.equals("s")){
                        pessoaService.tratarOpcaoAtualiza(consulta);
                    } else if (opcao3.equals("n")) consultar = false;
                } while(consultar);
            } else if(opcao.equals("3")) continua=false;
        } while(continua);
    }
}
