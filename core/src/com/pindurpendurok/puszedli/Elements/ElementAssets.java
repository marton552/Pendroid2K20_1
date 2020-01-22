package com.pindurpendurok.puszedli.Elements;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;

public class ElementAssets {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(SimpleButton.class, list);
        AssetList.collectAssetDescriptor(SimpleLabel.class, list);
        AssetList.collectAssetDescriptor(ProgressBar.class, list);

    }
}
