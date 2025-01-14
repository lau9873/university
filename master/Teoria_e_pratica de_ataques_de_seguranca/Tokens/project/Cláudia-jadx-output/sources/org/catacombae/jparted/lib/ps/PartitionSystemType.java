package org.catacombae.jparted.lib.ps;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.catacombae.jparted.lib.ps.apm.APMHandlerFactory;
import org.catacombae.jparted.lib.ps.ebr.EBRHandlerFactory;
import org.catacombae.jparted.lib.ps.gpt.GPTHandlerFactory;
import org.catacombae.jparted.lib.ps.mbr.MBRHandlerFactory;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemType.class */
public enum PartitionSystemType {
    MBR(true, MBRHandlerFactory.class),
    GPT(true, GPTHandlerFactory.class),
    APM(true, APMHandlerFactory.class),
    DOS_EXTENDED(false, EBRHandlerFactory.class);
    
    private final boolean isTopLevelCapable;
    private LinkedList<Class<? extends PartitionSystemHandlerFactory>> factoryClasses;

    PartitionSystemType(boolean pIsTopLevelCapable) {
        this.factoryClasses = new LinkedList<>();
        this.isTopLevelCapable = pIsTopLevelCapable;
    }

    PartitionSystemType(boolean pIsTopLevelCapable, Class cls) {
        this(pIsTopLevelCapable);
        this.factoryClasses.addLast(cls);
    }

    public boolean isTopLevelCapable() {
        return this.isTopLevelCapable;
    }

    public void addFactoryClass(Class<? extends PartitionSystemHandlerFactory> pFactoryClass) {
        this.factoryClasses.addLast(pFactoryClass);
    }

    public List<Class<? extends PartitionSystemHandlerFactory>> getFactoryClasses() {
        return new ArrayList(this.factoryClasses);
    }

    public PartitionSystemHandlerFactory createDefaultHandlerFactory() {
        if (this.factoryClasses.size() == 0) {
            return null;
        }
        Class<? extends PartitionSystemHandlerFactory> factoryClass = this.factoryClasses.getFirst();
        return createHandlerFactory(factoryClass);
    }

    public static PartitionSystemHandlerFactory createHandlerFactory(Class<? extends PartitionSystemHandlerFactory> factoryClass) {
        try {
            Constructor<? extends PartitionSystemHandlerFactory> c2 = factoryClass.getConstructor(new Class[0]);
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
