package models;

import java.util.Date;

import dao.enuns.Cargo;
import dao.enuns.Disponibilidade;
import dao.enuns.Escolaridade;
import dao.enuns.EstadoCivil;

public class Funcionario extends Pessoa {
    private String rg;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private Cargo cargo;
    private String pis;
    private String senha;
    private Date dataAdmissao;
    private Date dataDemissao;
    private Disponibilidade disponibilidade;
    private boolean status;
    private Date criadoEm;
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;
    
    public Funcionario(){

    }
    
    public Funcionario(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    public Funcionario(int id, String nome, String telefone, String cpf) {
        super(id, nome, telefone, cpf);
    }

    public Funcionario(int id, String nome, String telefone, String cpf, Escolaridade escolaridade, String pis, Date dataAdmissao, Cargo cargo) {
        super(id, nome, telefone, cpf);
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

}


