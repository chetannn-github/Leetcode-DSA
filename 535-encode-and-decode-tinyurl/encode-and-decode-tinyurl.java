public class Codec {
    private HashMap<String,String> hm= new HashMap<>() ;
    private int ID = 0;
    private String shortURLPrefix = new String("http://tinyurl.com/");
   

    public String encode(String longUrl) {
        ID++;
        hm.put(ID+"",longUrl);
        return shortURLPrefix + ID;
    }

    public String decode(String shortUrl) {
        String id = shortUrl.split("/")[3];
        return hm.get(id);
    }
}

