package models;

import java.util.Date;

import utils.enuns.Cargo;
import utils.enuns.Disponibilidade;
import utils.enuns.Escolaridade;
import utils.enuns.EstadoCivil;

public class Funcionario extends Pessoa {
    private String rg;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private Cargo cargo;
    private String pis;
    private String senha;
    private Date dataAdmissao;
    private Date dataDemissao;
    private Disponibilidade disponibilidade;
    private Date criadoEm;
    private String criadoPor;
    private Date alteradoEm;
    private String alteradoPor;
    
    public Funcionario(){

    }

    public Funcionario(String nome, String telefone, String cpf, boolean ativo) {
        super(nome, telefone, cpf, ativo);
    }

    public Funcionario(String nome, String telefone, String cpf, Escolaridade escolaridade, String pis, Date dataAdmissao, Cargo cargo, boolean ativo) {
        super(nome, telefone, cpf, ativo);
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getEstadoCivilString(){
        if(this.estadoCivil == null){
            return "(não informado)";
        }
        String stringEstadoCivil = "";
        switch(this.estadoCivil){
            case SOLTEIRO : stringEstadoCivil = "Solteiro"; break;
            case CASADO : stringEstadoCivil = "Casado"; break;
            case SEPARADO : stringEstadoCivil = "Separado"; break;
            case DIVORCIADO : stringEstadoCivil = "Divorciado"; break;
            case VIUVO : stringEstadoCivil = "Viúvo"; break;
            default : stringEstadoCivil = "não informado";
        }
        return stringEstadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public String getEscolaridadeString() {
        if(this.escolaridade == null){
            return "(não informada)";
        }
        String stringEscolaridade = "";
        switch(this.escolaridade){
            case FUNDAMENTAL : stringEscolaridade = "Fundamental"; break;
            case MEDIO : stringEscolaridade = "Médio"; break;
            case SUPERIOR : stringEscolaridade = "Superior"; break;
            default : stringEscolaridade = "não informado";
        }
        return stringEscolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getCargoString(){
        if(this.cargo == null){
            return "(não informado)";
        }
        String stringCargo = "";
        switch(this.cargo){
            case AUXILARCOZINHA : stringCargo = "Auxiliar de Cozinha"; break;
            case BALCONISTA : stringCargo = "Balconista"; break;
            case BARTENDER : stringCargo = "Bartender"; break;
            case CHEFF : stringCargo = "Cheff"; break;
            case GARCON : stringCargo = "Garçon"; break;
            case GERENTE : stringCargo = "Gerente"; break;
            case RECEPCIONISTA : stringCargo = "Recepcionista"; break;
            default : stringCargo = "não informado";
        }
        return stringCargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public String getDisponibilidadeString() {
        if(this.disponibilidade == null){
            return "(não informada)";
        }
        String stringDisponibilidade = "";
        switch(this.disponibilidade){
            case OCUPADO : stringDisponibilidade = "Ocupado"; break;
            case DISPONIVEL : stringDisponibilidade = "Disponível"; break;
        }
        return stringDisponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
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


