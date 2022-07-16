package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // @Hyoseong 보다 범위가 같거나 커야한다
@Target(ElementType.TYPE_USE) // @Hyoseong 보다 범위가 같거나 커야한다
public @interface HyoseongContainer {
    Hyoseong[] value();
}
