/**
 * Classe para a gestao de uma frutaria
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public class Frutaria extends Mercearia {
    /**
     * Numero de produtos
     */
    private int numProdutos;
    /**
     * Valor medio de faturacao anual por produto
     */
    private double valMedFaturacaoAnualProduto;

    /**
     * Construtor default para a classe Frutaria
     */
    public Frutaria(){}

    /**
     * Construtor para a classe Frutaria
     * @param nome String com o nome da frutaria
     * @param distrito String com o distrito onde a frutaria esta localizada
     * @param localizacao Objeto GPS com as coordenadas da localizacao da frutaria
     * @param custoAnualLimpezaEstabelecimento custo anual da limpeza do estabelecimento
     * @param numProdutos numero de produtos
     * @param valMedFaturacaoAnualProduto valor medio de faturacao anual por produto
     */
    public Frutaria(String nome, String distrito, GPS localizacao, double custoAnualLimpezaEstabelecimento, int numProdutos, double valMedFaturacaoAnualProduto) {
        super("Frutaria", nome, distrito, localizacao, custoAnualLimpezaEstabelecimento);
        this.numProdutos = numProdutos;
        this.valMedFaturacaoAnualProduto = valMedFaturacaoAnualProduto;
    }

    /**
     * Metodo para obter o numero de produtos
     * @return int com o numero de produtos
     */
    public int getNumProdutos() {
        return numProdutos;
    }

    /**
     * Metodo para definir o numero de produtos
     * @param numProdutos int com o numero de produtos
     */
    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }

    /**
     * Metodo para obter o valor medio de faturacao anual por produto
     * @return double com o valor medio de faturacao anual por produto
     */
    public double getValMedFaturacaoAnualProduto() {
        return valMedFaturacaoAnualProduto;
    }

    /**
     * Metodo para definir o valor medio de faturacao anual por produto
     * @param valMedFaturacaoAnualProduto double com o valor medio de faturacao anual por produto
     */
    public void setValMedFaturacaoAnualProduto(double valMedFaturacaoAnualProduto) {
        this.valMedFaturacaoAnualProduto = valMedFaturacaoAnualProduto;
    }

    /**
     * Metodo que efetua o calculo da receita anual da frutaria
     * @return double com o valor da receita anual
     */
    @Override
    public double defReceitaAnual() {
        return numProdutos * valMedFaturacaoAnualProduto;
    }

    /**
     * Metodo que efetua o calculo do lucro do frutaria
     * @return <i>True</i> caso a frutaria obtenha lucro no final do ano, <i>False</i> caso obtenha prejuizo
     */
    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    /**
     * Metodo para converter a classe Frutaria em String
     * @return String com o numero de produtos e o valor medio de faturacao anual por produto
     */
    @Override
    public String toString() {
        return super.toString() +
                "\t•Número de produtos = " + numProdutos + '\n' +
                "\t•Valor médio de faturação anual por produto = " + valMedFaturacaoAnualProduto + "€\n";
    }
    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return "5," + super.toStringFicheiro() + numProdutos + ',' + valMedFaturacaoAnualProduto + '\n';
    }
}
