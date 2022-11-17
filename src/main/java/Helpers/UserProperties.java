/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.awt.Dimension;

/**
 *
 * @author kkris
 */
public class UserProperties {
    public static UserProperties userPropertiesInstance;
    
    private Dimension playerResolution;
    private Dimension hostResolution;
    
    public UserProperties()
    {
        setDefaultResolutions();
    }
    
    private void setDefaultResolutions()
    {
        Dimension defaultDimension = new Dimension();
        defaultDimension.setSize(1280, 720);
        playerResolution = defaultDimension;
        hostResolution = defaultDimension;
    }
    
    public Dimension getPlayerResolution()
    {
        return playerResolution;
    }
    
    public Dimension getHostResolution()
    {
        return hostResolution;
    }
    
    public void setPlayerResolution(String newPlayerResolution)
    {
        playerResolution = getDimensionFromString(newPlayerResolution);
    }
    
    public void setHostResolution(String newHostResolution)
    {
        hostResolution = getDimensionFromString(newHostResolution);
    }
    
    private Dimension getDimensionFromString(String stringBlock)
    {
        String[] resolutions = stringBlock.split("x");
        Dimension dimension = new Dimension();
        dimension.setSize(Integer.parseInt(resolutions[0]),Integer.parseInt(resolutions[1]));
        return dimension;
    }
}
