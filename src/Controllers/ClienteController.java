package Controllers;

import java.util.List;

import Models.Cliente;
import dao.ListasDados;

public class ClienteController extends Controller <Cliente>{

    private List <Cliente> listaObj;

    public ClienteController() {
        this.listaObj = ListasDados.getInstance().getListaClientes();
    }

    @Override
    public Cliente recuperar(int id){
        for(Cliente obj : this.listaObj){
            if(obj.getId() == id){
                return obj;
            }
        }
        return null;
    }

    @Override
    public void inserir(Cliente obj){
        this.listaObj.add(obj);
    }

    @Override
    public void atualizar(Cliente obj){
        for (int i = 0; i < this.listaObj.size(); i++) {
            if (this.listaObj.get(i).getId() == obj.getId()) {
                this.listaObj.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Cliente obj){
        for(Cliente p : this.listaObj){
            if(p.getId() == obj.getId()){
                this.listaObj.remove(obj);
            }
        }
    }

    @Override
    public List<Cliente> pegarLista() {
        return this.listaObj;
    }

    public Cliente buscaClientePorCpf(String cpf){
        for(Cliente p : this.listaObj){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }
}
