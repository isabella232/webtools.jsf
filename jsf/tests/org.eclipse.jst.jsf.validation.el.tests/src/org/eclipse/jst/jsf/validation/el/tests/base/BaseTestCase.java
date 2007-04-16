package org.eclipse.jst.jsf.validation.el.tests.base;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jst.jsf.context.resolver.structureddocument.IStructuredDocumentContextResolverFactory;
import org.eclipse.jst.jsf.context.resolver.structureddocument.internal.ITextRegionContextResolver;
import org.eclipse.jst.jsf.context.structureddocument.IStructuredDocumentContext;
import org.eclipse.jst.jsf.context.structureddocument.IStructuredDocumentContextFactory;
import org.eclipse.jst.jsf.core.IJSFCoreConstants;
import org.eclipse.jst.jsf.core.jsfappconfig.JSFAppConfigManager;
import org.eclipse.jst.jsf.core.tests.util.JSFFacetedTestEnvironment;
import org.eclipse.jst.jsf.facesconfig.emf.ManagedBeanType;
import org.eclipse.jst.jsf.test.util.JDTTestEnvironment;
import org.eclipse.jst.jsf.test.util.JSFTestUtil;
import org.eclipse.jst.jsf.test.util.TestFileResource;
import org.eclipse.jst.jsf.test.util.WebProjectTestEnvironment;
import org.eclipse.jst.jsf.validation.el.tests.ELValidationTestPlugin;
import org.eclipse.jst.jsf.validation.internal.el.ELExpressionValidator;
import org.eclipse.jst.jsf.validation.internal.el.diagnostics.IELLocalizedMessage;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;

/**
 * Base class for all JSP test cases in this plugin
 * 
 * @author cbateman
 *
 */
public class BaseTestCase extends TestCase 
{
	/**
	 * The dynamic web project test environment
	 */
	protected WebProjectTestEnvironment  _testEnv;
	/**
	 * A handle to the Java project test environment
	 */
	protected JDTTestEnvironment         _jdtTestEnv;
    
