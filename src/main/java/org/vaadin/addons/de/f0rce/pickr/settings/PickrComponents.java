package org.vaadin.addons.de.f0rce.pickr.settings;

public class PickrComponents {

  private boolean palette = true;
  private boolean preview = false;
  private boolean opacity = false;
  private boolean hue = true;

  private PickrInteractions interaction = new PickrInteractions();

  /**
   * Returns if the palette is visible.
   *
   * @return boolean
   */
  public boolean isPalette() {
    return palette;
  }

  /**
   * Defines if the palette itself should be visible.</br>Will be overwritten with true if preview,
   * opacity or hue are true.
   *
   * @param palette boolean
   */
  public void setPalette(boolean palette) {
    this.palette = palette;
  }

  /**
   * Returns if the comparison between previous state and new color is visible.
   *
   * @return boolean
   */
  public boolean isPreview() {
    return preview;
  }

  /**
   * Display comparison between previous state and new color.
   *
   * @param preview boolean
   */
  public void setPreview(boolean preview) {
    this.preview = preview;
  }

  /**
   * Returns if the opacity slider is visible.
   *
   * @return boolean
   */
  public boolean isOpacity() {
    return opacity;
  }

  /**
   * Display opacity slider.
   *
   * @param opacity boolean
   */
  public void setOpacity(boolean opacity) {
    this.opacity = opacity;
  }

  /**
   * Returns if the hue slider is visible.
   *
   * @return boolean
   */
  public boolean isHue() {
    return hue;
  }

  /**
   * Display hue slider.
   *
   * @param hue boolean
   */
  public void setHue(boolean hue) {
    this.hue = hue;
  }

  /**
   * Returns the current {@link PickrInteractions}.
   *
   * @return {@link PickrInteractions}
   */
  public PickrInteractions getInteraction() {
    return interaction;
  }

  /**
   * Show or hide components on the bottom interaction bar.
   *
   * @param interaction {@link PickrInteractions}
   */
  public void setInteraction(PickrInteractions interaction) {
    this.interaction = interaction;
  }
}
