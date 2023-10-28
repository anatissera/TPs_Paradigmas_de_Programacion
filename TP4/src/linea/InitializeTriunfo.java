package linea;

import java.util.List;

public class InitializeTriunfo {
    static public Triunfo createTriunfo(char varianteTriunfo) {
        return List.of(
            new Triunfo('A'),
            new Triunfo('B'),
            new Triunfo('C')
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Variante de triunfo no válida"));
    }
}
