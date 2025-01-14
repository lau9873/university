package java.awt;

import java.io.File;
import java.io.IOException;
import java.net.URI;
/* loaded from: hfsexplorer-0_21-src.zip:lib/java_awt_Desktop.jar:java/awt/Desktop.class */
public class Desktop {

    /* loaded from: hfsexplorer-0_21-src.zip:lib/java_awt_Desktop.jar:java/awt/Desktop$Action.class */
    public enum Action {
        BROWSE,
        EDIT,
        MAIL,
        OPEN,
        PRINT
    }

    public static Desktop getDesktop() {
        throw new UnsupportedOperationException();
    }

    public static boolean isDesktopSupported() {
        return false;
    }

    public boolean isSupported(Action action) {
        return false;
    }

    public void open(File file) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void edit(File file) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void print(File file) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void browse(URI uri) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void mail() throws IOException {
        throw new UnsupportedOperationException();
    }

    public void mail(URI uri) throws IOException {
        throw new UnsupportedOperationException();
    }
}
