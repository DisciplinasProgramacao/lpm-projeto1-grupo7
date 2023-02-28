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

    public Produto() {
        quantidadeVendida = 0;
        valorArrecadado = 0;
    }

    public Produto(String descricao, double precoCusto, double margemDeLucro) throws Exception {
        setDescricao(descricao);
        setPrecoDeCusto(precoCusto);
        registraMargemDeLucro(margemDeLucro);
        setPrecoDeVenda(precoCusto, margemDeLucro);
    }

    // Getters and Setters ======================

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoDeCusto(double precoCusto) {
        this.precoDeCusto = precoCusto;
    }

    /** Setter que seta o valor de precoDeVenda com o retorno do método calculaPrecoDeVenda
     *  @return void
     *  @param precoDeCusto double - Preço de Custo de um Produto passado pelo construtor
     *  @param margemDeLucro double - Margem de Lucro de um Produto passa pelo construtor*/
    public void setPrecoDeVenda(double precoDeCusto, double margemDeLucro) { // Testado
        try {
            this.precoDeVenda = calculaPrecoDeVenda(precoDeCusto, margemDeLucro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ====================== Métodos ======================

    /** Método que retorna uma margemDeLucro passando por uma expressão lógica só é aceito valores entre 30 e 80
     *  @return void */
    public void registraMargemDeLucro(double margemDeLucro) throws Exception {
        if(margemDeLucro >= 30 && margemDeLucro <= 80) {
            this.margemDeLucro = margemDeLucro;
        };
        throw new Exception("Margem de Lucro Inválida");
    }

    /** Método que calcula o preco de venda de um produto
     *  @return double - Preço de Venda
     *  @param precoDeCusto double - Preço de Custo de um Produto passado pelo construtor
     *  @param margemDeLucro double - Margem de Lucro de um Produto passa pelo construtor */
    public double calculaPrecoDeVenda(double precoDeCusto, double margemDeLucro) {
        return 1+(impostos) * ((precoDeCusto * margemDeLucro / 100) + precoDeCusto);
    }

    /** Método que acrescenta x unidades de produtos vendido ao atributo quantidadeVendida
     *  @return void
     *  @param quantidade int - Unidades de produtos vendidas */
    public void registraQuantidadeVendida(int quantidade) {
        this.quantidadeVendida += quantidade;
    }


    /** Método que calcula o valor arrecadado com x unidades de produto vendida
     *  @return double
     *  @param precoDeVenda double - Preço de Venda de um Produto
     *  @param quantidadeVendida double - Unidades de produtos vendidas */
    public double calculaValorArrecadado(double precoDeVenda, double quantidadeVendida) {
        return precoDeVenda * quantidadeVendida;
    }

    /** Método que acrescente x quantidades compradas no atributo quantidadeComprada
     *  @return double
     *  @param quantidade int - Quantidade comprada de um produto */
    public void registraQuantidadeComprada(int quantidade) {
        this.quantidadeComprada += quantidade;
    }

    /** Método que subtrai a quantidade vendida do estoque atual e acrescenta o valor arrecadado
     *  @return void
     *  @param quantidadeVendida int - Unidades de produtos vendidas */
    public void registraVendaProduto(int quantidadeVendida) {
        this.estoqueAtual -= quantidadeVendida;
        this.valorArrecadado += calculaValorArrecadado(this.precoDeVenda, quantidadeVendida);
        registraQuantidadeVendida(quantidadeVendida);
    }

    /** Método que soma a quantidade vendida do estoque atual e subtrai o valor arrecadado
     *  @return void
     *  @param quantidadeComprada int - Unidades de produtos compradas
     *  @param precoCusto double - Preço de custo de um produto */
    public void registraCompraProduto(int quantidadeComprada, double precoCusto) {
        this.estoqueAtual += quantidadeComprada;
        this.valorArrecadado -= calculaValorArrecadado(this.precoDeVenda, quantidadeComprada);
        this.precoDeCusto = precoCusto;
        registraQuantidadeComprada(quantidadeComprada);
    }
}
