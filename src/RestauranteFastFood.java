/**
 * Classe para a gestao de um restaurante fast-food
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public class RestauranteFastFood extends Restaurante {
    /**
     * Numero medio diario de clientes drive-thru
     */
    private double numMedioDiarioClientesDriveThru;
    /**
     * Valor medio de faturacao por cada cliente drive-thru
     */
    private double valMedioFaturacaoClienteDriveThru;

    /**
     * Construtor default para a classe RestauranteFastFood
     */
    public RestauranteFastFood(){}

    /**
     * Consrutor para a classe RestauranteFastFood
     * @param nome String com o nome do restaurante fast-food
     * @param distrito String com o distrito onde o restaurante fast-food está localizado
     * @param localizacao Objeto GPS com as coordenadas da localização do restaurante fast-food
     * @param numEmpregadosMesa numero de empregados de mesa que trabalham no restaurante fast-food
     * @param numMedClientesDiario numero medio de clientes que frequentam o restaurante fast-food diariamente
     * @param custoEmpregadosMesa despesa do restaurante fast-food associada aos custos dos empregados de mesa
     * @param custoSalarioMedioAnual despesa do restaurante fast-food associada aos salarios medios anuais dos empregados de mesa
     * @param valMedioFaturacaoMesaDia valor medio de faturacao de cada mesa por dia
     * @param numDiasFuncionamentoAno numero de dias de funcionamento por ano
     * @param numMesasInteriores numero de mesas interiores
     * @param numMedioDiarioClientesDriveThru numero medio diario de clientes drive-thru
     * @param valMedioFaturacaoClienteDriveThru valor medio de faturacao por cada cliente drive-thru
     */
    public RestauranteFastFood(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores, double numMedioDiarioClientesDriveThru, double valMedioFaturacaoClienteDriveThru) {
        super("Restaurante Fast-food", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual, valMedioFaturacaoMesaDia, numDiasFuncionamentoAno, numMesasInteriores);
        this.numMedioDiarioClientesDriveThru = numMedioDiarioClientesDriveThru;
        this.valMedioFaturacaoClienteDriveThru = valMedioFaturacaoClienteDriveThru;
    }

    /**
     * Metodo para obter o numero medio diario de clientes drive-thru
     * @return double com o numero medio diario de clientes drive-thru
     */
    public double getNumMedioDiarioClientesDriveThru() {
        return numMedioDiarioClientesDriveThru;
    }

    /**
     * Metodo para definir o numero medio diario de clientes drive-thru
     * @param numMedioDiarioClientesDriveThru double com o numero medio diario de clientes drive-thru
     */
    public void setNumMedioDiarioClientesDriveThru(double numMedioDiarioClientesDriveThru) {
        this.numMedioDiarioClientesDriveThru = numMedioDiarioClientesDriveThru;
    }

    /**
     * Metodo para obter o valor medio de faturacao por cada cliente drive-thru
     * @return double com o valor medio de faturacao por cada cliente drive-thru
     */
    public double getValMedioFaturacaoClienteDriveThru() {
        return valMedioFaturacaoClienteDriveThru;
    }

    /**
     * Metodo para definir o valor medio de faturacao por cada cliente drive-thru
     * @param valMedioFaturacaoClienteDriveThru double com o valor medio de faturacao por cada cliente drive-thru
     */
    public void setValMedioFaturacaoClienteDriveThru(double valMedioFaturacaoClienteDriveThru) {
        this.valMedioFaturacaoClienteDriveThru = valMedioFaturacaoClienteDriveThru;
    }

    /**
     * Metodo que efetua o calculo da receita anual do restaurante fast-food
     * @return double com o valor da receita anual
     */
    @Override
    public double defReceitaAnual() {
        return (numMesasInteriores * valMedioFaturacaoMesaDia + numMedioDiarioClientesDriveThru * valMedioFaturacaoClienteDriveThru) * numDiasFuncionamentoAno;
    }

    /**
     * Metodo que efetua o calculo do lucro do restaurante fast-food
     * @return <i>True</i> caso o restaurante fast-food obtenha lucro no final do ano, <i>False</i> caso obtenha prejuizo
     */
    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    /**
     * Metodo para converter a classe RestauranteFastFood em String
     * @return String com o numero medio diario de clientes drive-thru
     * e o valor medio de faturação por cliente drive-thru
     */
    @Override
    public String toString() {
        return super.toString() +
                "\t•Número médio diario de clientes drive-thru = " + numMedioDiarioClientesDriveThru + '\n' +
                "\t•Valor médio de faturação por cliente drive-thru = " + valMedioFaturacaoClienteDriveThru + "€\n";
    }

    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return "4," + super.toStringFicheiro() + numMedioDiarioClientesDriveThru + ',' + valMedioFaturacaoClienteDriveThru + '\n';
    }
}