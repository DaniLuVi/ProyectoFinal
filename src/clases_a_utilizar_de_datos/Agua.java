package clases_a_utilizar_de_datos;

public class Agua extends Entorno{

    public Agua(int tiempo_aparicion, int v) {
        super(tiempo_aparicion, v);
    }
    private void probabilidad() {
        setV(30);
    }
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int vidas = individuo.getVidas();
        individuo.setVidas(vidas + 2);
    }
}
