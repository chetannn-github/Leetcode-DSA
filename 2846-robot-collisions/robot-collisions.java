class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dirns) {
        Stack<Quadruplet> st = new Stack<>();
        int n = dirns.length();
        List<Integer> result = new ArrayList<>();
        Quadruplet[] robots = new Quadruplet[n];

        for(int i=0; i<n; i++) {
            robots[i] = new Quadruplet(i,positions[i],healths[i],dirns.charAt(i));
        }

        Arrays.sort(robots,(a,b)->(a.pos-b.pos));

        for(int i=0; i<n; i++) {
            char dirn = robots[i].dirn;
            int health = robots[i].health;
            int pos = robots[i].pos;
            int actualIdx = robots[i].idx;

            if(dirn == 'L') {
                boolean myLoss = false;
                if(!st.isEmpty() && st.peek().dirn == 'R') {
                    while(!st.isEmpty() && st.peek().dirn == 'R' && !myLoss) {
                        Quadruplet prev = st.peek();
                        if(prev.health > health) {
                            st.peek().health--;
                            myLoss = true;
                        }else if(prev.health < health){
                            st.pop();
                            health--;
                            if(!st.isEmpty() && st.peek().dirn == 'R'){
                                myLoss = false;
                            } else {
                                st.push(new Quadruplet(actualIdx,pos,health,dirn));
                                myLoss = true;
                            }
                            
                        }else {
                            myLoss = true;
                            st.pop();
                        }
                    }
                }else {
                    st.push(new Quadruplet(actualIdx,pos,health,dirn));
                }
            }else {
                st.push(new Quadruplet(actualIdx,pos,health,dirn));
            }
        }


        List<Pair> remRobots = new ArrayList<>();

        while(!st.isEmpty()) {
           remRobots.add(new Pair(st.peek().idx,st.pop().health)) ;
        }

        Collections.sort(remRobots,(a,b)->(a.idx-b.idx));

        for(Pair curr : remRobots) {
            result.add(curr.health);
        }

        return result;


    }
}

class Quadruplet {
    int health,pos,idx;
    char dirn;
    Quadruplet(int idx, int pos,int health, char dirn) {
        this.pos = pos;
        this.idx = idx;
        this.health = health;
        this.dirn = dirn;
    }
}

class Pair {
    int health,idx;
    
    Pair(int idx,int health) {
        this.idx = idx;
        this.health = health;
    }
}