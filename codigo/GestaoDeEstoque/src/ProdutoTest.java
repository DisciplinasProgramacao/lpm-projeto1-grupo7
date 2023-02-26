import jdk.jfr.Description;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest extends TestCase {

    @Test
    @Description("Checa se um produto é instância da classe Produto")
    public void testaInstanciaDeProduto() {
        Produto p = new Produto(10, "iphone 13");
        Assertions.assertInstanceOf(Produto.class, p);
    }

    @Test
    @Description("Deve retornar um preço de venda")
    public void testaCalcularPrecoDeVenda() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;

        Produto p = new Produto(precoDeCusto, "Breve descrição sobre o produto");
        double calculoPrecoDeVenda = p.calculaPrecoDeVenda(margemDeLucro);

        Assertions.assertEquals(35.4, calculoPrecoDeVenda);
    }

    @Test
    @Description("Deve setar preço de venda")
    public void testaPetPrecoVenda() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;

        Produto p = new Produto(precoDeCusto, "Breve descrição sobre o produto");
        p.setPrecoDeVenda(margemDeLucro);

        Assertions.assertEquals(35.40, p.getPrecoDeVenda());
    }

    @Test
    @Description("Preço de Venda deve permanecer zerado ao tentar inserir uma margem de lucro inválida")
    public void testaPrecoDeVenda() throws Exception {
        double precoDeCusto = 20;
        double margemDeLucro = 10;

    Produto p = new Produto(precoDeCusto, "Breve descrição sobre o produto");

        p.setPrecoDeVenda(margemDeLucro);

        Assertions.assertEquals(0.0, p.getPrecoDeVenda());
    }

    @Test
    @Description("Deve acrescentar x unidades em quantidade vendida")
    public void testaQuantidadeVendida() {
        int unidadesVendidas = 10;

        Produto p = new Produto();

        p.registraQuantidadeVendida(unidadesVendidas);

        Assertions.assertEquals(unidadesVendidas, p.getQuantidadeVendida());
    }


    @Test
    @Description("Deve incrementar o preço arrecadado ao vender x produtos")
    public void testaVender() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;
        int quantidadeVendida = 10;

        Produto p = new Produto(precoDeCusto, "Breve descrição sobre o produto");

        p.setPrecoDeVenda(margemDeLucro);
        double precoDeVenda = p.getPrecoDeVenda();
        p.venderProduto(quantidadeVendida);
        double valorVendido = precoDeVenda * quantidadeVendida;

        Assertions.assertEquals(valorVendido, p.getValorArrecadado());
    }

    @Test
    @Description("Deve acrescentar x reais em valor arrecadados ao comprar x produtos")
    public void testaComprar() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;
        int quantidadeVendida = 10;

        Produto p = new Produto(precoDeCusto, "Breve descrição sobre o produto");

        p.setPrecoDeVenda(margemDeLucro);
        double precoDeVenda = p.getPrecoDeVenda();
        p.comprarProduto(quantidadeVendida);
        double valorArrecadado = precoDeVenda * quantidadeVendida;

        Assertions.assertEquals(valorArrecadado, p.getValorArrecadado());
    }
}
