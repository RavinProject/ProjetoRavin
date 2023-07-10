package models;

import java.sql.Timestamp;
import java.util.Date;

import utils.enuns.StatusPreparo;

public class Pedido {
    private int Id;
    private Produto produto;
    private Timestamp dataHoraSolicitacao;
    private Timestamp dataHoraInicioPreparo;
    private Timestamp tempoPreparoRestante;
    private StatusPreparo statusPreparo;
    private String observacao;
    private int quantidade;
    private Date criadoEm;	
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;

    public Pedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void adicionarQuantidadePedido(int quantidade){
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Timestamp getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public void setDataHoraSolicitacao(Timestamp dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    public Timestamp getDataHoraInicioPreparo() {
        return dataHoraInicioPreparo;
    }

    public void setDataHoraInicioPreparo(Timestamp dataHoraInicioPreparo) {
        this.dataHoraInicioPreparo = dataHoraInicioPreparo;
    }

    public Timestamp getTempoPreparoRestante() {
        return tempoPreparoRestante;
    }

    public void setTempoPreparoRestante(Timestamp tempoPreparoRestante) {
        this.tempoPreparoRestante = tempoPreparoRestante;
    }

    public StatusPreparo getStatusPreparo() {
        return statusPreparo;
    }

    public void setStatusPreparo(StatusPreparo statusPreparo) {
        this.statusPreparo = statusPreparo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
