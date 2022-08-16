package org.vaadin.addons.de.f0rce.pickr.events;

import org.vaadin.addons.de.f0rce.pickr.Pickr;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;
import org.vaadin.addons.de.f0rce.pickr.util.PickrColor;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

/** @author David "F0rce" Dodlek */
@SuppressWarnings("serial")
@DomEvent("pickr-change")
public class PickrChangeEvent extends ComponentEvent<Pickr> {

  private PickrColor color;
  private PickrColorRepresentation colorRepresentation;

  public PickrChangeEvent(
      Pickr source,
      boolean fromClient,
      @EventData("event.detail.color.cmyk") String cmyk,
      @EventData("event.detail.color.hexa") String hexa,
      @EventData("event.detail.color.hsla") String hsla,
      @EventData("event.detail.color.hsva") String hsva,
      @EventData("event.detail.color.rgba") String rgba,
      @EventData("event.detail.color.colorRepresentation") String colorRepresentation) {
    super(source, fromClient);
    this.color = new PickrColor(cmyk, hexa, hsla, hsva, rgba);
    this.colorRepresentation =
        PickrColorRepresentation.findByColorRepresentation(colorRepresentation);
  }

  /**
   * Returns the changed (but not saved) {@link PickrColor}.
   *
   * @return {@link PickrColor}
   */
  public PickrColor getColor() {
    return this.color;
  }

  /**
   * Returns the current {@link PickrColorRepresentation} selected by the user.
   *
   * @return {@link PickrColorRepresentation}
   */
  public PickrColorRepresentation getColorRepresentation() {
    return this.colorRepresentation;
  }
}
