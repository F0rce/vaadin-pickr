package org.vaadin.addons.de.f0rce.pickr.util;

/** @author David "F0rce" Dodlek */
public class PickrColor {

  private String cmyk;
  private String hexa;
  private String hsla;
  private String hsva;
  private String rgba;

  public PickrColor() {
    this.cmyk = null;
    this.hexa = null;
    this.hsla = null;
    this.hsva = null;
    this.rgba = null;
  }

  public PickrColor(String cmyk, String hexa, String hsla, String hsva, String rgba) {
    this.cmyk = cmyk;
    this.hexa = hexa;
    this.hsla = hsla;
    this.hsva = hsva;
    this.rgba = rgba;
  }

  public String getCMYK() {
    return this.cmyk;
  }

  public String getHEXA() {
    return this.hexa;
  }

  public String getHSLA() {
    return this.hsla;
  }

  public String getHSVA() {
    return this.hsva;
  }

  public String getRGBA() {
    return this.rgba;
  }

  public boolean isNull() {
    return this.cmyk == null
        && this.hexa == null
        && this.hsla == null
        && this.hsva == null
        && this.rgba == null;
  }
}
