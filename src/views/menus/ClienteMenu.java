package views.menus;

public class ClienteMenu {
    
    public static String inicial(){
        StringBuilder builder = new StringBuilder();
		builder.append(" ==================== RAVIN ==================== ");
		builder.append("\n");
		builder.append("1 - Cadastrar Cliente \n");
		builder.append("2 - Alterar Cliente \n");
		builder.append("3 - Listar Clientes \n");
		builder.append("4 - Visualizar Cliente \n");
		builder.append("5 - Excluir Cliente \n");
		builder.append("x - voltar \n");
        return builder.toString();
    }

    
}
