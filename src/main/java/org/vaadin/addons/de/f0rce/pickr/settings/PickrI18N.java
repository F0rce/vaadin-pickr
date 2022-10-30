package org.vaadin.addons.de.f0rce.pickr.settings;

import org.vaadin.addons.de.f0rce.pickr.Pickr;

/** The I18N helper file for the {@link Pickr} component. */
public class PickrI18N {
  private PickrUI ui;
  private PickrButton button;
  private PickrAria aria;

  public static class PickrUI {
    private String dialog;

    public String getDialog() {
      return this.dialog;
    }

    public PickrUI setDialog(String dialog) {
      this.dialog = dialog;
      return this;
    }
  }

  public static class PickrButton {
    private String toggle;
    private String swatch;
    private String last__color;
    private String save;
    private String cancel;
    private String clear;

    public String getToggle() {
      return this.toggle;
    }

    public PickrButton setToggle(String toggle) {
      this.toggle = toggle;
      return this;
    }

    public String getSwatch() {
      return this.swatch;
    }

    public PickrButton setSwatch(String swatch) {
      this.swatch = swatch;
      return this;
    }

    public String getLastColor() {
      return this.last__color;
    }

    public PickrButton setLastColor(String lastColor) {
      this.last__color = lastColor;
      return this;
    }

    public String getSave() {
      return this.save;
    }

    public PickrButton setSave(String save) {
      this.save = save;
      return this;
    }

    public String getCancel() {
      return this.cancel;
    }

    public PickrButton setCancel(String cancel) {
      this.cancel = cancel;
      return this;
    }

    public String getClear() {
      return this.clear;
    }

    public PickrButton setClear(String clear) {
      this.clear = clear;
      return this;
    }
  }

  public static class PickrAria {
    private PickrAriaButton ariaButton;
    private String input;
    private String palette;
    private String hue;
    private String opacity;

    public PickrAriaButton getButton() {
      return this.ariaButton;
    }

    public PickrAria setButton(PickrAriaButton ariaButton) {
      this.ariaButton = ariaButton;
      return this;
    }

    public String getInput() {
      return this.input;
    }

    public PickrAria setInput(String input) {
      this.input = input;
      return this;
    }

    public String getPalette() {
      return this.palette;
    }

    public PickrAria setPalette(String palette) {
      this.palette = palette;
      return this;
    }

    public String getHue() {
      return this.hue;
    }

    public PickrAria setHue(String hue) {
      this.hue = hue;
      return this;
    }

    public String getOpacity() {
      return this.opacity;
    }

    public PickrAria setOpacity(String opacity) {
      this.opacity = opacity;
      return this;
    }

    public static class PickrAriaButton {
      private String save;
      private String cancel;
      private String clear;

      public String getSave() {
        return this.save;
      }

      public PickrAriaButton setSave(String save) {
        this.save = save;
        return this;
      }

      public String getCancel() {
        return this.cancel;
      }

      public PickrAriaButton setCancel(String cancel) {
        this.cancel = cancel;
        return this;
      }

      public String getClear() {
        return this.clear;
      }

      public PickrAriaButton setClear(String clear) {
        this.clear = clear;
        return this;
      }
    }
  }

  public PickrUI getUI() {
    return this.ui;
  }

  public PickrI18N setUI(PickrUI ui) {
    this.ui = ui;
    return this;
  }

  public PickrButton getButton() {
    return this.button;
  }

  public PickrI18N setButton(PickrButton button) {
    this.button = button;
    return this;
  }

  public PickrAria getAria() {
    return this.aria;
  }

  public PickrI18N setAria(PickrAria aria) {
    this.aria = aria;
    return this;
  }
}
