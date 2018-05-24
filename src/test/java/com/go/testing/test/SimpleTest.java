package com.go.testing.test;


import com.go.testing.scanner.PkgScanner;
import com.go.testing.test.annotation.Component;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by whf on 8/29/15.
 */
@Component
public class SimpleTest {

    @Test
    public void testScanWithName() throws IOException {
        PkgScanner scanner = new PkgScanner("cn.fh.pkgscanner");
        List<String> list = scanner.scan();

        Assert.assertTrue(list.indexOf("cn.fh.pkgscanner.PathUtils") != -1);
        Assert.assertTrue(list.indexOf("cn.fh.pkgscanner.PkgScanner") != -1);
        Assert.assertTrue(list.indexOf("cn.fh.pkgscanner.ResourceType") != -1);
    }

    @Test
    public void testScanWithAnnotation() throws IOException {
        PkgScanner scanner = new PkgScanner("cn.fh.pkgscanner.test", Component.class);
        List<String> list = scanner.scan();

        Assert.assertTrue(list.indexOf("SimpleTest") != -1);
        Assert.assertTrue(list.indexOf("CannotFindThis") == -1);

    }
}
