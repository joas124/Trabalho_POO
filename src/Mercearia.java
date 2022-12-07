/**
 * Classe para a gestao de uma empresa da area da Mercearia
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public abstract class Mercearia extends Empresa{
    /**
     * Custo anual de limpeza do estabelecimento
     */
    protected double custoAnualLimpezaEstabelecimento;

    /**
     * Construtor default da classe Mercearia
     */
    public Mercearia(){}

    /**
     * Construtor da classe Mercearia
     * @param nome String com o nome da empresa de Mercearia
     * @param categoria String com a categoria da empresa
     * @param distrito String com o distrito onde a empresa esta localizada
     * @param localizacao Objeto GPS com as coordenadas da localizacao da empresa
     * @param custoAnualLimpezaEstabelecimento custo anual da limpeza do estabelecimento
     */
    public Mercearia(String categoria, String nome, String distrito, GPS localizacao, double custoAnualLimpezaEstabelecimento) {
        super(categoria, nome, distrito, localizacao);
        this.custoAnualLimpezaEstabelecimento = custoAnualLimpezaEstabelecimento;
    }

    /**
     * Metodo para obter o custo anual da limpeza do estabelecimento
     * @return double com o custo anual da limpeza do estabelecimento
     */
    public double getCustoAnualLimpezaEstabelecimento(){
        return custoAnualLimpezaEstabelecimento;
    }

    /**
     * Metodo para definir o custo anual da limpeza do estabelecimento
     * @param custoAnualLimpezaEstabelecimento double com o custo anual da limpeza do estabelecimento
     */
    public void setCustoAnualLimpezaEstabelecimento(double custoAnualLimpezaEstabelecimento) {
        this.custoAnualLimpezaEstabelecimento = custoAnualLimpezaEstabelecimento;
    }

    /**
     * Metodo para obter o custo anual da limpeza do estabelecimento
     * @return double com o custo anual da limpeza do estabelecimento
     */
    @Override
    public double defDespesaAnual() {
        return custoAnualLimpezaEstabelecimento;
    }

    /**
     * Método abstrato para apresentar (em uma empresa da area da restauracao)
     * a maior capacidade de clientes por dia.
     * @return Um double com a maior capacidade de clientes por dia (caso a empresa seja da
     * area da restauracao), 0 caso contrario
     */
    @Override
    public double capacidadeRestauracao() {
        return 0;
    }

    /**
     * Metodo para converter a classe Mercearia em String
     * @return String com o custo anual de limpeza do estabelecimento
     */
    @Override
    public String toString() {
        return super.toString() +
                "\t•Custo anual de limpeza do estabelecimento = " + custoAnualLimpezaEstabelecimento + "€\n";
    }
    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return super.toStringFicheiro() + custoAnualLimpezaEstabelecimento + ',';
    }
}
