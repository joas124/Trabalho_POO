/**
 * Classe para a gestao de uma pastelaria
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public class Pastelaria extends Restauracao {
    /**
     * Numero medio de bolos vendidos por dia
     */
    private double numMedBolosVendidosDia;
    /**
     * Valor medio de faturacao anual por cada bolo vendido por dia
     */
    private double valMedFaturacaoAnualBoloVendidoDia;

    /**
     * Construtor default para a classe Pastelaria
     */
    public Pastelaria(){}

    /**
     * Construtor para a classe Pastelaria
     * @param nome String com o nome da pastelaria
     * @param distrito String com o distrito onde a pastelaria está localizada
     * @param localizacao Objeto GPS com as coordenadas da localização da pastelaria
     * @param numEmpregadosMesa numero de empregados de mesa que trabalham na pastelaria
     * @param numMedClientesDiario numero medio de clientes que frequentam a pastelaria diariamente
     * @param custoEmpregadosMesa despesa da pastelaria associada aos custos dos empregados de mesa
     * @param custoSalarioMedioAnual despesa da pastelaria associada aos salarios medios anuais dos empregados de mesa
     * @param numMedBolosVendidosDia numero medio de bolos vendidos por dia
     * @param valMedFaturacaoAnualBoloVendidoDia valor medio de faturacao anual por cada bolo vendido por dia
     */
    public Pastelaria(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double numMedBolosVendidosDia, double valMedFaturacaoAnualBoloVendidoDia) {
        super("Pastelaria", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.numMedBolosVendidosDia = numMedBolosVendidosDia;
        this.valMedFaturacaoAnualBoloVendidoDia = valMedFaturacaoAnualBoloVendidoDia;
    }

    /**
     * Metodo para obter o numero medio de bolos vendidos por dia
     * @return double com o numero medio de bolos vendidos por dia
     */
    public double getNumMedBolosVendidosDia() {
        return numMedBolosVendidosDia;
    }

    /**
     * Metodo para definir o numero medio de bolos vendidos por dia
     * @param numMedBolosVendidosDia double com o numero medio de bolos vendidos por dia
     */
    public void setNumMedBolosVendidosDia(double numMedBolosVendidosDia) {
        this.numMedBolosVendidosDia = numMedBolosVendidosDia;
    }

    /**
     * Metodo para obter o valor medio de faturacao anual por cada bolo vendido por dia
     * @return double com o valor medio de faturacao anual por cada bolo vendido por dia
     */
    public double getValMedFaturacaoAnualBoloVendidoDia() {
        return valMedFaturacaoAnualBoloVendidoDia;
    }

    /**
     * Metodo para definir o valor medio de faturacao anual por cada bolo vendido por dia
     * @param valMedFaturacaoAnualBoloVendidoDia double com o valor medio de faturacao anual por cada bolo vendido por dia
     */
    public void setValMedFaturacaoAnualBoloVendidoDia(double valMedFaturacaoAnualBoloVendidoDia) {
        this.valMedFaturacaoAnualBoloVendidoDia = valMedFaturacaoAnualBoloVendidoDia;
    }

    /**
     * Metodo que efetua o calculo da receita anual da pastelaria
     * @return double com o valor da receita anual
     */
    @Override
    public double defReceitaAnual() {
        return numMedBolosVendidosDia * valMedFaturacaoAnualBoloVendidoDia;
    }

    /**
     * Metodo que efetua o calculo do lucro da pastelaria
     * @return <i>True</i> caso a pastelaria obtenha lucro no final do ano, <i>False</i> caso obtenha prejuizo
     */
    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    /**
     * Metodo para converter a classe Pastelaria em String
     * @return String com o numero medio de bolos vendidos por dia e o valor medio
     * de faturacao anual de bolos vendidos por dia
     */
    @Override
    public String toString() {
        return super.toString() +
                "\t•Numero medio de bolos vendidos por dia = " + numMedBolosVendidosDia + '\n' +
                "\t•Valor medio de faturacao anual de bolos vendidos por dia = " + valMedFaturacaoAnualBoloVendidoDia + "€\n";
    }

    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return "2," + super.toStringFicheiro() + numMedBolosVendidosDia + ',' + valMedFaturacaoAnualBoloVendidoDia + '\n';
    }
}
