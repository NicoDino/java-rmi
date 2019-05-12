import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PrediccionClima {

    // Clase singleton provee predicciones random
    private static PrediccionClima single_instance = null;
    private String[] predicciones = { "Llueve", "Nubes", "Soleado", "Tormenta", "Tornado", "Terremoto ", "Seco",
            "Viento" };
    private DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy");
    private DateFormat df2 = new SimpleDateFormat("dd-mm-yyyy");

    private PrediccionClima() {
    }

    public static PrediccionClima getInstance() {
        if (single_instance == null) {
            single_instance = new PrediccionClima();
        }
        return single_instance;
    }

    public String getPrediccion(String fecha) {
        // try {
        // df1.parse(fecha);
        // } catch (ParseException e1) {
        // try {
        // df2.parse(fecha);
        // } catch (ParseException e2) {
        // return "Fecha inválida, utilice el formato <dd/mm/yyyy> o <dd-mm-yyyy>";
        // }
        // }

        Random rand = new Random();
        int indiceRandom = rand.nextInt(7);
        return predicciones[indiceRandom];
    }

}