	protected void setUp() throws Exception    
	{
		super.setUp();

        JSFTestUtil.setValidationEnabled(false);
        
        JSFTestUtil.setInternetProxyPreferences(true, "www-proxy.us.oracle.com", "80");
        
        _testEnv = new WebProjectTestEnvironment("ELValidationTest_"+this.getClass().getName()+"_"+getName());
        _testEnv.createProject();
        assertNotNull(_testEnv);       
        assertNotNull(_testEnv.getTestProject());
        assertTrue(_testEnv.getTestProject().isAccessible());

        JSFFacetedTestEnvironment jsfFacedEnv = new JSFFacetedTestEnvironment(_testEnv);
        jsfFacedEnv.initialize(IJSFCoreConstants.FACET_VERSION_1_1);

        _testEnv.loadResourceInWebRoot(ELValidationTestPlugin.getDefault().getBundle(),
                                      "/testdata/web/faces-config.xml.data", 
                                      "/WEB-INF/faces-config.xml");

        _jdtTestEnv = new JDTTestEnvironment(_testEnv);

        TestFileResource resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/MyBean.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "MyBean", resource.toString());

        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/MapBean.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "MapBean", resource.toString());

        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/MyBeanSettable.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "MyBeanSettable", resource.toString());

        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/MyBeanSubClass.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "MyBeanSubClass", resource.toString());

        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/BeanWithMapProperties.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "BeanWithMapProperties", resource.toString());

        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/BeanWithListProperties.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "BeanWithListProperties", resource.toString());
        
        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/ListBean.java.data");
        _jdtTestEnv.addSourceFile("src", "beans", "ListBean", resource.toString());
        
        resource = new TestFileResource();
        resource.load(ELValidationTestPlugin.getDefault().getBundle(), 
                      "/testdata/classes/Bundle.properties.data");
        _jdtTestEnv.addResourceFile("src", new ByteArrayInputStream(resource.toBytes()), 
                      "beans", "Bundle.properties");

	}
    
    protected void tearDown() throws Exception
    {
        _testEnv.getTestProject().close(null);
        //_testEnv.getTestProject().delete(true, null);
    }
    
    /**
     * Performs pre-condition and other sanity checks on what was done in setUp()
     */
    public void testSanity()
    {
        final IJavaProject javaProject = _jdtTestEnv.getJavaProject(); 
        assertNotNull(javaProject);
        
        try
        {
            IType type = javaProject.findType("beans.MyBean");
            assertNotNull(type);
            
            type = javaProject.findType("beans.MapBean");
            assertNotNull(type);

            type = javaProject.findType("beans.MyBeanSettable");
            assertNotNull(type);

            type = javaProject.findType("beans.MyBeanSubClass");
            assertNotNull(type);
            
            type = javaProject.findType("beans.BeanWithMapProperties");
            assertNotNull(type);

            type = javaProject.findType("beans.BeanWithListProperties");
            assertNotNull(type);

            type = javaProject.findType("beans.ListBean");
            assertNotNull(type);

            IPackageFragmentRoot srcRoot = _jdtTestEnv.getPackageFragmentRoot("src");
            assertTrue(srcRoot.exists());
            IPackageFragment frag = srcRoot.getPackageFragment("beans");
            assertTrue(frag.exists());
            IFolder res = (IFolder) frag.getResource();
            IFile bundleFile = res.getFile("Bundle.properties");
            assertTrue(bundleFile.exists());
            
            JSFAppConfigManager  cfgManager = 
                JSFAppConfigManager.getInstance(_jdtTestEnv.getProjectEnvironment().getTestProject());
            assertNotNull(cfgManager);
            
            List mbeans = cfgManager.getManagedBeans();
            Map  nameTest = new HashMap();
            
            for (final Iterator it = mbeans.iterator(); it.hasNext();)
            {
                ManagedBeanType  mbean = (ManagedBeanType) it.next();
                nameTest.put(mbean.getManagedBeanName().getTextContent(), mbean);
            }

            assertTrue(nameTest.containsKey("myBean"));
            assertTrue(nameTest.containsKey("mapBean"));
            assertTrue(nameTest.containsKey("myBeanSettable"));
            assertTrue(nameTest.containsKey("myBeanSubClass"));
            assertTrue(nameTest.containsKey("beanWithMapProperties"));
            assertTrue(nameTest.containsKey("beanWithListProperties"));
            assertTrue(nameTest.containsKey("listBean"));
        }
        catch(JavaModelException jme)
        {
            assertTrue("JDT error: "+jme.getLocalizedMessage(), false);
        }
        catch (CoreException ce)
        {
            assertTrue("Problem loading bundle: "+ce.getLocalizedMessage(), false);
        }
    }
    
    /**
     * @param document
     * @param docPos
     * @return the ELText at docPos in document or null if no such text
     */
    protected String getELText(IStructuredDocument document, int docPos)
    {
        final IStructuredDocumentContext context = 
            IStructuredDocumentContextFactory.INSTANCE.getContext(document, docPos);
        final ITextRegionContextResolver resolver =
            IStructuredDocumentContextResolverFactory.INSTANCE.getTextRegionResolver(context);
        return resolver.getRegionText();
    }
    
    /**
     * @param document
     * @param docPos
     * @param file
     * @return a new expression validator for docPos in the document
     */
    protected ELExpressionValidator createELValidator(IStructuredDocument document, int docPos, IFile file)
    {
        final String elText = getELText(document, docPos);
        final IStructuredDocumentContext context = 
            IStructuredDocumentContextFactory.INSTANCE.getContext(document, docPos);
        return new ELExpressionValidator(context, elText, file);
    }
    
    /**
     * Uses assertSyntaxProblems with max severity of error.
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedProblems
     * @return the list of found syntax problems
     */
    protected List assertSyntaxError(IStructuredDocument document, 
            int docPos, 
            IFile file, 
            int expectedProblems)
    {
        return assertSyntaxProblems(document, docPos, file, expectedProblems, IMessage.HIGH_SEVERITY/* "high" is Warning for some reason*/);
    }

    
    /**
     * Uses assertSyntaxProblems with max severity of warning.
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedProblems
     * @return the list of syntax problems
     */
    protected List assertSyntaxWarning(IStructuredDocument document, 
                                          int docPos, 
                                          IFile file, 
                                          int expectedProblems)
    {
        return assertSyntaxProblems(document, docPos, file, expectedProblems, IMessage.NORMAL_SEVERITY/* "normal" is Warning for some reason*/);
    }
    
    /**
     * Checks the el expression in document at docPos in file. Asserts
     * that there exactly the number of expectedProblems expected and that
     * the highest error severity is expectedMaxSeverity.  Returns the list
     * of syntax errors
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedProblems
     * @param expectedMaxSeverity
     * @return the (possibly empty) list of problems
     */
    protected List assertSyntaxProblems(IStructuredDocument document, 
                                          int docPos, 
                                          IFile file, 
                                          int expectedProblems,
                                          int expectedMaxSeverity)
    {
        final ELExpressionValidator validator = 
            createELValidator(document, docPos, file);
        validator.validateXMLNode();
        
        final List problems = validator.getSyntaxProblems();
        assertEquals(expectedProblems, problems.size());
        int worstSeverity = 0;
        
        for (final Iterator it = problems.iterator(); it.hasNext();)
        {
            IMessage message = (IMessage) it.next();
            
            // for some reason, the number values are lower for higher severity
            // constants
            worstSeverity = maxSeverity(worstSeverity, message.getSeverity());
        }
    
        
        assertEquals(expectedMaxSeverity, worstSeverity);
        
        return problems;
    }

    /**
     * Asserts that the provided expression generates no problem diagnostics 
     * whatsever and that the resolved type is as expected
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedSignature
     */
    protected void assertNoError(IStructuredDocument document, int docPos, IFile file, String expectedSignature)
    {
        assertNoError(document, docPos, file, expectedSignature, -1);
    }
    
    /**
     * Asserts that the provided expression generates no problem diagnostics 
     * whatsever and that the resolved type is as expected and checks assignability
     * if value positive, non-zero.
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedSignature
     * @param assignability 
     */
    protected void assertNoError(IStructuredDocument document, int docPos, IFile file, String expectedSignature, int assignability)
    {
        ELExpressionValidator validator = createELValidator(document, docPos, file);
        validator.validateXMLNode();
        assertEquals(0, validator.getSyntaxProblems().size());
        assertEquals(0, validator.getSemanticValidator().getMessages().size());

        if (expectedSignature != null)
        {
            assertNotNull(validator.getExpressionType());
            assertEquals(expectedSignature, validator.getExpressionType().getSignatures()[0]);
        }
        
        if (assignability >= 0)
        {
            assertEquals(assignability, validator.getExpressionType().getAssignmentTypeMask());
        }
    }
    
    /**
     * Asserts that the provided expression generates one or more problem 
     * diagnostics of which the most severe is of ERROR severity and that
     * the total number expected is returned 
     * Asserts also that no syntax errors are present.
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedSignature
     * @param expectedProblems 
     * @return the list of semantic warnings
     */
    protected List assertSemanticError(IStructuredDocument document, int docPos, IFile file, String expectedSignature, int expectedProblems)
    {
        return assertSemanticProblems(document, docPos, file, expectedSignature, expectedProblems, IMessage.HIGH_SEVERITY/* "high" is Error for some reason*/);
    }
    
    /**
     * Asserts that the provided expression generates one or more problem 
     * diagnostics of which the most severe is of WARNING severity and that
     * the total number expected is returned 
     * Asserts also that no syntax errors are present.
     * 
     * @param document
     * @param docPos
     * @param file
     * @param expectedSignature
     * @param expectedProblems 
     * @return the list of semantic warnings
     */
    protected List assertSemanticWarning(IStructuredDocument document, int docPos, IFile file, String expectedSignature, int expectedProblems)
    {
        return assertSemanticProblems(document, docPos, file, expectedSignature, expectedProblems, IMessage.NORMAL_SEVERITY/* "normal" is Warning for some reason*/);
    }
    
    /**
     * @param document
     * @param docPos
     * @param file
     * @param expectedSignature
     * @param expectedProblems
     * @param expectedMaxSeverity
     * @return the list of semantic problems found
     */
    protected List assertSemanticProblems(IStructuredDocument document, 
                                          int docPos, 
                                          IFile file, 
                                          String expectedSignature, 
                                          int expectedProblems,
                                          int expectedMaxSeverity)
    {
        final ELExpressionValidator validator = 
                createELValidator(document, docPos, file);
        validator.validateXMLNode();
        
        if (expectedSignature != null
                && validator.getExpressionType() != null)
        {
            assertEquals(expectedSignature, validator.getExpressionType().getSignatures()[0]);
        }
        
        assertEquals(0, validator.getSyntaxProblems().size());
        final List problems = validator.getSemanticValidator().getMessages();
        assertEquals(expectedProblems, problems.size());
        int worstSeverity = 0;
        
        for (final Iterator it = problems.iterator(); it.hasNext();)
        {
            IMessage message = (IMessage) it.next();
            
            // for some reason, the number values are lower for higher severity
            // constants
            worstSeverity = maxSeverity(worstSeverity, message.getSeverity());
        }

        
        assertEquals(expectedMaxSeverity, worstSeverity);
        
        return problems;
    }
    
    /**
     * Asserts that the list of problems contains one whose id == code
     * 
     * @param problems
     * @param code
     */
    protected void assertContainsProblem(List problems, int code)
    {
        assertContainsProblem(problems, code, -1, -1);
    }
    
    /**
     * Asserts that the list of problems contains one whose id == code
     * If startPos > -1, also checks the offset and length on the matching
     * problem against startPos and length
     * 
     * @param problems
     * @param code
     * @param startPos
     * @param length
     */
    protected void assertContainsProblem(List problems, int code, int startPos, int length)
    {
        Set  probsFound = new HashSet();
        
        for (final Iterator it = problems.iterator(); it.hasNext();)
        {
            Object probObj = it.next();
            
            if (probObj instanceof IELLocalizedMessage)
            {
                final IELLocalizedMessage localizedMsg = (IELLocalizedMessage) probObj;
                probsFound.add(new Integer(localizedMsg.getErrorCode()));
                if (localizedMsg.getErrorCode() == code)
                {
                    assertTrue("Offset of message must be >= 0", localizedMsg.getOffset()>=0);
                    assertTrue("Length of message marker must be >=0", localizedMsg.getLength()>=0);
                    
                    if (startPos >= 0)
                    {
                        assertEquals("Offset must be == startPos", startPos, localizedMsg.getOffset());
                        assertEquals("Length must be == length", localizedMsg.getLength(), length);
                    }

                    // found the required code, so exit without throwing
                    // any error assertions
                    return;
                }
            }
        }
        // if we reach this point then we have not found the asserted
        // error code
        assertTrue("Expected find error code matching "+code+" found "+probsFound.toString(), false);
    }
    
    private static int maxSeverity(int sev1, int sev2)
    {
        if (sev1 == 0)
        {
            return sev2;
        }
        else if (sev2 == 0)
        {
            return sev1;
        }
        else
        {
            // if both are non-0, then the most sever is the lowest value
            return Math.min(sev1, sev2);
        }
    }
}