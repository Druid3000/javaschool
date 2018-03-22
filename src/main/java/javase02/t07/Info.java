package javase02.t07;

import java.lang.annotation.*;

@Documented
public @interface Info {
    String author();
    String date();
}
