package i;

import com.j256.ormlite.stmt.query.SimpleComparison;
import e.e0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final Type[] f7526a = new Type[0];

    /* compiled from: Utils.java */
    /* loaded from: classes.dex */
    public static final class a implements GenericArrayType {

        /* renamed from: a  reason: collision with root package name */
        public final Type f7527a;

        public a(Type type) {
            this.f7527a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && o.a((Type) this, (Type) ((GenericArrayType) obj));
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f7527a;
        }

        public int hashCode() {
            return this.f7527a.hashCode();
        }

        public String toString() {
            return o.e(this.f7527a) + "[]";
        }
    }

    /* compiled from: Utils.java */
    /* loaded from: classes.dex */
    public static final class b implements ParameterizedType {

        /* renamed from: a  reason: collision with root package name */
        public final Type f7528a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f7529b;

        /* renamed from: c  reason: collision with root package name */
        public final Type[] f7530c;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                o.a(type3, "typeArgument == null");
                o.a(type3);
            }
            this.f7528a = type;
            this.f7529b = type2;
            this.f7530c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && o.a((Type) this, (Type) ((ParameterizedType) obj));
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f7530c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f7528a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f7529b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f7530c) ^ this.f7529b.hashCode()) ^ o.a((Object) this.f7528a);
        }

        public String toString() {
            Type[] typeArr = this.f7530c;
            if (typeArr.length == 0) {
                return o.e(this.f7529b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(o.e(this.f7529b));
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(o.e(this.f7530c[0]));
            for (int i2 = 1; i2 < this.f7530c.length; i2++) {
                sb.append(", ");
                sb.append(o.e(this.f7530c[i2]));
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* compiled from: Utils.java */
    /* loaded from: classes.dex */
    public static final class c implements WildcardType {

        /* renamed from: a  reason: collision with root package name */
        public final Type f7531a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f7532b;

        public c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        if (typeArr2[0] != null) {
                            o.a(typeArr2[0]);
                            if (typeArr[0] == Object.class) {
                                this.f7532b = typeArr2[0];
                                this.f7531a = Object.class;
                                return;
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new NullPointerException();
                    } else if (typeArr[0] != null) {
                        o.a(typeArr[0]);
                        this.f7532b = null;
                        this.f7531a = typeArr[0];
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
            return (obj instanceof WildcardType) && o.a((Type) this, (Type) ((WildcardType) obj));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f7532b;
            return type != null ? new Type[]{type} : o.f7526a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f7531a};
        }

        public int hashCode() {
            Type type = this.f7532b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f7531a.hashCode() + 31);
        }

        public String toString() {
            if (this.f7532b != null) {
                return "? super " + o.e(this.f7532b);
            } else if (this.f7531a == Object.class) {
                return "?";
            } else {
                return "? extends " + o.e(this.f7531a);
            }
        }
    }

    public static boolean a(Type type, Type type2) {
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
                return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
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

    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return a(type, cls, a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    public static Class<?> c(Type type) {
        a(type, "type == null");
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
            return Array.newInstance(c(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return c(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    public static boolean d(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (d(type2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    public static String e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type b(Type type) {
        if (type instanceof ParameterizedType) {
            return a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces[i2])) {
                    return a(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
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
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static int a(Object[] objArr, Object obj) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
        L0:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto Lf
            java.lang.reflect.TypeVariable r10 = (java.lang.reflect.TypeVariable) r10
            java.lang.reflect.Type r0 = a(r8, r9, r10)
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
            java.lang.reflect.Type r8 = a(r8, r9, r10)
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
            java.lang.reflect.Type r8 = a(r8, r9, r0)
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
            java.lang.reflect.Type r3 = a(r8, r9, r0)
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
            java.lang.reflect.Type r6 = a(r8, r9, r6)
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
            java.lang.reflect.Type r8 = a(r8, r9, r3)
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
            java.lang.reflect.Type r8 = a(r8, r9, r0)     // Catch: java.lang.Throwable -> Lcc
            r9 = r3[r2]
            if (r8 == r9) goto Lcb
            i.o$c r9 = new i.o$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r1]
            r10[r2] = r8
            java.lang.reflect.Type[] r8 = i.o.f7526a
            r9.<init>(r10, r8)
            return r9
        Lcb:
            return r10
        Lcc:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i.o.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a2 = a(typeVariable);
        if (a2 == null) {
            return typeVariable;
        }
        Type a3 = a(type, cls, a2);
        if (a3 instanceof ParameterizedType) {
            return ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)];
        }
        return typeVariable;
    }

    public static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static void a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static e0 a(e0 e0Var) {
        f.c cVar = new f.c();
        e0Var.n().a(cVar);
        return e0.a(e0Var.m(), e0Var.l(), cVar);
    }

    public static <T> void a(Class<T> cls) {
        if (cls.isInterface()) {
            if (cls.getInterfaces().length > 0) {
                throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public static Type a(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 >= 0 && i2 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i2];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i2 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }
}
