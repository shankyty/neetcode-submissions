class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets ){
            map.computeIfAbsent(ticket.get(0),
                     __ -> new ArrayList<>())
                .add(ticket.get(1));
        }
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        LinkedList<String> itinerary = new LinkedList<>();
        itinerary.add("JFK");
        dfs("JFK", itinerary, map,  tickets.size() + 1);
        return itinerary;
    }

    boolean dfs(String src, 
                LinkedList<String> itinerary, 
                Map<String, List<String>> adj, 
                int len){
        if(itinerary.size() == len){
            return true;
        }
        if(!adj.containsKey(src)){
            return false;
        }
        
        List<String> neighbors = adj.get(src);
        for(int i = 0; i < neighbors.size(); i++){
            String v = neighbors.get(i);
            neighbors.remove(i);
            itinerary.add(v);
            if(dfs(v, itinerary, adj, len)){
                return true;
            }
            itinerary.removeLast();
            neighbors.add(i, v);
        }
        return false;
    }
}
