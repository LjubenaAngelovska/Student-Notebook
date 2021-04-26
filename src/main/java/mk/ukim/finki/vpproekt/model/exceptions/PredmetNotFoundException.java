package mk.ukim.finki.vpproekt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PredmetNotFoundException extends RuntimeException {

    public PredmetNotFoundException(String ime) {
        super(String.format("Ne postoi predmet so ime: %s", ime));
    }
}
