/**
 * Copyright (C) 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package testapplication.controllers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import ninja.Context;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.exceptions.BadRequestException;
import ninja.i18n.Messages;
import testapplication.conf.JuckulaI18n;
import testapplication.views.IndexPage;


public class JuckulaController {
    
    @Inject
    Messages messages;
    
    @Inject
    Provider<IndexPage> indexPageProvider;
    
    public Result index(Context context) {
        
        
        JuckulaI18n juckulaI18n = new JuckulaI18n(messages, context);
        
        return Results.ok().render(indexPageProvider.get().html(
                "a funky title", 
                "<IMG SRC=\"javascript:alert('XSS');\">",
                juckulaI18n));
    
    }
    
}
