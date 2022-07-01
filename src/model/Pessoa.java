package model;

import utils.ContadorId;

import java.time.LocalDateTime;

public class Pessoa {
    private Integer id;
    private String name;
    private String telefone;
    private String nascimento;
    private LocalDateTime dataCadastro;

    public Pessoa(Integer id, String name, String telefone, String nascimento, LocalDateTime dataCadastro) {
        this.id = ContadorId.proximoId();
        this.name = name;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.dataCadastro = dataCadastro;
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
}