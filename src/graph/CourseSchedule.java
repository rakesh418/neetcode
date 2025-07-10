package graph;

import java.util.*;

public class CourseSchedule {
    HashMap<Integer, List<Integer>> preRequisiteMap = new HashMap<>();
    HashSet<Integer> visit = new HashSet<>();

    public boolean canFinish(int[][] prerequisites, int numCourses) {
        for(int i=0; i<numCourses;i++){
            preRequisiteMap.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            preRequisiteMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        System.out.println(preRequisiteMap);
        for(int c=0; c<numCourses;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    public  boolean dfs(int c){
        if(visit.contains(c)){
            return false;
        }
        if(preRequisiteMap.get(c).isEmpty())
            return true;

        visit.add(c);
        List<Integer> preRequisiteCourses = preRequisiteMap.get(c);
        for(int i: preRequisiteCourses){
            if(!dfs(i)){
                return false;
            }else{
                visit.remove(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,1}, {1,0}, {0,2}};
        int numCourses = 3;
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(prerequisites, numCourses));
    }
}
