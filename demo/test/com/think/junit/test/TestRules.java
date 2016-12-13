package com.think.junit.test;

import com.think.junit.DigitalAssetManager;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 */
public class TestRules {

    @Rule
    public TemporaryFolder mTemporaryFolder = new TemporaryFolder();

    @Rule
    public ExpectedException mException = ExpectedException.none();

    @Test public void countsAssets() throws IOException {
        File icon = mTemporaryFolder.newFile("icon.png");
        File assets = mTemporaryFolder.newFolder("assets");

        createAssets(assets, 3);

        DigitalAssetManager dam = new DigitalAssetManager(icon, assets);

        Assert.assertEquals(3, dam.getAssetCount());
    }

    private void createAssets(File assets, int numOfAssets) throws IOException {
        for (int index = 0; index < numOfAssets; index++) {
            File asset = new File(assets, String.format("asset-%d.mpg", index));
            Assert.assertTrue("Asset couldn't be created.", asset.createNewFile());
        }
    }

    @Test public void throwsIllgalArgumentExceptionifIconIsNull() {
        mException.expect(IllegalArgumentException.class);
        mException.expectMessage("Icon is null, not a file, or doesn't exist.");
        new DigitalAssetManager(null, null);
    }
}
