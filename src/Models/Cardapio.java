package Models;

import java.util.Date;
import java.util.List;

public class Cardapio {
    private int nome;
    private List<Produto> listaProdutos;
    private int codigo;
    private boolean status;
    private Date criadoEm;
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;

    public Cardapio(int nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
