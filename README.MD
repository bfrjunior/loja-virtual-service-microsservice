# 🛒Loja Virtual Service - Microsserviço

## 📄 Descrição

Este microsserviço é responsável pela gestão das compras de produtos na loja virtual. Ele integra-se com outros microsserviços, como o serviço de produtos, serviço de pagamento e serviço de usuário, para realizar uma compra e verificar o pagamento. O processo é baseado no padrão BFF (Backend for Frontend), onde este microsserviço serve como uma camada intermediária entre o frontend e os outros serviços.

## 🔧 Funcionalidades
* 🔍 Busca os dados de usuário com base no e-mail fornecido.
* 🛍️ Recupera os detalhes do produto pelo nome.
* 💳 Verifica o pagamento utilizando as informações do usuário e produto.
* ✅ Retorna a resposta de aprovação ou negação da compra.

## 🛠️ Estrutura de Código
Classe Principal: LojaVirtualService
Métodos:

* realizaCompraProdutos(CompraRequestDTO compraRequestDTO): Principal método que processa a compra de um produto. Ele busca os dados do usuário e do produto, verifica o pagamento e retorna o status da compra.

* buscaDadosUsuario(String email): Método privado que consulta o serviço de usuários para obter os dados do usuário.

* buscaDadosProdutos(String nome): Método privado que consulta o serviço de produtos para obter as informações do produto.

* verificaPagamento(UsuarioResponseDTO usuario, CompraRequestDTO compraRequestDTO, ProductsDTO produto): Método privado que valida o pagamento utilizando o serviço de pagamento.

## 📦 Dependências
Este microsserviço depende de três outros serviços:

* ProdutosService 🛍️: Usado para buscar detalhes dos produtos.
* PagamentoService 💳: Realiza a verificação de pagamento.
* UsuarioService 👤: Responsável por buscar os dados dos usuários.
* LojaVirtualConverter 🔄: Um conversor para preparar os dados antes de enviar ao serviço de pagamento.

## 📑 API com Swagger
O microsserviço expõe suas rotas através de uma interface de documentação Swagger. Você pode acessar o Swagger UI para testar as APIs diretamente no navegador através do seguinte endereço:

Swagger UI - Loja Virtual API

## 📜 Rotas Disponíveis

1. Buscar todos os produtos

* Método: GET
* Rota: /loja-virtual/produtos
* Descrição: Retorna a lista de todos os produtos disponíveis.
* Respostas:

  * 200 OK: Busca realizada com sucesso.
  * 500 Internal Server Error: Erro ao realizar a busca.
2. Buscar produto por nome

* Método: GET
* Rota: /loja-virtual/produtos/{nome}
* Descrição: Retorna os detalhes de um produto específico pelo nome.
* Respostas:

   * 200 OK: Produto encontrado com sucesso.
   * 500 Internal Server Error: Erro ao realizar a busca.
3. Cadastrar Usuário

* Método: POST
* Rota: /loja-virtual/usuario
* Descrição: Cadastra um novo usuário.
* Respostas:

   * 200 OK: Cadastro realizado com sucesso.
   * 500 Internal Server Error: Erro ao cadastrar o usuário.
4. Deletar Usuário por e-mail

* Método: DELETE
* Rota: /loja-virtual/usuario/{email}
* Descrição: Deleta um usuário específico pelo e-mail.
* Respostas:
   * 200 OK: Usuário deletado com sucesso.
   * 500 Internal Server Error: Erro ao deletar o usuário.
5. Realizar compra de produto

* Método: POST
* Rota: /loja-virtual/compra
* Descrição: Processa a compra de um produto e verifica o pagamento.
* Respostas:
   * 200 OK: Compra realizada com sucesso.
   * 500 Internal Server Error: Erro ao realizar a compra.

## 📝 Requisição de Compra
Exemplo de CompraRequestDTO:
```
{
  "produto": "Mens Cotton Jacket",
  "email": "email@email",
  "numeroCartao": "12345668080",
  "mes": "01",
  "ano": "2023",
  "cvv": "54"
}
```

## 🚀 Fluxo de Processo:
1. O microsserviço recebe uma requisição de compra.

2. Busca os dados do usuário baseado no e-mail fornecido.

3. Busca os detalhes do produto solicitado.

4. Valida o pagamento através do serviço de pagamento.

5. Retorna uma mensagem de aprovação ou negação do pagamento.

## 🔄 Retornos
* ✅ "Pagamento aprovado": Quando o pagamento é aprovado pelo serviço de pagamento.
* ❌ "Pagamento Negado": Quando o pagamento não é autorizado.
