public class Empresa {
    protected String categoria;
    protected String nome;
    protected String destrito;
    protected GPS localizacao;

    public Empresa(){}

    public Empresa(String categoria, String nome, String destrito, GPS localizacao) {
        this.categoria = categoria;
        this.nome = nome;
        this.destrito = destrito;
        this.localizacao = localizacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestrito() {
        return destrito;
    }

    public void setDestrito(String destrito) {
        this.destrito = destrito;
    }

    public GPS getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(GPS localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", destrito='" + destrito + '\'' +
                ", localizacao=" + localizacao +
                '}';
    }
}
