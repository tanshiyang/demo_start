package com.example.svn;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

public class SvnKitTest {
    public void test1()
    {
        try {
            SVNRepositoryFactoryImpl.setup();
            ISVNAuthenticationManager authManager;
            authManager = new BasicAuthenticationManager( "tsy" , "tsy" );
            SVNURL url = SVNURL.parseURIDecoded( "https://DESKTOP-1F213AC/svn/" );
            SVNRepository repository = SVNRepositoryFactory.create( url, null );
            repository.setAuthenticationManager(authManager);
        } catch (SVNException e) {
            System.out.println(e.getMessage());
        }
    }
}
