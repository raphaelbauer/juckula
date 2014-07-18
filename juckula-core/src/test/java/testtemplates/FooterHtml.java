package testtemplates;

import org.juckula.JuckulaTemplate;

/**
 * That's the footer. 
 */
public class FooterHtml extends JuckulaTemplate {

  public FooterHtml() {

    $("<footer>");
    $("<p>That's the funky footer, dude!</p>");
    $("</footer>");

  }

}
