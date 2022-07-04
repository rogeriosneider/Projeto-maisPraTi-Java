package utils;

public class ContadorId {
    private static Integer CONTADOR = -1;

    public static Integer proximoId(){
        CONTADOR++;
        return CONTADOR;
    }
}
