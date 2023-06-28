package views;

import javax.swing.JOptionPane;

public class View {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";

    public static String selecionarOpcao(String menu){
        return JOptionPane.showInputDialog(menu);
    }

    public static void exibeDialogo(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static String solicitaEntradaDeDado(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }

    public static String solicitaEntradaDeDado(String mensagem, String valorInicial){
        return JOptionPane.showInputDialog(mensagem, valorInicial);
    }
    
}
