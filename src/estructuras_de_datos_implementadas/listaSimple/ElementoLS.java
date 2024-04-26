package estructuras_de_datos_implementadas.listaSimple;

public class ElementoLS<TipoDato> {
    private TipoDato data;

    public ElementoLS() {
    }

    public ElementoLS(TipoDato data) {
        this.data = data;
    }

    public TipoDato getData() {
        return data;
    }

    public void setData(TipoDato data) {
        this.data = data;
    }
}

