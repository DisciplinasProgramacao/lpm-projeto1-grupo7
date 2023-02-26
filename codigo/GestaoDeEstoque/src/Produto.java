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

    public void setPrecoDeVenda(double precoDeCusto, double margemDeLucro) {
        try {
            if(validaMargemDeLucro(margemDeLucro)) {
                this.precoDeVenda = calculaPrecoDeVenda(precoDeCusto, margemDeLucro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean validaMargemDeLucro(double margemDeLucro) throws Exception {
        if(margemDeLucro >= 30 && margemDeLucro <= 80) return true;
        throw new Exception("Margem de Lucro Inválida");
    }

    public double calculaPrecoDeVenda(double precoDeCusto, double margemDeLucro) {
        double lucro = precoDeCusto * (margemDeLucro / 100);
        double imposto = precoDeCusto * (18 / 100);
        return (precoDeCusto + lucro + imposto);
    }

    public void registraQuantidadeVendida(int quantidade) {
        this.quantidadeVendida += quantidade;
    }

    public void venderProduto(int quantidadeVendida) {
        valorArrecadado += (precoDeVenda * quantidadeVendida);
        registraQuantidadeVendida(quantidadeVendida);
    }

    public void comprarProduto(int quantidadeComprada) {
        venderProduto(quantidadeComprada);
    }
}
