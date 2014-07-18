package testapplication.views;

import com.google.inject.Inject;
import com.google.inject.Provider;
import testapplication.views.tags.LinkTag;
import testapplication.views.layout.LayoutHtml;
import org.juckula.JuckulaTemplate;
import testapplication.conf.JuckulaI18n;

/**
 * That's a main template a user would use.
 */
public class IndexPage extends JuckulaTemplate {
    
    @Inject
    Provider<LayoutHtml> layoutHtmlProvider;
    
    @Inject
    Provider<LinkTag> linkTagProvider;
    
    public IndexPage html(String title, String xssString, JuckulaI18n juckulaI18n) {

        $(x(xssString));
        $("<div class='main'><p>a message</p></div>");
        
        $("<p>... and tha's a i18n message, dude: ");
        $(juckulaI18n.getWithDefault("i18n.test", "defaultMessage"));
        $("</p>");
        
        $("<ul>");
        for (int i = 0; i < 10; i++) {
            $("<li>");
            $(linkTagProvider.get().html("title" + i, "href" + i));
            $("</li>");
        }
        $("</ul>");

        LayoutHtml layoutHtml = layoutHtmlProvider.get();
        layoutHtml.html(title, this);
        $parent(layoutHtml);
        
        return this;
        
    }

}
