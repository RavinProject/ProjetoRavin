package dao.dados;

import java.util.ArrayList;
import java.util.List;

import Models.Cargo;

public class GerarCargos {

    public static List<Cargo> pegaLista() {
        List<Cargo> lista = new ArrayList<Cargo>();
        lista.add(new Cargo(7, "Auxiliar de Cozinha", "Auxilia o Chef na cozinha e preparo dos pratos"));
        lista.add(new Cargo(1, "Balconista", "Responsável pelo atendimento ao balcão"));
        lista.add(new Cargo(2, "Bartender", "Responsável pela preparação de bebidas"));
        lista.add(new Cargo(3, "Chef", "Responsável pela cozinha e preparo dos pratos"));
        lista.add(new Cargo(4, "Garçon", "Responsável pelo atendimento às mesas"));
        lista.add(new Cargo(5, "Gerente", "Responsável pela gestão do estabelecimento"));
        lista.add(new Cargo(6, "Recepcionista", "Responsável pelo atendimento e recepção dos clientes"));
        return lista;
    }

}
