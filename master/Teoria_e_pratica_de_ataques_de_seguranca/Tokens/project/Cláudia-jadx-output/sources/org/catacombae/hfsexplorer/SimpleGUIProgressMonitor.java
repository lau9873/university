package org.catacombae.hfsexplorer;

import java.awt.Component;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import org.catacombae.hfsexplorer.ExtractProgressMonitor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/SimpleGUIProgressMonitor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/SimpleGUIProgressMonitor.class */
public class SimpleGUIProgressMonitor extends BasicExtractProgressMonitor {
    private final Component parentComponent;
    private final ExtractProgressMonitor.ExtractProperties extractProperties = new ExtractProgressMonitor.ExtractProperties();

    public SimpleGUIProgressMonitor(Component parentComponent) {
        this.parentComponent = parentComponent;
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.ExtractProperties getExtractProperties() {
        return this.extractProperties;
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.CreateDirectoryFailedAction createDirectoryFailed(String dirname, File parentDirectory) {
        return createDirectoryFailed(this.parentComponent, dirname, parentDirectory);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.CreateFileFailedAction createFileFailed(String filename, File parentDirectory) {
        return createFileFailed(this.parentComponent, filename, parentDirectory);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.DirectoryExistsAction directoryExists(File directory) {
        return directoryExists(this.parentComponent, directory);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.FileExistsAction fileExists(File file) {
        return fileExists(this.parentComponent, file);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public String displayRenamePrompt(String currentName, File outDir) {
        return displayRenamePrompt(this.parentComponent, currentName, outDir);
    }

    public static ExtractProgressMonitor.CreateDirectoryFailedAction createDirectoryFailed(Component parentComponent, String dirname, File parentDirectory) {
        String[] options = {"Rename", "Skip directory", "Auto-rename", "Cancel"};
        int reply = JOptionPane.showOptionDialog(parentComponent, "Could not create directory \"" + dirname + "\" in:\n    \"" + parentDirectory.getAbsolutePath() + "\"", "Error", 1, 0, (Icon) null, options, options[0]);
        switch (reply) {
            case 0:
                return ExtractProgressMonitor.CreateDirectoryFailedAction.RENAME;
            case 1:
                return ExtractProgressMonitor.CreateDirectoryFailedAction.SKIP_DIRECTORY;
            case 2:
                return ExtractProgressMonitor.CreateDirectoryFailedAction.AUTO_RENAME;
            default:
                return ExtractProgressMonitor.CreateDirectoryFailedAction.CANCEL;
        }
    }

    public static ExtractProgressMonitor.CreateFileFailedAction createFileFailed(Component parentComponent, String filename, File parentDirectory) {
        String[] options = {"Rename", "Skip file", "Skip directory", "Auto-rename", "Cancel"};
        int reply = JOptionPane.showOptionDialog(parentComponent, "Could not create file \"" + filename + "\" in:\n    \"" + parentDirectory.getAbsolutePath() + "\"", "Error", 1, 0, (Icon) null, options, options[0]);
        switch (reply) {
            case 0:
                return ExtractProgressMonitor.CreateFileFailedAction.RENAME;
            case 1:
                return ExtractProgressMonitor.CreateFileFailedAction.SKIP_FILE;
            case 2:
                return ExtractProgressMonitor.CreateFileFailedAction.SKIP_DIRECTORY;
            case 3:
                return ExtractProgressMonitor.CreateFileFailedAction.AUTO_RENAME;
            default:
                return ExtractProgressMonitor.CreateFileFailedAction.CANCEL;
        }
    }

    public static ExtractProgressMonitor.DirectoryExistsAction directoryExists(Component parentComponent, File directory) {
        String[] options = {"Continue", "Rename", "Skip directory", "Auto-rename", "Cancel"};
        int reply = JOptionPane.showOptionDialog(parentComponent, "Warning! Directory:\n    \"" + directory.getAbsolutePath() + "\"\nalready exists.", "Warning", 1, 2, (Icon) null, options, options[0]);
        switch (reply) {
            case 0:
                return ExtractProgressMonitor.DirectoryExistsAction.CONTINUE;
            case 1:
                return ExtractProgressMonitor.DirectoryExistsAction.RENAME;
            case 2:
                return ExtractProgressMonitor.DirectoryExistsAction.SKIP_DIRECTORY;
            case 3:
                return ExtractProgressMonitor.DirectoryExistsAction.AUTO_RENAME;
            default:
                return ExtractProgressMonitor.DirectoryExistsAction.CANCEL;
        }
    }

    public static ExtractProgressMonitor.FileExistsAction fileExists(Component parentComponent, File file) {
        String[] options = {"Overwrite", "Overwrite all", "Rename", "Skip file", "Skip directory", "Auto-rename", "Cancel"};
        int reply = JOptionPane.showOptionDialog(parentComponent, "Warning! File:\n    \"" + file.getAbsolutePath() + "\"\nalready exists.", "Warning", 1, 2, (Icon) null, options, options[0]);
        switch (reply) {
            case 0:
                return ExtractProgressMonitor.FileExistsAction.OVERWRITE;
            case 1:
                return ExtractProgressMonitor.FileExistsAction.OVERWRITE_ALL;
            case 2:
                return ExtractProgressMonitor.FileExistsAction.RENAME;
            case 3:
                return ExtractProgressMonitor.FileExistsAction.SKIP_FILE;
            case 4:
                return ExtractProgressMonitor.FileExistsAction.SKIP_DIRECTORY;
            case 5:
                return ExtractProgressMonitor.FileExistsAction.AUTO_RENAME;
            default:
                return ExtractProgressMonitor.FileExistsAction.CANCEL;
        }
    }

    public static String displayRenamePrompt(Component parentComponent, String currentName, File outDir) {
        Object selection = JOptionPane.showInputDialog(parentComponent, "Enter new name:", "Rename", -1, (Icon) null, (Object[]) null, currentName);
        if (selection != null) {
            return selection.toString();
        }
        return null;
    }
}
