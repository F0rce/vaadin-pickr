package org.vaadin.addons.de.f0rce.pickr.interfaces;

import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;
import org.vaadin.addons.de.f0rce.pickr.util.PickrColor;

/**
 * Interface for events that will update/save the color internally.
 *
 * @author David "F0rce" Dodlek
 */
public interface IPickrColorChange {
  /**
   * Returns the current {@link PickrColor}.
   *
   * @return {@link PickrColor}
   */
  public PickrColor getColor();

  /**
   * Returns the currently used {@link PickrColorRepresentation}.
   *
   * @return {@link PickrColorRepresentation}
   */
  public PickrColorRepresentation getColorRepresentation();
}
