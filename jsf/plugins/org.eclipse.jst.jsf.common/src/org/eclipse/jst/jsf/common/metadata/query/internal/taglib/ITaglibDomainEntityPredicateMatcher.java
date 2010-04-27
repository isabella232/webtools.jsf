/*******************************************************************************
 * Copyright (c) 2010 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oracle Corporation - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.jst.jsf.common.metadata.query.internal.taglib;

import org.eclipse.jst.jsf.common.metadata.query.internal.IEntityPredicateMatcher;

/**
 * Matches tag library entities
 */
public interface ITaglibDomainEntityPredicateMatcher extends IEntityPredicateMatcher {
	
	/**
	 * @return uri of the tag library - need this to determine model.   
	 * In the future, this may change if we allow for wild card search of models of a given domain
	 */
	public String getUri(); 
	
}
