package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.enums.StatusComanda;

public class Comanda {
    private int id;
    private Cliente cliente;
    private List<Pedido> pedidos;
    private String codigo;
    private String observacoes;
    private StatusComanda statusComanda;
    private double valorTotalProdutos;
    private double valorTotalFinal;
    private Date criadoEm;
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;
    
    public Comanda(Cliente cliente, String codigo) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.pedidos = new ArrayList<>();
        this.statusComanda = StatusComanda.ABERTA;
    }

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
        this.valorTotalProdutos = calcularTotal();
    }

    public boolean removerPedido(String codigo){
        Pedido pedido = this.pedidos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
        if(pedido == null){
            return false;
        } else {
            this.pedidos.remove(pedido);
            this.valorTotalProdutos = calcularTotal();
            return true;
        }
    }

    private double calcularTotal(){
        return pedidos.stream().mapToDouble(Pedido::getTotal).sum();
    } // TODO

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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusComanda getStatusComanda() {
        return statusComanda;
    }

    public void setStatusComanda(StatusComanda statusComanda) {
        this.statusComanda = statusComanda;
    }

    public double getValorTotalProdutos() { return calcularTotal(); }

    public double getValorTotalFinal() { return this.valorTotalFinal; }

    public void setValorTotalFinal(double valorTotalFinal) { this.valorTotalProdutos = valorTotalFinal; }

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
