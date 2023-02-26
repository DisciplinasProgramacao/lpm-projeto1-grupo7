public class Produto {
    private int id;
    private String nome, descricao;
    private double precoDeCusto, precoDeVenda;
    private double margemDeLucro, valorDoImposto;
    private static double valorArrecadado;
    private static int quantidade;
    private int quantidadeMinima;

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public double getMargemDeLucro() {
        return margemDeLucro;
    }

    public void setMargemDeLucro(double margemDeLucro) {
        this.margemDeLucro = margemDeLucro;
    }

    public double getValorDoImposto() {
        return valorDoImposto;
    }

    public void setValorDoImposto(double valorDoImposto) {
        this.valorDoImposto = valorDoImposto;
    }

    public static double getValorArrecadado() {
        return valorArrecadado;
    }

    public static void setValorArrecadado(double valorArrecadado) {
        Produto.valorArrecadado = valorArrecadado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
}
