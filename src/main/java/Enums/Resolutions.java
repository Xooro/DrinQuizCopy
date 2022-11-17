/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author kkris
 */
public enum Resolutions {
    UHD("3840x2160p"),
    QHD("2560x1440p"),
    FHD("1920x1080p"),
    HD("1280x720p");

    private String resolution;

    public String getResolution() {
        return this.resolution;
    }

    private Resolutions(String resolution) {
        this.resolution = resolution;
    }
}
