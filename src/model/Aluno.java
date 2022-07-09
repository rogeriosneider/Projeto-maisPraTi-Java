package model;

import utils.ContadorId;
import utils.FormataData;

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

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Id " + this.getId() + ", nome " + this.getName()
                + ", nascimento " + this.getNascimento() + ", telefone " + this.getTelefone()
                + ", nota final: " + getNotaFinal()
                + ", cadastro em " + FormataData.formata(this.getDataCadastro())
                + ", atualizado em " + FormataData.formata(this.getDataAtualização()) + ";";
    }
}
