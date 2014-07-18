/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testapplication.conf;

import com.google.inject.Singleton;
import java.io.IOException;
import java.io.OutputStream;
import ninja.Context;
import ninja.Result;
import ninja.template.TemplateEngine;
import ninja.utils.ResponseStreams;
import org.juckula.JuckulaTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ra
 */
@Singleton
public class JuckulaNinja implements TemplateEngine {
    
    Logger logger = LoggerFactory.getLogger(JuckulaNinja.class);

    @Override
    public void invoke(Context context, Result result) {
        
        if (result.getRenderable() instanceof JuckulaTemplate) {
        
            ResponseStreams responseStreams = context.finalizeHeaders(result);
            
            JuckulaTemplate juckulaEngine = (JuckulaTemplate) result.getRenderable();
            
            try (OutputStream outputStream = responseStreams.getOutputStream()) {
                juckulaEngine.writeOut(outputStream);
            } catch (IOException ioException) {
                logger.error("somthing bad happended while writing out template", ioException);  
            }  
        }

    }

    @Override
    public String getSuffixOfTemplatingEngine() {
        return null;
    }

    @Override
    public String getContentType() {
       return "text/html";
    }
    
}
