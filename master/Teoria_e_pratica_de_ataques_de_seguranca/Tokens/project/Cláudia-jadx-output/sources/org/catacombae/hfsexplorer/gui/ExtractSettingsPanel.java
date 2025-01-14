package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import org.catacombae.hfsexplorer.ExtractProgressMonitor;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel.class */
public class ExtractSettingsPanel extends JPanel {
    private final ButtonGroup createDirButtonGroup;
    private final ButtonGroup createFileButtonGroup;
    private final ButtonGroup dirExistsButtonGroup;
    private final ButtonGroup fileExistsButtonGroup;
    private JRadioButton createDirAutoRenameButton;
    private JRadioButton createDirCancelButton;
    private JLabel createDirLabel;
    private JPanel createDirPanel;
    private JRadioButton createDirPromptUserButton;
    private JRadioButton createDirSkipDirectoryButton;
    private JRadioButton createFileAutoRenameButton;
    private JRadioButton createFileCancelButton;
    private JLabel createFileLabel;
    private JPanel createFilePanel;
    private JRadioButton createFilePromptUserButton;
    private JRadioButton createFileSkipDirectoryButton;
    private JRadioButton createFileSkipFileButton;
    private JRadioButton dirExistsAutoRenameButton;
    private JRadioButton dirExistsCancelButton;
    private JRadioButton dirExistsContinueButton;
    private JLabel dirExistsLabel;
    private JPanel dirExistsPanel;
    private JRadioButton dirExistsPromptUserButton;
    private JRadioButton dirExistsSkipDirectoryButton;
    private JRadioButton fileExistsAutoRenameButton;
    private JRadioButton fileExistsCancelButton;
    private JLabel fileExistsLabel;
    private JRadioButton fileExistsOverwriteButton;
    private JPanel fileExistsPanel;
    private JRadioButton fileExistsPromptUserButton;
    private JRadioButton fileExistsSkipDirectoryButton;
    private JRadioButton fileExistsSkipFileButton;
    private JCheckBox quietModeBox;

