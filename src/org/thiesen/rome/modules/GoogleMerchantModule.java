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

import com.sun.syndication.feed.module.Module;

public interface GoogleMerchantModule extends Module {

    public static final String PRICE_TAG_NAME = "price";
    public static final String ID_TAG_NAME = "id";
    public static final String IMAGE_LINK_TAG_NAME = "image_link";
    public static final String CONDITION_TAG_NAME = "condition";
    public static final String AVAILABILITY_TAG_NAME = "availability";

    public final static String NS_PREFIX = "g";
    public final static String URI = "http://base.google.com/ns/1.0";

    public String getImageLink();
    public void setImageLink( final String imageLink );

    public Number getPrice();
    public void setPrice( final Number price );

    public String getCondition();
    public void setCondition( final String condition );

    public Long getId();
    public void setId( final Long id );

    public void setAvailability( final String value );
    public String getAvailability();
    
}
