package HitCounterProblem;

public class HitCounter_Circular_Array implements IHitCounter{
    public int WINDOW_SIZE = 300;

    public int[] timeStamp = new int[WINDOW_SIZE];
    public int[] hits = new int[WINDOW_SIZE];

    public void hit(int currentTimeStamp){
        int index = currentTimeStamp % WINDOW_SIZE;

        // Means next window encountered, so discard previous hits
        // For example - window at 298th second and next window at
        // 598th second
        if(timeStamp[index] != currentTimeStamp)
        {
            timeStamp[index] = currentTimeStamp;
            hits[index] = 1;
        }
        else{
            hits[index]++;
        }
    }

    public int count(int currentTimeStamp)
    {
        int count = 0;
        for(int i = 0; i < WINDOW_SIZE; i++)
        {
            if(currentTimeStamp - timeStamp[i] < WINDOW_SIZE)
            {
                count += hits[i];
            }
        }
        return count;
    }
}
