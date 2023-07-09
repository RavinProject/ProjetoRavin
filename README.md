![](https://github.com/regis-amaral/ProjetoRavin/blob/26a00626ba9604b7eb31236d6b8e46c22f6fbbad/documentation/printTelaInicial.png)

### Status atual

|   Entidades  | Criação (Create) | Leitura (Read)     | Atualização (Update) | Deleção (Delete)   |
|--------------|------------------|--------------------|----------------------|--------------------|
| Cardápio     | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |
| Cliente      | :heavy_check_mark | :heavy_check_mark: | :heavy_check_mark:   | :heavy_check_mark: |
| Comanda      | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |
| Estoque      | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |
| Funcionário  | :heavy_check_mark:| :heavy_check_mark: | :heavy_check_mark:   | :heavy_check_mark: |
| Mesa         | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |
| Pedido       | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |
| Pessoa       | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |
| Produto      | :white_check_mark:| :white_check_mark: | :white_check_mark:   | :white_check_mark: |


### Conceitos aplicados
- Padrão MVCS, desacoplando a parte visual, entidades, regra de negócios e dados;
- Padrão Singleton para a classe ListaDados.java, a qual monta as listas de dados fictícios ao iniciar o programa;
- Abstração;
- Encapsulamento;
- Herança;
- Polimorfismo Estático ou Sobrecarga;
- Polimorfismo Dinâmico ou Sobrescrita (método buscaPorCpf em ClienteController.java, FuncionarioController.java e PessoaController.java);
- Interfaces individualizadas (SIP)
- ...

  
---

### Diagrama de Classe
![Class Diagram](https://github.com/regis-amaral/ProjetoRavin/blob/522c9d95853c838f20f49375083ab8d39b16bd81/documentation/ClassDiagram.png)
