package utils;

public class ContadorId {
    private static Integer CONTADOR = 0;

    public static Integer proximoId(){
        CONTADOR++;
        return CONTADOR;
    }
}
