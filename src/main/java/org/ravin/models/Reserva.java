package org.ravin.models;

import java.util.Date;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Mesa mesa;
    private Date data;
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;

    public Reserva() {
    }

    public Reserva(Cliente cliente, Mesa mesa, Date data) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", mesa=" + mesa +
                ", data=" + data +
                ", criadoPor='" + criadoPor + '\'' +
                ", alteradoEm=" + alteradoEm +
                ", alteradoPor='" + alteradoPor + '\'' +
                '}';
    }
}
