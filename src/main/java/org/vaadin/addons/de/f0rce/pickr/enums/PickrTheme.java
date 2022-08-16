package org.vaadin.addons.de.f0rce.pickr.enums;

/** @author David "F0rce" Dodlek */
public enum PickrTheme {
  CLASSIC("classic"),
  MONOLITH("monolith"),
  NANO("nano");

  private String theme;

  private PickrTheme(String theme) {
    this.theme = theme;
  }

  /**
   * Returns the {@link String} representation of the enum.
   *
   * @return {@link String}
   */
  public String getTheme() {
    return this.theme;
  }

  /**
   * Find the enum by it's {@link String} representation.
   *
   * @param theme {@link String}
   * @return {@link PickrTheme}
   */
  public static PickrTheme findByTheme(String theme) {
    for (PickrTheme t : values()) {
      if (t.getTheme().equals(theme)) {
        return t;
      }
    }
    return null;
  }
}
