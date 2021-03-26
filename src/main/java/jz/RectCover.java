package jz;

public class RectCover {
    public int rectCover(int target) {
        if(target==1)
            return 1;
        if (target==2)
            return 2;
        else return rectCover(target-2)+rectCover(target-1);
    }
}
