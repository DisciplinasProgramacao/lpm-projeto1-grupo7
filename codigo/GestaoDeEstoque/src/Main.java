
public class Main {
    public static void main(String[] args) throws Exception {
        Produto arroz = new Produto("arroz", 10, 40, 20);
        Produto feijao = new Produto("feijao", 7, 45, 18);
        Produto macarrao = new Produto("macarrao", 6, 470, 20);
        Produto morango = new Produto("morango", 2, 80, 40);
        Produto chocolate = new Produto("chocolate", 8, 50, 5);
        Estoque estoque = new Estoque(10);

        morango.comprarProduto(43);
        arroz.comprarProduto(30);
        chocolate.venderProduto(4);

        estoque.Guardar(macarrao);
        estoque.Guardar(arroz);
        estoque.Guardar(feijao);
        estoque.Guardar(morango);
        estoque.Guardar(chocolate);

        estoque.Remover("arroz");

        System.out.println("Informaçöes do produto" + estoque.procurar("feijao").print());

        System.out.println("Produto(s) abaixo do estoque:" + estoque.ProdutosAbaixoEstoqueMinimo().print());

        System.out.println("O estoque vale:" + estoque.valorTotalEmEstoque());
        
    }
}
