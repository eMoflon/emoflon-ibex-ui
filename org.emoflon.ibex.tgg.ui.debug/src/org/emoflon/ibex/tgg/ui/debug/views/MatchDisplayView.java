package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import net.miginfocom.swt.MigLayout;
import net.sourceforge.plantuml.SourceStringReader;

public class MatchDisplayView extends Composite {

    private static final String nullStringErrorMessage = "@startuml\ntitle\nHow does one display the absence of something?\nNot just an empty image on the screen, but the sheer nothingness of a null reference.\nI do not know. Perhaps, some day, I will have gained the wisdom necessary to achieve this magnificent feat.\nendtitle\n@enduml";

    private Label imageContainer;

    private MatchDisplayView(Composite parent) {
	super(parent, SWT.NONE);
	setLayout(new MigLayout("fill"));
    }

    private MatchDisplayView build() {
	imageContainer = new Label(this, SWT.BORDER | SWT.CENTER);
	imageContainer.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	imageContainer.setLayoutData("grow");
	imageContainer.setImage(null);
	imageContainer.pack();

	pack();
	return this;
    }

    public static MatchDisplayView create(Composite pParent) {
	return new MatchDisplayView(pParent).build();
    }

    public void display(String pPlantUMLString) {

	if (pPlantUMLString == null)
	    pPlantUMLString = nullStringErrorMessage;

	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	try {
	    new SourceStringReader(pPlantUMLString).outputImage(outputStream);
	} catch (IOException pIOE) {
	    // TODO what do I do here?
	}

	imageContainer.setImage(new Image(Display.getCurrent(), new ByteArrayInputStream(outputStream.toByteArray())));
    }
}
