/**
 * Classe para a gestão de uma empresa da área da Restauração
 */
public abstract class Restauracao extends Empresa{
    /**
     * Número de empregados de mesa
     */
    protected int numEmpregadosMesa;
    /**
     * Número médio de clientes por dia
     */
    protected double numMedClientesDiario;
    /**
     * Custo dos empregados de mesa
     */
    protected double custoEmpregadosMesa;
    /**
     * Custo do salário médio anual
     */
    protected double custoSalarioMedioAnual;

    /**
     * Construtor default para a classe Restauracao
     */
    public Restauracao(){}

    /**
     * Construtor para a classe Restauracao
     * @param categoria String com categoria da empresa (Mercearia/Restauração)
     * @param nome String com o nome da empresa
     * @param distrito String com o distrito onde a empresa está localizada
     * @param localizacao Objeto GPS com as coordenadas da localização da empresa
     * @param numEmpregadosMesa numero de empregados de mesa que trabalham na empresa
     * @param numMedClientesDiario numero de clientes que frequentam a empresa diariamente
     * @param custoEmpregadosMesa despesa da empresa associada aos custos dos empregados de mesa
     * @param custoSalarioMedioAnual despesa da empresa associada aos salarios medios anuais dos empregados de mesa
     */
    public Restauracao(String categoria, String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual) {
        super(categoria, nome, distrito, localizacao);
        this.numEmpregadosMesa = numEmpregadosMesa;
        this.numMedClientesDiario = numMedClientesDiario;
        this.custoEmpregadosMesa = custoEmpregadosMesa;
        this.custoSalarioMedioAnual = custoSalarioMedioAnual;
    }

    /**
     * Metodo para obter o número de empregados de mesa que trabalham na empresa
     * @return int com o número de empregados de mesa que trabalham na empresa
     */
    public int getNumEmpregadosMesa() {
        return numEmpregadosMesa;
    }

    /**
     * Metodo para definir o número de empregados de mesa que trabalham na empresa
     * @param numEmpregadosMesa int com o número de empregados de mesa que trabalham na empresa
     */
    public void setNumEmpregadosMesa(int numEmpregadosMesa) {
        this.numEmpregadosMesa = numEmpregadosMesa;
    }

    /**
     * Metodo para obter o custo dos empregados de mesa
     * @return double com o custo dos empregados de mesa
     */
    public double getCustoEmpregadosMesa() {
        return custoEmpregadosMesa;
    }

    /**
     * Metodo para definir o custo dos empregados de mesa
     * @param custoEmpregadosMesa double com o custo dos empregados de mesa
     */
    public void setCustoEmpregadosMesa(double custoEmpregadosMesa) {
        this.custoEmpregadosMesa = custoEmpregadosMesa;
    }

    /**
     * Metodo para obter o valor do salario medios anual de um empregado de mesa
     * @return double com o valor do salário medio anual de um empregado de mesa
     */
    public double getCustoSalarioMedioAnual() {
        return custoSalarioMedioAnual;
    }

    /**
     * Metodo para definir o valor dos salarios medios anuais dos empregados de mesa
     * @param custoSalarioMedioAnual double com o valor dos salarios medios anuais dos empregados de mesa
     */
    public void setCustoSalarioMedioAnual(double custoSalarioMedioAnual) {
        this.custoSalarioMedioAnual = custoSalarioMedioAnual;
    }

    /**
     * Metodo para obter o numero medio de clientes diario
     * @return double com o numero medio de clientes diario
     */
    public double getNumMedClientesDiario() {
        return numMedClientesDiario;
    }

    /**
     * Metodo para definir o numero medio de clientes diario
     * @param numMedClientesDiario double com o numero medio de clientes diario
     */
    public void setNumMedClientesDiario(double numMedClientesDiario) {
        this.numMedClientesDiario = numMedClientesDiario;
    }

    @Override
    public double defDespesaAnual() {
        return numEmpregadosMesa * custoSalarioMedioAnual;
    }

    @Override
    public double capacidadeRestauracao() {
        return numMedClientesDiario;
    }

    /**
     * Metodo para converter a classe Restauracao em String
     * @return String com o número medio de empregados de mesa, o seu salário mensal e anual.
     */

    @Override
    public String toString() {
        return  super.toString() +
                "\t•Numero medio de clientes por dia = " + numMedClientesDiario + '\n' +
                "\t•Numero de empregados de mesa = " + numEmpregadosMesa + '\n'+
                "\t•Salario mensal de cada empregado de mesa = " + custoEmpregadosMesa + "€\n" +
                "\t•Salario anual de cada empregado de mesa = " + custoSalarioMedioAnual + "€\n";
    }
}