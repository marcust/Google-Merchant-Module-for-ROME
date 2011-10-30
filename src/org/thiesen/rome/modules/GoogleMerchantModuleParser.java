/*
 * The MIT License
 *
 * Copyright (c) 2011 Marcus Thiesen (marcus@thiesen.org)
 *
 * This file is part of Google Merchant Module for ROME.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.thiesen.rome.modules;

import org.jdom.Element;
import org.jdom.Namespace;

import com.sun.syndication.feed.module.Module;
import com.sun.syndication.io.ModuleParser;

public class GoogleMerchantModuleParser implements ModuleParser {

    @Override
    public String getNamespaceUri() {
        return GoogleMerchantModule.URI;
    }

    @Override
    public Module parse( final Element element ) {
        final Namespace myNamespace = Namespace.getNamespace(GoogleMerchantModule.URI);
        final GoogleMerchantModule myModule = new GoogleMerchantModuleImpl();
        if (element.getNamespace().equals(myNamespace)) {
            if (element.getName().equals( GoogleMerchantModule.CONDITION_TAG_NAME )) {
                myModule.setCondition( element.getTextTrim());
            }
            if (element.getName().equals( GoogleMerchantModule.ID_TAG_NAME )) {
                myModule.setId( Long.valueOf(element.getTextTrim()));
            }
            if (element.getName().equals( GoogleMerchantModule.IMAGE_LINK_TAG_NAME )) {
                myModule.setImageLink( element.getTextTrim() );
            }
            if (element.getName().equals( GoogleMerchantModule.PRICE_TAG_NAME )) {
                myModule.setPrice( Double.valueOf( element.getTextTrim() ) );
            }
            if (element.getName().equals( GoogleMerchantModule.AVAILABILITY_TAG_NAME )) {
                myModule.setAvailability( element.getTextTrim() );
            }

        }
        return myModule;

    }

}
