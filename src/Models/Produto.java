package Models;

import java.util.Date;

public class Produto {
    private String nome;
    private String descricao;
    private int codigo;
    private double precoCusto;
    private double precoVenda;
    private String statusPreparo;
    private String tempoPreparo;
    private String observacoes;
    private boolean status;
    private Date criadoEm;
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;
    
    public Produto(String nome, String descricao, int codigo, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getStatusPreparo() {
        return statusPreparo;
    }

    public void setStatusPreparo(String statusPreparo) {
        this.statusPreparo = statusPreparo;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
