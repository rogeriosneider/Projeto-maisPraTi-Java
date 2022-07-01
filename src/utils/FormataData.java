package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormataData {
    static DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    public static String formata(LocalDateTime data){
        return data.format(formatter);
    }

}
