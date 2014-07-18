package testtemplates;

import org.juckula.JuckulaTemplate;

/**
 * That's a main template a user would use.
 */
public class LandingPage extends JuckulaTemplate {
    
    public LandingPage(String title) {

        $("<div class='main'><p>a message</p></div>");
        
        LayoutHtml indexHtml = new LayoutHtml(title, this);
        $parent(indexHtml);
        
    }

}
