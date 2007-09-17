package org.eclipse.jst.jsf.designtime.tests;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.jst.jsf.context.symbol.ISymbol;
import org.eclipse.jst.jsf.context.symbol.source.ISymbolConstants;
import org.eclipse.jst.jsf.core.IJSFCoreConstants;
import org.eclipse.jst.jsf.core.tests.util.JSFFacetedTestEnvironment;
import org.eclipse.jst.jsf.designtime.internal.jsp.JSPModelProcessor;
import org.eclipse.jst.jsf.test.util.JDTTestEnvironment;
import org.eclipse.jst.jsf.test.util.JSFTestUtil;
import org.eclipse.jst.jsf.test.util.TestFileResource;
import org.eclipse.jst.jsf.test.util.WebProjectTestEnvironment;

public class TestJSPModelProcessor extends TestCase 
{
    private static final int NUM_JSPS = 25;
    private IFile _testJSP1;
    private List<IFile> _jsps;
    
    private JSFFacetedTestEnvironment _jsfFactedTestEnvironment;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        JSFTestUtil.setValidationEnabled(false);
        JSFTestUtil.setInternetProxyPreferences(true, "www-proxy.us.oracle.com","80");

        final WebProjectTestEnvironment  projectTestEnvironment = 
            new WebProjectTestEnvironment("TestJSPModelProcessor_"+getName());
        projectTestEnvironment.createProject(false);

        JDTTestEnvironment jdtTestEnvironment = 
            new JDTTestEnvironment(projectTestEnvironment);

        final TestFileResource input = new TestFileResource();
        input.load(DesignTimeTestsPlugin.getDefault().getBundle(), 
                "/testdata/bundle1.resources.data");
        jdtTestEnvironment.addResourceFile("src"
                , new ByteArrayInputStream(input.toBytes())
                , "bundles", "bundle1.properties");
        
        _testJSP1 = (IFile) projectTestEnvironment.loadResourceInWebRoot(DesignTimeTestsPlugin.getDefault().getBundle()
                , "/testdata/testdata1.jsp.data", "testdata1.jsp");

        _jsps = new ArrayList<IFile>(NUM_JSPS);
        for (int i = 0; i < NUM_JSPS; i++)
        {
            _jsps.add((IFile) projectTestEnvironment.loadResourceInWebRoot(DesignTimeTestsPlugin.getDefault().getBundle()
                , "/testdata/testdata1.jsp.data", "testdata_"+i+".jsp"));
        }

        _jsfFactedTestEnvironment = new JSFFacetedTestEnvironment(projectTestEnvironment);
        _jsfFactedTestEnvironment.initialize(IJSFCoreConstants.FACET_VERSION_1_1);    
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public void testGet() throws Exception
    {
        JSPModelProcessor processor = JSPModelProcessor.get(_testJSP1);
        assertNotNull(processor);
        assertFalse(processor.isDisposed());
    }

    public void testGetMapForScope() throws Exception
    {
        // if we not refreshed yet, then should be no symbols
        JSPModelProcessor processor = JSPModelProcessor.get(_testJSP1);
        assertNotNull(processor);

         Map<Object, ISymbol> scopeMap = 
            processor.getMapForScope(ISymbolConstants.SYMBOL_SCOPE_REQUEST_STRING);
        assertTrue(scopeMap.isEmpty());

        scopeMap = 
            processor.getMapForScope(ISymbolConstants.SYMBOL_SCOPE_SESSION_STRING);
        assertTrue(scopeMap.isEmpty());

        scopeMap = 
            processor.getMapForScope(ISymbolConstants.SYMBOL_SCOPE_APPLICATION_STRING);
        assertTrue(scopeMap.isEmpty());

        scopeMap = 
            processor.getMapForScope(ISymbolConstants.SYMBOL_SCOPE_NONE_STRING);
        assertTrue(scopeMap.isEmpty());
    }

