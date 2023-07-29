package org.ravin.views;

import javax.swing.*;
import java.util.Objects;

public class View {

    public final static ImageIcon icon = new ImageIcon(Objects.requireNonNull(View.class.getResource("/images/logo.png")));

    public static void exibeDialogo(String mensagem){
        // JOptionPane.showMessageDialog(null, mensagem);
        JOptionPane.showMessageDialog(null,mensagem, "Ravin", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public static String solicitaEntradaDeDado(String mensagem){
        return (String) JOptionPane.showInputDialog(null,mensagem,"Ravin",JOptionPane.INFORMATION_MESSAGE,icon,null,"");
    }

    public static String solicitaEntradaDeDado(String mensagem, String valorInicial){
        return (String) JOptionPane.showInputDialog(null,mensagem,"Ravin",JOptionPane.INFORMATION_MESSAGE,icon,null,valorInicial);
    }
    
    public static int confirmaAcao(String mensagem){
        return JOptionPane.showConfirmDialog(null, mensagem, "Ravin", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    }
}
