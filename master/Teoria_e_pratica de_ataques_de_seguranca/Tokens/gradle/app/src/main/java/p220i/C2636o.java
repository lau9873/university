package p220i;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import p181e.ResponseBody;
import p192f.Buffer;

/* compiled from: Utils.java */
/* renamed from: i.o */
/* loaded from: classes.dex */
public final class C2636o {

    /* renamed from: a */
    public static final Type[] f10501a = new Type[0];

    /* compiled from: Utils.java */
    /* renamed from: i.o$a */
    /* loaded from: classes.dex */
    public static final class C2637a implements GenericArrayType {

        /* renamed from: a */
        public final Type f10502a;

        public C2637a(Type type) {
            this.f10502a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C2636o.m590a((Type) this, (Type) ((GenericArrayType) obj));
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f10502a;
        }

        public int hashCode() {
            return this.f10502a.hashCode();
        }

        public String toString() {
            return C2636o.m582e(this.f10502a) + "[]";
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: i.o$b */
    /* loaded from: classes.dex */
    public static final class C2638b implements ParameterizedType {

        /* renamed from: a */
        public final Type f10503a;

        /* renamed from: b */
        public final Type f10504b;

        /* renamed from: c */
        public final Type[] f10505c;

        public C2638b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                C2636o.m595a(type3, "typeArgument == null");
                C2636o.m594a(type3);
            }
            this.f10503a = type;
            this.f10504b = type2;
            this.f10505c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C2636o.m590a((Type) this, (Type) ((ParameterizedType) obj));
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f10505c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f10503a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f10504b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f10505c) ^ this.f10504b.hashCode()) ^ C2636o.m597a((Object) this.f10503a);
        }

        public String toString() {
            Type[] typeArr = this.f10505c;
            if (typeArr.length == 0) {
                return C2636o.m582e(this.f10504b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(C2636o.m582e(this.f10504b));
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(C2636o.m582e(this.f10505c[0]));
            for (int i = 1; i < this.f10505c.length; i++) {
                sb.append(", ");
                sb.append(C2636o.m582e(this.f10505c[i]));
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: i.o$c */
    /* loaded from: classes.dex */
    public static final class C2639c implements WildcardType {

        /* renamed from: a */
        public final Type f10506a;

        /* renamed from: b */
        public final Type f10507b;

        public C2639c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        if (typeArr2[0] != null) {
                            C2636o.m594a(typeArr2[0]);
                            if (typeArr[0] == Object.class) {
                                this.f10507b = typeArr2[0];
                                this.f10506a = Object.class;
                                return;
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new NullPointerException();
                    } else if (typeArr[0] != null) {
                        C2636o.m594a(typeArr[0]);
                        this.f10507b = null;
                        this.f10506a = typeArr[0];
                        return;
                    } else {
                        throw new NullPointerException();
                    }
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C2636o.m590a((Type) this, (Type) ((WildcardType) obj));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f10507b;
            return type != null ? new Type[]{type} : C2636o.f10501a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f10506a};
        }

        public int hashCode() {
            Type type = this.f10507b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f10506a.hashCode() + 31);
        }

        public String toString() {
            if (this.f10507b != null) {
                return "? super " + C2636o.m582e(this.f10507b);
            } else if (this.f10506a == Object.class) {
                return "?";
            } else {
                return "? extends " + C2636o.m582e(this.f10506a);
            }
        }
    }

    /* renamed from: a */
    public static boolean m590a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                return m596a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m590a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public static Type m585b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m592a(type, cls, m593a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    public static Class<?> m584c(Type type) {
        m595a(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m584c(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return m584c(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    /* renamed from: d */
    public static boolean m583d(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (m583d(type2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return m583d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    /* renamed from: e */
    public static String m582e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: b */
    public static Type m586b(Type type) {
        if (type instanceof ParameterizedType) {
            return m600a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    /* renamed from: a */
    public static Type m593a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return m593a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m593a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: a */
    public static int m588a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public static boolean m596a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m597a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type m592a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
        L0:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto Lf
            java.lang.reflect.TypeVariable r10 = (java.lang.reflect.TypeVariable) r10
            java.lang.reflect.Type r0 = m591a(r8, r9, r10)
            if (r0 != r10) goto Ld
            return r0
        Ld:
            r10 = r0
            goto L0
        Lf:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L2d
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L2d
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = m592a(r8, r9, r10)
            if (r10 != r8) goto L27
            goto L2c
        L27:
            i.o$a r0 = new i.o$a
            r0.<init>(r8)
        L2c:
            return r0
        L2d:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L44
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = m592a(r8, r9, r0)
            if (r0 != r8) goto L3e
            goto L43
        L3e:
            i.o$a r10 = new i.o$a
            r10.<init>(r8)
        L43:
            return r10
        L44:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L87
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = m592a(r8, r9, r0)
            if (r3 == r0) goto L58
            r0 = 1
            goto L59
        L58:
            r0 = 0
        L59:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L5e:
            if (r2 >= r5) goto L79
            r6 = r4[r2]
            java.lang.reflect.Type r6 = m592a(r8, r9, r6)
            r7 = r4[r2]
            if (r6 == r7) goto L76
            if (r0 != 0) goto L74
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L74:
            r4[r2] = r6
        L76:
            int r2 = r2 + 1
            goto L5e
        L79:
            if (r0 == 0) goto L85
            i.o$b r8 = new i.o$b
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            goto L86
        L85:
            r8 = r10
        L86:
            return r8
        L87:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto Lcb
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto Lb2
            r3 = r0[r2]
            java.lang.reflect.Type r8 = m592a(r8, r9, r3)
            r9 = r0[r2]
            if (r8 == r9) goto Lcb
            i.o$c r9 = new i.o$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r1]
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r10[r2] = r0
            java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r1]
            r0[r2] = r8
            r9.<init>(r10, r0)
            return r9
        Lb2:
            int r0 = r3.length
            if (r0 != r1) goto Lcb
            r0 = r3[r2]
            java.lang.reflect.Type r8 = m592a(r8, r9, r0)     // Catch: java.lang.Throwable -> Lcc
            r9 = r3[r2]
            if (r8 == r9) goto Lcb
            i.o$c r9 = new i.o$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r1]
            r10[r2] = r8
            java.lang.reflect.Type[] r8 = p220i.C2636o.f10501a
            r9.<init>(r10, r8)
            return r9
        Lcb:
            return r10
        Lcc:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p220i.C2636o.m592a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    /* renamed from: a */
    public static Type m591a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> m589a = m589a(typeVariable);
        if (m589a == null) {
            return typeVariable;
        }
        Type m593a = m593a(type, cls, m589a);
        if (m593a instanceof ParameterizedType) {
            return ((ParameterizedType) m593a).getActualTypeArguments()[m588a((Object[]) m589a.getTypeParameters(), (Object) typeVariable)];
        }
        return typeVariable;
    }

    /* renamed from: a */
    public static Class<?> m589a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* renamed from: a */
    public static void m594a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static <T> T m595a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m587a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static ResponseBody m599a(ResponseBody responseBody) {
        Buffer buffer = new Buffer();
        responseBody.mo670n().mo2563a(buffer);
        return ResponseBody.m3195a(responseBody.mo671m(), responseBody.mo672l(), buffer);
    }

    /* renamed from: a */
    public static <T> void m598a(Class<T> cls) {
        if (cls.isInterface()) {
            if (cls.getInterfaces().length > 0) {
                throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    /* renamed from: a */
    public static Type m600a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i >= 0 && i < actualTypeArguments.length) {
            Type type = actualTypeArguments[i];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }
}
