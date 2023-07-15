package dao;

import dao.interfaces.IComandaRepositorio;
import models.Comanda;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ComandaRepositorio implements IComandaRepositorio {
    @Override
    public void inserir(Comanda object) {

    }

    @Override
    public List<Comanda> pegarLista() {
        return null;
    }

    @Override
    public Optional<Comanda> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Comanda object) {

    }

    @Override
    public void remover(Comanda object) {

    }

    @Override
    public void removerPorId(int id) {

    }

    @Override
    public Optional<Comanda> getComandaPorCodigo(String codigo) {
        List<Comanda> comandas = this.pegarLista();

        for (Comanda comanda : comandas) {
            if (Objects.equals(comanda.getCodigo(), codigo)) {
                return Optional.of(comanda);
            }
        }
        return Optional.empty();
    }

    @Override
    public int geraProximoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geraProximoId'");
    }
}
