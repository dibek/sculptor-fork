/*
 * Copyright 2013 The Sculptor Project Team, including the original 
 * author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sculptor.dsl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.sculptor.dsl.ui.hover.SculptordslEObjectDocumentationProvider;
import org.sculptor.dsl.ui.hover.SculptordslEObjectHoverProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class SculptordslUiModule extends org.sculptor.dsl.ui.AbstractSculptordslUiModule {
	public SculptordslUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SculptordslSemanticHighlightingCalculator.class;
	}

    public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
        return SculptordslEObjectHoverProvider.class;
    }
 
    public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
        return SculptordslEObjectDocumentationProvider.class;
    }

}
