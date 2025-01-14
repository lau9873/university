package p070c.p084d.p105b.p107v;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: c.d.b.v.b  reason: invalid class name */
/* loaded from: classes.dex */
public final class C$Gson$Types {

    /* renamed from: a */
    public static final Type[] f5693a = new Type[0];

    /* compiled from: $Gson$Types.java */
    /* renamed from: c.d.b.v.b$a */
    /* loaded from: classes.dex */
    public static final class C1265a implements GenericArrayType, Serializable {

        /* renamed from: a */
        public final Type f5694a;

        public C1265a(Type type) {
            this.f5694a = C$Gson$Types.m4872b(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.m4876a((Type) this, (Type) ((GenericArrayType) obj));
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f5694a;
        }

        public int hashCode() {
            return this.f5694a.hashCode();
        }

        public String toString() {
            return C$Gson$Types.m4864h(this.f5694a) + "[]";
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: c.d.b.v.b$b */
    /* loaded from: classes.dex */
    public static final class C1266b implements ParameterizedType, Serializable {

        /* renamed from: a */
        public final Type f5695a;

        /* renamed from: b */
        public final Type f5696b;

        /* renamed from: c */
        public final Type[] f5697c;

        public C1266b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                C$Gson$Preconditions.m4885a(z);
            }
            this.f5695a = type == null ? null : C$Gson$Types.m4872b(type);
            this.f5696b = C$Gson$Types.m4872b(type2);
            this.f5697c = (Type[]) typeArr.clone();
            int length = this.f5697c.length;
            for (int i = 0; i < length; i++) {
                C$Gson$Preconditions.m4886a(this.f5697c[i]);
                C$Gson$Types.m4869c(this.f5697c[i]);
                Type[] typeArr2 = this.f5697c;
                typeArr2[i] = C$Gson$Types.m4872b(typeArr2[i]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.m4876a((Type) this, (Type) ((ParameterizedType) obj));
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f5697c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f5695a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f5696b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f5697c) ^ this.f5696b.hashCode()) ^ C$Gson$Types.m4884a((Object) this.f5695a);
        }

        public String toString() {
            int length = this.f5697c.length;
            if (length == 0) {
                return C$Gson$Types.m4864h(this.f5696b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(C$Gson$Types.m4864h(this.f5696b));
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(C$Gson$Types.m4864h(this.f5697c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(C$Gson$Types.m4864h(this.f5697c[i]));
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: c.d.b.v.b$c */
    /* loaded from: classes.dex */
    public static final class C1267c implements WildcardType, Serializable {

        /* renamed from: a */
        public final Type f5698a;

        /* renamed from: b */
        public final Type f5699b;

        public C1267c(Type[] typeArr, Type[] typeArr2) {
            C$Gson$Preconditions.m4885a(typeArr2.length <= 1);
            C$Gson$Preconditions.m4885a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.m4886a(typeArr2[0]);
                C$Gson$Types.m4869c(typeArr2[0]);
                C$Gson$Preconditions.m4885a(typeArr[0] == Object.class);
                this.f5699b = C$Gson$Types.m4872b(typeArr2[0]);
                this.f5698a = Object.class;
                return;
            }
            C$Gson$Preconditions.m4886a(typeArr[0]);
            C$Gson$Types.m4869c(typeArr[0]);
            this.f5699b = null;
            this.f5698a = C$Gson$Types.m4872b(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.m4876a((Type) this, (Type) ((WildcardType) obj));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f5699b;
            return type != null ? new Type[]{type} : C$Gson$Types.f5693a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f5698a};
        }

        public int hashCode() {
            Type type = this.f5699b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f5698a.hashCode() + 31);
        }

        public String toString() {
            if (this.f5699b != null) {
                return "? super " + C$Gson$Types.m4864h(this.f5699b);
            } else if (this.f5698a == Object.class) {
                return "?";
            } else {
                return "? extends " + C$Gson$Types.m4864h(this.f5698a);
            }
        }
    }

    /* renamed from: a */
    public static ParameterizedType m4875a(Type type, Type type2, Type... typeArr) {
        return new C1266b(type, type2, typeArr);
    }

    /* renamed from: b */
    public static Type m4872b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C1265a(m4872b(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C1266b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C1265a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return new C1267c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
            return type;
        }
    }

    /* renamed from: c */
    public static void m4869c(Type type) {
        C$Gson$Preconditions.m4885a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    /* renamed from: d */
    public static Type m4868d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    /* renamed from: e */
    public static Class<?> m4867e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.m4885a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m4867e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return m4867e(((WildcardType) type).getUpperBounds()[0]);
            }
            String name = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
        }
    }

    /* renamed from: f */
    public static WildcardType m4866f(Type type) {
        return new C1267c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f5693a);
    }

    /* renamed from: g */
    public static WildcardType m4865g(Type type) {
        return new C1267c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    /* renamed from: h */
    public static String m4864h(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: a */
    public static GenericArrayType m4882a(Type type) {
        return new C1265a(type);
    }

    /* renamed from: a */
    public static boolean m4883a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static boolean m4876a(Type type, Type type2) {
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
                return m4883a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m4876a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
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
    public static Type m4870b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        C$Gson$Preconditions.m4885a(cls2.isAssignableFrom(cls));
        return m4879a(type, cls, m4880a(type, cls, cls2));
    }

    /* renamed from: b */
    public static Type[] m4871b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type m4870b = m4870b(type, cls, Map.class);
        return m4870b instanceof ParameterizedType ? ((ParameterizedType) m4870b).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    /* renamed from: a */
    public static int m4884a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: a */
    public static Type m4880a(Type type, Class<?> cls, Class<?> cls2) {
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
                    return m4880a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
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
                    return m4880a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: a */
    public static Type m4881a(Type type, Class<?> cls) {
        Type m4870b = m4870b(type, cls, Collection.class);
        if (m4870b instanceof WildcardType) {
            m4870b = ((WildcardType) m4870b).getUpperBounds()[0];
        }
        if (m4870b instanceof ParameterizedType) {
            return ((ParameterizedType) m4870b).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    /* renamed from: a */
    public static Type m4879a(Type type, Class<?> cls, Type type2) {
        return m4878a(type, cls, type2, new HashSet());
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type m4878a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable> r11) {
        /*
        L0:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L18
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto Le
            return r10
        Le:
            r11.add(r0)
            java.lang.reflect.Type r10 = m4877a(r8, r9, r0)
            if (r10 != r0) goto L0
            return r10
        L18:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L35
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L35
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = m4878a(r8, r9, r10, r11)
            if (r10 != r8) goto L30
            goto L34
        L30:
            java.lang.reflect.GenericArrayType r0 = m4882a(r8)
        L34:
            return r0
        L35:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L4b
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = m4878a(r8, r9, r0, r11)
            if (r0 != r8) goto L46
            goto L4a
        L46:
            java.lang.reflect.GenericArrayType r10 = m4882a(r8)
        L4a:
            return r10
        L4b:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8b
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = m4878a(r8, r9, r0, r11)
            if (r3 == r0) goto L5f
            r0 = 1
            goto L60
        L5f:
            r0 = 0
        L60:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L65:
            if (r2 >= r5) goto L80
            r6 = r4[r2]
            java.lang.reflect.Type r6 = m4878a(r8, r9, r6, r11)
            r7 = r4[r2]
            if (r6 == r7) goto L7d
            if (r0 != 0) goto L7b
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L7b:
            r4[r2] = r6
        L7d:
            int r2 = r2 + 1
            goto L65
        L80:
            if (r0 == 0) goto L8a
            java.lang.reflect.Type r8 = r10.getRawType()
            java.lang.reflect.ParameterizedType r10 = m4875a(r3, r8, r4)
        L8a:
            return r10
        L8b:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto Lbd
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto Lab
            r1 = r0[r2]
            java.lang.reflect.Type r8 = m4878a(r8, r9, r1, r11)
            r9 = r0[r2]
            if (r8 == r9) goto Lbd
            java.lang.reflect.WildcardType r8 = m4865g(r8)
            return r8
        Lab:
            int r0 = r3.length
            if (r0 != r1) goto Lbd
            r0 = r3[r2]
            java.lang.reflect.Type r8 = m4878a(r8, r9, r0, r11)     // Catch: java.lang.Throwable -> Lbe
            r9 = r3[r2]
            if (r8 == r9) goto Lbd
            java.lang.reflect.WildcardType r8 = m4866f(r8)
            return r8
        Lbd:
            return r10
        Lbe:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p107v.C$Gson$Types.m4878a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }

    /* renamed from: a */
    public static Type m4877a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> m4874a = m4874a(typeVariable);
        if (m4874a == null) {
            return typeVariable;
        }
        Type m4880a = m4880a(type, cls, m4874a);
        if (m4880a instanceof ParameterizedType) {
            return ((ParameterizedType) m4880a).getActualTypeArguments()[m4873a((Object[]) m4874a.getTypeParameters(), (Object) typeVariable)];
        }
        return typeVariable;
    }

    /* renamed from: a */
    public static int m4873a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public static Class<?> m4874a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }
}
