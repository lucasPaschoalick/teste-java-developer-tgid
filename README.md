# Desafio - Teste Java Developer

## Descrição

### OBJETIVOS:
- O sistema deve conter ao menos dois usuários: Empresa e Cliente
- CPF (para Cliente) e CNPJ (para Empresa) devem ser validados
- Para cada Empresa, deve haver ao menos um tipo de taxa de sistema que será incidida no momento da transação (seja saque ou depósito)
- As Empresas devem ter um saldo que advém dos depósitos e saques realizados por Clientes na sua empresa, e já com o abate das taxas de administração (sistema)
- Clientes podem fazer depósitos e saques pelas Empresas (a depender dos saldos
das empresas)
- No momento em que a transação é realizada, deve ser enviado um callback para Empresa informando a transação e algum tipo de notificação para o Cliente (seja e-mail, SMS ou algo do tipo).

## Informações importantes para execução do projeto
- Para acessar o console do H2 da api-movie-reviews, utilize o caminho: http://localhost:8080/h2-console, no campo `JDBC URL:` informe o valor `jdbc:h2:mem:tgidTestDB`, no campo `User Name:` informe o valor `admin`, no campo `Password:` informe o valor `admin`
- Utilize a colection disponibilizada no link: https://drive.google.com/file/d/1cuVNZd3c7_uB1ZNYl5tO0XvD0QBvtd9N/view?usp=sharing para fazer as requisiçoes.
- Necessário ter instalado Java 17.