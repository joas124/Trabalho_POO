public class RestauranteLocal extends Restaurante {
    private int numMesasEsplanada;
    private float custoLicencaAnualMesaEsplanada;

    public RestauranteLocal(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, float numMedClientesDiario, float custoEmpregadosMesa, float custoSalarioMedioAnual, float valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores, int numMesasEsplanada, float custoLicencaAnualMesaEsplanada) {
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

    public float getCustoLicencaAnualMesaEsplanada() {
        return custoLicencaAnualMesaEsplanada;
    }

    public void setCustoLicencaAnualMesaEsplanada(float custoLicencaAnualMesaEsplanada) {
        this.custoLicencaAnualMesaEsplanada = custoLicencaAnualMesaEsplanada;
    }

    @Override
    public float defDespesaAnual() {
        return (numEmpregadosMesa * custoSalarioMedioAnual) + (numMesasEsplanada * custoLicencaAnualMesaEsplanada);
    }

    @Override
    public float defReceitaAnual() {
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

    @Override
    public String toStringFicheiro() {
        return '3' + super.toStringFicheiro() + numMesasEsplanada + ',' + custoLicencaAnualMesaEsplanada;
    }
}
