package linea;

import java.util.List;

public class InitializeTriumphVariant {
    static public Triumph createTriunfo(char varianteTriunfo) {
        return List.of(
            new TriumphA(),
            new TriumphB(),
            new TriumphC()
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Variante de estrategia no válida"));
    }
}