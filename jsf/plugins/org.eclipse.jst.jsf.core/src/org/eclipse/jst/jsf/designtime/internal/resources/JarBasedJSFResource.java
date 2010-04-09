package org.eclipse.jst.jsf.designtime.internal.resources;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import org.eclipse.jst.jsf.common.internal.resource.ContentTypeResolver;

/**
 * A JSF Resource that references an entry in the jar. Because of changes in the
 * underlying system since it was created, there is no guarantee that the jarURI
 * is still valid. Callers should call isAccessible to determine this.
 * 
 * @author cbateman
 * 
 */
public class JarBasedJSFResource extends JSFResource
{

    private final URL _jarURL;

    /**
     * @param id
     * @param jarURL
     * @param contentTypeResolver 
     */
    public JarBasedJSFResource(final ResourceIdentifier id, final URL jarURL,  final ContentTypeResolver contentTypeResolver)
    {
        super(id, contentTypeResolver);
        _jarURL = jarURL;
    }

    /**
     * @return the uri pointing in the the jar where the resource lives.
     */
    public final URL getJarURL()
    {
        return _jarURL;
    }

    /**
     * @return the jar entry name for this resource.
     */
    protected String getJarEntryName()
    {
        return String.format("META-INF/resources/%s", getId().toString()); //$NON-NLS-1$
    }

    /**
     * @return true if is accessible.
     */
    @Override
    public final boolean isAccessible()
    {
        URLConnection connection = null;
        try
        {
            connection = _jarURL.openConnection();
            connection.connect();
            if (connection instanceof JarURLConnection)
            {
                JarFile jarFile = ((JarURLConnection)connection).getJarFile();
                ZipEntry entry = jarFile.getEntry(getJarEntryName());
                return entry != null;
            }
        } catch (IOException e)
        {
            // fall-through
        }
        return false;
    }
}
