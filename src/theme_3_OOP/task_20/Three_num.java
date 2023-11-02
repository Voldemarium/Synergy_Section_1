package theme_3_OOP.task_20;

public class Three_num {
    int x;
    int y;
    int z;

    public int biggest() {
        if(this.x > this.y) {
            return Math.max(this.x, this.z);
        } else return Math.max(this.y, this.z);
    }
}
