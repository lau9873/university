package p070c.p084d.p105b.p106u;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: c.d.b.u.a */
/* loaded from: classes.dex */
public @interface Expose {
    boolean deserialize() default true;

    boolean serialize() default true;
}