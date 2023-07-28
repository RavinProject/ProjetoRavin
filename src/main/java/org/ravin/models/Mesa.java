package org.ravin.models;

import org.ravin.utils.enums.StatusMesa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mesa {
    private int id;
    private Funcionario funcionario;
    private String nome;
    private String codigo;
    private int numero;
    private int quantidadeMaxima;
    private StatusMesa statusMesa;
    private Date criadoEm;
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;
    
    public Mesa(String nome, String codigo, int numero, int quantidadeMaxima) {
        this.nome = nome;
        this.codigo = codigo;
        this.numero = numero;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public void alocarFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Date getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(Date alteradoEm) {
        this.alteradoEm = alteradoEm;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", funcionario=" + funcionario +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", numero=" + numero +
                ", quantidadeMaxima=" + quantidadeMaxima +
                ", statusMesa=" + statusMesa +
                ", criadoEm=" + criadoEm +
                ", alteradoEm=" + alteradoEm +
                '}';
    }
}
