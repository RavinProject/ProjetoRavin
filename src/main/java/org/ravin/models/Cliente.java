package org.ravin.models;

import java.util.Date;

public class Cliente extends Pessoa {
    private String alergias;
    private boolean vip;

    public Cliente(){ }

    public Cliente(int id, String nome, String telefone, String cpf, boolean ativo) {
        super(id, nome, telefone, cpf, ativo);
    }

    public Cliente(String nome, String telefone, String cpf, boolean ativo, String alergias, boolean vip) {
        super(nome, telefone, cpf, ativo);
        this.alergias = alergias;
        this.vip = vip;
    }

    public Cliente(String nome, String telefone, String endereco, String cpf, Date nascimento, String observacao, boolean ativo, Date criadoEm, Date alteradoEm, String alergias, boolean vip) {
        super(nome, telefone, endereco, cpf, nascimento, observacao, ativo, criadoEm, alteradoEm);
        this.alergias = alergias;
        this.vip = vip;
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

    public void setCriadoEm(Date criadoEm) {
        super.setCriadoEm(criadoEm);
    }

    public Date getCriadoEm() {
        return super.getCriadoEm();
    }

    public void setCriadoPor(String criadoPor) {
        super.setCriadoPor(criadoPor);
    }

    public String getCriadoPor() {
        return super.getCriadoPor();
    }

    public void setAlteradoPor(String alteradoPor) {
        super.setAlteradoPor(alteradoPor);
    }

    public String getAlteradoPor() {
        return super.getAlteradoPor();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                "alergias='" + alergias + '\'' +
                ", vip=" + vip +
                '}';
    }

    // TODO isso está certo???
    public Reserva reservarMesa(Mesa mesa, Date data) {
        return new Reserva(this, mesa, data);
    }
}
