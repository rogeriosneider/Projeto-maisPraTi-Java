package model;

import utils.ContadorId;
import utils.FormataData;

import java.time.LocalDateTime;

public class Pessoa {
    protected final Integer id;
    private String name;
    private String telefone;
    private String nascimento;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private Double notaFinal = null;

    public Pessoa(String name, String telefone, String nascimento) {
        this.id = ContadorId.proximoId();
        this.name = name;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = getDataAtualizacao();
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao = LocalDateTime.now();
    }

    public void setDataAtualizacao() {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return "Id " + this.getId() + ", nome " + this.getName()
                + ", nascimento " + this.getNascimento() + ", telefone " + this.getTelefone()
                + ", cadastro em " + FormataData.formata(this.getDataCadastro())
                + ", atualizado em " + FormataData.formata(this.getDataAtualizacao())
                + ";";
    }
}
