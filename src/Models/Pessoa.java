package Models;

import java.util.Date;

public class Pessoa {
    
    private int id;
    private String nome;
    private String telefone;
    private Date nascimento;
    private String cpf;
    private String rg;
    private String estadoCivil;
    private String endereco;
    private Date criadoEm;	
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Pessoa(int id, String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Date getNascimento() {
        return nascimento;
    }


    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getRg() {
        return rg;
    }


    public void setRg(String rg) {
        this.rg = rg;
    }


    public String getEstadoCivil() {
        return estadoCivil;
    }


    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
