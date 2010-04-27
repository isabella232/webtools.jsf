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

package org.eclipse.jst.jsf.common.metadata.internal;

import org.eclipse.jst.jsf.common.metadata.query.internal.MetaDataQueryContextFactory;
import org.eclipse.jst.jsf.context.IModelContext;

/**
 * Domain context
 * <p>
 * @noimplement - see {@link MetaDataQueryContextFactory}
 *
 */
public interface IMetaDataDomainContext extends IModelContext{
	/**
	 * @return domain identifier for this context.  
	 */
	public String getDomainId();	
}
