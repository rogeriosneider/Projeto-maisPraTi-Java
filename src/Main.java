import menu.Menu;
import model.Pessoa;
import service.PessoaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.menu1();
        Scanner sc = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService(sc);
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
                    System.out.println();
                    Menu.menu4();
                    String opcao3 = sc.nextLine();
                    if(opcao3.equals("1")) {
                        Pessoa consulta = pessoaService.consultaListaCompleta();
                        System.out.println(consulta);
                        System.out.println();
                        Menu.menu5();
                        String opcao4 = sc.nextLine();
                        if (opcao4.equals("s")) {
                            pessoaService.tratarOpcaoAtualiza(consulta);
                        };
                    } if(opcao3.equals("2")) {
                        Pessoa consulta = pessoaService.consultaListaAlunos();
                        System.out.println(consulta);
                        System.out.println();
                        Menu.menu5();
                        String opcao4 = sc.nextLine();
                        if (opcao4.equals("s")) {
                            pessoaService.tratarOpcaoAtualiza(consulta);
                        };
                    } else if(opcao3.equals("3")) consultar = false;
            } while(consultar);
            } else if(opcao.equals("3")) continua=false;
        } while(continua);
    }
}
