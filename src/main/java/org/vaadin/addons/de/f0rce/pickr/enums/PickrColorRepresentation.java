package org.vaadin.addons.de.f0rce.pickr.enums;

/** @author David "F0rce" Dodlek */
public enum PickrColorRepresentation {
  HEX("hex"),
  RGBA("rgba"),
  HSVA("hsva"),
  HSLA("hsla"),
  CMYK("cmyk");

  private String defaultRepresentation;

  private PickrColorRepresentation(String defaultRepresentation) {
    this.defaultRepresentation = defaultRepresentation;
  }

  /**
   * Returns the {@link String} representation of the enum.
   *
   * @return {@link String}
   */
  public String getColorRepresentation() {
    return this.defaultRepresentation;
  }

  /**
   * Find the enum by it's {@link String} representation.
   *
   * @param theme {@link String}
   * @return {@link PickrColorRepresentation}
   */
  public static PickrColorRepresentation findByColorRepresentation(String defaultRepresentation) {
    for (PickrColorRepresentation dr : values()) {
      if (dr.getColorRepresentation().equals(defaultRepresentation)) {
        return dr;
      }
    }
    return null;
  }
}
