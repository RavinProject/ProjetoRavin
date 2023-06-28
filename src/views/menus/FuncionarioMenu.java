package views.menus;

public class FuncionarioMenu {
    
    public static String inicial(){
        StringBuilder builder = new StringBuilder();
		builder.append(" ==================== RAVIN ==================== ");
		builder.append("\n");
		builder.append("1 - Cadastrar Funcionário \n");
		builder.append("2 - Alterar Funcionário \n");
		builder.append("3 - Listar Funcionários \n");
		builder.append("4 - Visualizar Funcionário \n");
		builder.append("x - voltar \n");
        return builder.toString();
    }

    
}
