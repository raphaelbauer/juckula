package testtemplates;

import org.juckula.JuckulaTemplate;

/**
 * A header of a webpage. Something that many webpages of your app would use...
 */
public class HeaderHtml extends JuckulaTemplate {

  public HeaderHtml() {

    $("<header>");
    $("<p>That's the funky header, dude!</p>");
    $("</header>");

  }

}
