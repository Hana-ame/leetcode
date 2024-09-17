package com.example;

import java.util.HashMap;
import java.util.HashSet;

public class LC815 {
  public int numBusesToDestination(int[][] routes, int source, int target) {
      HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
      for (int i = 0; i<routes.length; i++) {
          for (int stations : routes[i]) {
              map.putIfAbsent(stations, new HashSet<>());
              map.get(stations).add(i);
          }
      }
      // bfs
      int i = 0;
      HashSet<Integer> visitedStations = new HashSet<>();
      HashSet<Integer> toVisitStations = new HashSet<>();

      visitedStations.add(source);
      toVisitStations.add(source);

      while (!toVisitStations.isEmpty()) {
          if (toVisitStations.contains(target)) {
              break;
          }
          i++;

          HashSet<Integer> nextStations = new HashSet<>();
          HashSet<Integer> nextRoutes = new HashSet<>();
          for (int station : toVisitStations) {                
              if (map.containsKey(station))
              for (int route : map.get(station)) {
                  if (nextRoutes.contains(route)) continue;
                  for(int stationInRoute : routes[route]) {
                      if (visitedStations.contains(stationInRoute)) continue;
                      nextStations.add(stationInRoute);
                      visitedStations.add(stationInRoute);
                  }
                  nextRoutes.add(route);
              }
          }
          toVisitStations = nextStations;
          
      }
      
      return toVisitStations.isEmpty()? -1: i;
  }

  public static void main(String[] args) {
      LC815 lc815 = new LC815();
      int[][] routes = {
          {1, 2, 7},
          {3, 6, 7}
      };
      int source = 1;
      int target = 6;

      int result = lc815.numBusesToDestination(routes, source, target);
      System.out.println("Number of buses to destination: " + result);  // 输出结果
    }

}