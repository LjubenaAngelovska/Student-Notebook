package mk.ukim.finki.vpproekt.bootstrap;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataHolder {

    @PostConstruct
    public void init() {

    }
}
