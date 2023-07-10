package views.interfaces;

public interface IView {
    String selecionarOpcao(String menu);
    void exibeDialogo(String mensagem);

    String solicitaEntradaDeDado(String mensagem);

    String solicitaEntradaDeDado(String mensagem, String valorInicial);

    int confirmaAcao(String mensagem);
}
