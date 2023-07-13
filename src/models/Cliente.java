package models;

import java.util.Date;

public class Cliente extends Pessoa {
    private String alergias;
    private boolean vip;
    private Date criadoEm;	
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;

    public Cliente(){
    }

    public Cliente(int id, String nome, String telefone, String cpf, boolean ativo) {
        super(id, nome, telefone, cpf, ativo);
    }

    public Cliente(String nome, String telefone, String cpf, boolean ativo) {
        super(nome, telefone, cpf, ativo);
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
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
