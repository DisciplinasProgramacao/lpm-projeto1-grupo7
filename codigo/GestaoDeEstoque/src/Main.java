
public class Main {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto("Descricao", 10, 10 );
        Produto feijao = new Produto();
        Produto arroz = new Produto();

        Estoque estoque = new Estoque(100);

        produto.registraMargemDeLucro(40);
        produto.comprarProduto(10);
        produto.venderProduto(3);
        produto.print();

        estoque.Guardar(produto);
        estoque.Guardar(arroz);
        estoque.Guardar(feijao);
        estoque.Remover("arroz");
        System.out.println(estoque.procurar("feijao"));
        estoque.ProdutosAbaixoEstoqueMinimo();
        
    }
}
