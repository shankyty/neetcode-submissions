/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> events = new ArrayList<>();
        for(Interval interval : intervals){
            events.add(new int[]{interval.start, 1});
            events.add(new int[]{interval.end, -1});
        }
        Collections.sort(events, (a,b) -> {
            int comp = Integer.compare(a[0],b[0]);
            if(comp == 0){
                return Integer.compare(a[1],b[1]);
            }
            return comp;
        });
        int rooms = 0;
        int maxRooms = 0;
        for(int[] event : events){
            rooms += event[1];
            if(rooms > maxRooms){
                maxRooms = rooms;
            }
        }
        return maxRooms;
    }
}
