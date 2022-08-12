package org.vaadin.addons.de.f0rce.pickr.interfaces;

import org.vaadin.addons.de.f0rce.pickr.Pickr;

/** @author David "F0rce" Dodlek */
public interface IPickrVisibilityChange {
  /**
   * Returns if the {@link Pickr} dialog, where the color itself can be selected, is currently
   * visible.
   *
   * @return boolean
   */
  public boolean isVisible();
}
