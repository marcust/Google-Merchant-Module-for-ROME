#Google Merchant Module for ROME

If you want to feed your RSS Feed into Google Merchant, you need to specify additional fields,
otherwise Google Merchant will not import your feed. 

This module provides you with a ROME compatible way of adding those fields to your feed:

```java
        final SyndFeed feed = new SyndFeedImpl();
        feed.getModules().add( new GoogleMerchantModuleImpl() );

        final SyndEntry entry = new SyndEntryImpl();

        entry.setTitle( "Title" );

        final GoogleMerchantModule merchantData = new GoogleMerchantModuleImpl();
        merchantData.setImageLink( "SOME IMAGE URL" );
        
        entry.getModules().add( merchantData );
```

**Usually you must not send a special Id (setId()) because Merchant uses one of the unique Ids the Feed contains!**