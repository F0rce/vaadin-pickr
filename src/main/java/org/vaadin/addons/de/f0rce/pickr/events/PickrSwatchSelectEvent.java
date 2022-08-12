package org.vaadin.addons.de.f0rce.pickr.events;

import org.vaadin.addons.de.f0rce.pickr.Pickr;
import org.vaadin.addons.de.f0rce.pickr.util.PickrColor;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

/** @author David "F0rce" Dodlek */
@SuppressWarnings("serial")
@DomEvent("pickr-swatchselect")
public class PickrSwatchSelectEvent extends ComponentEvent<Pickr> {

  private PickrColor color;

  public PickrSwatchSelectEvent(
      Pickr source,
      boolean fromClient,
      @EventData("event.detail.color.cmyk") String cmyk,
      @EventData("event.detail.color.hexa") String hexa,
      @EventData("event.detail.color.hsla") String hsla,
      @EventData("event.detail.color.hsva") String hsva,
      @EventData("event.detail.color.rgba") String rgba) {
    super(source, fromClient);
    this.color = new PickrColor(cmyk, hexa, hsla, hsva, rgba);
  }

  public PickrColor getColor() {
    return this.color;
  }
}
