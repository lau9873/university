package p220i;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p220i.CallAdapter;

/* renamed from: i.f */
/* loaded from: classes.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.AbstractC2601a {

    /* renamed from: a */
    public static final CallAdapter.AbstractC2601a f10380a = new DefaultCallAdapterFactory();

    /* compiled from: DefaultCallAdapterFactory.java */
    /* renamed from: i.f$a */
    /* loaded from: classes.dex */
    public class C2604a implements CallAdapter<Object, InterfaceC2600b<?>> {

        /* renamed from: a */
        public final /* synthetic */ Type f10381a;

        public C2604a(DefaultCallAdapterFactory defaultCallAdapterFactory, Type type) {
            this.f10381a = type;
        }

        @Override // p220i.CallAdapter
        /* renamed from: a */
        public InterfaceC2600b<?> mo567a(InterfaceC2600b<Object> interfaceC2600b) {
            return interfaceC2600b;
        }

        @Override // p220i.CallAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ InterfaceC2600b<?> mo567a(InterfaceC2600b<Object> interfaceC2600b) {
            mo567a(interfaceC2600b);
            return interfaceC2600b;
        }

        @Override // p220i.CallAdapter
        /* renamed from: a */
        public Type mo568a() {
            return this.f10381a;
        }
    }

    @Override // p220i.CallAdapter.AbstractC2601a
    /* renamed from: a */
    public CallAdapter<?, ?> mo565a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.AbstractC2601a.m685a(type) != InterfaceC2600b.class) {
            return null;
        }
        return new C2604a(this, C2636o.m586b(type));
    }
}
