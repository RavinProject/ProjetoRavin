package views.menus;

public class PrincipalMenu {
    
    public static String inicial(){
        StringBuilder builder = new StringBuilder();
		builder.append(" ==================== RAVIN ==================== ");
		builder.append("\n");
		builder.append("1 - Clientes \n");
		builder.append("2 - Funcionarios \n");
		builder.append("3 - Estoque \n");
		builder.append("4 - Mesas \n");
		// builder.append("5 - Mesas \n");
		// builder.append("6 - Pedidos \n");
		builder.append("x - Sair");
        return builder.toString();
    }
	
}