    public void testRefreshAndGet() throws Exception
    {
        // if we not refreshed yet, then should be no symbols
        JSPModelProcessor processor = JSPModelProcessor.get(_testJSP1);
        assertNotNull(processor);

        Map<Object, ISymbol> scopeMap = 
            processor.getMapForScope(ISymbolConstants.SYMBOL_SCOPE_REQUEST_STRING);
        assertTrue(scopeMap.isEmpty());

        processor.refresh(false);

        // after refresh we should have a symbol for the loadBundle and the dataTable
        scopeMap = 
            processor.getMapForScope(ISymbolConstants.SYMBOL_SCOPE_REQUEST_STRING);
        assertFalse(scopeMap.isEmpty());
        assertEquals(2, scopeMap.size());
    }

    public void testFileDeletion_RegressionBug199480() throws Exception
    {
        // Regression for bug 199480
        // ensure that the deletion of a resource with a JSPModelProcessor
        // on it without an editor close event is still disposed of due
        // to the resource change event.
        // if we not refreshed yet, then should be no symbols
        JSPModelProcessor processor = JSPModelProcessor.get(_testJSP1);
        assertNotNull(processor);
        assertFalse(processor.isDisposed());

        _testJSP1.delete(true, null);
        // file is deleted, so the processor should dispose itself on the 
        // resource change event
        assertTrue(processor.isDisposed());
    }
    
    public void testProjectClosure() throws Exception
    {
        // ensure that if the enclosing project of the associated IFile
        // is closed, then the processor gets disposed
        JSPModelProcessor processor = JSPModelProcessor.get(_testJSP1);
        assertNotNull(processor);
        assertFalse(processor.isDisposed());

        _testJSP1.getProject().close(null);

        // file is deleted, so the processor should dispose itself on the 
        // resource change event
        assertTrue(processor.isDisposed());
    }

    public void testProjectDeletion() throws Exception
    {
        // ensure that if the enclosing project of the associated IFile
        // is deleted, then the processor gets disposed
        JSPModelProcessor processor = JSPModelProcessor.get(_testJSP1);
        assertNotNull(processor);
        assertFalse(processor.isDisposed());

        _testJSP1.getProject().delete(true,null);

        // file is deleted, so the processor should dispose itself on the 
        // resource change event
        assertTrue(processor.isDisposed());
    }
    
    public void testChangeRefresh() throws Exception
    {
        // random order of access to the jsps, but always the same between runs
        final int order[] = new int[] {6,19,10,16,14,4,13,11,24,2,3,23,20,15,17,9,1,5,22,12,21,8,18,0,7};
        assertEquals(NUM_JSPS, order.length);
        
        for (int i = 0; i < order.length; i++)
        {
            final IFile file = _jsps.get(order[i]);
            JSPModelProcessor processor = JSPModelProcessor.get(file);
            // the processor model should start out dirty since it won't
            // get refreshed unless the resource detects a change or if
            // it is explicitly refreshed
            assertTrue(processor.isModelDirty()); 

            // this should trigger a change event and update the model
            file.touch(null);
            
            assertFalse(processor.isModelDirty());

            // now delete the file and ensure the processor is disposed
            file.delete(true, null);

            assertTrue(processor.isDisposed());
        }
    }

    public void testExplicitRefresh() throws Exception
    {
        // random order of access to the jsps, but always the same between runs
        final int order[] = new int[] {6,19,10,16,14,4,13,11,24,2,3,23,20,15,17,9,1,5,22,12,21,8,18,0,7};
        assertEquals(NUM_JSPS, order.length);
        
        for (int i = 0; i < order.length; i++)
        {
            final IFile file = _jsps.get(order[i]);
            JSPModelProcessor processor = JSPModelProcessor.get(file);
            // the processor model should start out dirty since it won't
            // get refreshed unless the resource detects a change or if
            // it is explicitly refreshed
            assertTrue(processor.isModelDirty()); 

            // since the model is dirty this should trigger a refresh
            processor.refresh(false);
            
            assertFalse(processor.isModelDirty());

            // now delete the file and ensure the processor is disposed
            file.delete(true, null);

            assertTrue(processor.isDisposed());
        }
    }
    
    public static void main(String[] args)
    {
       Set<Integer> set = new TreeSet<Integer>();
       
       Random random = new Random();
       
       while(set.size() < NUM_JSPS)
       {
           Integer value = Integer.valueOf(Math.abs(random.nextInt()) % NUM_JSPS);
           
           if (!set.contains(value))
           {
               System.out.printf("%d,", value);
               set.add(value);
           }
       }
    }
}

