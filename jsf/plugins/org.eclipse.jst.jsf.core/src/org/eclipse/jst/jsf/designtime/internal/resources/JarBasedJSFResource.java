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
    public JarBasedJSFResource(final ResourceIdentifier id, final URL jarURL,
            final ContentTypeResolver contentTypeResolver)
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

    private ZipEntry getZipEntry(final JarFile jarFile)
    {
        return jarFile.getEntry(getJarEntryName());
    }

    /**
     * @return true if is accessible.
     */
    @Override
    public final boolean isAccessible()
    {
        JarFile jarFile = null;
        try
        {
            jarFile = getJarFile();
            if (jarFile != null)
            {
                final ZipEntry entry = getZipEntry(jarFile);
                return entry != null;
            }
        } finally
        {
            if (jarFile != null)
            {
//                try
//                {
//                    // TODO
////                    jarFile.close();
//                } /*catch (IOException e)
//                {
//                    // fall-through.
//                }*/
            }
        }
        return false;
    }

    private JarFile getJarFile()
    {
        URLConnection connection;
        try
        {
            connection = _jarURL.openConnection();
            connection.connect();
            if (connection instanceof JarURLConnection)
            {
                return ((JarURLConnection) connection).getJarFile();
            }
        } catch (IOException e)
        {
            // fall through
        }
        return null;
    }

    @Override
    public boolean isFragment()
    {
        JarFile jarFile = null;
        try
        {
            jarFile = getJarFile();
            if (jarFile != null)
            {
                final ZipEntry entry = getZipEntry(jarFile);
                return entry.isDirectory();
            }
        } finally
        {
            if (jarFile != null)
            {
                // TODO:
//                try
//                {
//                    jarFile.close();
//                } catch (IOException e)
//                {
//                    // fall-through.
//                }
            }
        }
        return false;
    }
}
