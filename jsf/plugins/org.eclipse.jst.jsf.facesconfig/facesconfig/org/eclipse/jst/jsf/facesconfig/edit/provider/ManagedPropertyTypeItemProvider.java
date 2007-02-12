/***************************************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM Corporation - initial API and implementation
 *   Oracle Corporation - revision
 **************************************************************************************************/
package org.eclipse.jst.jsf.facesconfig.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jst.jsf.facesconfig.FacesConfigPlugin;
import org.eclipse.jst.jsf.facesconfig.emf.FacesConfigFactory;
import org.eclipse.jst.jsf.facesconfig.emf.FacesConfigPackage;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedPropertyType;

/**
 * This is the item provider adapter for a {@link org.eclipse.jst.jsf.facesconfig.emf.ManagedPropertyType} object.
 * <!-- begin-user-doc -->
 * @extends ITableItemLabelProvider
 * <!-- end-user-doc -->
 * @generated
 */
public class ManagedPropertyTypeItemProvider
	extends ItemProviderAdapter
	implements	
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider{
    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation and others";

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ManagedPropertyTypeItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public List getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addPropertyNamePropertyDescriptor(object);
            addPropertyClassPropertyDescriptor(object);
            addNullValuePropertyDescriptor(object);
            addValuePropertyDescriptor(object);
            addIdPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Property Name feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addPropertyNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ManagedPropertyType_propertyName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ManagedPropertyType_propertyName_feature", "_UI_ManagedPropertyType_type"),
                 FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__PROPERTY_NAME,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Property Class feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addPropertyClassPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ManagedPropertyType_propertyClass_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ManagedPropertyType_propertyClass_feature", "_UI_ManagedPropertyType_type"),
                 FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__PROPERTY_CLASS,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Null Value feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addNullValuePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ManagedPropertyType_nullValue_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ManagedPropertyType_nullValue_feature", "_UI_ManagedPropertyType_type"),
                 FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__NULL_VALUE,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Value feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addValuePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ManagedPropertyType_value_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ManagedPropertyType_value_feature", "_UI_ManagedPropertyType_type"),
                 FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__VALUE,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Id feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ManagedPropertyType_id_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ManagedPropertyType_id_feature", "_UI_ManagedPropertyType_type"),
                 FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__ID,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Collection getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__DESCRIPTION);
            childrenFeatures.add(FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__DISPLAY_NAME);
            childrenFeatures.add(FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__ICON);
            childrenFeatures.add(FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__MAP_ENTRIES);
            childrenFeatures.add(FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__LIST_ENTRIES);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns ManagedPropertyType.gif.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ManagedPropertyType"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated NOT
     */
	public String getText(Object object) {
        String label = ((ManagedPropertyType) object).getId();
        if (((ManagedPropertyType) object).getPropertyName() != null) {
            label = ((ManagedPropertyType) object).getPropertyName()
                    .getTextContent();
        }
        return label == null || label.length() == 0 ? getString("_UI_ManagedPropertyType_type")
                : label;

    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(ManagedPropertyType.class)) {
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__PROPERTY_NAME:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__PROPERTY_CLASS:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__NULL_VALUE:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__VALUE:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__ID:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__DESCRIPTION:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__DISPLAY_NAME:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__ICON:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__MAP_ENTRIES:
            case FacesConfigPackage.MANAGED_PROPERTY_TYPE__LIST_ENTRIES:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing all of the children that can be created under this object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__DESCRIPTION,
                 FacesConfigFactory.eINSTANCE.createDescriptionType()));

        newChildDescriptors.add
            (createChildParameter
                (FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__DISPLAY_NAME,
                 FacesConfigFactory.eINSTANCE.createDisplayNameType()));

        newChildDescriptors.add
            (createChildParameter
                (FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__ICON,
                 FacesConfigFactory.eINSTANCE.createIconType()));

        newChildDescriptors.add
            (createChildParameter
                (FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__MAP_ENTRIES,
                 FacesConfigFactory.eINSTANCE.createMapEntriesType()));

        newChildDescriptors.add
            (createChildParameter
                (FacesConfigPackage.Literals.MANAGED_PROPERTY_TYPE__LIST_ENTRIES,
                 FacesConfigFactory.eINSTANCE.createListEntriesType()));
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResourceLocator getResourceLocator() {
        return FacesConfigPlugin.INSTANCE;
    }

	public String getColumnText(Object object, int columnIndex) {
		ManagedPropertyType attribute = (ManagedPropertyType) object;
		switch (columnIndex) {

		case 0:
			return attribute.getPropertyName() == null ? "" : attribute
					.getPropertyName().getTextContent();
		case 1:
			return attribute.getPropertyClass() == null ? "" : attribute
					.getPropertyClass().getTextContent();
		case 2:
			if(attribute.getValue() != null)
			{
				return attribute.getValue().getTextContent();
			}
			else if(attribute.getNullValue() != null)
				return "<null-value>";
			else if(attribute.getMapEntries() != null)
				return "<map-entries>";
			else if(attribute.getListEntries() != null)
				return "<list-entries>";
			return "";
		}
		return null;
	}

	public Object getColumnImage(Object object, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
