package p000a.p001a.p005b;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000a.p001a.p005b.Lifecycle;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: a.a.b.l */
/* loaded from: classes.dex */
public @interface OnLifecycleEvent {
    Lifecycle.EnumC0011a value();
}
