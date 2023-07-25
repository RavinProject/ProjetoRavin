package org.ravin.models;

import org.ravin.utils.enums.Cargo;
import org.ravin.utils.enums.Disponibilidade;
import org.ravin.utils.enums.Escolaridade;
import org.ravin.utils.enums.EstadoCivil;

import java.util.Date;

public class Funcionario extends Pessoa {
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private Cargo cargo;
    private String pis;
    private String senha;
    private Date dataAdmissao;
    private Date dataDemissao;
    private Disponibilidade disponibilidade;
    
    public Funcionario(){ }

    public Funcionario(String nome, String telefone, String cpf, boolean ativo) {
        super(nome, telefone, cpf, ativo);
    }

    public Funcionario(String nome, String telefone, String endereco, String cpf, Date nascimento, String observacao, boolean ativo, Date criadoEm, Date alteradoEm, EstadoCivil estadoCivil, Escolaridade escolaridade, Cargo cargo, String pis, String senha, Date dataAdmissao, Date dataDemissao, Disponibilidade disponibilidade) {
        super(nome, telefone, endereco, cpf, nascimento, observacao, ativo, criadoEm, alteradoEm);
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.pis = pis;
        this.senha = senha;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.disponibilidade = disponibilidade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getEstadoCivilString(){
        if(this.estadoCivil == null){
            return "(não informado)";
        }
        return switch (this.estadoCivil) {
            case SOLTEIRO -> "Solteiro";
            case CASADO -> "Casado";
            case SEPARADO -> "Separado";
            case DIVORCIADO -> "Divorciado";
            case VIUVO -> "Viúvo";
            default -> "não informado";
        };
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
        return switch (this.escolaridade) {
            case FUNDAMENTAL -> "Fundamental";
            case MEDIO -> "Médio";
            case SUPERIOR -> "Superior";
            default -> "não informado";
        };
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
        return switch (this.cargo) {
            case AUXILARCOZINHA -> "Auxiliar de Cozinha";
            case BALCONISTA -> "Balconista";
            case BARTENDER -> "Bartender";
            case CHEFF -> "Cheff";
            case GARCON -> "Garçon";
            case GERENTE -> "Gerente";
            case RECEPCIONISTA -> "Recepcionista";
            default -> "não informado";
        };
    }

    public void setCargo(Cargo string) {
        this.cargo = string;
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
        return "Funcionario{" +
                super.toString() +
                "estadoCivil=" + estadoCivil +
                ", escolaridade=" + escolaridade +
                ", cargo=" + cargo +
                ", pis='" + pis + '\'' +
                ", senha='" + senha + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", dataDemissao=" + dataDemissao +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}


