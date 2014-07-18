/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.juckula;

import com.google.common.html.HtmlEscapers;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JuckulaTemplate {

  private Optional<JuckulaTemplate> renderer = Optional.empty();

  private final StringBuilder stringBuilder = new StringBuilder();

  public void $(String... strings) {
    
    for (String string: strings) {
      stringBuilder.append(string);
    }
    
    stringBuilder.append("\n");

  }

  public void $(JuckulaTemplate renderer) {

    stringBuilder.append(renderer.writeOut());

  }

  public void $parent(JuckulaTemplate renderer) {

    this.renderer = Optional.of(renderer);

  }

  public String x(String unescapedString) {
    return HtmlEscapers.htmlEscaper().escape(unescapedString);
  }
  
  public String writeOut() {

    return renderer.orElse(this).stringBuilder.toString();

  }

  public void writeOut(OutputStream outputStream) {

    try {

      outputStream.write(renderer.orElse(this).stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
    
    } catch (IOException ioException) {
      throw new IllegalStateException("Could not find charset for UTF-8. That's totally strange. Stopping.", ioException);
    }

  }

}
