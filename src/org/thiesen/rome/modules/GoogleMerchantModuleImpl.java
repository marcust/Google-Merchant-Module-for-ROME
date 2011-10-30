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


import com.sun.syndication.feed.module.ModuleImpl;

public class GoogleMerchantModuleImpl extends ModuleImpl implements GoogleMerchantModule {

    private static final long serialVersionUID = 1L;

    private String _imageLink;
    private Number _price = Double.valueOf( 0 );
    private String _condition = "new";
    private String _availability = "in stock";
    private Long _id;


    public GoogleMerchantModuleImpl() {
        super( GoogleMerchantModule.class, URI );
    }

    @Override
    public String getImageLink() {
        return _imageLink;
    }

    @Override
    public void setImageLink( final String imageLink ) {
        _imageLink = imageLink;
    }

    @Override
    public Number getPrice() {
        return _price;
    }

    @Override
    public void setPrice( final Number price ) {
        _price = price;
    }

    @Override
    public String getCondition() {
        return _condition;
    }

    @Override
    public void setCondition( final String condition ) {
        _condition = condition;
    }

    @Override
    public Long getId() {
        return _id;
    }

    @Override
    public void setId( final Long id ) {
        _id = id;
    }

    @Override
    public void copyFrom( final Object other ) {
        if ( !(other instanceof GoogleMerchantModule) ) {
            throw new IllegalArgumentException( "Expected other to be of class " + GoogleMerchantModule.class.getSimpleName() + " but was " + other.getClass().getSimpleName() );
        }
        final GoogleMerchantModule otherModule = (GoogleMerchantModule) other;
        setImageLink( otherModule.getImageLink() );
        setPrice( otherModule.getPrice() );
        setCondition( otherModule.getCondition() );
        setId( otherModule.getId() );
        
    }

    @Override
    public Class<?> getInterface() {
        return GoogleMerchantModule.class;
    }

    @Override
    public String getAvailability() {
        return _availability;
    }

    @Override
    public void setAvailability( final String availability ) {
        _availability = availability;
    }

}
