public class Frutaria extends Mercearia {
    private int numProdutos;
    private float valMedFaturacaoAnualProduto;

    public Frutaria(){}

    public Frutaria(String nome, String distrito, GPS localizacao, float custoAnualLimpezaEstabelecimento, int numProdutos, float valMedFaturacaoAnualProduto) {
        super("Frutaria", nome, distrito, localizacao, custoAnualLimpezaEstabelecimento);
        this.numProdutos = numProdutos;
        this.valMedFaturacaoAnualProduto = valMedFaturacaoAnualProduto;
    }

    public int getNumProdutos() {
        return numProdutos;
    }

    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }

    public float getValMedFaturacaoAnualProduto() {
        return valMedFaturacaoAnualProduto;
    }

    public void setValMedFaturacaoAnualProduto(float valMedFaturacaoAnualProduto) {
        this.valMedFaturacaoAnualProduto = valMedFaturacaoAnualProduto;
    }

    @Override
    public float defReceitaAnual() {
        return numProdutos * valMedFaturacaoAnualProduto;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t•Número de produtos = " + numProdutos + '\n' +
                "\t•Valor médio de faturação anual por produto = " + valMedFaturacaoAnualProduto + "€\n";
    }

    @Override
    public String toStringFicheiro() {
        return '5' + super.toStringFicheiro() + numProdutos + ',' + valMedFaturacaoAnualProduto;
    }
}
