import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

public class EstoqueTest {
    Estoque estoque = new Estoque(5);

    @Test
    public void testAdicionarProdutosLista() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Guardar(produto);
        assertEquals(1, estoque.ultimo);
    }

    @Test
    public void testAdicionarProdutosListaCheia() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Guardar(produto);
        estoque.Guardar(produto);
        estoque.Guardar(produto);
        estoque.Guardar(produto);
        estoque.Guardar(produto);
        try {
            estoque.Guardar(produto);
        } catch (Exception e) {
            assertEquals("Lista Cheia", e.getMessage());
        }
    }

    @Test
    public void testRemoverProdutosLista() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Guardar(produto);
        estoque.Remover(produto.getDescricao());
        assertEquals(0, estoque.ultimo);
    }

    @Test
    public void testRemoverProdutosListaVazia() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Remover(produto.getDescricao());
        assertEquals(0, estoque.ultimo);
    }

    @Test
    public void testRemoverProdutosListaNaoExiste() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Guardar(produto);
        estoque.Remover("Feijão");
        assertEquals(1, estoque.ultimo);
    }

    @Test
    public void testProcurarProdutos() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Guardar(produto);
        assertEquals(produto, estoque.procurar(produto.getDescricao()));
    }

    @Test
    public void testProcurarProdutosNaoExiste() throws Exception {
        Produto produto = new Produto("Arroz", 10, 60);
        estoque.Guardar(produto);
        assertEquals(null, estoque.procurar("Feijão"));
    }
    @Test
    public void testProcurarProdutosListaVazia() throws Exception {
        assertEquals(null, estoque.procurar("Feijão"));
    }
    @Test
    public void testProdutosEstoqueAbaixoMinimo() throws Exception {
        
    }
}
