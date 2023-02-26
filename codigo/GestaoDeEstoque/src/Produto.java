public class Produto {
    private static int id = 0;
    private String nome, descricao;
    private double precoDeCusto, precoDeVenda;
    private double margemDeLucro;
    private double valorArrecadado;
    private static int quantidade;
    private int quantidadeMinima;

    public Produto(int id, String nome, String descricao, double precoDeCusto, int quantidade, int quantidadeMinima) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setPrecoDeCusto(precoDeCusto);
        setQuantidade(quantidade);
        setQuantidadeMinima(quantidadeMinima);
        setPrecoDeVenda(getPrecoDeCusto(), getMargemDeLucro());
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

    public void setPrecoDeVenda(double precoDeCusto, double margemDeLucro) {
        this.precoDeVenda = 1.18 * ((precoDeCusto * (margemDeLucro / 100)) + precoDeCusto);
    }

    public double getMargemDeLucro() {
        return margemDeLucro;
    }

    public void setMargemDeLucro(double margemDeLucro) {
        if(!(margemDeLucro >= 30 && margemDeLucro <= 80)) {
            this.margemDeLucro = 50; // comportamento padrão para que se a margem de lucro inserida for inválida, o código seta automaticamente para 50
        } else {
            this.margemDeLucro = margemDeLucro;
        }
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public void setValorArrecadado(double valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
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
