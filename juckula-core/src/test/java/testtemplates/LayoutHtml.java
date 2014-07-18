package testtemplates;

import org.juckula.JuckulaTemplate;

/**
 * Demo of a layout page that will be "inherited" by the template called
 * by the user.
 */
public class LayoutHtml extends JuckulaTemplate {

  public LayoutHtml(String title, JuckulaTemplate innerHtml) {
    
    HeaderHtml headerHtml = new HeaderHtml();
    FooterHtml footerHtml = new FooterHtml();

    $("<html>");
    $("<head><title>", x(title), "<title></head>");
    $("<body>");
    
    $(headerHtml);
    
    for (int i = 0; i < 10; i++) {
      $(new LinkTag("title" + i, "href" + i));
    }

    $(innerHtml);
    
    $(footerHtml);

    $("</body>");
    $("</html>");

  }

}
