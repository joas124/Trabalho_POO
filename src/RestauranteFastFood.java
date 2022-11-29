public class RestauranteFastFood extends Restaurante {
    private double numMedioDiarioClientesDriveThru;
    private double valMedioFaturacaoClienteDriveThru;

    public RestauranteFastFood(){}

    public RestauranteFastFood(String nome, String distrito, GPS localizacao, int numEmpregadosMesa, double numMedClientesDiario, double custoEmpregadosMesa, double custoSalarioMedioAnual, double valMedioFaturacaoMesaDia, int numDiasFuncionamentoAno, int numMesasInteriores, double numMedioDiarioClientesDriveThru, double valMedioFaturacaoClienteDriveThru) {
        super("Restaurante Fast-food", nome, distrito, localizacao, numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual, valMedioFaturacaoMesaDia, numDiasFuncionamentoAno, numMesasInteriores);
        this.numMedioDiarioClientesDriveThru = numMedioDiarioClientesDriveThru;
        this.valMedioFaturacaoClienteDriveThru = valMedioFaturacaoClienteDriveThru;
    }

    public double getNumMedioDiarioClientesDriveThru() {
        return numMedioDiarioClientesDriveThru;
    }

    public void setNumMedioDiarioClientesDriveThru(double numMedioDiarioClientesDriveThru) {
        this.numMedioDiarioClientesDriveThru = numMedioDiarioClientesDriveThru;
    }

    public double getValMedioFaturacaoClienteDriveThru() {
        return valMedioFaturacaoClienteDriveThru;
    }

    public void setValMedioFaturacaoClienteDriveThru(double valMedioFaturacaoClienteDriveThru) {
        this.valMedioFaturacaoClienteDriveThru = valMedioFaturacaoClienteDriveThru;
    }

    @Override
    public double defReceitaAnual() {
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