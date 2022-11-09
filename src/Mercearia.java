public abstract class Mercearia extends Empresa{
    protected float custoAnualLimpezaEstabelecimento;

    public Mercearia(){}

    public Mercearia(String categoria, String nome, String distrito, GPS localizacao, float custoAnualLimpezaEstabelecimento) {
        super(categoria, nome, distrito, localizacao);
        this.custoAnualLimpezaEstabelecimento = custoAnualLimpezaEstabelecimento;
    }

    public float getCustoAnualLimpezaEstabelecimento(){
        return custoAnualLimpezaEstabelecimento;
    }

    public void setCustoAnualLimpezaEstabelecimento(float custoAnualLimpezaEstabelecimento) {
        this.custoAnualLimpezaEstabelecimento = custoAnualLimpezaEstabelecimento;
    }

    @Override
    public float defDespesaAnual() {
        return custoAnualLimpezaEstabelecimento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t•Custo anual de limpeza do estabelecimento = " + custoAnualLimpezaEstabelecimento + "€\n";
    }
}
