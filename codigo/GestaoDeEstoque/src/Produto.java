public class Produto {
    private String descricao;
    private double precoDeCusto;
    private double margemDeLucro;
    private double impostos = 0.18;
    private int estoqueAtual;
    private int estoqueMinimo;
    private double precoDeVenda;
    private int quantidadeVendida;
    private int quantidadeComprada;
    private double valorArrecadado;
    private double valorGasto;

    // **Verificar a necessidade de um construtor sem parametros, pra evitar quebras
    // de sistema por criar um objeto null. Priorizar a criação so com parametros */
    public Produto() {
        quantidadeVendida = 0;
        valorArrecadado = 0;
        valorGasto = 0;
    }

    public Produto(String descricao, double precoCusto, int margemDeLucro, int estoqueMinimo) throws Exception {
        this.descricao = descricao;
        this.precoDeCusto = precoCusto;
        registraMargemDeLucro(margemDeLucro);
        this.estoqueAtual = estoqueMinimo;
        this.estoqueMinimo = estoqueMinimo;
        PrecoDeVenda(precoCusto, margemDeLucro);
    }

    // Getters and Setters ======================

    public String getDescricao() {
        return descricao;
    }

    public double getPreçoDeVenda() {
        return precoDeVenda;
    }

    public double getMargemDeLucro() {
        return margemDeLucro;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

    // ====================== Métodos ======================
    /**
     * Setter que seta o valor de precoDeVenda com o retorno do método
     * calculaPrecoDeVenda
     * 
     * @return void
     * @param precoDeCusto  double - Preço de Custo de um Produto passado pelo
     *                      construtor
     * @param margemDeLucro double - Margem de Lucro de um Produto passa pelo
     *                      construtor
     */
    public void PrecoDeVenda(double precoDeCusto, double margemDeLucro) { // Testado
        try {
            this.precoDeVenda = calculaPrecoDeVenda(precoDeCusto, margemDeLucro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que retorna uma margemDeLucro passando por uma expressão lógica só é
     * aceito valores entre 30 e 80
     * 
     * @return void
     */
    public void registraMargemDeLucro(int margemDeLucro) throws Exception {
        if (margemDeLucro >= 30 && margemDeLucro <= 80) {
            this.margemDeLucro = margemDeLucro;
        } else {
            throw new Exception("Margem de Lucro Inválida");
        }

    }

    /**
     * Método que calcula o preco de venda de um produto
     * 
     * @return double - Preço de Venda
     * @param precoDeCusto  double - Preço de Custo de um Produto passado pelo
     *                      construtor
     * @param margemDeLucro double - Margem de Lucro de um Produto passa pelo
     *                      construtor
     */
    public double calculaPrecoDeVenda(double precoDeCusto, double margemDeLucro) {
        return (1 + (impostos)) * ((precoDeCusto * margemDeLucro / 100) + precoDeCusto);
    }

    /**
     * Método que decrementa do estoque a quantidade de x de itens vendidos e soma a
     * sua arrecadação ao valor de caixa
     * 
     * @param quantidade
     */
    public void venderProduto(int quantidade) throws Exception {
        if (this.estoqueAtual - quantidade > 0) {
            this.estoqueAtual -= quantidade;
            this.valorArrecadado += calculaValorArrecadado(this.precoDeVenda, quantidade);
            this.quantidadeVendida += quantidade;

        }else
            throw new Exception("Estoque insuficiente");

    }

    /**
     * Método que calcula o valor arrecadado com x unidades de produto vendidas ou
     * compradas
     * 
     * @return double
     * @param precoDeVenda      double - Preço de Venda de um Produto
     * @param quantidadeVendida int - Unidades de produtos vendidas
     */
    private double calculaValorArrecadado(double precoDeVenda, int quantidadeVendida) {
        return precoDeVenda * quantidadeVendida;
    }

    /**
     * Método que acrescenta um valor x de produtos no estoque e realização a
     * subtração do valor gasto do caixa
     * 
     * @param quantidade
     */
    public void comprarProduto(int quantidade) {
        this.estoqueAtual += quantidade;
        this.valorGasto += calculaValorArrecadado(this.precoDeCusto, quantidade);
        this.quantidadeComprada += quantidade;
    }

    // #region Mostrar Dados

    public String print() {
        return "Descrição do produto: " + this.descricao + String.format("\nPreço de Custo: R$%.2f", this.precoDeCusto)
                + String.format("\nValor de Venda: R$%.2f", this.precoDeVenda);
    }
    // #endregion
}
