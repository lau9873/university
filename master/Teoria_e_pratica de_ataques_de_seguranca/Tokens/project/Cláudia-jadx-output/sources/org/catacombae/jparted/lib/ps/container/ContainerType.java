package org.catacombae.jparted.lib.ps.container;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.catacombae.jparted.lib.ps.container.hfs.HFSContainerHandlerFactory;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/container/ContainerType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/container/ContainerType.class */
public enum ContainerType {
    NT_OS2_IFS,
    APPLE_HFS(HFSContainerHandlerFactory.class),
    APPLE_UNIX_SVR2,
    LINUX_NATIVE;
    
    private LinkedList<Class<? extends ContainerHandlerFactory>> factoryClasses = new LinkedList<>();

    ContainerType() {
    }

    ContainerType(Class cls) {
        this.factoryClasses.addLast(cls);
    }

    public void addFactoryClass(Class<? extends ContainerHandlerFactory> factoryClass) {
        this.factoryClasses.addLast(factoryClass);
    }

    public List<Class<? extends ContainerHandlerFactory>> getFactoryClasses() {
        return new ArrayList(this.factoryClasses);
    }

    public ContainerHandlerFactory createDefaultHandlerFactory() {
        if (this.factoryClasses.size() == 0) {
            return null;
        }
        Class<? extends ContainerHandlerFactory> factoryClass = this.factoryClasses.getFirst();
        return createHandlerFactory(factoryClass);
    }

    public static ContainerHandlerFactory createHandlerFactory(Class<? extends ContainerHandlerFactory> factoryClass) {
        try {
            Constructor<? extends ContainerHandlerFactory> c2 = factoryClass.getConstructor(new Class[0]);
            return c2.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
