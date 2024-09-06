# Task Menagement

API simples desenvolvida com objetivo de servir como um organizador de tarefas.
Linguagens e Tecnologias utilizados: Java 21, Spring Boot, Maven, PostgresSQL.

## ❗️ Link Documentação

- 📄 [Java](https://docs.oracle.com/en/java/)
- 📄 [Spring](https://docs.spring.io/spring-boot/index.html)

### Comando para criação do DB:

```env
create table tb_tasks (
  task_id text primary key,
  title text not null,
  description varchar(250),
  status varchar(250)
);
```

### Start na aplicação

Para criar uma tarefa no local utilize o endpoint (POST):

![image](https://github.com/user-attachments/assets/10316c05-f199-4db3-922e-34171c82e8aa)

Editar tarefa passando o id (PUT):

![image](https://github.com/user-attachments/assets/8763038b-42a2-4fd1-8486-a79f686f1858)

Buscar todas as tarefas criadas (GET): 

![image](https://github.com/user-attachments/assets/64a03a45-7d26-469b-bd48-bdff52ba3f5c)

Excluir tarefa pelo id (DELETE): 

![image](https://github.com/user-attachments/assets/b84dba8b-1adc-496a-bf84-b3afaa60c83a)


