package testapplication.views.layout;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.juckula.JuckulaTemplate;

/**
 * Demo of a layout page that will be "inherited" by the template called by the
 * user.
 */
public class LayoutHtml extends JuckulaTemplate {

  @Inject
  Provider<HeaderHtml> headerHtmlProvider;

  @Inject
  Provider<FooterHtml> footerHtmlProvider;

  public void html(String title, JuckulaTemplate innerHtml) {

    $("<!DOCTYPE html>");
    $("<html>");
    $("<head><title>", x(title), "</title></head>");
    $("<body>");

    $(headerHtmlProvider.get().html());

    $(innerHtml);

    $(footerHtmlProvider.get().html());

    $("</body>");
    $("</html>");

  }

}
