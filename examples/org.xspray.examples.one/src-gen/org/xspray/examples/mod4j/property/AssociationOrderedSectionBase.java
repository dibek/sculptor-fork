/*************************************************************************************
 *
 * Generated on Sat Aug 27 19:33:30 CEST 2011 by XSpray PropertySection.xtend
 *
 * This file contains generated and should not be changed.
 * Use the extension point class (the direct subclass of this class) to add manual code
 *
 *************************************************************************************/
package org.xspray.examples.mod4j.property;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import java.util.List;

//import BusinessDomainDsl.Association;
import BusinessDomainDsl.Association;
public class AssociationOrderedSectionBase extends GFPropertySection implements ITabbedPropertyConstants {
 
    protected Association bc = null;
protected CCombo orderedWidget;
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;

orderedWidget = factory.createCCombo(composite);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        orderedWidget.setLayoutData(data);
 
        CLabel valueLabel = factory.createCLabel(composite, "Ordered");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(orderedWidget, -HSPACE);
        data.top = new FormAttachment(orderedWidget, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
}
 

    
    @Override
    public void refresh() {
		orderedWidget.removeSelectionListener(nameListener);
		orderedWidget.setItems(getEnumerationFeatureValues());
		orderedWidget.setText(getFeatureAsText());
		orderedWidget.addSelectionListener(nameListener);
	}
    
   /**
	 * 
	 * @return An Array of all the String representations of Multiplicity enumeration values
	 */
	protected String[] getEnumerationFeatureValues() {
String[] ret = new String[] {"false", "true"};
		return ret;
	}
//        value = ( bc.isOrdered() ? "true" : "false" );

	/**
	 * 
	 * @return The string representation of the current value of 'sourceMultiplicity' of the selected Association
	 */
	protected String getFeatureAsText() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a Association
			if (bo == null) {
				return "unknown ";
			}
			bc = (Association) bo;
	return ( bc.isOrdered() ? "true" : "false" );
		}
		return "unknown ";
	}


	 
	private SelectionListener nameListener = new SelectionAdapter() {
        public void widgetSelected(SelectionEvent event) {
			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					changePropertyValue();
				}
			});
        }
    };

    protected void changePropertyValue(){
		int index = orderedWidget.getSelectionIndex();
boolean newValue = (index == 0 ? false : true);
			    	if( newValue != bc.isOrdered() ) { 
				    	bc.setOrdered(newValue );
			    	}
    }
}	