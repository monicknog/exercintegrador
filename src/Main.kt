fun main(){

    var biblioteca = Livroteca("B1", "23/09/2020")
    var livro1 = Livro(1,"livro1","autor1","2020", 20.0, 2.0, "disponivel")
    var livro2 = Livro(2,"livro2","autor2","2020", 20.0, 2.0, "disponivel")
    var livro3 = Livro(3,"livro3","autor3","2020", 25.0, 2.0, "disponivel")
    var colecao1 = Colecao(1001,200.0, 8.0, listOf(livro1,livro2), "disponivel")
    var cliente = Cliente("Monick", "20000")
    var funcionario = Funcionario("helel", "123456")

    biblioteca.cadastrarLivro(livro1)
    biblioteca.cadastrarLivro(livro2)
    biblioteca.cadastrarLivro(livro3)
    biblioteca.cadastrarColecao(colecao1)

    biblioteca.efetuarVenda(1,funcionario,cliente)
    biblioteca.alugarLivroColecao(3,funcionario,cliente)
    biblioteca.consultarLivroColecao(1001)

    println(cliente.historico)
    println(funcionario.historico)

    biblioteca.verificarEstoque()
}