public class RestauranteFastFood extends Restaurante {
    private float numMedioDiarioClientesDriveThru;
    private float valMedioFaturacaoClienteDriveThru;

    public RestauranteFastFood(){}

    public RestauranteFastFood(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, float numMedClientesDiario, float custoEmpregadosMesa, float custoSalarioMedioAnual, float valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores, float numMedioDiarioClientesDriveThru, float valMedioFaturacaoClienteDriveThru) {
        super("Restaurante Fast-food", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual, valMedioFaturacaoMesaDia, numDiasFuncionamentoAno, numMesasInteriores);
        this.numMedioDiarioClientesDriveThru = numMedioDiarioClientesDriveThru;
        this.valMedioFaturacaoClienteDriveThru = valMedioFaturacaoClienteDriveThru;
    }

    public float getNumMedioDiarioClientesDriveThru() {
        return numMedioDiarioClientesDriveThru;
    }

    public void setNumMedioDiarioClientesDriveThru(float numMedioDiarioClientesDriveThru) {
        this.numMedioDiarioClientesDriveThru = numMedioDiarioClientesDriveThru;
    }

    public float getValMedioFaturacaoClienteDriveThru() {
        return valMedioFaturacaoClienteDriveThru;
    }

    public void setValMedioFaturacaoClienteDriveThru(float valMedioFaturacaoClienteDriveThru) {
        this.valMedioFaturacaoClienteDriveThru = valMedioFaturacaoClienteDriveThru;
    }

    @Override
    public float defReceitaAnual() {
        return (numMesasInteriores * valMedioFaturacaoMesaDia + numMedioDiarioClientesDriveThru * valMedioFaturacaoClienteDriveThru) * numDiasFuncionamentoAno;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t•Número médio diario de clientes drive-thru = " + numMedioDiarioClientesDriveThru + '\n' +
                "\t•Valor médio de faturação por cliente drive-thru = " + valMedioFaturacaoClienteDriveThru + "€\n";
    }
}