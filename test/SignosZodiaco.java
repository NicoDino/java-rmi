import java.util.Random;

public class SignosZodiaco {

    // Clase singleton provee signos de forma random

    private static SignosZodiaco single_instance = null;

    private final String[] arraySignos = { "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio",
            "Sagitario", "Capricornio", "Acuario", "Piscis" };

    private SignosZodiaco() {
    }

    public static SignosZodiaco getInstance() {
        if (single_instance == null) {
            single_instance = new SignosZodiaco();
        }
        return single_instance;
    }

    public String getSigno() {
        Random rand = new Random();
        // Generamos un numero aleatorio entre [0 - 11].
        int indiceRandom = rand.nextInt(10);
        return this.arraySignos[indiceRandom];
    }
}
