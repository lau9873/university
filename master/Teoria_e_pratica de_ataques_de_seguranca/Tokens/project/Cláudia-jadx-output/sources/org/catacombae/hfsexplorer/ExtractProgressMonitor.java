package org.catacombae.hfsexplorer;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.fs.ProgressMonitor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor.class */
public interface ExtractProgressMonitor extends ProgressMonitor {

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$CreateDirectoryFailedAction.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$CreateDirectoryFailedAction.class */
    public enum CreateDirectoryFailedAction {
        PROMPT_USER,
        SKIP_DIRECTORY,
        RENAME,
        AUTO_RENAME,
        CANCEL
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$CreateFileFailedAction.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$CreateFileFailedAction.class */
    public enum CreateFileFailedAction {
        PROMPT_USER,
        SKIP_FILE,
        SKIP_DIRECTORY,
        RENAME,
        AUTO_RENAME,
        CANCEL
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$DirectoryExistsAction.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$DirectoryExistsAction.class */
    public enum DirectoryExistsAction {
        PROMPT_USER,
        CONTINUE,
        SKIP_DIRECTORY,
        RENAME,
        AUTO_RENAME,
        CANCEL
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$ExtractPropertiesListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$ExtractPropertiesListener.class */
    public interface ExtractPropertiesListener {
        void propertyChanged(Object obj);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$FileExistsAction.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$FileExistsAction.class */
    public enum FileExistsAction {
        PROMPT_USER,
        SKIP_FILE,
        SKIP_DIRECTORY,
        OVERWRITE,
        OVERWRITE_ALL,
        RENAME,
        AUTO_RENAME,
        CANCEL
    }

    void updateCalculateDir(String str);

    void updateTotalProgress(double d2, String str);

    void updateCurrentDir(String str);

    void updateCurrentFile(String str, long j);

    void setDataSize(long j);

    CreateDirectoryFailedAction createDirectoryFailed(String str, File file);

    CreateFileFailedAction createFileFailed(String str, File file);

    DirectoryExistsAction directoryExists(File file);

    FileExistsAction fileExists(File file);

    String displayRenamePrompt(String str, File file);

    ExtractProperties getExtractProperties();

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$ExtractProperties.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressMonitor$ExtractProperties.class */
    public static class ExtractProperties {
        private final LinkedList<ExtractPropertiesListener> listeners = new LinkedList<>();
        private volatile CreateDirectoryFailedAction createDirAction = CreateDirectoryFailedAction.PROMPT_USER;
        private volatile CreateFileFailedAction createFileAction = CreateFileFailedAction.PROMPT_USER;
        private volatile DirectoryExistsAction dirExistsAction = DirectoryExistsAction.PROMPT_USER;
        private volatile FileExistsAction fileExistsAction = FileExistsAction.PROMPT_USER;

        public CreateDirectoryFailedAction getCreateDirectoryFailedAction() {
            return this.createDirAction;
        }

        public CreateFileFailedAction getCreateFileFailedAction() {
            return this.createFileAction;
        }

        public DirectoryExistsAction getDirectoryExistsAction() {
            return this.dirExistsAction;
        }

        public FileExistsAction getFileExistsAction() {
            return this.fileExistsAction;
        }

        public void setCreateDirectoryFailedAction(CreateDirectoryFailedAction action) {
            this.createDirAction = action;
            notifyListeners(action);
        }

        public void setCreateFileFailedAction(CreateFileFailedAction action) {
            this.createFileAction = action;
            notifyListeners(action);
        }

        public void setDirectoryExistsAction(DirectoryExistsAction action) {
            this.dirExistsAction = action;
            notifyListeners(action);
        }

        public void setFileExistsAction(FileExistsAction action) {
            this.fileExistsAction = action;
            notifyListeners(action);
        }

        public void addListener(ExtractPropertiesListener listener) {
            this.listeners.addLast(listener);
        }

        private void notifyListeners(Object changedProperty) {
            Iterator i$ = this.listeners.iterator();
            while (i$.hasNext()) {
                ExtractPropertiesListener listener = i$.next();
                try {
                    listener.propertyChanged(changedProperty);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
