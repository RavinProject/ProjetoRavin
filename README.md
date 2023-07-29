![Project Logo](https://github.com/regis-amaral/ProjetoRavin/blob/26a00626ba9604b7eb31236d6b8e46c22f6fbbad/documentation/printTelaInicial.png)

## Sobre

Este projeto é uma atividade do programa +Devs2Blu 2023. Criamos um sistema para gerenciar um restaurante fictício, segundo algumas especificações gerais. Na fase #1 do projeto, estamos desenvolvendo apenas em Java, sem frameworks. Nossa abordagem foi partir para Code-first, e assim que o sistema estiver minimamente completo, iniciaremos a integração com uma camada de persistência.

Confiram nossa [Wiki do Projeto](https://github.com/RavinProject/ProjetoRavin/wiki) bem como temos desenvolvido nossa [organização de fluxo de trabalho](https://github.com/orgs/RavinProject/projects/2)! 

## Rodando o Projeto localmente

### Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado em seu sistema:
- [Java JDK 17](https://www.oracle.com/java/technologies/downloads/#java17) ou superior
- [Git](https://git-scm.com/downloads)

### Como executar

1. Clone o repositório para sua máquina local usando o Git:
```bash
git clone https://github.com/RavinProject/ProjetoRavin.git
```
1. Navegue até o diretório que contém a classe principal `App.java`:
```bash
cd ProjetoRavin/src/main/java/org/ravin
```
1. Compile o código:
```bash
javac App.java
```
1. Execute a classe principal:
```bash
java App
```

## Status atual

| Entidades   | Criação (Create) | Leitura (Read) | Atualização (Update) | Deleção (Delete) |
|-------------|------------------|----------------|----------------------|------------------|
| Cardápio    | 🚧               | 🚧             | 🚧                   | 🚧               |
| Cliente     | ✔️               | ✔️             | ✔️                   | ✔️               |
| Comanda     | 🚧               | 🚧             | 🚧                   | 🚧               |
| Estoque     | ✔️               | ✔️             | ✔️                   | ✔️               |
| Funcionário | ✔️               | ✔️             | ✔️                   | ✔️               |
| Mesa        | ✔️               | ✔️             | ✔️                   | ✔️               |
| Reserva     | 🚧               | 🚧             | 🚧                   | 🚧               | 
| Pedido      | 🚧               | 🚧             | 🚧                   | 🚧               |
| Produto     | ✔️               | ✔️             | ✔️                   | ✔️               |

---

## Conceitos aplicados

### Arquitetura
Padrão MVCS, desacoplando a parte visual, entidades, regra de negócios e dados

![Architecture](https://github.com/RavinProject/ProjetoRavin/assets/118540708/68680d3b-41c9-4593-a852-f9519f8ea876)


### Conceitos gerais
- Abstração
- Encapsulamento
- Herança
- Polimorfismo Estático ou Sobrecarga
- Polimorfismo Dinâmico ou Sobrescrita (método buscaPorCpf em ClienteController.java, FuncionarioController.java e PessoaController.java)
- Interfaces individualizadas (SIP)

### Design Patterns
- Singleton 
  - Classe ListaDados.java, a qual monta as listas de dados fictícios ao iniciar o programa
- Factory + Strategy
  - Sistema flexível de Descontos utilizado para a regra de negócios de Desconto de Aniversariante
  - Foi pensado para facilitar a implementação futura de outras regras de descontos
- Inversion of Control
  - Nesta etapa do desenvolvimento do sistema, ainda não estamos fazendo uso de Frameworks.
  - Mesmo assim, criamos uma sequência de dependências parametrizadas entre as classes do sistema, facilitando futuras alterações

---

### Diagrama de Classe
![Class Diagram](https://github.com/regis-amaral/ProjetoRavin/blob/522c9d95853c838f20f49375083ab8d39b16bd81/documentation/ClassDiagram.png)
