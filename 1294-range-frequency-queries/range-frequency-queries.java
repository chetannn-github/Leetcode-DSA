// class RangeFreqQuery {
//     int[] nums;
//     public RangeFreqQuery(int[] arr) {
//         nums = new int[arr.length];
//         for(int i=0; i < arr.length; i++) {
//             nums[i] = arr[i];
//         }
//     }
    
//     public int query(int left, int right, int value) {
//         int count = 0;
//         for(int i = left; i <= right; i++) {
//             if(nums[i] == value) count++;
//         }
//         return count;
//     }
// }
class RangeFreqQuery {
    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        List<Integer> indices = map.get(value);
        int size = indices.size();
        int l = lowerBound(indices, left,size);
        int r = upperBound(indices, right, size);
        if (r<l) return 0;
        return r -l +1;
    }

    private int lowerBound(List<Integer> list, int target, int size) {
        int s = 0, e = size -1;
        int ans = size;

        while(s<=e) {
            int mid = s + ((e-s)>>1);
            if(list.get(mid) > target) {
                e = mid-1;
                ans = mid;
            }else if(list.get(mid) < target) {
                s = mid+1;
            }else {
                return mid;
            }
        }

        return ans;
    }

    private int upperBound(List<Integer> list, int target, int size) {
        int s = 0, e = size -1;
        int ans = -1;

        while(s<=e) {
            int mid = s + ((e-s)>>1);
            if(list.get(mid) > target) {
                e = mid-1;
            }else if(list.get(mid) < target) {
                s = mid+1;
                ans = mid;
            }else {
                return mid ;
            }
        }

        return ans;
    }
}

