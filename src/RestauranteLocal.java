public class RestauranteLocal extends Restaurante {
    protected int numMesasInteriores, numMesasEsplanada;
    protected float custoLicencaAnualMesaEsplanada, valorMedioFaturacaoMesaDia;

    public RestauranteLocal(int numEmpregadosMesa, float custoEmpregadosMesa, float numMedClientesDiario, float valMedioFaturacaoMesa, int numDiasFuncionamentoAno, int numMesasInteriores, int numMesasInteriores1, int numMesasEsplanada, float custoLicencaAnualMesaEsplanada, float valorMedioFaturacaoMesaDia) {
        super(numEmpregadosMesa, custoEmpregadosMesa, numMedClientesDiario, valMedioFaturacaoMesa, numDiasFuncionamentoAno, numMesasInteriores);
        this.numMesasInteriores = numMesasInteriores1;
        this.numMesasEsplanada = numMesasEsplanada;
        this.custoLicencaAnualMesaEsplanada = custoLicencaAnualMesaEsplanada;
        this.valorMedioFaturacaoMesaDia = valorMedioFaturacaoMesaDia;
    }
}
