class Livroteca(var nome: String, var dataCriacao: String){

    var livros: MutableMap<Int, Livro> = mutableMapOf()
    var colecoes: MutableMap<Int, Colecao> = mutableMapOf()

    fun cadastrarLivro(livro: Livro){
        livros[livro.codigo] = livro
        println("livro cadastrado com sucesso")
    }

    fun cadastrarColecao(colecao: Colecao){
        colecoes[colecao.codigo] = colecao
    }

    fun consultarLivroColecao(codigo: Int){
        if (livros.containsKey(codigo)) {
            println(livros.get(codigo))
        } else if (colecoes.containsKey(codigo)) {
            println(colecoes.get(codigo))
        } else {
            println("Livro/Coleção não encontrado")
        }
    }

    fun alugarLivroColecao(codigo: Int, func: Funcionario, cliente: Cliente){
        if(livros.containsKey(codigo)){
            livros.get(codigo)?.estadoAtual = "alugado"
            func.historico.add("Aluguel do livro $codigo")
            cliente.historico.add("Alugou o livro $codigo")
        }else if (colecoes.containsKey(codigo)){
            colecoes.get(codigo)?.estadoAtual = "alugado"
            func.historico.add("Aluguel da colecao $codigo")
            func.historico.add("Alugou a colecao $codigo")
        }else{
            println("Livro ou Colecao não encontrada")
        }

    }

    fun efetuarVenda(codigo: Int, func: Funcionario, cliente: Cliente)
    {
        if(livros.containsKey(codigo)){
            livros.get(codigo)?.estadoAtual = "vendido"
            func.historico.add("Vendeu o livro $codigo")
            cliente.historico.add("Comprou o livro $codigo")
        }else if (colecoes.containsKey(codigo)){
            colecoes.get(codigo)?.estadoAtual = "vendido"
            func.historico.add("Vendeu a colecao $codigo")
            func.historico.add("Comprou a colecao $codigo")
        }else {
            println("Livro ou Colecao não encontrada")
        }
    }

    fun verificarEstoque(){
        var qtdDisponivel = 0
        var qtdAlugado = 0
        var qtdVendido = 0
        var total = 0.0

        livros.forEach {
            if (it.value.estadoAtual == "disponivel"){
                qtdDisponivel++
                total+= it.value.precoVenda
            }else if (it.value.estadoAtual  == "alugado"){
                qtdAlugado++
                total+= it.value.precoVenda
            }else if (it.value.estadoAtual == "vendido"){
                qtdVendido++
                total+= it.value.precoVenda
            }
        }

        println("Disponiveis: $qtdDisponivel")
        println("Alugados: $qtdAlugado")
        println("Vendidos: $qtdVendido")
        println("Preco total livos (venda): $total")
    }

    override fun toString(): String {
        return "Livroteca: $nome, data de criação: $dataCriacao"
    }
}