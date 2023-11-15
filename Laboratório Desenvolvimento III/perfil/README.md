# API REST para Perfis

Esta é uma API REST simples para gerenciar perfis. Ela permite a criação, recuperação, atualização e exclusão de perfis.

## Recursos Disponíveis

### 1. Listar Todos os Perfis

- **Método:** GET
- **URL:** `/perfis/all`
- **Descrição:** Retorna todos os perfis cadastrados.

### 2. Buscar Perfil por E-mail

- **Método:** GET
- **URL:** `/perfis?email={email}`
- **Descrição:** Retorna perfis que correspondem ao e-mail fornecido.

### 3. Criar um Novo Perfil

- **Método:** POST
- **URL:** `/perfis`
- **Descrição:** Cria um novo perfil com base nos dados fornecidos no corpo da solicitação. O corpo deve estar no formato JSON.

  **Exemplo do Corpo da Solicitação:**
  ```json
  {
    "nome": "Nome do Usuário",
    "dataNascimento": "01/01/2000",
    "sobre": "Descrição do usuário",
    "email": "usuario@email.com",
    "projeto": {
      "nome": "Nome do Projeto",
      "link": "https://github.com/projeto",
      "descricao": "Descrição do Projeto",
      "tagsStack": "Java, Spring"
    },
    "experiencia": {
      "nome": "Nome da Experiência",
      "durationMeses": 6,
      "dataInicio": 2022,
      "descricao": "Descrição da Experiência"
    },
    "habilidade": {
      "habilidade": "Habilidade do Usuário",
      "descricao": "Descrição da Habilidade"
    }
  }


### 4. Atualizar Perfil por E-mail

- **Método:** PUT
- **URL:** `/perfis/{email}`
- **Descrição:** Atualiza um perfil existente com base no e-mail fornecido. O corpo deve estar no formato JSON.

### 5. Excluir Perfil por E-mail

- **Método:** DELETE
- **URL:** `/perfis?email={email}`
- **Descrição:** Exclui um perfil com base no e-mail fornecido.

---

## Exemplos de Uso

> `Listar` Todos os Perfis

curl -X GET http://localhost:8080/perfis/all


> `Buscar` Perfil por E-mail

curl -X GET http://localhost:8080/perfis?email=usuario@email.com

> `Criar` um Novo Perfil

```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "nome": "Nome do Usuário",
  "dataNascimento": "01/01/2000",
  "sobre": "Descrição do usuário",
  "email": "usuario@email.com",
  "projeto": {
    "nome": "Nome do Projeto",
    "link": "https://github.com/projeto",
    "descricao": "Descrição do Projeto",
    "tagsStack": "Java, Spring"
  },
  "experiencia": {
    "nome": "Nome da Experiência",
    "durationMeses": 6,
    "dataInicio": 2022,
    "descricao": "Descrição da Experiência"
  },
  "habilidade": {
    "habilidade": "Habilidade do Usuário",
    "descricao": "Descrição da Habilidade"
  }
}' http://localhost:8080/perfis


```

> `Atualizar` Perfil por E-mail

```bash
curl -X PUT -H "Content-Type: application/json" -d '{
  "nome": "Novo Nome",
  "dataNascimento": "02/02/2002",
  "sobre": "Nova Descrição"
}' http://localhost:8080/perfis/usuario@email.com?email=usuario@email.co
```

> `Excluir` Perfil por E-mail

curl -X DELETE http://localhost:8080/perfis?email=usuario@email.com
