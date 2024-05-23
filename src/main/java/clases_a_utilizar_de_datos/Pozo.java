package clases_a_utilizar_de_datos;

public class Pozo extends Entorno{
    public Pozo(int tiempo_aparicion, int probabilidad, String tipo) {
        super(tiempo_aparicion, probabilidad, tipo);
    }
    public Pozo() {}
    @Override
    public void modificarIndividuo(Individuo individuo) {
        individuo.setVidas(0);
    }
}
