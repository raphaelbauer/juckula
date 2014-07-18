package testtemplates;

import org.juckula.JuckulaTemplate;

/**
 * Just a demo for a basic tag you might have in your application. Like a 
 * box on the left side. Or a href like so...
 * 
 * @author ra
 */
public class LinkTag extends JuckulaTemplate {
  
  public LinkTag(String name, String href) {
    
    $("<a href='", x(href), "'>", x(name), "</a>");
  
  }

}
