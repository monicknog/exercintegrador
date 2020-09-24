class Livro(var codigo: Int,
            var titulo: String,
            var autor: String,
            var anoLancamento: String,
            var precoVenda: Double,
            var precoAluguel: Double,
            var estadoAtual: String){

    override fun toString(): String {
        return "$titulo de $autor - $anoLancamento, preço venda: $precoVenda, preço aluguel $precoAluguel, $estadoAtual"
    }
}