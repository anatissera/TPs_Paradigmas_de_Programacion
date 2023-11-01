package linea;

import java.util.List;

public class InitializeTriunfo {
    static public Triunfo createTriunfo(char varianteTriunfo) {
        return List.of(
            new TriunfoA(),
            new TriunfoB(),
            new TriunfoC()
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Variante de triunfo no válida"));
    }
}