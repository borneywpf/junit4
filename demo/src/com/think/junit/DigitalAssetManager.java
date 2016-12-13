package com.think.junit;

import java.io.File;

/**
 * Created by borney on 12/13/16.
 */
public class DigitalAssetManager {

    private File icon;
    private File assets;

    public DigitalAssetManager(File icon, File assets) {
        if (icon == null || !icon.isFile() || !icon.exists()) {
            throw new IllegalArgumentException("Icon is null, not a file, or doesn't exist.");
        }
        if (assets == null || !assets.isFile() || !assets.exists() || !assets.isDirectory()) {
            throw new IllegalArgumentException("Assets is null, not a file, or doesn't exist, or not a directory");
        }
        this.icon = icon;
        this.assets = assets;
    }

    public int getAssetCount() {
        return assets.listFiles().length;
    }
}
