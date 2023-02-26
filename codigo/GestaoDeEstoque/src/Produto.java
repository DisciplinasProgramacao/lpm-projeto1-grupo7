import org.junit.jupiter.api.function.Executable;

public class Produto {
    private String descricao;
    private double precoDeCusto;
    private double precoDeVenda;
    private static int quantidadeVendida;
    private static double valorArrecadado;

    public Produto(double precoDeCusto, String descricao) {
        setDescricao(descricao);
        setPrecoDeCusto(precoDeCusto);
        quantidadeVendida = 0;
        valorArrecadado = 0;
    }

    // Construtor para teste
    public Produto() {}

    // Getters and Setters ======================

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

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setPrecoDeVenda(double margemDeLucro) { // Testado
        try {
            if(validaMargemDeLucro(margemDeLucro)) {
                this.precoDeVenda = calculaPrecoDeVenda(margemDeLucro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Métodos ======================

    public boolean validaMargemDeLucro(double margemDeLucro) throws Exception { // Testado
        if(margemDeLucro >= 30 && margemDeLucro <= 80) return true;
        throw new Exception("Margem de Lucro Inválida");
    }

    public double calculaPrecoDeVenda(double margemDeLucro) { // Testado
        return 1.18 * ((getPrecoDeCusto() * margemDeLucro / 100) + getPrecoDeCusto());
    }

    public void registraQuantidadeVendida(int quantidade) { // Testado
        quantidadeVendida += quantidade;
    }

    public void venderProduto(int quantidadeVendida) { // Testado
        valorArrecadado += (getPrecoDeVenda() * quantidadeVendida);
        registraQuantidadeVendida(quantidadeVendida);
    }

    public void comprarProduto(int quantidadeComprada) { // Testado
        venderProduto(quantidadeComprada);
    }
}
