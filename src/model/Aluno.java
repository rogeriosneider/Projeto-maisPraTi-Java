package model;

import utils.FormataData;


public class Aluno extends Pessoa{
    private double notaFinal;

    public Aluno(String name, String telefone, String nascimento, double notaFinal) {
        super(name, telefone, nascimento);
        this.notaFinal = notaFinal;
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
