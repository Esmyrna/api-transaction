# 💸 Sistema de Transferências com Java + Spring Boot

Este projeto foi desenvolvido como um desafio técnico que simula um sistema de **transferência de valores entre usuários e lojistas**, aplicando os princípios da **Arquitetura Limpa (Clean Architecture)** com foco em separação de responsabilidades, escalabilidade e manutenibilidade.

---

## 🚀 Funcionalidades

- Cadastro de usuários (comuns e lojistas) com:
  - Nome completo
  - CPF/CNPJ (único)
  - E-mail (único)
  - Senha (criptografada)
- Cada usuário possui uma carteira (wallet) com saldo
- Transferências:
  - De usuários comuns para outros usuários ou lojistas
  - Lojistas não podem enviar valores
- Validação de saldo antes da transferência
- Autorização via serviço externo:  
  `GET https://util.devi.tools/api/v2/authorize`
- Notificação após recebimento de transferência via serviço externo (instável):  
  `POST https://util.devi.tools/api/v1/notify`
- Operações realizadas em transações atômicas (rollback em caso de falha)

---

## 🧱 Arquitetura

Este projeto segue os princípios da **Arquitetura Limpa**, separado em camadas:

├── domain # Entidades e enums
├── application/usecases # Regras de negócio (casos de uso)
├── infra # Repositórios, configurações, Feign Clients
├── adapters # Controllers e APIs externas

## 🐳 Executando com Docker
Certifique-se de ter Docker instalado.
