package linea;

import java.util.List;

public class InitializeTriumphVariant {
	
    public static String NonValidStrategyVariant = "Variante de estrategia no válida";

	static public Triumph createTriunfo(char varianteTriunfo) {
        return List.of(
            new TriumphA(),
            new TriumphB(),
            new TriumphC()
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new RuntimeException(NonValidStrategyVariant));
    }
}