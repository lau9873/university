package org.catacombae.jparted.lib.fs;

import java.util.LinkedList;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandler.class */
public abstract class FileSystemHandler {
    public abstract FSEntry[] list(String... strArr);

    public abstract FSFolder getRoot();

    public abstract FSEntry getEntry(String... strArr);

    public abstract String parsePosixPathnameComponent(String str);

    public abstract String generatePosixPathnameComponent(String str);

    public abstract String[] getTargetPath(FSLink fSLink, String[] strArr);

    public abstract FSForkType[] getSupportedForkTypes();

    public abstract void close();

    public FSEntry getEntryByPosixPath(String posixPath, String... rootFolderPath) throws IllegalArgumentException {
        String[] path = getTruePathFromPosixPath(posixPath, rootFolderPath);
        if (path != null) {
            FSEntry entry = getEntry(path);
            return entry;
        }
        return null;
    }

    public String[] getTruePathFromPosixPath(String posixPath, String... rootFolderPath) throws IllegalArgumentException {
        FSFolder curFolder;
        String[] components = posixPath.split("/");
        int i2 = 0;
        LinkedList<String> pathStack = new LinkedList<>();
        LinkedList<String[]> visitedLinks = null;
        if (posixPath.startsWith("/")) {
            i2 = 1;
        } else {
            for (String pathComponent : rootFolderPath) {
                pathStack.addLast(pathComponent);
            }
        }
        FSEntry curEntry2 = null;
        while (i2 < components.length) {
            String[] curPath = null;
            if (curEntry2 == null) {
                if (0 == 0) {
                    curPath = (String[]) pathStack.toArray(new String[pathStack.size()]);
                }
                curEntry2 = getEntry(curPath);
            }
            if (curEntry2 instanceof FSFolder) {
                curFolder = (FSFolder) curEntry2;
            } else if (curEntry2 instanceof FSLink) {
                FSLink curLink = (FSLink) curEntry2;
                if (visitedLinks == null) {
                    visitedLinks = new LinkedList<>();
                } else {
                    visitedLinks.clear();
                }
                if (curPath == null) {
                    curPath = (String[]) pathStack.toArray(new String[pathStack.size()]);
                }
                FSEntry linkTarget = resolveLinks(curPath, curLink, visitedLinks);
                if (linkTarget == null) {
                    return null;
                }
                if (linkTarget instanceof FSFolder) {
                    curFolder = (FSFolder) linkTarget;
                    visitedLinks.clear();
                } else if (linkTarget instanceof FSFile) {
                    return null;
                } else {
                    throw new RuntimeException("Unknown type: " + linkTarget.getClass());
                }
            } else {
                return null;
            }
            String curPathComponent = components[i2];
            if (curPathComponent.length() != 0 && !curPathComponent.equals(".")) {
                if (curPathComponent.equals("..")) {
                    if (pathStack.size() > 0) {
                        pathStack.removeLast();
                        curEntry2 = null;
                    } else {
                        return null;
                    }
                } else {
                    String fsPathnameComponent = parsePosixPathnameComponent(curPathComponent);
                    FSEntry nextEntry = curFolder.getChild(fsPathnameComponent);
                    if (nextEntry != null) {
                        curEntry2 = nextEntry;
                        pathStack.add(nextEntry.getName());
                    } else {
                        return null;
                    }
                }
            }
            i2++;
        }
        String[] res = (String[]) pathStack.toArray(new String[pathStack.size()]);
        return res;
    }

    public FSEntry resolveLinks(String[] linkPath, FSLink link) {
        return resolveLinks(linkPath, link, new LinkedList<>());
    }

    private FSEntry resolveLinks(String[] curPath, FSLink curLink, LinkedList<String[]> visitedLinks) {
        System.err.println("resolveLinks(" + Util.concatenateStrings(curPath, "/") + ", " + curLink.getLinkTargetString() + ", ...);");
        visitedLinks.add(curPath);
        FSEntry linkTarget = null;
        String[] curLinkPath = curPath;
        while (curLinkPath != null) {
            String[] parentPath = (String[]) Util.arrayCopy(curLinkPath, 0, new String[curLinkPath.length - 1], 0, curLinkPath.length - 1);
            System.err.println("  Resolving " + curLink.getLinkTargetString() + " from " + Util.concatenateStrings(parentPath, "/"));
            String[] linkTargetPath = getTargetPath(curLink, parentPath);
            if (linkTargetPath == null || Util.contains(visitedLinks, linkTargetPath)) {
                return null;
            }
            linkTarget = getEntry(linkTargetPath);
            if (linkTarget != null && (linkTarget instanceof FSLink)) {
                curLink = (FSLink) linkTarget;
                curLinkPath = linkTargetPath;
                visitedLinks.add(curLinkPath);
            } else {
                curLinkPath = null;
            }
        }
        return linkTarget;
    }
}
