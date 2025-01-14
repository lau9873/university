package org.catacombae.jparted.lib.fs;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.catacombae.jparted.lib.fs.hfs.HFSFileSystemHandlerFactory;
import org.catacombae.jparted.lib.fs.hfsplus.HFSPlusFileSystemHandlerFactory;
import org.catacombae.jparted.lib.fs.hfsx.HFSXFileSystemHandlerFactory;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemMajorType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemMajorType.class */
public enum FileSystemMajorType {
    APPLE_MFS,
    APPLE_HFS(HFSFileSystemHandlerFactory.class),
    APPLE_HFS_PLUS(HFSPlusFileSystemHandlerFactory.class),
    APPLE_HFSX(HFSXFileSystemHandlerFactory.class),
    APPLE_UFS,
    APPLE_PRODOS,
    FAT12,
    FAT16,
    FAT32,
    EXFAT,
    NTFS,
    HPFS,
    EXT3,
    REISERFS,
    REISER4,
    XFS,
    JFS,
    ZFS,
    UNKNOWN;
    
    private final LinkedList<Class<? extends FileSystemHandlerFactory>> factoryClasses = new LinkedList<>();

    FileSystemMajorType() {
    }

    FileSystemMajorType(Class cls) {
        this.factoryClasses.add(cls);
    }

    public void addFactoryClass(Class<? extends FileSystemHandlerFactory> factoryClass) {
        this.factoryClasses.addLast(factoryClass);
    }

    public List<Class<? extends FileSystemHandlerFactory>> getFactoryClasses() {
        return new ArrayList(this.factoryClasses);
    }

    public FileSystemHandlerFactory createDefaultHandlerFactory() {
        if (this.factoryClasses.size() == 0) {
            return null;
        }
        Class<? extends FileSystemHandlerFactory> factoryClass = this.factoryClasses.getFirst();
        return createHandlerFactory(factoryClass);
    }

    public static FileSystemHandlerFactory createHandlerFactory(Class<? extends FileSystemHandlerFactory> factoryClass) {
        try {
            Constructor<? extends FileSystemHandlerFactory> c2 = factoryClass.getConstructor(new Class[0]);
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
