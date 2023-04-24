import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Point charToPoint(Character[][] group, char c, String pattern){
        for(int i = 0; i < group.length; i++){
            for(int j = 0; j< group[i].length; j++){
                if(group[i][j] == c){
                    if(pattern.equals("right")) {
                        if(i==2) return new Point(j-1, i);
                        else return new Point(j, i);
                    }
                    else return new Point(-(group[i].length-j),i);
                }
            }
        }
        return null;
    }

    public static int calDistance(Point p1, Point p2){
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Character[][] leftGroup = {{'q','w','e','r','t'}, {'a','s','d','f','g'}, {'z','x','c','v',' '}};
        Character[][] rightGroup = {{'y','u','i','o','p'}, {'h','j','k','l',' '}, {'b','n','m',' ',' '}};

        String[] startInput = br.readLine().split(" ");

        Point leftIndex = charToPoint(leftGroup, startInput[0].charAt(0), "left");
        Point rightIndex = charToPoint(rightGroup, startInput[1].charAt(0), "right");

        String sentence = br.readLine();
        int time = 0;

        for(int i = 0; i < sentence.length(); i++){
            Point nowIndex =  charToPoint(leftGroup, sentence.charAt(i), "left");
            if(nowIndex == null){
                nowIndex = charToPoint(rightGroup, sentence.charAt(i), "right");
                time += calDistance(rightIndex, nowIndex) + 1;
                rightIndex = nowIndex;
            } else {
                time += calDistance(leftIndex, nowIndex) + 1;
                leftIndex = nowIndex;
            }
        }

        System.out.print(time);
    }

}
