class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> mailToID = new HashMap<>();
        HashMap<Integer,String> mailIDToParent = new HashMap<>();
        int ID = 0;

        for(List<String> acc : accounts) {
            String name = acc.get(0);
            for(int i=1; i<acc.size(); i++) {
                String mail = acc.get(i);
                if(!mailToID.containsKey(mail)) {
                    mailToID.put(mail,ID);
                    mailIDToParent.put(ID,name);
                    ID++;
                }   
            }
        }

        DSU dsu = new DSU(ID);

        for(List<String> acc : accounts) {
            String parentMail = acc.get(1);
            int parentMailID= mailToID.get(parentMail);

            for(int i=2; i<acc.size(); i++) {
                String currMail = acc.get(i);
                int currMailID =  mailToID.get(currMail);

                dsu.union(parentMailID, currMailID);
            
            }
        }


        HashMap<Integer,TreeSet<String>> parentToMails = new HashMap<>();

        for(List<String> acc : accounts) {
            for(int i=1; i<acc.size(); i++) {
                String currMail = acc.get(i);
                int currMailID =  mailToID.get(currMail);

                int parentMailID = dsu.find(currMailID);

                TreeSet<String> mails = parentToMails.getOrDefault(parentMailID,new TreeSet<>());
                mails.add(currMail);
                parentToMails.put(parentMailID,mails);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(Integer parentMailID : parentToMails.keySet()) {
            String parent = mailIDToParent.get(parentMailID);
            List<String> acc = new ArrayList<>();
            acc.add(parent);

            for(String mail :parentToMails.get(parentMailID)) acc.add(mail);
            result.add(acc);
        }

        
        return result;

    }

}

class DSU {
    int[] parent, rank;

    DSU(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i=0; i<size; i++) {
            parent[i] = i;
        } 
    }


    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return;

        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }else if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }


}