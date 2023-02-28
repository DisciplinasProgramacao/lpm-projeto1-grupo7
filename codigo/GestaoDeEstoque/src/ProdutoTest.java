import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest extends TestCase {
    private String descricao;
    private double precoCusto;

    @BeforeEach
    public void newProduto() {
        descricao = "description test";
        precoCusto = 10.00;
    }

    @Test
    public void testaRegistraMargemDeLucro() throws Exception {
        Produto p = new Produto(descricao, precoCusto);
        p.registraMargemDeLucro(50);

        assertEquals(50.0, p.getMargemDeLucro());
        assertNotNull(p.getMargemDeLucro());
    }
}
