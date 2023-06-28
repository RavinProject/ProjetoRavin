package views;

import javax.swing.JOptionPane;

public class View {
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
