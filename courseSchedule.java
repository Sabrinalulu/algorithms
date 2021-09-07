// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first 
// if you want to take course ai. Return true if you can finish all courses. Otherwise, return false.
// numCourses = 2, prerequisites = [[1,0]] | numCourses = 2, prerequisites = [[1,0],[0,1]]

import java.util.*;
public class courseSchedule {
    // build a graph and test if there is a cycle
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        // current course and next course
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

        for(int[] relation: prerequisites){
            if(courseDict.containsKey(relation[1])){
                courseDict.get(relation[1]).add(relation[0]);
            }else{ // the frist record
                List<Integer> next_course = new LinkedList<>();
                next_course.add(relation[0]);
                courseDict.put(relation[1], next_course);
            }
        }

        boolean[] checked = new boolean[numCourses]; // check if it is visted and tagged not cyclic
        boolean[] paths = new boolean[numCourses]; // check if it is visted (the same node)
        for(int curr=0; curr<numCourses; curr++){ // curr: current course (idx)
            if(isCyclic(curr, courseDict, checked, paths)){
                return false;
            }
        }

        return true;
    }

    public static boolean isCyclic(int curr, HashMap<Integer, List<Integer>> courseDict, boolean[] checked, boolean[] paths){
        if(checked[curr]) return false; // bottom case; if visited and not cyclic, return false;
        if(paths[curr]) return true; // if visited and cyclic
        if(!courseDict.containsKey(curr)) return false; // if it doesn't have relative courses

        paths[curr] = true; // record visited

        // loop through next course list
        boolean tmp = false;
        for(Integer next: courseDict.get(curr)){
            tmp = isCyclic(next, courseDict, checked, paths);
            if(tmp){
                break;
            }
        }

        checked[curr] = true; // mark the check complete
        paths[curr] = false; // after backtracking, remove the recorded node from paths
        return tmp; 
    }
    
    public static void main(String args[]){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        System.out.print(canFinish(numCourses, prerequisites));
    }
}
