public class RestauranteFastFood extends Restaurante {
    private float numMedioDiarioClientesDriveThru, valMedioFaturacaoClienteDriveThru;

    public RestauranteFastFood(){}

    public RestauranteFastFood(int numEmpregadosMesa, float custoEmpregadosMesa, float numMedClientesDiario, float valMedioFaturacaoMesa, int numDiasFuncionamentoAno, int numMesasInteriores, float numMedioDiarioClientesDriveThru, float valMedioFaturacaoClienteDriveThru) {
        super(numEmpregadosMesa, custoEmpregadosMesa, numMedClientesDiario, valMedioFaturacaoMesa, numDiasFuncionamentoAno, numMesasInteriores);
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
    public String toString() {
        return "RestauranteFastFood{" +
                "numMedioDiarioClientesDriveThru=" + numMedioDiarioClientesDriveThru +
                ", valMedioFaturacaoClienteDriveThru=" + valMedioFaturacaoClienteDriveThru +
                '}';
    }
}
