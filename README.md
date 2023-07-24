![](https://github.com/regis-amaral/ProjetoRavin/blob/26a00626ba9604b7eb31236d6b8e46c22f6fbbad/documentation/printTelaInicial.png)

### Status atual

|   Entidades  | Criação (Create)   | Leitura (Read)     | Atualização (Update) | Deleção (Delete)   |
|--------------|--------------------|--------------------|----------------------|--------------------|
| Cardápio     | 🚧 | 🚧 | 🚧 | 🚧 |
| Cliente      | ✔️ | ✔️ | ✔️  | ✔️ |
| Comanda      | 🚧 | 🚧 | 🚧 | 🚧 |
| Estoque      | ✔️ | ✔️ | ✔️ | ✔️ |
| Funcionário  | ✔️ | ✔️ | ✔️  | ✔️ |
| Mesa         | 🚧 | 🚧 | 🚧 | 🚧 |
| Pedido       | 🚧 | 🚧 | 🚧 | 🚧 |
| Pessoa       | 🚧 | 🚧 | 🚧 | 🚧 |
| Produto      | ✔️ | ✔️ | ✔️ | ✔️ |

---

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

### Arquitetura Utilizada
![](https://github.com/RavinProject/ProjetoRavin/assets/118540708/68680d3b-41c9-4593-a852-f9519f8ea876)

---

### Diagrama de Classe
![Class Diagram](https://github.com/regis-amaral/ProjetoRavin/blob/522c9d95853c838f20f49375083ab8d39b16bd81/documentation/ClassDiagram.png)
