package clases_a_utilizar_de_datos;

public class Comida extends Entorno{
    public Comida(int tiempo_aparicion, int v) {
        super(tiempo_aparicion, v);
    }
    public Comida() {}
    private void probabilidad() {
        setV(10);
    }
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int vidas = individuo.getVidas();
        individuo.setVidas(vidas + 10);
    }
}
