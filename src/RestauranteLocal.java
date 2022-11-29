public class RestauranteLocal extends Restaurante {
    private int numMesasEsplanada;
    private double custoLicencaAnualMesaEsplanada;
    public RestauranteLocal(){}

    public RestauranteLocal(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores, int numMesasEsplanada, double custoLicencaAnualMesaEsplanada) {
        super("Restaurante Local", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual, valMedioFaturacaoMesaDia, numDiasFuncionamentoAno, numMesasInteriores);
        this.numMesasEsplanada = numMesasEsplanada;
        this.custoLicencaAnualMesaEsplanada = custoLicencaAnualMesaEsplanada;
    }

    public int getNumMesasEsplanada() {
        return numMesasEsplanada;
    }

    public void setNumMesasEsplanada(int numMesasEsplanada) {
        this.numMesasEsplanada = numMesasEsplanada;
    }

    public double getCustoLicencaAnualMesaEsplanada() {
        return custoLicencaAnualMesaEsplanada;
    }

    public void setCustoLicencaAnualMesaEsplanada(double custoLicencaAnualMesaEsplanada) {
        this.custoLicencaAnualMesaEsplanada = custoLicencaAnualMesaEsplanada;
    }

    @Override
    public double defDespesaAnual() {
        return (numEmpregadosMesa * custoSalarioMedioAnual) + (numMesasEsplanada * custoLicencaAnualMesaEsplanada);
    }

    @Override
    public double defReceitaAnual() {
        return (numMesasInteriores + numMesasEsplanada) * valMedioFaturacaoMesaDia * numDiasFuncionamentoAno;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\t•Numero de mesas da esplanada = " + numMesasEsplanada + "\n" +
                "\t•Custo da licenca anual por mesa da esplanada = " + custoLicencaAnualMesaEsplanada + "€\n";
    }

}
