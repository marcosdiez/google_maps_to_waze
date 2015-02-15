package com.marcosdiez.googlemapstowaze;

/**
 * Created by Marcos on 15-Feb-15.
 */
public class ParseGoogleMapsUrl {
    final static String TAG = "Intel2GPS";
    public String getLongitude(){
        return longitude;
    }

    public String getLatitude(){
        return latitude;
    }

    private String longitude;
    private String latitude;

    public ParseGoogleMapsUrl(String googleMapsUrl){
        // http://www.ingress.com/intel?ll=-11.111111,-22.222222&z=12
        // https://www.ingress.com/intel?ll=-11.111111,-22.222222&z=12&pll=-33.11111,-44.222222

        // http://ingress.com/intel?ll=-11.111111,-22.222222&z=12
        // https://ingress.com/intel?ll=-11.111111,-22.222222&z=12&pll=-33.11111,-44.222222

        // verifyUrlSanity(intelUrl);

        int begin = getUrlBegin(googleMapsUrl);
        int end = getUrlEnd(googleMapsUrl, begin);

        String parsedUrl = googleMapsUrl.substring(begin, end);
        int coma = getComa(googleMapsUrl, parsedUrl);

        latitude  = parsedUrl.substring(0,coma);
        longitude = parsedUrl.substring(coma+1);
    }

    private int getComa(String intelUrl, String parsedUrl) {
        int coma = parsedUrl.indexOf(",");
        if(coma == -1){
            throw new IllegalArgumentException("Google URL must have a coma. You sent [" + intelUrl +"]");
        }
        return coma;
    }


    private int getUrlEnd(String intelUrl, int begin) {
        int end=intelUrl.indexOf("&", begin);
        if(end == -1 ){
            end = intelUrl.length();
        }
        return end;
    }

    private int getUrlBegin(String intelUrl) {
        int begin=-1;

        String[] locationTokenArray = { "?daddr=", "?q=loc:", "?geo:", "?q=", "&daddr=", "&q=loc:", "&geo:", "&q="  };
        String theLocationToken=null;
        for( String locationToken : locationTokenArray ){
            begin = intelUrl.indexOf(locationToken);
            if( begin != -1 ){
                theLocationToken=locationToken;
                break;
            }
        }
        if(begin==-1){
            throw new IllegalArgumentException("Google Maps URL must containain one of " + locationTokenArray.toString());
        }
        return begin + theLocationToken.length();
    }
}
