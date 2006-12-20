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
package org.eclipse.jst.jsf.facesconfig.emf.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.emf.ecore.xml.type.impl.XMLTypePackageImpl;
import org.eclipse.jst.jsf.facesconfig.emf.ActionListenerType;
import org.eclipse.jst.jsf.facesconfig.emf.ApplicationFactoryType;
import org.eclipse.jst.jsf.facesconfig.emf.ApplicationType;
import org.eclipse.jst.jsf.facesconfig.emf.AttributeClassType;
import org.eclipse.jst.jsf.facesconfig.emf.AttributeExtensionType;
import org.eclipse.jst.jsf.facesconfig.emf.AttributeNameType;
import org.eclipse.jst.jsf.facesconfig.emf.AttributeType;
import org.eclipse.jst.jsf.facesconfig.emf.ComponentClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ComponentExtensionType;
import org.eclipse.jst.jsf.facesconfig.emf.ComponentFamilyType;
import org.eclipse.jst.jsf.facesconfig.emf.ComponentType;
import org.eclipse.jst.jsf.facesconfig.emf.ComponentTypeType;
import org.eclipse.jst.jsf.facesconfig.emf.ConverterClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ConverterForClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ConverterIdType;
import org.eclipse.jst.jsf.facesconfig.emf.ConverterType;
import org.eclipse.jst.jsf.facesconfig.emf.DefaultLocaleType;
import org.eclipse.jst.jsf.facesconfig.emf.DefaultRenderKitIdType;
import org.eclipse.jst.jsf.facesconfig.emf.DefaultValueType;
import org.eclipse.jst.jsf.facesconfig.emf.DescriptionType;
import org.eclipse.jst.jsf.facesconfig.emf.DisplayNameType;
import org.eclipse.jst.jsf.facesconfig.emf.DocumentRoot;
import org.eclipse.jst.jsf.facesconfig.emf.DynamicAttribute;
import org.eclipse.jst.jsf.facesconfig.emf.DynamicElement;
import org.eclipse.jst.jsf.facesconfig.emf.ExtensionType;
import org.eclipse.jst.jsf.facesconfig.emf.FacesConfigFactory;
import org.eclipse.jst.jsf.facesconfig.emf.FacesConfigPackage;
import org.eclipse.jst.jsf.facesconfig.emf.FacesConfigType;
import org.eclipse.jst.jsf.facesconfig.emf.FacesContextFactoryType;
import org.eclipse.jst.jsf.facesconfig.emf.FacetExtensionType;
import org.eclipse.jst.jsf.facesconfig.emf.FacetNameType;
import org.eclipse.jst.jsf.facesconfig.emf.FacetType;
import org.eclipse.jst.jsf.facesconfig.emf.FactoryType;
import org.eclipse.jst.jsf.facesconfig.emf.FromActionType;
import org.eclipse.jst.jsf.facesconfig.emf.FromOutcomeType;
import org.eclipse.jst.jsf.facesconfig.emf.FromViewIdType;
import org.eclipse.jst.jsf.facesconfig.emf.IconType;
import org.eclipse.jst.jsf.facesconfig.emf.KeyClassType;
import org.eclipse.jst.jsf.facesconfig.emf.KeyType;
import org.eclipse.jst.jsf.facesconfig.emf.LargeIconType;
import org.eclipse.jst.jsf.facesconfig.emf.LifecycleFactoryType;
import org.eclipse.jst.jsf.facesconfig.emf.LifecycleType;
import org.eclipse.jst.jsf.facesconfig.emf.ListEntriesType;
import org.eclipse.jst.jsf.facesconfig.emf.LocaleConfigType;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedBeanClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedBeanNameType;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedBeanScopeType;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedBeanType;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedPropertyType;
import org.eclipse.jst.jsf.facesconfig.emf.MapEntriesType;
import org.eclipse.jst.jsf.facesconfig.emf.MapEntryType;
import org.eclipse.jst.jsf.facesconfig.emf.MessageBundleType;
import org.eclipse.jst.jsf.facesconfig.emf.NavigationCaseType;
import org.eclipse.jst.jsf.facesconfig.emf.NavigationHandlerType;
import org.eclipse.jst.jsf.facesconfig.emf.NavigationRuleType;
import org.eclipse.jst.jsf.facesconfig.emf.NullValueType;
import org.eclipse.jst.jsf.facesconfig.emf.PhaseListenerType;
import org.eclipse.jst.jsf.facesconfig.emf.PropertyClassType;
import org.eclipse.jst.jsf.facesconfig.emf.PropertyExtensionType;
import org.eclipse.jst.jsf.facesconfig.emf.PropertyNameType;
import org.eclipse.jst.jsf.facesconfig.emf.PropertyResolverType;
import org.eclipse.jst.jsf.facesconfig.emf.PropertyType;
import org.eclipse.jst.jsf.facesconfig.emf.RedirectType;
import org.eclipse.jst.jsf.facesconfig.emf.ReferencedBeanClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ReferencedBeanNameType;
import org.eclipse.jst.jsf.facesconfig.emf.ReferencedBeanType;
import org.eclipse.jst.jsf.facesconfig.emf.RenderKitClassType;
import org.eclipse.jst.jsf.facesconfig.emf.RenderKitFactoryType;
import org.eclipse.jst.jsf.facesconfig.emf.RenderKitIdType;
import org.eclipse.jst.jsf.facesconfig.emf.RenderKitType;
import org.eclipse.jst.jsf.facesconfig.emf.RendererClassType;
import org.eclipse.jst.jsf.facesconfig.emf.RendererExtensionType;
import org.eclipse.jst.jsf.facesconfig.emf.RendererType;
import org.eclipse.jst.jsf.facesconfig.emf.RendererTypeType;
import org.eclipse.jst.jsf.facesconfig.emf.SmallIconType;
import org.eclipse.jst.jsf.facesconfig.emf.StateManagerType;
import org.eclipse.jst.jsf.facesconfig.emf.SuggestedValueType;
import org.eclipse.jst.jsf.facesconfig.emf.SupportedLocaleType;
import org.eclipse.jst.jsf.facesconfig.emf.ToViewIdType;
import org.eclipse.jst.jsf.facesconfig.emf.ValidatorClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ValidatorIdType;
import org.eclipse.jst.jsf.facesconfig.emf.ValidatorType;
import org.eclipse.jst.jsf.facesconfig.emf.ValueClassType;
import org.eclipse.jst.jsf.facesconfig.emf.ValueType;
import org.eclipse.jst.jsf.facesconfig.emf.VariableResolverType;
import org.eclipse.jst.jsf.facesconfig.emf.ViewHandlerType;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FacesConfigPackageImpl extends EPackageImpl implements FacesConfigPackage {
    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation and others";

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass actionListenerTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass applicationFactoryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass applicationTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeExtensionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeNameTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass componentClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass componentExtensionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass componentFamilyTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass componentTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass componentTypeTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass converterClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass converterForClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass converterIdTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass converterTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass defaultLocaleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass defaultRenderKitIdTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass defaultValueTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass descriptionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass displayNameTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dynamicAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dynamicElementEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass facesConfigTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass facesContextFactoryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass facetExtensionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass facetNameTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass facetTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass factoryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass fromActionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass fromOutcomeTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass fromViewIdTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass iconTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass keyClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass keyTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass largeIconTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass lifecycleFactoryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass lifecycleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass listEntriesTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass localeConfigTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass managedBeanClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass managedBeanNameTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass managedBeanScopeTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass managedBeanTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass managedPropertyTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass mapEntriesTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass mapEntryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass messageBundleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass navigationCaseTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass navigationHandlerTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass navigationRuleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass nullValueTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass phaseListenerTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyExtensionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyNameTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyResolverTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass redirectTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass referencedBeanClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass referencedBeanNameTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass referencedBeanTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass rendererClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass rendererExtensionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass rendererTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass rendererTypeTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass renderKitClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass renderKitFactoryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass renderKitIdTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass renderKitTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass smallIconTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stateManagerTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass suggestedValueTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass supportedLocaleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass toViewIdTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass validatorClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass validatorIdTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass validatorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass valueClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass valueTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass variableResolverTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass viewHandlerTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass extensionTypeEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.jst.jsf.facesconfig.emf.FacesConfigPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private FacesConfigPackageImpl() {
        super(eNS_URI, FacesConfigFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static FacesConfigPackage init() {
        if (isInited) return (FacesConfigPackage)EPackage.Registry.INSTANCE.getEPackage(FacesConfigPackage.eNS_URI);

        // Obtain or create and register package
        FacesConfigPackageImpl theFacesConfigPackage = (FacesConfigPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof FacesConfigPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new FacesConfigPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theFacesConfigPackage.createPackageContents();

        // Initialize created meta-data
        theFacesConfigPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFacesConfigPackage.freeze();

        return theFacesConfigPackage;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getActionListenerType() {
        return actionListenerTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getActionListenerType_TextContent() {
        return (EAttribute)actionListenerTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getActionListenerType_Id() {
        return (EAttribute)actionListenerTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getApplicationFactoryType() {
        return applicationFactoryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationFactoryType_TextContent() {
        return (EAttribute)applicationFactoryTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationFactoryType_Id() {
        return (EAttribute)applicationFactoryTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getApplicationType() {
        return applicationTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_ActionListener() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_DefaultRenderKitId() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_MessageBundle() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_NavigationHandler() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_ViewHandler() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_StateManager() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_PropertyResolver() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_VariableResolver() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_LocaleConfig() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationType_Id() {
        return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttributeClassType() {
        return attributeClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeClassType_TextContent() {
        return (EAttribute)attributeClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeClassType_Id() {
        return (EAttribute)attributeClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttributeExtensionType() {
        return attributeExtensionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttributeNameType() {
        return attributeNameTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeNameType_TextContent() {
        return (EAttribute)attributeNameTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeNameType_Id() {
        return (EAttribute)attributeNameTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttributeType() {
        return attributeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_Description() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_DisplayName() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_Icon() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_AttributeName() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_AttributeClass() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_DefaultValue() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_SuggestedValue() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAttributeType_AttributeExtension() {
        return (EReference)attributeTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeType_Id() {
        return (EAttribute)attributeTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getComponentClassType() {
        return componentClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentClassType_TextContent() {
        return (EAttribute)componentClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentClassType_Id() {
        return (EAttribute)componentClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getComponentExtensionType() {
        return componentExtensionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getComponentFamilyType() {
        return componentFamilyTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentFamilyType_TextContent() {
        return (EAttribute)componentFamilyTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentFamilyType_Id() {
        return (EAttribute)componentFamilyTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getComponentType() {
        return componentTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_Description() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_DisplayName() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_Icon() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_ComponentType() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_ComponentClass() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_Facet() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_Attribute() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_Property() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getComponentType_ComponentExtension() {
        return (EReference)componentTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentType_Id() {
        return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getComponentTypeType() {
        return componentTypeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentTypeType_TextContent() {
        return (EAttribute)componentTypeTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getComponentTypeType_Id() {
        return (EAttribute)componentTypeTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConverterClassType() {
        return converterClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterClassType_TextContent() {
        return (EAttribute)converterClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterClassType_Id() {
        return (EAttribute)converterClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConverterForClassType() {
        return converterForClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterForClassType_TextContent() {
        return (EAttribute)converterForClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterForClassType_Id() {
        return (EAttribute)converterForClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConverterIdType() {
        return converterIdTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterIdType_TextContent() {
        return (EAttribute)converterIdTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterIdType_Id() {
        return (EAttribute)converterIdTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConverterType() {
        return converterTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_Description() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_DisplayName() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_Icon() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_ConverterId() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_ConverterForClass() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_ConverterClass() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_Attribute() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterType_Property() {
        return (EReference)converterTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConverterType_Id() {
        return (EAttribute)converterTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDefaultLocaleType() {
        return defaultLocaleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDefaultLocaleType_TextContent() {
        return (EAttribute)defaultLocaleTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDefaultLocaleType_Id() {
        return (EAttribute)defaultLocaleTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDefaultRenderKitIdType() {
        return defaultRenderKitIdTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDefaultRenderKitIdType_TextContent() {
        return (EAttribute)defaultRenderKitIdTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDefaultRenderKitIdType_Id() {
        return (EAttribute)defaultRenderKitIdTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDefaultValueType() {
        return defaultValueTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDefaultValueType_TextContent() {
        return (EAttribute)defaultValueTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDefaultValueType_Id() {
        return (EAttribute)defaultValueTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDescriptionType() {
        return descriptionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDescriptionType_TextContent() {
        return (EAttribute)descriptionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDescriptionType_Lang() {
        return (EAttribute)descriptionTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDescriptionType_Id() {
        return (EAttribute)descriptionTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDisplayNameType() {
        return displayNameTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDisplayNameType_TextContent() {
        return (EAttribute)displayNameTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDisplayNameType_Lang() {
        return (EAttribute)displayNameTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDisplayNameType_Id() {
        return (EAttribute)displayNameTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDocumentRoot() {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ActionListener() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Application() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ApplicationFactory() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Attribute() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_AttributeClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_AttributeExtension() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_AttributeName() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Component() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ComponentClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ComponentExtension() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ComponentFamily() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ComponentType() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Converter() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ConverterClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ConverterForClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ConverterId() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_DefaultLocale() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_DefaultRenderKitId() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_DefaultValue() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Description() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_DisplayName() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FacesConfig() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FacesContextFactory() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Facet() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FacetExtension() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FacetName() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Factory() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FromAction() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FromOutcome() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_FromViewId() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(32);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Icon() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(33);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Key() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(34);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_KeyClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(35);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_LargeIcon() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(36);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Lifecycle() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(37);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_LifecycleFactory() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(38);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ListEntries() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(39);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_LocaleConfig() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(40);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ManagedBean() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(41);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ManagedBeanClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(42);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ManagedBeanName() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(43);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ManagedBeanScope() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(44);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ManagedProperty() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(45);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_MapEntries() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(46);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_MapEntry() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(47);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_MessageBundle() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(48);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_NavigationCase() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(49);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_NavigationHandler() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(50);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_NavigationRule() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(51);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_NullValue() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(52);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_PhaseListener() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(53);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Property() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(54);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_PropertyClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(55);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_PropertyExtension() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(56);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_PropertyName() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(57);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_PropertyResolver() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(58);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Redirect() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(59);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ReferencedBean() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(60);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ReferencedBeanClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(61);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ReferencedBeanName() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(62);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Renderer() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(63);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RendererClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(64);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RendererExtension() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(65);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RendererType() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(66);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RenderKit() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(67);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RenderKitClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(68);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RenderKitFactory() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(69);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_RenderKitId() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(70);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_SmallIcon() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(71);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_StateManager() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(72);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_SuggestedValue() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(73);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_SupportedLocale() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(74);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ToViewId() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(75);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Validator() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(76);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ValidatorClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(77);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ValidatorId() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(78);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Value() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(79);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ValueClass() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(80);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_VariableResolver() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(81);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_ViewHandler() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(82);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDynamicAttribute() {
        return dynamicAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDynamicAttribute_Name() {
        return (EAttribute)dynamicAttributeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDynamicAttribute_Value() {
        return (EAttribute)dynamicAttributeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDynamicElement() {
        return dynamicElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDynamicElement_ChildNodes() {
        return (EReference)dynamicElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDynamicElement_Attributes() {
        return (EReference)dynamicElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDynamicElement_TextContent() {
        return (EAttribute)dynamicElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDynamicElement_Name() {
        return (EAttribute)dynamicElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFacesConfigType() {
        return facesConfigTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_Application() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_Factory() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_Component() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_Converter() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_ManagedBean() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_NavigationRule() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_ReferencedBean() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_RenderKit() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_Lifecycle() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacesConfigType_Validator() {
        return (EReference)facesConfigTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacesConfigType_Xmlns() {
        return (EAttribute)facesConfigTypeEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacesConfigType_Id() {
        return (EAttribute)facesConfigTypeEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFacesContextFactoryType() {
        return facesContextFactoryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacesContextFactoryType_TextContent() {
        return (EAttribute)facesContextFactoryTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacesContextFactoryType_Id() {
        return (EAttribute)facesContextFactoryTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFacetExtensionType() {
        return facetExtensionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFacetNameType() {
        return facetNameTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacetNameType_TextContent() {
        return (EAttribute)facetNameTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacetNameType_Id() {
        return (EAttribute)facetNameTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFacetType() {
        return facetTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacetType_Description() {
        return (EReference)facetTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacetType_DisplayName() {
        return (EReference)facetTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacetType_Icon() {
        return (EReference)facetTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacetType_FacetName() {
        return (EReference)facetTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFacetType_FacetExtension() {
        return (EReference)facetTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFacetType_Id() {
        return (EAttribute)facetTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFactoryType() {
        return factoryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFactoryType_ApplicationFactory() {
        return (EReference)factoryTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFactoryType_FacesContextFactory() {
        return (EReference)factoryTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFactoryType_LifecycleFactory() {
        return (EReference)factoryTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFactoryType_RenderKitFactory() {
        return (EReference)factoryTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFactoryType_Id() {
        return (EAttribute)factoryTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFromActionType() {
        return fromActionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFromActionType_TextContent() {
        return (EAttribute)fromActionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFromActionType_Id() {
        return (EAttribute)fromActionTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFromOutcomeType() {
        return fromOutcomeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFromOutcomeType_TextContent() {
        return (EAttribute)fromOutcomeTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFromOutcomeType_Id() {
        return (EAttribute)fromOutcomeTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFromViewIdType() {
        return fromViewIdTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFromViewIdType_TextContent() {
        return (EAttribute)fromViewIdTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFromViewIdType_Id() {
        return (EAttribute)fromViewIdTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIconType() {
        return iconTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIconType_SmallIcon() {
        return (EReference)iconTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIconType_LargeIcon() {
        return (EReference)iconTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIconType_Lang() {
        return (EAttribute)iconTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIconType_Id() {
        return (EAttribute)iconTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getKeyClassType() {
        return keyClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getKeyClassType_TextContent() {
        return (EAttribute)keyClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getKeyClassType_Id() {
        return (EAttribute)keyClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getKeyType() {
        return keyTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getKeyType_TextContent() {
        return (EAttribute)keyTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getKeyType_Id() {
        return (EAttribute)keyTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLargeIconType() {
        return largeIconTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLargeIconType_TextContent() {
        return (EAttribute)largeIconTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLargeIconType_Id() {
        return (EAttribute)largeIconTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLifecycleFactoryType() {
        return lifecycleFactoryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLifecycleFactoryType_TextContent() {
        return (EAttribute)lifecycleFactoryTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLifecycleFactoryType_Id() {
        return (EAttribute)lifecycleFactoryTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLifecycleType() {
        return lifecycleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLifecycleType_PhaseListener() {
        return (EReference)lifecycleTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLifecycleType_Id() {
        return (EAttribute)lifecycleTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getListEntriesType() {
        return listEntriesTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getListEntriesType_ValueClass() {
        return (EReference)listEntriesTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getListEntriesType_NullValue() {
        return (EReference)listEntriesTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getListEntriesType_Value() {
        return (EReference)listEntriesTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getListEntriesType_Id() {
        return (EAttribute)listEntriesTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLocaleConfigType() {
        return localeConfigTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLocaleConfigType_DefaultLocale() {
        return (EReference)localeConfigTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLocaleConfigType_SupportedLocale() {
        return (EReference)localeConfigTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLocaleConfigType_Id() {
        return (EAttribute)localeConfigTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getManagedBeanClassType() {
        return managedBeanClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanClassType_TextContent() {
        return (EAttribute)managedBeanClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanClassType_Id() {
        return (EAttribute)managedBeanClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getManagedBeanNameType() {
        return managedBeanNameTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanNameType_TextContent() {
        return (EAttribute)managedBeanNameTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanNameType_Id() {
        return (EAttribute)managedBeanNameTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getManagedBeanScopeType() {
        return managedBeanScopeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanScopeType_TextContent() {
        return (EAttribute)managedBeanScopeTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanScopeType_Id() {
        return (EAttribute)managedBeanScopeTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getManagedBeanType() {
        return managedBeanTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_Description() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_DisplayName() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_Icon() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_ManagedBeanName() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_ManagedBeanClass() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_ManagedBeanScope() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_ManagedProperty() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_MapEntries() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedBeanType_ListEntries() {
        return (EReference)managedBeanTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedBeanType_Id() {
        return (EAttribute)managedBeanTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getManagedPropertyType() {
        return managedPropertyTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_Description() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_DisplayName() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_Icon() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_PropertyName() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_PropertyClass() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_MapEntries() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_NullValue() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_Value() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getManagedPropertyType_ListEntries() {
        return (EReference)managedPropertyTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getManagedPropertyType_Id() {
        return (EAttribute)managedPropertyTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMapEntriesType() {
        return mapEntriesTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMapEntriesType_KeyClass() {
        return (EReference)mapEntriesTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMapEntriesType_ValueClass() {
        return (EReference)mapEntriesTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMapEntriesType_MapEntry() {
        return (EReference)mapEntriesTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMapEntriesType_Id() {
        return (EAttribute)mapEntriesTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMapEntryType() {
        return mapEntryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMapEntryType_Key() {
        return (EReference)mapEntryTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMapEntryType_NullValue() {
        return (EReference)mapEntryTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMapEntryType_Value() {
        return (EReference)mapEntryTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMapEntryType_Id() {
        return (EAttribute)mapEntryTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMessageBundleType() {
        return messageBundleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMessageBundleType_TextContent() {
        return (EAttribute)messageBundleTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMessageBundleType_Id() {
        return (EAttribute)messageBundleTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNavigationCaseType() {
        return navigationCaseTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_Description() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_DisplayName() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_Icon() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_FromAction() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_FromOutcome() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_ToViewId() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCaseType_Redirect() {
        return (EReference)navigationCaseTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNavigationCaseType_Id() {
        return (EAttribute)navigationCaseTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNavigationHandlerType() {
        return navigationHandlerTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNavigationHandlerType_TextContent() {
        return (EAttribute)navigationHandlerTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNavigationHandlerType_Id() {
        return (EAttribute)navigationHandlerTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNavigationRuleType() {
        return navigationRuleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationRuleType_Description() {
        return (EReference)navigationRuleTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationRuleType_DisplayName() {
        return (EReference)navigationRuleTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationRuleType_Icon() {
        return (EReference)navigationRuleTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationRuleType_FromViewId() {
        return (EReference)navigationRuleTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationRuleType_NavigationCase() {
        return (EReference)navigationRuleTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNavigationRuleType_Id() {
        return (EAttribute)navigationRuleTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNullValueType() {
        return nullValueTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNullValueType_Id() {
        return (EAttribute)nullValueTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPhaseListenerType() {
        return phaseListenerTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPhaseListenerType_TextContent() {
        return (EAttribute)phaseListenerTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPhaseListenerType_Id() {
        return (EAttribute)phaseListenerTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyClassType() {
        return propertyClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyClassType_TextContent() {
        return (EAttribute)propertyClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyClassType_Id() {
        return (EAttribute)propertyClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyExtensionType() {
        return propertyExtensionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyNameType() {
        return propertyNameTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyNameType_TextContent() {
        return (EAttribute)propertyNameTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyNameType_Id() {
        return (EAttribute)propertyNameTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyResolverType() {
        return propertyResolverTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyResolverType_TextContent() {
        return (EAttribute)propertyResolverTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyResolverType_Id() {
        return (EAttribute)propertyResolverTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyType() {
        return propertyTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_Description() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_DisplayName() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_Icon() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_PropertyName() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_PropertyClass() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_DefaultValue() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_SuggestedValue() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyType_PropertyExtension() {
        return (EReference)propertyTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPropertyType_Id() {
        return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRedirectType() {
        return redirectTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRedirectType_Id() {
        return (EAttribute)redirectTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getReferencedBeanClassType() {
        return referencedBeanClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReferencedBeanClassType_TextContent() {
        return (EAttribute)referencedBeanClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReferencedBeanClassType_Id() {
        return (EAttribute)referencedBeanClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getReferencedBeanNameType() {
        return referencedBeanNameTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReferencedBeanNameType_TextContent() {
        return (EAttribute)referencedBeanNameTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReferencedBeanNameType_Id() {
        return (EAttribute)referencedBeanNameTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getReferencedBeanType() {
        return referencedBeanTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReferencedBeanType_Description() {
        return (EReference)referencedBeanTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReferencedBeanType_DisplayName() {
        return (EReference)referencedBeanTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReferencedBeanType_Icon() {
        return (EReference)referencedBeanTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReferencedBeanType_ReferencedBeanName() {
        return (EReference)referencedBeanTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReferencedBeanType_ReferencedBeanClass() {
        return (EReference)referencedBeanTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReferencedBeanType_Id() {
        return (EAttribute)referencedBeanTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRendererClassType() {
        return rendererClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRendererClassType_TextContent() {
        return (EAttribute)rendererClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRendererClassType_Id() {
        return (EAttribute)rendererClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRendererExtensionType() {
        return rendererExtensionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRendererType() {
        return rendererTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_Description() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_DisplayName() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_Icon() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_ComponentFamily() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_RendererType() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_RendererClass() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_Facet() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_Attribute() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRendererType_RendererExtension() {
        return (EReference)rendererTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRendererType_Id() {
        return (EAttribute)rendererTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRendererTypeType() {
        return rendererTypeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRendererTypeType_TextContent() {
        return (EAttribute)rendererTypeTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRendererTypeType_Id() {
        return (EAttribute)rendererTypeTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRenderKitClassType() {
        return renderKitClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitClassType_TextContent() {
        return (EAttribute)renderKitClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitClassType_Id() {
        return (EAttribute)renderKitClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRenderKitFactoryType() {
        return renderKitFactoryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitFactoryType_TextContent() {
        return (EAttribute)renderKitFactoryTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitFactoryType_Id() {
        return (EAttribute)renderKitFactoryTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRenderKitIdType() {
        return renderKitIdTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitIdType_TextContent() {
        return (EAttribute)renderKitIdTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitIdType_Id() {
        return (EAttribute)renderKitIdTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRenderKitType() {
        return renderKitTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRenderKitType_Description() {
        return (EReference)renderKitTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRenderKitType_DisplayName() {
        return (EReference)renderKitTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRenderKitType_Icon() {
        return (EReference)renderKitTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRenderKitType_RenderKitId() {
        return (EReference)renderKitTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRenderKitType_RenderKitClass() {
        return (EReference)renderKitTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRenderKitType_Renderer() {
        return (EReference)renderKitTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRenderKitType_Id() {
        return (EAttribute)renderKitTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSmallIconType() {
        return smallIconTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSmallIconType_TextContent() {
        return (EAttribute)smallIconTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSmallIconType_Id() {
        return (EAttribute)smallIconTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStateManagerType() {
        return stateManagerTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getStateManagerType_TextContent() {
        return (EAttribute)stateManagerTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getStateManagerType_Id() {
        return (EAttribute)stateManagerTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSuggestedValueType() {
        return suggestedValueTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSuggestedValueType_TextContent() {
        return (EAttribute)suggestedValueTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSuggestedValueType_Id() {
        return (EAttribute)suggestedValueTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSupportedLocaleType() {
        return supportedLocaleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSupportedLocaleType_TextContent() {
        return (EAttribute)supportedLocaleTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSupportedLocaleType_Id() {
        return (EAttribute)supportedLocaleTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getToViewIdType() {
        return toViewIdTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getToViewIdType_TextContent() {
        return (EAttribute)toViewIdTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getToViewIdType_Id() {
        return (EAttribute)toViewIdTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getValidatorClassType() {
        return validatorClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValidatorClassType_TextContent() {
        return (EAttribute)validatorClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValidatorClassType_Id() {
        return (EAttribute)validatorClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getValidatorIdType() {
        return validatorIdTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValidatorIdType_TextContent() {
        return (EAttribute)validatorIdTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValidatorIdType_Id() {
        return (EAttribute)validatorIdTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getValidatorType() {
        return validatorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_Description() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_DisplayName() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_Icon() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_ValidatorId() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_ValidatorClass() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_Attribute() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getValidatorType_Property() {
        return (EReference)validatorTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValidatorType_Id() {
        return (EAttribute)validatorTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getValueClassType() {
        return valueClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValueClassType_TextContent() {
        return (EAttribute)valueClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValueClassType_Id() {
        return (EAttribute)valueClassTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getValueType() {
        return valueTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValueType_TextContent() {
        return (EAttribute)valueTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValueType_Id() {
        return (EAttribute)valueTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVariableResolverType() {
        return variableResolverTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getVariableResolverType_TextContent() {
        return (EAttribute)variableResolverTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getVariableResolverType_Id() {
        return (EAttribute)variableResolverTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getViewHandlerType() {
        return viewHandlerTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getViewHandlerType_TextContent() {
        return (EAttribute)viewHandlerTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getViewHandlerType_Id() {
        return (EAttribute)viewHandlerTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExtensionType() {
        return extensionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExtensionType_ChildNodes() {
        return (EReference)extensionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExtensionType_TextContent() {
        return (EAttribute)extensionTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExtensionType_Id() {
        return (EAttribute)extensionTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FacesConfigFactory getFacesConfigFactory() {
        return (FacesConfigFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        actionListenerTypeEClass = createEClass(ACTION_LISTENER_TYPE);
        createEAttribute(actionListenerTypeEClass, ACTION_LISTENER_TYPE__TEXT_CONTENT);
        createEAttribute(actionListenerTypeEClass, ACTION_LISTENER_TYPE__ID);

        applicationFactoryTypeEClass = createEClass(APPLICATION_FACTORY_TYPE);
        createEAttribute(applicationFactoryTypeEClass, APPLICATION_FACTORY_TYPE__TEXT_CONTENT);
        createEAttribute(applicationFactoryTypeEClass, APPLICATION_FACTORY_TYPE__ID);

        applicationTypeEClass = createEClass(APPLICATION_TYPE);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__ACTION_LISTENER);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__DEFAULT_RENDER_KIT_ID);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__MESSAGE_BUNDLE);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__NAVIGATION_HANDLER);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__VIEW_HANDLER);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__STATE_MANAGER);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__PROPERTY_RESOLVER);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__VARIABLE_RESOLVER);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__LOCALE_CONFIG);
        createEAttribute(applicationTypeEClass, APPLICATION_TYPE__ID);

        attributeClassTypeEClass = createEClass(ATTRIBUTE_CLASS_TYPE);
        createEAttribute(attributeClassTypeEClass, ATTRIBUTE_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(attributeClassTypeEClass, ATTRIBUTE_CLASS_TYPE__ID);

        attributeExtensionTypeEClass = createEClass(ATTRIBUTE_EXTENSION_TYPE);

        attributeNameTypeEClass = createEClass(ATTRIBUTE_NAME_TYPE);
        createEAttribute(attributeNameTypeEClass, ATTRIBUTE_NAME_TYPE__TEXT_CONTENT);
        createEAttribute(attributeNameTypeEClass, ATTRIBUTE_NAME_TYPE__ID);

        attributeTypeEClass = createEClass(ATTRIBUTE_TYPE);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__DESCRIPTION);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__DISPLAY_NAME);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__ICON);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__ATTRIBUTE_NAME);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__ATTRIBUTE_CLASS);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__DEFAULT_VALUE);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__SUGGESTED_VALUE);
        createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__ATTRIBUTE_EXTENSION);
        createEAttribute(attributeTypeEClass, ATTRIBUTE_TYPE__ID);

        componentClassTypeEClass = createEClass(COMPONENT_CLASS_TYPE);
        createEAttribute(componentClassTypeEClass, COMPONENT_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(componentClassTypeEClass, COMPONENT_CLASS_TYPE__ID);

        componentExtensionTypeEClass = createEClass(COMPONENT_EXTENSION_TYPE);

        componentFamilyTypeEClass = createEClass(COMPONENT_FAMILY_TYPE);
        createEAttribute(componentFamilyTypeEClass, COMPONENT_FAMILY_TYPE__TEXT_CONTENT);
        createEAttribute(componentFamilyTypeEClass, COMPONENT_FAMILY_TYPE__ID);

        componentTypeEClass = createEClass(COMPONENT_TYPE);
        createEReference(componentTypeEClass, COMPONENT_TYPE__DESCRIPTION);
        createEReference(componentTypeEClass, COMPONENT_TYPE__DISPLAY_NAME);
        createEReference(componentTypeEClass, COMPONENT_TYPE__ICON);
        createEReference(componentTypeEClass, COMPONENT_TYPE__COMPONENT_TYPE);
        createEReference(componentTypeEClass, COMPONENT_TYPE__COMPONENT_CLASS);
        createEReference(componentTypeEClass, COMPONENT_TYPE__FACET);
        createEReference(componentTypeEClass, COMPONENT_TYPE__ATTRIBUTE);
        createEReference(componentTypeEClass, COMPONENT_TYPE__PROPERTY);
        createEReference(componentTypeEClass, COMPONENT_TYPE__COMPONENT_EXTENSION);
        createEAttribute(componentTypeEClass, COMPONENT_TYPE__ID);

        componentTypeTypeEClass = createEClass(COMPONENT_TYPE_TYPE);
        createEAttribute(componentTypeTypeEClass, COMPONENT_TYPE_TYPE__TEXT_CONTENT);
        createEAttribute(componentTypeTypeEClass, COMPONENT_TYPE_TYPE__ID);

        converterClassTypeEClass = createEClass(CONVERTER_CLASS_TYPE);
        createEAttribute(converterClassTypeEClass, CONVERTER_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(converterClassTypeEClass, CONVERTER_CLASS_TYPE__ID);

        converterForClassTypeEClass = createEClass(CONVERTER_FOR_CLASS_TYPE);
        createEAttribute(converterForClassTypeEClass, CONVERTER_FOR_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(converterForClassTypeEClass, CONVERTER_FOR_CLASS_TYPE__ID);

        converterIdTypeEClass = createEClass(CONVERTER_ID_TYPE);
        createEAttribute(converterIdTypeEClass, CONVERTER_ID_TYPE__TEXT_CONTENT);
        createEAttribute(converterIdTypeEClass, CONVERTER_ID_TYPE__ID);

        converterTypeEClass = createEClass(CONVERTER_TYPE);
        createEReference(converterTypeEClass, CONVERTER_TYPE__DESCRIPTION);
        createEReference(converterTypeEClass, CONVERTER_TYPE__DISPLAY_NAME);
        createEReference(converterTypeEClass, CONVERTER_TYPE__ICON);
        createEReference(converterTypeEClass, CONVERTER_TYPE__CONVERTER_ID);
        createEReference(converterTypeEClass, CONVERTER_TYPE__CONVERTER_FOR_CLASS);
        createEReference(converterTypeEClass, CONVERTER_TYPE__CONVERTER_CLASS);
        createEReference(converterTypeEClass, CONVERTER_TYPE__ATTRIBUTE);
        createEReference(converterTypeEClass, CONVERTER_TYPE__PROPERTY);
        createEAttribute(converterTypeEClass, CONVERTER_TYPE__ID);

        defaultLocaleTypeEClass = createEClass(DEFAULT_LOCALE_TYPE);
        createEAttribute(defaultLocaleTypeEClass, DEFAULT_LOCALE_TYPE__TEXT_CONTENT);
        createEAttribute(defaultLocaleTypeEClass, DEFAULT_LOCALE_TYPE__ID);

        defaultRenderKitIdTypeEClass = createEClass(DEFAULT_RENDER_KIT_ID_TYPE);
        createEAttribute(defaultRenderKitIdTypeEClass, DEFAULT_RENDER_KIT_ID_TYPE__TEXT_CONTENT);
        createEAttribute(defaultRenderKitIdTypeEClass, DEFAULT_RENDER_KIT_ID_TYPE__ID);

        defaultValueTypeEClass = createEClass(DEFAULT_VALUE_TYPE);
        createEAttribute(defaultValueTypeEClass, DEFAULT_VALUE_TYPE__TEXT_CONTENT);
        createEAttribute(defaultValueTypeEClass, DEFAULT_VALUE_TYPE__ID);

        descriptionTypeEClass = createEClass(DESCRIPTION_TYPE);
        createEAttribute(descriptionTypeEClass, DESCRIPTION_TYPE__TEXT_CONTENT);
        createEAttribute(descriptionTypeEClass, DESCRIPTION_TYPE__LANG);
        createEAttribute(descriptionTypeEClass, DESCRIPTION_TYPE__ID);

        displayNameTypeEClass = createEClass(DISPLAY_NAME_TYPE);
        createEAttribute(displayNameTypeEClass, DISPLAY_NAME_TYPE__TEXT_CONTENT);
        createEAttribute(displayNameTypeEClass, DISPLAY_NAME_TYPE__LANG);
        createEAttribute(displayNameTypeEClass, DISPLAY_NAME_TYPE__ID);

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ACTION_LISTENER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__APPLICATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__APPLICATION_FACTORY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ATTRIBUTE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ATTRIBUTE_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ATTRIBUTE_EXTENSION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ATTRIBUTE_NAME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT_EXTENSION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT_FAMILY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT_TYPE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERTER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERTER_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERTER_FOR_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERTER_ID);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DEFAULT_LOCALE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DEFAULT_RENDER_KIT_ID);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DEFAULT_VALUE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DESCRIPTION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DISPLAY_NAME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FACES_CONFIG);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FACES_CONTEXT_FACTORY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FACET);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FACET_EXTENSION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FACET_NAME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FACTORY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FROM_ACTION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FROM_OUTCOME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FROM_VIEW_ID);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ICON);
        createEReference(documentRootEClass, DOCUMENT_ROOT__KEY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__KEY_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__LARGE_ICON);
        createEReference(documentRootEClass, DOCUMENT_ROOT__LIFECYCLE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__LIFECYCLE_FACTORY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__LIST_ENTRIES);
        createEReference(documentRootEClass, DOCUMENT_ROOT__LOCALE_CONFIG);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MANAGED_BEAN);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MANAGED_BEAN_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MANAGED_BEAN_NAME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MANAGED_BEAN_SCOPE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MANAGED_PROPERTY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MAP_ENTRIES);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MAP_ENTRY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MESSAGE_BUNDLE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__NAVIGATION_CASE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__NAVIGATION_HANDLER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__NAVIGATION_RULE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__NULL_VALUE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PHASE_LISTENER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY_EXTENSION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY_NAME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY_RESOLVER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__REDIRECT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__REFERENCED_BEAN);
        createEReference(documentRootEClass, DOCUMENT_ROOT__REFERENCED_BEAN_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__REFERENCED_BEAN_NAME);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDERER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDERER_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDERER_EXTENSION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDERER_TYPE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDER_KIT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDER_KIT_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDER_KIT_FACTORY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RENDER_KIT_ID);
        createEReference(documentRootEClass, DOCUMENT_ROOT__SMALL_ICON);
        createEReference(documentRootEClass, DOCUMENT_ROOT__STATE_MANAGER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__SUGGESTED_VALUE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__SUPPORTED_LOCALE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__TO_VIEW_ID);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VALIDATOR);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VALIDATOR_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VALIDATOR_ID);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VALUE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VALUE_CLASS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VARIABLE_RESOLVER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__VIEW_HANDLER);

        dynamicAttributeEClass = createEClass(DYNAMIC_ATTRIBUTE);
        createEAttribute(dynamicAttributeEClass, DYNAMIC_ATTRIBUTE__NAME);
        createEAttribute(dynamicAttributeEClass, DYNAMIC_ATTRIBUTE__VALUE);

        dynamicElementEClass = createEClass(DYNAMIC_ELEMENT);
        createEReference(dynamicElementEClass, DYNAMIC_ELEMENT__CHILD_NODES);
        createEAttribute(dynamicElementEClass, DYNAMIC_ELEMENT__NAME);
        createEReference(dynamicElementEClass, DYNAMIC_ELEMENT__ATTRIBUTES);
        createEAttribute(dynamicElementEClass, DYNAMIC_ELEMENT__TEXT_CONTENT);

        facesConfigTypeEClass = createEClass(FACES_CONFIG_TYPE);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__APPLICATION);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__FACTORY);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__COMPONENT);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__CONVERTER);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__MANAGED_BEAN);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__NAVIGATION_RULE);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__REFERENCED_BEAN);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__RENDER_KIT);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__LIFECYCLE);
        createEReference(facesConfigTypeEClass, FACES_CONFIG_TYPE__VALIDATOR);
        createEAttribute(facesConfigTypeEClass, FACES_CONFIG_TYPE__XMLNS);
        createEAttribute(facesConfigTypeEClass, FACES_CONFIG_TYPE__ID);

        facesContextFactoryTypeEClass = createEClass(FACES_CONTEXT_FACTORY_TYPE);
        createEAttribute(facesContextFactoryTypeEClass, FACES_CONTEXT_FACTORY_TYPE__TEXT_CONTENT);
        createEAttribute(facesContextFactoryTypeEClass, FACES_CONTEXT_FACTORY_TYPE__ID);

        facetExtensionTypeEClass = createEClass(FACET_EXTENSION_TYPE);

        facetNameTypeEClass = createEClass(FACET_NAME_TYPE);
        createEAttribute(facetNameTypeEClass, FACET_NAME_TYPE__TEXT_CONTENT);
        createEAttribute(facetNameTypeEClass, FACET_NAME_TYPE__ID);

        facetTypeEClass = createEClass(FACET_TYPE);
        createEReference(facetTypeEClass, FACET_TYPE__DESCRIPTION);
        createEReference(facetTypeEClass, FACET_TYPE__DISPLAY_NAME);
        createEReference(facetTypeEClass, FACET_TYPE__ICON);
        createEReference(facetTypeEClass, FACET_TYPE__FACET_NAME);
        createEReference(facetTypeEClass, FACET_TYPE__FACET_EXTENSION);
        createEAttribute(facetTypeEClass, FACET_TYPE__ID);

        factoryTypeEClass = createEClass(FACTORY_TYPE);
        createEReference(factoryTypeEClass, FACTORY_TYPE__APPLICATION_FACTORY);
        createEReference(factoryTypeEClass, FACTORY_TYPE__FACES_CONTEXT_FACTORY);
        createEReference(factoryTypeEClass, FACTORY_TYPE__LIFECYCLE_FACTORY);
        createEReference(factoryTypeEClass, FACTORY_TYPE__RENDER_KIT_FACTORY);
        createEAttribute(factoryTypeEClass, FACTORY_TYPE__ID);

        fromActionTypeEClass = createEClass(FROM_ACTION_TYPE);
        createEAttribute(fromActionTypeEClass, FROM_ACTION_TYPE__TEXT_CONTENT);
        createEAttribute(fromActionTypeEClass, FROM_ACTION_TYPE__ID);

        fromOutcomeTypeEClass = createEClass(FROM_OUTCOME_TYPE);
        createEAttribute(fromOutcomeTypeEClass, FROM_OUTCOME_TYPE__TEXT_CONTENT);
        createEAttribute(fromOutcomeTypeEClass, FROM_OUTCOME_TYPE__ID);

        fromViewIdTypeEClass = createEClass(FROM_VIEW_ID_TYPE);
        createEAttribute(fromViewIdTypeEClass, FROM_VIEW_ID_TYPE__TEXT_CONTENT);
        createEAttribute(fromViewIdTypeEClass, FROM_VIEW_ID_TYPE__ID);

        iconTypeEClass = createEClass(ICON_TYPE);
        createEReference(iconTypeEClass, ICON_TYPE__SMALL_ICON);
        createEReference(iconTypeEClass, ICON_TYPE__LARGE_ICON);
        createEAttribute(iconTypeEClass, ICON_TYPE__LANG);
        createEAttribute(iconTypeEClass, ICON_TYPE__ID);

        keyClassTypeEClass = createEClass(KEY_CLASS_TYPE);
        createEAttribute(keyClassTypeEClass, KEY_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(keyClassTypeEClass, KEY_CLASS_TYPE__ID);

        keyTypeEClass = createEClass(KEY_TYPE);
        createEAttribute(keyTypeEClass, KEY_TYPE__TEXT_CONTENT);
        createEAttribute(keyTypeEClass, KEY_TYPE__ID);

        largeIconTypeEClass = createEClass(LARGE_ICON_TYPE);
        createEAttribute(largeIconTypeEClass, LARGE_ICON_TYPE__TEXT_CONTENT);
        createEAttribute(largeIconTypeEClass, LARGE_ICON_TYPE__ID);

        lifecycleFactoryTypeEClass = createEClass(LIFECYCLE_FACTORY_TYPE);
        createEAttribute(lifecycleFactoryTypeEClass, LIFECYCLE_FACTORY_TYPE__TEXT_CONTENT);
        createEAttribute(lifecycleFactoryTypeEClass, LIFECYCLE_FACTORY_TYPE__ID);

        lifecycleTypeEClass = createEClass(LIFECYCLE_TYPE);
        createEReference(lifecycleTypeEClass, LIFECYCLE_TYPE__PHASE_LISTENER);
        createEAttribute(lifecycleTypeEClass, LIFECYCLE_TYPE__ID);

        listEntriesTypeEClass = createEClass(LIST_ENTRIES_TYPE);
        createEReference(listEntriesTypeEClass, LIST_ENTRIES_TYPE__VALUE_CLASS);
        createEReference(listEntriesTypeEClass, LIST_ENTRIES_TYPE__NULL_VALUE);
        createEReference(listEntriesTypeEClass, LIST_ENTRIES_TYPE__VALUE);
        createEAttribute(listEntriesTypeEClass, LIST_ENTRIES_TYPE__ID);

        localeConfigTypeEClass = createEClass(LOCALE_CONFIG_TYPE);
        createEReference(localeConfigTypeEClass, LOCALE_CONFIG_TYPE__DEFAULT_LOCALE);
        createEReference(localeConfigTypeEClass, LOCALE_CONFIG_TYPE__SUPPORTED_LOCALE);
        createEAttribute(localeConfigTypeEClass, LOCALE_CONFIG_TYPE__ID);

        managedBeanClassTypeEClass = createEClass(MANAGED_BEAN_CLASS_TYPE);
        createEAttribute(managedBeanClassTypeEClass, MANAGED_BEAN_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(managedBeanClassTypeEClass, MANAGED_BEAN_CLASS_TYPE__ID);

        managedBeanNameTypeEClass = createEClass(MANAGED_BEAN_NAME_TYPE);
        createEAttribute(managedBeanNameTypeEClass, MANAGED_BEAN_NAME_TYPE__TEXT_CONTENT);
        createEAttribute(managedBeanNameTypeEClass, MANAGED_BEAN_NAME_TYPE__ID);

        managedBeanScopeTypeEClass = createEClass(MANAGED_BEAN_SCOPE_TYPE);
        createEAttribute(managedBeanScopeTypeEClass, MANAGED_BEAN_SCOPE_TYPE__TEXT_CONTENT);
        createEAttribute(managedBeanScopeTypeEClass, MANAGED_BEAN_SCOPE_TYPE__ID);

        managedBeanTypeEClass = createEClass(MANAGED_BEAN_TYPE);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__DESCRIPTION);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__DISPLAY_NAME);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__ICON);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__MANAGED_BEAN_NAME);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__MANAGED_BEAN_CLASS);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__MANAGED_BEAN_SCOPE);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__MANAGED_PROPERTY);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__MAP_ENTRIES);
        createEReference(managedBeanTypeEClass, MANAGED_BEAN_TYPE__LIST_ENTRIES);
        createEAttribute(managedBeanTypeEClass, MANAGED_BEAN_TYPE__ID);

        managedPropertyTypeEClass = createEClass(MANAGED_PROPERTY_TYPE);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__DESCRIPTION);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__DISPLAY_NAME);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__ICON);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__PROPERTY_NAME);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__PROPERTY_CLASS);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__MAP_ENTRIES);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__NULL_VALUE);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__VALUE);
        createEReference(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__LIST_ENTRIES);
        createEAttribute(managedPropertyTypeEClass, MANAGED_PROPERTY_TYPE__ID);

        mapEntriesTypeEClass = createEClass(MAP_ENTRIES_TYPE);
        createEReference(mapEntriesTypeEClass, MAP_ENTRIES_TYPE__KEY_CLASS);
        createEReference(mapEntriesTypeEClass, MAP_ENTRIES_TYPE__VALUE_CLASS);
        createEReference(mapEntriesTypeEClass, MAP_ENTRIES_TYPE__MAP_ENTRY);
        createEAttribute(mapEntriesTypeEClass, MAP_ENTRIES_TYPE__ID);

        mapEntryTypeEClass = createEClass(MAP_ENTRY_TYPE);
        createEReference(mapEntryTypeEClass, MAP_ENTRY_TYPE__KEY);
        createEReference(mapEntryTypeEClass, MAP_ENTRY_TYPE__NULL_VALUE);
        createEReference(mapEntryTypeEClass, MAP_ENTRY_TYPE__VALUE);
        createEAttribute(mapEntryTypeEClass, MAP_ENTRY_TYPE__ID);

        messageBundleTypeEClass = createEClass(MESSAGE_BUNDLE_TYPE);
        createEAttribute(messageBundleTypeEClass, MESSAGE_BUNDLE_TYPE__TEXT_CONTENT);
        createEAttribute(messageBundleTypeEClass, MESSAGE_BUNDLE_TYPE__ID);

        navigationCaseTypeEClass = createEClass(NAVIGATION_CASE_TYPE);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__DESCRIPTION);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__DISPLAY_NAME);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__ICON);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__FROM_ACTION);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__FROM_OUTCOME);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__TO_VIEW_ID);
        createEReference(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__REDIRECT);
        createEAttribute(navigationCaseTypeEClass, NAVIGATION_CASE_TYPE__ID);

        navigationHandlerTypeEClass = createEClass(NAVIGATION_HANDLER_TYPE);
        createEAttribute(navigationHandlerTypeEClass, NAVIGATION_HANDLER_TYPE__TEXT_CONTENT);
        createEAttribute(navigationHandlerTypeEClass, NAVIGATION_HANDLER_TYPE__ID);

        navigationRuleTypeEClass = createEClass(NAVIGATION_RULE_TYPE);
        createEReference(navigationRuleTypeEClass, NAVIGATION_RULE_TYPE__DESCRIPTION);
        createEReference(navigationRuleTypeEClass, NAVIGATION_RULE_TYPE__DISPLAY_NAME);
        createEReference(navigationRuleTypeEClass, NAVIGATION_RULE_TYPE__ICON);
        createEReference(navigationRuleTypeEClass, NAVIGATION_RULE_TYPE__FROM_VIEW_ID);
        createEReference(navigationRuleTypeEClass, NAVIGATION_RULE_TYPE__NAVIGATION_CASE);
        createEAttribute(navigationRuleTypeEClass, NAVIGATION_RULE_TYPE__ID);

        nullValueTypeEClass = createEClass(NULL_VALUE_TYPE);
        createEAttribute(nullValueTypeEClass, NULL_VALUE_TYPE__ID);

        phaseListenerTypeEClass = createEClass(PHASE_LISTENER_TYPE);
        createEAttribute(phaseListenerTypeEClass, PHASE_LISTENER_TYPE__TEXT_CONTENT);
        createEAttribute(phaseListenerTypeEClass, PHASE_LISTENER_TYPE__ID);

        propertyClassTypeEClass = createEClass(PROPERTY_CLASS_TYPE);
        createEAttribute(propertyClassTypeEClass, PROPERTY_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(propertyClassTypeEClass, PROPERTY_CLASS_TYPE__ID);

        propertyExtensionTypeEClass = createEClass(PROPERTY_EXTENSION_TYPE);

        propertyNameTypeEClass = createEClass(PROPERTY_NAME_TYPE);
        createEAttribute(propertyNameTypeEClass, PROPERTY_NAME_TYPE__TEXT_CONTENT);
        createEAttribute(propertyNameTypeEClass, PROPERTY_NAME_TYPE__ID);

        propertyResolverTypeEClass = createEClass(PROPERTY_RESOLVER_TYPE);
        createEAttribute(propertyResolverTypeEClass, PROPERTY_RESOLVER_TYPE__TEXT_CONTENT);
        createEAttribute(propertyResolverTypeEClass, PROPERTY_RESOLVER_TYPE__ID);

        propertyTypeEClass = createEClass(PROPERTY_TYPE);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__DESCRIPTION);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__DISPLAY_NAME);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__ICON);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__PROPERTY_NAME);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__PROPERTY_CLASS);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__DEFAULT_VALUE);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__SUGGESTED_VALUE);
        createEReference(propertyTypeEClass, PROPERTY_TYPE__PROPERTY_EXTENSION);
        createEAttribute(propertyTypeEClass, PROPERTY_TYPE__ID);

        redirectTypeEClass = createEClass(REDIRECT_TYPE);
        createEAttribute(redirectTypeEClass, REDIRECT_TYPE__ID);

        referencedBeanClassTypeEClass = createEClass(REFERENCED_BEAN_CLASS_TYPE);
        createEAttribute(referencedBeanClassTypeEClass, REFERENCED_BEAN_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(referencedBeanClassTypeEClass, REFERENCED_BEAN_CLASS_TYPE__ID);

        referencedBeanNameTypeEClass = createEClass(REFERENCED_BEAN_NAME_TYPE);
        createEAttribute(referencedBeanNameTypeEClass, REFERENCED_BEAN_NAME_TYPE__TEXT_CONTENT);
        createEAttribute(referencedBeanNameTypeEClass, REFERENCED_BEAN_NAME_TYPE__ID);

        referencedBeanTypeEClass = createEClass(REFERENCED_BEAN_TYPE);
        createEReference(referencedBeanTypeEClass, REFERENCED_BEAN_TYPE__DESCRIPTION);
        createEReference(referencedBeanTypeEClass, REFERENCED_BEAN_TYPE__DISPLAY_NAME);
        createEReference(referencedBeanTypeEClass, REFERENCED_BEAN_TYPE__ICON);
        createEReference(referencedBeanTypeEClass, REFERENCED_BEAN_TYPE__REFERENCED_BEAN_NAME);
        createEReference(referencedBeanTypeEClass, REFERENCED_BEAN_TYPE__REFERENCED_BEAN_CLASS);
        createEAttribute(referencedBeanTypeEClass, REFERENCED_BEAN_TYPE__ID);

        rendererClassTypeEClass = createEClass(RENDERER_CLASS_TYPE);
        createEAttribute(rendererClassTypeEClass, RENDERER_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(rendererClassTypeEClass, RENDERER_CLASS_TYPE__ID);

        rendererExtensionTypeEClass = createEClass(RENDERER_EXTENSION_TYPE);

        rendererTypeEClass = createEClass(RENDERER_TYPE);
        createEReference(rendererTypeEClass, RENDERER_TYPE__DESCRIPTION);
        createEReference(rendererTypeEClass, RENDERER_TYPE__DISPLAY_NAME);
        createEReference(rendererTypeEClass, RENDERER_TYPE__ICON);
        createEReference(rendererTypeEClass, RENDERER_TYPE__COMPONENT_FAMILY);
        createEReference(rendererTypeEClass, RENDERER_TYPE__RENDERER_TYPE);
        createEReference(rendererTypeEClass, RENDERER_TYPE__RENDERER_CLASS);
        createEReference(rendererTypeEClass, RENDERER_TYPE__FACET);
        createEReference(rendererTypeEClass, RENDERER_TYPE__ATTRIBUTE);
        createEReference(rendererTypeEClass, RENDERER_TYPE__RENDERER_EXTENSION);
        createEAttribute(rendererTypeEClass, RENDERER_TYPE__ID);

        rendererTypeTypeEClass = createEClass(RENDERER_TYPE_TYPE);
        createEAttribute(rendererTypeTypeEClass, RENDERER_TYPE_TYPE__TEXT_CONTENT);
        createEAttribute(rendererTypeTypeEClass, RENDERER_TYPE_TYPE__ID);

        renderKitClassTypeEClass = createEClass(RENDER_KIT_CLASS_TYPE);
        createEAttribute(renderKitClassTypeEClass, RENDER_KIT_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(renderKitClassTypeEClass, RENDER_KIT_CLASS_TYPE__ID);

        renderKitFactoryTypeEClass = createEClass(RENDER_KIT_FACTORY_TYPE);
        createEAttribute(renderKitFactoryTypeEClass, RENDER_KIT_FACTORY_TYPE__TEXT_CONTENT);
        createEAttribute(renderKitFactoryTypeEClass, RENDER_KIT_FACTORY_TYPE__ID);

        renderKitIdTypeEClass = createEClass(RENDER_KIT_ID_TYPE);
        createEAttribute(renderKitIdTypeEClass, RENDER_KIT_ID_TYPE__TEXT_CONTENT);
        createEAttribute(renderKitIdTypeEClass, RENDER_KIT_ID_TYPE__ID);

        renderKitTypeEClass = createEClass(RENDER_KIT_TYPE);
        createEReference(renderKitTypeEClass, RENDER_KIT_TYPE__DESCRIPTION);
        createEReference(renderKitTypeEClass, RENDER_KIT_TYPE__DISPLAY_NAME);
        createEReference(renderKitTypeEClass, RENDER_KIT_TYPE__ICON);
        createEReference(renderKitTypeEClass, RENDER_KIT_TYPE__RENDER_KIT_ID);
        createEReference(renderKitTypeEClass, RENDER_KIT_TYPE__RENDER_KIT_CLASS);
        createEReference(renderKitTypeEClass, RENDER_KIT_TYPE__RENDERER);
        createEAttribute(renderKitTypeEClass, RENDER_KIT_TYPE__ID);

        smallIconTypeEClass = createEClass(SMALL_ICON_TYPE);
        createEAttribute(smallIconTypeEClass, SMALL_ICON_TYPE__TEXT_CONTENT);
        createEAttribute(smallIconTypeEClass, SMALL_ICON_TYPE__ID);

        stateManagerTypeEClass = createEClass(STATE_MANAGER_TYPE);
        createEAttribute(stateManagerTypeEClass, STATE_MANAGER_TYPE__TEXT_CONTENT);
        createEAttribute(stateManagerTypeEClass, STATE_MANAGER_TYPE__ID);

        suggestedValueTypeEClass = createEClass(SUGGESTED_VALUE_TYPE);
        createEAttribute(suggestedValueTypeEClass, SUGGESTED_VALUE_TYPE__TEXT_CONTENT);
        createEAttribute(suggestedValueTypeEClass, SUGGESTED_VALUE_TYPE__ID);

        supportedLocaleTypeEClass = createEClass(SUPPORTED_LOCALE_TYPE);
        createEAttribute(supportedLocaleTypeEClass, SUPPORTED_LOCALE_TYPE__TEXT_CONTENT);
        createEAttribute(supportedLocaleTypeEClass, SUPPORTED_LOCALE_TYPE__ID);

        toViewIdTypeEClass = createEClass(TO_VIEW_ID_TYPE);
        createEAttribute(toViewIdTypeEClass, TO_VIEW_ID_TYPE__TEXT_CONTENT);
        createEAttribute(toViewIdTypeEClass, TO_VIEW_ID_TYPE__ID);

        validatorClassTypeEClass = createEClass(VALIDATOR_CLASS_TYPE);
        createEAttribute(validatorClassTypeEClass, VALIDATOR_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(validatorClassTypeEClass, VALIDATOR_CLASS_TYPE__ID);

        validatorIdTypeEClass = createEClass(VALIDATOR_ID_TYPE);
        createEAttribute(validatorIdTypeEClass, VALIDATOR_ID_TYPE__TEXT_CONTENT);
        createEAttribute(validatorIdTypeEClass, VALIDATOR_ID_TYPE__ID);

        validatorTypeEClass = createEClass(VALIDATOR_TYPE);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__DESCRIPTION);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__DISPLAY_NAME);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__ICON);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__VALIDATOR_ID);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__VALIDATOR_CLASS);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__ATTRIBUTE);
        createEReference(validatorTypeEClass, VALIDATOR_TYPE__PROPERTY);
        createEAttribute(validatorTypeEClass, VALIDATOR_TYPE__ID);

        valueClassTypeEClass = createEClass(VALUE_CLASS_TYPE);
        createEAttribute(valueClassTypeEClass, VALUE_CLASS_TYPE__TEXT_CONTENT);
        createEAttribute(valueClassTypeEClass, VALUE_CLASS_TYPE__ID);

        valueTypeEClass = createEClass(VALUE_TYPE);
        createEAttribute(valueTypeEClass, VALUE_TYPE__TEXT_CONTENT);
        createEAttribute(valueTypeEClass, VALUE_TYPE__ID);

        variableResolverTypeEClass = createEClass(VARIABLE_RESOLVER_TYPE);
        createEAttribute(variableResolverTypeEClass, VARIABLE_RESOLVER_TYPE__TEXT_CONTENT);
        createEAttribute(variableResolverTypeEClass, VARIABLE_RESOLVER_TYPE__ID);

        viewHandlerTypeEClass = createEClass(VIEW_HANDLER_TYPE);
        createEAttribute(viewHandlerTypeEClass, VIEW_HANDLER_TYPE__TEXT_CONTENT);
        createEAttribute(viewHandlerTypeEClass, VIEW_HANDLER_TYPE__ID);

        extensionTypeEClass = createEClass(EXTENSION_TYPE);
        createEReference(extensionTypeEClass, EXTENSION_TYPE__CHILD_NODES);
        createEAttribute(extensionTypeEClass, EXTENSION_TYPE__TEXT_CONTENT);
        createEAttribute(extensionTypeEClass, EXTENSION_TYPE__ID);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Add supertypes to classes
        attributeExtensionTypeEClass.getESuperTypes().add(this.getExtensionType());
        componentExtensionTypeEClass.getESuperTypes().add(this.getExtensionType());
        facetExtensionTypeEClass.getESuperTypes().add(this.getExtensionType());
        propertyExtensionTypeEClass.getESuperTypes().add(this.getExtensionType());
        rendererExtensionTypeEClass.getESuperTypes().add(this.getExtensionType());

        // Initialize classes and features; add operations and parameters
        initEClass(actionListenerTypeEClass, ActionListenerType.class, "ActionListenerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getActionListenerType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ActionListenerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getActionListenerType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ActionListenerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(applicationFactoryTypeEClass, ApplicationFactoryType.class, "ApplicationFactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getApplicationFactoryType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ApplicationFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationFactoryType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ApplicationFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(applicationTypeEClass, ApplicationType.class, "ApplicationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getApplicationType_ActionListener(), this.getActionListenerType(), null, "actionListener", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_DefaultRenderKitId(), this.getDefaultRenderKitIdType(), null, "defaultRenderKitId", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_MessageBundle(), this.getMessageBundleType(), null, "messageBundle", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_NavigationHandler(), this.getNavigationHandlerType(), null, "navigationHandler", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_ViewHandler(), this.getViewHandlerType(), null, "viewHandler", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_StateManager(), this.getStateManagerType(), null, "stateManager", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_PropertyResolver(), this.getPropertyResolverType(), null, "propertyResolver", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_VariableResolver(), this.getVariableResolverType(), null, "variableResolver", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_LocaleConfig(), this.getLocaleConfigType(), null, "localeConfig", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeClassTypeEClass, AttributeClassType.class, "AttributeClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttributeClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, AttributeClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, AttributeClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeExtensionTypeEClass, AttributeExtensionType.class, "AttributeExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(attributeNameTypeEClass, AttributeNameType.class, "AttributeNameType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttributeNameType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, AttributeNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeNameType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, AttributeNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeTypeEClass, AttributeType.class, "AttributeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAttributeType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_Icon(), this.getIconType(), null, "icon", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_AttributeName(), this.getAttributeNameType(), null, "attributeName", null, 1, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_AttributeClass(), this.getAttributeClassType(), null, "attributeClass", null, 1, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_DefaultValue(), this.getDefaultValueType(), null, "defaultValue", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_SuggestedValue(), this.getSuggestedValueType(), null, "suggestedValue", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAttributeType_AttributeExtension(), this.getAttributeExtensionType(), null, "attributeExtension", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(componentClassTypeEClass, ComponentClassType.class, "ComponentClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComponentClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ComponentClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getComponentClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ComponentClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(componentExtensionTypeEClass, ComponentExtensionType.class, "ComponentExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(componentFamilyTypeEClass, ComponentFamilyType.class, "ComponentFamilyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComponentFamilyType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ComponentFamilyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getComponentFamilyType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ComponentFamilyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComponentType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_Icon(), this.getIconType(), null, "icon", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_ComponentType(), this.getComponentTypeType(), null, "componentType", null, 1, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_ComponentClass(), this.getComponentClassType(), null, "componentClass", null, 1, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_Facet(), this.getFacetType(), null, "facet", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_Property(), this.getPropertyType(), null, "property", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComponentType_ComponentExtension(), this.getComponentExtensionType(), null, "componentExtension", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getComponentType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(componentTypeTypeEClass, ComponentTypeType.class, "ComponentTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComponentTypeType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ComponentTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getComponentTypeType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ComponentTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(converterClassTypeEClass, ConverterClassType.class, "ConverterClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConverterClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ConverterClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConverterClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ConverterClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(converterForClassTypeEClass, ConverterForClassType.class, "ConverterForClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConverterForClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ConverterForClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConverterForClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ConverterForClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(converterIdTypeEClass, ConverterIdType.class, "ConverterIdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConverterIdType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ConverterIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConverterIdType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ConverterIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(converterTypeEClass, ConverterType.class, "ConverterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConverterType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_Icon(), this.getIconType(), null, "icon", null, 0, -1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_ConverterId(), this.getConverterIdType(), null, "converterId", null, 0, 1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_ConverterForClass(), this.getConverterForClassType(), null, "converterForClass", null, 0, 1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_ConverterClass(), this.getConverterClassType(), null, "converterClass", null, 1, 1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterType_Property(), this.getPropertyType(), null, "property", null, 0, -1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConverterType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ConverterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(defaultLocaleTypeEClass, DefaultLocaleType.class, "DefaultLocaleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDefaultLocaleType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, DefaultLocaleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDefaultLocaleType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, DefaultLocaleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(defaultRenderKitIdTypeEClass, DefaultRenderKitIdType.class, "DefaultRenderKitIdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDefaultRenderKitIdType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, DefaultRenderKitIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDefaultRenderKitIdType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, DefaultRenderKitIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(defaultValueTypeEClass, DefaultValueType.class, "DefaultValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDefaultValueType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, DefaultValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDefaultValueType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, DefaultValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(descriptionTypeEClass, DescriptionType.class, "DescriptionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDescriptionType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDescriptionType_Lang(), theXMLTypePackage.getLanguage(), "lang", null, 0, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDescriptionType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(displayNameTypeEClass, DisplayNameType.class, "DisplayNameType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDisplayNameType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, DisplayNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDisplayNameType_Lang(), theXMLTypePackage.getLanguage(), "lang", null, 0, 1, DisplayNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDisplayNameType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, DisplayNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ActionListener(), this.getActionListenerType(), null, "actionListener", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Application(), this.getApplicationType(), null, "application", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ApplicationFactory(), this.getApplicationFactoryType(), null, "applicationFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_AttributeClass(), this.getAttributeClassType(), null, "attributeClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_AttributeExtension(), this.getAttributeExtensionType(), null, "attributeExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_AttributeName(), this.getAttributeNameType(), null, "attributeName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Component(), this.getComponentType(), null, "component", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ComponentClass(), this.getComponentClassType(), null, "componentClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ComponentExtension(), this.getComponentExtensionType(), null, "componentExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ComponentFamily(), this.getComponentFamilyType(), null, "componentFamily", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ComponentType(), this.getComponentTypeType(), null, "componentType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Converter(), this.getConverterType(), null, "converter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ConverterClass(), this.getConverterClassType(), null, "converterClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ConverterForClass(), this.getConverterForClassType(), null, "converterForClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ConverterId(), this.getConverterIdType(), null, "converterId", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_DefaultLocale(), this.getDefaultLocaleType(), null, "defaultLocale", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_DefaultRenderKitId(), this.getDefaultRenderKitIdType(), null, "defaultRenderKitId", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_DefaultValue(), this.getDefaultValueType(), null, "defaultValue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Description(), this.getDescriptionType(), null, "description", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FacesConfig(), this.getFacesConfigType(), null, "facesConfig", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FacesContextFactory(), this.getFacesContextFactoryType(), null, "facesContextFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Facet(), this.getFacetType(), null, "facet", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FacetExtension(), this.getFacetExtensionType(), null, "facetExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FacetName(), this.getFacetNameType(), null, "facetName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Factory(), this.getFactoryType(), null, "factory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FromAction(), this.getFromActionType(), null, "fromAction", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FromOutcome(), this.getFromOutcomeType(), null, "fromOutcome", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FromViewId(), this.getFromViewIdType(), null, "fromViewId", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Icon(), this.getIconType(), null, "icon", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Key(), this.getKeyType(), null, "key", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_KeyClass(), this.getKeyClassType(), null, "keyClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_LargeIcon(), this.getLargeIconType(), null, "largeIcon", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Lifecycle(), this.getLifecycleType(), null, "lifecycle", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_LifecycleFactory(), this.getLifecycleFactoryType(), null, "lifecycleFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ListEntries(), this.getListEntriesType(), null, "listEntries", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_LocaleConfig(), this.getLocaleConfigType(), null, "localeConfig", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ManagedBean(), this.getManagedBeanType(), null, "managedBean", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ManagedBeanClass(), this.getManagedBeanClassType(), null, "managedBeanClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ManagedBeanName(), this.getManagedBeanNameType(), null, "managedBeanName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ManagedBeanScope(), this.getManagedBeanScopeType(), null, "managedBeanScope", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ManagedProperty(), this.getManagedPropertyType(), null, "managedProperty", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_MapEntries(), this.getMapEntriesType(), null, "mapEntries", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_MapEntry(), this.getMapEntryType(), null, "mapEntry", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_MessageBundle(), this.getMessageBundleType(), null, "messageBundle", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_NavigationCase(), this.getNavigationCaseType(), null, "navigationCase", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_NavigationHandler(), this.getNavigationHandlerType(), null, "navigationHandler", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_NavigationRule(), this.getNavigationRuleType(), null, "navigationRule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_NullValue(), this.getNullValueType(), null, "nullValue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PhaseListener(), this.getPhaseListenerType(), null, "phaseListener", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Property(), this.getPropertyType(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PropertyClass(), this.getPropertyClassType(), null, "propertyClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PropertyExtension(), this.getPropertyExtensionType(), null, "propertyExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PropertyName(), this.getPropertyNameType(), null, "propertyName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PropertyResolver(), this.getPropertyResolverType(), null, "propertyResolver", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Redirect(), this.getRedirectType(), null, "redirect", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ReferencedBean(), this.getReferencedBeanType(), null, "referencedBean", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ReferencedBeanClass(), this.getReferencedBeanClassType(), null, "referencedBeanClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ReferencedBeanName(), this.getReferencedBeanNameType(), null, "referencedBeanName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Renderer(), this.getRendererType(), null, "renderer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RendererClass(), this.getRendererClassType(), null, "rendererClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RendererExtension(), this.getRendererExtensionType(), null, "rendererExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RendererType(), this.getRendererTypeType(), null, "rendererType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RenderKit(), this.getRenderKitType(), null, "renderKit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RenderKitClass(), this.getRenderKitClassType(), null, "renderKitClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RenderKitFactory(), this.getRenderKitFactoryType(), null, "renderKitFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RenderKitId(), this.getRenderKitIdType(), null, "renderKitId", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_SmallIcon(), this.getSmallIconType(), null, "smallIcon", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_StateManager(), this.getStateManagerType(), null, "stateManager", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_SuggestedValue(), this.getSuggestedValueType(), null, "suggestedValue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_SupportedLocale(), this.getSupportedLocaleType(), null, "supportedLocale", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ToViewId(), this.getToViewIdType(), null, "toViewId", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Validator(), this.getValidatorType(), null, "validator", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ValidatorClass(), this.getValidatorClassType(), null, "validatorClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ValidatorId(), this.getValidatorIdType(), null, "validatorId", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Value(), this.getValueType(), null, "value", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ValueClass(), this.getValueClassType(), null, "valueClass", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_VariableResolver(), this.getVariableResolverType(), null, "variableResolver", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ViewHandler(), this.getViewHandlerType(), null, "viewHandler", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(dynamicAttributeEClass, DynamicAttribute.class, "DynamicAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDynamicAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, DynamicAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDynamicAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, DynamicAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dynamicElementEClass, DynamicElement.class, "DynamicElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDynamicElement_ChildNodes(), this.getDynamicElement(), null, "childNodes", null, 0, -1, DynamicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDynamicElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, DynamicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDynamicElement_Attributes(), this.getDynamicAttribute(), null, "attributes", null, 0, -1, DynamicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDynamicElement_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, DynamicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(facesConfigTypeEClass, FacesConfigType.class, "FacesConfigType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFacesConfigType_Application(), this.getApplicationType(), null, "application", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_Factory(), this.getFactoryType(), null, "factory", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_Component(), this.getComponentType(), null, "component", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_Converter(), this.getConverterType(), null, "converter", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_ManagedBean(), this.getManagedBeanType(), null, "managedBean", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_NavigationRule(), this.getNavigationRuleType(), null, "navigationRule", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_ReferencedBean(), this.getReferencedBeanType(), null, "referencedBean", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_RenderKit(), this.getRenderKitType(), null, "renderKit", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_Lifecycle(), this.getLifecycleType(), null, "lifecycle", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacesConfigType_Validator(), this.getValidatorType(), null, "validator", null, 0, -1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFacesConfigType_Xmlns(), theXMLTypePackage.getString(), "xmlns", "http://java.sun.com/JSF/Configuration", 0, 1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFacesConfigType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FacesConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(facesContextFactoryTypeEClass, FacesContextFactoryType.class, "FacesContextFactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFacesContextFactoryType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, FacesContextFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFacesContextFactoryType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FacesContextFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(facetExtensionTypeEClass, FacetExtensionType.class, "FacetExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(facetNameTypeEClass, FacetNameType.class, "FacetNameType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFacetNameType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, FacetNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFacetNameType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FacetNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(facetTypeEClass, FacetType.class, "FacetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFacetType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, FacetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacetType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, FacetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacetType_Icon(), this.getIconType(), null, "icon", null, 0, -1, FacetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacetType_FacetName(), this.getFacetNameType(), null, "facetName", null, 1, 1, FacetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFacetType_FacetExtension(), this.getFacetExtensionType(), null, "facetExtension", null, 0, -1, FacetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFacetType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FacetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(factoryTypeEClass, FactoryType.class, "FactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFactoryType_ApplicationFactory(), this.getApplicationFactoryType(), null, "applicationFactory", null, 0, -1, FactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFactoryType_FacesContextFactory(), this.getFacesContextFactoryType(), null, "facesContextFactory", null, 0, -1, FactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFactoryType_LifecycleFactory(), this.getLifecycleFactoryType(), null, "lifecycleFactory", null, 0, -1, FactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFactoryType_RenderKitFactory(), this.getRenderKitFactoryType(), null, "renderKitFactory", null, 0, -1, FactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFactoryType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fromActionTypeEClass, FromActionType.class, "FromActionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFromActionType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, FromActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFromActionType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FromActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fromOutcomeTypeEClass, FromOutcomeType.class, "FromOutcomeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFromOutcomeType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, FromOutcomeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFromOutcomeType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FromOutcomeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fromViewIdTypeEClass, FromViewIdType.class, "FromViewIdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFromViewIdType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, FromViewIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFromViewIdType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FromViewIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iconTypeEClass, IconType.class, "IconType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIconType_SmallIcon(), this.getSmallIconType(), null, "smallIcon", null, 0, 1, IconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIconType_LargeIcon(), this.getLargeIconType(), null, "largeIcon", null, 0, 1, IconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIconType_Lang(), theXMLTypePackage.getLanguage(), "lang", null, 0, 1, IconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIconType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, IconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(keyClassTypeEClass, KeyClassType.class, "KeyClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKeyClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, KeyClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKeyClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, KeyClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(keyTypeEClass, KeyType.class, "KeyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKeyType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, KeyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKeyType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, KeyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(largeIconTypeEClass, LargeIconType.class, "LargeIconType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLargeIconType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, LargeIconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLargeIconType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, LargeIconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lifecycleFactoryTypeEClass, LifecycleFactoryType.class, "LifecycleFactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLifecycleFactoryType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, LifecycleFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLifecycleFactoryType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, LifecycleFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lifecycleTypeEClass, LifecycleType.class, "LifecycleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLifecycleType_PhaseListener(), this.getPhaseListenerType(), null, "phaseListener", null, 0, -1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLifecycleType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(listEntriesTypeEClass, ListEntriesType.class, "ListEntriesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getListEntriesType_ValueClass(), this.getValueClassType(), null, "valueClass", null, 0, 1, ListEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getListEntriesType_NullValue(), this.getNullValueType(), null, "nullValue", null, 0, -1, ListEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getListEntriesType_Value(), this.getValueType(), null, "value", null, 0, -1, ListEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getListEntriesType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ListEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(localeConfigTypeEClass, LocaleConfigType.class, "LocaleConfigType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLocaleConfigType_DefaultLocale(), this.getDefaultLocaleType(), null, "defaultLocale", null, 0, 1, LocaleConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLocaleConfigType_SupportedLocale(), this.getSupportedLocaleType(), null, "supportedLocale", null, 0, -1, LocaleConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLocaleConfigType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, LocaleConfigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(managedBeanClassTypeEClass, ManagedBeanClassType.class, "ManagedBeanClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getManagedBeanClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ManagedBeanClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getManagedBeanClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ManagedBeanClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(managedBeanNameTypeEClass, ManagedBeanNameType.class, "ManagedBeanNameType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getManagedBeanNameType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ManagedBeanNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getManagedBeanNameType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ManagedBeanNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(managedBeanScopeTypeEClass, ManagedBeanScopeType.class, "ManagedBeanScopeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getManagedBeanScopeType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ManagedBeanScopeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getManagedBeanScopeType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ManagedBeanScopeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(managedBeanTypeEClass, ManagedBeanType.class, "ManagedBeanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getManagedBeanType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_Icon(), this.getIconType(), null, "icon", null, 0, -1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_ManagedBeanName(), this.getManagedBeanNameType(), null, "managedBeanName", null, 1, 1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_ManagedBeanClass(), this.getManagedBeanClassType(), null, "managedBeanClass", null, 1, 1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_ManagedBeanScope(), this.getManagedBeanScopeType(), null, "managedBeanScope", null, 1, 1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_ManagedProperty(), this.getManagedPropertyType(), null, "managedProperty", null, 0, -1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_MapEntries(), this.getMapEntriesType(), null, "mapEntries", null, 0, 1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedBeanType_ListEntries(), this.getListEntriesType(), null, "listEntries", null, 0, 1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getManagedBeanType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ManagedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(managedPropertyTypeEClass, ManagedPropertyType.class, "ManagedPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getManagedPropertyType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_Icon(), this.getIconType(), null, "icon", null, 0, -1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_PropertyName(), this.getPropertyNameType(), null, "propertyName", null, 1, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_PropertyClass(), this.getPropertyClassType(), null, "propertyClass", null, 0, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_MapEntries(), this.getMapEntriesType(), null, "mapEntries", null, 0, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_NullValue(), this.getNullValueType(), null, "nullValue", null, 0, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_Value(), this.getValueType(), null, "value", null, 0, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getManagedPropertyType_ListEntries(), this.getListEntriesType(), null, "listEntries", null, 0, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getManagedPropertyType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ManagedPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(mapEntriesTypeEClass, MapEntriesType.class, "MapEntriesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMapEntriesType_KeyClass(), this.getKeyClassType(), null, "keyClass", null, 0, 1, MapEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMapEntriesType_ValueClass(), this.getValueClassType(), null, "valueClass", null, 0, 1, MapEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMapEntriesType_MapEntry(), this.getMapEntryType(), null, "mapEntry", null, 0, -1, MapEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMapEntriesType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, MapEntriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(mapEntryTypeEClass, MapEntryType.class, "MapEntryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMapEntryType_Key(), this.getKeyType(), null, "key", null, 1, 1, MapEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMapEntryType_NullValue(), this.getNullValueType(), null, "nullValue", null, 0, 1, MapEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMapEntryType_Value(), this.getValueType(), null, "value", null, 0, 1, MapEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMapEntryType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, MapEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(messageBundleTypeEClass, MessageBundleType.class, "MessageBundleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMessageBundleType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, MessageBundleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMessageBundleType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, MessageBundleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(navigationCaseTypeEClass, NavigationCaseType.class, "NavigationCaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNavigationCaseType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationCaseType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationCaseType_Icon(), this.getIconType(), null, "icon", null, 0, -1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationCaseType_FromAction(), this.getFromActionType(), null, "fromAction", null, 0, 1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationCaseType_FromOutcome(), this.getFromOutcomeType(), null, "fromOutcome", null, 0, 1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationCaseType_ToViewId(), this.getToViewIdType(), null, "toViewId", null, 1, 1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationCaseType_Redirect(), this.getRedirectType(), null, "redirect", null, 0, 1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNavigationCaseType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, NavigationCaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(navigationHandlerTypeEClass, NavigationHandlerType.class, "NavigationHandlerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNavigationHandlerType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, NavigationHandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNavigationHandlerType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, NavigationHandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(navigationRuleTypeEClass, NavigationRuleType.class, "NavigationRuleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNavigationRuleType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, NavigationRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationRuleType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, NavigationRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationRuleType_Icon(), this.getIconType(), null, "icon", null, 0, -1, NavigationRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationRuleType_FromViewId(), this.getFromViewIdType(), null, "fromViewId", null, 0, 1, NavigationRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNavigationRuleType_NavigationCase(), this.getNavigationCaseType(), null, "navigationCase", null, 0, -1, NavigationRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNavigationRuleType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, NavigationRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nullValueTypeEClass, NullValueType.class, "NullValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNullValueType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, NullValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(phaseListenerTypeEClass, PhaseListenerType.class, "PhaseListenerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPhaseListenerType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, PhaseListenerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPhaseListenerType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, PhaseListenerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyClassTypeEClass, PropertyClassType.class, "PropertyClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPropertyClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, PropertyClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, PropertyClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyExtensionTypeEClass, PropertyExtensionType.class, "PropertyExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(propertyNameTypeEClass, PropertyNameType.class, "PropertyNameType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPropertyNameType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, PropertyNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyNameType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, PropertyNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyResolverTypeEClass, PropertyResolverType.class, "PropertyResolverType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPropertyResolverType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, PropertyResolverType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyResolverType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, PropertyResolverType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyTypeEClass, PropertyType.class, "PropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPropertyType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_Icon(), this.getIconType(), null, "icon", null, 0, -1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_PropertyName(), this.getPropertyNameType(), null, "propertyName", null, 1, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_PropertyClass(), this.getPropertyClassType(), null, "propertyClass", null, 1, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_DefaultValue(), this.getDefaultValueType(), null, "defaultValue", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_SuggestedValue(), this.getSuggestedValueType(), null, "suggestedValue", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPropertyType_PropertyExtension(), this.getPropertyExtensionType(), null, "propertyExtension", null, 0, -1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(redirectTypeEClass, RedirectType.class, "RedirectType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRedirectType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RedirectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referencedBeanClassTypeEClass, ReferencedBeanClassType.class, "ReferencedBeanClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getReferencedBeanClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ReferencedBeanClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferencedBeanClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ReferencedBeanClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referencedBeanNameTypeEClass, ReferencedBeanNameType.class, "ReferencedBeanNameType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getReferencedBeanNameType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ReferencedBeanNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferencedBeanNameType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ReferencedBeanNameType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referencedBeanTypeEClass, ReferencedBeanType.class, "ReferencedBeanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReferencedBeanType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, ReferencedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferencedBeanType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, ReferencedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferencedBeanType_Icon(), this.getIconType(), null, "icon", null, 0, -1, ReferencedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferencedBeanType_ReferencedBeanName(), this.getReferencedBeanNameType(), null, "referencedBeanName", null, 1, 1, ReferencedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferencedBeanType_ReferencedBeanClass(), this.getReferencedBeanClassType(), null, "referencedBeanClass", null, 1, 1, ReferencedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferencedBeanType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ReferencedBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rendererClassTypeEClass, RendererClassType.class, "RendererClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRendererClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, RendererClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRendererClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RendererClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rendererExtensionTypeEClass, RendererExtensionType.class, "RendererExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rendererTypeEClass, RendererType.class, "RendererType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRendererType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_Icon(), this.getIconType(), null, "icon", null, 0, -1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_ComponentFamily(), this.getComponentFamilyType(), null, "componentFamily", null, 1, 1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_RendererType(), this.getRendererTypeType(), null, "rendererType", null, 1, 1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_RendererClass(), this.getRendererClassType(), null, "rendererClass", null, 1, 1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_Facet(), this.getFacetType(), null, "facet", null, 0, -1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRendererType_RendererExtension(), this.getRendererExtensionType(), null, "rendererExtension", null, 0, -1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRendererType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RendererType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rendererTypeTypeEClass, RendererTypeType.class, "RendererTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRendererTypeType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, RendererTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRendererTypeType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RendererTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(renderKitClassTypeEClass, RenderKitClassType.class, "RenderKitClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRenderKitClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, RenderKitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRenderKitClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RenderKitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(renderKitFactoryTypeEClass, RenderKitFactoryType.class, "RenderKitFactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRenderKitFactoryType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, RenderKitFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRenderKitFactoryType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RenderKitFactoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(renderKitIdTypeEClass, RenderKitIdType.class, "RenderKitIdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRenderKitIdType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, RenderKitIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRenderKitIdType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RenderKitIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(renderKitTypeEClass, RenderKitType.class, "RenderKitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRenderKitType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRenderKitType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRenderKitType_Icon(), this.getIconType(), null, "icon", null, 0, -1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRenderKitType_RenderKitId(), this.getRenderKitIdType(), null, "renderKitId", null, 0, 1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRenderKitType_RenderKitClass(), this.getRenderKitClassType(), null, "renderKitClass", null, 0, 1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRenderKitType_Renderer(), this.getRendererType(), null, "renderer", null, 0, -1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRenderKitType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RenderKitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(smallIconTypeEClass, SmallIconType.class, "SmallIconType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSmallIconType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, SmallIconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSmallIconType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, SmallIconType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stateManagerTypeEClass, StateManagerType.class, "StateManagerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStateManagerType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, StateManagerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getStateManagerType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, StateManagerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(suggestedValueTypeEClass, SuggestedValueType.class, "SuggestedValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSuggestedValueType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, SuggestedValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSuggestedValueType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, SuggestedValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(supportedLocaleTypeEClass, SupportedLocaleType.class, "SupportedLocaleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSupportedLocaleType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, SupportedLocaleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSupportedLocaleType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, SupportedLocaleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(toViewIdTypeEClass, ToViewIdType.class, "ToViewIdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getToViewIdType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ToViewIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getToViewIdType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ToViewIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(validatorClassTypeEClass, ValidatorClassType.class, "ValidatorClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValidatorClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ValidatorClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValidatorClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ValidatorClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(validatorIdTypeEClass, ValidatorIdType.class, "ValidatorIdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValidatorIdType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ValidatorIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValidatorIdType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ValidatorIdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(validatorTypeEClass, ValidatorType.class, "ValidatorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getValidatorType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getValidatorType_DisplayName(), this.getDisplayNameType(), null, "displayName", null, 0, -1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getValidatorType_Icon(), this.getIconType(), null, "icon", null, 0, -1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getValidatorType_ValidatorId(), this.getValidatorIdType(), null, "validatorId", null, 1, 1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getValidatorType_ValidatorClass(), this.getValidatorClassType(), null, "validatorClass", null, 1, 1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getValidatorType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getValidatorType_Property(), this.getPropertyType(), null, "property", null, 0, -1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValidatorType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ValidatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(valueClassTypeEClass, ValueClassType.class, "ValueClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValueClassType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ValueClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValueClassType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ValueClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(valueTypeEClass, ValueType.class, "ValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValueType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValueType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(variableResolverTypeEClass, VariableResolverType.class, "VariableResolverType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getVariableResolverType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, VariableResolverType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getVariableResolverType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, VariableResolverType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(viewHandlerTypeEClass, ViewHandlerType.class, "ViewHandlerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getViewHandlerType_TextContent(), theXMLTypePackage.getString(), "textContent", null, 0, 1, ViewHandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getViewHandlerType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ViewHandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(extensionTypeEClass, ExtensionType.class, "ExtensionType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getExtensionType_ChildNodes(), this.getDynamicElement(), null, "childNodes", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExtensionType_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExtensionType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
        addAnnotation
          (this, 
           source, 
           new String[] {
             "qualified", "false"
           });		
        addAnnotation
          (actionListenerTypeEClass, 
           source, 
           new String[] {
             "name", "action-listener_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getActionListenerType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getActionListenerType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (applicationFactoryTypeEClass, 
           source, 
           new String[] {
             "name", "application-factory_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getApplicationFactoryType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getApplicationFactoryType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (applicationTypeEClass, 
           source, 
           new String[] {
             "name", "application_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getApplicationType_ActionListener(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "action-listener",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_DefaultRenderKitId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-render-kit-id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_MessageBundle(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "message-bundle",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_NavigationHandler(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "navigation-handler",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_ViewHandler(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "view-handler",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_StateManager(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "state-manager",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_PropertyResolver(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-resolver",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_VariableResolver(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "variable-resolver",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_LocaleConfig(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "locale-config",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getApplicationType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (attributeClassTypeEClass, 
           source, 
           new String[] {
             "name", "attribute-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getAttributeClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getAttributeClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (attributeExtensionTypeEClass, 
           source, 
           new String[] {
             "name", "attribute-extension_._type"
           });		
        addAnnotation
          (attributeNameTypeEClass, 
           source, 
           new String[] {
             "name", "attribute-name_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getAttributeNameType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getAttributeNameType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (attributeTypeEClass, 
           source, 
           new String[] {
             "name", "attribute_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getAttributeType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_AttributeName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_AttributeClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_DefaultValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_SuggestedValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "suggested-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_AttributeExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute-extension",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getAttributeType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (componentClassTypeEClass, 
           source, 
           new String[] {
             "name", "component-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getComponentClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getComponentClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (componentExtensionTypeEClass, 
           source, 
           new String[] {
             "name", "component-extension_._type"
           });		
        addAnnotation
          (componentFamilyTypeEClass, 
           source, 
           new String[] {
             "name", "component-family_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getComponentFamilyType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getComponentFamilyType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (componentTypeEClass, 
           source, 
           new String[] {
             "name", "component_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getComponentType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_ComponentType(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-type",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_ComponentClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_Facet(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_ComponentExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-extension",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getComponentType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (componentTypeTypeEClass, 
           source, 
           new String[] {
             "name", "component-type_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getComponentTypeType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getComponentTypeType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (converterClassTypeEClass, 
           source, 
           new String[] {
             "name", "converter-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getConverterClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getConverterClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (converterForClassTypeEClass, 
           source, 
           new String[] {
             "name", "converter-for-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getConverterForClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getConverterForClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (converterIdTypeEClass, 
           source, 
           new String[] {
             "name", "converter-id_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getConverterIdType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getConverterIdType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (converterTypeEClass, 
           source, 
           new String[] {
             "name", "converter_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getConverterType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_ConverterId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter-id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_ConverterForClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter-for-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_ConverterClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getConverterType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (defaultLocaleTypeEClass, 
           source, 
           new String[] {
             "name", "default-locale_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getDefaultLocaleType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getDefaultLocaleType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (defaultRenderKitIdTypeEClass, 
           source, 
           new String[] {
             "name", "default-render-kit-id_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getDefaultRenderKitIdType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getDefaultRenderKitIdType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (defaultValueTypeEClass, 
           source, 
           new String[] {
             "name", "default-value_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getDefaultValueType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getDefaultValueType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (descriptionTypeEClass, 
           source, 
           new String[] {
             "name", "description_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getDescriptionType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getDescriptionType_Lang(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "lang",
             "namespace", "http://www.w3.org/XML/1998/namespace"
           });		
        addAnnotation
          (getDescriptionType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (displayNameTypeEClass, 
           source, 
           new String[] {
             "name", "display-name_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getDisplayNameType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getDisplayNameType_Lang(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "lang",
             "namespace", "http://www.w3.org/XML/1998/namespace"
           });		
        addAnnotation
          (getDisplayNameType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (documentRootEClass, 
           source, 
           new String[] {
             "name", "",
             "kind", "mixed"
           });		
        addAnnotation
          (getDocumentRoot_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });		
        addAnnotation
          (getDocumentRoot_XMLNSPrefixMap(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xmlns:prefix"
           });		
        addAnnotation
          (getDocumentRoot_XSISchemaLocation(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsi:schemaLocation"
           });			
        addAnnotation
          (getDocumentRoot_ActionListener(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "action-listener",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Application(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "application",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ApplicationFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "application-factory",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_AttributeClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_AttributeExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute-extension",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_AttributeName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute-name",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Component(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ComponentClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ComponentExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-extension",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ComponentFamily(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-family",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ComponentType(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-type",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Converter(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ConverterClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ConverterForClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter-for-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ConverterId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter-id",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_DefaultLocale(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-locale",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_DefaultRenderKitId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-render-kit-id",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_DefaultValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-value",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FacesConfig(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "faces-config",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FacesContextFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "faces-context-factory",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Facet(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FacetExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet-extension",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FacetName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet-name",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Factory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "factory",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FromAction(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "from-action",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FromOutcome(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "from-outcome",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_FromViewId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "from-view-id",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Key(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "key",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_KeyClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "key-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_LargeIcon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "large-icon",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Lifecycle(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "lifecycle",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_LifecycleFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "lifecycle-factory",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ListEntries(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "list-entries",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_LocaleConfig(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "locale-config",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ManagedBean(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ManagedBeanClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ManagedBeanName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean-name",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ManagedBeanScope(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean-scope",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ManagedProperty(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-property",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_MapEntries(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "map-entries",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_MapEntry(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "map-entry",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_MessageBundle(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "message-bundle",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_NavigationCase(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "navigation-case",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_NavigationHandler(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "navigation-handler",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_NavigationRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "navigation-rule",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_NullValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "null-value",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_PhaseListener(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "phase-listener",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_PropertyClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_PropertyExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-extension",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_PropertyName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-name",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_PropertyResolver(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-resolver",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Redirect(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "redirect",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ReferencedBean(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "referenced-bean",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ReferencedBeanClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "referenced-bean-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ReferencedBeanName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "referenced-bean-name",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Renderer(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RendererClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RendererExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer-extension",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RendererType(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer-type",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RenderKit(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RenderKitClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RenderKitFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit-factory",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_RenderKitId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit-id",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_SmallIcon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "small-icon",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_StateManager(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "state-manager",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_SuggestedValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "suggested-value",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_SupportedLocale(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "supported-locale",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ToViewId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "to-view-id",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Validator(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validator",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ValidatorClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validator-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ValidatorId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validator-id",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_Value(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ValueClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value-class",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_VariableResolver(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "variable-resolver",
             "namespace", "##targetNamespace"
           });			
        addAnnotation
          (getDocumentRoot_ViewHandler(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "view-handler",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getExtensionType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getExtensionType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (facesConfigTypeEClass, 
           source, 
           new String[] {
             "name", "faces-config_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getFacesConfigType_Application(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "application",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Factory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "factory",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Component(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Converter(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "converter",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_ManagedBean(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_NavigationRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "navigation-rule",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_ReferencedBean(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "referenced-bean",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_RenderKit(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Lifecycle(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "lifecycle",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Validator(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validator",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Xmlns(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xmlns",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacesConfigType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (facesContextFactoryTypeEClass, 
           source, 
           new String[] {
             "name", "faces-context-factory_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getFacesContextFactoryType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getFacesContextFactoryType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (facetExtensionTypeEClass, 
           source, 
           new String[] {
             "name", "facet-extension_._type"
           });		
        addAnnotation
          (facetNameTypeEClass, 
           source, 
           new String[] {
             "name", "facet-name_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getFacetNameType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getFacetNameType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (facetTypeEClass, 
           source, 
           new String[] {
             "name", "facet_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getFacetType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacetType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacetType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacetType_FacetName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacetType_FacetExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet-extension",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFacetType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (factoryTypeEClass, 
           source, 
           new String[] {
             "name", "factory_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getFactoryType_ApplicationFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "application-factory",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFactoryType_FacesContextFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "faces-context-factory",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFactoryType_LifecycleFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "lifecycle-factory",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFactoryType_RenderKitFactory(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit-factory",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getFactoryType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (fromActionTypeEClass, 
           source, 
           new String[] {
             "name", "from-action_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getFromActionType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getFromActionType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (fromOutcomeTypeEClass, 
           source, 
           new String[] {
             "name", "from-outcome_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getFromOutcomeType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getFromOutcomeType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (fromViewIdTypeEClass, 
           source, 
           new String[] {
             "name", "from-view-id_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getFromViewIdType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getFromViewIdType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (iconTypeEClass, 
           source, 
           new String[] {
             "name", "icon_._type",
             "kind", "empty"
           });		
        addAnnotation
          (getIconType_SmallIcon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "small-icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getIconType_LargeIcon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "large-icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getIconType_Lang(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "lang",
             "namespace", "http://www.w3.org/XML/1998/namespace"
           });		
        addAnnotation
          (getIconType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (keyClassTypeEClass, 
           source, 
           new String[] {
             "name", "key-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getKeyClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getKeyClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (keyTypeEClass, 
           source, 
           new String[] {
             "name", "key_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getKeyType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getKeyType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (largeIconTypeEClass, 
           source, 
           new String[] {
             "name", "large-icon_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getLargeIconType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getLargeIconType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (lifecycleFactoryTypeEClass, 
           source, 
           new String[] {
             "name", "lifecycle-factory_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getLifecycleFactoryType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getLifecycleFactoryType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (lifecycleTypeEClass, 
           source, 
           new String[] {
             "name", "lifecycle_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getLifecycleType_PhaseListener(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "phase-listener",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getLifecycleType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (listEntriesTypeEClass, 
           source, 
           new String[] {
             "name", "list-entries_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getListEntriesType_ValueClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getListEntriesType_NullValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "null-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getListEntriesType_Value(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getListEntriesType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (localeConfigTypeEClass, 
           source, 
           new String[] {
             "name", "locale-config_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getLocaleConfigType_DefaultLocale(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-locale",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getLocaleConfigType_SupportedLocale(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "supported-locale",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getLocaleConfigType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (managedBeanClassTypeEClass, 
           source, 
           new String[] {
             "name", "managed-bean-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getManagedBeanClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getManagedBeanClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (managedBeanNameTypeEClass, 
           source, 
           new String[] {
             "name", "managed-bean-name_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getManagedBeanNameType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getManagedBeanNameType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (managedBeanScopeTypeEClass, 
           source, 
           new String[] {
             "name", "managed-bean-scope_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getManagedBeanScopeType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getManagedBeanScopeType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (managedBeanTypeEClass, 
           source, 
           new String[] {
             "name", "managed-bean_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getManagedBeanType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_ManagedBeanName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_ManagedBeanClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_ManagedBeanScope(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-bean-scope",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_ManagedProperty(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "managed-property",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_MapEntries(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "map-entries",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_ListEntries(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "list-entries",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedBeanType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (managedPropertyTypeEClass, 
           source, 
           new String[] {
             "name", "managed-property_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getManagedPropertyType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_PropertyName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_PropertyClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_MapEntries(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "map-entries",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_NullValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "null-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_Value(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_ListEntries(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "list-entries",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getManagedPropertyType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (mapEntriesTypeEClass, 
           source, 
           new String[] {
             "name", "map-entries_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getMapEntriesType_KeyClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "key-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getMapEntriesType_ValueClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getMapEntriesType_MapEntry(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "map-entry",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getMapEntriesType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (mapEntryTypeEClass, 
           source, 
           new String[] {
             "name", "map-entry_._type",
             "kind", "empty"
           });		
        addAnnotation
          (getMapEntryType_Key(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "key",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getMapEntryType_NullValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "null-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getMapEntryType_Value(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getMapEntryType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (messageBundleTypeEClass, 
           source, 
           new String[] {
             "name", "message-bundle_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getMessageBundleType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getMessageBundleType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (navigationCaseTypeEClass, 
           source, 
           new String[] {
             "name", "navigation-case_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getNavigationCaseType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_FromAction(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "from-action",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_FromOutcome(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "from-outcome",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_ToViewId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "to-view-id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_Redirect(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "redirect",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationCaseType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (navigationHandlerTypeEClass, 
           source, 
           new String[] {
             "name", "navigation-handler_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getNavigationHandlerType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getNavigationHandlerType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (navigationRuleTypeEClass, 
           source, 
           new String[] {
             "name", "navigation-rule_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getNavigationRuleType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationRuleType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationRuleType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationRuleType_FromViewId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "from-view-id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationRuleType_NavigationCase(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "navigation-case",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getNavigationRuleType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (nullValueTypeEClass, 
           source, 
           new String[] {
             "name", "null-value_._type",
             "kind", "empty"
           });		
        addAnnotation
          (getNullValueType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (phaseListenerTypeEClass, 
           source, 
           new String[] {
             "name", "phase-listener_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getPhaseListenerType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getPhaseListenerType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (propertyClassTypeEClass, 
           source, 
           new String[] {
             "name", "property-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getPropertyClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getPropertyClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (propertyExtensionTypeEClass, 
           source, 
           new String[] {
             "name", "property-extension_._type"
           });		
        addAnnotation
          (propertyNameTypeEClass, 
           source, 
           new String[] {
             "name", "property-name_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getPropertyNameType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getPropertyNameType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (propertyResolverTypeEClass, 
           source, 
           new String[] {
             "name", "property-resolver_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getPropertyResolverType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getPropertyResolverType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (propertyTypeEClass, 
           source, 
           new String[] {
             "name", "property_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPropertyType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_PropertyName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_PropertyClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_DefaultValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "default-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_SuggestedValue(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "suggested-value",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_PropertyExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property-extension",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getPropertyType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (redirectTypeEClass, 
           source, 
           new String[] {
             "name", "redirect_._type",
             "kind", "empty"
           });		
        addAnnotation
          (getRedirectType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (referencedBeanClassTypeEClass, 
           source, 
           new String[] {
             "name", "referenced-bean-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getReferencedBeanClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getReferencedBeanClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (referencedBeanNameTypeEClass, 
           source, 
           new String[] {
             "name", "referenced-bean-name_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getReferencedBeanNameType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getReferencedBeanNameType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (referencedBeanTypeEClass, 
           source, 
           new String[] {
             "name", "referenced-bean_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getReferencedBeanType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getReferencedBeanType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getReferencedBeanType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getReferencedBeanType_ReferencedBeanName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "referenced-bean-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getReferencedBeanType_ReferencedBeanClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "referenced-bean-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getReferencedBeanType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (rendererClassTypeEClass, 
           source, 
           new String[] {
             "name", "renderer-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getRendererClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getRendererClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (rendererExtensionTypeEClass, 
           source, 
           new String[] {
             "name", "renderer-extension_._type"
           });		
        addAnnotation
          (rendererTypeEClass, 
           source, 
           new String[] {
             "name", "renderer_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getRendererType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_ComponentFamily(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "component-family",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_RendererType(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer-type",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_RendererClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_Facet(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "facet",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_RendererExtension(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer-extension",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRendererType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (rendererTypeTypeEClass, 
           source, 
           new String[] {
             "name", "renderer-type_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getRendererTypeType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getRendererTypeType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (renderKitClassTypeEClass, 
           source, 
           new String[] {
             "name", "render-kit-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getRenderKitClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getRenderKitClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (renderKitFactoryTypeEClass, 
           source, 
           new String[] {
             "name", "render-kit-factory_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getRenderKitFactoryType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getRenderKitFactoryType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (renderKitIdTypeEClass, 
           source, 
           new String[] {
             "name", "render-kit-id_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getRenderKitIdType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getRenderKitIdType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (renderKitTypeEClass, 
           source, 
           new String[] {
             "name", "render-kit_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getRenderKitType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRenderKitType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRenderKitType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRenderKitType_RenderKitId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit-id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRenderKitType_RenderKitClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "render-kit-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRenderKitType_Renderer(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "renderer",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getRenderKitType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (smallIconTypeEClass, 
           source, 
           new String[] {
             "name", "small-icon_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getSmallIconType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getSmallIconType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (stateManagerTypeEClass, 
           source, 
           new String[] {
             "name", "state-manager_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getStateManagerType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getStateManagerType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (suggestedValueTypeEClass, 
           source, 
           new String[] {
             "name", "suggested-value_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getSuggestedValueType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getSuggestedValueType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (supportedLocaleTypeEClass, 
           source, 
           new String[] {
             "name", "supported-locale_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getSupportedLocaleType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getSupportedLocaleType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (toViewIdTypeEClass, 
           source, 
           new String[] {
             "name", "to-view-id_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getToViewIdType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getToViewIdType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (validatorClassTypeEClass, 
           source, 
           new String[] {
             "name", "validator-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getValidatorClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getValidatorClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (validatorIdTypeEClass, 
           source, 
           new String[] {
             "name", "validator-id_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getValidatorIdType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getValidatorIdType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (validatorTypeEClass, 
           source, 
           new String[] {
             "name", "validator_._type",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getValidatorType_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_DisplayName(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "display-name",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_Icon(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "icon",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_ValidatorId(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validator-id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_ValidatorClass(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validator-class",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getValidatorType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (valueClassTypeEClass, 
           source, 
           new String[] {
             "name", "value-class_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getValueClassType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getValueClassType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (valueTypeEClass, 
           source, 
           new String[] {
             "name", "value_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getValueType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getValueType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (variableResolverTypeEClass, 
           source, 
           new String[] {
             "name", "variable-resolver_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getVariableResolverType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getVariableResolverType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (viewHandlerTypeEClass, 
           source, 
           new String[] {
             "name", "view-handler_._type",
             "kind", "simple"
           });		
        addAnnotation
          (getViewHandlerType_TextContent(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });		
        addAnnotation
          (getViewHandlerType_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });
    }

} //FacesConfigPackageImpl
