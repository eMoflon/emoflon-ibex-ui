package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;

public class SaveDialog {
    public static void build(Shell pParentShell, IVictoryDataProvider pDataProvider) {
	Shell dialogShell = new Shell(pParentShell, SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.ON_TOP);

	dialogShell.setLayout(new GridLayout());

	Composite panel = new Composite(dialogShell, SWT.NONE);
	panel.setLayoutData(new GridData(GridData.FILL_BOTH));
	panel.setLayout(new GridLayout());

	String[][] defaultSaveData = pDataProvider.getDefaultSaveData();

	LocationSelector srcSelector = new LocationSelector(panel, defaultSaveData[0][0], defaultSaveData[0][1],
		defaultSaveData[0][2]).build(dialogShell);
	srcSelector.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	LocationSelector trgSelector = new LocationSelector(panel, defaultSaveData[1][0], defaultSaveData[1][1],
		defaultSaveData[1][2]).build(dialogShell);
	trgSelector.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	LocationSelector corrSelector = new LocationSelector(panel, defaultSaveData[2][0], defaultSaveData[2][1],
		defaultSaveData[2][2]).build(dialogShell);
	corrSelector.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	LocationSelector protocolSelector = new LocationSelector(panel, defaultSaveData[3][0], defaultSaveData[3][1],
		defaultSaveData[3][2]).build(dialogShell);
	protocolSelector.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	Button saveButton = new Button(panel, SWT.PUSH);
	saveButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	saveButton.setText("Save all");
	saveButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pEvent) {
		try {
		    pDataProvider
			    .saveModels(new String[] { srcSelector.getFileLocation(), trgSelector.getFileLocation(),
				    corrSelector.getFileLocation(), protocolSelector.getFileLocation() });
		} catch (IOException e) {
		    // TODO what to do here?
		} finally {
		    dialogShell.close();
		    dialogShell.dispose();
		}
	    }
	});

	panel.pack();
	dialogShell.pack();

	dialogShell.open();
    }

    private static class LocationSelector extends Composite {

	private String defaultDirectory;
	private String defaultName;
	private String fileExtension;

	private Text location;

	private LocationSelector(Composite pParent, String pDefaultDirectory, String pDefaultName,
		String pFileExtension) {
	    super(pParent, SWT.NONE);
	    defaultDirectory = pDefaultDirectory;
	    defaultName = pDefaultName;
	    fileExtension = pFileExtension;
	}

	private LocationSelector build(Shell pParentShell) {
	    setLayout(new GridLayout(2, false));

	    location = new Text(this, SWT.SINGLE);
	    location.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    location.setText(defaultDirectory + defaultName + fileExtension);

	    Button selectButton = new Button(this, SWT.PUSH);
	    selectButton.setText("Change...");
	    selectButton.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent pEvent) {
		    FileDialog dialog = new FileDialog(pParentShell, SWT.SAVE);
		    dialog.setFilterPath(defaultDirectory);
		    dialog.setFileName(defaultName);
		    dialog.setFilterExtensions(new String[] { fileExtension });
		    dialog.setFilterNames(new String[] { fileExtension });
		    dialog.setOverwrite(true);

		    String result = dialog.open();
		    if (result != null)
			location.setText(result);
		}
	    });

	    return this;
	}

	private String getFileLocation() {
	    return location.getText();
	}
    }
}
