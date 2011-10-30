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

import java.util.Collections;
import java.util.Set;

import org.jdom.Element;
import org.jdom.Namespace;

import com.sun.syndication.feed.module.Module;
import com.sun.syndication.io.ModuleGenerator;

public class GoogleMerchantModuleGenerator implements ModuleGenerator {

    private static final Namespace NAMESPACE = Namespace.getNamespace( GoogleMerchantModule.NS_PREFIX, GoogleMerchantModule.URI );
    private static final Set<Namespace> NAMESPACES = Collections.singleton(  NAMESPACE  );
    
    @Override
    public void generate( final Module module, final Element element ) {
        final GoogleMerchantModule myModule = (GoogleMerchantModule) module;
        addIfNotBlank( element, myModule.getCondition(), GoogleMerchantModule.CONDITION_TAG_NAME);
        addIfNotBlank( element, myModule.getImageLink(), GoogleMerchantModule.IMAGE_LINK_TAG_NAME);
        addIfNotBlank( element, myModule.getAvailability(), GoogleMerchantModule.AVAILABILITY_TAG_NAME);
        addIfNotNull( element, myModule.getId(), GoogleMerchantModule.ID_TAG_NAME);
        addIfNotNull( element, myModule.getPrice(), GoogleMerchantModule.PRICE_TAG_NAME);
    }

    private void addIfNotNull( final Element element, final Object value, final String tag ) {
        if ( value != null ) {
            add( element, String.valueOf( value ), tag );
        }
    }

    private void addIfNotBlank( final Element element, final String value, final String tag ) {
        if ( value != null && !"".equals( value.trim() ) )  {
            add( element, value, tag );
        }
    }

    private void add( final Element element, final String value, final String tag ) {
        final Element myElement = new Element(tag, NAMESPACE);
        myElement.setText(value);
        element.addContent(myElement);
    }

    @Override
    public String getNamespaceUri() {
        return GoogleMerchantModule.URI;
    }

    @Override
    public Set<?> getNamespaces() {
        return NAMESPACES;
    }

}
