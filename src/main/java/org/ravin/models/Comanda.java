package org.ravin.models;

import org.ravin.utils.enums.StatusComanda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda {
    private int id;
    private String codigo;
    private StatusComanda statusComanda;
    private Cliente cliente;
    private Mesa mesa;
    private List<Pedido> pedidos;
    private String observacoes;
    private double totalBruto;
    private double totalLiquido;
    private Date criadoEm;
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;

    public Comanda(){}

    public Comanda(Cliente cliente, String codigo, Mesa mesa) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.mesa = mesa;
        this.statusComanda = StatusComanda.ABERTA;
        this.pedidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public StatusComanda getStatusComanda() {
        return statusComanda;
    }

    public void setStatusComanda(StatusComanda statusComanda) {
        this.statusComanda = statusComanda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public double getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(double totalLiquido) {
        this.totalLiquido = totalLiquido;
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
        return "Comanda{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", pedidos=" + pedidos +
                ", codigo='" + codigo + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", statusComanda=" + statusComanda +
                ", valorTotalProdutos=" + totalBruto +
                ", valorTotalFinal=" + totalLiquido +
                ", criadoEm=" + criadoEm +
                ", criadoPor='" + criadoPor + '\'' +
                ", alteradoEm=" + alteradoEm +
                ", alteradoPor='" + alteradoPor + '\'' +
                '}';
    }
}
