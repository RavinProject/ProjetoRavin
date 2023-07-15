package views.mesa;

import javax.swing.JOptionPane;
import static views.View.exibeDialogo;

public class SubmenuMesa {

    public static void menu() {
        // Injeção de Dependência
        // TODO
        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            switch (opcao) {
                case "1" -> exibeDialogo("Criar Mesa: implementar...");
                case "2" -> exibeDialogo("Alterar Mesa: implementar...");
                case "3" -> exibeDialogo("Excluir Mesa: implementar...");
                case "4" -> exibeDialogo("Listar Mesas: implementar...");
                case "5" -> exibeDialogo("Exibir Mesa: implementar...");
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== RAVIN ==================== ");
        builder.append("\n");
        builder.append("1 - Criar Mesa \n");
        builder.append("2 - Alterar Mesa \n");
        builder.append("3 - Excluir Mesa \n");
        builder.append("4 - Listar Mesas \n");
        builder.append("5 - Exibir Mesa \n");
        builder.append("x - voltar \n");
        return builder.toString();
    }

}
