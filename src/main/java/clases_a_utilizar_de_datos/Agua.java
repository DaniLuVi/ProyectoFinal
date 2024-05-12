package clases_a_utilizar_de_datos;

public class Agua extends Entorno{

    public Agua(int tiempo_aparicion, int probabilidad) {
        super(tiempo_aparicion, probabilidad);
    }
    public Agua() {}
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int vidas = individuo.getVidas();
        individuo.setVidas(vidas + 2);
    }
}
