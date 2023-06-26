package Models;

import java.util.Date;

public class Cliente extends Pessoa {
    private String observacao;
    private boolean status;
    private Date criadoEm;	
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;

    public Cliente(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    public Cliente(String nome, String telefone, String cpf, String observacao, boolean status) {
        super(nome, telefone, cpf);
        this.observacao = observacao;
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean getStatus() {
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
