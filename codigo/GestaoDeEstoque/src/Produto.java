import org.junit.jupiter.api.function.Executable;

public class Produto {
    private String descricao;
    private double precoDeCusto;
    private double precoDeVenda;
    private static int quantidadeVendida;
    private static double valorArrecadado;

    public Produto() {
        quantidadeVendida = 0;
        valorArrecadado = 0;
    }

    // Getters and Setters ======================

    public static double getValorArrecadado() {
        return valorArrecadado;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setPrecoDeVenda(double precoDeCusto, double margemDeLucro) { // Testado
        try {
            if(validaMargemDeLucro(margemDeLucro)) {
                this.precoDeVenda = calculaPrecoDeVenda(precoDeCusto, margemDeLucro);
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

    public double calculaPrecoDeVenda(double precoDeCusto, double margemDeLucro) { // Testado
        return 1.18 * ((precoDeCusto * margemDeLucro / 100) + precoDeCusto);
    }

    public void registraQuantidadeVendida(int quantidade) { // Testado
        this.quantidadeVendida += quantidade;
    }

    public void venderProduto(int quantidadeVendida) { // Testado
        valorArrecadado += (precoDeVenda * quantidadeVendida);
        registraQuantidadeVendida(quantidadeVendida);
    }

    public void comprarProduto(int quantidadeComprada) { // Testado
        venderProduto(quantidadeComprada);
    }
}
