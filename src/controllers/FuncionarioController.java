package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Funcionario;

public class FuncionarioController extends Controller <Funcionario>{

    private List <Funcionario> listaObj;

    public FuncionarioController() {
        this.listaObj = new ArrayList<Funcionario>();
    }

    @Override
    public Funcionario recuperar(int id){
        for(Funcionario obj : this.listaObj){
            if(obj.getId() == id){
                return obj;
            }
        }
        return null;
    }

    @Override
    public void inserir(Funcionario obj){
        this.listaObj.add(obj);
    }

    @Override
    public void atualizar(Funcionario obj){
        for (int i = 0; i < this.listaObj.size(); i++) {
            if (this.listaObj.get(i).getId() == obj.getId()) {
                this.listaObj.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Funcionario obj){
        for(Funcionario p : this.listaObj){
            if(p.getId() == obj.getId()){
                this.listaObj.remove(obj);
            }
        }
    }

    @Override
    public List<Funcionario> pegarLista() {
        return this.listaObj;
    }


}
