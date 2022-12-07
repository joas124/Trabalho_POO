/**
 * Classe para a gestao de um cafe
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public class Cafe extends Restauracao {
    /**
     * Numero medio de cafes vendidos por dia
     */
    private double numMedCafesVendidosDia;
    /**
     * Valor medio de faturacao anual por cada cafe vendido por dia
     */
    private double valMedFaturacaoAnualCafeVendidoDia;

    /**
     * Construtor default para a classe Cafe
     */
    public Cafe(){}

    /**
     * Construtor para a classe Cafe
     * @param nome String com o nome do cafe
     * @param distrito String com o distrito onde o cafe esta localizado
     * @param localizacao Objeto GPS com as coordenadas da localizacao do cafe
     * @param numEmpregadosMesa numero de empregados de mesa que trabalham no cafe
     * @param numMedClientesDiario numero medio de clientes que frequentam o cafe diariamente
     * @param custoEmpregadosMesa despesa do cafe associada aos custos dos empregados de mesa
     * @param custoSalarioMedioAnual despesa do cafe associada aos salarios medios anuais dos empregados de mesa
     * @param numMedCafesVendidosDia numero medio de cafes vendidos por dia nesse estabelecimento
     * @param valMedFaturacaoAnualCafeVendidoDia valor medio de faturacao anual por cafe vendido por dia
     */
    public Cafe(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double numMedCafesVendidosDia, double valMedFaturacaoAnualCafeVendidoDia) {
        super("Café", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.numMedCafesVendidosDia = numMedCafesVendidosDia;
        this.valMedFaturacaoAnualCafeVendidoDia = valMedFaturacaoAnualCafeVendidoDia;
    }

    /**
     * Metodo para obter o numero medio de cafes vendidos por dia
     * @return double com o numero medio de cafes vendidos por dia
     */
    public double getNumMedCafesVendidosDia() {
        return numMedCafesVendidosDia;
    }

    /**
     * Metodo para definir o numero medio de cafes vendidos por dia
     * @param numMedCafesVendidosDia double com o numero medio de cafes vendidos por dia
     */
    public void setNumMedCafesVendidosDia(double numMedCafesVendidosDia) {
        this.numMedCafesVendidosDia = numMedCafesVendidosDia;
    }

    /**
     * Metodo para obter o valor medio de faturacao anual por cafe vendido por dia
     * @return double com o valor medio de faturacao anual por cafe vendido por dia
     */
    public double getValMedFaturacaoAnualCafeVendidoDia() {
        return valMedFaturacaoAnualCafeVendidoDia;
    }

    /**
     * Metodo para definir o valor medio de faturacao anual por cafe vendido por dia
     * @param valMedFaturacaoAnualCafeVendidoDia double com o valor medio de faturacao anual por cafe vendido por dia
     */
    public void setValMedFaturacaoAnualCafeVendidoDia(double valMedFaturacaoAnualCafeVendidoDia) {
        this.valMedFaturacaoAnualCafeVendidoDia = valMedFaturacaoAnualCafeVendidoDia;
    }

    /**
     * Metodo que efetua o calculo da receita anual do cafe
     * @return double com o valor da receita anual
     */
    @Override
    public double defReceitaAnual() {
        return numMedCafesVendidosDia * valMedFaturacaoAnualCafeVendidoDia;
    }

    /**
     * Metodo que efetua o calculo do lucro do cafe
     * @return <i>True</i> caso o cafe obtenha lucro no final do ano, <i>False</i> caso obtenha prejuizo
     */
    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    /**
     * Metodo para converter a classe Cafe em String
     * @return String com o numero medio de cafes vendidos por dia e o valor medio
     * de faturacao anual de cafes vendidos por dia
     */
    @Override
    public String toString() {
        return super.toString() +
                "\t•Numero medio de cafes vendidos por dia = " + numMedCafesVendidosDia + '\n' +
                "\t•Valor medio de faturacao anual de cafes vendidos por dia = " + valMedFaturacaoAnualCafeVendidoDia + "€\n";
    }
    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return "1," + super.toStringFicheiro() + numMedCafesVendidosDia + ',' + valMedFaturacaoAnualCafeVendidoDia + '\n';
    }
}
