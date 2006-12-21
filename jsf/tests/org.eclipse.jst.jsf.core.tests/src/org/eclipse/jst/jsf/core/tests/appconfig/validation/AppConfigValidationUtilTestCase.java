package org.eclipse.jst.jsf.core.tests.appconfig.validation;



import junit.framework.TestCase;

import org.eclipse.jst.jsf.validation.internal.appconfig.AppConfigValidationUtil;
import org.eclipse.jst.jsf.validation.internal.appconfig.DiagnosticFactory;
import org.eclipse.jst.jsf.validation.internal.appconfig.ILocalizedMessage;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;

/**
 * Unit tests for AppConfigValidationUtil
 * 
 * @author cbateman
 *
 */
public class AppConfigValidationUtilTestCase extends TestCase 
{
    /**
     * test validateELExpression method
     */
    public void testValidateELExpression()
    {
        final String validELString1 = "#{x.y}";
        final String validELString2 = "#{a.b.c}";
        final String inValidEmptyExpr = "#{}";
        final String inValidNoBraces = "x.y";
        final String inValidSyntaxInEL = "#{x.[}";
        
        assertNull(AppConfigValidationUtil.validateELExpression(validELString1));
        assertNull(AppConfigValidationUtil.validateELExpression(validELString2));
        
        IMessage message = AppConfigValidationUtil.validateELExpression(inValidEmptyExpr);
        assertNotNull(message);
        assertEquals(DiagnosticFactory.SYNTAX_ERROR_IN_EL_ID, 
                ((ILocalizedMessage)message).getErrorCode());
        
        message = AppConfigValidationUtil.validateELExpression(inValidNoBraces);
        assertNotNull(message);
        assertEquals(DiagnosticFactory.EL_EXPR_MUST_BE_IN_HASH_BRACES_ID, 
                ((ILocalizedMessage)message).getErrorCode());

        message = AppConfigValidationUtil.validateELExpression(inValidSyntaxInEL);
        assertNotNull(message);
        assertEquals(DiagnosticFactory.SYNTAX_ERROR_IN_EL_ID, 
                ((ILocalizedMessage)message).getErrorCode());
    }
}
