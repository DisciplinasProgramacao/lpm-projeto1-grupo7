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

    public Produto(String descricao, double precoCusto) throws Exception {
        this.descricao = descricao;
        this.precoDeCusto = precoCusto;
    }

    // Getters and Setters ======================

    public double getValorArrecadado() {
        return this.valorArrecadado;
    }

    public double getPrecoDeVenda() {
        return this.precoDeVenda;
    }

    public int getQuantidadeVendida() {
        return this.quantidadeVendida;
    }

    public int getQuantidadeComprada() {
        return this.quantidadeComprada;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setPrecoDeVenda() { // Testado
        try {
            this.precoDeVenda = calculaPrecoDeVenda(this.precoDeCusto, this.margemDeLucro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setPrecoDeCusto(double precoCusto) {
        try {
            this.precoDeCusto = precoCusto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double getMargemDeLucro() {
        return this.margemDeLucro;
    }

    // Método para obter o estoque atual do produto
    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    // Método para obter o estoque mínimo do produto
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }


    // Métodos ======================

    public double registraMargemDeLucro(double margemDeLucro) throws Exception {
        if(margemDeLucro >= 30 && margemDeLucro <= 80) {
            this.margemDeLucro = margemDeLucro;
            return margemDeLucro;
        };
        throw new Exception("Margem de Lucro Inválida");
    }

    public double calculaPrecoDeVenda(double precoDeCusto, double margemDeLucro) {
        return 1+(impostos) * ((precoDeCusto * margemDeLucro / 100) + precoDeCusto);
    }

    public void registraQuantidadeVendida(int quantidade) {
        this.quantidadeVendida += quantidade;
    }

    public void registraVendaProduto(int quantidadeVendida) {
        this.estoqueAtual -= quantidadeVendida;
        this.valorArrecadado += (this.precoDeVenda * quantidadeVendida);
        registraQuantidadeVendida(quantidadeVendida);
    }

    public void registraQuantidadeComprada(int quantidade) {
        this.quantidadeComprada += quantidade;
    }

    public void registraCompraProduto(int quantidadeComprada, double precoCusto) {
        this.estoqueAtual += quantidadeComprada;
        this.precoDeCusto = precoCusto;
        registraQuantidadeComprada(quantidadeComprada);
    }
}
