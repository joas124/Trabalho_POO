/**
 * Classe para a gestao de um restaurante
 */
public abstract class Restaurante extends Restauracao {
    /**
     * Valor medio de faturacao de cada mesa por dia
     */
    protected double valMedioFaturacaoMesaDia;
    /**
     * Numero de dias de funcionamento por ano
     */
    protected int numDiasFuncionamentoAno;
    /**
     * Numero de mesas interiores
     */
    protected int numMesasInteriores;

    /**
     * Construtor default para a classe Restaurante
     */
    public Restaurante(){}

    /**
     * Construtor para a classe Restaurante
     * @param categoria String com categoria do restaurante (Fast food/Local)
     * @param nome String com o nome do restaurante
     * @param distrito String com o distrito onde o restaurante está localizado
     * @param localizacao Objeto GPS com as coordenadas da localização do restaurante
     * @param numEmpregadosMesa numero de empregados de mesa que trabalham no restaurante
     * @param numMedClientesDiario numero medio de clientes que frequentam o restaurante diariamente
     * @param custoEmpregadosMesa despesa do restaurante associada aos custos dos empregados de mesa
     * @param custoSalarioMedioAnual despesa do restaurante associada aos salarios medios anuais dos empregados de mesa
     * @param valMedioFaturacaoMesaDia valor medio de faturacao de cada mesa por dia
     * @param numDiasFuncionamentoAno numero de dias de funcionamento por ano
     * @param numMesasInteriores numero de mesas interiores
     */
    public Restaurante(String categoria, String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores) {
        super(categoria, nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual);
        this.valMedioFaturacaoMesaDia = valMedioFaturacaoMesaDia;
        this.numDiasFuncionamentoAno = numDiasFuncionamentoAno;
        this.numMesasInteriores = numMesasInteriores;
    }

    /**
     * Metodo para obter o valor medio de faturacao de cada mesa por dia
     * @return double com o valor medio de faturacao de cada mesa por dia
     */
    public double getValMedioFaturacaoMesaDia() {
        return valMedioFaturacaoMesaDia;
    }

    /**
     * Metodo para definir o valor medio de faturacao de cada mesa por dia
     * @param valMedioFaturacaoMesa double com o valor medio de faturacao de cada mesa por dia
     */
    public void setValMedioFaturacaoMesaDia(double valMedioFaturacaoMesa) {
        this.valMedioFaturacaoMesaDia = valMedioFaturacaoMesa;
    }

    /**
     * Metodo para obter o numero de dias de funcionamento por ano
     * @return int como o numero de dias de funcionamento por ano
     */
    public int getNumDiasFuncionamentoAno() {
        return numDiasFuncionamentoAno;
    }

    /**
     * Metodo para definir o numero de dias de funcionamento por ano
     * @param numDiasFuncionamentoAno int com o numero de dias de funcionamento por ano
     */
    public void setNumDiasFuncionamentoAno(int numDiasFuncionamentoAno) {
        this.numDiasFuncionamentoAno = numDiasFuncionamentoAno;
    }

    /**
     * Metodo para obter o numero de mesas interiores
     * @return int com o numero de mesas interiores
     */
    public int getNumMesasInteriores() {
        return numMesasInteriores;
    }

    /**
     * Metodo para definir o numero de mesas interiores
     * @param numMesasInteriores int com o numero de mesas interiores
     */
    public void setNumMesasInteriores(int numMesasInteriores) {
        this.numMesasInteriores = numMesasInteriores;
    }

    /**
     * Metodo para converter a classe Restaurante em String
     * @return String com o valor medio de faturacao por mesa, o numero de dias
     * de funcionamento por ano e o numero de mesas interiores de um restaurante
     */
    @Override
    public String toString() {
        return super.toString() +
                "\t•Valor médio de faturação por mesa = " + valMedioFaturacaoMesaDia + "€\n" +
                "\t•Número de dias de funcionamento por ano = " + numDiasFuncionamentoAno + '\n' +
                "\t•Número de mesas interiores = " + numMesasInteriores + '\n';
    }
    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return super.toStringFicheiro() + valMedioFaturacaoMesaDia + ',' + numDiasFuncionamentoAno + ',' +
                numMesasInteriores + ',';
    }
}
