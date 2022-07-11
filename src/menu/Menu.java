package menu;

public class Menu {

    public static void menu1(){
        System.out.println("===================================");
        System.out.println("Bem vindo ao sistema de alunos");
        System.out.println("===================================");
    }

    public static void menu2(){
        System.out.println("Digite 1 para cadastrar nova pessoa ou aluno;");
        System.out.println("Digite 2 para consultar lista de cadastros;");
        System.out.println("Digite 3 para encerrar.");
    }

    public static void menu3(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - cadastrar nova pessoa;");
        System.out.println("2 - cadastrar novo aluno;");
        System.out.println("3 - para retornar.");

    }

    public static void menu4(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - consultar lista completa;");
        System.out.println("2 - consultar lista de alunos.");

    }

    public static void menu5(){
        System.out.println("Deseja atualizar dados?");
        System.out.println("s para sim; n para retornar.");
    }
}
