package org.ravin.models;

import java.util.Date;

public abstract class Pessoa {
    
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private Date nascimento;
    private String observacao;
    private boolean ativo;
    private Date criadoEm;	
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String telefone, String cpf, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.ativo = ativo;
    }

    public Pessoa(String nome, String telefone, String cpf, boolean ativo) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.ativo = ativo;
    }

    public Pessoa(String nome, String telefone, String endereco, String cpf, Date nascimento, String observacao, boolean ativo, Date criadoEm, Date alteradoEm) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.observacao = observacao;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.alteradoEm = alteradoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setStatusAtivo(boolean status) {
        this.ativo = status;
    }

    public Date getCriadoEm() {
        return this.criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getCriadoPor() {
        return this.criadoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public String getAlteradoPor() {
        return this.alteradoPor;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nascimento=" + nascimento +
                ", observacao='" + observacao + '\'' +
                ", ativo=" + ativo +
                ", criadoEm=" + criadoEm +
                ", criadoPor='" + criadoPor + '\'' +
                ", alteradoEm=" + alteradoEm +
                ", alteradoPor='" + alteradoPor + '\'' +
                '}';
    }
}
