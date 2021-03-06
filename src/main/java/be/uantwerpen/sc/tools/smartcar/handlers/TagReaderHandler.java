package be.uantwerpen.sc.tools.smartcar.handlers;

/**
 * Created by Thomas on 29/05/2016.
 * Handles virtual tag reading
 */
public class TagReaderHandler
{
    /**
     * Location handler, used for reading current location and getting the tag
     */
    private LocationHandler locationHandler;

    protected TagReaderHandler()
    {
        this.locationHandler = null;
    }

    public TagReaderHandler(LocationHandler locationHandler)
    {
        this.locationHandler = locationHandler;
    }

    /**
     * Virtual tag reader, gets tag from map based on current location
     * @return Some text + Tag string
     */
    public String readTag()
    {
        String tag = null;

        if(locationHandler.onNode())
        {
            tag = locationHandler.getNodeRFID(locationHandler.getCurrentLocation());

            if(tag != null) {
                if(tag.equals("")) {
                    //No tag linked to node
                    tag = null;
                }
            }
        }

        if(tag != null) {
            return "TAG DETECTION EVENT: " + tag;
        }
        else {
            return "TAG DETECTION EVENT: NONE";
        }
    }
}
