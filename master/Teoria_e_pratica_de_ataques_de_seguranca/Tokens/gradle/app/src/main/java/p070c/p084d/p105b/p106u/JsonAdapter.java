package p070c.p084d.p105b.p106u;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: c.d.b.u.b */
/* loaded from: classes.dex */
public @interface JsonAdapter {
    boolean nullSafe() default true;

    Class<?> value();
}
