import jdk.jfr.Description;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest extends TestCase {
    private static Produto p;

    @BeforeEach
    public void inicializaProduto() {
        p = new Produto();
    }

    @Test
    @Description("Checa se um produto é instância da classe Produto")
    public void testaInstanciaDeProduto() {
        Assertions.assertInstanceOf(Produto.class, p);
    }

    @Test
    @Description("Deve retornar um preço de venda")
    public void testaCalcularPrecoDeVenda() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;

        double calculoPrecoDeVenda = p.calculaPrecoDeVenda(precoDeCusto, margemDeLucro);

        Assertions.assertEquals(35.4, calculoPrecoDeVenda);
    }

    @Test
    @Description("Deve setar preço de venda")
    public void testaPetPrecoVenda() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;

        p.setPrecoDeVenda(precoDeCusto, margemDeLucro);

        Assertions.assertEquals(35.40, p.getPrecoDeVenda());
    }

    @Test
    @Description("Preço de Venda deve permanecer zerado ao tentar inserir uma margem de lucro inválida")
    public void testaPrecoDeVenda() throws Exception {
        double precoDeCusto = 20;
        double margemDeLucro = 10;

        p.setPrecoDeVenda(precoDeCusto, margemDeLucro);

        Assertions.assertEquals(0.0, p.getPrecoDeVenda());
    }

    @Test
    @Description("Deve acrescentar x unidades em quantidade vendida")
    public void testaQuantidadeVendida() {
        int unidadesVendidas = 10;

        p.registraQuantidadeVendida(unidadesVendidas);

        Assertions.assertEquals(unidadesVendidas, p.getQuantidadeVendida());
    }


    @Test
    @Description("Deve incrementar o preço arrecadado ao vender x produtos")
    public void testaVender() {
        double precoDeCusto = 20;
        double margemDeLucro = 50;
        int quantidadeVendida = 10;

        p.setPrecoDeVenda(precoDeCusto, margemDeLucro);
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

        p.setPrecoDeVenda(precoDeCusto, margemDeLucro);
        double precoDeVenda = p.getPrecoDeVenda();
        p.comprarProduto(quantidadeVendida);
        double valorArrecadado = precoDeVenda * quantidadeVendida;

        Assertions.assertEquals(valorArrecadado, p.getValorArrecadado());
    }
}
