package clases_a_utilizar_de_datos;

public class Pozo extends Entorno{
    public Pozo(int tiempo_aparicion, int v) {
        super(tiempo_aparicion, v);
    }
    public Pozo() {}
    private void probabilidad() {
        setV(10);
    }
    @Override
    public void modificarIndividuo(Individuo individuo) {
        individuo.setVidas(0);
    }
}
