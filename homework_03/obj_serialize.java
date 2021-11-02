package homework_03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class obj_serialize {
    static String path="homework_03/example/";
    
    static void save_func() throws Exception{
        Circle temp_circle1 = new Circle(10.0,1,1);
        Circle temp_circle2 = new Circle(20.0,5,0);
        System.out.println("obj1 created :"+temp_circle1);
        System.out.println("obj2 created :"+temp_circle2);
        FileOutputStream fos = new FileOutputStream(path+"circles.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(temp_circle1);
        oos.writeObject(temp_circle2);
        fos.close();
    }
    
    static void load_func() throws Exception{
        FileInputStream fis = new FileInputStream(path+"circles.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object temp_circle1=ois.readObject();
        Object temp_circle2=ois.readObject();
        temp_circle1=(Circle)temp_circle1;
        temp_circle2=(Circle)temp_circle2;
        System.out.println("obj1 loaded :"+temp_circle1);
        System.out.println("obj2 loaded :"+temp_circle2);
    }
}
 
class Circle implements Serializable{
    private class Point implements Serializable{
        int x;
        int y;
        Point(){}
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.x+","+this.y;
        }
    }
    double radius;
    Point center;
    Circle () {}  
    Circle (double a, int x, int y) {
       radius = a;
       center = new Point(x, y);
    }
    public String toString(){
       return getClass().getName() + "[" + center + " - " + radius + "]";
    }
}
