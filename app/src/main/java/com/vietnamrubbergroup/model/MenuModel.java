package com.vietnamrubbergroup.model;

/**
 * Created by Nguyen Kim Khanh on 7/29/2020.
 */
public class MenuModel {
    public int menuName;
    public int idFragment;
    public boolean hasChildren, isGroup;

    public MenuModel(int menuName, int idFragment, boolean hasChildren, boolean isGroup) {
        this.menuName = menuName;
        this.idFragment = idFragment;
        this.hasChildren = hasChildren;
        this.isGroup = isGroup;
    }

    public int getMenuName() {
        return menuName;
    }

    public void setMenuName(int menuName) {
        this.menuName = menuName;
    }

    public int getIdFragment() {
        return idFragment;
    }

    public void setIdFragment(int idFragment) {
        this.idFragment = idFragment;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }
}
