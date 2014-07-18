package testapplication.views.layout;

import org.juckula.JuckulaTemplate;


/**
 * That's the footer. 
 */
public class FooterHtml extends JuckulaTemplate {

  public FooterHtml html() {

    $("<footer>");
    $("<p>That's the funky footer, dude!</p>");
    $("</footer>");
    
    return this;

  }

}
