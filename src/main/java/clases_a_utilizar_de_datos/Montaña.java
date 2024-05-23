package clases_a_utilizar_de_datos;

public class Montaña extends Entorno{
    public Montaña(int tiempo_aparicion, int probabilidad, String tipo) {
        super(tiempo_aparicion, probabilidad, tipo);
    }
    public Montaña() {}
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int vidas = individuo.getVidas();
        individuo.setVidas(vidas - 2);
    }
}
