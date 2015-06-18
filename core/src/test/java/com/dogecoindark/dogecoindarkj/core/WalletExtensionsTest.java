package com.dogecoindark.dogecoindarkj.core;

import com.dogecoindark.dogecoindarkj.testing.FooWalletExtension;
import com.dogecoindark.dogecoindarkj.testing.TestWithWallet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WalletExtensionsTest extends TestWithWallet {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test(expected = java.lang.IllegalStateException.class)
    public void duplicateWalletExtensionTest() {
        wallet.addExtension(new FooWalletExtension("com.whatever.required", true));
        wallet.addExtension(new FooWalletExtension("com.whatever.required", true));
    }
}
