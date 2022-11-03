package org.vaadin.addons.de.f0rce.pickr;

import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrPosition;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrI18N;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrI18N.PickrAria;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrI18N.PickrAria.PickrAriaButton;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrI18N.PickrButton;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrI18N.PickrUI;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrInteractions;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrSettings;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
public class TestView extends VerticalLayout {

  public TestView() {
    Button themeToggle =
        new Button(
            new Icon(VaadinIcon.SUN_O),
            click -> {
              ThemeList themeList = UI.getCurrent().getElement().getThemeList();

              if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
              } else {
                themeList.add(Lumo.DARK);
              }
            });

    PickrInteractions interactions = new PickrInteractions();
    interactions.setInput(true);
    interactions.setSave(true);
    interactions.setClear(true);
    interactions.setCancel(true);
    interactions.setHex(true);
    interactions.setRgba(true);
    interactions.setCmyk(true);
    interactions.setHsva(true);
    interactions.setHsla(true);

    PickrSettings ps = new PickrSettings();
    ps.setDefaultRepresentation(PickrColorRepresentation.HEX);
    ps.getComponents().setInteraction(interactions);
    ps.setPosition(PickrPosition.BOTTOM_START);
    //    ps.setLockOpacity(true);

    PickrI18N translation = new PickrI18N();
    translation.setUI(new PickrUI().setDialog("color picker dialog"));
    translation.setAria(
        new PickrAria()
            .setHue("hue selection slider")
            .setInput("color input field")
            .setOpacity("selection slider")
            .setPalette("color selection area")
            .setButton(
                new PickrAriaButton()
                    .setCancel("cancel and close")
                    .setClear("clear and close")
                    .setSave("save and close")));
    translation.setButton(
        new PickrButton()
            .setSave("Save")
            .setCancel("Cancel")
            .setClear("Clear")
            .setLastColor("use previous color")
            .setSwatch("color swatch")
            .setToggle("toggle color picker dialog"));

    ps.setI18N(translation);

    Pickr paperSlider = new Pickr(ps);
    this.setSizeFull();
    paperSlider.setOutputPrecision(0);

    paperSlider.setSwatches("red", "green", "magenta", "blue");

    this.setAlignItems(Alignment.CENTER);
    this.setJustifyContentMode(JustifyContentMode.CENTER);

    TextField tf = new TextField();
    tf.setSuffixComponent(paperSlider);

    paperSlider.addSaveListener(
        event -> {
          System.out.println(event.getColor().getRGBA());
          System.out.println(event.getColor().getCMYK());
          System.out.println(event.getColor().getHEXA());
          System.out.println(event.getColor().getHSLA());
          System.out.println(event.getColor().getHSVA());
        });

    paperSlider.addChangeListener(
        event -> {
          paperSlider.applyColor();
          tf.setValue(event.getColor().getHEXA());
        });

    Paragraph p = new Paragraph("(Tap me)");

    Button b = new Button("setColor(null)");
    b.addClickListener(
        event -> {
          paperSlider.setEnabled(true);
        });

    Dialog d = new Dialog();
    d.setHeight("300px");
    d.setWidth("700px");

    Button openDialog = new Button("Open Dialog");
    openDialog.addClickListener(
        event -> {
          d.open();
        });

    add(themeToggle, p, b, tf, openDialog, d);
  }
}
