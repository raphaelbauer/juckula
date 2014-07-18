/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.juckula;

import testtemplates.LandingPage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ra
 */
public class RenderTest {
    
    String expectedResult = "<html>\n" +
"<head><title>title<title></head>\n" +
"<body>\n" +
"<header>\n" +
"<p>That's the funky header, dude!</p>\n" +
"</header>\n" +
"<a href='href0'>title0</a>\n" +
"<a href='href1'>title1</a>\n" +
"<a href='href2'>title2</a>\n" +
"<a href='href3'>title3</a>\n" +
"<a href='href4'>title4</a>\n" +
"<a href='href5'>title5</a>\n" +
"<a href='href6'>title6</a>\n" +
"<a href='href7'>title7</a>\n" +
"<a href='href8'>title8</a>\n" +
"<a href='href9'>title9</a>\n" +
"<div class='main'><p>a message</p></div>\n" +
"<footer>\n" +
"<p>That's the funky footer, dude!</p>\n" +
"</footer>\n" +
"</body>\n" +
"</html>\n";
    
    public RenderTest() {
    }

    @Test
    public void testSomeMethod() throws Exception {
        
        LandingPage render = new LandingPage("title");
        
        System.out.println(render.writeOut());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        render.writeOut(byteArrayOutputStream);
        
        String string = new String( byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
        
        assertThat(string, CoreMatchers.equalTo(expectedResult));
        assertThat(render.writeOut(), CoreMatchers.equalTo(expectedResult));
        
    }
    
}
