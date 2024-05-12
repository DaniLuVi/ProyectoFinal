package clases_a_utilizar_de_datos;

public class Comida extends Entorno{
    public Comida(int tiempo_aparicion, int probabilidad) {
        super(tiempo_aparicion, probabilidad);
    }
    public Comida() {}
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int vidas = individuo.getVidas();
        individuo.setVidas(vidas + 10);
    }
}
