import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MIT License
 *
 * Copyright(c) 2023 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class ProdutoTest {

    @Test
    public void deveRegistraMargemDeLucroInvalida() throws Exception {
        Produto produto = new Produto();
        try {
            produto.registraMargemDeLucro(20);
        } catch (Exception e) {
            assertEquals("Margem de Lucro Inválida", e.getMessage());
        }
    }

    @Test
    public void deveRegistraMargemDeLucroValida() throws Exception {
        Produto produto = new Produto();
        produto.registraMargemDeLucro(50);
        assertEquals(50, produto.getMargemDeLucro(), 0.1);
    }

    @Test
    public void deveRegistrarPrecoDeVenda() throws Exception {
        Produto produto = new Produto("", 20, 50, 5);
        assertEquals(35.4, produto.getPreçoDeVenda(), 0.01);
    }

    @Test
    public void deveComprarProduto() throws Exception {
        Produto produto = new Produto();
        produto.comprarProduto(7);
        assertEquals(7, produto.getQuantidadeComprada());
    }

    @Test
    public void calculaValorGasto() throws Exception {
        Produto produto = new Produto("", 20, 50, 0);
        produto.comprarProduto(7);
        assertEquals(140, produto.getValorGasto(), 0.1);
    }

    @Test
    public void deveVenderProduto() throws Exception {
        Produto produto = new Produto();
        produto.comprarProduto(10);
        produto.venderProduto(9);
        assertEquals(9, produto.getQuantidadeVendida());
    }

    @Test
    public void calculaValorArrecadado() throws Exception {
        Produto produto = new Produto("", 20, 50, 0);
        produto.comprarProduto(10);
        produto.venderProduto(9);
        assertEquals(318.6, produto.getValorArrecadado(), 0.1);
    }

    @Test
    public void deveMostrarDadosDoProduto() throws Exception {
        Produto produto = new Produto("Alprazolam 1mg", 10, 40, 10);
        assertEquals("Descrição do produto: Alprazolam 1mg\nPreço de Custo: R$10,00\nValor de Venda: R$16,52",
                produto.print());
    }

}
