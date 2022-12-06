/**
 * Classe para a gestao de um restaurante local
 */
public class RestauranteLocal extends Restaurante {
    /**
     * Numero de mesas na esplanada
     */
    private int numMesasEsplanada;
    /**
     * Custo de licenca anual por mesa de esplanada
     */
    private double custoLicencaAnualMesaEsplanada;

    /**
     * Construtor default para a classe RestauranteLocal
     */
    public RestauranteLocal(){}

    /**
     * Construtor para a classe RestauranteLocal
     * @param nome String com o nome do restaurante local
     * @param distrito String com o distrito onde o restaurante local está localizado
     * @param localizacao Objeto GPS com as coordenadas da localização do restaurante local
     * @param numEmpregadosMesa numero de empregados de mesa que trabalham no restaurante local
     * @param numMedClientesDiario numero medio de clientes que frequentam o restaurante local diariamente
     * @param custoEmpregadosMesa despesa do restaurante local associada aos custos dos empregados de mesa
     * @param custoSalarioMedioAnual despesa do restaurante local associada aos salarios medios anuais dos empregados de mesa
     * @param valMedioFaturacaoMesaDia valor medio de faturacao de cada mesa por dia
     * @param numDiasFuncionamentoAno numero de dias de funcionamento por ano
     * @param numMesasInteriores numero de mesas interiores
     * @param numMesasEsplanada numero de mesas na esplanada
     * @param custoLicencaAnualMesaEsplanada custo de licenca anual por mesa de esplanada
     */
    public RestauranteLocal(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores, int numMesasEsplanada, double custoLicencaAnualMesaEsplanada) {
        super("Restaurante Local", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual, valMedioFaturacaoMesaDia, numDiasFuncionamentoAno, numMesasInteriores);
        this.numMesasEsplanada = numMesasEsplanada;
        this.custoLicencaAnualMesaEsplanada = custoLicencaAnualMesaEsplanada;
    }

    /**
     * Metodo para obter o numero de mesas na esplanada
     * @return int com o numero de mesas na esplanada
     */
    public int getNumMesasEsplanada() {
        return numMesasEsplanada;
    }

    /**
     * Metodo para definir o numero de mesas na esplanada
     * @param numMesasEsplanada int com o numero de mesas na esplanada
     */
    public void setNumMesasEsplanada(int numMesasEsplanada) {
        this.numMesasEsplanada = numMesasEsplanada;
    }

    /**
     * Metodo para obter o custo de licenca anual por mesa de esplanada
     * @return double com o custo de licenca anual por mesa de esplanada
     */
    public double getCustoLicencaAnualMesaEsplanada() {
        return custoLicencaAnualMesaEsplanada;
    }

    /**
     *  Metodo para definir o custo de licenca anual por mesa de esplanada
     * @param custoLicencaAnualMesaEsplanada double com o custo de licenca anual por mesa de esplanada
     */
    public void setCustoLicencaAnualMesaEsplanada(double custoLicencaAnualMesaEsplanada) {
        this.custoLicencaAnualMesaEsplanada = custoLicencaAnualMesaEsplanada;
    }

    /**
     * Metodo que efetua o calculo da receita anual do restaurante local
     * @return double com o valor da receita anual
     */
    @Override
    public double defReceitaAnual() {
        return (numMesasInteriores + numMesasEsplanada) * valMedioFaturacaoMesaDia * numDiasFuncionamentoAno;
    }

    /**
     * Metodo que efetua o calculo da despesa anual do restaurante local
     * @return double com o valor da despesa anual
     */
    @Override
    public double defDespesaAnual() {
        return (numEmpregadosMesa * custoSalarioMedioAnual) + (numMesasEsplanada * custoLicencaAnualMesaEsplanada);
    }

    /**
     * Metodo que efetua o calculo do lucro do restaurante local
     * @return <i>True</i> caso o restaurante local obtenha lucro no final do ano, <i>False</i> caso obtenha prejuizo
     */
    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    /**
     * Metodo para converter a classe RestauranteLocal em String
     * @return String com o numero de mesas da esplanada
     * e o custo da licenca anual por cada uma
     */
    @Override
    public String toString() {
        return  super.toString() +
                "\t•Numero de mesas da esplanada = " + numMesasEsplanada + "\n" +
                "\t•Custo da licenca anual por mesa da esplanada = " + custoLicencaAnualMesaEsplanada + "€\n";
    }

    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return "3," + super.toStringFicheiro() + numMesasEsplanada + ',' + custoLicencaAnualMesaEsplanada + '\n';
    }
}
