/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.ui.parts;

/**
 *
 * @author Artur Tomasi
 */
public class PortletInfo 
{
    public enum PortletType 
    {
        IFRAME, INCLUDE;
    }
    
    private String urlMin;
    private String urlMax;
    private PortletType type;
    private String scroll;
    private String minSize;
    private String name;
 
    /**
     * PortletInfo
     * 
     * @param name String
     * @param urlMin String
     * @param urlMax String
     * @param type PortletType
     * @param scroll String
     * @param minSize String
     */
    public PortletInfo( String name, String urlMin, String urlMax, PortletType type, String scroll, String minSize )
    {
        this.urlMin = urlMin;
        this.urlMax = urlMax;
        this.type = type;
        this.scroll = scroll;
        this.minSize = minSize;
        this.name = name;
    }
 
    /**
     * getUrlMin
     * 
     * @return String
     */
    public String getUrlMin() 
    {
        return urlMin;
    }
 
    /**
     * getUrlMax
     * 
     * @return String
     */
    public String getUrlMax() 
    {
        return urlMax;
    }
 
    /**
     * getType
     * 
     * @return PortletType
     */
    public PortletType getType() 
    {
        return type;
    }
 
    /**
     * getScroll
     * 
     * @return String
     */
    public String getScroll() 
    {
        return scroll;
    }
 
    /**
     * getMinSize
     * 
     * @return String
     */
    public String getMinSize() 
    {
        return minSize;
    }
 
    /**
     * getName
     * 
     * @return String
     */
    public String getName() 
    {
        return name;
    }
 
    /**
     * toString
     * 
     * @return String
     */
    public String toString() 
    {
        return name;
    }
}