    public ExtractSettingsPanel(ExtractProgressMonitor.ExtractProperties p) {
        this();
        p.addListener(new ExtractProgressMonitor.ExtractPropertiesListener() { // from class: org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.1
            @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor.ExtractPropertiesListener
            public void propertyChanged(Object changedProperty) {
                JRadioButton jRadioButton;
                if (changedProperty instanceof ExtractProgressMonitor.CreateDirectoryFailedAction) {
                    switch (AnonymousClass3.$SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction[((ExtractProgressMonitor.CreateDirectoryFailedAction) changedProperty).ordinal()]) {
                        case 1:
                            jRadioButton = ExtractSettingsPanel.this.createDirPromptUserButton;
                            break;
                        case 2:
                            jRadioButton = ExtractSettingsPanel.this.createDirAutoRenameButton;
                            break;
                        case 3:
                            jRadioButton = ExtractSettingsPanel.this.createDirSkipDirectoryButton;
                            break;
                        case 4:
                            jRadioButton = ExtractSettingsPanel.this.createDirCancelButton;
                            break;
                        default:
                            throw new RuntimeException("Unknown property: " + changedProperty);
                    }
                } else if (changedProperty instanceof ExtractProgressMonitor.CreateFileFailedAction) {
                    switch (AnonymousClass3.$SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction[((ExtractProgressMonitor.CreateFileFailedAction) changedProperty).ordinal()]) {
                        case 1:
                            jRadioButton = ExtractSettingsPanel.this.createFilePromptUserButton;
                            break;
                        case 2:
                            jRadioButton = ExtractSettingsPanel.this.createFileSkipFileButton;
                            break;
                        case 3:
                            jRadioButton = ExtractSettingsPanel.this.createFileAutoRenameButton;
                            break;
                        case 4:
                            jRadioButton = ExtractSettingsPanel.this.createFileSkipDirectoryButton;
                            break;
                        case 5:
                            jRadioButton = ExtractSettingsPanel.this.createFileCancelButton;
                            break;
                        default:
                            throw new RuntimeException("Unknown property: " + changedProperty);
                    }
                } else if (changedProperty instanceof ExtractProgressMonitor.DirectoryExistsAction) {
                    switch (AnonymousClass3.$SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction[((ExtractProgressMonitor.DirectoryExistsAction) changedProperty).ordinal()]) {
                        case 1:
                            jRadioButton = ExtractSettingsPanel.this.dirExistsPromptUserButton;
                            break;
                        case 2:
                            jRadioButton = ExtractSettingsPanel.this.dirExistsContinueButton;
                            break;
                        case 3:
                            jRadioButton = ExtractSettingsPanel.this.dirExistsAutoRenameButton;
                            break;
                        case 4:
                            jRadioButton = ExtractSettingsPanel.this.dirExistsSkipDirectoryButton;
                            break;
                        case 5:
                            jRadioButton = ExtractSettingsPanel.this.dirExistsCancelButton;
                            break;
                        default:
                            throw new RuntimeException("Unknown property: " + changedProperty);
                    }
                } else if (changedProperty instanceof ExtractProgressMonitor.FileExistsAction) {
                    switch (AnonymousClass3.$SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[((ExtractProgressMonitor.FileExistsAction) changedProperty).ordinal()]) {
                        case 1:
                            jRadioButton = ExtractSettingsPanel.this.fileExistsPromptUserButton;
                            break;
                        case 2:
                            jRadioButton = ExtractSettingsPanel.this.fileExistsOverwriteButton;
                            break;
                        case 3:
                            jRadioButton = ExtractSettingsPanel.this.fileExistsAutoRenameButton;
                            break;
                        case 4:
                            jRadioButton = ExtractSettingsPanel.this.fileExistsSkipFileButton;
                            break;
                        case 5:
                            jRadioButton = ExtractSettingsPanel.this.fileExistsSkipDirectoryButton;
                            break;
                        case 6:
                            jRadioButton = ExtractSettingsPanel.this.fileExistsCancelButton;
                            break;
                        default:
                            throw new RuntimeException("Unknown property: " + changedProperty);
                    }
                } else {
                    throw new RuntimeException("Unknown property: " + (changedProperty != null ? changedProperty.getClass() : "null"));
                }
                if (jRadioButton != null) {
                    final JRadioButton jRadioButton2 = jRadioButton;
                    SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            jRadioButton2.setSelected(true);
                        }
                    });
                }
            }
        });
        this.createDirPromptUserButton.doClick();
        this.createFilePromptUserButton.doClick();
        this.dirExistsPromptUserButton.doClick();
        this.fileExistsPromptUserButton.doClick();
        this.createDirPromptUserButton.addActionListener(new CreateDirListener(this.createDirPromptUserButton, p, ExtractProgressMonitor.CreateDirectoryFailedAction.PROMPT_USER));
        this.createDirSkipDirectoryButton.addActionListener(new CreateDirListener(this.createDirSkipDirectoryButton, p, ExtractProgressMonitor.CreateDirectoryFailedAction.SKIP_DIRECTORY));
        this.createDirAutoRenameButton.addActionListener(new CreateDirListener(this.createDirAutoRenameButton, p, ExtractProgressMonitor.CreateDirectoryFailedAction.AUTO_RENAME));
        this.createDirCancelButton.addActionListener(new CreateDirListener(this.createDirCancelButton, p, ExtractProgressMonitor.CreateDirectoryFailedAction.CANCEL));
        this.createFilePromptUserButton.addActionListener(new CreateFileListener(this.createFilePromptUserButton, p, ExtractProgressMonitor.CreateFileFailedAction.PROMPT_USER));
        this.createFileSkipFileButton.addActionListener(new CreateFileListener(this.createFileSkipFileButton, p, ExtractProgressMonitor.CreateFileFailedAction.SKIP_FILE));
        this.createFileSkipDirectoryButton.addActionListener(new CreateFileListener(this.createFileSkipDirectoryButton, p, ExtractProgressMonitor.CreateFileFailedAction.SKIP_DIRECTORY));
        this.createFileAutoRenameButton.addActionListener(new CreateFileListener(this.createFileAutoRenameButton, p, ExtractProgressMonitor.CreateFileFailedAction.AUTO_RENAME));
        this.createFileCancelButton.addActionListener(new CreateFileListener(this.createFileCancelButton, p, ExtractProgressMonitor.CreateFileFailedAction.CANCEL));
        this.dirExistsPromptUserButton.addActionListener(new DirExistsListener(this.dirExistsPromptUserButton, p, ExtractProgressMonitor.DirectoryExistsAction.PROMPT_USER));
        this.dirExistsContinueButton.addActionListener(new DirExistsListener(this.dirExistsContinueButton, p, ExtractProgressMonitor.DirectoryExistsAction.CONTINUE));
        this.dirExistsSkipDirectoryButton.addActionListener(new DirExistsListener(this.dirExistsSkipDirectoryButton, p, ExtractProgressMonitor.DirectoryExistsAction.SKIP_DIRECTORY));
        this.dirExistsAutoRenameButton.addActionListener(new DirExistsListener(this.dirExistsAutoRenameButton, p, ExtractProgressMonitor.DirectoryExistsAction.AUTO_RENAME));
        this.dirExistsCancelButton.addActionListener(new DirExistsListener(this.dirExistsCancelButton, p, ExtractProgressMonitor.DirectoryExistsAction.CANCEL));
        this.fileExistsPromptUserButton.addActionListener(new FileExistsListener(this.fileExistsPromptUserButton, p, ExtractProgressMonitor.FileExistsAction.PROMPT_USER));
        this.fileExistsSkipFileButton.addActionListener(new FileExistsListener(this.fileExistsSkipFileButton, p, ExtractProgressMonitor.FileExistsAction.SKIP_FILE));
        this.fileExistsSkipDirectoryButton.addActionListener(new FileExistsListener(this.fileExistsSkipDirectoryButton, p, ExtractProgressMonitor.FileExistsAction.SKIP_DIRECTORY));
        this.fileExistsOverwriteButton.addActionListener(new FileExistsListener(this.fileExistsOverwriteButton, p, ExtractProgressMonitor.FileExistsAction.OVERWRITE));
        this.fileExistsAutoRenameButton.addActionListener(new FileExistsListener(this.fileExistsAutoRenameButton, p, ExtractProgressMonitor.FileExistsAction.AUTO_RENAME));
        this.fileExistsCancelButton.addActionListener(new FileExistsListener(this.fileExistsCancelButton, p, ExtractProgressMonitor.FileExistsAction.CANCEL));
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$3.class
     */
    /* renamed from: org.catacombae.hfsexplorer.gui.ExtractSettingsPanel$3  reason: invalid class name */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$3.class */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction;
        static final /* synthetic */ int[] $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction;
        static final /* synthetic */ int[] $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction;
        static final /* synthetic */ int[] $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction = new int[ExtractProgressMonitor.FileExistsAction.values().length];

        static {
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[ExtractProgressMonitor.FileExistsAction.PROMPT_USER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[ExtractProgressMonitor.FileExistsAction.OVERWRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[ExtractProgressMonitor.FileExistsAction.AUTO_RENAME.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[ExtractProgressMonitor.FileExistsAction.SKIP_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[ExtractProgressMonitor.FileExistsAction.SKIP_DIRECTORY.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$FileExistsAction[ExtractProgressMonitor.FileExistsAction.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction = new int[ExtractProgressMonitor.DirectoryExistsAction.values().length];
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction[ExtractProgressMonitor.DirectoryExistsAction.PROMPT_USER.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction[ExtractProgressMonitor.DirectoryExistsAction.CONTINUE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction[ExtractProgressMonitor.DirectoryExistsAction.AUTO_RENAME.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction[ExtractProgressMonitor.DirectoryExistsAction.SKIP_DIRECTORY.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$DirectoryExistsAction[ExtractProgressMonitor.DirectoryExistsAction.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction = new int[ExtractProgressMonitor.CreateFileFailedAction.values().length];
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction[ExtractProgressMonitor.CreateFileFailedAction.PROMPT_USER.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction[ExtractProgressMonitor.CreateFileFailedAction.SKIP_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction[ExtractProgressMonitor.CreateFileFailedAction.AUTO_RENAME.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction[ExtractProgressMonitor.CreateFileFailedAction.SKIP_DIRECTORY.ordinal()] = 4;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateFileFailedAction[ExtractProgressMonitor.CreateFileFailedAction.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError e17) {
            }
            $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction = new int[ExtractProgressMonitor.CreateDirectoryFailedAction.values().length];
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction[ExtractProgressMonitor.CreateDirectoryFailedAction.PROMPT_USER.ordinal()] = 1;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction[ExtractProgressMonitor.CreateDirectoryFailedAction.AUTO_RENAME.ordinal()] = 2;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction[ExtractProgressMonitor.CreateDirectoryFailedAction.SKIP_DIRECTORY.ordinal()] = 3;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$ExtractProgressMonitor$CreateDirectoryFailedAction[ExtractProgressMonitor.CreateDirectoryFailedAction.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError e21) {
            }
        }
    }

    private ExtractSettingsPanel() {
        this.createDirButtonGroup = new ButtonGroup();
        this.createFileButtonGroup = new ButtonGroup();
        this.dirExistsButtonGroup = new ButtonGroup();
        this.fileExistsButtonGroup = new ButtonGroup();
        initComponents();
        this.createDirButtonGroup.add(this.createDirPromptUserButton);
        this.createDirButtonGroup.add(this.createDirSkipDirectoryButton);
        this.createDirButtonGroup.add(this.createDirAutoRenameButton);
        this.createDirButtonGroup.add(this.createDirCancelButton);
        this.createFileButtonGroup.add(this.createFilePromptUserButton);
        this.createFileButtonGroup.add(this.createFileSkipFileButton);
        this.createFileButtonGroup.add(this.createFileSkipDirectoryButton);
        this.createFileButtonGroup.add(this.createFileAutoRenameButton);
        this.createFileButtonGroup.add(this.createFileCancelButton);
        this.dirExistsButtonGroup.add(this.dirExistsPromptUserButton);
        this.dirExistsButtonGroup.add(this.dirExistsContinueButton);
        this.dirExistsButtonGroup.add(this.dirExistsSkipDirectoryButton);
        this.dirExistsButtonGroup.add(this.dirExistsAutoRenameButton);
        this.dirExistsButtonGroup.add(this.dirExistsCancelButton);
        this.fileExistsButtonGroup.add(this.fileExistsPromptUserButton);
        this.fileExistsButtonGroup.add(this.fileExistsSkipFileButton);
        this.fileExistsButtonGroup.add(this.fileExistsSkipDirectoryButton);
        this.fileExistsButtonGroup.add(this.fileExistsOverwriteButton);
        this.fileExistsButtonGroup.add(this.fileExistsAutoRenameButton);
        this.fileExistsButtonGroup.add(this.fileExistsCancelButton);
        this.quietModeBox.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.2
            public void actionPerformed(ActionEvent e2) {
                boolean selected = ExtractSettingsPanel.this.quietModeBox.isSelected();
                if (selected) {
                    ExtractSettingsPanel.this.createDirSkipDirectoryButton.doClick();
                    ExtractSettingsPanel.this.createFileSkipFileButton.doClick();
                    ExtractSettingsPanel.this.dirExistsSkipDirectoryButton.doClick();
                    ExtractSettingsPanel.this.fileExistsSkipFileButton.doClick();
                }
                List<ButtonGroup> buttonGroups = Arrays.asList(ExtractSettingsPanel.this.createDirButtonGroup, ExtractSettingsPanel.this.createFileButtonGroup, ExtractSettingsPanel.this.dirExistsButtonGroup, ExtractSettingsPanel.this.fileExistsButtonGroup);
                for (ButtonGroup bg : buttonGroups) {
                    Enumeration<AbstractButton> buttonEnum = bg.getElements();
                    while (buttonEnum.hasMoreElements()) {
                        AbstractButton b2 = buttonEnum.nextElement();
                        b2.setEnabled(!selected);
                    }
                }
            }
        });
    }

    private void initComponents() {
        this.quietModeBox = new JCheckBox();
        this.createDirPanel = new JPanel();
        this.createDirLabel = new JLabel();
        this.createDirPromptUserButton = new JRadioButton();
        this.createDirSkipDirectoryButton = new JRadioButton();
        this.createDirAutoRenameButton = new JRadioButton();
        this.createDirCancelButton = new JRadioButton();
        this.createFilePanel = new JPanel();
        this.createFileLabel = new JLabel();
        this.createFilePromptUserButton = new JRadioButton();
        this.createFileSkipFileButton = new JRadioButton();
        this.createFileSkipDirectoryButton = new JRadioButton();
        this.createFileAutoRenameButton = new JRadioButton();
        this.createFileCancelButton = new JRadioButton();
        this.dirExistsPanel = new JPanel();
        this.dirExistsLabel = new JLabel();
        this.dirExistsPromptUserButton = new JRadioButton();
        this.dirExistsContinueButton = new JRadioButton();
        this.dirExistsSkipDirectoryButton = new JRadioButton();
        this.dirExistsAutoRenameButton = new JRadioButton();
        this.dirExistsCancelButton = new JRadioButton();
        this.fileExistsPanel = new JPanel();
        this.fileExistsLabel = new JLabel();
        this.fileExistsPromptUserButton = new JRadioButton();
        this.fileExistsSkipFileButton = new JRadioButton();
        this.fileExistsSkipDirectoryButton = new JRadioButton();
        this.fileExistsOverwriteButton = new JRadioButton();
        this.fileExistsAutoRenameButton = new JRadioButton();
        this.fileExistsCancelButton = new JRadioButton();
        this.quietModeBox.setText("Quiet mode");
        this.quietModeBox.setToolTipText("A non-destructive \"No questions asked\" mode");
        this.createDirLabel.setText("Create directory failed:");
        this.createDirPromptUserButton.setText("Prompt user");
        this.createDirSkipDirectoryButton.setText("Skip directory");
        this.createDirAutoRenameButton.setText("Auto-rename");
        this.createDirCancelButton.setText("Cancel");
        GroupLayout createDirPanelLayout = new GroupLayout(this.createDirPanel);
        this.createDirPanel.setLayout(createDirPanelLayout);
        createDirPanelLayout.setHorizontalGroup(createDirPanelLayout.createParallelGroup(1).add((Component) this.createDirLabel).add(createDirPanelLayout.createSequentialGroup().add(10, 10, 10).add(createDirPanelLayout.createParallelGroup(1).add((Component) this.createDirPromptUserButton).add((Component) this.createDirSkipDirectoryButton).add((Component) this.createDirAutoRenameButton).add((Component) this.createDirCancelButton))));
        createDirPanelLayout.setVerticalGroup(createDirPanelLayout.createParallelGroup(1).add(createDirPanelLayout.createSequentialGroup().add((Component) this.createDirLabel).addPreferredGap(0).add((Component) this.createDirPromptUserButton).addPreferredGap(0).add((Component) this.createDirSkipDirectoryButton).addPreferredGap(0).add((Component) this.createDirAutoRenameButton).addPreferredGap(0).add((Component) this.createDirCancelButton).addContainerGap(23, 32767)));
        this.createFileLabel.setText("Create file failed:");
        this.createFilePromptUserButton.setText("Prompt user");
        this.createFileSkipFileButton.setText("Skip file");
        this.createFileSkipDirectoryButton.setText("Skip rest of directory");
        this.createFileAutoRenameButton.setText("Auto-rename");
        this.createFileCancelButton.setText("Cancel");
        GroupLayout createFilePanelLayout = new GroupLayout(this.createFilePanel);
        this.createFilePanel.setLayout(createFilePanelLayout);
        createFilePanelLayout.setHorizontalGroup(createFilePanelLayout.createParallelGroup(1).add(createFilePanelLayout.createSequentialGroup().add(createFilePanelLayout.createParallelGroup(1).add((Component) this.createFileLabel).add(createFilePanelLayout.createSequentialGroup().add(10, 10, 10).add(createFilePanelLayout.createParallelGroup(1).add((Component) this.createFileSkipFileButton).add((Component) this.createFilePromptUserButton).add((Component) this.createFileSkipDirectoryButton).add((Component) this.createFileAutoRenameButton).add((Component) this.createFileCancelButton)))).addContainerGap(-1, 32767)));
        createFilePanelLayout.setVerticalGroup(createFilePanelLayout.createParallelGroup(1).add(createFilePanelLayout.createSequentialGroup().add((Component) this.createFileLabel).addPreferredGap(0).add((Component) this.createFilePromptUserButton).addPreferredGap(0).add((Component) this.createFileSkipFileButton).addPreferredGap(0).add((Component) this.createFileSkipDirectoryButton).addPreferredGap(0).add((Component) this.createFileAutoRenameButton).addPreferredGap(0).add((Component) this.createFileCancelButton)));
        this.dirExistsLabel.setText("Directory already exists:");
        this.dirExistsPromptUserButton.setText("Prompt user");
        this.dirExistsContinueButton.setText("Continue");
        this.dirExistsSkipDirectoryButton.setText("Skip directory");
        this.dirExistsAutoRenameButton.setText("Auto-rename");
        this.dirExistsCancelButton.setText("Cancel");
        GroupLayout dirExistsPanelLayout = new GroupLayout(this.dirExistsPanel);
        this.dirExistsPanel.setLayout(dirExistsPanelLayout);
        dirExistsPanelLayout.setHorizontalGroup(dirExistsPanelLayout.createParallelGroup(1).add((Component) this.dirExistsLabel).add(dirExistsPanelLayout.createSequentialGroup().add(10, 10, 10).add(dirExistsPanelLayout.createParallelGroup(1).add((Component) this.dirExistsContinueButton).add((Component) this.dirExistsPromptUserButton).add((Component) this.dirExistsSkipDirectoryButton).add((Component) this.dirExistsAutoRenameButton).add((Component) this.dirExistsCancelButton))));
        dirExistsPanelLayout.setVerticalGroup(dirExistsPanelLayout.createParallelGroup(1).add(dirExistsPanelLayout.createSequentialGroup().add((Component) this.dirExistsLabel).addPreferredGap(0).add((Component) this.dirExistsPromptUserButton).addPreferredGap(0).add((Component) this.dirExistsContinueButton).addPreferredGap(0).add((Component) this.dirExistsSkipDirectoryButton).addPreferredGap(0).add((Component) this.dirExistsAutoRenameButton).addPreferredGap(0).add((Component) this.dirExistsCancelButton)));
        this.fileExistsLabel.setText("File already exists:");
        this.fileExistsPromptUserButton.setText("Prompt user");
        this.fileExistsSkipFileButton.setText("Skip file");
        this.fileExistsSkipDirectoryButton.setText("Skip rest of directory");
        this.fileExistsOverwriteButton.setText("Overwrite existing file");
        this.fileExistsAutoRenameButton.setText("Auto-rename");
        this.fileExistsCancelButton.setText("Cancel");
        GroupLayout fileExistsPanelLayout = new GroupLayout(this.fileExistsPanel);
        this.fileExistsPanel.setLayout(fileExistsPanelLayout);
        fileExistsPanelLayout.setHorizontalGroup(fileExistsPanelLayout.createParallelGroup(1).add(fileExistsPanelLayout.createSequentialGroup().add(fileExistsPanelLayout.createParallelGroup(1).add((Component) this.fileExistsLabel).add(fileExistsPanelLayout.createSequentialGroup().add(10, 10, 10).add(fileExistsPanelLayout.createParallelGroup(1).add((Component) this.fileExistsCancelButton).add((Component) this.fileExistsAutoRenameButton).add((Component) this.fileExistsSkipFileButton).add((Component) this.fileExistsPromptUserButton).add((Component) this.fileExistsSkipDirectoryButton).add((Component) this.fileExistsOverwriteButton)))).addContainerGap(-1, 32767)));
        fileExistsPanelLayout.setVerticalGroup(fileExistsPanelLayout.createParallelGroup(1).add(fileExistsPanelLayout.createSequentialGroup().add((Component) this.fileExistsLabel).addPreferredGap(0).add((Component) this.fileExistsPromptUserButton).addPreferredGap(0).add((Component) this.fileExistsSkipFileButton).addPreferredGap(0).add((Component) this.fileExistsSkipDirectoryButton).addPreferredGap(0).add((Component) this.fileExistsOverwriteButton).addPreferredGap(0).add((Component) this.fileExistsAutoRenameButton).addPreferredGap(0).add((Component) this.fileExistsCancelButton)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(21, 21, 21).add(layout.createParallelGroup(1).add(this.dirExistsPanel, -2, -1, -2).add(this.createDirPanel, -2, -1, -2)).add(18, 18, 18).add(layout.createParallelGroup(1).add(this.fileExistsPanel, -2, -1, -2).add(this.createFilePanel, -2, -1, -2))).add((Component) this.quietModeBox)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.quietModeBox).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.createDirPanel, -2, -1, -2).add(this.createFilePanel, -1, -1, 32767)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.fileExistsPanel, -2, -1, -2).add(this.dirExistsPanel, -2, -1, -2)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$AbstractListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$AbstractListener.class */
    public abstract class AbstractListener<A> implements ActionListener {
        protected final AbstractButton button;
        protected final ExtractProgressMonitor.ExtractProperties p;
        protected final A action;

        protected abstract void setAction(A a2);

        public AbstractListener(AbstractButton button, ExtractProgressMonitor.ExtractProperties p, A action) {
            this.button = button;
            this.p = p;
            this.action = action;
        }

        public void actionPerformed(ActionEvent e2) {
            if (this.button.isSelected()) {
                setAction(this.action);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$CreateDirListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$CreateDirListener.class */
    private class CreateDirListener extends AbstractListener<ExtractProgressMonitor.CreateDirectoryFailedAction> {
        public CreateDirListener(AbstractButton button, ExtractProgressMonitor.ExtractProperties p, ExtractProgressMonitor.CreateDirectoryFailedAction action) {
            super(button, p, action);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.AbstractListener
        public void setAction(ExtractProgressMonitor.CreateDirectoryFailedAction action) {
            this.p.setCreateDirectoryFailedAction(action);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$CreateFileListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$CreateFileListener.class */
    private class CreateFileListener extends AbstractListener<ExtractProgressMonitor.CreateFileFailedAction> {
        public CreateFileListener(AbstractButton button, ExtractProgressMonitor.ExtractProperties p, ExtractProgressMonitor.CreateFileFailedAction action) {
            super(button, p, action);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.AbstractListener
        public void setAction(ExtractProgressMonitor.CreateFileFailedAction action) {
            this.p.setCreateFileFailedAction(action);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$DirExistsListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$DirExistsListener.class */
    private class DirExistsListener extends AbstractListener<ExtractProgressMonitor.DirectoryExistsAction> {
        public DirExistsListener(AbstractButton button, ExtractProgressMonitor.ExtractProperties p, ExtractProgressMonitor.DirectoryExistsAction action) {
            super(button, p, action);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.AbstractListener
        public void setAction(ExtractProgressMonitor.DirectoryExistsAction action) {
            this.p.setDirectoryExistsAction(action);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$FileExistsListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractSettingsPanel$FileExistsListener.class */
    private class FileExistsListener extends AbstractListener<ExtractProgressMonitor.FileExistsAction> {
        public FileExistsListener(AbstractButton button, ExtractProgressMonitor.ExtractProperties p, ExtractProgressMonitor.FileExistsAction action) {
            super(button, p, action);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.catacombae.hfsexplorer.gui.ExtractSettingsPanel.AbstractListener
        public void setAction(ExtractProgressMonitor.FileExistsAction action) {
            this.p.setFileExistsAction(action);
        }
    }
}
