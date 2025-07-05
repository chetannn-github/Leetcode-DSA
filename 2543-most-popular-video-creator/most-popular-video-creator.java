class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        int n = ids.length;
        HashMap<String,Triple> hm = new HashMap<>();

        for(int i=0; i<n; i++) {
            String creator = creators[i];
            String videoID = ids[i];
            int currViews = views[i];

            if(!hm.containsKey(creator)) {
                hm.put(creator,new Triple((long) currViews,videoID, currViews));
            }else {
                int maxViews = hm.get(creator).maxViews;
                long totalViews = (long) hm.get(creator).totalViews + currViews;
                String maxVideoID = hm.get(creator).mostViewedVideoID;

                if(maxViews < currViews) {
                    hm.put(creator , new Triple(totalViews, videoID, currViews));
                }else if(maxViews == currViews) {
                    String smallerID = (videoID.compareTo(maxVideoID) < 0) ? videoID : maxVideoID;

                    hm.put(creator , new Triple(totalViews, smallerID, currViews));
                }else hm.put(creator , new Triple(totalViews, maxVideoID, maxViews));
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->(
            (hm.get(b).totalViews - hm.get(a).totalViews > 0 ? 1 : -1)
        ));
        long maxTotalViews = 0L;
        for(String creator : hm.keySet()) {
            maxTotalViews = Math.max(maxTotalViews,hm.get(creator).totalViews);
        }

        for(String creator : hm.keySet()) {
            if(maxTotalViews == hm.get(creator).totalViews) {
                String mostViewedVideoID = hm.get(creator).mostViewedVideoID;
                result.add(List.of(creator,mostViewedVideoID));
            }
        }

        return result;
    }
}


class Triple {
    String mostViewedVideoID;
    long totalViews;
    int maxViews;

    Triple(long totalViews,String mostViewedVideoID ,int maxViews) {
        this.mostViewedVideoID = mostViewedVideoID;
        this.totalViews = totalViews;
        this.maxViews= maxViews;
    }
}