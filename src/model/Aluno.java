package model;

import utils.ContadorId;

import java.time.LocalDateTime;

public class Aluno extends Pessoa{
    private Integer id;
    private double notaFinal;
    private LocalDateTime dataCadastro;

    public Aluno(String name, String telefone, String nascimento, double notaFinal) {
        super(name, telefone, nascimento);
        this.id = ContadorId.proximoId();
        this.notaFinal = notaFinal;
        this.dataCadastro = LocalDateTime.now();
    }
}
