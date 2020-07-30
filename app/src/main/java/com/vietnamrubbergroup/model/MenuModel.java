package com.vietnamrubbergroup.model;

/**
 * Created by Nguyen Kim Khanh on 7/29/2020.
 */
public class MenuModel {
    public int menuName;
    public int idFragment;
    public int idImg;
    public boolean hasChildren, isGroup;

    public MenuModel(int menuName, int idFragment, boolean hasChildren, boolean isGroup, int idImg) {
        this.menuName = menuName;
        this.idFragment = idFragment;
        this.hasChildren = hasChildren;
        this.isGroup = isGroup;
        this.idImg = idImg;
    }
}
