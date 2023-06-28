![](https://github.com/regis-amaral/ProjetoRavin/blob/26a00626ba9604b7eb31236d6b8e46c22f6fbbad/documentation/printTelaInicial.png)

Respostas:

[Cadastro de Entidades Modo Texto](https://github.com/regis-amaral/ProjetoRavin/blob/atividade2/src/views/Cadastro.java)

[Modo Gráfico - Atualização 28/06/2023 1:47](https://github.com/regis-amaral/ProjetoRavin/blob/atividade2/src/views/CadastroCliente.java)

---

### Faça os métodos de input das classes do nosso projeto

Com base no projeto desenvolvido em sala (Diagrama de classes), crie os métodos de input para cada uma das entidades.

EXEMPLO:

```
public static Pessoa cadastrarPessoa() {
       int id = Integer.parseInt(JOptionPane.showInputDialog("Digite um id"));
       String nome = JOptionPane.showInputDialog("Digite o nome da pessoa");
       String endereco = JOptionPane.showInputDialog("Digite o endereço da pessoa");
       String telefone = JOptionPane.showInputDialog("Digite o telefone");
       String cpf = JOptionPane.showInputDialog("Digite o CPF da pessoa");
       Date dataNascimento = new Date();
       String observacao = JOptionPane.showInputDialog("Digite alguma possível observação");
       boolean ativo = true;

       Pessoa pessoa = new Pessoa(id, nome, endereco, telefone, cpf, dataNascimento, observacao, ativo);

       return pessoa;
   }
```

### Diagrama de Classe
![Class Diagram](https://github.com/regis-amaral/ProjetoRavin/blob/522c9d95853c838f20f49375083ab8d39b16bd81/documentation/ClassDiagram.png)
