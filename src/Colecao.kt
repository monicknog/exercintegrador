class Colecao(val codigo: Int,
              val precoVenda: Double,
              val precoAluguel: Double,
              val livros: List<Livro>,
              var estadoAtual: String
               ){

    override fun toString(): String {
        return "livros: $livros ,preço venda: $precoVenda, preço aluguel $precoAluguel, $estadoAtual"
    }
}