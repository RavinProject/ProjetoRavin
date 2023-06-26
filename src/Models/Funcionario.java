package Models;

import java.util.Date;

public class Funcionario extends Pessoa {
    private String escolaridade;
    private Cargo cargo;
    private String ctps;
    private Date dataAdmissao;
    private Date dataDemissao;
    private boolean disponibilidade;
    private boolean status;
    private String senha;
    private Date criadoEm;
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;
    
    public Funcionario(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    public Funcionario(int id, String nome, String telefone, String cpf) {
        super(id, nome, telefone, cpf);
    }

    public Funcionario(int id, String nome, String telefone, String cpf, String escolaridade, String ctps, Date dataAdmissao, Cargo cargo) {
        super(id, nome, telefone, cpf);
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.ctps = ctps;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
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

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
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

    public Funcionario getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(Funcionario criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Date getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(Date alteradoEm) {
        this.alteradoEm = alteradoEm;
    }

    public Funcionario getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Funcionario alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    
    
}


