public class Point{
    public int x;
    public int y;
        
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int caldistance(Point p1, Point p2){
        //System.out.println("left/right : " + p1.x + " " + p1.y);
        //System.out.println("standard : " + p2.x + " " + p2.y);
        
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Point left = new Point(3,1); // '*'
        Point right = new Point(3,3); // '#'
        
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                left.x = n/3;
                left.y = 1;
                answer += "L";
            }
            else if(n == 3 || n == 6 || n == 9){
                right.x = n/3 - 1;
                right.y = 3;
                answer += "R";
            }
            else {
                Point standard = new Point(n/3, 2);
                if(n == 0)
                    standard.x = 3;
                int leftdist = caldistance(left, standard);
                int rightdist = caldistance(right, standard);
                //System.out.println(leftdist + " " + rightdist);
                if(leftdist == rightdist){
                    String tmphand = hand.equals("left")? "L" : "R";
                    if(tmphand == "L"){
                        left.x = (n == 0)? 3 : n/3; 
                        left.y = 2;
                    }else{
                        right.x = (n == 0)? 3 : n/3;
                        right.y = 2;
                    }
                    answer += tmphand;
                }else{
                    String tmphand = leftdist < rightdist? "L" : "R";
                    if(tmphand == "L"){
                        left.x = (n == 0)? 3 : n/3;
                        left.y = 2;
                    }else{
                        right.x = (n == 0)? 3 : n/3;
                        right.y = 2;
                    }
                    answer += tmphand;
                }
            }
        }
        return answer;
    }
}